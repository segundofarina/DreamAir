package itba.dreamair2.services;

import android.app.IntentService;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import itba.dreamair2.Flight;
import itba.dreamair2.MainActivity;
import itba.dreamair2.MyApplication;
import itba.dreamair2.R;
import itba.dreamair2.httprequests.StatusResponse;
import itba.dreamair2.notifications.Notification;
import itba.dreamair2.notifications.AlarmReceiver;

/**
 * Created by martin on 25/6/17.
 */

public class SchedulingService extends IntentService {

    private final static String FLIGHT_STATUS_BASEURL = "http://hci.it.itba.edu.ar/v1/api/status.groovy?method=getflightstatus";
    private final static int NOTIFICATION_ICON_SMALL = itba.dreamair2.R.drawable.ic_stat_logo;
    private final static String APP_NAME = "Dream Air";

    public SchedulingService() {
        super("NotificationService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {

        final ArrayList<Flight> flights = loadFlightsFromLocalStorage();
        System.out.println(flights.size());

        for(final Flight flight : flights) {
            String stringUrl = FLIGHT_STATUS_BASEURL + "&airline_id=" + flight.getAirlineID() + "&flight_number=" + flight.getNumber().substring(3) ;

            HttpURLConnection urlConnection = null;
            String resp;

            try {
                URL url = new URL(stringUrl);
                urlConnection = (HttpURLConnection) url.openConnection();
                InputStream in = new BufferedInputStream(urlConnection.getInputStream());
                resp = readStream(in);
            } catch (Exception exception) {
                exception.printStackTrace();
                resp = null;
            } finally {
                if (urlConnection != null)
                    urlConnection.disconnect();
            }

            Gson gson = new Gson();
            Type listType = new TypeToken<StatusResponse>() {
            }.getType();

            StatusResponse response= gson.fromJson(resp,listType);

            System.out.println(response);
            System.out.println(flight.getStatus());
            if(!flight.getStatus().equals(getFlightStatusString(response.getStatus().getStatus()))) {
                flight.setStatus(getFlightStatusString(response.getStatus().getStatus()));

                saveFlightsToLocalStorage(flights);

                sendNotification(new Notification(response.getStatus().getId(),APP_NAME, getMsgString(flight.getNumber(),response.getStatus().getStatus())),flight);

            }


        }

        AlarmReceiver.completeWakefulIntent(intent);
    }



    private String readStream(InputStream inputStream) {
        try {
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            int i = inputStream.read();
            while (i != -1) {
                outputStream.write(i);
                i = inputStream.read();
            }
            return outputStream.toString();
        } catch (IOException e) {
            return "";
        }
    }




    private void sendNotification(Notification notification,Flight flight) {


        NotificationCompat.Builder builder =
                new NotificationCompat.Builder(this)
                        .setSmallIcon(NOTIFICATION_ICON_SMALL)
                        .setContentTitle(notification.getTitle())
                        .setContentText(notification.getMsg())
                        .setAutoCancel(true);

        // Creates an explicit intent for an Activity in your app
        Intent resultIntent = new Intent(this, MainActivity.class);
        resultIntent.putExtra("menuFragment","notificationItem");
        resultIntent.putExtra("flight",flight);

        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);

        stackBuilder.addNextIntent(resultIntent);
        PendingIntent resultPendingIntent = stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);

        builder.setContentIntent(resultPendingIntent);

        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        notificationManager.notify(notification.getId(), builder.build());

    }

    private void saveFlightsToLocalStorage(ArrayList<Flight> savedFlights) {
        Gson gson = new Gson();
        Type listType = new TypeToken<ArrayList<Flight>>() {
        }.getType();

        String ans= gson.toJson(savedFlights,listType);

        SharedPreferences sharedPref = MyApplication.getSharedPreferences();
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(getString(R.string.FAVORITE_FLIGHTS), ans);
        editor.commit();
    }

    private ArrayList<Flight> loadFlightsFromLocalStorage() {
        Gson gson = new Gson();
        Type listType = new TypeToken<ArrayList<Flight>>() {
        }.getType();

        SharedPreferences sharedPref = MyApplication.getSharedPreferences();
        String str =sharedPref.getString(getString(R.string.FAVORITE_FLIGHTS),null);

        return gson.fromJson(str,listType);
    }

    private String getMsgString(String flight, String status) {
        String resp = getString(R.string.notificationToastStart);
        resp += " " +flight+" ";
        if(status.equals("S")) {
            resp += getString(R.string.notificationToastProgrammed);
        } else if(status.equals("A")) {
            resp += getString(R.string.notificationToastActive);
        } else if(status.equals("R")) {
            resp += getString(R.string.notificationToastDeviated);
        } else if(status.equals("L")) {
            resp += getString(R.string.notificationToastLanded);
        } else if(status.equals("C")) {
            resp += getString(R.string.notificationToastCancelled);
        }
        return resp;
    }

    private String getFlightStatusString(String status) {
        if(status.equals("S")) {
            return getString(R.string.flightStatusProgrammed);
        } else if(status.equals("A")) {
            return getString(R.string.flightStatusActive);
        } else if(status.equals("R")) {
            return getString(R.string.flightStatusDeviated);
        } else if(status.equals("L")) {
            return getString(R.string.flightStatusLanded);
        } else if(status.equals("C")) {
            return getString(R.string.flightStatusCancelled);
        }
        return "Not Found";
    }
}