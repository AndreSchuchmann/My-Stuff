

public class Hauptprogramm {

	public static Comparable max(Comparable c1, Comparable c2) {
		if (c1.greaterThan(c2)) {
			return c1;
		} else if (c1.equals(c2)) {
			return c1;
		} else {
			return c2;
		}
	}
	
	public static Comparable max(Comparable c1, Comparable c2, Comparable c3) {
		return max(max(c1,c2),c3);
	}
	
	public static void meinSort(Comparable[] meinArray) {
		for (int i=0; i<meinArray.length; i++) {
			for (int j=i+1; j<meinArray.length; j++) {
				if (meinArray[i].greaterThan(meinArray[j])) {
					Comparable help = meinArray[i];
					meinArray[i]=meinArray[j];
					meinArray[j]=help;
				}
			}
		}
	}

	public static void main(String[] args) {
		System.out.println(max(new Geldbetrag(14, 3), new Geldbetrag(14, 0)));
		System.out.println(max(new Zeichenkette("Thomas"), 
				new Zeichenkette("Stefan")));
		
		System.out.println(max(new Geldbetrag(14, 3), new Geldbetrag(14, 0), new Geldbetrag(14, 9)));

	   Geldbetrag[] meinGeld = { new Geldbetrag(14, 3),  new Geldbetrag(14, 0),  new Geldbetrag(14, 9) };
	   System.out.println();
	   meinSort(meinGeld);
	   for (int i=0; i<meinGeld.length; i++) {
		   System.out.println(meinGeld[i]);
	   }
	   
	}

}
