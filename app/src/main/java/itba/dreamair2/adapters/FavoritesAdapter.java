package itba.dreamair2.adapters;

import android.app.Activity;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.Serializable;
import java.util.List;

import itba.dreamair2.Flight;
import itba.dreamair2.MainActivity;
import itba.dreamair2.R;

/**
 * Created by segundofarina on 24/6/17.
 */

public class FavoritesAdapter extends RecyclerView.Adapter<FavoritesAdapter.ViewHolder> implements Parcelable {

    List<Flight> flights;
    MainActivity activity;

    public FavoritesAdapter(Activity activity, List<Flight> flights) {
        this.activity = (MainActivity) activity;
        this.flights = flights;
    }

    protected FavoritesAdapter(Parcel in) {
        flights = in.createTypedArrayList(Flight.CREATOR);
    }

    public static final Creator<FavoritesAdapter> CREATOR = new Creator<FavoritesAdapter>() {
        @Override
        public FavoritesAdapter createFromParcel(Parcel in) {
            return new FavoritesAdapter(in);
        }

        @Override
        public FavoritesAdapter[] newArray(int size) {
            return new FavoritesAdapter[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(flights);
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView image;
        public TextView from;
        public TextView to;
        public TextView status;
        public TextView flight_number;

        public ViewHolder(View itemView) {
            super(itemView);
            image = (ImageView) itemView.findViewById(R.id.favorite_image);
            from = (TextView) itemView.findViewById(R.id.favorite_from);
            to = (TextView) itemView.findViewById(R.id.favorite_to);
            status = (TextView) itemView.findViewById(R.id.favorite_status);
            flight_number = (TextView) itemView.findViewById(R.id.favorite_flight_number);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    activity.loadFlightDetailFragment(flights.get(position));

                }
            });
        }
    }

    @Override
    public FavoritesAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.favorite_single, viewGroup, false);
        FavoritesAdapter.ViewHolder viewHolder = new FavoritesAdapter.ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(FavoritesAdapter.ViewHolder viewHolder, int i) {
        Flight flight= flights.get(i);
        viewHolder.from.setText(flight.getDepartureCity().split(",")[0]);
        viewHolder.to.setText(flight.getArrivalCity().split(",")[0]);
        viewHolder.status.setText(flight.getStatus());
        viewHolder.flight_number.setText(flight.getNumber());
        viewHolder.image.setImageResource(flight.getAirlineImg());
    }

    @Override
    public int getItemCount() {
        return flights.size();
    }
}