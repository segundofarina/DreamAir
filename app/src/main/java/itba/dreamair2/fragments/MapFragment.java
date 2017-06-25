package itba.dreamair2.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

import itba.dreamair2.Flight;
import itba.dreamair2.R;


public class MapFragment extends Fragment implements OnMapReadyCallback {

    private static final String ARG_PARAM1 = "param1";

    private GoogleMap mMap;
    private ArrayList<Flight> flights;


    public MapFragment() {
        // Required empty public constructor
    }

    public static MapFragment newInstance(ArrayList<Flight> flights) {
        MapFragment fragment = new MapFragment();
        Bundle args = new Bundle();
        args.putParcelableArrayList(ARG_PARAM1, flights);
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
        View view=inflater.inflate(R.layout.fragment_map, container, false);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        return view;
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        updateMarkers();
    }

    public void updateMarkers(){
        for(Flight flight: flights){
            MarkerOptions marker = new MarkerOptions().position(new LatLng(flight.getLatitude(),flight.getLongitude()));
            marker.title(flight.getDepartureAirportId()+ " - "+flight.getArrivalAirportId());
            marker.snippet(flight.getPrice());
            mMap.addMarker(marker);
        }
    }

}
