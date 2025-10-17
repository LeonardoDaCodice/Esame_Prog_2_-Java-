package eccezioni;


public class FederazioneGiaCatalogataException extends Exception {

	public FederazioneGiaCatalogataException(String messaggio) {
		super(messaggio);
	}
	
	public FederazioneGiaCatalogataException() {
		super("Federazione gia catalogata Exception!");
	}
}
