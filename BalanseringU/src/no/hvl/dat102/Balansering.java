package no.hvl.dat102;

import no.hvl.dat102.Stabel.KjedetStabel;

import java.io.*;

public class Balansering {
	// Her opphever du kommentarsetning n�r du har f�tt lagt inn
	// n�dvendig kode
	// SirkulaerStabel<Parentesinfo>stabel = new
	// SirkulaerStabel<Parentesinfo>();

	KjedetStabel<Character> stabel = new KjedetStabel<>();


	private boolean passer(char Åpent, char lukket) {
		switch (Åpent) {
		case '(':
			return (lukket == ')');
		case '[':
			return (lukket == ']');
		case '{':
			return (lukket == '}');
		default:
			return false;
		}
	}//

	public void foretaBalansering(String innDataStreng, int linjenr) {

		//int lengde = innDataStreng.length();

		char[] tab = innDataStreng.toCharArray(); //GJØR STRENGEN OM TIL TABELL
		/*
		for(char bar: tab) {
			System.out.print(bar);
		}
		System.out.println();
		*/


		for(int index = 0; index < tab.length; index++) {

			if (tab[index] == '{' || tab[index] == '[' || tab[index] == '(') { //PUSHER VENSTRE PARANTESENE INN I STABELEN
				stabel.push(tab[index]);

			}else if (tab[index] == '}' || tab[index] == ']' || tab[index] == ')') { //SJEKKER OM SLUTTPARANTESENE PASSER MED DET SOM ER I STABELEN
				if (stabel.erTom()) { //SJEKKER OM STABELEN ER TOM
					System.out.println("Lukkesymbol '" + tab[index] + "'på linje "+ linjenr + " tegn nr: " + index +" mangler åpnesymbol");
				}else {
					char foo = stabel.pop();
					if (!passer(foo, tab[index])) { //SJEKKER OM PARANTESEN PASSER MED DEN SOM ER LAGRET I STABELEN
						System.out.println("Lukkesymbol '" + tab[index] + "'på linje "+ linjenr + " tegn nr: " + index +" har feil åpnesymbol");
					}
				}
			}
		}

		// Fyll ut

	}//

	public void lesFraFil(String filnavn) {
		FileReader tekstFilLeser = null;
		try {
			tekstFilLeser = new FileReader(filnavn);
		} catch (FileNotFoundException unntak) {
			System.out.println("Finner ike filen!");
			System.exit(-1);
		}

		BufferedReader tekstLeser = new BufferedReader(tekstFilLeser);
		String linje = null;
		int linjenr = 1;
		try {
			linje = tekstLeser.readLine();
			while (linje != null) {
				// kalle metode her!
				// Fyll ut
				foretaBalansering(linje, linjenr);
				linjenr++;
				linje = tekstLeser.readLine();


			} // while
			if (!stabel.erTom()) {
				System.out.println("stabel er ikke tom");
				System.out.println(stabel.pop());
			}
		}

		catch (IOException unntak) {
			System.out.println("Feil ved innlesing!");
			System.exit(-1);
		}
		try {
			tekstFilLeser.close();
		} catch (IOException unntak) {
			System.out.println("Feil ved lukking av fil!");
		}

	}// metode

}// class
