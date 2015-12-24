package fr.gtm.proxibanquesi.front.mbeans;

import java.sql.Date;

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
import fr.gtm.proxibanquesi.exceptions.LigneInexistanteException;
import fr.gtm.proxibanquesi.service.ICompteService;

@ManagedBean(name = "compte")
@ViewScoped
public class CompteBean {

	@Inject
	ICompteService serv;
	
	@ManagedProperty(value = "#{client}")
	private ClientBean client;
	
	private int numCompte;
	private double solde;
	private Date dateOuverture;

	private String typeCompte;
	private double autorisationDecouvert = 1000;
	private double tauxRemuneration = 0.03;
	
	public CompteBean() {
		super();
	}

	public ClientBean getClient() {
		return client;
	}

	public void setClient(ClientBean client) {
		this.client = client;
	}

	public int getNumCompte() {
		return numCompte;
	}

	public void setNumCompte(int numCompte) {
		this.numCompte = numCompte;
	}

	public double getSolde() {
		return solde;
	}

	public void setSolde(double solde) {
		this.solde = solde;
	}

	public Date getDateOuverture() {
		return dateOuverture;
	}

	public void setDateOuverture(Date dateOuverture) {
		this.dateOuverture = dateOuverture;
	}

	public double getAutorisationDecouvert() {
		return autorisationDecouvert;
	}

	public void setAutorisationDecouvert(double autorisationDecouvert) {
		this.autorisationDecouvert = autorisationDecouvert;
	}

	public double getTauxRemuneration() {
		return tauxRemuneration;
	}

	public void setTauxRemuneration(double tauxRemuneration) {
		this.tauxRemuneration = tauxRemuneration;
	}
	
	public String getTypeCompte() {
		return typeCompte;
	}

	public void setTypeCompte(String typeCompte) {
		this.typeCompte = typeCompte;
	}

	@PostConstruct
	public void creationBean() {
		System.out.println("Creation du bean");
	}

	@PreDestroy
	public void finBean() {
		System.out.println("Fin du bean: " + this.toString());
	}

	@Override
	public String toString() {
		return "CompteBean [numCompte=" + numCompte + ", solde=" + solde + ", dateOuverture=" + dateOuverture
				+ ", idcli="+ client.getId() + ", autorisationDecouvert=" + autorisationDecouvert + ", tauxRemuneration="
				+ tauxRemuneration + "]";
	}
	
	
	/**
	 * Création de compte
	 * @return
	 */
	public String creerCompte() {
		// Revoir cycle de vie, normalement inutile?
		if(null == typeCompte) {
			return null;
		}
		// Creation de l'objet Compte
		Compte compte = null;
		if (typeCompte.equals("Courant")) {
			compte = new CompteCourant();
			((CompteCourant) compte).setAutorisationDecouvert(autorisationDecouvert);
		} else if (typeCompte.equals("Epargne")) {
			compte = new CompteEpargne();
			((CompteEpargne) compte).setTauxRemuneration(tauxRemuneration);
		}
		compte.setIdcli(client.getId());
		compte.setSolde(solde);
		
		//Récupération info compte créé
		compte = serv.creerCompte(compte);
		setNumCompte(compte.getNumCompte());
		setSolde(compte.getSolde());
		setDateOuverture(compte.getDateOuverture());
		if (compte instanceof CompteCourant) {
			setAutorisationDecouvert(((CompteCourant) compte).getAutorisationDecouvert());
			setTauxRemuneration(0);
			setTypeCompte("Courant");
		} else if (compte instanceof CompteEpargne) {
			setTauxRemuneration(((CompteEpargne) compte).getTauxRemuneration());
			setAutorisationDecouvert(0);
			setTypeCompte("Epargne");
		}
		
			//TODO set page xhtml de retour
			return "";
	}
	
	/**
	 * Suppression de compte
	 * @return
	 */
	public String supprimerCompte() {
		// Revoir cycle de vie, normalement inutile?
		if(0 == numCompte) {
			return null;
		}
		// Creation de l'objet Compte
		Compte compte = null;
		if (typeCompte.equals("Courant")) {
			compte = new CompteCourant();
			((CompteCourant) compte).setAutorisationDecouvert(autorisationDecouvert);
		} else if (typeCompte.equals("Epargne")) {
			compte = new CompteEpargne();
			((CompteEpargne) compte).setTauxRemuneration(tauxRemuneration);
		}
		compte.setIdcli(client.getId());
		
		//Supression compte
		try {
			serv.supprimerCompte(compte);
		} catch (LigneInexistanteException e) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Compte inexistant",
					"Veuillez réessayer");
			FacesContext.getCurrentInstance().addMessage("delete-compte-form", message);
		}
		//Remise à zéro des champs du bean (inutile?)
		setNumCompte(0);
		setSolde(0);
		setDateOuverture(null);
		setAutorisationDecouvert(0);
		setTauxRemuneration(0);
		setTypeCompte(null);
		
		
			//TODO set page xhtml de retour
			return "";
	}
	
	/**
	 * Lecture de compte
	 * @return
	 */
	public String consulterCompte() {
		// Revoir cycle de vie, normalement inutile?
		if(null == typeCompte) {
			return null;
		}
		// Creation de l'objet Compte
		Compte compte = null;
		if (typeCompte.equals("Courant")) {
			compte = new CompteCourant();
			((CompteCourant) compte).setAutorisationDecouvert(autorisationDecouvert);
		} else if (typeCompte.equals("Epargne")) {
			compte = new CompteEpargne();
			((CompteEpargne) compte).setTauxRemuneration(tauxRemuneration);
		}
		compte.setIdcli(client.getId());
		compte.setSolde(solde);
		
		//Récupération info compte créé
		compte = serv.creerCompte(compte);
		setNumCompte(compte.getNumCompte());
		setSolde(compte.getSolde());
		setDateOuverture(compte.getDateOuverture());
		if (compte instanceof CompteCourant) {
			setAutorisationDecouvert(((CompteCourant) compte).getAutorisationDecouvert());
			setTauxRemuneration(0);
			setTypeCompte("Courant");
		} else if (compte instanceof CompteEpargne) {
			setTauxRemuneration(((CompteEpargne) compte).getTauxRemuneration());
			setAutorisationDecouvert(0);
			setTypeCompte("Epargne");
		}
		
			//TODO set page xhtml de retour
			return "";
	}
}
