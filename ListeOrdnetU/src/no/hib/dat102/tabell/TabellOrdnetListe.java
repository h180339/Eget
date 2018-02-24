package no.hib.dat102.tabell;

import no.hib.dat102.adt.OrdnetListeADT;


public class TabellOrdnetListe<T extends Comparable<T>> implements OrdnetListeADT<T> {
	
	private final static int STDK = 100;
	private final static int IKKE_FUNNET = -1;
	private int bak;
	private T[] liste;

	public TabellOrdnetListe() {
		this(STDK);
	}

	public TabellOrdnetListe(int startKapasitet) {
		bak = 0;
		liste = (T[]) (new Comparable[startKapasitet]);
	}

	@Override
	public T fjernSiste() {
		T resultat = null;
		if(erTom()) {
			return resultat;
		}else {
			resultat = liste[bak -1];
			liste[bak - 1] = null;
			bak--;
		}

		return resultat;
	}

	@Override
	public T fjernFoerste() {
		T resultat = null;
		if (erTom()) {
			return resultat;
		} else {
			resultat = liste[0];
			for (int i = 0; i < bak; i++) {
				if (liste[i + 1] != null) {
					liste[i] = liste[i +1];
				}else {
					liste[i] = null;
				}
			}

		}
		bak--;
		return resultat;
	}

     @Override
	public T foerste() {
		T resultat = null;
		if (!erTom()){
			resultat = liste[0];
		}
		return resultat;
	}

	@Override
	public T siste() {
		T resultat = null;
		//...Fyll ut
		
	return resultat;
	}

	@Override
	public boolean erTom() {
		return (bak == 0);
	}

	@Override
	public int antall() {
		return bak;
	}
	
    @Override
	public void leggTil(T element) {
		if (bak >= liste.length) {
			utvid();
		}
		if (bak == 0) {
			liste[0] = element;
			bak++;
		}else {
			for (int i= 0; i <= bak; i++) {
				if (element.compareTo(liste[i]) < 0 || (i == (bak -1))) {
					if (i == (bak -1) && element.compareTo(liste[i]) >=0 ) {
						liste[bak] = element;
						break;
					}else {
						for (int c = bak; c > i; c--) {
							liste[c] = liste[c -1];
						}
						liste[i] = element;
						break;
					}
				}
			}
			bak++;
		}
	}

	
	@Override
	public boolean inneholder(T element) {
		return (finn(element) != IKKE_FUNNET);
	}

	@Override
	public T fjern(T element) {
		int index = finn(element);
		if (index == -1) {
			return null;
		}
		if (index == (bak - 1)) {
			liste[index] = null;
			bak--;
		}else {
			for (int i = index; i < bak; i++) {
				if (liste[i + 1] != null) {
					liste[i] = liste[i +1];
				}else {
					liste[i] = null;
				}
			}
			bak--;
		}

		return element;
	}		

	private int finn(T el) {
		int i = 0, resultat = IKKE_FUNNET;
		int lav = 0, hoy = bak - 1;
		while (lav <= hoy) {
			int midt = (lav + hoy) / 2;
			if (el.compareTo(liste[midt]) > 0) {
				lav = midt + 1;
			}
			else if (el.compareTo(liste[midt]) < 0) {
				hoy = midt - 1;
			}
			else {
				return midt;
			}
		}
		return resultat;
	}

	public String toString() {
		String resultat = "";

		for (int i = 0; i < bak; i++) {
			resultat = resultat + liste[i].toString() + "\n";
		}
		return resultat;
	}


	private void utvid() {
		T[] hjelpeTabell = (T[]) (new Object[liste.length * 2]);

		for (int i = 0; i < liste.length; i++){
			hjelpeTabell[i] = liste[i];
		}
		
		liste = hjelpeTabell;
	}

}// class
