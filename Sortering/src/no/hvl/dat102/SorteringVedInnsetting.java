package no.hvl.dat102;

import static java.util.Arrays.binarySearch;

public class SorteringVedInnsetting <T> {

	T[] tab;
	int antall;

	public SorteringVedInnsetting (int antallPlasser) {

		this.tab = (T[])(new Object[antallPlasser]);
		this.antall = 0;

	}
	/*
	public static void main (String [] args) {

		Integer[] tab = new Integer[20];


	}
	*/

	public void settInn (T el) {

		if (antall == 0) { //setter inn første element
			this.tab[0] = el;
		}

		int index = binarySearch(tab, el); //finner posisjon av
		if (index >= 0) { //elementet er i tabellen allerede
			System.out.println("Yes");
		}


	}


}
