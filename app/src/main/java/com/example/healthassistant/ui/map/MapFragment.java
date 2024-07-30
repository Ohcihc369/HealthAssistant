package com.example.healthassistant.ui.map;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.healthassistant.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.CameraUpdateFactory;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Marker;
import java.util.ArrayList;
import java.util.List;

public class MapFragment extends Fragment implements OnMapReadyCallback {

    private GoogleMap mMap;
    private MapView mapView;
    private List<HealthLocation> healthLocations; // List of predefined health-related locations

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_map, container, false);

        mapView = view.findViewById(R.id.mapView);
        mapView.onCreate(savedInstanceState);
        mapView.getMapAsync(this);

        // Initializing the list of health-related locations
        healthLocations = getHealthLocations();

        return view;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // This code sets the default locations(latitude and Longitudes) and the zoom camera to a central location
        LatLng centralLocation = new LatLng(-15.386166530101002, 28.343186078388587); // Default to Lusaka, Munali, Chudleigh
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(centralLocation, 13f));

        // Adding markers for health-related locations
        for (HealthLocation location : healthLocations) {
            LatLng healthLocationLatLng = new LatLng(location.getLatitude(), location.getLongitude());
            MarkerOptions markerOptions = new MarkerOptions()
                    .position(healthLocationLatLng)
                    .title(location.getName());

            Marker marker = mMap.addMarker(markerOptions);
            // You can store the marker reference if you need to manipulate it later
            // marker.setTag(location.getId());
        }
    }

    private List<HealthLocation> getHealthLocations() {
        // this logic is used to fetch predefined health-related locations
        List<HealthLocation> locations = new ArrayList<>();
        locations.add(new HealthLocation("Levy Mwanawasa Hospital", -15.38491211380739, 28.353723293757874));
        locations.add(new HealthLocation("Madplus Pharmacy ", -15.384170035066369, 28.3499080572205));
        locations.add(new HealthLocation("Body Temple Gymn", -15.380937344733452, 28.339231506260347));
        return locations;
    }
}
