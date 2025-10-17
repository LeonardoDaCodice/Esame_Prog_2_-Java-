package catalogo;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import atleta.Atleta;
import eccezioni.FederazioneGiaCatalogataException;
import federazione.Federazione;
public class Catalogo {
	
	//mappa di chiave"codFederazione", valore "Federazione".
	private Map<String, Federazione> federazioni;

	
	
	public Catalogo() {
		super();
		this.federazioni = new HashMap<String, Federazione>();
	}
	
	
	public void addFederazione(Federazione federazione) throws FederazioneGiaCatalogataException {
		if(this.federazioni.containsKey(federazione.getCodFederazione())) {
			throw new FederazioneGiaCatalogataException();
		}else {
			this.federazioni.put(federazione.getCodFederazione(), federazione);
		}
	}
	
	//verifico se l'atleta risulti essere tesserato presso una federazione.
	public boolean atletaIsGiaTesserato(Atleta atleta) {
		boolean risultato = false;
		Iterator<Entry<String, Federazione>> itFederazioni = this.federazioni.entrySet().iterator();
		Federazione federazione = null;
		
		while(itFederazioni.hasNext()) {
			federazione = itFederazioni.next().getValue();
			if(federazione.atletaIsTesserato(atleta)) {
				System.out.println("L'atleta risulta essere gia tesserato presso :"+ federazione.getDenominazione());
				risultato = true;
			}
		}
		return risultato;
	}
	

}
