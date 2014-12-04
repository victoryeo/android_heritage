package com.world.heritage;

import java.util.ArrayList;
import java.util.HashSet;

import com.world.heritage.R;


import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TabHost;
import android.widget.TabWidget;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class ContinentFragment extends Fragment {
	public static String TAG = "ContinentFragment";
	
	public static final ContinentFragment newInstance(String sampleText) {
		ContinentFragment f = new ContinentFragment();

		Bundle b = new Bundle();
		if (b != null)
			b.putString("bString", sampleText);
		if (f != null)
			f.setArguments(b);
		return f;
	}

	private View mView;
	private GridView gridView;
	private ArrayAdapterContinent pAdapter;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
		StrictMode.setThreadPolicy(policy);		
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		mView = inflater.inflate(R.layout.fragment_country, container, false);
			
		getArguments().getString("key");

		return mView;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState){
		super.onActivityCreated(savedInstanceState);
		gridView = (GridView) mView.findViewById(R.id.gridView1);
	}
	
	@Override
	public void onResume(){
		super.onResume();
		
		Log.i(TAG, "I'm visible onResume()");
		if (gridView == null) {
			Log.d(TAG, "gridView is null");
		} else {
			pAdapter = new ArrayAdapterContinent(getActivity(), R.layout.special_continent_container, getCountryList(),
					"Country");
			gridView.setAdapter(pAdapter);
			
			gridView.setOnItemClickListener(new OnItemClickListener() {
				public void onItemClick(AdapterView<?> parent, View v,
						int position, long id) {
					
					gridView.setEnabled(false);
					
					//parent.getItemAtPosition(position);

					ClassProfile thisPatient1 = (ClassProfile) parent.getItemAtPosition(position);
					if (thisPatient1 == null) {
						
						Log.d(TAG, "No continents available");
						
						Toast.makeText(getActivity(), "No continents available", Toast.LENGTH_SHORT).show();
						
					} else {
						Intent intent = new Intent();
						intent.setClass(getActivity(),	RegionActivity.class);
						intent.putExtra("id", id);
						startActivityForResult(intent, 0);				
					}
				}
			});
			pAdapter.notifyDataSetChanged();
		}
						
	}
	
	private ArrayList<ClassProfile> getCountryList(){
		
		ArrayList<ClassProfile> warnings = new ArrayList<ClassProfile>();
		
		ArrayList<String> name = new ArrayList<String>();
	    name.add("Africa");
	    name.add("America");
	    name.add("Asia");
	    name.add("Europe");
	    name.add("Oceania");
	    
	    ArrayList<String> region = new ArrayList<String>();
	    region.add("");	    region.add("");	    region.add("");	    region.add("");	    region.add("");
	    
	    ArrayList<String> subregion = new ArrayList<String>();
	    subregion.add("");	    subregion.add("");   subregion.add("");   subregion.add("");   subregion.add("");
	    
	    ArrayList<String> imageUrl = new ArrayList<String>();
	    imageUrl.add("africa"); imageUrl.add("america"); imageUrl.add("asia"); imageUrl.add("europe"); imageUrl.add("oceania");
	    
		for (Integer i = 0; i < name.size(); i++){
			ClassProfile criticalPatient = new ClassProfile(i, i, name.get(i) , region.get(i), subregion.get(i), imageUrl.get(i), 0);
			warnings.add(criticalPatient);
		}
		//HashSet<ClassProfile> patientHashing = new HashSet<ClassProfile>();
		//patientHashing.addAll(warnings);
		//warnings.clear();
		//warnings.addAll(patientHashing);
		
		return warnings;
	}
	
	private void refreshAdapter(){
		pAdapter = new ArrayAdapterContinent(getActivity(), R.layout.special_continent_container, getCountryList(), "Country");
		pAdapter.notifyDataSetChanged();
		gridView.setAdapter(pAdapter);
		gridView.refreshDrawableState();
	}	
}
