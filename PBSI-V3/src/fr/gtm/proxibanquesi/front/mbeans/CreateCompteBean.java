package fr.gtm.proxibanquesi.front.mbeans;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import fr.gtm.proxibanquesi.domaine.Compte;
import fr.gtm.proxibanquesi.domaine.CompteCourant;
import fr.gtm.proxibanquesi.domaine.CompteEpargne;
import fr.gtm.proxibanquesi.service.ICompteService;

@ManagedBean(name = "createCompteBean")

public class CreateCompteBean implements Serializable {

	// Serial ID
	private static final long serialVersionUID = 1L;

	// Compte to create
	private Compte createdCompte;
	@ManagedProperty(value = "courant")
	private String type;

	// Client id
	@ManagedProperty(value = "#{clientBean.selectedClient.id}")
	private int idclient;

	// Service injection
	@Inject
	ICompteService serv;

	// Constructor
	public CreateCompteBean() {
		createdCompte = new CompteCourant();
	}

	// Bean lifecycle log
	@PostConstruct
	public void creationBean() {
		System.out.println("Création CreateCompteBean, id client: " + idclient);

	}

	@PreDestroy
	public void destructionBean() {
		System.out.println("Destruction CreateCompteBean");
	}

	// Creation du compte
	public void creerCompte() {
		
		createdCompte.setIdcli(idclient);
		if(type.equals("courant")) serv.creerCompte( (CompteCourant) createdCompte);
		// Tres moche....
		else if(type.equals("epargne")) {
			CompteEpargne epargne = new CompteEpargne();
			epargne.setIdcli(idclient);
			epargne.setSolde(createdCompte.getSolde());
			serv.creerCompte( epargne);
		}
	}

	public Compte getCreatedCompte() {
		return createdCompte;
	}

	public void setCreatedCompte(Compte createdCompte) {
		this.createdCompte = createdCompte;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getIdclient() {
		return idclient;
	}

	public void setIdclient(int idclient) {
		this.idclient = idclient;
	}

}
