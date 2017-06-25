package itba.dreamair2.services;

import android.app.IntentService;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import itba.dreamair2.notifications.Notification;
import itba.dreamair2.notifications.AlarmReceiver;
import itba.dreamair2.notifications.NotificationGenerator;

/**
 * Created by martin on 25/6/17.
 */

public class SchedulingService extends IntentService {

    private final static int NOTIFICATION_ICON_SMALL = itba.dreamair2.R.drawable.ic_stat_logo;

    public SchedulingService() {
        super("NotificationService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {

        for(Notification notification : NotificationGenerator.getNotifications()) {
            sendNotification(notification);
        }

        AlarmReceiver.completeWakefulIntent(intent);
    }


    private void sendNotification(Notification notification) {


        NotificationCompat.Builder builder =
                new NotificationCompat.Builder(this)
                        .setSmallIcon(NOTIFICATION_ICON_SMALL)
                        .setContentTitle(notification.getTitle())
                        .setContentText(notification.getMsg());

        // Creates an explicit intent for an Activity in your app
        /*Intent resultIntent = new Intent(this, ResultActivity.class);

        // The stack builder object will contain an artificial back stack for the
        // started Activity.
        // This ensures that navigating backward from the Activity leads out of
        // your application to the Home screen.
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
        // Adds the back stack for the Intent (but not the Intent itself)
        stackBuilder.addParentStack(ResultActivity.class);
        // Adds the Intent that starts the Activity to the top of the stack
        stackBuilder.addNextIntent(resultIntent);
        PendingIntent resultPendingIntent = stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);

        builder.setContentIntent(resultPendingIntent);
*/
        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        // mId allows you to update the notification later on.
        notificationManager.notify(notification.getId(), builder.build());
        System.out.println("Puse notificacion");

    }

}