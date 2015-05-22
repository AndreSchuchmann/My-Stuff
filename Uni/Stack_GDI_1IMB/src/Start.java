import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
public class Start {
    private static char expression[] = {};
 
    public static void main(String[] args) {
 
        System.out.println(compareBrackets('[', ']'));
        System.out
                .println("Please enter an expression to check if it is semantically correct");
        expression = readString().toCharArray();
 
        if (checkExpression(expression)) {
            System.out.println("The brackets are right!");
        } else {
            System.out.println("Sorry dude..");
        }
 
    }
 
    /**
     * this method checks the entered expression String by String
     * 
     * @param expression
     *            is an array of the type character
     * @return if the entered brackets fit to each other in the whole expression
     *         or not
     */
    public static boolean checkExpression(char[] expression) {
        Stack stack = new Stack();
        for (int i = 0; i < expression.length; i++) {
            if (checkForOpeningBracket(expression[i])) {
                System.out.println("Opening bracket found.");
                stack.push(expression[i]);
            } else if (checkForClosingBracket(expression[i])) {
                System.out.println("Closing bracket found.");
                System.out
                        .println("Checking if the closing bracket fits to the opening bracket:");
                if (compareBrackets(stack.pop(), expression[i])) {
                    System.out.println("It fits!");
                } else {
                    System.out.println("It doesn't fit!");
                    return false;
                }
 
            }
 
        }
 
        if (stack.size() > 0) {
            System.out.println("Closing bracket not found!");
            return false;
        }
 
        stack.print();
 
        return true;
    }
 
    public static String readString() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(
                System.in));
        String inStr = "";
        try {
            inStr = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return inStr;
    }
 
    /**
     * this method checks if the entered String is a closing bracket
     * 
     * @param c
     *            of the type character
     * @return true if the entered String is a closing bracket and false if it
     *         is not
     */
    public static boolean checkForClosingBracket(char c) {
        switch (c) {
        case ')':
            return true;
        case ']':
            return true;
        case '}':
            return true;
        default:
            return false;
        }
    }
 
    /**
     * this method check if the read String is a opening bracket
     * 
     * @param c
     *            of the type character
     * @return true if it is a opening bracket and false if it is not a opening
     *         bracket
     */
    public static boolean checkForOpeningBracket(char c) {
        switch (c) {
        case '(':
            return true;
        case '[':
            return true;
        case '{':
            return true;
        default:
            return false;
        }
    }
 
    /**
     * this method checks if the brackets fit to each other
     * 
     * @param b1
     *            of the type character
     * @param b2
     *            of the type character
     * @return true if brackets are right and false if brackets doesn't fit
     *         together
     */
    public static boolean compareBrackets(char b1, char b2) {
        if (b1 == '(' && b2 == ')') {
            return true;
        } else if (b1 == '[' && b2 == ']') {
            return true;
        } else if (b1 == '{' && b2 == '}') {
            return true;
        } else {
            return false;
        }
    }
 
}