package fr.gtm.proxibanquesi.front.mbeans;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import fr.gtm.proxibanquesi.domaine.Compte;
import fr.gtm.proxibanquesi.domaine.CompteCourant;
import fr.gtm.proxibanquesi.domaine.CompteEpargne;
import fr.gtm.proxibanquesi.exceptions.DaoException;
import fr.gtm.proxibanquesi.service.ICompteService;

/**
 * Bean associé à la création d'un compte bancaire.
 * 
 * @author Alex
 *
 */
@ManagedBean(name = "createCompteBean")
public class CreateCompteBean implements Serializable {

	// Serial ID
	/**
	 * Serial ID.
	 */
	private static final long serialVersionUID = 1L;

	// Compte to create
	/**
	 * L'objet Compte stockant les informations du compte à créer.
	 */
	private Compte createdCompte;
	/**
	 * Le type du compte (courant ou epargne) Par défaut: courant.
	 */
	@ManagedProperty(value = "courant")
	private String type;

	// Client id
	/**
	 * L'identifiant du client pour qui le compte sera créé.
	 */
	@ManagedProperty(value = "#{clientBean.selectedClient.id}")
	private int idclient;

	// Service injection
	/**
	 * EJB chargé de créer le compte.
	 */
	@Inject
	ICompteService serv;

	// Constructor
	/**
	 * Constructeur initialisant la propriété createdCompte.
	 */
	public CreateCompteBean() {
		createdCompte = new CompteCourant();
	}

	// Bean lifecycle log
	// @PostConstruct
	// public void creationBean() {
	// System.out.println("Création CreateCompteBean, id client: " + idclient);
	//
	// }
	//
	// @PreDestroy
	// public void destructionBean() {
	// System.out.println("Destruction CreateCompteBean");
	// }

	// Creation du compte
	/**
	 * Méthode appelé lors de la soumission du formulaire de création de compte.
	 * Créé le compte en base de donnée et charge un message indiquant le
	 * résultat.
	 */
	public void creerCompte() {
		try {
			createdCompte.setIdcli(idclient);
			if (type.equals("courant")) {
				serv.creerCompte((CompteCourant) createdCompte);
				FacesMessage message = new FacesMessage("Compte courant créé avec succès");
				FacesContext.getCurrentInstance().addMessage(null, message);
			} else if (type.equals("epargne")) {
				CompteEpargne epargne = new CompteEpargne();
				epargne.setIdcli(idclient);
				epargne.setSolde(createdCompte.getSolde());
				serv.creerCompte(epargne);
				FacesMessage message = new FacesMessage("Compte épargne créé avec succès");
				FacesContext.getCurrentInstance().addMessage(null, message);
			}
		} catch (DaoException e) {
			FacesMessage message = new FacesMessage("Problème lors de la création");
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
	}

	/**
	 * Getter de la propriété createdCompte.
	 * 
	 * @return La propriété createdCompte.
	 */
	public Compte getCreatedCompte() {
		return createdCompte;
	}

	/**
	 * Setter de la propriété created Compte
	 * 
	 * @param createdCompte
	 *            Le compte à affecter à la propriété.
	 */
	public void setCreatedCompte(Compte createdCompte) {
		this.createdCompte = createdCompte;
	}

	/**
	 * Getter de la propriété type.
	 * 
	 * @return La propriété type.
	 */
	public String getType() {
		return type;
	}

	/**
	 * Setter de la propriété type
	 * 
	 * @param type
	 *            La chaine de caractère a associer à la propriété.
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * Getter de la propriété idclient.
	 * 
	 * @return La propriété idclient.
	 */
	public int getIdclient() {
		return idclient;
	}

	/**
	 * Setter de la propriété idclient.
	 * 
	 * @param idclient
	 *            L'entier à affecter à la propriété.
	 */
	public void setIdclient(int idclient) {
		this.idclient = idclient;
	}

}
