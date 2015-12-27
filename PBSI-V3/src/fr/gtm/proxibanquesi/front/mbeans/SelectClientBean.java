package fr.gtm.proxibanquesi.front.mbeans;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import fr.gtm.proxibanquesi.domaine.Client;
import fr.gtm.proxibanquesi.service.IClientService;

/**
 * Managed Bean chargé de la sélection d'un client dans la liste.
 * 
 * @author Alex
 *
 */
@ManagedBean(name = "clientBean")
@ViewScoped
public class SelectClientBean implements Serializable {

	// Serial ID
	/**
	 * Serial ID.
	 */
	private static final long serialVersionUID = 1L;

	// Bean attributes
	/**
	 * Propriété stockant le client sélectionné.
	 */
	private Client selectedClient;

	// Service injection
	// @Inject
	// IClientService serv;

	// Constructor
	//
	// public SelectClientBean() {
	// }

	// Bean lifecycle log
	// @PostConstruct
	// public void creationBean() {
	// System.out.println("Création SelectClientBean: " + selectedClient);
	// }
	// @PreDestroy
	// public void destructionBean() {
	// System.out.println("Destruction SelectClientBean");
	// }

	// Getters & Setters
	/**
	 * Getter de la propriété selectedClient.
	 * 
	 * @return La propriété selectedClient.
	 */
	public Client getSelectedClient() {
		return selectedClient;
	}

	/**
	 * Setter de la propriété selectedClient.
	 * 
	 * @param selectedClient
	 *            Le client à affecter à la propriété.
	 */
	public void setSelectedClient(Client selectedClient) {
		this.selectedClient = selectedClient;
		System.out.println(selectedClient);
	}
}
