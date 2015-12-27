package fr.gtm.proxibanquesi.service;

import java.util.ArrayList;

import fr.gtm.proxibanquesi.domaine.Compte;
import fr.gtm.proxibanquesi.domaine.Conseiller;
import fr.gtm.proxibanquesi.exceptions.DaoException;
import fr.gtm.proxibanquesi.exceptions.LigneInexistanteException;
import fr.gtm.proxibanquesi.exceptions.SoldeInsuffisantException;

/**
 * Interface de la couche Service du COmpte
 * Elle liste les méthodes de CRUD d'un compte et la méthode virement.
 * @author Alexandre De Bruyn et Clement Peberge
 *
 */
public interface ICompteService {
	
	/**
	 * Méthode de création d'un compte.
	 * 
	 * @param comt : le compte
	 * @return Le compte créé
	 * @throws DaoException 
	 */
	public Compte creerCompte(Compte compte) throws DaoException;
	
	
	
	/**
	 * Méthode pour lire les informations d'un compte.
	 * 
	 * @param comt : le compte
	 * @return Le compte consulté
	 * @throws LigneInexistanteException
	 */
	public Compte consulterCompte(Compte compte) throws LigneInexistanteException;
	
	
	
	/**
	 * Méthode de modification d'un compte.
	 * @param compte : compte
	 * @return Le compte mis à jour
	 * @throws LigneInexistanteException
	 */
	public Compte modifierCompte(Compte compte) throws LigneInexistanteException;
	
	
	
	/**
	 * Méthode pour supprimer un compte.
	 * 
	 * @param comt : le compte
	 * @return res : un int représentant le nombre de lignes supprimée en base de données
	 * @throws LigneInexistanteException
	 */
	public int supprimerCompte(Compte compte) throws LigneInexistanteException;
	
	/**
	 * Méthode de virement d'un compte vers un autre compte.
	 * @param compteDebiteur : compte à débiter
	 * @param compteCrediteur : compte à créditer
	 * @param double montant : montant du virement
	 * @return
	 * @throws SoldeInsuffisantException
	 * @throws LigneInexistanteException
	 */
	public int virement(Compte compteDebiteur, Compte compteCrediteur, double montant)
			throws SoldeInsuffisantException, LigneInexistanteException;



	/**
	 * Méthode qui récupère la liste des comptes des clients d'un conseiller.
	 * 
	 * @param cons : Le conseiller en session
	 * @return La liste de tous les comptes des clients d'un conseiller
	 */
	public ArrayList<Compte> getListeComptes(Conseiller cons);



	



	

	
	
}
