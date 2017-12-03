
public class Birne {
	private boolean an = false;

	public boolean istAngeschaltet() {
		return this.an;
	}

	public void schalteAus() {
		this.an = false;
	}

	public void schalteAn() {
		this.an = true;
	}

	public String toString() {
		if (this.istAngeschaltet())
			return "X";
		else
			return ".";
	}
}
