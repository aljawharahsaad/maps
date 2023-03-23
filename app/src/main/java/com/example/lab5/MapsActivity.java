package com.example.lab5;


import androidx.fragment.app.FragmentActivity;
import android.os.Bundle;
import android.widget.Toast;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


public class MapsActivity extends FragmentActivity implements
        OnMapReadyCallback, GoogleMap.OnCameraMoveStartedListener,
        GoogleMap.OnCameraMoveListener,
        GoogleMap.OnCameraMoveCanceledListener,
        GoogleMap.OnCameraIdleListener {
    private GoogleMap mMap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment)
                getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        // Add a marker in Sydney and move the camera LatLng sydney = new LatLng(-34, 151);
        LatLng uj_loc = new LatLng(21.913, 39.263);
        mMap.addMarker(new MarkerOptions().position(uj_loc).title("Marker in UJ"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(uj_loc));
        mMap.setOnCameraIdleListener(this);
        mMap.setOnCameraMoveStartedListener(this);
        mMap.setOnCameraMoveListener(this);
        mMap.setOnCameraMoveCanceledListener(this);
    }
    @Override
    public void onCameraMoveStarted(int reason) {
        if (reason == GoogleMap.OnCameraMoveStartedListener.REASON_GESTURE) {
            Toast.makeText(this, "The user gestured on the map.", Toast.LENGTH_SHORT).show();
        }
        else if (reason == GoogleMap.OnCameraMoveStartedListener.REASON_API_ANIMATION) {
            Toast.makeText(this, "The user tapped something on the map.", Toast.LENGTH_SHORT).show();
        }
        else if (reason == GoogleMap.OnCameraMoveStartedListener.REASON_DEVELOPER_ANIMATION) {
            Toast.makeText(this, "The app moved the camera.", Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    public void onCameraMove() {
        Toast.makeText(this, "The camera is moving.", Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onCameraMoveCanceled() {
        Toast.makeText(this, "Camera movement canceled.", Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onCameraIdle() {
        Toast.makeText(this, "The camera has stopped moving.", Toast.LENGTH_SHORT).show();
    }
}
