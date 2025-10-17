package eccezioni;

public class AtletaNonPresenteException extends Exception {

	public AtletaNonPresenteException(String messaggio) {
		super(messaggio);
	}
	
	public AtletaNonPresenteException() {
		super("Atleta non presente Exception!");
	}
}
