package com.flipboxstudio.aqid.mapexample;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;

public class MapActivity extends FragmentActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_map);
		
		Bundle bndl = getIntent().getExtras();
		
		//inisialiasi marker location
		LatLng location = new LatLng(bndl.getDouble("lat"), bndl.getDouble("long"));
		
		GoogleMap mMap;
		mMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map)).getMap();
		mMap.addMarker(new MarkerOptions()
		        .position(location)
		        .title(bndl.getString("name")));
		
		// Move the camera instantly to location with a zoom of 15.
		mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(location, 15));
		
	}

}
