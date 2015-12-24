package fr.gtm.proxibanquesi.dao;

import fr.gtm.proxibanquesi.domaine.Client;
import fr.gtm.proxibanquesi.exceptions.LigneExistanteException;
import fr.gtm.proxibanquesi.exceptions.LigneInexistanteException;

/**
 * Cette interface permet d'effectuer les fonctions de CRUD pour la table CLIENT
 * de la base de donn�es.
 * 
 * @author Alexandre De Bruyn
 *
 */
public interface IClientDao {

	/**
	 * M�thode de cr�ation de client.
	 * 
	 * @param cli
	 *            : le client
	 * @return
	 * @throws LigneExistanteException
	 */
	public Client create(Client cli) throws LigneExistanteException;

	/**
	 * M�thode de lecture des informations du client.
	 * 
	 * @param cli
	 *            : le client
	 * @return
	 * @throws LigneInexistanteException
	 */
	public Client read(Client cli) throws LigneInexistanteException;

	/**
	 * M�thode pour modifier les informations du client.
	 * 
	 * @param cli
	 *            : le client
	 * @return
	 * @throws LigneInexistanteException
	 */
	public Client update(Client cli) throws LigneInexistanteException;

	/**
	 * M�thode pour effacer un client.
	 * 
	 * @param cli
	 *            : le client
	 * @return
	 * @throws LigneInexistanteException
	 */
	public int delete(Client cli) throws LigneInexistanteException;


	

}
