package classroom.io;

/**
 * Created by stran on 10.05.2016.
 */
public class UserRequestedExitException extends Exception {
    public UserRequestedExitException(String message) {
        super(message);
    }

    public UserRequestedExitException() {
    }
}
