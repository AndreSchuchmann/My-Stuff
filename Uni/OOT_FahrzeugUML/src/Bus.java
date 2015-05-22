public class Bus extends Fahrzeug {
	String kennzeichen;
	double dieselVerbrauch;

	public Bus(int fahrzeugnummer, int anzahlSitze, double hoechstgeschwindigkeit, String kennzeichen, double dieselVerbrauch) {
		super(fahrzeugnummer, anzahlSitze, hoechstgeschwindigkeit);
		this.kennzeichen = kennzeichen;
		this.dieselVerbrauch = dieselVerbrauch;
	}
}
