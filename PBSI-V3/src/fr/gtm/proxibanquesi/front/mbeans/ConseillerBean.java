package fr.gtm.proxibanquesi.front.mbeans;

import java.io.Serializable;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseListener;
import javax.inject.Inject;

import org.primefaces.event.SelectEvent;

import fr.gtm.proxibanquesi.domaine.Client;
import fr.gtm.proxibanquesi.domaine.Conseiller;
import fr.gtm.proxibanquesi.exceptions.LigneInexistanteException;
import fr.gtm.proxibanquesi.service.IConseillerService;

@ManagedBean(name = "conseiller")
@SessionScoped
public class ConseillerBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Inject
	IConseillerService serv;

	
	private String login;
	private String mdp;
	private String nom;
	private String prenom;
	private int idcons;
	private ArrayList<Client> listeClients = new ArrayList<Client>();
	
	private Client selectedClient;

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

	public Client getSelectedClient() {
		return selectedClient;
	}

	public void setSelectedClient(Client selectedClient) {
		this.selectedClient = selectedClient;
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

			// Si valide mettre � jour le Managed Bean avec les infos Conseiller
			cons = serv.checkUser(cons);
			nom = cons.getNom();
			prenom = cons.getPrenom();
			idcons = cons.getIdcons();
			// R�cup�rer la liste des clients
			listeClients = serv.getListeClients(cons);
			// Debug
			System.out.println(listeClients);
			return "user-page";
		} catch (LigneInexistanteException e) {
			// Si invalide retourner page existante et message d'erreur
			// (FacesMessage)
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Login/Mot de passe invalides",
					"Veuillez r�essayer");
			FacesContext.getCurrentInstance().addMessage("login-form", message);
			return null;
		}

	}
	
    public void onRowSelect(SelectEvent event) {
        FacesMessage msg = new FacesMessage("Client choisi", ((Client) event.getObject()).getNom());
        FacesContext.getCurrentInstance().addMessage(null, msg);
        selectedClient = (Client) event.getObject();
    }
    

}
