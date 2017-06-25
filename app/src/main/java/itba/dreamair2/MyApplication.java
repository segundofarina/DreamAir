package itba.dreamair2;

import android.app.Application;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.preference.PreferenceManager;

import itba.dreamair2.notifications.AlarmReceiver;

/**
 * Created by martin on 25/6/17.
 */

public class MyApplication extends Application {

    private static boolean activityVisible;
    private static SharedPreferences preferences;

    public static boolean isActivityVisible() {
        return activityVisible;
    }

    public static void activityResumed() {
        activityVisible = true;
    }

    public static void activityPaused() {
        activityVisible = false;
    }

    public static SharedPreferences getSharedPreferences() {
        return preferences;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        preferences = PreferenceManager.getDefaultSharedPreferences(this);
        if (!preferences.getBoolean("firstTime", false)) {

            AlarmReceiver alarm = new AlarmReceiver();
            alarm.setAlarm(this);

            // mark first time has runned.
            SharedPreferences.Editor editor = preferences.edit();
            editor.putBoolean("firstTime", true);
            editor.commit();
        }
    }
}