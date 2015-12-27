package fr.gtm.proxibanquesi.front.mbeans;

import java.io.Serializable;
import java.util.ArrayList;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import fr.gtm.proxibanquesi.domaine.Client;
import fr.gtm.proxibanquesi.domaine.Compte;
import fr.gtm.proxibanquesi.exceptions.LigneExistanteException;
import fr.gtm.proxibanquesi.exceptions.LigneInexistanteException;
import fr.gtm.proxibanquesi.service.IClientService;

@ManagedBean(name="clientbean")
public class ClientBean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ManagedProperty(value="#{conseiller}")
	private ConseillerBean cons;

	@Inject
	private IClientService serv;
	
	private String nom;
	private String prenom;
	private String adresse;
	private String codePostal;
	private String ville;
	private String telephone;
	private int id;
	private ArrayList<Compte> listeComptes;
	private Client client;
	
	
	public ClientBean() {
		super();
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
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getCodePostal() {
		return codePostal;
	}
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public ArrayList<Compte> getListeComptes() {
		return listeComptes;
	}
	public void setListeComptes(ArrayList<Compte> listeComptes) {
		this.listeComptes = listeComptes;
	}
	
		
	public ConseillerBean getCons() {
		return cons;
	}

	public void setCons(ConseillerBean cons) {
		this.cons = cons;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public void creerClient() {
		Client client = new Client(nom, prenom, adresse, codePostal, ville, telephone, cons.getIdcons());
		try {
			client = serv.createClient(client);
			nom = client.getNom();
			prenom = client.getPrenom();
			adresse = client.getAdresse();
			codePostal = client.getCodePostal();
			ville = client.getVille();
			telephone = client.getTelephone();
			id = client.getId();
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Succes",
					"Client créé avec succès.");
			FacesContext.getCurrentInstance().addMessage("creerclient-form", message);
		} catch (LigneExistanteException e) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erreur",
					"Ce client existe déja.");
			FacesContext.getCurrentInstance().addMessage("creerclient-form", message);
		}
	}
	
//	public String consulterClient() {
//		Client client = new Client();
//		client.setCons(cons.getIdcons());
//		client.setId(getId());
//		
//		try {
//			client = serv.consulterClient(client);
//			nom = client.getNom();
//			prenom = client.getPrenom();
//			adresse = client.getAdresse();
//			codePostal = client.getCodePostal();
//			ville = client.getVille();
//			telephone = client.getTelephone();
//			id = client.getId();
//		} catch (LigneInexistanteException e) {
//			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erreur",
//					"Le client n'existe pas dans la base");
//			FacesContext.getCurrentInstance().addMessage("clientpage-grid", message);
//		}
//		return "client-page";
//	}
	
}
