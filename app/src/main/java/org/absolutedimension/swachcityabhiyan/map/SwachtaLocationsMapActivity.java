package org.absolutedimension.swachcityabhiyan.map;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;


import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import org.absolutedimension.swachcityabhiyan.R;

import java.util.List;

public class SwachtaLocationsMapActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swachta_locations_map);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
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
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));//Here we have add multiple markers on Map.
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));// here the location will be the current location
    }
    public List getMarkersReady(){
            return null;
    }
    /* This class shows the list of locations where the cleaning task is there */

    public List showCleaningLocations(LatLng centerToStart){
           //the list of all locations in a circular area with radius from centerToStart in the form of list.
            return null;
    }

    public GoogleMap showCleaningLocationsOnMap(LatLng centerToStart){
        //the list of all locations in a circular area with radius from centerToStart on the map.
        return null;
    }

    public LatLng giveLatLngDetails(LatLng detailOfLatLng){
        //this gives exactly one point which has all the details about the place.
        return null;
    }

    public void showDirectionToLocation(LatLng InitialLatLng, LatLng finalLatLng){
        //this method will give direction between two points.
    }
}
