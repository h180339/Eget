package no.hib.dat102.listeklient;

public class Person implements Comparable<Person> {
	private String fornavn, etternavn;
	private int fodselsaar;

	public Person (String fornavn, String etternavn, int fodselsaar) {
		this.fornavn = fornavn;
		this.etternavn = etternavn;
		this.fodselsaar = fodselsaar;
	}

	public String getFornavn() {
		return this.fornavn;
	}

	public String getEtternavn() {
		return this.etternavn;
	}

	public int getFodselsaar() {
		return this.fodselsaar;
	}

	public int compareTo(Person andrePers) {
		if (this.fodselsaar < andrePers.getFodselsaar()) {
			return -1;
		}else if(this.fodselsaar > andrePers.getFodselsaar()) {
			return 1;
		}else {//sjekker etter navn hvis fødselsår er lik
			String denneNavn = this.etternavn + this.fornavn;
			String andrePersNavn = andrePers.getEtternavn() + andrePers.getFornavn();
			if (denneNavn.compareTo(andrePersNavn) > 0) {
				return -1;
			}else if(denneNavn.compareTo(andrePersNavn) < 0) {
				return 1;
			}else {
				return 0;
			}
		}
	}

	public String toString() {
		return this.etternavn + " " + this.fornavn + " " + this.fodselsaar;
	}
}
