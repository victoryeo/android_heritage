package com.world.heritage;

import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.world.heritage.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.MapFragment;

public class ContinentMapFragment extends Fragment {
	public static String TAG = "MapFragment";

	public static final ContinentMapFragment newInstance(String sampleText) {
		ContinentMapFragment f = new ContinentMapFragment();

		Bundle b = new Bundle();
		if (b != null)
			b.putString("bString", sampleText);
		if (f != null)
			f.setArguments(b);
		return f;
	}

	private static View view;
	/**
	 * Note that this may be null if the Google Play services APK is not
	 * available.
	 */

	private static GoogleMap mMap;
	private static Double latitude, longitude;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		if (container == null) {
			return null;
		}
		
		if (view != null) {
	        ViewGroup parent = (ViewGroup) view.getParent();
	        if (parent != null)
	            parent.removeView(view);
	    }
	    try {
	    	view = (RelativeLayout) inflater.inflate(R.layout.continent_map_fragment,
					container, false);
	    	
			// Passing harcoded values for latitude & longitude. Please change as
			// per your need. This is just used to drop a Marker on the Map
			latitude = 26.78;
			longitude = 72.56;
			
	    } catch (InflateException e) {
	        /* map is already there, just return view as it is */
	    }
	    return view;

	}

	@Override
	public void onResume() {
		super.onResume();
		setUpMapIfNeeded(); // For setting up the MapFragment
	}

	/***** Sets up the map if it is possible to do so *****/
	public void setUpMapIfNeeded() {
		// Do a null check to confirm that we have not already instantiated the
		// map.
		if (mMap == null) {
			// Try to obtain the map from the SupportMapFragment.
			// mMap = ((SupportMapFragment) ContinentActivity.fragmentManager
			// .findFragmentById(R.id.location_map)).getMap();

			new Handler().postDelayed(new Runnable() {
				@Override
				public void run() {
					mMap = ((MapFragment) getActivity().getFragmentManager()
							.findFragmentById(R.id.location_map)).getMap();
					if (mMap != null)
						setUpMap();
				}
			}, 500);

			// Check if we were successful in obtaining the map.

		}
	}

	/**
	 * This is where we can add markers or lines, add listeners or move the
	 * camera.
	 * 
	 * This should only be called once and when we are sure that {@link #mMap}
	 * is not null.
	 */
	private void setUpMap() {
		mMap.setMyLocationEnabled(true);// Makes the users current location
										// visible by displaying a blue dot.

		LocationManager lm = (LocationManager) getActivity().getSystemService(
				Context.LOCATION_SERVICE);// use of location services by firstly
											// defining location manager.
		String provider = lm.getBestProvider(new Criteria(), true);
		if (provider == null) {
			// onProviderDisabled(provider);
		}
		Location loc = lm.getLastKnownLocation(provider);

		if (loc != null) {
			LatLng latlng = new LatLng(loc.getLatitude(), loc.getLongitude());// This
																				// methods
																				// gets
																				// the
																				// users
																				// current
																				// longitude
																				// and
																				// latitude.
			mMap.addMarker(new MarkerOptions().position(latlng)
					.title("My Home").snippet("Home Address"));
			mMap.moveCamera(CameraUpdateFactory.newLatLng(latlng));// Moves the
																	// camera to
																	// users
																	// current
																	// longitude
																	// and
																	// latitude
			mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latlng,
					(float) 2));// Animates camera and zooms to preferred state
								// on the user's current location.
		}

		// For showing a move to my loction button
		//mMap.setMyLocationEnabled(true);
		// For dropping a marker at a point on the Map
		//mMap.addMarker(new MarkerOptions().position(new LatLng(latitude,
		//   longitude)).title("My Home").snippet("Home Address"));
		// For zooming automatically to the Dropped PIN Location
		//mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new
		//   LatLng(latitude, longitude), 1.0f));
	}

	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		if (mMap != null)
			setUpMap();

		/*
		 * if (mMap == null) {
		 * 
		 * new Handler().postDelayed(new Runnable() {
		 * 
		 * @Override public void run() { FragmentManager fmgr =
		 * ContinentActivity.fragmentManager; Fragment f =
		 * fmgr.findFragmentById(R.id.location_map); mMap =
		 * ((SupportMapFragment) f).getMap(); if (mMap != null) setUpMap(); } },
		 * 500);
		 * 
		 * }
		 */
	}

	/****
	 * The mapfragment's id must be removed from the FragmentManager or else if
	 * the same it is passed on the next time then app will crash
	 ****/

	@Override
	public void onSaveInstanceState(Bundle state) {
		if (mMap != null) 
		{ 			 
			getActivity().getFragmentManager().beginTransaction().remove(getActivity().getFragmentManager()
					.findFragmentById(R.id.location_map)) .commitAllowingStateLoss();
			mMap = null; 
		}
		super.onSaveInstanceState(state);
	}

	@Override
	public void onDestroyView() {
		super.onDestroyView();
		
		/*if (mMap != null) 
		{ 			 
			getActivity().getFragmentManager().beginTransaction().remove(getActivity().getFragmentManager()
					.findFragmentById(R.id.location_map)) .commitAllowingStateLoss();
			mMap = null; 
		}*/
		 			
	}

}
