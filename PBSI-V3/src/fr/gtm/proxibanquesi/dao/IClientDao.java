package fr.gtm.proxibanquesi.dao;

import java.util.ArrayList;

import fr.gtm.proxibanquesi.domaine.Client;
import fr.gtm.proxibanquesi.domaine.Compte;
import fr.gtm.proxibanquesi.exceptions.LigneExistanteException;
import fr.gtm.proxibanquesi.exceptions.LigneInexistanteException;

/**
 * Cette interface permet d'effectuer les fonctions de CRUD pour la table CLIENT
 * de la base de donn�es.
 * 
 * @author Alexandre De Bruyn et Clement Peberge
 *
 */
public interface IClientDao {

	/**
	 * M�thode de cr�ation de client.
	 * 
	 * @param cli : le client
	 * @return le client cr��
	 * @throws LigneExistanteException
	 */
	public Client create(Client cli) throws LigneExistanteException;

	/**
	 * M�thode de lecture des informations du client.
	 * 
	 * @param cli : le client
	 * @return le client consult�
	 * @throws LigneInexistanteException
	 */
	public Client read(Client cli) throws LigneInexistanteException;

	/**
	 * M�thode pour modifier les informations du client.
	 * 
	 * @param cli : le client
	 * @return le client mis � jour
	 * @throws LigneInexistanteException
	 */
	public Client update(Client cli) throws LigneInexistanteException;

	/**
	 * M�thode pour effacer un client.
	 * 
	 * @param cli : le client
	 * @return res : un int repr�sentant le nombre de lignes supprim�e en base de donn�es
	 * @throws LigneInexistanteException
	 */
	public int delete(Client cli) throws LigneInexistanteException;

	/**
	 * M�thode qui r�cup�re la liste des comptes d'un client.
	 * 
	 * @param client : Le client
	 * @return La liste de comptes d'un client
	 */
	public ArrayList<Compte> getListeComptesClient(Client client);


	

}
