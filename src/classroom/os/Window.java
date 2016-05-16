package classroom.os;

/**
 * Created by stran on 10.05.2016.
 */
public class Window {
    protected String title;

    public Window(String title) {
        this.title = title;
    }
    public String getTitle() {
        return this.title;
    }
    @Override
    public String toString() {
        return title;
    }
}
