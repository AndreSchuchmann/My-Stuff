package crypter;

/**
 * Created by Ali on 26.05.2015.
 */
public class IllegalMessageException extends Exception {
    public IllegalMessageException() {
    }

    public IllegalMessageException(String message) {

        super(message);
    }
}
