package itba.dreamair2;

import android.app.Application;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import itba.dreamair2.notifications.AlarmReceiver;

/**
 * Created by martin on 25/6/17.
 */

public class MyApplication extends Application {

    private static boolean activityVisible;

    public static boolean isActivityVisible() {
        return activityVisible;
    }

    public static void activityResumed() {
        activityVisible = true;
    }

    public static void activityPaused() {
        activityVisible = false;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        if (!prefs.getBoolean("firstTime", false)) {

            AlarmReceiver alarm = new AlarmReceiver();
            alarm.setAlarm(this);

            // mark first time has runned.
            SharedPreferences.Editor editor = prefs.edit();
            editor.putBoolean("firstTime", true);
            editor.commit();
        }
    }
}