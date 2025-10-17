package federazione;

import java.time.LocalDate;

import tesserato.Tesserato;

public class Tesseramento {
	
	private int costoTesseramento;
	private String modPagamento;
	private String annoTesseramento;
	private Tesserato tesserato;
	
	
	
	public Tesseramento(int costoTesseramento, String modPagamento, Tesserato tesserato) {
		super();
		this.costoTesseramento = costoTesseramento;
		this.modPagamento = modPagamento;
		this.tesserato = tesserato;
		this.annoTesseramento = ""+LocalDate.now().getYear();
	}



	public int getCostoTesseramento() {
		return costoTesseramento;
	}



	public String getModPagamento() {
		return modPagamento;
	}



	public String getAnnoTesseramento() {
		return annoTesseramento;
	}



	public Tesserato getCloneTesserato() {
		return (Tesserato) tesserato.clone();
	}



	@Override
	public String toString() {
		return "Tesseramento [costoTesseramento=" + costoTesseramento + ", modPagamento=" + modPagamento
				+ ", annoTesseramento=" + annoTesseramento + ", tesserato=" + tesserato + "]";
	}
	
	
	

}
