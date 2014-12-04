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

public class CountryFragment extends Fragment {
	public static String TAG = "CountryFragment";

	public static final CountryFragment newInstance(String sampleText) {
		CountryFragment f = new CountryFragment();

		Bundle b = new Bundle();
		if (b != null)
			b.putString("bString", sampleText);
		if (f != null)
			f.setArguments(b);
		return f;
	}

	private View mView;
	private GridView gridView;
	private ArrayAdapterCountry pAdapter;

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
			pAdapter = new ArrayAdapterCountry(getActivity(),
					R.layout.special_country_container, getCountryList(),
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
						intent.setClass(getActivity(),
								HeritageDetailActivity.class);
						intent.putExtra("continent_id",
								((CountryActivity) getActivity())
										.getContinentId());
						intent.putExtra("region_id",
								((CountryActivity) getActivity())
										.getRegionId());	
						intent.putExtra("country_id", id);
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
		ArrayList<Integer> number = new ArrayList<Integer>();
		
		if ((((CountryActivity) getActivity()).getContinentId() == 0)
				&& (((CountryActivity) getActivity()).getRegionId() == 0))

		{
			name.add("Cameroon"); number.add(2);
			name.add("Central Africa Republic"); number.add(2);
			name.add("Chad"); number.add(1);
			name.add("Congo"); number.add(6);
			name.add("Gabon"); number.add(1);
			imageUrl.add("cameroon"); 
			imageUrl.add("car"); 
			imageUrl.add("chad"); 
			imageUrl.add("congo");
			imageUrl.add("gabon");
		} else if ((((CountryActivity) getActivity()).getContinentId() == 0)
				&& (((CountryActivity) getActivity()).getRegionId() == 1)) {
			name.add("Ethiopia"); number.add(9);
			name.add("Kenya"); number.add(6);
			name.add("Madagascar"); number.add(3);
			name.add("Malawi"); number.add(2);
			name.add("Mauritius"); number.add(2);
			name.add("Mozambique"); number.add(1);
			name.add("Seychelles"); number.add(2);
			name.add("Tanzania"); number.add(7);
			name.add("Uganda"); number.add(3);
			name.add("Zimbabwe"); number.add(5);
			imageUrl.add("ethiopia");
			imageUrl.add("kenya");
			imageUrl.add("madagascar");
			imageUrl.add("malawi");
			imageUrl.add("mauritius");
			imageUrl.add("mozambique");
			imageUrl.add("seychelles");
			imageUrl.add("tanzania");
			imageUrl.add("uganda");
			imageUrl.add("zimbabwe");
		} else if ((((CountryActivity) getActivity()).getContinentId() == 0)
				&& (((CountryActivity) getActivity()).getRegionId() == 2)) {
			name.add("Algeria"); number.add(7);
			name.add("Egypt"); number.add(7);
			name.add("Libya"); number.add(5);
			name.add("Morocco"); number.add(9);
			name.add("Sudan"); number.add(2);
			name.add("Tunisia"); number.add(8);
			imageUrl.add("algeria");
			imageUrl.add("egypt");
			imageUrl.add("libya");
			imageUrl.add("morocco");
			imageUrl.add("sudan");
			imageUrl.add("tunisia");
		} else if ((((CountryActivity) getActivity()).getContinentId() == 0)
				&& (((CountryActivity) getActivity()).getRegionId() == 3)) {
			name.add("Botswana"); number.add(2);
			name.add("Namibia"); number.add(2);
			name.add("South Africa"); number.add(8);
			imageUrl.add("botswana");
			imageUrl.add("namibia");
			imageUrl.add("southafrica");

		} else if ((((CountryActivity) getActivity()).getContinentId() == 0)
				&& (((CountryActivity) getActivity()).getRegionId() == 4)) {
			name.add("Benin"); number.add(1);
			name.add("Burkina Faso"); number.add(1);
			name.add("Cape Verde"); number.add(1);
			name.add("Cote D'lvoire"); number.add(1);
			name.add("Gambia"); number.add(2);
			name.add("Ghana"); number.add(2);
			name.add("Mali"); number.add(4);
			name.add("Mauritania"); number.add(2);
			name.add("Niger"); number.add(3);
			name.add("Nigeria"); number.add(2);
			name.add("Senegal"); number.add(7);
			name.add("Togo"); number.add(1);
			imageUrl.add("benin");
			imageUrl.add("burkinafaso");
			imageUrl.add("capeverde");
			imageUrl.add("cote");
			imageUrl.add("gambia");
			imageUrl.add("ghana");
			imageUrl.add("mali");
			imageUrl.add("mauritania");
			imageUrl.add("niger");
			imageUrl.add("nigeria");
			imageUrl.add("senegal");
			imageUrl.add("togo");
		} else if ((((CountryActivity) getActivity()).getContinentId() == 1)
				&& (((CountryActivity) getActivity()).getRegionId() == 0)) {
			name.add("Belize"); number.add(1);
			name.add("Costa Rica"); number.add(4);
			name.add("Cuba"); number.add(9);
			name.add("El Salvador"); number.add(1);
			name.add("Guatemala"); number.add(3);
			name.add("Honduras");number.add(2);
			name.add("Nicaragua"); number.add(2);
			name.add("Panama"); number.add(5);
			imageUrl.add("belize");
			imageUrl.add("costarica");
			imageUrl.add("cuba");
			imageUrl.add("elsalvador");
			imageUrl.add("guatemala");
			imageUrl.add("honduras");
			imageUrl.add("nicaragua");
			imageUrl.add("panama");
		} else if ((((CountryActivity) getActivity()).getContinentId() == 1)
				&& (((CountryActivity) getActivity()).getRegionId() == 1)) {
			name.add("Canada"); number.add(17);
			name.add("Mexico"); number.add(32);
			name.add("USA"); number.add(22);
			imageUrl.add("canada");
			imageUrl.add("mexico");
			imageUrl.add("usa");
		} else if ((((CountryActivity) getActivity()).getContinentId() == 1)
				&& (((CountryActivity) getActivity()).getRegionId() == 2)) {
			name.add("Argentina"); number.add(9);
			name.add("Bolivia"); number.add(7);
			name.add("Brazil"); number.add(19);
			name.add("Chile"); number.add(6);
			name.add("Colombia"); number.add(8);
			name.add("Ecuador"); number.add(5);
			name.add("Paraguay"); number.add(1);
			name.add("Peru"); number.add(12);
			name.add("Suriname"); number.add(2);
			name.add("Uruguay"); number.add(1);
			name.add("Venezuela"); number.add(3);
			imageUrl.add("argentina");
			imageUrl.add("bolivia");
			imageUrl.add("brazil");
			imageUrl.add("chile");
			imageUrl.add("colombia");
			imageUrl.add("ecuador");
			imageUrl.add("paraguay");
			imageUrl.add("peru");
			imageUrl.add("suriname");
			imageUrl.add("uruguay");
			imageUrl.add("venezuela");
		} else if ((((CountryActivity) getActivity()).getContinentId() == 2)
				&& (((CountryActivity) getActivity()).getRegionId() == 0)) {
			name.add("Kazakhstan"); number.add(4);
			name.add("Kyrgyzstan"); number.add(2);
			name.add("Tajikistan"); number.add(2);
			name.add("Turkmenistan"); number.add(3);
			name.add("Uzbekistan"); number.add(4);
			imageUrl.add("kazakhstan");
			imageUrl.add("kyrgyzstan");
			imageUrl.add("tajikistan");
			imageUrl.add("turkmenistan");
			imageUrl.add("uzbekistan");
		} else if ((((CountryActivity) getActivity()).getContinentId() == 2)
				&& (((CountryActivity) getActivity()).getRegionId() == 1)) {
			name.add("China"); number.add(47);
			name.add("Japan"); number.add(18);
			name.add("South Korea"); number.add(13);
			name.add("Mongolia"); number.add(3);
			name.add("North Korea"); number.add(2);
			imageUrl.add("china");
			imageUrl.add("japan");
			imageUrl.add("southkorea");
			imageUrl.add("mongolia");
			imageUrl.add("northkorea");
		} else if ((((CountryActivity) getActivity()).getContinentId() == 2)
				&& (((CountryActivity) getActivity()).getRegionId() == 2)) {
			name.add("Bangladesh"); number.add(3);
			name.add("India"); number.add(32);
			name.add("Nepal"); number.add(4);
			name.add("Pakistan"); number.add(6);
			name.add("Sri Langka"); number.add(8);
			imageUrl.add("bangladesh");
			imageUrl.add("india");
			imageUrl.add("nepal");
			imageUrl.add("pakistan");
			imageUrl.add("srilangka");
		} else if ((((CountryActivity) getActivity()).getContinentId() == 2)
				&& (((CountryActivity) getActivity()).getRegionId() == 3)) {
			name.add("Cambodia"); number.add(2);
			name.add("Indonesia"); number.add(8);
			name.add("Laos"); number.add(2);
			name.add("Malaysia");number.add(4);
			name.add("Myanmar"); number.add(1);
			name.add("Philippines"); number.add(6);
			name.add("Thailand"); number.add(5);
			name.add("Vietnam"); number.add(8);
			imageUrl.add("cambodia");
			imageUrl.add("indonesia");
			imageUrl.add("laos");
			imageUrl.add("malaysia");
			imageUrl.add("myanmar");
			imageUrl.add("philippines");
			imageUrl.add("thailand");
			imageUrl.add("vietnam");
		} else if ((((CountryActivity) getActivity()).getContinentId() == 2)
				&& (((CountryActivity) getActivity()).getRegionId() == 4)) {
			name.add("Afghanistan"); number.add(2);
			name.add("Bahrain"); number.add(2);
			name.add("Iran"); number.add(17);
			name.add("Iraq"); number.add(4);
			name.add("Israel"); number.add(8);
			name.add("Jordan"); number.add(4);
			name.add("Lebanon"); number.add(5);
			name.add("Oman"); number.add(4);
			name.add("Qatar"); number.add(1);
			name.add("Saudi Arabia"); number.add(3);
			name.add("Syria"); number.add(6);
			name.add("Turkey"); number.add(13);
			imageUrl.add("afghanistan");
			imageUrl.add("bahrain");
			imageUrl.add("iran");
			imageUrl.add("iraq");
			imageUrl.add("israel");
			imageUrl.add("jordan");
			imageUrl.add("lebanon");
			imageUrl.add("oman");
			imageUrl.add("qatar");
			imageUrl.add("saudiarabia");
			imageUrl.add("syria");
			imageUrl.add("turkey");
		} else if ((((CountryActivity) getActivity()).getContinentId() == 3)
				&& (((CountryActivity) getActivity()).getRegionId() == 0)) {
			name.add("Austria"); number.add(9);
			name.add("Czech"); number.add(12);
			name.add("Germany"); number.add(39);
			name.add("Hungary"); number.add(8);
			name.add("Poland"); number.add(14);
			name.add("Slovakia"); number.add(7);
			name.add("Switzerland"); number.add(11);
			imageUrl.add("austria");
			imageUrl.add("czech");
			imageUrl.add("germany");
			imageUrl.add("hungary");
			imageUrl.add("poland");
			imageUrl.add("slovakia");
			imageUrl.add("switzerland");
		} else if ((((CountryActivity) getActivity()).getContinentId() == 3)
				&& (((CountryActivity) getActivity()).getRegionId() == 1)) {
			name.add("Azerbaijan"); number.add(2);
			name.add("Belarus"); number.add(4);
			name.add("Bulgaria"); number.add(9);
			name.add("Estonia"); number.add(2);
			name.add("Georgia"); number.add(3);
			name.add("Latvia"); number.add(2);
			name.add("Lithuania"); number.add(4);
			name.add("Romania"); number.add(7);
			name.add("Russia"); number.add(26);
			name.add("Ukraine"); number.add(7);
			imageUrl.add("azerbaijan");
			imageUrl.add("belarus");
			imageUrl.add("bulgaria");
			imageUrl.add("estonia");
			imageUrl.add("georgia");
			imageUrl.add("latvia");
			imageUrl.add("lithuania");
			imageUrl.add("romania");
			imageUrl.add("russia");
			imageUrl.add("ukraine");
		} else if ((((CountryActivity) getActivity()).getContinentId() == 3)
				&& (((CountryActivity) getActivity()).getRegionId() == 2)) {
			name.add("Denmark"); number.add(6);
			name.add("Finland"); number.add(7);
			name.add("Iceland"); number.add(2);
			name.add("Norway"); number.add(7);
			name.add("Sweden"); number.add(15);
			imageUrl.add("denmark");
			imageUrl.add("finland");
			imageUrl.add("iceland");
			imageUrl.add("norway");
			imageUrl.add("sweden");
		} else if ((((CountryActivity) getActivity()).getContinentId() == 3)
				&& (((CountryActivity) getActivity()).getRegionId() == 3)) {
			name.add("Albania"); number.add(2);
			name.add("Armenia"); number.add(3);
			name.add("Bosnia"); number.add(2);
			name.add("Croatia"); number.add(7);
			name.add("Cyprus");number.add(3);
			name.add("Greece");number.add(17);
			name.add("Holy See");number.add(2);
			name.add("Italy");number.add(50);
			name.add("Macedonia");number.add(1);
			name.add("Malta");number.add(3);
			name.add("Montenegro");number.add(2);
			name.add("Portugal");number.add(15);
			name.add("San Marino");number.add(1);
			name.add("Serbia");number.add(4);
			name.add("Slovenia");number.add(3);
			name.add("Spain");number.add(44);
			imageUrl.add("albania");
			imageUrl.add("armenia");
			imageUrl.add("bosnia");
			imageUrl.add("croatia");
			imageUrl.add("cyprus");
			imageUrl.add("greece");
			imageUrl.add("holysee");
			imageUrl.add("italy");
			imageUrl.add("macedonia");
			imageUrl.add("malta");
			imageUrl.add("montenegro");
			imageUrl.add("portugal");
			imageUrl.add("sanmarino");
			imageUrl.add("serbia");
			imageUrl.add("slovenia");
			imageUrl.add("spain");
		} else if ((((CountryActivity) getActivity()).getContinentId() == 3)
				&& (((CountryActivity) getActivity()).getRegionId() == 4)) {
			name.add("Belgium");number.add(11);
			name.add("France");number.add(39);
			name.add("Ireland");number.add(2);
			name.add("Luxembourg");number.add(1);
			name.add("Netherlands");number.add(10);
			name.add("UK");number.add(28);
			imageUrl.add("belgium");
			imageUrl.add("france");
			imageUrl.add("ireland");
			imageUrl.add("luxembourg");
			imageUrl.add("netherlands");
			imageUrl.add("uk");
		} else if ((((CountryActivity) getActivity()).getContinentId() == 4)
				&& (((CountryActivity) getActivity()).getRegionId() == 0)) {
			name.add("Australia"); number.add(19);
			name.add("New Zealand"); number.add(3);
			imageUrl.add("australia");
			imageUrl.add("newzealand");
		} else if ((((CountryActivity) getActivity()).getContinentId() == 4)
				&& (((CountryActivity) getActivity()).getRegionId() == 1)) {
			name.add("Fiji"); number.add(1);
			name.add("Kiribati"); number.add(1);
			imageUrl.add("fiji");
			imageUrl.add("kiribati");
		}

		for (Integer i = 0; i < name.size(); i++) {
			ClassProfile criticalPatient = new ClassProfile(i, i, name.get(i),
					null, null, imageUrl.get(i), number.get(i));
			warnings.add(criticalPatient);
		}
		// HashSet<ClassProfile> patientHashing = new HashSet<ClassProfile>();
		// patientHashing.addAll(warnings);
		// warnings.clear();
		// warnings.addAll(patientHashing);

		return warnings;
	}

	private void refreshAdapter() {
		pAdapter = new ArrayAdapterCountry(getActivity(),
				R.layout.special_continent_container, getCountryList(),
				"Country");
		pAdapter.notifyDataSetChanged();
		gridView.setAdapter(pAdapter);
		gridView.refreshDrawableState();
	}

}