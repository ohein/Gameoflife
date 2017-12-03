
public class Spielbrett {
	/**
	 * In DIMENSION wird die Gr��e des Arrays gespeichert. Die Dimension wird in
	 * der Breite und H�he zwei Felder gr��er gew�hlt, damit sp�ter nicht
	 * gepr�ft werden muss ob wir uns am Rand befinden.
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

		// Die Gl�hbirnen aus der Aufgabenstellung anschalten
		felder[2][3].schalteAn();
		felder[3][3].schalteAn();
		felder[3][2].schalteAn();
		felder[4][3].schalteAn();
		felder[3][4].schalteAn();
	}

	/**
	 * Diese Methode gibt und genau eine Birne des Spielbretts zur�ck.
	 */
	public Birne getFeld(int x, int y) {
		return this.felder[x][y];
	}

	/**
	 * �berschreiben der Methode toString() aus der Klasse Object, damit wir ein
	 * Objekt dieser Klasse direkt in Sytem.out.println() verwenden k�nnen.
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
