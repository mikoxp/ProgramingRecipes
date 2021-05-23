package file.manager;

/**
 * @author michal.oles
 */
public class PathWithDate {
    private final String date;
    private final String path;

    public PathWithDate(String date, String path) {
        this.date = date;
        this.path = path;
    }

    public String getDate() {
        return date;
    }

    public String getPath() {
        return path;
    }

}
