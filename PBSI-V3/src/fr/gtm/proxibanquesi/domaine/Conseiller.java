package fr.gtm.proxibanquesi.domaine;

import javax.validation.constraints.NotNull;

/** Cette classe représente un conseiller d'une agence ProxiBanque.
 * @author Alexandre De Bruyn et Clement Peberge
 *
 */
public class Conseiller {
	// Prorpiétés
	/** Prenom du conseiller. */
	private String prenom;
	/** Nom du conseiller. */
	private String nom;
	/** Numéro d'identification du conseiller. */
	private int idcons;
	/** Numéro d'identification de l'agence. */
	private int idagence;
	/** True si le conseiller est également le gérant de l'agence. */
	private boolean gerant = false;
	/** Login du conseiller pour s'authentifier à l'application */
	@NotNull(message="Veuillez saisir votre identifiant")
	private String login;
	/** Mot de passe du conseiller pour s'authentifier à l'application */
	@NotNull(message="Veuillez saisir votre mot de passe")
	private String mdp;

	// Constructeurs
	/**
	 * Constructeur par défaut du conseiller
	 */
	public Conseiller() {
	}
	/**
	 * Constructeur du conseiller avec les propriétés nom et prenom
	 * 
	 * @param String nom
	 * String prenom
	 * @return void
	 */
	public Conseiller(String nom, String prenom) {
		super();
		this.prenom = prenom;
		this.nom = nom;
		this.idagence = 1;
		this.gerant = false;
	}	
	/**
	 * Constructeur du conseiller avec les propriétés nom ,prenom, et gérant
	 * 
	 * @param String nom
	 * String prenom
	 * boolean gerant
	 * @return void
	 */
	public Conseiller(String nom, String prenom, boolean gerant) {
		this(nom, prenom);
		this.gerant = true;		
	}
	/**
	 * Constructeur du conseiller avec les propriétés nom ,prenom, login et mdp
	 * 
	 * @param String nom
	 * String prenom
	 * String login
	 * String mdp
	 * @return void
	 */
	public Conseiller(String nom, String prenom, String login, String mdp) {
		this(nom, prenom);
		this.login = login;
		this.mdp = mdp;
	}
	/**
	 * Constructeur du conseiller avec les propriétés nom ,prenom, login, mdp et gerant
	 * 
	 * @param String nom
	 * String prenom
	 * String login
	 * String mdp
	 * boolean gerant
	 * @return void
	 */
	public Conseiller(String nom, String prenom, String login, String mdp, boolean gerant) {
		this(nom, prenom, gerant);
		this.login = login;
		this.mdp = mdp;
	}
	
	// Getters & Setters
	/**
	 * Getter de la propriété prenom
	 * 
	 * @return La propriété prenom
	 */
	public String getPrenom() {
		return this.prenom;
	}
	/**
	 * Setter de la propriété prenom
	 * 
	 * @return void
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	/**
	 * Getter de la propriété nom
	 * 
	 * @return La propriété nom
	 */
	public String getNom() {
		return this.nom;
	}
	/**
	 * Setter de la propriété nom
	 * 
	 * @return void
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	/**
	 * Getter de la propriété idcons
	 * 
	 * @return La propriété idcons
	 */
	public int getIdcons() {
		return idcons;
	}
	/**
	 * Setter de la propriété idcons
	 * 
	 * @return void
	 */
	public void setIdcons(int idcons) {
		this.idcons = idcons;
	}
	/**
	 * Getter de la propriété idagence
	 * 
	 * @return La propriété idagence
	 */
	public int getIdagence() {
		return idagence;
	}
	/**
	 * Setter de la propriété idagence
	 * 
	 * @return void
	 */
	public void setIdagence(int idagence) {
		this.idagence = idagence;
	}
	/**
	 * Getter de la propriété gerant
	 * 
	 * @return La propriété gerant
	 */
	public boolean isGerant() {
		return gerant;
	}
	/**
	 * Setter de la propriété gerant
	 * 
	 * @return void
	 */
	public void setGerant(boolean gerant) {
		this.gerant = gerant;
	}
	/**
	 * Getter de la propriété login
	 * 
	 * @return La propriété login
	 */
	public String getLogin() {
		return login;
	}
	/**
	 * Setter de la propriété login
	 * 
	 * @return void
	 */
	public void setLogin(String login) {
		this.login = login;
	}
	/**
	 * Getter de la propriété mdp
	 * 
	 * @return La propriété mdp
	 */
	public String getMdp() {
		return mdp;
	}
	/**
	 * Setter de la propriété mdp
	 * 
	 * @return void
	 */
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	/**
	 * Méthode permettant de retourner un String avec les propriétés de l'objet Conseiller
	 * 
	 * @return String décrivant le conseiller
	 */
	@Override
	public String toString() {
		return "Conseiller [prenom=" + prenom + ", nom=" + nom + ", idcons=" + idcons + ", idagence=" + idagence
				+ ", gerant=" + gerant + ", login=" + login + ", mdp=" + mdp + "]";
	}




}
