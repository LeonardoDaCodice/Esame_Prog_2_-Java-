package tesserato;

import atleta.Atleta;
import eccezioni.CodiceAltletaException;

public class Tesserato extends Atleta {

	private static int generateCode;
	private int codTesserato;
	
	public Tesserato(String codAtleta, String nome, String cognome) throws CodiceAltletaException {
		super(codAtleta, nome, cognome);
		this.codTesserato = generateCode;
		generateCode++;
	}

	public int getCodTesserato() {
		return codTesserato;
	}

	@Override
	public Object clone() {
		Object o = null;
		
		o = super.clone();
		return o;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + codTesserato;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tesserato other = (Tesserato) obj;
		if (codTesserato != other.codTesserato)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Tesserato [codTesserato=" + codTesserato + "," + super.toString() + "]";
	}
	
	

}
