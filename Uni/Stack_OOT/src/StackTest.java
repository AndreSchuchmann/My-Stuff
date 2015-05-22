public class StackTest {
	public static void main(String[] args) {
		Stack myStack = new Stack();
		myStack.push("Thomas");
		myStack.push("Michael");
		System.out.println(myStack.pop());
		System.out.println(myStack.pop());
		System.out.println(myStack.pop()); // null
	}
}