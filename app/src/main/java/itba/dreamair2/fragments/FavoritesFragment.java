package itba.dreamair2.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import itba.dreamair2.Flight;
import itba.dreamair2.R;
import itba.dreamair2.adapters.FavoritesAdapter;
import itba.dreamair2.httprequests.FlightsResponse;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FavoritesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FavoritesFragment extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;
    ArrayList<Flight> flights;


    public FavoritesFragment() {
        // Required empty public constructor
    }


    public static FavoritesFragment newInstance(FavoritesAdapter param1, ArrayList<Flight> param2) {
        FavoritesFragment fragment = new FavoritesFragment();
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.fragment_favorites, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        return view;
    }



}
