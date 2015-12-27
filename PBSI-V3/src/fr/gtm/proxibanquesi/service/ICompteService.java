package fr.gtm.proxibanquesi.service;

import java.util.ArrayList;

import fr.gtm.proxibanquesi.domaine.Compte;
import fr.gtm.proxibanquesi.domaine.Conseiller;
import fr.gtm.proxibanquesi.exceptions.DaoException;
import fr.gtm.proxibanquesi.exceptions.LigneInexistanteException;
import fr.gtm.proxibanquesi.exceptions.SoldeInsuffisantException;

/**
 * Interface de la couche Service du COmpte
 * Elle liste les méthodes de CRUD d'un compte.
 * @author Alexandre et Coralie
 *
 */
public interface ICompteService {
	
	/**
	 * Méthode pour créer un compte
	 * @param compte : compte
	 * @return
	 * @throws DaoException 
	 */
	public Compte creerCompte(Compte compte) throws DaoException;
	
	
	
	/**
	 * Méthode pour lire les informations d'un compte.
	 * @param compte : un compte
	 * @return
	 * @throws LigneInexistanteException
	 */
	public Compte consulterCompte(Compte compte) throws LigneInexistanteException;
	
	
	
	/**
	 * Méthode pour modifier le solde d'un compte.
	 * @param compte : un compte
	 * @return
	 * @throws LigneInexistanteException
	 */
	public Compte modifierCompte(Compte compte) throws LigneInexistanteException;
	
	
	
	/**
	 * Méthode pour supprimer un compte.
	 * @param compte : un compte
	 * @return
	 * @throws LigneInexistanteException
	 */
	public int supprimerCompte(Compte compte) throws LigneInexistanteException;
	
	/**
	 * Méthode de virement d'un compte vers un autre compte.
	 * @param compteDebiteur : compte
	 * @param compteCrediteur : compte
	 * @param montant
	 * @return
	 * @throws SoldeInsuffisantException
	 * @throws LigneInexistanteException
	 */
	public int virement(Compte compteDebiteur, Compte compteCrediteur, double montant)
			throws SoldeInsuffisantException, LigneInexistanteException;




	public ArrayList<Compte> getListeComptes(Conseiller cons);



	



	

	
	
}
