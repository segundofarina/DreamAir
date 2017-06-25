package itba.dreamair2.notifications;

/**
 * Created by martin on 25/6/17.
 */

public class Notification {
    private int id;
    private String title;
    private String msg;

    public Notification(int id, String title, String msg) {
        this.id = id;
        this.title = title;
        this.msg = msg;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getMsg() {
        return msg;
    }
}