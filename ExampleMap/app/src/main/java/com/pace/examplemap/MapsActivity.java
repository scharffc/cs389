package com.pace.examplemap;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.pace.examplemap.databinding.ActivityMapsBinding;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, LocationListener {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

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
        LatLng newyork = new LatLng(40.2904, -74.0211);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.addMarker(new MarkerOptions().position(newyork).title("Maker in NYC"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(newyork));

        Log.i("MAINACTIVITY", "GET MY LOCATION");

        // What is my current location?

        // Get networking / GPS provider
        LocationManager locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);

        // getting GPS status
        boolean isGPSEnabled = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
        Log.i("MAINACTIVITY", "GPS enabled: " + String.valueOf(isGPSEnabled));

        // getting network status
        boolean isNetworkEnabled = locationManager
                .isProviderEnabled(LocationManager.NETWORK_PROVIDER);
        Log.i("MAINACTIVITY", "Network enabled: " + String.valueOf(isNetworkEnabled));

        if (isGPSEnabled && isNetworkEnabled) {
            //network provider is enabled
            Log.i("MAINACTIVITY", "Location & network provider enabled");
        } else {
            Log.i("MAINACTIVITY", "Location & network provider NOT enabled");
        }

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) !=
                PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) !=
                        PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            int p1 = ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION);
            int p2 = PackageManager.PERMISSION_GRANTED;
            int p3 = ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION);
            Log.i("MAINACTIVITY", "Problems with permissions");
            Log.i("MAINACTIVITY", String.valueOf(p1));
            Log.i("MAINACTIVITY", String.valueOf(p2));
            Log.i("MAINACTIVITY", String.valueOf(p3));
            return;
        } else {
            Log.i("MAINACTIVITY", "NO problems with permissions");
        }

        if (isNetworkEnabled) {
            //check the network permission
            Log.i("MAINACTIVITY", "Networked enabled");
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) !=
                    PackageManager.PERMISSION_GRANTED &&
                    ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) !=
                            PackageManager.PERMISSION_GRANTED) {
                // It opens the dialog box on the phone
                ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION,
                        Manifest.permission.ACCESS_COARSE_LOCATION}, 101);
            }
            Log.i("MAINACTIVITY", "Everything's perfect!");

            locationManager.requestLocationUpdates(
                    // Random numbers I put
                    LocationManager.NETWORK_PROVIDER,
                    2000,
                    50, this);

            Log.d("Network", "Network");
            if (locationManager != null) {
                Log.i("MAINACTIVITY", "Locationmanager not null");
                Location location = locationManager
                        .getLastKnownLocation(LocationManager.NETWORK_PROVIDER);

                if (location == null) {
                    Log.i("MAINACTIVITY", "Location null");
                }
                else {
                    Log.i("MAINACTIVITY", "Location not null");
                }

                if (location != null) {
                    Log.i("MAINACTIVITY", "Location not null");
                    double latitude = location.getLatitude();
                    double longitude = location.getLongitude();
                    Log.i("MAINACTIVITY", location.getLatitude() + " " + location.getLongitude());
                }
            }
        }

    }

    @Override
    public void onLocationChanged(@NonNull Location location) {
        Log.i("MAINACTIVITY onLocationChanged", location.getLatitude() + " " + location.getLongitude());
    }
}