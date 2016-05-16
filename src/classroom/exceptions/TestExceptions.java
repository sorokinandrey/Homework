package classroom.exceptions;

/**
 * Created by stran on 10.05.2016.
 */
public class TestExceptions {
    public static void main(String[] args) {
        String s = "TeXT";
        Integer i;
        try {
            i = Integer.valueOf(s);
        } catch (NumberFormatException e) {
            System.out.println("Invalid number " + e.getLocalizedMessage());
        }

    }

}
