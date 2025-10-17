package eccezioni;

public class CodiceAltletaException extends Exception {

	public CodiceAltletaException (String messaggio) {
		super(messaggio);
	}
	
	
	public CodiceAltletaException() {
		super("Codice Atleta Exception!");
	}
}
