package fr.gtm.proxibanquesi.front.mbeans;

import java.io.Serializable;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.inject.Inject;

import fr.gtm.proxibanquesi.domaine.Client;
import fr.gtm.proxibanquesi.domaine.Conseiller;
import fr.gtm.proxibanquesi.exceptions.LigneInexistanteException;
import fr.gtm.proxibanquesi.service.IConseillerService;

/**
 * Managed Bean chargé de l'authentification du conseiller. Permet d'accéder aux
 * clients du conseiller authentifié. Ce bean possède un scope de type session.
 * 
 * @author Alex
 *
 */
@ManagedBean(name = "authBean")
@SessionScoped
public class AuthentificationBean implements Serializable {

	/**
	 * Serial ID
	 */
	private static final long serialVersionUID = 1L;

	// Bean attributes
	/**
	 * Objet Conseiller correspondant au conseiller authentifié. Permet
	 * d'accéder aux informations concernant ce conseiller.
	 */
	private Conseiller conseiller;
	/**
	 * Liste des clients du conseillé authentifié.
	 */
	private ArrayList<Client> listeClients;

	// Service injection
	/**
	 * EJB permettant de vérifier l'authentification du conseiller.
	 */
	@Inject
	IConseillerService serv;

	/**
	 * Constructeur initialisant les propriétés du bean
	 */
	public AuthentificationBean() {
		conseiller = new Conseiller();
		listeClients = new ArrayList<Client>();
	}

	// // Bean lifecycle log
	// @PostConstruct
	// public void creationBean() {
	// System.out.println("Création AuthentificationBean");
	// }
	// @PreDestroy
	// public void destructionBean() {
	// System.out.println("Destruction AuthentificationBean");
	// }

	// Phases log
	// public void afterPhase(PhaseEvent event) {
	// System.out.println(conseiller);
	// System.out.println(listeClients);
	// }

	// Authentification method (login-form)
	/**
	 * Méthode qui permet d'authentifier le conseiller à partir du login et mot
	 * de passe. Charge les infos du conseiller et sa liste de clients dans le
	 * bean. Charge un message indicatif dans le contexte de la vue en fonction
	 * du résultat.
	 * 
	 * @return Null en cas d'échec de l'authentification, sinon le nom de la
	 *         page utilisateur.
	 */
	public String authentifier() {
		try {
			conseiller = serv.checkUser(conseiller);
			listeClients = serv.getListeClients(conseiller);
			FacesMessage message = new FacesMessage("Authentification réussie.");
			FacesContext.getCurrentInstance().addMessage(null, message);
			return "user-page";
		} catch (LigneInexistanteException e) {
			FacesMessage message = new FacesMessage("Authentification échouée. Veuillez réessayer");
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
		return null;
	}

	// Getters & Setters
	/**
	 * Getter de la propriété Conseiller
	 * 
	 * @return La propriété Conseiller
	 */
	public Conseiller getConseiller() {
		return conseiller;
	}

	// public void setConseiller(Conseiller conseiller) {
	// this.conseiller = conseiller;
	// }
	/**
	 * Getter de la propriété listeClients
	 * 
	 * @return La propriété listeClients
	 */
	public ArrayList<Client> getListeClients() {
		listeClients = serv.getListeClients(conseiller);
		return listeClients;
	}
	// public void setListeClients(ArrayList<Client> listeClients) {
	// this.listeClients = listeClients;
	// }

}
