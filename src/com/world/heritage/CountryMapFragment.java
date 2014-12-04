package com.world.heritage;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.world.heritage.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class CountryMapFragment extends Fragment {
	public static String TAG = "CountryMapFragment";

	public static final CountryMapFragment newInstance(String sampleText) {
		CountryMapFragment f = new CountryMapFragment();

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

	private GoogleMap mMap;
	private Double latitude, longitude;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		if (savedInstanceState != null) {
			// savedInstanceState.remove("android:support:fragments");
			// savedInstanceState.remove("com.google.android.gms.maps.SupportMapFragment");
		}
	}

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
			view = (RelativeLayout) inflater.inflate(R.layout.map_fragment,
					container, false);
	    	
			// Passing harcoded values for latitude & longitude. Please change as
			// per your need. This is just used to drop a Marker on the Map
			if ((((CountryActivity) getActivity()).getContinentId() == 0)
					&& (((CountryActivity) getActivity()).getRegionId() == 0))
			{
		           latitude = -7.881;
		           longitude = 21.09;
		    } else if ((((CountryActivity) getActivity()).getContinentId() == 0)
					&& (((CountryActivity) getActivity()).getRegionId() == 1)) {
		    	   latitude = -5.881;
		           longitude = 35.09;
		    	
		    } else if ((((CountryActivity) getActivity()).getContinentId() == 0)
					&& (((CountryActivity) getActivity()).getRegionId() == 2)) {
		    		latitude = 17.881;
		    		longitude = 19.09;
		    	
		    } else if ((((CountryActivity) getActivity()).getContinentId() == 0)
					&& (((CountryActivity) getActivity()).getRegionId() == 3)) {
		    		latitude = -19.881;
		    		longitude = 21.09;
		    	
		    } else if ((((CountryActivity) getActivity()).getContinentId() == 0)
					&& (((CountryActivity) getActivity()).getRegionId() == 4)){
		    		latitude = 1.881;
		    		longitude = 9.09;	    	
		    } else if ((((CountryActivity) getActivity()).getContinentId() == 1)
					&& (((CountryActivity) getActivity()).getRegionId() == 0)) {
	    		latitude = 18.88;
	    		longitude = -87.56;
		    } else if ((((CountryActivity) getActivity()).getContinentId() == 1)
					&& (((CountryActivity) getActivity()).getRegionId() == 1)) {
	    		latitude = 52.88;
	    		longitude = -93.56;
		    } else if ((((CountryActivity) getActivity()).getContinentId() == 1)
					&& (((CountryActivity) getActivity()).getRegionId() == 2)) {
	    		latitude = -38.88;
	    		longitude = -74.56;
		    } else if ((((CountryActivity) getActivity()).getContinentId() == 2)
					&& (((CountryActivity) getActivity()).getRegionId() == 0)) {
	            latitude = 38.88;
	            longitude = 76.67;
		    } else if ((((CountryActivity) getActivity()).getContinentId() == 2)
					&& (((CountryActivity) getActivity()).getRegionId() == 1)) {
	            latitude = 29.88;
	            longitude = 126.67;
		    } else if ((((CountryActivity) getActivity()).getContinentId() == 2)
					&& (((CountryActivity) getActivity()).getRegionId() == 2))  {
	            latitude = -12.88;
	            longitude = 76.67;

		    } else if ((((CountryActivity) getActivity()).getContinentId() == 2)
					&& (((CountryActivity) getActivity()).getRegionId() == 3))  {
	            latitude = -3.88;
	            longitude = 116.67;    	
		    } else if ((((CountryActivity) getActivity()).getContinentId() == 2)
					&& (((CountryActivity) getActivity()).getRegionId() == 4)) {
	            latitude = 10.88;
	            longitude = 46.67;	
		    } else if ((((CountryActivity) getActivity()).getContinentId() == 3)
					&& (((CountryActivity) getActivity()).getRegionId() == 0)){
	            latitude = 51.1;
	            longitude = 22.7;
		    	
		    } else if ((((CountryActivity) getActivity()).getContinentId() == 3)
					&& (((CountryActivity) getActivity()).getRegionId() == 1)){
	            latitude = 61.1;
	            longitude = 37.7;
		    	
		    } else if ((((CountryActivity) getActivity()).getContinentId() == 3)
					&& (((CountryActivity) getActivity()).getRegionId() == 2)){
	            latitude = 71.1;
	            longitude = 17.7;
		    	
		    } else if ((((CountryActivity) getActivity()).getContinentId() == 3)
					&& (((CountryActivity) getActivity()).getRegionId() == 3)){
	            latitude = 41.1;
	            longitude = 27.7;
		    	
		    } else if ((((CountryActivity) getActivity()).getContinentId() == 3)
					&& (((CountryActivity) getActivity()).getRegionId() == 4)){
	            latitude = 41.1;
	            longitude = 1.7;
		    	
		    } else if ((((CountryActivity) getActivity()).getContinentId() == 4)
					&& (((CountryActivity) getActivity()).getRegionId() == 0)) {
	            latitude = -5.1;
	            longitude = 133.2;
		    } else if ((((CountryActivity) getActivity()).getContinentId() == 4)
					&& (((CountryActivity) getActivity()).getRegionId() == 1))  {
	            latitude = 1.1;
	            longitude = 149.2;
		    }

			
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
			// mMap = ((SupportMapFragment) RegionActivity.fragmentManager
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
		} else {
			mMap.clear();
			setUpMap();
		}
	}

	/**
	 * This is where we can add markers or lines, add listeners or move the
	 * camera.
	 * <p>
	 * This should only be called once and when we are sure that {@link #mMap}
	 * is not null.
	 */
	private void setUpMap() {
		// For showing a move to my loction button
		mMap.setMyLocationEnabled(true);
		// For dropping a marker at a point on the Map
		LatLng latlng=new LatLng(latitude, longitude);
		//mMap.addMarker(new MarkerOptions().position(latlng).title("My Home").snippet("Home Address"));
		
		mMap.moveCamera(CameraUpdateFactory.newLatLng(latlng));//Moves the camera to users current longitude and latitude
		// For zooming automatically to the Dropped PIN Location
		mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latlng, 4.0f));
	}

	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		
		 if (mMap != null) 
			 setUpMap();
		 
		 /*if (mMap == null) { 
			 // Try to obtain the map from the SupportMapFragment. 
			 mMap = ((SupportMapFragment) CountryActivity.fragmentManager
		    		 .findFragmentById(R.id.location_map)).getMap(); 
		     // Check if we were successful in obtaining the map. 
		     if (mMap != null) 
		    	 setUpMap(); 
		  }*/
		 
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
		/*if (mMap != null) {
			CountryActivity.fragmentManager
					.beginTransaction()
					.remove(CountryActivity.fragmentManager
							.findFragmentById(R.id.location_map))
					.commitAllowingStateLoss();
			mMap = null;
		}*/
	}

}