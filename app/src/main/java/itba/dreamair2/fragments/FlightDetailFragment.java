package itba.dreamair2.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

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
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private FlightsResponse.FlightsBean flight;
    private String mParam2;


    TextView fromAirport;
    TextView fromCity;
    TextView toAirport;
    TextView toCity;
    TextView flightNumber;
    TextView gate;
    TextView duration;
    TextView arrivalTime;
    TextView departureTime;
    TextView departureDate;



    private OnFlightDetailListener mListener;

    public FlightDetailFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     *
     * @return A new instance of fragment FlightDetailFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FlightDetailFragment newInstance(FlightsResponse.FlightsBean param1) {
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
            flight = (FlightsResponse.FlightsBean) getArguments().getParcelable(ARG_PARAM1);
        }




    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
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

    public void setFlight(FlightsResponse.FlightsBean flight) {
        FlightsResponse.FlightsBean.OutboundRoutesBean.SegmentsBean info= flight.getOutbound_routes().get(0).getSegments().get(0);
        System.out.println(info.getDeparture().getAirport().getId());
        fromAirport.setText(info.getDeparture().getAirport().getId());
        fromCity.setText(info.getDeparture().getAirport().getCity().getName());
        toAirport.setText(info.getArrival().getAirport().getId());
        toCity.setText(info.getArrival().getAirport().getCity().getName());
        flightNumber.setText(info.getAirline().getId()+" "+info.getNumber());
        gate.setText(info.getDeparture().getAirport().getTime_zone());
        duration.setText(info.getDuration());
        arrivalTime.setText(getTime(info.getArrival().getDate()));
        departureTime.setText(getTime(info.getDeparture().getDate()));
        departureDate.setText(CustomCards.getStringDate(info.getDeparture().getDate()));


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
