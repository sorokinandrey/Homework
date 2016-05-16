package classroom.io;

/**
 * Created by stran on 10.05.2016.
 */
public class FormException extends Exception {
    private String field;

    public String getField() {
        return field;
    }

    public FormException(String message) {
        super(message);
    }

    public FormException(String message, String field) {
        super(message);
        this.field = field;
    }

    public FormException() {
    }
}
