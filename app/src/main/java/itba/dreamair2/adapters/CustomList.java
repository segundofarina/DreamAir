package itba.dreamair2.adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import itba.dreamair2.MainActivity;
import itba.dreamair2.R;
import itba.dreamair2.httprequests.FlightsResponse;

/**
 * Created by segundofarina on 8/6/17.
 */
@Deprecated
public class CustomList extends ArrayAdapter<String>{

    private final static String ON_TIME="En horario";

    private final Activity context;
//    private final String[] from;
//    private final String[] to;
//    private final String[] status;
//    private final String[] number;
//    private final Integer[] imageId;

    private ArrayList<FlightsResponse.FlightsBean> flights;

//    public CustomList(Activity context, String[] from, String[] to, String[] status, String[] number, Integer[] imageId) {
//        super(context, R.layout.list_single, from);
//        this.context = context;
//        this.from=from;
//        this.to=to;
//        this.status=status;
//        this.number=number;
//        this.imageId = imageId;
//
//    }

    public CustomList(Activity context, ArrayList<FlightsResponse.FlightsBean> flights){
        super(context, R.layout.list_single, flights.size());
        this.flights=flights;
        this.context=context;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {


        // agregar un holder
        // agregar si el view ya esta creado
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView= inflater.inflate(R.layout.list_single, null, true);
        TextView txtFrom = (TextView) rowView.findViewById(R.id.flight_form);
        TextView txtTo = (TextView) rowView.findViewById(R.id.flight_to);
        TextView txtStatus = (TextView) rowView.findViewById(R.id.flight_status);
        TextView txtNumber = (TextView) rowView.findViewById(R.id.flight_number);

        ImageView imageView = (ImageView) rowView.findViewById(R.id.img);


        FlightsResponse.FlightsBean.OutboundRoutesBean.SegmentsBean info=flights.get(position).getOutbound_routes().get(0).getSegments().get(0);

        txtFrom.setText(info.getDeparture().getAirport().getCity().getName().split("-")[0]);
        txtTo.setText(info.getArrival().getAirport().getCity().getName().split("-")[0]);
        txtNumber.setText(info.getAirline().getId()+" "+ info.getId());
        txtStatus.setText(ON_TIME);
        txtStatus.setTextColor(context.getResources().getColor(R.color.onTime));








        return rowView;
    }
}