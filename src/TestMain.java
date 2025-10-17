import java.util.List;

import atleta.Atleta;
import catalogo.Catalogo;
import eccezioni.CodiceAltletaException;
import eccezioni.FederazioneGiaCatalogataException;
import federazione.Federazione;
import federazione.ModalitaPagamento;
import federazione.Tesseramento;
import tesserato.Tesserato;

public class TestMain {

	public static void main(String[] args) {

		Atleta atleta1 = null;
		Atleta atleta2 = null;
		Atleta atleta3 = null;
		Atleta atleta4 = null;

		Federazione federazione1 = new Federazione("Federazione_Calcistica");
		Federazione federazione2 = new Federazione("Federazione_Nuoto");
		Catalogo catalogo = new Catalogo();
		
		//aggiungo le federazioni nel catalogo.
		try {
			catalogo.addFederazione(federazione1);
		} catch (FederazioneGiaCatalogataException e) {
			System.out.println(e.getMessage());
		}
		try {
			catalogo.addFederazione(federazione2);
		} catch (FederazioneGiaCatalogataException e) {
			System.out.println(e.getMessage());
		}
		
		
		//istanzio gli atleti.
		try {
			 atleta1 = new Atleta("QQQQQQQ", "Mario", "Rossi");
		} catch (CodiceAltletaException e) {
			System.out.println(e.getMessage());
		}
		try {
			 atleta2 = new Atleta("QQQQQQ1", "Dario", "Verdi");
		} catch (CodiceAltletaException e) {
			System.out.println(e.getMessage());
		}
		try {
			atleta3 = new Atleta("QQQQQQ2", "Sario", "Blasi");
		} catch (CodiceAltletaException e) {
			System.out.println(e.getMessage());
		}
		try {
			atleta4 = new Atleta("QQQQQQ3", "Carlo", "Magno");
		} catch (CodiceAltletaException e) {
			System.out.println(e.getMessage());
		}
		
		
		//verifico se l'atleta risulti gia' tesserato consultando il catalogo delle federazioni.
		//e successivamente effettuo il tesseramento dell'atleta presso la federazione.
		if(catalogo.atletaIsGiaTesserato(atleta1) == false) {
		try {
			federazione1.addTesseramento(atleta1, 15, ModalitaPagamento.Bonifico_Bancario.toString());
		} catch (CodiceAltletaException e) {
			System.out.println(e.getMessage());
		}
		}
		
		if(catalogo.atletaIsGiaTesserato(atleta2) == false) {
		try {
			federazione1.addTesseramento(atleta2, 21, ModalitaPagamento.Carta_Di_Credito.toString());
		} catch (CodiceAltletaException e) {
			System.out.println(e.getMessage());
		}
		}
		
		if(catalogo.atletaIsGiaTesserato(atleta3) == false) {
		try {
			federazione2.addTesseramento(atleta3, 25, ModalitaPagamento.Carta_Di_Credito.toString());
		} catch (CodiceAltletaException e) {
			System.out.println(e.getMessage());
		}
		}
		
		if(catalogo.atletaIsGiaTesserato(atleta4) == false) {
		try {
			federazione2.addTesseramento(atleta4, 30, ModalitaPagamento.Contanti.toString());
		} catch (CodiceAltletaException e) {
			System.out.println(e.getMessage());

		}
		}
		
		
		//ottengo una copia della lista dei Tesserati e stampo i tesserati ordinati per cognome.
		List<Tesseramento> tesseramentiFed1PerCognome = federazione1.getCopiaLIstaTesseramentiPerCognome();
		System.out.println(tesseramentiFed1PerCognome.toString());
		
		//ottengo una copia della lista dei Tesseramenti e stampo i tesseramenti ordinati per anno.
		List<Tesserato> tesseratiOrdinatiPerAnno = federazione2.getCopiaListaTesseratiPerAnno();
		System.out.println(tesseratiOrdinatiPerAnno.toString());
	}

}
