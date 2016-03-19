package com.cfi.bhraman.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.cfi.bhraman.fragments.MonumentFragmnet;
import com.github.nitrico.mapviewpager.MapViewPager;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by yogesh on 19/3/16.
 */
public class MonumentAdapter extends MapViewPager.MultiAdapter {

    public static final String[] PAGE_TITLES = { "Akshardham Temple", "Rashtrapati Bhavan", "National Museum",
            "Jama Masjid", "India Gate and Rajpath", "Gurudwara Bangla Sahib" };

    public static final String[] ENGLAND_TITLES = { "Akshardham Temple" };
    public static final String[] FRANCE_TITLES = { "Rashtrapati Bhavan" };
    public static final String[] SPAIN_TITLES = { "National Museum" };
    public static final String[] PORTUGAL_TITLES = {"Jama Masjid"};
    public static final String[] ITALY_TITLES = { "India Gate and Rajpath" };
    public static final String[] BELGIUM_TITLES = { "Gurudwara Bangla Sahib" };

    public static final CameraPosition LONDON
            = CameraPosition.fromLatLngZoom(new LatLng(28.643851,77.299098), 6f);
    public static final CameraPosition PARIS
            = CameraPosition.fromLatLngZoom(new LatLng(28.614153,77.195962), 6f);
    public static final CameraPosition BARCELONA
            = CameraPosition.fromLatLngZoom(new LatLng(28.611799,77.219493), 6f);
    public static final CameraPosition MADRID
            = CameraPosition.fromLatLngZoom(new LatLng(28.650594,77.230328), 6f);

    public static final CameraPosition VALENCIA
            = CameraPosition.fromLatLngZoom(new LatLng(28.612912,77.22951), 6f);
    public static final CameraPosition MILAN
            = CameraPosition.fromLatLngZoom(new LatLng(28.62025,77.218437), 6f);
//    public static final CameraPosition ROME
//            = CameraPosition.fromLatLngZoom(new LatLng(41.9102415,12.3959121), 6f);
//    public static final CameraPosition BRUSSELS
//            = CameraPosition.fromLatLngZoom(new LatLng(50.8550625,4.3053499), 6f);

    private LinkedList<CameraPosition> england;
    private LinkedList<CameraPosition> france;
    private LinkedList<CameraPosition> spain;
    private LinkedList<CameraPosition> portugal;
    private LinkedList<CameraPosition> italy;
    private LinkedList<CameraPosition> belgium;

    public MonumentAdapter(FragmentManager fm) {
        super(fm);

        // camera positions
        england = new LinkedList<>();
        france = new LinkedList<>();
        spain = new LinkedList<>();
        portugal = new LinkedList<>();
        italy = new LinkedList<>();
        belgium = new LinkedList<>();

        england.add(LONDON);
        france.add(PARIS);
        spain.add(BARCELONA);
        portugal.add(MADRID);
//        spain.add(MADRID);
//        spain.add(VALENCIA);
        italy.add(VALENCIA);
      //  italy.add(ROME);
        belgium.add(MILAN);
    }

    @Override
    public int getCount() {
        return PAGE_TITLES.length;
    }

    @Override
    public Fragment getItem(int position) {
        return MonumentFragmnet.newInstance("null", position);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return PAGE_TITLES[position];
    }

    @Override
    public String getMarkerTitle(int page, int position) {
        switch (page) {
            case 0: return ENGLAND_TITLES[position];
            case 1: return FRANCE_TITLES[position];
            case 2: return SPAIN_TITLES[position];
            case 3: return PORTUGAL_TITLES[position];
            case 4: return ITALY_TITLES[position];
            case 5: return BELGIUM_TITLES[position];
        }
        return null;
    }

    @Override
    public List<CameraPosition> getCameraPositions(int page) {
        switch (page) {
            case 0: return england;
            case 1: return france;
            case 2: return spain;
            case 3: return portugal;
            case 4: return italy;
            case 5: return belgium;
        }
        return null;
    }

}