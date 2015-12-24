package fr.gtm.proxibanquesi.dao;

import java.util.ArrayList;

import fr.gtm.proxibanquesi.domaine.Client;
import fr.gtm.proxibanquesi.domaine.Conseiller;
import fr.gtm.proxibanquesi.exceptions.LigneExistanteException;
import fr.gtm.proxibanquesi.exceptions.LigneInexistanteException;

/**
 * Cette interface permet d'effectuer les fonctions de CRUD
 * pour la table CONSEILLER de la base de données.
 * @author Alexandre De Bruyn
 *
 */

public interface IConseillerDao {
	
	/**
	 * Méthode de création un conseiller.
	 * @param cons qui est le conseiller.
	 * @return
	 * @throws LigneExistanteException
	 */
	public Conseiller create(Conseiller cons) throws LigneExistanteException;
	
	/**
	 * Méthode pour lire les informations d'un conseiller.
	 * @param cons qui est le conseiller.
	 * @return
	 * @throws LigneInexistanteException
	 */
	public Conseiller read(Conseiller cons) throws LigneInexistanteException;
	
	/**
	 * Méthode pour modifier les informations d'un conseiller.
	 * @param cons qui est le conseiller.
	 * @return
	 * @throws LigneInexistanteException
	 */
	public Conseiller update(Conseiller cons) throws LigneInexistanteException;
	
	/**
	 * Méthode pour supprimer un conseiller.
	 * @param cons qui est le conseiller.
	 * @return
	 * @throws LigneInexistanteException
	 */
	public int delete(Conseiller cons) throws LigneInexistanteException;
	

	public ArrayList<Client> getListeClients(Conseiller cons);


	
}
