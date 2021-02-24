package com.example.vldattractions.utils;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import com.example.vldattractions.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsFragment extends Fragment {
    private GoogleMap map;
    private NestedScrollView scrollView;
    private String coordinates;
    private String mapPointCaption;
    private double lat;
    private double lng;
    public MapsFragment(String coordinates, String mapPointCaption) {
        this.coordinates = coordinates;
        this.mapPointCaption = mapPointCaption;
    }

    private OnMapReadyCallback callback = new OnMapReadyCallback() {

        @Override
        public void onMapReady(GoogleMap googleMap) {
            parseCoordinates();
            map = googleMap;
            map.setMapType(GoogleMap.MAP_TYPE_NORMAL);
            map.getUiSettings().setZoomControlsEnabled(true);
            map.getUiSettings().setMapToolbarEnabled(true);
            scrollView = getActivity().findViewById(R.id.scroll_content);
            ((ScrollableSupMap) getChildFragmentManager().findFragmentById(R.id.map)).setOnTouchListener(new ScrollableSupMap.OnTouchListener() {
                @Override
                public void onTouch() {
                    scrollView.requestDisallowInterceptTouchEvent(true);
                }
            });
            LatLng mark = new LatLng(lat, lng);
            map.addMarker(new MarkerOptions().position(mark).title(mapPointCaption));
            map.moveCamera(CameraUpdateFactory.newLatLngZoom(mark, 14f));
        }
    };

    private void parseCoordinates() {
        String s = coordinates.substring(0, coordinates.indexOf(","));
        String d = coordinates.substring(coordinates.indexOf(",") + 1);
        lat = Double.parseDouble(s);
        lng = Double.parseDouble(d);
    }
//    private void parseCoordRes(String coord) {
//        String coordinates = "43.10940662109832,131.89620329110045;43.06439528860409,131.90847930947993";
//        ArrayList<String> list = new ArrayList<>();
//        if (coordinates.contains(";")) {
//            for (String s : coordinates.split(";")) {
//                list.add(s);
//            }
//        } else {
//            list.add(coordinates);
//        }
//    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_maps, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SupportMapFragment mapFragment =
                (ScrollableSupMap) getChildFragmentManager().findFragmentById(R.id.map);
        if (mapFragment != null) {
            mapFragment.getMapAsync(callback);
        }
    }
}