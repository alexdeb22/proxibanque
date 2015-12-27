package fr.gtm.proxibanquesi.exceptions;

/**
 * Classe personnalisée d'exception, qui hérite de la classe Exception,
 *  provoquée par une erreur dans la couche Dao
 */
public class DaoException extends Exception {

	/** Clé de sérialisation */
	private static final long serialVersionUID = 1L;
	/** Message renvoyé par l'exception */
	private String message = "Database Exception";
	
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
