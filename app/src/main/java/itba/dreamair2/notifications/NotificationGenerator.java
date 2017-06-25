package itba.dreamair2.notifications;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by martin on 25/6/17.
 */

public class NotificationGenerator {
    public static List<Notification> getNotifications() {
        List<Notification> notifications = new ArrayList<>();

        notifications.add(new Notification(0,"DreamAir","El vuelo AA230 aterrizo"));
        notifications.add(new Notification(1,"DreamAir","El vuelo LN300 esta retrasado"));


        return notifications;
    }

    //get local data

    //get remote data

    //compare diferences

    //create notifications for the diferences
}
