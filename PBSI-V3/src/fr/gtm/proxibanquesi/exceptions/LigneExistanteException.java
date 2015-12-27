package fr.gtm.proxibanquesi.exceptions;

/**
 * Classe personnalisée d'exception, qui hérite de la classe DaoException,
 *  provoquée si une clé primaire de la base est violée
 */
public class LigneExistanteException extends DaoException {

	/** Clé de sérialisation */
	private static final long serialVersionUID = 1L;
	/** Message renvoyé par l'exception */
	private String message;
	
	/**
	 * Constructeur de l'exception
	 * 
	 * @param String message
	 * @return void
	 */
	public LigneExistanteException(String message) {
		super();
		this.message = super.getMessage() + ": " + message;
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
