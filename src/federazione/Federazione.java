package federazione;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Iterator;
import java.util.LinkedList;

import atleta.Atleta;
import comparator.ComparatorTesseramentoByCognome;
import comparator.ComparatorTesseratiByAnno;
import eccezioni.AtletaNonPresenteException;
import eccezioni.CodiceAltletaException;
import tesserato.Tesserato;

public class Federazione {
	
	private static int generateCode;
	private String codFederazione;
	private String denominazione;
	
	//mappa Chiave "CodAtleta", Valore"Tesseramento".
	private Map<String, Tesseramento> tesseramenti;

	public Federazione(String denominazione) {
		super();
		this.codFederazione = ""+generateCode;
		generateCode++;
		this.denominazione = denominazione;
		this.tesseramenti = new HashMap<String, Tesseramento>();
	}
	
	
	
	//inserimento di un nuovo tesserato.
	//la verifica della presenza dell'atleta verr�
	//effettuata all'interno del main tramite la consultazione
	//del Catalogo.
	public void addTesseramento(Atleta atleta, int costo, String modPagamento) throws CodiceAltletaException {
	Tesserato tesserato = new Tesserato(atleta.getCodAtleta(), atleta.getNome(),atleta.getCognome());
	
	Tesseramento tesseramento = new Tesseramento(costo, modPagamento, tesserato);
	this.tesseramenti.put(atleta.getCodAtleta(), tesseramento);
	}
	
	
	//rimuove dalla mappa un tesseramento avente come chiave codAtleta.
	public void removeTesseramento(String codAtleta) throws AtletaNonPresenteException{
		if(this.tesseramenti.containsKey(codAtleta)) {
			this.tesseramenti.remove(codAtleta);
		}else {
			throw new AtletaNonPresenteException();
		}
	}
	
	
	public List<Tesserato> getCopiaListaTesseratiPerAnno(){
		
		List<Tesseramento> listaTesseratiOrdinati = new ArrayList<>();
		Iterator<Entry<String, Tesseramento>> itTesseramenti = this.tesseramenti.entrySet().iterator();
		Tesseramento tesseramento = null;
		Tesserato tesserato = null;
		List<Tesserato> copiaListaTesseratiPerAnno = new LinkedList<>();
		
		while(itTesseramenti.hasNext()) {
			listaTesseratiOrdinati.add(itTesseramenti.next().getValue());
		}
		
		listaTesseratiOrdinati.sort(new ComparatorTesseratiByAnno());
		Iterator<Tesseramento> itListaOrdinata = listaTesseratiOrdinati.iterator();
		while(itListaOrdinata.hasNext()) {
			copiaListaTesseratiPerAnno.add(itListaOrdinata.next().getCloneTesserato());
		}
		
		return copiaListaTesseratiPerAnno;
	}
	
	
	
	//ottengo una copia della lista dei tesseramenti ordinati per cognome
	public List<Tesseramento> getCopiaLIstaTesseramentiPerCognome(){
		Iterator<Entry<String, Tesseramento>> itTesseraementi = this.tesseramenti.entrySet().iterator();
		Tesseramento tesseramento = null;
		List<Tesseramento> listaCopia = new LinkedList<Tesseramento>();
		
		
		while(itTesseraementi.hasNext()) {
			tesseramento = itTesseraementi.next().getValue();
			listaCopia.add(tesseramento);
		}
		
		listaCopia.sort(new ComparatorTesseramentoByCognome());
		return listaCopia;
	}



	public String getCodFederazione() {
		return codFederazione;
	}



	public String getDenominazione() {
		return denominazione;
	}
	
	
	public boolean atletaIsTesserato(Atleta atleta) {
		boolean risultato = false;
		if(this.tesseramenti.containsKey(atleta.getCodAtleta())) {
			risultato = true;
		}else {
			risultato = false;
		}
		return risultato;
	}



	@Override
	public String toString() {
		return "Federazione [codFederazione=" + codFederazione + ", denominazione=" + denominazione + ", tesseramenti="
				+ tesseramenti + "]";
	}

	
}
