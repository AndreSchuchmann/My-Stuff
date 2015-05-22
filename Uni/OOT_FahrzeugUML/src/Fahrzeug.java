public class Fahrzeug {
	int fahrzeugnummer;
	int anzahlSitze;
	double hoechstgeschwindigkeit;

	public Fahrzeug(int fahrzeugnummer, int anzahlSitze, double hoechstgeschwindigkeit) {
		this.fahrzeugnummer = fahrzeugnummer;
		this.anzahlSitze = anzahlSitze;
		this.hoechstgeschwindigkeit = hoechstgeschwindigkeit;
	}

	public String toString() {
		return "" + fahrzeugnummer;
	}
}
