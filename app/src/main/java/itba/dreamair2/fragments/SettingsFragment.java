package itba.dreamair2.fragments;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.support.annotation.Nullable;

import itba.dreamair2.MainActivity;
import itba.dreamair2.MyApplication;
import itba.dreamair2.R;
import itba.dreamair2.contracts.BroadcastContract;

/**
 * Created by martin on 25/6/17.
 */

public class SettingsFragment extends PreferenceFragment {

    ListPreference currency;
    ListPreference notifications;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addPreferencesFromResource(R.xml.preferences);

        MainActivity activity= (MainActivity)getActivity();
        activity.getSupportActionBar().setTitle(getString(R.string.SETTINGS));

        currency = (ListPreference) findPreference("currencyList");
        notifications = (ListPreference) findPreference("notificationList");

        notifications.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            @Override
            public boolean onPreferenceChange(Preference preference, Object newValue) {

                SharedPreferences sharedPref = MyApplication.getSharedPreferences();
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putString(BroadcastContract.NOTIFICATION_FREC, getMills((String)notifications.getEntry()));
                editor.commit();

                return false;
            }
        });

        currency.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            @Override
            public boolean onPreferenceChange(Preference preference, Object newValue) {

                SharedPreferences sharedPref = MyApplication.getSharedPreferences();
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putString("currency", (String)currency.getEntry());
                editor.commit();

                return false;
            }
        });


    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        getView().setBackgroundColor(Color.WHITE);
        getView().setClickable(true);
    }

    private String getMills(String str) {
        switch (Integer.parseInt(str)) {
            case 0:
                return "60000";
            case 1:
                return "1800000";
            case 2:
                return "3600000";
            case 3:
                return "86400000";
        }
        return "1";
    }


}
