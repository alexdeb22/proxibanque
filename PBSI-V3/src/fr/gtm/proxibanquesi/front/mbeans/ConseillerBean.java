package fr.gtm.proxibanquesi.front.mbeans;

import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseListener;
import javax.inject.Inject;

import fr.gtm.proxibanquesi.domaine.Client;
import fr.gtm.proxibanquesi.domaine.Conseiller;
import fr.gtm.proxibanquesi.exceptions.LigneInexistanteException;
import fr.gtm.proxibanquesi.service.IConseillerService;

@ManagedBean(name = "conseiller")
@SessionScoped
public class ConseillerBean {

	@Inject
	IConseillerService serv;

	
	private String login;
	private String mdp;
	private String nom;
	private String prenom;
	private int idcons;
	private ArrayList<Client> listeClients = new ArrayList<Client>();

	public ConseillerBean() {
		super();
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public int getIdcons() {
		return idcons;
	}

	public void setIdcons(int idcons) {
		this.idcons = idcons;
	}

	public ArrayList<Client> getListeClients() {
		return listeClients;
	}

	public void setListeClients(ArrayList<Client> listeClients) {
		this.listeClients = listeClients;
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
		return "ConseillerBean [login=" + login + ", mdp=" + mdp + "]";
	}

	/**
	 * Valdiation du login mdp.
	 * @return
	 */
	public String validerLogin() {
		// Revoir cycle de vie, normalement inutile?
		if(null == login | null == mdp) {
			return null;
		}
		// Creation de l'objet conseiller
		Conseiller cons = new Conseiller();
		cons.setLogin(login);
		cons.setMdp(mdp);
		try {

			// Si valide mettre à jour le Managed Bean avec les infos Conseiller
			cons = serv.checkUser(cons);
			nom = cons.getNom();
			prenom = cons.getPrenom();
			idcons = cons.getIdcons();
			// Récupérer la liste des clients
			listeClients = serv.getListeClients(cons);
			// Debug
			System.out.println(listeClients);
			return "user-page";
		} catch (LigneInexistanteException e) {
			// Si invalide retourner page existante et message d'erreur
			// (FacesMessage)
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Login/Mot de passe invalides",
					"Veuillez réessayer");
			FacesContext.getCurrentInstance().addMessage("login-form", message);
			return null;
		}

	}

}
