package fr.gtm.proxibanquesi.domaine;

import java.sql.Date;

/**
 * Classe abstraite repr�sentant un compte en banque g�n�rique.
 * @author Alexandre De Bruyn et Clement Peberge
 */
public abstract class Compte {

	// Propri�t�s
	/** Num�ro du compte */
	private int numCompte;
	/** Solde du compte */
	private double solde;
	/** Date d'ouverture du compte */
	private Date dateOuverture;
	/** Num�ro d'identification du client auquel le compte appartient */
	private int idcli;
	
	// Getters & Setters
	/**
	 * Getter de la propri�t� numCompte
	 * 
	 * @return La propri�t� numCompte
	 */
	public int getNumCompte() {
		return numCompte;
	}
	/**
	 * Setter de la propri�t� numCompte
	 * 
	 * @return void
	 */
	public void setNumCompte(int numCompte) {
		this.numCompte = numCompte;
	}
	/**
	 * Getter de la propri�t� solde
	 * 
	 * @return La propri�t� solde
	 */
	public double getSolde() {
		return solde;
	}
	/**
	 * Setter de la propri�t� solde
	 * 
	 * @return void
	 */
	public void setSolde(double d) {
		this.solde = d;
	}
	/**
	 * Getter de la propri�t� dateOuverture
	 * 
	 * @return La propri�t� dateOuverture
	 */
	public Date getDateOuverture() {
		return dateOuverture;
	}
	/**
	 * Setter de la propri�t� dateOuverture
	 * 
	 * @return void
	 */
	public void setDateOuverture(Date dateOuverture) {
		this.dateOuverture = dateOuverture;
	}
	/**
	 * Getter de la propri�t� idcli
	 * 
	 * @return La propri�t� idcli
	 */
	public int getIdcli() {
		return idcli;
	}
	/**
	 * Setter de la propri�t� idcli
	 * 
	 * @return void
	 */
	public void setIdcli(int idcli) {
		this.idcli = idcli;
	}
	// Affichage
	/**
	 * M�thode permettant de retourner un String avec les propri�t�s de l'objet Compte
	 * 
	 * @return String d�crivant le compte
	 */
	@Override
	public String toString() {
		return "CompteBancaire [numCompte=" + numCompte + ", solde=" + solde
				+ "]";
	}

}