package classroom.io;

/**
 * Created by stran on 10.05.2016.
 */
public class DateFormatException extends FormException {
    public DateFormatException(String message) {
        super(message);
    }

    public DateFormatException(String message, String field) {
        super(message, field);
    }

    public DateFormatException() {
    }
}
