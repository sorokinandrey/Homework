package classroom.io;

import com.google.appengine.repackaged.org.joda.time.DateTime;
import com.google.appengine.repackaged.org.joda.time.Period;
import com.google.appengine.repackaged.org.joda.time.Years;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * Created by stran on 10.05.2016.
 */


public class Processor {
    private static String forbiddenChars = "_$!";

    private static boolean isValid(String s) {
        for (char c : forbiddenChars.toCharArray()) {
            if (s.indexOf(c) != -1) {
                return false;
            }
        }
        return true;
    }

    public static boolean isValidEmailAddress(String email) {
        try {
            InternetAddress emailAddr = new InternetAddress(email);
            emailAddr.validate();
        } catch (AddressException ex) {
            return false;
        }
        return true;
    }

    //    ^                 # start-of-string
    //    (?=.*[0-9])       # a digit must occur at least once
    //    (?=.*[a-z])       # a lower case letter must occur at least once
    //    (?=.*[A-Z])       # an upper case letter must occur at least once
    //    (?=.*[@#$%^&+=])  # a special character must occur at least once
    //    (?=\S+$)          # no whitespace allowed in the entire string
    //    .{8,}             # anything, at least eight places though
    //    $                 # end-of-string
    public static boolean isStrongPassword(String pwd) {
        String pattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";
        return pwd.matches(pattern);
    }

    public static boolean isNumber(String str) {
        try {
            double d = Double.parseDouble(str);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public static boolean isDateValid(String dateString) {
        DateFormat format = new SimpleDateFormat("dd.mm.yyyy");
        int maxYears = 150;
        try {
            Date date = format.parse(dateString);
            Date currentDate = new Date();
            if (date.before(currentDate)) {
                DateTime start = new DateTime(date);
                DateTime end = new DateTime(currentDate);
                if (Years.yearsBetween(start, end).getYears() < maxYears) {
                    return true;
                }

            }

        } catch (ParseException e) {
            return false;
        }
        return false;
    }

    public static String getMapFirstValue(String key, Map data) {
        String[] arr = (String[]) data.get(key);
        return arr[0];

    }

    public static void validateForm(Map data) throws DateFormatException, WeakPasswordException, EmailFormatException, InvalidNumberException {
        if (!isValidEmailAddress(getMapFirstValue("email", data))) {
            throw new EmailFormatException("Invalid email", "email");
        } else if (!isStrongPassword(getMapFirstValue("pwd", data))) {
            throw new WeakPasswordException("Too weak password", "pwd");
        } else if (!isNumber(getMapFirstValue("number", data))) {
            throw new InvalidNumberException("Entered not number", "number");
        } else if (!isDateValid(getMapFirstValue("date", data))) {
            throw new DateFormatException("Use proper date format e.g. dd.mm.yyyy and make sure you enter reasonable date", "date");
        }
    }


    public static void parse(String s) throws StringTooLongException, InvalidStringException, UserRequestedExitException {
        if (s.length() > 5) {
            throw new StringTooLongException("Please, use less, than 6 symbols");
        } else if (!isValid(s)) {
            throw new InvalidStringException("Please don't use these symbols " + forbiddenChars);
        } else if (s.equals("exit")) {
            throw new UserRequestedExitException("See you! Bye.");
        }
    }//e-mail, strong password, number, etc

}
