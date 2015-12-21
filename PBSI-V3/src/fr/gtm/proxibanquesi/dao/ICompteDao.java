package fr.gtm.proxibanquesi.dao;

import java.util.ArrayList;

import fr.gtm.proxibanquesi.domaine.Compte;
import fr.gtm.proxibanquesi.domaine.CompteCourant;
import fr.gtm.proxibanquesi.domaine.CompteEpargne;
import fr.gtm.proxibanquesi.exceptions.LigneInexistanteException;

/**
 * Cette interface permet d'effectuer les fonctions de CRUD pour la table Compte
 * de la base de données.
 * 
 * @author Alexandre De Bruyn
 *
 */
public interface ICompteDao {

	/**
	 * Méthode de création un compte Epargne.
	 * 
	 * @param comt
	 *            : le client
	 * @return
	 */
	public int createEpargne(CompteEpargne comt);

	/**
	 * Méthode de création un compte Courant.
	 * 
	 * @param comt
	 *            : le client
	 * @return
	 */
	public int createCourant(CompteCourant comt);

	/**
	 * Méthode pour lire les informations d'un compte.
	 * 
	 * @param comt
	 *            : le client
	 * @return
	 * @throws LigneInexistanteException
	 */
	public Compte read(Compte comt) throws LigneInexistanteException;

	/**
	 * Méthode pour modifier les informations d'un compte.
	 * 
	 * @param comt
	 *            : le client
	 * @return
	 * @throws LigneInexistanteException
	 */
	public int updateCourant(CompteCourant comt) throws LigneInexistanteException;

	/**
	 * Méthode pour supprimer un compte.
	 * 
	 * @param comt
	 *            : le client
	 * @return
	 * @throws LigneInexistanteException
	 */
	public int delete(Compte comt) throws LigneInexistanteException;

	/**
	 * Méthode qui récupère la liste des numéros de compte courant d'un client à partir
	 * de son identifiant.
	 * 
	 * @param id
	 *            L'identifiant du client
	 * @return Une liste de numéros de compte
	 */
	public ArrayList<Integer> getListeComptesCourant(int id);
	
	/**
	 * Méthode qui récupère la liste des numéros de compte épargne d'un client à partir
	 * de son identifiant.
	 * 
	 * @param id
	 *            L'identifiant du client
	 * @return Une liste de numéros de compte
	 */
	public ArrayList<Integer> getListeComptesEpargne(int id);
	
	public boolean debiter(int numcompte, Double montant);
	
	public boolean crediter(int numcompte, Double montant);

	

}
