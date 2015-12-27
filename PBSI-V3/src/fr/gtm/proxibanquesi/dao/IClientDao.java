package fr.gtm.proxibanquesi.dao;

import java.util.ArrayList;

import fr.gtm.proxibanquesi.domaine.Client;
import fr.gtm.proxibanquesi.domaine.Compte;
import fr.gtm.proxibanquesi.exceptions.LigneExistanteException;
import fr.gtm.proxibanquesi.exceptions.LigneInexistanteException;

/**
 * Cette interface permet d'effectuer les fonctions de CRUD pour la table CLIENT
 * de la base de données.
 * 
 * @author Alexandre De Bruyn et Clement Peberge
 *
 */
public interface IClientDao {

	/**
	 * Méthode de création de client.
	 * 
	 * @param cli : le client
	 * @return le client créé
	 * @throws LigneExistanteException
	 */
	public Client create(Client cli) throws LigneExistanteException;

	/**
	 * Méthode de lecture des informations du client.
	 * 
	 * @param cli : le client
	 * @return le client consulté
	 * @throws LigneInexistanteException
	 */
	public Client read(Client cli) throws LigneInexistanteException;

	/**
	 * Méthode pour modifier les informations du client.
	 * 
	 * @param cli : le client
	 * @return le client mis à jour
	 * @throws LigneInexistanteException
	 */
	public Client update(Client cli) throws LigneInexistanteException;

	/**
	 * Méthode pour effacer un client.
	 * 
	 * @param cli : le client
	 * @return res : un int représentant le nombre de lignes supprimée en base de données
	 * @throws LigneInexistanteException
	 */
	public int delete(Client cli) throws LigneInexistanteException;

	/**
	 * Méthode qui récupère la liste des comptes d'un client.
	 * 
	 * @param client : Le client
	 * @return La liste de comptes d'un client
	 */
	public ArrayList<Compte> getListeComptesClient(Client client);


	

}
