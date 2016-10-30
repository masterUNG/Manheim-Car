package appewtc.masterung.manheimcar;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;

public class DetailActivity extends FragmentActivity implements OnMapReadyCallback {

    //Explicit
    private GoogleMap mMap;
    private String nameString, latString, lngString;
    private Double latADouble, lngADouble;
    private LatLng latLng;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_detail);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        //Get Value from Intent
        nameString = getIntent().getStringExtra("Name");
        latString = getIntent().getStringExtra("Lat");
        lngString = getIntent().getStringExtra("Lng");

        Log.d("30octV3", "latSting ==> " + latString);
        Log.d("30octV3", "lngSting ==> " + lngString);



    }   // Main Method


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        latADouble = Double.parseDouble(latString);
        lngADouble = Double.parseDouble(lngString);
        latLng = new LatLng(latADouble, lngADouble);

        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 16));


    }   // onMapReady

}   // Main Class
