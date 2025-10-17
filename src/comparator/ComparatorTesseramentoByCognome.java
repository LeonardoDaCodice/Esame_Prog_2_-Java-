package comparator;

import java.util.Comparator;

import federazione.Tesseramento;

public class ComparatorTesseramentoByCognome implements Comparator<Tesseramento> {

	@Override
	public int compare(Tesseramento o, Tesseramento o1) {
		if(o.getAnnoTesseramento().compareTo(o1.getAnnoTesseramento()) < 0) {
			return -1;
		}else if(o.getAnnoTesseramento().compareTo(o1.getAnnoTesseramento()) > 0) {
			return 1;
		}else {
			return 0;
		}
	}

}
