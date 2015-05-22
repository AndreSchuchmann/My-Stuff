public class Liste {
	public static void main(String[] args) {
		
		IntList2 a = new IntList2();
		IntList2 b = new IntList2();
		
		// List a
		
		a.addFirst(1);
        a.addLast(2);
        a.addLast(3);
        a.addLast(4);
        a.addLast(5);
        a.addLast(6);
        a.addLast(7);
        a.addLast(9);
        a.addLast(10);
        
        System.out.println("Liste A lautet: "+ a);
        System.out.println();
        
        System.out.println("Liste B lautet: "+ b);
       
	
		// List b
		
		b.addLast(2);
		b.addLast(3);
		b.addLast(4);
		b.addLast(5);
		b.addLast(7);
		b.addLast(9);
		
		System.out.print(b);
		
		b.removeLast();
		System.out.println();
		System.out.println();
		System.out.print("getLast-Methode (angewand an Liste a): " + a.getLast()); // hängt die letzte zahl von liste a an die erste stelle von b
		System.out.println();
		System.out.println("getFirst-Methode (angewand an Liste a) : " +a.getFirst());
		
		
		System.out.println();
		System.out.println();
		System.out.println("Die neu verbundene Liste (a+b) lautet: ");
		a.concat(b); // verbindet die liste a + b
		a.print();
		System.out.println();
		System.out.println();
		System.out.println("Anzahl der Elemente in der neuen Liste lautet: " + a.size());
		
		System.out.println();
		System.out.println("Ueberpruefung ob gewisse Elemente in der neuen Liste vorhanden sind: ");
		System.out.println(b.contains(2)); // zeigt welche elemente in der neuen liste enthalten sind
		System.out.println(b.contains(22));
		
		
		b.clear();
		b.addFirst(0); // dient zum beweis das die liste b gelöscht wurde
		System.out.println();
		System.out.println("Hier die gelöschte Liste (die 0 dient als Beweis dass die Liste leer ist):");
		b.print();
		System.out.println();
		
		
	}
}