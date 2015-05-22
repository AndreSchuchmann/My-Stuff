/**
 * Diese Klasse zeigt kompletten Source-Code von Beispielen, die in der
 * Vorlesung gezeigt werden. Es werden bewusst nicht alle Eigenschaften von Java
 * genutzt, da diese zum Zeitpunkt der Vorlesung offiziell nicht bekannt sind.
 * </p> Java-Exception können nicht genutzt werden, da sie im ersten Semester
 * nicht vorgesehen sind. Deshalb werden Ausnahmen (Fehlerzustände) durch die
 * Rückgabe von -1 gekennzeichnet. Daraus folgt, dass in dieser Liste nur Zahlen
 * >= 0 gespeichert werden sollten.
 * 
 * @author Markus Gumbel
 * @version public
 */
public class IntList2 {

	/**
	 * Listenkopf.
	 */
	IntNode head = null;

	/**
	 * Falls bereits ein Element in neuer Liste sein soll.
	 * 
	 * @param value
	 *            Wert des ersten Elements.
	 */
	public IntList2(int value) {
		head = new IntNode(value, null);
	}

	public IntList2() {
	}

	public void addFirst(int value) {
		IntNode element = new IntNode();
		element.value = value;
		element.next = head;
		// Alternativ: ... new IntNode(value, head);
		head = element;
	}

	/**
	 * Fügt ein Element an das Ende der Liste an. Alternative Implementierung.
	 * 
	 * @param value
	 *            Element, das eingefügt werden soll.
	 */
	public void addLast(int value) {
		IntNode element = new IntNode(); // Erzeuge Knoten
		element.value = value;
		element.next = null;
		// Das Ende der Liste suchen:
		IntNode p = head;
		if (p == null) {// Leere Liste?
			head = element;
		} else { // Liste enthält Elemente
			while (p.next != null) {
				p = p.next;
			}
			// Füge am Ende an:
			p.next = element;
		}
	}

	/**
	 * Überprüft, ob die Liste Elemente enthält.
	 * 
	 * @return Wahr, wenn die Liste leer ist, falsch sonst.
	 */
	public boolean isEmpty() {
		// Es könnte auch überprüft werden, ob size() 0 liefert,
		// dieser Test ist jedoch schneller:
		return head == null;
	}

	/**
	 * @return Der Wert des ersten Elements oder -1, wenn die Liste leer ist.
	 */
	public int getFirst() {
		if (isEmpty())
			return -1;
		return head.value;
	}

	/**
	 * @return Der Wert des letzten Elements oder -1, wenn die Liste leer ist.
	 */
	public int getLast() {
		if (isEmpty()) {
			return -1;
		}
		IntNode l = head;
		while (l.next != null) {
			l = l.next;
		}
		return l.value;

	}

	/**
	 * Entfernt das erste Element aus der Liste.
	 * 
	 * @return Der Wert des ersten Elements oder -1, wenn die Liste leer ist.
	 */
	public int removeFirst() {
		if (isEmpty())
			return -1;
		return 0;
	}

	/**
	 * Entfernt das letzte Element aus der Liste.
	 * 
	 * @return Der Wert des letzten Elements oder -1, wenn die Liste leer ist.
	 */
	public int removeLast() {
		if (isEmpty()) {
			return -1;
		}
		if (this.size() == 1) {
			this.head = null;
			return 0;
		}

		IntNode l = head;
		while (l.next.next != null) {
			l = l.next;
		}
		l.next = null;
		return 0;
	}

	/**
	 * @param idx
	 * @return Wert an Position <code>idx</code> oder -1 im Fehlerfall, wenn der
	 *         Index ungültig ist.
	 */
	public int getAt(int idx) {
		if (idx < 0 || idx >= this.size()) {
			return -1;
		} else {
			IntNode l = head;
			while (idx > 0) {
				l = l.next;
				idx--;
			}
			return l.value;
		}
	}

