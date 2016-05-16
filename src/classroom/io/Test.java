package classroom.io;

import java.util.Scanner;

/**
 * Created by stran on 10.05.2016.
 */
public class Test {
    public static void main(String[] args) {
        Scanner sr = new Scanner(System.in);
        String s;
        // TODO add output to web page e-mail, strong password, number, etc
        System.out.print("Enter word: ");
        while (sr.hasNext()) {
            s = sr.next();
            try {
                Processor.parse(s);
            } catch (UserRequestedExitException e) {
                System.exit(0);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            System.out.print("Enter word: ");

        }
    }
}

