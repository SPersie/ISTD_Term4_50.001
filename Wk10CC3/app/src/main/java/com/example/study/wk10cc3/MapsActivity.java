package com.example.study.wk10cc3;

import android.location.Address;
import android.location.Geocoder;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.List;
import java.util.Locale;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    //TODO 1.1 - add these instance variables
    private GoogleMap mMap;
    private Marker marker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
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

        // TODO 1.2 modify the following line so that the marker is stored in the instance variable
        marker =mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));

        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }

    public void whenClick(View view){

        Geocoder geocoder;
        List<Address> addresses;

        geocoder = new Geocoder(this, Locale.getDefault());

        try{

            //TODO 2.1 - query the addresses of changi airport using the getFromLocationName method of geocoder
            addresses =geocoder.getFromLocationName("changi airport", 5);

            //TODO 2.2 - get the latitude and longitude from the 0-th elements of the List object
            double latitude =addresses.get(0).getLatitude();
            double longitude =addresses.get(0).getLongitude();

            //TODO 2.3 - set up a new LatLng object
            LatLng changiairport =new LatLng(latitude, longitude);

            //TODO 2.4 - use the setPosition method of the marker object to move the marker
            marker.setPosition(changiairport);

            //TODO 2.5 - use the moveCamera method of mMap to move the view
            mMap.moveCamera(CameraUpdateFactory.newLatLng(changiairport));

            //TODO 2.6 - similarly, set an appropriate zoom level
            mMap.animateCamera(CameraUpdateFactory.zoomIn());

        }catch(Exception ex){
            ex.printStackTrace();
        }

    }
}
