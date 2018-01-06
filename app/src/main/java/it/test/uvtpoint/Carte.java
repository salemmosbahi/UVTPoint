package it.test.uvtpoint;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class Carte extends Activity {

    private MapView mMapView;
    private GoogleMap mGoogleMap;
    private CameraPosition mCameraPosition;

    private String name;
    private double latitude;
    private double longitude;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            name = extras.getString("name");
            latitude = extras.getDouble("latitude");
            longitude = extras.getDouble("longitude");
        }

        mMapView = (MapView) findViewById(R.id.mapView);
        mMapView.onCreate(savedInstanceState);
        mMapView.onResume();

        try {
            MapsInitializer.initialize(getApplicationContext());
        } catch (Exception e) {
            e.printStackTrace();
        }

        mMapView.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap pGoogleMap) {
                pGoogleMap.getUiSettings().setZoomControlsEnabled(true);
                mGoogleMap = pGoogleMap;
                if (null != name) {
                    mCameraPosition = new CameraPosition.Builder().target(new LatLng(latitude, longitude)).zoom(15).build();
                    MarkerOptions market = new MarkerOptions().position(new LatLng(latitude, longitude)).title(name);
                    market.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED));
                    mGoogleMap.addMarker(market);
                    mGoogleMap.animateCamera(CameraUpdateFactory.newCameraPosition(mCameraPosition));
                }
            }
        });
    }
}
