package classroom.io;

/**
 * Created by stran on 10.05.2016.
 */
public class StringTooLongException extends Exception {
    public StringTooLongException(String message) {
        super(message);
    }

    public StringTooLongException() {
    }
}
