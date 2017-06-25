package itba.dreamair2;

import android.os.AsyncTask;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;

import itba.dreamair2.httprequests.DealResponse;

/**
 * Created by martin on 25/6/17.
 */

public class ApiConnection extends AsyncTask<Void, Void, String> {

    @Override
    protected String doInBackground(Void... params) {
        HttpURLConnection urlConnection = null;

        try {
            URL url = new URL("http://hci.it.itba.edu.ar/v1/api/booking.groovy?method=getflightdeals&from=BUE");
            urlConnection = (HttpURLConnection) url.openConnection();
            InputStream in = new BufferedInputStream(urlConnection.getInputStream());
            return readStream(in);
        } catch (Exception exception) {
            exception.printStackTrace();
            //return getResources().getString(R.string.error);
            return null;
        } finally {
            if (urlConnection != null)
                urlConnection.disconnect();
        }
    }

    @Override
    protected void onPostExecute(String result) {
        Gson gson = new Gson();
        Type listType = new TypeToken<DealResponse>() {
        }.getType();

        DealResponse response= gson.fromJson(result,listType);
        System.out.println("resultado: "+result);
        for(DealResponse.DealsBean deal :response.getDeals()){

        }

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

}
