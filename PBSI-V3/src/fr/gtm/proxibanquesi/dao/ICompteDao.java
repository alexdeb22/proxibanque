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
 * de la base de donn�es.
 * 
 * @author Alexandre De Bruyn
 *
 */
public interface ICompteDao {

	/**
	 * M�thode de cr�ation d'un compte.
	 * 
	 * @param comt
	 *            : le client
	 * @return
	 */
	public Compte createCompte(Compte comt);
	


	/**
	 * M�thode pour lire les informations d'un compte.
	 * 
	 * @param comt
	 *            : le compte
	 * @return
	 * @throws LigneInexistanteException
	 */
	public Compte readCompte(Compte comt) throws LigneInexistanteException;
	


	/**
	 * M�thode pour supprimer un compte.
	 * 
	 * @param comt
	 *            : le client
	 * @return
	 * @throws LigneInexistanteException
	 */
	public int delete(Compte comt) throws LigneInexistanteException;

	/**
	 * M�thode qui r�cup�re la liste des comptes des clients d'un conseiller.
	 * 
	 * @param cons : Le conseiller en session
	 * @return Une liste de comptes
	 */
	public ArrayList<Compte> getListeComptes(Conseiller cons);;
	
	
	/**
	 * M�thode de modification d'un compte.
	 * @param compte : compte
	 * @return
	 * @throws LigneInexistanteException
	 */
	public Compte updateCompte(Compte comt) throws LigneInexistanteException;




	
	




	



	



	

	
	

	

}
