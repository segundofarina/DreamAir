package itba.dreamair2;

import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import itba.dreamair2.adapters.CustomCards;
import itba.dreamair2.adapters.FavoritesAdapter;
import itba.dreamair2.fragments.FavoritesFragment;
import itba.dreamair2.fragments.FlightDetailFragment;
import itba.dreamair2.fragments.MyFlightsFragment;
import itba.dreamair2.fragments.OffersFragment;
import itba.dreamair2.httprequests.DealResponse;
import itba.dreamair2.httprequests.FlightsResponse;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,FlightDetailFragment.OnFlightDetailListener{

    ArrayList<Flight> flights;
    CustomCards adapter;
    ArrayList<Flight> savedFlights;
    FavoritesAdapter favAdapter;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.add);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        savedFlights= new ArrayList<>();
        flights= new ArrayList<>();
        adapter = new CustomCards(this,flights);
        favAdapter= new FavoritesAdapter(this,savedFlights);
        new HttpGetDeals().execute();


    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        Fragment fragment;

        if (id == R.id.nav_flights) {
            fragment= getSupportFragmentManager().findFragmentById(R.id.fragment_my_flights);
            if(fragment== null) {
                fragment = FavoritesFragment.newInstance(favAdapter,savedFlights);
            }
                getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment).addToBackStack(null).commit();

        } else if (id == R.id.nav_sale) {
            fragment= getSupportFragmentManager().findFragmentById(R.id.fragment_offers);
            if(fragment== null) {
                fragment = OffersFragment.newInstance(adapter,flights);
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment).addToBackStack(null).commit();

        } else if (id == R.id.nav_notification) {

        }  else if (id == R.id.nav_settings) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }




    public void addFavoriteFlight(Flight flight){
        savedFlights.add(flight);
    }



    public void loadFlightDetailFragment(Flight flight){
        FlightDetailFragment fragment = FlightDetailFragment.newInstance(flight);
        getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment).addToBackStack(null).commit();
        //fragment.setFlight(flight);
    }

    @Override
    public void onFlightDetailInteraction(Uri uri) {

    }





    private class HttpGetFlights extends AsyncTask<DealResponse.DealsBean, Void, String> {
        DealResponse.DealsBean deal;
        int it;
        String to;
        String date;

        public HttpGetFlights(DealResponse.DealsBean deal, int it){
            this.deal=deal;
            this.it=it;
        }

        @Override
        protected String doInBackground(DealResponse.DealsBean... params) {

            HttpURLConnection urlConnection = null;
            Calendar today= Calendar.getInstance();
            today.add(Calendar.DATE,it);
            SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");


            String from="BUE";
            to=deal.getCity().getId();
            date=sdf.format(today.getTime());


            try {
                URL url = new URL("http://hci.it.itba.edu.ar/v1/api/booking.groovy?method=getonewayflights&from="+from+"&to="+to+"&dep_date="+date+"&adults=1&children=0&infants=0&sort_key=total&page_size=300");
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
            if(it>12){
                return;
            }
            Gson gson = new Gson();
            Type listType = new TypeToken<FlightsResponse>() {
            }.getType();

            FlightsResponse response= gson.fromJson(result,listType);
            System.out.println("Buscando vuelos en el dia:"+date +"a: "+to);
            System.out.println("Respuesta getFlights"+result);
            if(!response.getFlights().isEmpty()) {
                FlightsResponse.FlightsBean flight = response.getFlights().get(0);

                if (flight.getPrice().getTotal().getTotal() == deal.getPrice()) {
                    System.out.println("ENCONTRADOOO Hasta: "+flight.getOutbound_routes().get(0).getSegments().get(0).getArrival().getAirport().getCity().getName()+"Duracion: " + flight.getOutbound_routes().get(0).getDuration());
                    System.out.println("------end-----");
                    flights.add(new Flight(flight));
                    adapter.notifyDataSetChanged();
                }
                else{
                    System.out.println("No se encontro el vuelo iniciando con it:"+(it+1));
                    System.out.println("------end-----");
                    new HttpGetFlights(deal,it+1).execute();
                }
            }else{
                System.out.println("No habia vuelos iniciando con it:"+(it+1));
                System.out.println("------end-------");
                new HttpGetFlights(deal,it+1).execute();
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

    private class HttpGetDeals extends AsyncTask<Void, Void, String> {
        @Override
        protected String doInBackground(Void... params) {

            HttpURLConnection urlConnection = null;

            try {
                //URL url = new URL("http://hci.it.itba.edu.ar/v1/api/geo.groovy?method=getcountries");
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
                new HttpGetFlights(deal,2).execute(deal);
                System.out.println(deal.getCity().getName());
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
}
