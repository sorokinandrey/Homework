package classroom.os;

/**
 * Created by stran on 10.05.2016.
 */
public class Os {
    protected static Os os;
    protected Window[] windows;

    private Os() {

    }

    private Os(String[] initialWindows) {
        windows = new Window[initialWindows.length];
        for (int i = 0; i < initialWindows.length; i++) {
            windows[i] = new Window(initialWindows[i]);
        }

    }

    public static Os start(String[] initialWindows) {
        if (os == null) {
            os = new Os(initialWindows);
        }
        return os;
    }

    public void outWindows() {
        System.out.println("Currently running windows: ");
        for (Window w : windows) {
            System.out.println(w);
        }
        return;
    }

    public Window getWindowByTitle(String title) throws WindowNotFoundException {
        for (Window w : windows) {
            if (w.getTitle().equals(title)) {
                return w;
            }
        }
        throw (new WindowNotFoundException("Window not found by provided title"));
    }


}
