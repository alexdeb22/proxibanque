package fr.gtm.proxibanquesi.exceptions;

public class LigneExistanteException extends DaoException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;
	
	public LigneExistanteException(String message) {
		super();
		this.message = super.getMessage() + ": " + message;
	}

	@Override
	public String getMessage() {
		return this.message;
	}

}
