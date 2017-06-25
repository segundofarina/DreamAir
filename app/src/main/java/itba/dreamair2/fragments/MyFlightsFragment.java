package itba.dreamair2.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import itba.dreamair2.adapters.CustomList;
import itba.dreamair2.R;
import itba.dreamair2.httprequests.FlightsResponse;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link MyFlightsFragment.MyFlightsInteractionListener} interface
 * to handle interaction events.
 * Use the {@link MyFlightsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */


@Deprecated
public class MyFlightsFragment extends Fragment {


    ListView list;
    String [] from={"Buenos Aires","Buenos Aires","Buenos Aires","Buenos Aires","Buenos Aires"};
    String [] to= {"Nueva York", "Miami", "Roma", "Madrid", "Barcelona"};
    String[] status={"En horario","En horario","Demorado", "En horario", "Demorado"};
    String [] number= {"AA 128", "AF 13013", "AM 2034", "AR 4930", "AV 19302"};

    Integer[] imageId = {
            R.drawable.aa,
            R.drawable.af,
            R.drawable.am,
            R.drawable.ar,
            R.drawable.av,
            R.drawable.az,
            R.drawable.ba,
            R.drawable.cm,
            R.drawable.ib,
            R.drawable.jj,
            R.drawable.la,
            R.drawable.ta,
            R.drawable.aa
    };







    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private ArrayList<FlightsResponse.FlightsBean> flights;


    public MyFlightsFragment() {
        // Required empty public constructor
    }


    public static MyFlightsFragment newInstance(ArrayList<FlightsResponse.FlightsBean> param1) {
        MyFlightsFragment fragment = new MyFlightsFragment();
        Bundle args = new Bundle();
        args.putParcelableArrayList(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            flights = getArguments().getParcelableArrayList(ARG_PARAM1);
        }


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_my_flights, container, false);
    }



    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //CustomList adapter = new CustomList(getActivity(), from,to,status,number, imageId);
        ///CustomList adapter = new CustomList(this,flights);
        //list=(ListView) getView().findViewById(R.id.list);
        //list.setAdapter(adapter);
//        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view,
//                                    int position, long id) {
//                //Toast.makeText(MainActivity.this, "You Clicked at " +web[+ position], Toast.LENGTH_SHORT).show();
//
//            }
//        });
    }



}
