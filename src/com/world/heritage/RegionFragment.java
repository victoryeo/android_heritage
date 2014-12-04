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

public class RegionFragment extends Fragment {
	public static String TAG = "RegionFragment";

	public static final RegionFragment newInstance(String sampleText) {
		RegionFragment f = new RegionFragment();

		Bundle b = new Bundle();
		if (b != null)
			b.putString("bString", sampleText);
		if (f != null)
			f.setArguments(b);
		return f;
	}

	private View mView;
	private GridView gridView;
	private ArrayAdapterRegion pAdapter;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
				.permitAll().build();
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
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		gridView = (GridView) mView.findViewById(R.id.gridView1);
	}

	@Override
	public void onResume() {
		super.onResume();

		Log.i(TAG, "I'm visible onResume()");
		if (gridView == null) {
			Log.d(TAG, "gridView is null");
		} else {
			pAdapter = new ArrayAdapterRegion(getActivity(),
					R.layout.special_continent_container, getCountryList(),
					"Country");
			gridView.setAdapter(pAdapter);

			gridView.setOnItemClickListener(new OnItemClickListener() {
				public void onItemClick(AdapterView<?> parent, View v,
						int position, long id) {

					gridView.setEnabled(false);

					// parent.getItemAtPosition(position);

					ClassProfile thisPatient1 = (ClassProfile) parent
							.getItemAtPosition(position);
					if (thisPatient1 == null) {

						Log.d(TAG, "No continents available");

						Toast.makeText(getActivity(),
								"No continents available", Toast.LENGTH_SHORT)
								.show();

					} else {
						Intent intent = new Intent();
						intent.setClass(getActivity(), CountryActivity.class);
						intent.putExtra("id", id);
						intent.putExtra("continent_id",
								((RegionActivity) getActivity())
										.getContinentId());
						startActivityForResult(intent, 0);
					}
				}
			});
			pAdapter.notifyDataSetChanged();
		}

	}

	private ArrayList<ClassProfile> getCountryList() {

		ArrayList<ClassProfile> warnings = new ArrayList<ClassProfile>();

		ArrayList<String> name = new ArrayList<String>();
		ArrayList<String> region = new ArrayList<String>();
		ArrayList<String> subregion = new ArrayList<String>();
		ArrayList<String> imageUrl = new ArrayList<String>();

		if (((RegionActivity) getActivity()).getContinentId() == 0) {
			name.add("Central Africa");
			name.add("East Africa");
			name.add("North Africa");
			name.add("South Africa");
			name.add("West Africa");
			region.add("");
			region.add("");
			region.add("");
			region.add("");
			region.add("");

			imageUrl.add("africa_central");
			imageUrl.add("africa_east");
			imageUrl.add("africa_north");
			imageUrl.add("africa_south");
			imageUrl.add("africa_west");

		} else if (((RegionActivity) getActivity()).getContinentId() == 1) {
			name.add("Central America");
			name.add("North America");
			name.add("South America");
			region.add("");
			region.add("");
			region.add("");
			imageUrl.add("america_central");
			imageUrl.add("america_north");
			imageUrl.add("america_south");
		} else if (((RegionActivity) getActivity()).getContinentId() == 2) {
			name.add("Central Asia");
			name.add("East Asia");
			name.add("South Asia");
			name.add("South East Asia");
			name.add("West Asia");
			region.add("");
			region.add("");
			region.add("");
			region.add("");
			region.add("");
			imageUrl.add("asia_central");
			imageUrl.add("asia_east");
			imageUrl.add("asia_south");
			imageUrl.add("asia_south_east");
			imageUrl.add("asia_west");		
		} else if (((RegionActivity) getActivity()).getContinentId() == 3) {
			name.add("Central Europe");
			name.add("East Europe");
			name.add("North Europe");
			name.add("South Europe");
			name.add("West Europe");
			region.add("");
			region.add("");
			region.add("");
			region.add("");
			region.add("");
			imageUrl.add("europe_central");
			imageUrl.add("europe_east");
			imageUrl.add("europe_north");
			imageUrl.add("europe_south");
			imageUrl.add("europe_west");
		} else if (((RegionActivity) getActivity()).getContinentId() == 4) {
			name.add("Australia & NZ");
			name.add("Pacific Islands");
			region.add("");
			region.add("");
			imageUrl.add("anz");
			imageUrl.add("pacificislands");
			
		}

		for (Integer i = 0; i < name.size(); i++) {
			ClassProfile criticalPatient = new ClassProfile(i, i, name.get(i),
					region.get(i), null, imageUrl.get(i), 0);
			warnings.add(criticalPatient);
		}
		// HashSet<ClassProfile> patientHashing = new HashSet<ClassProfile>();
		// patientHashing.addAll(warnings);
		// warnings.clear();
		// warnings.addAll(patientHashing);

		return warnings;
	}

	private void refreshAdapter() {
		pAdapter = new ArrayAdapterRegion(getActivity(),
				R.layout.special_continent_container, getCountryList(), "Country");
		pAdapter.notifyDataSetChanged();
		gridView.setAdapter(pAdapter);
		gridView.refreshDrawableState();
	}

}
