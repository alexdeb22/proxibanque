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

@ManagedBean(name="authBean")
@SessionScoped
public class AuthentificationBean implements Serializable {

	// Serial ID
	private static final long serialVersionUID = 1L;

	// Bean attributes
	private Conseiller conseiller;
	private ArrayList<Client> listeClients;
	
	// Service injection
	@Inject
	IConseillerService serv;
	
	// Constructor with attributes initialization
	public AuthentificationBean() {
		conseiller = new Conseiller();
		listeClients = new ArrayList<Client>();
	}
	
	// Bean lifecycle log
	@PostConstruct
	public void creationBean() {
		System.out.println("Création AuthentificationBean");
	}
	@PreDestroy
	public void destructionBean() {
		System.out.println("Destruction AuthentificationBean");
	}
	
	// Phases log
	public void afterPhase(PhaseEvent event) {
		System.out.println(conseiller);
		System.out.println(listeClients);
	}
	
	// Authentification method (login-form)
	public void authentifier() {
		try {
			conseiller = serv.checkUser(conseiller);
			listeClients = serv.getListeClients(conseiller);
			FacesMessage message = new FacesMessage("Authentification réussie.");
			FacesContext.getCurrentInstance().addMessage(null, message);
		} catch (LigneInexistanteException e) {
			FacesMessage message = new FacesMessage("Authentification échouée. Veuillez réessayer");
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
	}

	
	// Getters & Setters
	public Conseiller getConseiller() {
		return conseiller;
	}
//	public void setConseiller(Conseiller conseiller) {
//		this.conseiller = conseiller;
//	}
	public ArrayList<Client> getListeClients() {
		return listeClients;
	}
//	public void setListeClients(ArrayList<Client> listeClients) {
//		this.listeClients = listeClients;
//	}
	
}
