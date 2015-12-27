package fr.gtm.proxibanquesi.exceptions;

/**
 * Classe personnalisée d'exception, qui hérite de la classe DaoException,
 *  provoquée si aucune donnée en base ne correspond à la requête
 */
public class LigneInexistanteException extends DaoException {

	/** Clé de sérialisation */
	private static final long serialVersionUID = 1L;
	/** Message renvoyé par l'exception */
	private String message;
	
	/**
	 * Constructeur par défaut de l'exception
	 * 
	 * @return void
	 */
	public LigneInexistanteException() {
		super();
	}
	
	/**
	 * Constructeur de l'exception
	 * 
	 * @param String message
	 * @return void
	 */
	public LigneInexistanteException(String message) {
		this();
		this.message = super.getMessage() + ": donnée manquante. " + message;
	}

	/**
	 * Getter de la propriété message
	 * 
	 * @return La propriété message
	 */
	@Override
	public String getMessage() {
		return this.message;
	}

}
