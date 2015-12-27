package fr.gtm.proxibanquesi.service;

import java.util.ArrayList;

import fr.gtm.proxibanquesi.domaine.Client;
import fr.gtm.proxibanquesi.domaine.Compte;
import fr.gtm.proxibanquesi.exceptions.LigneExistanteException;
import fr.gtm.proxibanquesi.exceptions.LigneInexistanteException;

/**
 * Interface de la couche Service du Client
 * Elle liste les m�thodes de CRUD d'un client, et les m�thodes pour lister ses diff�rents types de comptes.
 * @author Alexandre et Coralie
 *
 */
public interface IClientService {
	/**
	 * M�thode de cr�ation d'un client.
	 * @param cli : le client
	 * @return
	 * @throws LigneExistanteException
	 */
	public Client createClient(Client cli) throws LigneExistanteException;
	
	/**
	 * M�thode pour lire les informations d'un client.
	 * @param cli : le client
	 * @return
	 * @throws LigneInexistanteException
	 */
	public Client consulterClient(Client cli) throws LigneInexistanteException;
	
	/**
	 * M�thode pour modifier les informations d'un client.
	 * @param cli : le client
	 * @return
	 * @throws LigneInexistanteException
	 */
	public Client modifierClient(Client cli) throws LigneInexistanteException;
	
	/**
	 * M�thode pour supprimer un client et ses comptes.
	 * @param cli : le client
	 * @return
	 * @throws LigneInexistanteException
	 */
	public int supprimerClient(Client cli) throws LigneInexistanteException;
	
	/**
	 * M�thode qui r�cup�re la liste des comptes d'un client.
	 * 
	 * @param client : Le client
	 * @return Une liste de comptes
	 */
	public ArrayList<Compte> getListeComptesClient(Client client);

}
