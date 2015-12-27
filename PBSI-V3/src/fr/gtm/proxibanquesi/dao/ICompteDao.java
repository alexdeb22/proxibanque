package fr.gtm.proxibanquesi.dao;

import java.util.ArrayList;

import fr.gtm.proxibanquesi.domaine.Compte;
import fr.gtm.proxibanquesi.domaine.Conseiller;
import fr.gtm.proxibanquesi.exceptions.DaoException;
import fr.gtm.proxibanquesi.exceptions.LigneInexistanteException;

/**
 * Cette interface permet d'effectuer les fonctions de CRUD pour la table Compte
 * de la base de données.
 * 
 * @author Alexandre De Bruyn et Clement Peberge
 *
 */
public interface ICompteDao {

	/**
	 * Méthode de création d'un compte.
	 * 
	 * @param comt : le compte
	 * @return Le compte créé
	 * @throws DaoException 
	 */
	public Compte createCompte(Compte comt) throws DaoException;
	


	/**
	 * Méthode pour lire les informations d'un compte.
	 * 
	 * @param comt : le compte
	 * @return Le compte consulté
	 * @throws LigneInexistanteException
	 */
	public Compte readCompte(Compte comt) throws LigneInexistanteException;
	


	/**
	 * Méthode pour supprimer un compte.
	 * 
	 * @param comt : le compte
	 * @return res : un int représentant le nombre de lignes supprimée en base de données
	 * @throws LigneInexistanteException
	 */
	public int delete(Compte comt) throws LigneInexistanteException;

	/**
	 * Méthode qui récupère la liste des comptes des clients d'un conseiller.
	 * 
	 * @param cons : Le conseiller en session
	 * @return La liste de tous les comptes des clients d'un conseiller
	 */
	public ArrayList<Compte> getListeComptes(Conseiller cons);;
	
	
	/**
	 * Méthode de modification d'un compte.
	 * @param compte : compte
	 * @return Le compte mis à jour
	 * @throws LigneInexistanteException
	 */
	public Compte updateCompte(Compte comt) throws LigneInexistanteException;




	
	




	



	



	

	
	

	

}
