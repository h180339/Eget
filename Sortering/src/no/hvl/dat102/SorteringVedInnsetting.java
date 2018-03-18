package no.hvl.dat102;

import static java.util.Arrays.binarySearch;

public class SorteringVedInnsetting {


	public static  <T extends Comparable <T>> T[] sorter (T[] tab) {

		T[] hjelpeTab = (T[])(new Comparable[tab.length]);
		hjelpeTab[0] = tab[0];
		int antall = 1;

		for (int i = 1; i < tab.length; i++) {
			hjelpeTab = settInn(hjelpeTab, tab[i], antall);
			antall++;
		}


		/*for (int v = 0; v < hjelpeTab.length; v++) {
			System.out.print(hjelpeTab[v]);
		}*/

		return hjelpeTab;
	}
	private static <T extends Comparable <T>> T[] settInn(T[] tab, T el, int antall) {

		int index = 0;

		while(index < antall && el.compareTo(tab[index]) > 0) {
			index++;
		}
		//System.out.println("index : " + index + " antall : " + antall + " element: " + el);
		//System.out.println(tab.length);
		for (int i = antall - 1; i >= index; i--) {
		//	System.out.println("i: " + i);
			tab[i + 1] = tab[i];
		}
		tab[index] = el;

		/*for (int v = 0; v < tab.length; v++) {
			System.out.print(tab[v]);
		}
		System.out.println();*/
		return tab;
	}





}
