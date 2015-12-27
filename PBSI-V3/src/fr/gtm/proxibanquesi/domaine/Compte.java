package fr.gtm.proxibanquesi.domaine;

import java.sql.Date;

/**
 * Classe abstraite représentant un compte en banque générique.
 * @author Alexandre De Bruyn et Clement Peberge
 */
public abstract class Compte {

	// Propriétés
	/** Numéro du compte */
	private int numCompte;
	/** Solde du compte */
	private double solde;
	/** Date d'ouverture du compte */
	private Date dateOuverture;
	/** Numéro d'identification du client auquel le compte appartient */
	private int idcli;
	
	// Getters & Setters
	/**
	 * Getter de la propriété numCompte
	 * 
	 * @return La propriété numCompte
	 */
	public int getNumCompte() {
		return numCompte;
	}
	/**
	 * Setter de la propriété numCompte
	 * 
	 * @return void
	 */
	public void setNumCompte(int numCompte) {
		this.numCompte = numCompte;
	}
	/**
	 * Getter de la propriété solde
	 * 
	 * @return La propriété solde
	 */
	public double getSolde() {
		return solde;
	}
	/**
	 * Setter de la propriété solde
	 * 
	 * @return void
	 */
	public void setSolde(double d) {
		this.solde = d;
	}
	/**
	 * Getter de la propriété dateOuverture
	 * 
	 * @return La propriété dateOuverture
	 */
	public Date getDateOuverture() {
		return dateOuverture;
	}
	/**
	 * Setter de la propriété dateOuverture
	 * 
	 * @return void
	 */
	public void setDateOuverture(Date dateOuverture) {
		this.dateOuverture = dateOuverture;
	}
	/**
	 * Getter de la propriété idcli
	 * 
	 * @return La propriété idcli
	 */
	public int getIdcli() {
		return idcli;
	}
	/**
	 * Setter de la propriété idcli
	 * 
	 * @return void
	 */
	public void setIdcli(int idcli) {
		this.idcli = idcli;
	}
	// Affichage
	/**
	 * Méthode permettant de retourner un String avec les propriétés de l'objet Compte
	 * 
	 * @return String décrivant le compte
	 */
	@Override
	public String toString() {
		return "CompteBancaire [numCompte=" + numCompte + ", solde=" + solde
				+ "]";
	}

}