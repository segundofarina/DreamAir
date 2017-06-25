package itba.dreamair2.notifications;

/**
 * Created by martin on 25/6/17.
 */

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.content.WakefulBroadcastReceiver;
import itba.dreamair2.MyApplication;
import itba.dreamair2.contracts.BroadcastContract;
import itba.dreamair2.services.SchedulingService;

public class AlarmReceiver extends WakefulBroadcastReceiver {

    private final static long NOTIFICATION_INTERVAL =  10000;//in miliseconds

    private AlarmManager alarmMgr;
    private PendingIntent alarmIntent;

    @Override
    public void onReceive(Context context, Intent intent) {
        //app content update
        Intent mainActivityIntent = new Intent(BroadcastContract.UPDATE_NOTIFICATIONS);
        context.sendBroadcast(mainActivityIntent);

        //Notification
        if(!MyApplication.isActivityVisible()) {
            Intent service = new Intent(context, SchedulingService.class);
            startWakefulService(context, service);
        }

    }

    public void setAlarm(Context context) {
        alarmMgr = (AlarmManager)context.getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(context, AlarmReceiver.class);
        alarmIntent = PendingIntent.getBroadcast(context, 0, intent, 0);

        alarmMgr.setInexactRepeating(AlarmManager.ELAPSED_REALTIME_WAKEUP,
                NOTIFICATION_INTERVAL,
                NOTIFICATION_INTERVAL, alarmIntent);

    }

}
