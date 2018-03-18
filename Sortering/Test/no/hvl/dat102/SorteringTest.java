package no.hvl.dat102;

import org.junit.Test;

import static org.junit.Assert.*;

public class SorteringTest {

	@Test
	public void SorteringVedInnsettingTest() {


		Integer[] tab = {3, 2, 5, 9, 0, 10 , 4, 8};

		Object [] tabell =  SorteringVedInnsetting.sorter(tab);

		for (Object i: tabell) {
			System.out.print("|" + i + "|");
		}

	}

}