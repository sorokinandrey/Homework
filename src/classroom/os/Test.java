package classroom.os;


/**
 * Created by stran on 10.05.2016.
 */
public class Test {

    public static void main(String[] args) {
        String[] windows = {"main", "second"};
        Os os = Os.start(windows);
        os.outWindows();
        Window main;
        try {
            main = os.getWindowByTitle("f");
            System.out.println("Main selected: " + main);
        } catch (WindowNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

}
