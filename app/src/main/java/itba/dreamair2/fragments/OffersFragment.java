package itba.dreamair2.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v7.widget.LinearLayoutManager;
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

import itba.dreamair2.Flight;
import itba.dreamair2.MainActivity;
import itba.dreamair2.adapters.CustomCards;
import itba.dreamair2.adapters.CustomList;
import itba.dreamair2.httprequests.DealResponse;
import itba.dreamair2.httprequests.FlightsResponse;
import itba.dreamair2.R;



public class OffersFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;
    ArrayList<Flight> flights;



    public OffersFragment() {
        // Required empty public constructor
    }

    public static OffersFragment newInstance(CustomCards param1, ArrayList<Flight> param2) {
        OffersFragment fragment = new OffersFragment();
        Bundle args = new Bundle();
        args.putParcelable(ARG_PARAM1, param1);
        args.putParcelableArrayList(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            adapter = (RecyclerView.Adapter) getArguments().getParcelable(ARG_PARAM1);
            flights = getArguments().getParcelableArrayList(ARG_PARAM2);
        }
    }


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_offers, container, false);

        MainActivity activity= (MainActivity)getActivity();
        activity.getSupportActionBar().setTitle(getString(R.string.OFFERS));


        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        return view;
    }


}
