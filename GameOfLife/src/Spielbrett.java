
public class Spielbrett {
	/**
	 * In DIMENSION wird die Größe des Arrays gespeichert. Die Dimension wird in
	 * der Breite und Höhe zwei Felder größer gewählt, damit später nicht
	 * geprüft werden muss ob wir uns am Rand befinden.
	 */
	public static final int DIMENSION = 12;
	private Birne[][] felder = new Birne[DIMENSION][DIMENSION];

	public Spielbrett() {
		// Array initialisieren
		for (int i = 0; i < DIMENSION; i++) {
			for (int j = 0; j < DIMENSION; j++) {
				felder[i][j] = new Birne();
			}
		}

		// Die Glühbirnen aus der Aufgabenstellung anschalten
		felder[2][3].schalteAn();
		felder[3][3].schalteAn();
		felder[3][2].schalteAn();
		felder[4][3].schalteAn();
		felder[3][4].schalteAn();
	}

	/**
	 * Diese Methode gibt und genau eine Birne des Spielbretts zurück.
	 */
	public Birne getFeld(int x, int y) {
		return this.felder[x][y];
	}

	/**
	 * Überschreiben der Methode toString() aus der Klasse Object, damit wir ein
	 * Objekt dieser Klasse direkt in Sytem.out.println() verwenden können.
	 */
	public String toString() {
		String ret = "";

		for (int i = 1; i < DIMENSION - 1; i++) {
			for (int j = 1; j < DIMENSION - 1; j++) {
				ret = ret + this.felder[i][j];
			}
			ret += "\n";
		}
		return ret;
	}

}
