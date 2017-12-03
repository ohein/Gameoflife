import java.util.*;

public class Simulator {
	private Spielbrett spielbrett;

	public void starteSimulation(int anzahl_runden) {
		this.spielbrett = new Spielbrett();
		System.out.println(this.spielbrett);
		for (int i = 0; i < anzahl_runden; i++) {
			this.simuliereNaechsteRunde();
			System.out.println(this.spielbrett);
		}

	}

	private void simuliereNaechsteRunde() {
		// Wir müssen uns die an- und abzuschaltenden Birnen merken und dürfen
		// diese nicht bereits bei der Untersuchung des Spielfelds manipulieren.
		// Somit vermeiden wir Seiteneffekte.
		ArrayList<Birne> anschalten = new ArrayList<Birne>();
		ArrayList<Birne> abschalten = new ArrayList<Birne>();

		for (int i = 1; i < Spielbrett.DIMENSION - 1; i++) {
			for (int j = 1; j < Spielbrett.DIMENSION - 1; j++) {
				if (getAnzahlNachbarn(i, j) >= 2) {
					anschalten.add(spielbrett.getFeld(i, j));
				} else {
					abschalten.add(spielbrett.getFeld(i, j));
				}
			}
		}

		this.schalteAus(abschalten);
		this.schalteAn(anschalten);
	}

	private int getAnzahlNachbarn(int x, int y) {
		int anzahl = 0;
		// Da wir die DIMENSION um zwei Felder größer gewählt haben, müssen wir
		// an dieser Stelle nicht prüfen ob die Indizes x-1, x+1, y-1 und y+1
		// ausserhalb des Arrays liegen.
		// Wir arbeiten nur im inneren des Spielfelds und betrachten nicht den
		// Rand.
		if (spielbrett.getFeld(x - 1, y).istAngeschaltet())
			anzahl++;
		if (spielbrett.getFeld(x + 1, y).istAngeschaltet())
			anzahl++;
		if (spielbrett.getFeld(x, y - 1).istAngeschaltet())
			anzahl++;
		if (spielbrett.getFeld(x, y + 1).istAngeschaltet())
			anzahl++;

		return anzahl;
	}

	private void schalteAn(ArrayList<Birne> liste) {
		for (Birne birne : liste) {
			birne.schalteAn();
		}
	}

	private void schalteAus(ArrayList<Birne> liste) {
		for (Birne birne : liste) {
			birne.schalteAus();
		}
	}
}