	/**
	 * Überschreibe den Wert an Position <code>idx</code> mit <code>value</code>
	 * . Es wird eine Fehlermeldung ausgegeben, wenn <code>idx</code> eine
	 * üngültige Position ist.
	 * 
	 * @param idx
	 * @param value
	 */
	public void setAt(int idx, int value) {
		if (idx < 0 || idx >= this.size()) {
			System.out.println(value + " konnte nicht an Position " + idx
					+ " geschrieben werden");
		} else {
			IntNode l = head;
			while (idx > 0) {
				l = l.next;
				idx--;
			}
			l.value = value;
		}

	}

	public void remove(int e) {
		// NOCH NICHT IMPLEMENTIERT!
	}

	public int removeAt(int idx) {
		System.out.println("an position " + idx + " soll " + this.getAt(idx)
				+ " entfernt werden");
		if (idx < 0 || idx >= this.size()) {
			return -1;
		} else if ((idx + 1) == size()) {
			return removeLast();
		} else {
			IntNode l = head;
			while (idx > 0) {
				l = l.next;
				idx--;
			}
			int value = l.value;
			l.value = l.next.value;
			l.next = l.next.next;
			return value;
		}
	}

	/**
	 * Fügt eine andere Liste an das Ende dieser Liste an. Achtung! Die
	 * angefügte Liste könnte auch weiterhin doppelt verwendet werden. Das wird
	 * hier NICHT gemacht, statt dessen wird die ursprüngliche Liste geleert.
	 * Aufgabe der Methode: Fügt listen zusammen! (a+b)
	 * 
	 * @param otherList
	 *            Die andere Liste.
	 */
	// @SuppressWarnings("unused")
	public void concat(IntList2 otherList) {

		if (this.head == null) {
			this.head = otherList.head;
		} else {
			IntNode l = head;
			while (l.next != null) {
				l = l.next;
			}
			l.next = otherList.head;
		}
	}

	public int longestSequenceSize() {

		if (this.size() > 0) {

			int countCurrent = 1;
			int countMax = 1;
			IntNode l = this.head;
			while (l.next != null) {
				if (l.value == l.next.value) {
					countCurrent++;
					if (countCurrent > countMax) {
						countMax = countCurrent;
					}
				} else {
					countCurrent = 1;
				}
				l = l.next;
			}
			return countMax;
		}
		return 0;
	}

	/**
	 * Überprüft, ob der der Wert <code>value</code> in der Liste enthalten ist.
	 * Aufgabe der Methode: Soll die neue Liste nach gewissen Elementen suchen
	 * 1. Ueberprüfung: Ist die Liste leer? 2. Hier geht die Methode durch die
	 * Liste und sucht nach dem gewünschten Element. Es ist verhanden == true 3.
	 * Ist das Element nicht in der Liste vorhanden, gibt es false aus
	 * 
	 * @param value
	 * @return
	 */
	public boolean contains(int value) {
		if (isEmpty())
			return false;
		IntNode l = head;
		while (l.next != null) {
			if (l.value == value) {
				return true;
			}
			l = l.next;
		}
		if (l.value == value) {
			return true;
		}
		return false;
	}

	/**
	 * Entfernt alle Elemente aus der Liste. Aufgabe der Methode: Es soll die
	 * Liste b löschen. Die Ausgegebene 0 dient als Beweis es ueberprüft den
	 * head ob es ungleich null ist und wenn ja kommt die RemoveLast-Methode
	 */
	public void clear() {

		while (this.head != null) {
			this.removeLast();
		}
	}

	/**
	 * @return Anzahl der Elemente in der Liste. Aufgabe der Methode: Hier wird
	 *         die Länge der neuen Liste (a+b) ermittelt.
	 */
	public int size() {
		int s = 0;
		if (this.head != null) {
			IntNode l = head;
			s++;
			while (l.next != null) {
				s++;
				l = l.next;
			}
		}
		return s;
	}

	/**
	 * Gibt die Liste auf die Console aus.
	 */
	public void print() {
		System.out.print("( ");
		IntNode p = head;
		while (p != null) {
			p.print();
			System.out.print(" ");
			p = p.next;
		}
		System.out.print(")");
	}

	public String toString() {
		// Anmerkung: StringBuffer wäre die bessere Lösung. Egal.
		String text = "";
		IntNode p = head;
		while (p != null) {
			text += p.toString() + " ";
			p = p.next;
		}
		return text;
	}
}