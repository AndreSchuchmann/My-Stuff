public class Hauptprogramm {

	public static int gibAnzahlSitze(Fahrzeug fahrzeug) {
		return fahrzeug.anzahlSitze;
	}

	/*
	 * Straﬂenbahn: Stromverbrauch in KW Bus: Benzinverbrauch in l pro 100 km
	 */
	public static double gibEnergieVerbrauch(Fahrzeug fahrzeug) {
		if (fahrzeug instanceof Strassenbahn) {
			return ((Strassenbahn) fahrzeug).leistungInKW;
		} else if (fahrzeug instanceof Bus) {
			return ((Bus) fahrzeug).dieselVerbrauch;
		} else {
			return -1.0;
		}
	}

	public static Fahrzeug gibFahrzeug(Fahrzeug[] fahrzeuge, int i) {
		return fahrzeuge[i];
	}

	public static void main(String[] args) {
		// Fahrzeug[] fahrzeuge = new Fahrzeug[10];

		/*
		 * fahrzeuge[0] = new Standardbus(101, 56,80.0,"MA-RN 98",18.3 );
		 * fahrzeuge[1] = new Strassenbahn(201, 120,100.0,500.0 ); fahrzeuge[2]
		 * = new Gelenkbus(102, 76,80.0,"MA-RN 99",18.3 );
		 */

		Fahrzeug[] fahrzeuge = {
				new Standardbus(101, 56, 80.0, "MA-RN 98", 18.3),
				new Strassenbahn(201, 120, 100.0, 500.0),
				new Gelenkbus(102, 76, 80.0, "MA-RN 99", 18.3) };

		for (int i = 0; i < fahrzeuge.length; i++) {
			if (fahrzeuge[i] != null) {
				System.out.println(fahrzeuge[i] + ":"
						+ gibAnzahlSitze(fahrzeuge[i]) + "Sitze, Verbrauch: " + gibEnergieVerbrauch(fahrzeuge[i]));
			}
		}
		
		System.out.println(((Strassenbahn)gibFahrzeug(fahrzeuge,1)).leistungInKW);
		
		Fahrzeug meineStrassenbahn = fahrzeuge[1];
		Fahrzeug deineStrassenbahn = new Strassenbahn(202, 120, 100.0, 500.0);

	}
}
