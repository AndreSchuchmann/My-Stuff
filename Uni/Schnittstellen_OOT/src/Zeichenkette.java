

public class Zeichenkette implements Comparable {
	public String stringInhalt;
	
	public Zeichenkette(String inhalt) {
		this.stringInhalt = inhalt;
	}

	public boolean greaterThan(Object o) {
		if (o instanceof Zeichenkette) {
			Zeichenkette oZeichenkette = (Zeichenkette) o;
			return stringInhalt.compareTo(oZeichenkette.stringInhalt) > 0;
		} else {
			return false;
		}
	}

	public boolean equals(Object o) {
		if (o instanceof Zeichenkette) {
			Zeichenkette oZeichenkette = (Zeichenkette) o;
			return stringInhalt.equals(oZeichenkette.stringInhalt);
		} else {
			return false;
		}
	}
	
	public String toString() {
		return stringInhalt;
	}
}
