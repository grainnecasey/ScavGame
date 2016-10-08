package com.example.grainne.scavgame;

import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity {

    private GoogleMap mMap; // Might be null if Google Play services APK is not available.
    double[][] coords = new double[7][2];
    Location x;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        setUpMapIfNeeded();


        /*
    42.524748,-71.221619
    42.524242,-71.062317
    42.366408,-71.062317
    42.359812,-71.066093
    42.359051,-71.106262
    42.340021,-71.089439
    42.313624,-71.088409
     */
        coords[0][0] = 42.524748;
        coords[0][1] = -71.221619;
        coords[1][0] = 42.524242;
        coords[1][1] = -71.062317;
        coords[2][0] = 42.366408;
        coords[2][1] = -71.062317;
        coords[3][0] = 42.359812;
        coords[3][1] = -71.066093;
        coords[4][0] = 42.359051;
        coords[4][1] = -71.106262;
        coords[5][0] = 42.524242;
        coords[5][1] = 42.524242;
        coords[6][0] = 42.524242;
        coords[6][1] = 42.524242;
    }

    @Override
    protected void onResume() {
        super.onResume();
        setUpMapIfNeeded();
    }

    /**
     * Sets up the map if it is possible to do so (i.e., the Google Play services APK is correctly
     * installed) and the map has not already been instantiated.. This will ensure that we only ever
     * call {@link #setUpMap()} once when {@link #mMap} is not null.
     * <p/>
     * If it isn't installed {@link SupportMapFragment} (and
     * {@link com.google.android.gms.maps.MapView MapView}) will show a prompt for the user to
     * install/update the Google Play services APK on their device.
     * <p/>
     * A user can return to this FragmentActivity after following the prompt and correctly
     * installing/updating/enabling the Google Play services. Since the FragmentActivity may not
     * have been completely destroyed during this process (it is likely that it would only be
     * stopped or paused), {@link #onCreate(Bundle)} may not be called again so we should call this
     * method in {@link #onResume()} to guarantee that it will be called.
     */
    private void setUpMapIfNeeded() {
        // Do a null check to confirm that we have not already instantiated the map.
        if (mMap == null) {
            // Try to obtain the map from the SupportMapFragment.
            mMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map))
                    .getMap();
            // Check if we were successful in obtaining the map.
            if (mMap != null) {
                setUpMap();
            }
        }
    }

    /**
     * This is where we can add markers or lines, add listeners or move the camera. In this case, we
     * just add a marker near Africa.
     * <p/>
     * This should only be called once and when we are sure that {@link #mMap} is not null.
     */
    private void setUpMap() {

        // Enable MyLocation Layer of Google Map
        mMap.setMyLocationEnabled(true);

        if (mMap.getMyLocation() != null) {
            x = mMap.getMyLocation();
        }

        coords[0][0] = 42.524748;
        coords[0][1] = -71.221619;
        coords[1][0] = 42.524242;
        coords[1][1] = -71.062317;
        coords[2][0] = 42.366408;
        coords[2][1] = -71.062317;
        coords[3][0] = 42.359812;
        coords[3][1] = -71.066093;
        coords[4][0] = 42.359051;
        coords[4][1] = -71.106262;
        coords[5][0] = 42.524242;
        coords[5][1] = 42.524242;
        coords[6][0] = 42.524242;
        coords[6][1] = 42.524242;

        mMap.addMarker(new MarkerOptions().position(new LatLng(coords[0][0], coords[0][1]))
                .title("Destination 1").snippet("Distance: " + calculateDistance(coords[0][0], coords[0][1], 0, 0)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(coords[1][0], coords[1][1]))
                .title("Destination 2").snippet("Distance: " + calculateDistance(coords[1][0], coords[1][1], 0, 0)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(coords[2][0], coords[2][1]))
                .title("Destination 2").snippet("Distance: " + calculateDistance(coords[2][0], coords[2][1], 0, 0)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(coords[3][0], coords[3][1]))
                .title("Destination 2").snippet("Distance: " + calculateDistance(coords[3][0], coords[3][1], 0, 0)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(coords[4][0], coords[4][1]))
                .title("Destination 2").snippet("Distance: " + calculateDistance(coords[4][0], coords[4][1], 0, 0)));


        if (mMap.getMyLocation() != null) {
            mMap.addMarker(new MarkerOptions().position(new LatLng(x.getLatitude(), x.getLongitude()))
                    .title("Destination 2").snippet("Distance: " + calculateDistance(x.getLatitude(), x.getLongitude(), 0, 0)));
        }
    }

    private double calculateDistance (double lat1, double lon1, double lat2, double lon2) {

        double theta = lon1 - lon2;
        double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2)) + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));
        dist = Math.acos(dist);
        dist = rad2deg(dist);
        dist = dist * 60 * 1.1515;

        return (dist);
    }

    /*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
	/*::	This function converts decimal degrees to radians						 :*/
	/*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
    private static double deg2rad(double deg) {
        return (deg * Math.PI / 180.0);
    }

    /*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
	/*::	This function converts radians to decimal degrees						 :*/
	/*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
    private static double rad2deg(double rad) {
        return (rad * 180 / Math.PI);
    }
}

//© 2016 Microsoft Terms Privacy & cookies Developers English (United States)
