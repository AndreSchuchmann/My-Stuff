
public class Strassenbahn extends Fahrzeug {
  double leistungInKW;
  
	public Strassenbahn(int fahrzeugnummer, int anzahlSitze, double hoechstgeschwindigkeit, double leistungInKW) {
		super(fahrzeugnummer, anzahlSitze, hoechstgeschwindigkeit);
		this.leistungInKW = leistungInKW;

	}
}
