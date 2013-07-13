package com.flipboxstudio.aqid.mapexample;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.google.android.gms.maps.model.LatLng;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ListActivity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * @author Bukhori Muhammad Aqid
 * 
 */
public class LocationListActivity extends ListActivity {

	@Override
	public void onCreate(Bundle savedInstanceState) {

		final ArrayList<Pair<String, LatLng>> locationList = initializeDestination();
		final LatLng myLocation = initializeMyLocation();

		super.onCreate(savedInstanceState);

		// melakukan pembuatan list view berdasarkan list lokasi yang telah
		// dibuat sebelumnya
		String[] location_names = new String[locationList.size()];
		for (int i = 0; i <= location_names.length - 1; i++) {
			location_names[i] = locationList.get(i).first;
		}

		setListAdapter(new ArrayAdapter<String>(this, R.layout.location_list,
				location_names));

		ListView listView = getListView();
		listView.setTextFilterEnabled(true);

		listView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {

				final int count = arg2;
				String[] options = { "get route", "view on map" };
				AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
						LocationListActivity.this);
				// set title
				alertDialogBuilder.setTitle("Choose Actions");
				alertDialogBuilder.setItems(options,
						new DialogInterface.OnClickListener() {

							@Override
							public void onClick(DialogInterface dialog,
									int which) {
								if (which == 0) {
									Intent intent = new Intent(
											android.content.Intent.ACTION_VIEW,
											Uri.parse("http://maps.google.com/maps?saddr="
													+ myLocation.latitude
													+ ","
													+ myLocation.longitude
													+ "&daddr="
													+ locationList.get(count).second.latitude
													+ ","
													+ locationList.get(count).second.longitude));
									intent.setClassName(
											"com.google.android.apps.maps",
											"com.google.android.maps.MapsActivity");
									startActivity(intent);
								} else if (which == 1) {
									Intent i = new Intent(
											getApplicationContext(),
											MapActivity.class);

									i.putExtra("name",
											locationList.get(count).first);

									i.putExtra(
											"lat",
											locationList.get(count).second.latitude);
									i.putExtra(
											"long",
											locationList.get(count).second.longitude);
									startActivity(i);
								} else {
									Toast.makeText(LocationListActivity.this,
											"unexplicable error happened!!",
											Toast.LENGTH_LONG).show();

								}
							}
						});

				// create alert dialog
				AlertDialog alertDialog = alertDialogBuilder.create();

				// show it
				alertDialog.show();
			}
		});

	}

	public LatLng initializeMyLocation() {
		/* inisialisasi lokasi asal (Pesona Khayangan) */
		LatLng myLocation = new LatLng(-6.383490, 106.834987);
		
		return myLocation;
	}

	/**
	 * @return list lokasi tempat tujuan
	 */
	public ArrayList<Pair<String, LatLng>> initializeDestination() {

		// inisialisasi koordinat - koordinat tempat tujuan
		ArrayList<Pair<String, LatLng>> locations = new ArrayList<Pair<String, LatLng>>();

		// tambahkan satu per satu koordinat dan nama tempat yang dituju
		Pair<String, LatLng> location = new Pair<String, LatLng>(
				"Stasiun Pondok Cina", new LatLng(-6.369642, 106.831924));
		locations.add(location);

		location = new Pair<String, LatLng>("Kampus D Gunadarma", new LatLng(
				-6.369056, 106.833158));
		locations.add(location);

		location = new Pair<String, LatLng>("Fasilkom UI", new LatLng(
				-6.364716, 106.828705));
		locations.add(location);

		return locations;
	}
}
