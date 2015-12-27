package fr.gtm.proxibanquesi.exceptions;

/**
 * Classe personnalisée d'exception, qui hérite de la classe Exception,
 *  provoquée si une modification de solde dépasse l'autorisation du compte concerné
 */
public class SoldeInsuffisantException extends Exception {

	/** Clé de sérialisation */
	private static final long serialVersionUID = 1L;

}
