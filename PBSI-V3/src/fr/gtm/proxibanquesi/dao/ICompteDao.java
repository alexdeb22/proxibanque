package fr.gtm.proxibanquesi.dao;

import java.util.ArrayList;

import fr.gtm.proxibanquesi.domaine.Compte;
import fr.gtm.proxibanquesi.domaine.Conseiller;
import fr.gtm.proxibanquesi.exceptions.DaoException;
import fr.gtm.proxibanquesi.exceptions.LigneInexistanteException;

/**
 * Cette interface permet d'effectuer les fonctions de CRUD pour la table Compte
 * de la base de donn�es.
 * 
 * @author Alexandre De Bruyn et Clement Peberge
 *
 */
public interface ICompteDao {

	/**
	 * M�thode de cr�ation d'un compte.
	 * 
	 * @param comt : le compte
	 * @return Le compte cr��
	 * @throws DaoException 
	 */
	public Compte createCompte(Compte comt) throws DaoException;
	


	/**
	 * M�thode pour lire les informations d'un compte.
	 * 
	 * @param comt : le compte
	 * @return Le compte consult�
	 * @throws LigneInexistanteException
	 */
	public Compte readCompte(Compte comt) throws LigneInexistanteException;
	


	/**
	 * M�thode pour supprimer un compte.
	 * 
	 * @param comt : le compte
	 * @return res : un int repr�sentant le nombre de lignes supprim�e en base de donn�es
	 * @throws LigneInexistanteException
	 */
	public int delete(Compte comt) throws LigneInexistanteException;

	/**
	 * M�thode qui r�cup�re la liste des comptes des clients d'un conseiller.
	 * 
	 * @param cons : Le conseiller en session
	 * @return La liste de tous les comptes des clients d'un conseiller
	 */
	public ArrayList<Compte> getListeComptes(Conseiller cons);;
	
	
	/**
	 * M�thode de modification d'un compte.
	 * @param compte : compte
	 * @return Le compte mis � jour
	 * @throws LigneInexistanteException
	 */
	public Compte updateCompte(Compte comt) throws LigneInexistanteException;




	
	




	



	



	

	
	

	

}
