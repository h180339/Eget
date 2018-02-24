package no.hib.dat102.listeklient;

import no.hib.dat102.tabell.TabellOrdnetListe;

public class KlientPerson {

	public static void main(String[] args ) {

		Person p1 = new Person("eirik", "Alvestad", 1992);
		Person p2 = new Person("joakim", "Andås", 1992);
		Person p3 = new Person("Orjan", "enes", 1900);


		TabellOrdnetListe<Person> tab = new TabellOrdnetListe<>();

		tab.leggTil(p2);
		tab.leggTil(p1);
		tab.leggTil(p3);
		System.out.println(tab);
	}





}
