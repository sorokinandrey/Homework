package classroom.io;

/**
 * Created by stran on 10.05.2016.
 */
public class EmailFormatException extends FormException {
    public EmailFormatException(String message) {
        super(message);
    }

    public EmailFormatException(String message, String field) {
        super(message, field);
    }

    public EmailFormatException() {
    }
}
