package itba.dreamair2.adapters;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import itba.dreamair2.Flight;
import itba.dreamair2.httprequests.FlightsResponse;
import itba.dreamair2.MainActivity;
import itba.dreamair2.R;

/**
 * Created by segundofarina on 13/6/17.
 */







public class CustomCards extends RecyclerView.Adapter<CustomCards.ViewHolder> implements Serializable {


    List<Flight> flights;
    MainActivity activity;

    public CustomCards(Activity activity,List<Flight> flights) {
    this.activity=(MainActivity) activity;
    this.flights=flights;
    }

    class ViewHolder extends RecyclerView.ViewHolder{

            public ImageView image;
            public TextView city;
            public TextView price;
            public TextView departure;
            public TextView flight_number;

            public ViewHolder(View itemView) {
                super(itemView);
                image = (ImageView)itemView.findViewById(R.id.offer_image);
                city = (TextView)itemView.findViewById(R.id.offer_city);
                price = (TextView)itemView.findViewById(R.id.offer_price);
                departure = (TextView)itemView.findViewById(R.id.offer_departure);
                flight_number = (TextView)itemView.findViewById(R.id.offer_flight_number);


                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override public void onClick(View v) {
                        int position = getAdapterPosition();

                        //Snackbar.make(v, "Click detected on item " + position,
                        //        Snackbar.LENGTH_LONG)
                        //        .setAction("Action", null).show();
                        activity.loadFlightDetailFragment(flights.get(position));

                    }
                });
            }
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            View v = LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.offer_single, viewGroup, false);
            ViewHolder viewHolder = new ViewHolder(v);
            return viewHolder;
        }


    @Override
    public void onBindViewHolder(CustomCards.ViewHolder viewHolder, int i) {
        Flight flight= flights.get(i);

        viewHolder.city.setText(flight.getArrivalCity().split(",")[0]);
        viewHolder.price.setText(flight.getPrice());
        viewHolder.flight_number.setText(flight.getNumber());
        viewHolder.image.setImageResource(flight.getDestinationImg());
        viewHolder.departure.setText(flight.getDepartureDate());

    }

    @Override
        public int getItemCount() {
            return flights.size();
        }
    }



