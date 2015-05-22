
public class Travelling_Saler_Men {
	
	public static void main(String[] args) {
		
		/**
		 * Autor des Programmes: André Schuchmann
		 * 
		 * Im unteren Bereich wird der Konstruktor aufgebaut und ebenfalls die Arrays generiert. Hierbei sollen 
		 * die Zahlen für die Städte stehen
		 * In der ersten Aufgabe wird die Stadt per Zufall generiert und von diesem Wert wird die Distanz
		 * berechnet
		 * 
		 * In der zweiten Aufgabe haben wir zwei feste Arrays für zwei verschiedene Städte. 
		 * 
		 * Aufgabe dreiberechnet eine zufällige Strecke während dem roadtrip. hierbei wird nach dem kürzeste
		 * Weg gesucht!
		 */

		// Declaration of the Arrays Cities and Cities 2
		
		int[][] distances = generateDistances(10); //Aufgabe 1 
		printDistances(distances);
		int[] cities = { 2, 5, 7, 9, 10, 8, 4  }; //Aufgabe 2
		int[] cities2 = { 2, 5, 7, 9, 10, 8, 4 }; // Aufgabe2

		// Compare the Arrays Cities and Cities2 
		// The Arrays must have the same Distance to each other, doesn´t matter from which side
		System.out.println("Abstände der Staedte gleich?? " + cities.equals(cities2));
		printCities(cities);
		System.out.println("roundtrip Distance: " + getDistance(cities, distances));

		cities = changeCities(cities);
		printCities(cities);

		int distance = getDistance(cities, distances);

		// Aufgabe 3 Change cities while roadtrip
		
		/*boolean change = true;
		do {
			int[] citiesNew = changeCities(cities);
			int distanceNew = getDistance(citiesNew, distances);
			if (distanceNew < distance) {
				cities = citiesNew;
				distance = getDistance(citiesNew, distances);
				System.out.println("Distance: " + distance);
			}
			else{
				System.out.println("Distance: " + distance + " Still searching...");
			}
		}while(change);*/
		

	}
 
	// Aufgabe 2
	public static int[][] generateDistances(int cities) {
		int[][] distances = new int[cities][cities];
		for (int i = 0; i < distances.length; i++) {
			for (int j = 0; j < distances.length; j++) {
				if (i == j) {
					distances[j][i] = 0;
				} else if (distances[j][i] != 0) {
					distances[i][j] = distances[j][i];
				} else {
					int distance = getRandomDistance();
					distances[i][j] = distance;
					distances[j][i] = distance;
				}
			}
		}
		return distances;
	}

	// Aufgabe 2
	public static int getDistance(int[] cities, int[][] distances) {
		int distance = 0;
		if (cities.length > 1) {
			for (int i = 0; i < cities.length - 1; i++) {
				distance = distance
						+ distances[cities[i] - 1][cities[i + 1] - 1];
			}
		}
		return distance;
	}

	public static int[] changeCities(int[] cities) {
		int randomCity1 = -1;
		int randomCity2 = -1;
		while (randomCity1 == randomCity2) {
			randomCity1 = getRandomCity(cities);
			randomCity2 = getRandomCity(cities);
		}
		int tmpCity1 = cities[randomCity1];
		int tmpCity2 = cities[randomCity2];
		cities[randomCity1] = tmpCity2;
		cities[randomCity2] = tmpCity1;
		return cities;
	}

	public static int getRandomCity(int[] cities) {
		int city = (int) (Math.random() * cities.length);
		return city;
	}

	public static void printDistances(int[][] distances) {
		System.out.println("Distance table");

	
		for (int i = 0; i < distances.length; i++) {
		
			for (int j = 0; j < distances.length; j++) { //GANZE TABELLE
				if (distances[i][j] < 10) {
					System.out.print(" ");
				}
				System.out.print(distances[i][j] + " ");
			}
			System.out.println();
		}
	}

	// Aufgabe 1
	public static void printCities(int[] cities) {
		System.out.println("Cities: ");
		for (int i = 0; i < cities.length; i++) {
			System.out.print(cities[i] + " ");
		}
		System.out.println();
	}

	public static int getRandomDistance() {
		int randomDistance = 0;
		while (randomDistance == 0) {
			randomDistance = (int) (Math.random() * 100);
		}
		return randomDistance;
	}

}



