package fr.gtm.proxibanquesi.front.mbeans;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import fr.gtm.proxibanquesi.domaine.Client;
import fr.gtm.proxibanquesi.service.IClientService;

@ManagedBean(name="clientBean")
@ViewScoped
public class SelectClientBean implements Serializable {

	// Serial ID
	private static final long serialVersionUID = 1L;

	// Bean attributes
	private Client selectedClient;
	
	// Service injection
//	@Inject
//	IClientService serv;
	
	// Constructor
	public SelectClientBean() {
	}

	// Bean lifecycle log
	@PostConstruct
	public void creationBean() {
		System.out.println("Création SelectClientBean: " + selectedClient);
	}
	@PreDestroy
	public void destructionBean() {
		System.out.println("Destruction SelectClientBean");
	}
	
	// Getters & Setters
	public Client getSelectedClient() {
		return selectedClient;
	}
	public void setSelectedClient(Client selectedClient) {
		this.selectedClient = selectedClient;
		System.out.println(selectedClient);
	}
}
