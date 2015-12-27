package fr.gtm.proxibanquesi.dao;

import java.util.ArrayList;

import fr.gtm.proxibanquesi.domaine.Client;
import fr.gtm.proxibanquesi.domaine.Conseiller;
import fr.gtm.proxibanquesi.exceptions.LigneExistanteException;
import fr.gtm.proxibanquesi.exceptions.LigneInexistanteException;

/**
 * Cette interface permet d'effectuer les fonctions de CRUD
 * pour la table CONSEILLER de la base de donn�es.
 * @author Alexandre De Bruyn et Clement Peberge
 *
 */

public interface IConseillerDao {
	
	/**
	 * M�thode de cr�ation un conseiller.
	 * @param cons qui est le conseiller.
	 * @return Le conseiller cr��
	 * @throws LigneExistanteException
	 */
	public Conseiller create(Conseiller cons) throws LigneExistanteException;
	
	/**
	 * M�thode pour lire les informations d'un conseiller.
	 * @param cons qui est le conseiller (doit avoir un login et un mdp).
	 * @return Le conseiller consult�
	 * @throws LigneInexistanteException
	 */
	public Conseiller read(Conseiller cons) throws LigneInexistanteException;
	
	/**
	 * M�thode pour modifier les informations d'un conseiller.
	 * @param cons qui est le conseiller.
	 * @return Le conseiller mis � jour
	 * @throws LigneInexistanteException
	 */
	public Conseiller update(Conseiller cons) throws LigneInexistanteException;
	
	/**
	 * M�thode pour supprimer un conseiller.
	 * @param cons qui est le conseiller.
	 * @return res : un int repr�sentant le nombre de lignes supprim�e en base de donn�es
	 * @throws LigneInexistanteException
	 */
	public int delete(Conseiller cons) throws LigneInexistanteException;
	
	/**
	 * M�thode pour r�cup�rer la liste des clients et leurs comptes d'un conseiller.
	 * @param cons qui est le conseiller.
	 * @return La liste de clients et de comptes du conseiller
	 */
	public ArrayList<Client> getListeClients(Conseiller cons);


	
}
