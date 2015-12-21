package fr.gtm.proxibanquesi.exceptions;

public class LigneInexistanteException extends DaoException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;
	
	public LigneInexistanteException() {
		super();
	}
	
	public LigneInexistanteException(String message) {
		this();
		this.message = super.getMessage() + ": donn�e manquante. " + message;
	}

	@Override
	public String getMessage() {
		return this.message;
	}

}
