public class Stack {
	private int DEFAULT_SIZE = 100;
	private Object[] values;
	private int stackIndex = 0; // Zeigt auf nächstes freies Element

	public Stack() {
		values = new Object[DEFAULT_SIZE];
	}

	public Stack(int size) {
		values = new Object[size];
	}

	// Liefert TRUE bei erfolgreichem Ablegen auf dem Stack, FALSE bei vollem
	// Stack
	public boolean push(Object obj) {
		if (!isFull()) {
			values[stackIndex++] = obj;
			return true;
		} else {
			return false;
		}
	}

	// Liefert oberstes Element des Stacks und entfernt es vom Stack.
	// NULL, wenn kein Element mehr auf dem Stack ist
	public Object pop() {
		if (!isEmpty()) {
			return values[--stackIndex];
		} else {
			return null;
		}
	}

	public boolean isEmpty() {
		return stackIndex == 0;
	}

	public boolean isFull() {
		return stackIndex == values.length;
	}
}