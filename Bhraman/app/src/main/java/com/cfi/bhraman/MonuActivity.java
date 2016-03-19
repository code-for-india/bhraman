package com.cfi.bhraman;

import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;

import com.cfi.bhraman.adapter.MonumentAdapter;
import com.github.nitrico.mapviewpager.MapViewPager;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MonuActivity extends FragmentActivity implements OnMapReadyCallback, MapViewPager.Callback {

    private GoogleMap mMap;
    private ViewPager viewPager;
    private MapViewPager mvp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monu);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        SupportMapFragment map = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        viewPager.setPageMargin(utils.dp(this, 18));
        utils.setMargins(viewPager, 0, 0, 0, utils.getNavigationBarHeight(this));

        mvp = new MapViewPager.Builder(this)
                .mapFragment(map)
                .viewPager(viewPager)
                .position(2)
                .adapter(new MonumentAdapter(getSupportFragmentManager()))
                .callback(this)
                .build();
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
    }

    @Override
    public void onMapViewPagerReady() {
        mvp.getMap().setPadding(
                0,
                utils.dp(this, 40),
                utils.getNavigationBarWidth(this),
                viewPager.getHeight() + utils.getNavigationBarHeight(this));
    }
}
