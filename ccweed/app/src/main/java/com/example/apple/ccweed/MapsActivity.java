package com.example.apple.ccweed;

import android.Manifest;
import android.app.FragmentManager;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;


public class MapsActivity extends FragmentActivity implements OnMapReadyCallback  {

    private GoogleMap mMap;
    private LatLng currPosition = new LatLng(49.2834510, -123.1152550);
    private MarkerOptions currMarker = new MarkerOptions().position(currPosition).title("Bcit DownTown Vancouver");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("problem", "dsfjalkfjkdsafjlksafjklasjfkldsajflsjdafjsdafjldksafjlk");
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
        Log.d("problem", "dsfjalkfjkdsafjlksafjklasjfkldsajflsjdafjsdafjldksafjlk");
        System.out.println("sdfsdfdsfsfdsfdsfsd");
        mMap = googleMap;
        mMap.setBuildingsEnabled(true);
        // Add a marker in Sydney and move the camera
        mMap.addMarker(currMarker);
        movingCameraEffect(currPosition, 17);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        mMap.setMyLocationEnabled(true);


    }


    public void onMapSearch(View view) {
        EditText locationSearch = (EditText) findViewById(R.id.editText);
        String location = locationSearch.getText().toString();
        List<Address> addressList = null;
        mMap.clear();


        if ((location != null || !location.equals(""))) {
            Geocoder geocoder = new Geocoder(this);
            try {
                addressList = geocoder.getFromLocationName(location, 1);

            } catch (IOException e) {
                e.printStackTrace();
            }
            Address address = addressList.get(0);

            LatLng latLng = new LatLng(address.getLatitude(), address.getLongitude());
            movingCameraEffect(latLng, 11);
        }
    }


    private void movingCameraEffect(LatLng latLng, int zoom) {
        mMap.addMarker(new MarkerOptions().position(latLng).title("Marker"));
        mMap.animateCamera(CameraUpdateFactory.newLatLng(latLng));
        CameraPosition cameraPosition = new CameraPosition.Builder()
                .target(latLng)      // Sets the center of the map to Mountain View
                .zoom(zoom)                   // Sets the zoom
                .bearing(0)                // Sets the orientation of the camera to east
                .tilt(15)                   // Sets the tilt of the camera to 30 degrees
                .build();                   // Creates a CameraPosition from the builder
        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));

    }

    public void showDialog(View v){
        FragmentManager manager = getFragmentManager();
        DFragment myDialog = new DFragment();
        myDialog.show(manager, "My Dialog");

    }
}







