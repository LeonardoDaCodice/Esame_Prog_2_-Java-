package atleta;

import eccezioni.CodiceAltletaException;

public class Atleta implements Cloneable{
	
	private String codAtleta;
	private String nome;
	private String cognome;
	
	
	public Atleta(String codAtleta, String nome, String cognome)throws CodiceAltletaException {
		super();
		setCodAtleta(codAtleta);
		this.nome = nome;
		this.cognome = cognome;
	}


	public String getCodAtleta() {
		return codAtleta;
	}


	public void setCodAtleta(String codAtleta) throws CodiceAltletaException {
		if(codAtleta.length() != 7) {
			throw new CodiceAltletaException();
		}
		this.codAtleta = codAtleta;
	}


	public String getNome() {
		return nome;
	}


	public String getCognome() {
		return cognome;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codAtleta == null) ? 0 : codAtleta.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Atleta other = (Atleta) obj;
		if (codAtleta == null) {
			if (other.codAtleta != null)
				return false;
		} else if (!codAtleta.equals(other.codAtleta))
			return false;
		return true;
	}


	@Override
	public Object clone() {
	
		Object o = null;
		try {
			o = super.clone();
		} catch (CloneNotSupportedException e) {

		System.out.println("Clonazione non supportata!");
		}
		
		return o;
	}


	@Override
	public String toString() {
		return "Atleta [codAtleta=" + codAtleta + ", nome=" + nome + ", cognome=" + cognome + "]\n";
	}
	
	
	
	

}
