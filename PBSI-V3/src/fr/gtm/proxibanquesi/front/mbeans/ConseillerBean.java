package fr.gtm.proxibanquesi.front.mbeans;

import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import fr.gtm.proxibanquesi.domaine.Client;
import fr.gtm.proxibanquesi.domaine.Conseiller;

@ManagedBean(name="conseiller")
public class ConseillerBean {
	
	private String login;
	private String mdp;
	private String nom;
	private String prenom;
	private int idcons;
	private ArrayList<Client> listeClients;
	
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
	
	public String validerLogin() {
		Conseiller cons = new Conseiller();
		cons.setLogin(login);
		cons.setMdp(mdp);

		// TODO: verifier l'existence en base
		// Si invalide retourner page existante et message d'erreur (FacesMessage)
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Message");
		System.out.println(message);
		FacesContext.getCurrentInstance().addMessage("login-form", message);
		return "login-page.xhtml";
		// Sinon mettre à jour le Managed Bean avec les infos Conseiller
	}

}
