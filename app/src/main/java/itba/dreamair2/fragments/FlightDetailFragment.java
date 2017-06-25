package itba.dreamair2.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import itba.dreamair2.Flight;
import itba.dreamair2.MainActivity;
import itba.dreamair2.adapters.CustomCards;
import itba.dreamair2.httprequests.FlightsResponse;
import itba.dreamair2.R;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FlightDetailFragment.OnFlightDetailListener} interface
 * to handle interaction events.
 * Use the {@link FlightDetailFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FlightDetailFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private Flight flight;


    private TextView fromAirport;
    private TextView fromCity;
    private TextView toAirport;
    private TextView toCity;
    private TextView flightNumber;
    private TextView gate;
    private TextView duration;
    private TextView arrivalTime;
    private TextView departureTime;
    private TextView departureDate;



    private OnFlightDetailListener mListener;

    public FlightDetailFragment() {
        // Required empty public constructor
    }


    public static FlightDetailFragment newInstance(Flight param1) {
        FlightDetailFragment fragment = new FlightDetailFragment();
        Bundle args = new Bundle();
        args.putParcelable(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            flight = (Flight) getArguments().getParcelable(ARG_PARAM1);
        }




    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_flight_detail, container, false);

        fromAirport= (TextView) view.findViewById(R.id.detail_from_airport);
        fromCity= (TextView) view.findViewById(R.id.detail_from_city);
        toAirport= (TextView) view.findViewById( R.id.detail_to_airport);
        toCity= (TextView) view.findViewById( R.id.detail_to_city);
        flightNumber= (TextView) view.findViewById( R.id.detail_flight_number);
        gate= (TextView) view.findViewById( R.id.detail_gate);
        duration= (TextView) view.findViewById( R.id.detail_duration);
        arrivalTime= (TextView) view.findViewById( R.id.detail_arrival_time);
        departureTime= (TextView) view.findViewById( R.id.detail_departure_time);
        departureDate= (TextView) view.findViewById( R.id.detail_departure_date);
        setFlight(flight);

        gate.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        MainActivity activity= (MainActivity) getActivity();
                        activity.addFavoriteFlight(flight);
                        Snackbar.make(v, "El vuelo se agregó a favoritos" , Snackbar.LENGTH_LONG).setAction("Action", null).show();
                    }
                }
        );


        return view;
    }


    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFlightDetailInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFlightDetailListener) {
            mListener = (OnFlightDetailListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public void setFlight(Flight flight) {
        //FlightsResponse.FlightsBean.OutboundRoutesBean.SegmentsBean info= flight.getOutbound_routes().get(0).getSegments().get(0);
        fromAirport.setText(flight.getDepartureAirportId());
        fromCity.setText(flight.getDepartureCity());
        toAirport.setText(flight.getArrivalAirportId());
        toCity.setText(flight.getArrivalCity());
        flightNumber.setText(flight.getNumber());
        gate.setText(flight.getGate());
        duration.setText(flight.getDuration());
        arrivalTime.setText(flight.getArrivalTime());
        departureTime.setText(flight.getDepartureTime());
        departureDate.setText(flight.getDepartureDate());


    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFlightDetailListener {
        // TODO: Update argument type and name
        void onFlightDetailInteraction(Uri uri);
    }

    public static String getTime(String str) {

        SimpleDateFormat input = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date day;
        try {
            day = input.parse(str);
        } catch (ParseException e) {
            day = null;
            e.printStackTrace();
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(day);

        return cal.get(Calendar.HOUR)+":"+cal.get(Calendar.MINUTE);
    }
}
