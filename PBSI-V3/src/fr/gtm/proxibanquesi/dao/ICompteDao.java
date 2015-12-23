package fr.gtm.proxibanquesi.dao;

import java.util.ArrayList;

import fr.gtm.proxibanquesi.domaine.Client;
import fr.gtm.proxibanquesi.domaine.Compte;
import fr.gtm.proxibanquesi.domaine.CompteCourant;
import fr.gtm.proxibanquesi.domaine.CompteEpargne;
import fr.gtm.proxibanquesi.domaine.Conseiller;
import fr.gtm.proxibanquesi.exceptions.LigneExistanteException;
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
	 * Méthode de création d'un compte.
	 * 
	 * @param comt
	 *            : le client
	 * @return
	 */
	public Compte createCompte(Compte comt);
	


	/**
	 * Méthode pour lire les informations d'un compte.
	 * 
	 * @param comt
	 *            : le compte
	 * @return
	 * @throws LigneInexistanteException
	 */
	public Compte readCompte(Compte comt) throws LigneInexistanteException;
	


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
	 * Méthode qui récupère la liste des comptes des clients d'un conseiller.
	 * 
	 * @param cons : Le conseiller en session
	 * @return Une liste de comptes
	 */
	public ArrayList<Compte> getListeComptes(Conseiller cons);;
	
	
	/**
	 * Méthode de modification d'un compte.
	 * @param compte : compte
	 * @return
	 * @throws LigneInexistanteException
	 */
	public Compte updateCompte(Compte comt) throws LigneInexistanteException;




	
	




	



	



	

	
	

	

}
