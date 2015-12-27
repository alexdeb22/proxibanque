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

import fr.gtm.proxibanquesi.domaine.Client;
import fr.gtm.proxibanquesi.exceptions.LigneExistanteException;
import fr.gtm.proxibanquesi.service.IClientService;

@ManagedBean(name="creationClient")
@ViewScoped
public class CreateClientBean implements Serializable {

	// Serial ID
	private static final long serialVersionUID = 1L;
	
	// Client to create
	private Client createdClient;
	
	// Conseiller id
	@ManagedProperty(value="#{authBean.conseiller.idcons}")
	private int idcons;
	
	// Service injection
	@Inject
	IClientService serv;
	
	// Constructor with attributes initialization
	public CreateClientBean() {
		createdClient = new Client();
		}
	
	// Bean lifecycle log
	@PostConstruct
	public void creationBean() {
		System.out.println("Création CreateClientBean, id conseiller: " + idcons);
	}
	@PreDestroy
	public void destructionBean() {
		System.out.println("Destruction CreateClientBean");
	}
	
	// Creation client
	public void creerClient() {
		System.out.println(createdClient);
		try {
			createdClient.setCons(idcons);
			serv.createClient(createdClient);
			FacesMessage message = new FacesMessage("Client créé avec succès.");
			FacesContext.getCurrentInstance().addMessage(null, message);
		} catch (LigneExistanteException e) {
			FacesMessage message = new FacesMessage("Ce client existe déja.");
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
	}
	
	// Getters & Setters
	public Client getCreatedClient() {
		return createdClient;
	}
	public void setCreatedClient(Client createdClient) {
		this.createdClient = createdClient;
	}

	public int getIdcons() {
		return idcons;
	}

	public void setIdcons(int idcons) {
		this.idcons = idcons;
	}

}
