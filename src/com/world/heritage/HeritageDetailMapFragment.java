package com.world.heritage;

import java.util.ArrayList;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.world.heritage.R;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

public class HeritageDetailMapFragment extends Fragment {
	public static String TAG = "HeritageDetailMapFragment";
	
	public static final HeritageDetailMapFragment newInstance(String sampleText) {
		HeritageDetailMapFragment f = new HeritageDetailMapFragment();

		Bundle b = new Bundle();
		if (b != null)
			b.putString("bString", sampleText);
		if (f != null)
			f.setArguments(b);
		return f;
	}

	private static View mView;
	
	private GoogleMap mMap;
	private Double latitude, longitude;
	
	public class Coord {
		private Double lati;
		private Double longi;
		private String desc;
		
		public Coord(double d, double e, String f) {
			// TODO Auto-generated constructor stub
			lati = d;
			longi = e;
			desc = f;
		}	
		
		public Double getX()
		{
			return lati;
		}
		
		public Double getY()
		{
			return longi;
		}
		
		public String getDesc()
		{
			return desc;
		}
	}
	
	ArrayList<Coord> coord = new ArrayList<Coord>();
	
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
		
		if (mView != null) {
	        ViewGroup parent = (ViewGroup) mView.getParent();
	        if (parent != null)
	            parent.removeView(mView);
	    }
	    try {

	    	mView = inflater.inflate(R.layout.map_fragment, container, false);	
	    	
	        latitude = 0.0;
	        longitude = 0.0;
	        
			if ((((HeritageDetailActivity) getActivity()).getContinentId() == 0)
					&& (((HeritageDetailActivity) getActivity()).getRegionId() == 0)
					&& (((HeritageDetailActivity) getActivity()).getCountryId() == 0)) {
		        latitude = 1.0;
		        longitude = 14.4;

		        coord.add(new Coord(3.0, 13.0, "Dja Faunal Reserve"));
		        coord.add(new Coord(2.4, 15.4, "Sangha Trinational"));
			} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 0)
					&& (((HeritageDetailActivity) getActivity()).getRegionId() == 0)
					&& (((HeritageDetailActivity) getActivity()).getCountryId() == 1)) {
		        latitude = 7.0;
		        longitude = 21.4;
		        
		        coord.add(new Coord(9.0, 21.2, "Manovo-Gounda St. Floris National Park"));
		        coord.add(new Coord(2.4, 16.4, "Sangha Trinational"));
			} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 0)
					&& (((HeritageDetailActivity) getActivity()).getRegionId() == 0)
					&& (((HeritageDetailActivity) getActivity()).getCountryId() == 2)) {	
				latitude = 17.0;
		        longitude = 20.4;
		        
				coord.add(new Coord(19.1, 20.3, "Lakes of Ounianga"));
			} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 0)
				&& (((HeritageDetailActivity) getActivity()).getRegionId() == 0)
				&& (((HeritageDetailActivity) getActivity()).getCountryId() == 3)) {	
				
				latitude = 1.5;
		        longitude = 23.0;		        
		        
				coord.add(new Coord(1.0, 29.1, "Virunga National Park"));
				coord.add(new Coord(4.0, 29.2, "Garamba National Park"));
				coord.add(new Coord(-2.5, 28.75, "Kahuzi-Niega National Park"));
				coord.add(new Coord(-2.0, 21.0, "Salango National Park"));
				coord.add(new Coord(2.0, 28.5, "Okapi Wildlife Reserve"));
				coord.add(new Coord(2.4, 16.4, "Sangha Trinational"));
			} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 0)
					&& (((HeritageDetailActivity) getActivity()).getRegionId() == 0)
					&& (((HeritageDetailActivity) getActivity()).getCountryId() == 4)) {	
				latitude = 0.;
		        longitude = 11.4;
		        
				coord.add(new Coord(0.5, 11.5, "Ecosystem and Relict Cultural Landscape of Lope-Okanda"));
			} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 0)
					&& (((HeritageDetailActivity) getActivity()).getRegionId() == 1)
					&& (((HeritageDetailActivity) getActivity()).getCountryId() == 0)) {	
				latitude = 6.1;
		        longitude = 40.4;
		        
				coord.add(new Coord(12.1, 39.0, "Rock-Hewn Churches, Lalibela"));
				coord.add(new Coord(19.1, 20.3, "Simien National Park"));
				coord.add(new Coord(12.6, 37.5, "Fasil Ghebbi, Gondar Region"));
				coord.add(new Coord(14.1, 38.7, "Aksum"));
				coord.add(new Coord(11.1, 40.5, "Lower Valley of the Awash"));
				coord.add(new Coord(4.8, 35.9, "Lower Valley of the Omo"));
				coord.add(new Coord(8.4, 38.6, "Tiya"));
				coord.add(new Coord(9.2, 42.1, "Harar Jugol, the Fortified Historic Town"));
				coord.add(new Coord(5.2, 37.3, "Konso Cultural Landscape"));
			} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 0)
					&& (((HeritageDetailActivity) getActivity()).getRegionId() == 1)
					&& (((HeritageDetailActivity) getActivity()).getCountryId() == 1)) {	
				latitude = 0.0;
		        longitude = 38.4;
		        
				coord.add(new Coord(0.1, 37.3, "Mount Kenya National Park/Natural Forest"));
				coord.add(new Coord(3.05, 36.5, "Lake Turkana National Parks"));
				coord.add(new Coord(-2.3, 40.8, "Lamu Old Town"));
				coord.add(new Coord(-3.9, 39.7, "Sacred Mijikenda Kaya Forests"));
				coord.add(new Coord(0.4, 36.2, "Lake System in the Great Rift Valley"));
				coord.add(new Coord(-4.0, 39.6, "Fort Jesus"));
			} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 0)
					&& (((HeritageDetailActivity) getActivity()).getRegionId() == 1)
					&& (((HeritageDetailActivity) getActivity()).getCountryId() == 2)) {	
				latitude = -18.5;
		        longitude = 48.4;

				coord.add(new Coord(-18.6, 44.75, "Tsingy de Bemaraha Strict Nature Reserve"));
				coord.add(new Coord(-18.75, 47.55, "Royal Hill of Ambohimanga"));
				coord.add(new Coord(-14.45, 49.7, "Rainforests of the Atsinanana"));
			} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 0)
					&& (((HeritageDetailActivity) getActivity()).getRegionId() == 1)
					&& (((HeritageDetailActivity) getActivity()).getCountryId() == 3)) {	
				latitude = -14.2;
		        longitude = 34.5;

				coord.add(new Coord(-14.2, 34.9, "Lake Malawi National Park"));
				coord.add(new Coord(-14.2, 34.2, "Chongoni Rock-Art Area"));
			} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 0)
					&& (((HeritageDetailActivity) getActivity()).getRegionId() == 1)
					&& (((HeritageDetailActivity) getActivity()).getCountryId() == 4)) {	
				latitude = -20.2;
		        longitude = 57.5;

				coord.add(new Coord(-20.18, 57.5, "Aapravasi Ghat"));
				coord.add(new Coord(-20.26, 57.5, "Le Morne Cultural Landscape"));
			} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 0)
					&& (((HeritageDetailActivity) getActivity()).getRegionId() == 1)
					&& (((HeritageDetailActivity) getActivity()).getCountryId() == 5)) {	
				latitude = -15.0;
		        longitude = 40.7;

				coord.add(new Coord(-15.05, 40.75, "Island of Mozambique"));
			} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 0)
					&& (((HeritageDetailActivity) getActivity()).getRegionId() == 1)
					&& (((HeritageDetailActivity) getActivity()).getCountryId() == 6)) {	
				latitude = -7.0;
		        longitude = 50.4;
		      
				coord.add(new Coord(-4.2, 55.75, "Vallee de Mai Nature Reserve"));
				coord.add(new Coord(-9.45, 46.45, "Aldabra Atoll"));
			} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 0)
					&& (((HeritageDetailActivity) getActivity()).getRegionId() == 1)
					&& (((HeritageDetailActivity) getActivity()).getCountryId() == 7)) {	
				latitude = -5.0;
		        longitude = 37.0;
		       
				coord.add(new Coord(-4.75, 35.8, "Kondoa Rock-Art Sites"));
				coord.add(new Coord(-8.95, 39.5, "Ruins of Kilwa Kisiwani and Ruins of Songo Mnara"));
				coord.add(new Coord(-6.1, 39.2, "Stone Town of Zanzibar"));
				coord.add(new Coord(-3.1, 37.4, "Kilimanjaro National Park"));
				coord.add(new Coord(-9.0, 37.25, "Selous Game Reserve"));
				coord.add(new Coord(-2.4, 34.54, "Serengeti National Park"));
				coord.add(new Coord(-3.2, 35.51, "Ngorongoro Conservation Area"));
			} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 0)
					&& (((HeritageDetailActivity) getActivity()).getRegionId() == 1)
					&& (((HeritageDetailActivity) getActivity()).getCountryId() == 8)) {	
				latitude = 0.0;
		        longitude = 31.2;
		       
				coord.add(new Coord(0.36, 32.52, "Tombs of Buganda Kings at Kasubi"));
				coord.add(new Coord(-1.1, 29.7, "Bwindi Impenetrable National Park"));
				coord.add(new Coord(0.2, 29.85, "Rwenzori Mountains National Park"));
			} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 0)
					&& (((HeritageDetailActivity) getActivity()).getRegionId() == 1)
					&& (((HeritageDetailActivity) getActivity()).getCountryId() == 9)) {	
				latitude = -19.0;
		        longitude = 28.4;
		        
				coord.add(new Coord(-20.2, 30.85, "Great Zimbabwe National Monument "));
				coord.add(new Coord(-20.1, 28.4, "Khami Ruins National Monument "));
				coord.add(new Coord(-20.5, 28.5, "Matobo Hills "));
				coord.add(new Coord(-15.8, 29.45, "Mana Pools National Park, Sapi and Chewore Safari Areas "));
				coord.add(new Coord(-17.85, 25.8, "Mosi-oa-Tunya / Victoria Falls"));
			} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 0)
					&& (((HeritageDetailActivity) getActivity()).getRegionId() == 2)
					&& (((HeritageDetailActivity) getActivity()).getCountryId() == 0)) {	
				latitude = 31.0;
		        longitude = 6.5;
		       
				coord.add(new Coord(35.8, 4.8, "Al Qal'a of Beni Hammad "));
				coord.add(new Coord(36.25, 5.75, "Djemila "));
				coord.add(new Coord(36.75, 3.05, "Kasbah of Algiers "));
				coord.add(new Coord(32.5, 3.7, "M'Zab Valley"));
				coord.add(new Coord(35.5, 6.35, "Timgad"));
				coord.add(new Coord(36.5, 2.25, "Tipasa"));
				coord.add(new Coord(25.5, 9.0, "Tassili n'Ajjer"));
			} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 0)
					&& (((HeritageDetailActivity) getActivity()).getRegionId() == 2)
					&& (((HeritageDetailActivity) getActivity()).getCountryId() == 1)) {	
				latitude = 26.0;
		        longitude = 30.4;
		        
				coord.add(new Coord(30.8, 29.75, "Abu Mena "));
				coord.add(new Coord(25.72, 32.52, "Ancient Thebes with its Necropolis "));
				coord.add(new Coord(30.05, 31.25, "Historic Cairo "));
				coord.add(new Coord(29.95, 31.08, "Memphis and its Necropolis - the Pyramid Fields from Giza to Dahshur"));
				coord.add(new Coord(22.33, 31.55, "Nubian Monuments from Abu Simbel to Philae"));
				coord.add(new Coord(28.52, 33.9, "Saint Catherine Area"));
				coord.add(new Coord(29.35, 30.15, "Wadi Al-Hitan (Whale Valley)"));;
			} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 0)
					&& (((HeritageDetailActivity) getActivity()).getRegionId() == 2)
					&& (((HeritageDetailActivity) getActivity()).getCountryId() == 2)) {	
				latitude = 28.5;
		        longitude = 16.0;
		       
				coord.add(new Coord(32.83, 21.86, "Archaeological Site of Cyrene"));
				coord.add(new Coord(32.82, 12.50, "Archaeological Site of Sabratha"));
				coord.add(new Coord(30.10, 9.5, "Old Town of Ghadam's"));
				coord.add(new Coord(24.84, 10.34, "Rock-Art Sites of Tadrart Acacus"));
				coord.add(new Coord(32.65, 14.20, "Archaeological Site of Leptis Magna"));

			} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 0)
					&& (((HeritageDetailActivity) getActivity()).getRegionId() == 2)
					&& (((HeritageDetailActivity) getActivity()).getCountryId() == 3)) {	
				latitude = 32.5;
		        longitude = -6.6;
		        
				coord.add(new Coord(34.05, -4.95, "Medina of Fez "));
				coord.add(new Coord(31.64, -7.98, "Medina of Marrakesh "));
				coord.add(new Coord(31.4, -7.10, "Ksar of Ait-Ben-Haddou "));
				coord.add(new Coord(33.85, -5.55, "Historic City of Meknes "));
				coord.add(new Coord(34.07, -5.54, "Archaeological Site of Volubilis"));
				coord.add(new Coord(35.56, -5.36, "Medina of Tztouan (formerly known as Titawin)"));
				coord.add(new Coord(31.5, -9.76, "Medina of Essaouira (formerly Mogador)"));
				coord.add(new Coord(33.25, -8.5, "Portuguese City of Mazagan (El Jadida)"));
				coord.add(new Coord(34.02, -6.83, "Rabat, Modern Capital and Historic City: a Shared Heritage "));
			} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 0)
					&& (((HeritageDetailActivity) getActivity()).getRegionId() == 2)
					&& (((HeritageDetailActivity) getActivity()).getCountryId() == 4)) {	
				latitude = 17.5;
		        longitude = 32.7;
		        
				coord.add(new Coord(18.51, 31.83, "Gebel Barkal and the Sites of the Napatan Region"));
				coord.add(new Coord(16.90, 33.74, "Archaeological Sites of the Island of Meroe "));

			} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 0)
					&& (((HeritageDetailActivity) getActivity()).getRegionId() == 2)
					&& (((HeritageDetailActivity) getActivity()).getCountryId() == 5)) {	
				latitude = 36.4;
		        longitude = 10.2;
		        
				coord.add(new Coord(35.30, 10.71, "Amphitheatre of El Jem"));
				coord.add(new Coord(36.84, 10.33, "Archaeological Site of Carthage "));
				coord.add(new Coord(36.80, 10.17, "Medina of Tunis"));
				coord.add(new Coord(37.15, 9.67, "Ichkeul National Park"));
				coord.add(new Coord(36.90, 11.08, "Punic Town of Kerkuana and its Necropolis"));
				coord.add(new Coord(35.84, 10.10, "Kairouan"));
				coord.add(new Coord(35.82, 10.66, "Medina of Sousse"));
				coord.add(new Coord(36.40, 9.24, "Dougga/Thugga"));
			
			} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 0)
					&& (((HeritageDetailActivity) getActivity()).getRegionId() == 3)
					&& (((HeritageDetailActivity) getActivity()).getCountryId() == 0)) {	
				latitude = -19.0;
		        longitude = 22.2;
		        
				coord.add(new Coord(-18.75, 21.72, "Tsodilo"));
				coord.add(new Coord(-19.26, 22.84, "Okavango Delta"));

			} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 0)
					&& (((HeritageDetailActivity) getActivity()).getRegionId() == 3)
					&& (((HeritageDetailActivity) getActivity()).getCountryId() == 1)) {	
				latitude = -22.8;
		        longitude = 14.8;
		        
				coord.add(new Coord(-20.58, 14.33, "Twyfelfontein"));
				coord.add(new Coord(-24.84, 15.41, "Namib Sand Sea "));

			} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 0)
					&& (((HeritageDetailActivity) getActivity()).getRegionId() == 3)
					&& (((HeritageDetailActivity) getActivity()).getCountryId() == 2)) {	
				latitude = -28.0;
		        longitude = 25.4;
		        
				coord.add(new Coord(-24.15, 29.16, "Fossil Hominid Sites of South Africa"));
				coord.add(new Coord(-33.79, 18.37, "Robben Island "));
				coord.add(new Coord(-27.84, 32.55, "Simangaliso Wetland Park"));
				coord.add(new Coord(-29.75, 29.12, "Maloti Drakensberg Park"));
				coord.add(new Coord(-22.18, 29.24, "Mapungubwe Cultural Landscape"));
				coord.add(new Coord(-34.17, 18.35, "Cape Floral Region Protected Areas"));				
				coord.add(new Coord(-28.60, 17.20, "Richtersveld Cultural and Botanical Landscape"));
				coord.add(new Coord(-26.85, 27.25, "Vredefort Dome"));
			
			} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 0)
					&& (((HeritageDetailActivity) getActivity()).getRegionId() == 4)
					&& (((HeritageDetailActivity) getActivity()).getCountryId() == 0)) {	
				latitude = 7.1;
		        longitude = 1.9;
		        
				coord.add(new Coord(7.17, 1.97, "Royal Palaces of Abomey"));
			} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 0)
					&& (((HeritageDetailActivity) getActivity()).getRegionId() == 4)
					&& (((HeritageDetailActivity) getActivity()).getCountryId() == 1)) {	
				latitude = 10.0;
		        longitude = -3.4;
		        
				coord.add(new Coord(10.25, -3.55, "Ruins of Loropeni"));
			} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 0)
					&& (((HeritageDetailActivity) getActivity()).getRegionId() == 4)
					&& (((HeritageDetailActivity) getActivity()).getCountryId() == 2)) {	
				latitude = 15.0;
		        longitude = -23.6;
		        
				coord.add(new Coord(14.93,-23.60, "Cidade Velha, Historic Center of Ribeira Grande"));
			}  else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 0)
					&& (((HeritageDetailActivity) getActivity()).getRegionId() == 4)
					&& (((HeritageDetailActivity) getActivity()).getCountryId() == 3)) {	
				latitude = 5.1;
		        longitude = -3.7;
		        
				coord.add(new Coord(5.17, -3.74, "Historic Town of Grand Bassam "));
			} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 0)
					&& (((HeritageDetailActivity) getActivity()).getRegionId() == 4)
					&& (((HeritageDetailActivity) getActivity()).getCountryId() == 4)) {	
				latitude = 13.5;
		        longitude = -15.9;
		      
				coord.add(new Coord(13.33, -16.36, "Kunta Kinteh Island and Related Sites "));
				coord.add(new Coord(13.67, -15.51, "Stone Circles of Senegambia"));
			} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 0)
					&& (((HeritageDetailActivity) getActivity()).getRegionId() == 4)
					&& (((HeritageDetailActivity) getActivity()).getCountryId() == 5)) {	
				latitude = 6.0;
		        longitude = -0.4;
		       
				coord.add(new Coord(6.42, -1.6, "Asante Traditional Buildings "));
				coord.add(new Coord(5.38, -0.5, "Forts and Castles, Volta, Greater Accra, Central and Western Regions"));
			} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 0)
					&& (((HeritageDetailActivity) getActivity()).getRegionId() == 4)
					&& (((HeritageDetailActivity) getActivity()).getCountryId() == 6)) {	
				latitude = 15.0;
		        longitude = -2.4;
		        
				coord.add(new Coord(13.86, -4.55, "Old Towns of Djenne"));
				coord.add(new Coord(16.77, -2.99, "Timbuktu "));
				coord.add(new Coord(16.30, 0.3, "Tomb of Askia "));
				coord.add(new Coord(14.33, -3.41, "Cliff of Bandiagara"));
			} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 0)
					&& (((HeritageDetailActivity) getActivity()).getRegionId() == 4)
					&& (((HeritageDetailActivity) getActivity()).getCountryId() == 7)) {	
				latitude = 20.6;
		        longitude = -13.4;
		        
				coord.add(new Coord(20.25, -16.10, "Banc d'Arguin National Park "));
				coord.add(new Coord(20.95, -11.60, "Ancient Ksour of Ouadane, Chinuetti, Tichitt and Oualate"));
			} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 0)
					&& (((HeritageDetailActivity) getActivity()).getRegionId() == 4)
					&& (((HeritageDetailActivity) getActivity()).getCountryId() == 8)) {	
				latitude = 16.0;
		        longitude = 5.4;
		        
				coord.add(new Coord(16.98, 7.99, "Historic ceter of Agadez "));
				coord.add(new Coord(18.0, 9.0, "Air and Tenere Natural Reserves"));
				coord.add(new Coord(12.34, 2.35, "W National Park of Niger"));
			} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 0)
					&& (((HeritageDetailActivity) getActivity()).getRegionId() == 4)
					&& (((HeritageDetailActivity) getActivity()).getCountryId() == 9)) {	
				latitude = 9.0;
		        longitude = 8.2;
		        
				coord.add(new Coord(7.75, 4.55, "Osun Osogbo Sacred Grove"));
				coord.add(new Coord(10.74, 13.56, "Sukur Cultural Landscape"));
			} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 0)
					&& (((HeritageDetailActivity) getActivity()).getRegionId() == 4)
					&& (((HeritageDetailActivity) getActivity()).getCountryId() == 10)) {	
				latitude = 14.4;
		        longitude = -13.4;
		        
				coord.add(new Coord(12.60, -12.84, "Bassari Country: Bassari, Fula and Bedik Cultural Landscapes"));
				coord.add(new Coord(14.67, -17.41, "Island of Goree"));
				coord.add(new Coord(16.02, -16.50, "Island of Saint-Louis"));
				coord.add(new Coord(13.84, -16.50, "Saloum Delta"));
				coord.add(new Coord(13.67, -15.52, "Stone Circles of Senegambia"));
				coord.add(new Coord(16.50, -16.17, "Djoudj National Bird Sanctuary"));
				coord.add(new Coord(13.07, -12.72, "Niokolo-Koba National Park"));
				
			} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 0)
					&& (((HeritageDetailActivity) getActivity()).getRegionId() == 4)
					&& (((HeritageDetailActivity) getActivity()).getCountryId() == 11)) {	
				latitude = 10.0;
		        longitude = 1.1;
		       
				coord.add(new Coord(10.1, 1.12, "Koutammakou, the Land of the Batammariba"));				
			}  else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 1)
					&& (((HeritageDetailActivity) getActivity()).getRegionId() == 0)
					&& (((HeritageDetailActivity) getActivity()).getCountryId() == 0)) {	
				latitude = 16.7;
		        longitude = -87.05;
		        
				coord.add(new Coord(16.75, -87.05, "Belize Barrier Reef Reserve System"));				
			} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 1)
					&& (((HeritageDetailActivity) getActivity()).getRegionId() == 0)
					&& (((HeritageDetailActivity) getActivity()).getCountryId() == 1)) {	
				latitude = 8.0;
		        longitude = -85.0;
		        
				coord.add(new Coord(9.40, -82.90, "Talamanca Range-La Amistad Reserves / La Amistad National Park"));	
coord.add(new Coord(5.52, -87.05, "Cocos Island National Park"));
coord.add(new Coord(10.90, -85.60, "Area de Conservacion Guanacaste"));
coord.add(new Coord(8.95, -83.50, "Precolumbian chiefdom settlements with stone spheres of the Diquis"));
				
			} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 1)
					&& (((HeritageDetailActivity) getActivity()).getRegionId() == 0)
					&& (((HeritageDetailActivity) getActivity()).getCountryId() == 2)) {	
				latitude = 21.0;
		        longitude = -79.0;
		        
				coord.add(new Coord(23.1, -82.31, "Old Havana and its Fortifications"));	
coord.add(new Coord(21.65, -79.99, "Trinidad and the Valley de los Ingenios"));
coord.add(new Coord(19.96, -75.84, "San Pedro de la Roca Castle, Santiago de Cuba"));
coord.add(new Coord(22.60, -83.70, "Vinales Valley"));
				coord.add(new Coord(19.90, -77.60, "Desembarco del Granma National Park"));	
coord.add(new Coord(20.02, -75.40, "Archaeological Landscape of the First Coffee Plantations in the South-East of Cuba"));
coord.add(new Coord(20.41, -75.0, "Alejandro de Humboldt National Park"));
coord.add(new Coord(22.12, -80.45, "Urban Historic Centre of Cienfuegos"));
	coord.add(new Coord(21.40, -77.90, "Historic Centre of Camaguey"));
	
			} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 1)
					&& (((HeritageDetailActivity) getActivity()).getRegionId() == 0)
					&& (((HeritageDetailActivity) getActivity()).getCountryId() == 3)) {	
				latitude = 13.8;
		        longitude = -89.4;
		        
				coord.add(new Coord(13.81, -89.35, "Joya de Ceren Archaeological Site"));				
			} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 1)
					&& (((HeritageDetailActivity) getActivity()).getRegionId() == 0)
					&& (((HeritageDetailActivity) getActivity()).getCountryId() == 4)) {	
				latitude = 15.5;
		        longitude = -89.6;
		        
				coord.add(new Coord(14.56, -90.67, "Antigua Guatemala"));	
coord.add(new Coord(15.26, -89.03, "Archaeological Park and Ruins of Quirigua"));	
coord.add(new Coord(17.20, -89.60, "Tikal National Park"));					
			} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 1)
					&& (((HeritageDetailActivity) getActivity()).getRegionId() == 0)
					&& (((HeritageDetailActivity) getActivity()).getCountryId() == 5)) {	
				latitude = 15.2;
		        longitude = -87.1;
		        
				coord.add(new Coord(14.90, -89.10, "Maya Site of Copan"));	
coord.add(new Coord(15.74, -84.67, "Rio Platano Biosphere Reserve"));	
				
			} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 1)
					&& (((HeritageDetailActivity) getActivity()).getRegionId() == 0)
					&& (((HeritageDetailActivity) getActivity()).getCountryId() == 6)) {	
				latitude = 12.4;
		        longitude = -86.8;
		        
				coord.add(new Coord(12.45, -86.90, "Leon Cathedral"));	
coord.add(new Coord(12.44, -86.60, "Ruins of Leon Viejo"));	
				
			} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 1)
					&& (((HeritageDetailActivity) getActivity()).getRegionId() == 0)
					&& (((HeritageDetailActivity) getActivity()).getCountryId() == 7)) {	
				latitude = 8.5;
		        longitude = -80.4;
		      
				coord.add(new Coord(8.95, -79.53, "Archaeological Site of Panama Viejo and Historic District of Panama City"));	
coord.add(new Coord(7.40, -81.75, "Coiba National Park and its Special Zone of Marine Protection"));	
coord.add(new Coord(7.74, -77.53, "Darien National Park"));		
coord.add(new Coord(9.40, -82.90, "Talamanca Range-La Amistad Reserves / La Amistad National Park"));	
coord.add(new Coord(9.55, -79.66, "Fortifications on the Caribbean Side of Panama: Portobelo-San Lorenzo"));
				
			} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 1)
					&& (((HeritageDetailActivity) getActivity()).getRegionId() == 1)
					&& (((HeritageDetailActivity) getActivity()).getCountryId() == 0)) {
				//canada
				latitude = 58.0;
		        longitude = -92.0;
		        
				coord.add(new Coord(51.49, -55.60, "L'Anse aux Meadows National Historic Site"));	
				coord.add(new Coord(61.52, -125.59, "Nahanni National Park"));	
				coord.add(new Coord(50.74, -111.50, "Dinosaur Provincial Park"));	
				coord.add(new Coord(61.14, -140.98, "Kluane/Wrangell-St.Elias/Glacier Bay/Tatshenshini-Alsek"));	
				coord.add(new Coord(52.08, -131.20, "SGang Gwaay"));	
				
				coord.add(new Coord(49.74, -113.60, "Head-Smashed-In Buffalo Jump"));	
				coord.add(new Coord(59.32, -112.22, "Wood Buffalo National Park"));	
				coord.add(new Coord(51.40, -116.48, "Canadian Rocky Mountain Parks"));					
				coord.add(new Coord(49.60, -57.52, "Gros Morne National Park"));
				
				coord.add(new Coord(48.98, -113.90, "Waterton Glacier International Peace Park"));	
				coord.add(new Coord(44.40, -64.34, "Old Town Lunenburg"));	
				coord.add(new Coord(48.10, -66.28, "Miguasha National Park"));	
				coord.add(new Coord(44.99, -75.75, "Rideau Canal"));	
				coord.add(new Coord(45.70, -64.42, "Joggins Fossil Cliffs"));
				
				coord.add(new Coord(45.10, -64.32, "Landscape of Grand-Pre"));
				coord.add(new Coord(51.72, -56.44, "Red Bay Basque Whaling Station"));		
				coord.add(new Coord(46.81, -71.20, "Historic District of Old Quebec"));			
			} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 1)
					&& (((HeritageDetailActivity) getActivity()).getRegionId() == 1)
					&& (((HeritageDetailActivity) getActivity()).getCountryId() == 1)) {	
				latitude = 22.0;
		        longitude = -99.4;
		        
				coord.add(new Coord(19.45, -99.12, "Historic Center of Mexico City and Xochimilco"));	
				coord.add(new Coord(17.05, -96.74, "Historic Center of Oaxaca and Monte Alban"));	
				coord.add(new Coord(19.03, -98.20, "Historic Center of Puebla"));	
				coord.add(new Coord(17.48, -92.04, "Pre-Hispanic City and National Park of Palenque"));	
				coord.add(new Coord(19.85, -98.90, "Pre-Hispanic City of Teotihuacan"));	
				
				coord.add(new Coord(19.40, -87.80, "Sian Ka'an"));	
				coord.add(new Coord(21.02, -101.25, "Historic Town of Guanajuato and Adjacent Mines"));	
				coord.add(new Coord(20.83, -88.58, "Pre-Hispanic City of Chichen-Itza"));	
				coord.add(new Coord(19.70, -101.20, "Historic Centre of Morelia"));	
				coord.add(new Coord(20.50, -97.40, "El Tajin"));
				
				coord.add(new Coord(22.76, -102.55, "Historic Centre of Zacatecas"));	
				coord.add(new Coord(27.84, -112.90, "Rock Paintings of the Sierra de San Francisco"));	
				coord.add(new Coord(27.78, -114.20, "Whale Sanctuary of El Vizcaino"));	
				coord.add(new Coord(18.902, -98.89, "Earliest 16th century monasteries on the slopes of Popocatepetl"));	
				coord.add(new Coord(20.36, -100.31, "Historic Monuments Zone of Queretaro"));
				
				coord.add(new Coord(20.31, -89.76, "Pre-Hispanic Town of Uxmal"));
				coord.add(new Coord(20.73, -103.44, "Hospicio Cabanas"));	
				coord.add(new Coord(30.40, -107.90, "Archaeological Zone of Paquime, Casas Grandes"));
				coord.add(new Coord(18.61, -95.68, "Historic Monuments Zone of Tlacotalpan"));
				coord.add(new Coord(18.80, -99.26, "Archaeological Monuments Zone of Xochicalco"));	
				
				coord.add(new Coord(19.90, -90.53, "Historic Fortified Town of Campeche"));	
				coord.add(new Coord(18.10, -89.77, "Ancient Maya City and Protected Tropical Forests of Calakmul, Campeche"));
				coord.add(new Coord(21.20, -99.45, "Franciscan Missions in the Sierra Gorda"));
				coord.add(new Coord(19.42, -99.18, "Luis Barragan House and Studio"));	
				coord.add(new Coord(27.61, -112.54, "Islands and Protected Areas of the Gulf of California"));	
				
				coord.add(new Coord(20.81, -103.76, "Agave Landscape and Ancient Industrial Facilities of Tequila"));	
				coord.add(new Coord(20.90, -100.74, "Protective town of San Miguel de Allende and Sanctuary of Jesus Nazareno de Atotonilco"));
				coord.add(new Coord(19.60, -100.20, "Monarch Butterfly Biosphere Reserve"));	
				coord.add(new Coord(22.60, -102.40, "Camino Real de Tierra Adentro"));

				coord.add(new Coord(16.97, -96.44, "Prehistoric Caves of Yagul and Mitla in the Central Valley of Oaxaca"));	
				coord.add(new Coord(32, -113.90, "El Pinacate y Gran Desierto de Altar Biosphere Reserve"));
				coord.add(new Coord(19.40, -99.20, "Central University City Campus of the UNAM"));				
			}  else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 1)
					&& (((HeritageDetailActivity) getActivity()).getRegionId() == 1)
					&& (((HeritageDetailActivity) getActivity()).getCountryId() == 2)) {	
				//usa
				latitude = 41.0;
		        longitude = -95.4;
		        
				coord.add(new Coord(37.25, -108.49, "Mesa Verde National Park"));	
				coord.add(new Coord(44.46, -110.83, "Yellowstone National Park"));
				coord.add(new Coord(61.14, -140.98, "Kluane / Wrangell and St. Elias / Glacier Bay / Tatshenshini-Alsek"));
				coord.add(new Coord(36.10, -112.8, "Grand Canyon National Park"));
				coord.add(new Coord(39.94, -75.14, "Independence Hall"));
				
				coord.add(new Coord(37.14, -86.9, "Mammoth Cave National Park"));	
				coord.add(new Coord(47.73, -123.44, "Olympic National Park"));
				coord.add(new Coord(32.17, -104.38, "Carlsbad Caverns National Park"));
				coord.add(new Coord(38.66, -90.05, "Cahokia Mounds State Historic Site"));
				coord.add(new Coord(35.58, -83.44, "Great Smoky Mountains National Park"));
				
				coord.add(new Coord(18.48, -66.11, "La Fortaleza and San Juan National Historic Site"));	
				coord.add(new Coord(40.68, -74.03, "Statue of Liberty"));
				coord.add(new Coord(37.74, -119.58, "Yosemite National Park"));
				coord.add(new Coord(36.05, -107.98, "Chaco Culture National Historical Park"));
				coord.add(new Coord(19.41, -155.10, "Hawaii Volcanoes National Park"));
				
				coord.add(new Coord(38.1, -78.50, "Monticello and the University of Virginia"));	
				coord.add(new Coord(36.43, -105.54, "Taos Pueblo"));
				coord.add(new Coord(41.37, -123.99, "Redwood National and State Parks"));
				coord.add(new Coord(48.99, -113.92, "Waterton-Glacier International Peace Park"));
				coord.add(new Coord(25.34, -170.12, "Papahanaumokuakea"));
				
				coord.add(new Coord(32.64, -91.41, "Monumental Earthworks of Poverty Point"));
				coord.add(new Coord(25.55, -80.99, "Everglades National Park"));
			} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 1)
					&& (((HeritageDetailActivity) getActivity()).getRegionId() == 2)
					&& (((HeritageDetailActivity) getActivity()).getCountryId() == 0)) {
				//argentina
				latitude = -40.0;
		        longitude = -60.4;
		        
				coord.add(new Coord(-50.0, -73.24, "Los Glaciares National Park"));	
				coord.add(new Coord(-28.54, -54.26, "Jesuit Missions of the Guaranis"));	
				coord.add(new Coord(-25.51, -54.11, "Iguazu National Park"));	
				coord.add(new Coord(-47.12, -70.67, "Cueva de las Manos, Rio Pinturas"));	
				coord.add(new Coord(-42.50, -64.0, "Peninsula Valdes"));
				
				coord.add(new Coord(-30.00, -68.00, "Ischigualasto / Talampaya Natural Parks"));	
				coord.add(new Coord(-31.42, -64.18, "Jesuit Block and Estancias of Cordoba"));
				coord.add(new Coord(-23.18, -65.35, "Quebrada de Humahuaca"));
				//coord.add(new Coord(19.1, 20.3, "Qhapaq Nan, Andean Road System"));				
			} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 1)
					&& (((HeritageDetailActivity) getActivity()).getRegionId() == 2)
					&& (((HeritageDetailActivity) getActivity()).getCountryId() == 1)) {	
				//bolivia
				latitude = -17.30;
		        longitude = -63.4;
		        				
				coord.add(new Coord(-18.16, -63.83, "Fuerte de Samaipata"));	
				coord.add(new Coord(-19.03, -65.25, "Historic City of Sucre"));	
				coord.add(new Coord(-16.0, -60.50, "Jesuit Missions of Chiquitos"));	
				coord.add(new Coord(-14.26, -60.87, "Noel Kempff Mercado National Park"));	
				coord.add(new Coord(-16.55, -68.67, "Tiwanaku: Spiritual and Political Centre of the Tiwanaku Culture"));	
				coord.add(new Coord(-19.58, -65.75, "City of Potosi"));	
			} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 1)
					&& (((HeritageDetailActivity) getActivity()).getRegionId() == 2)
					&& (((HeritageDetailActivity) getActivity()).getCountryId() == 2)) {	
				//brazil
				latitude = -10.0;
		        longitude = -46.8;
		        
				coord.add(new Coord(19.1, 20.3, "Atlantic Forest South-East Reserves"));					
				coord.add(new Coord(-15.77, -47.90, "Brasilia"));
				coord.add(new Coord(-3.88, -32.42, "Brazilian Atlantic Islands: Fernando de Noronha and Atol das Rocas Reserves"));
				coord.add(new Coord(-2.33, -62.01, "Central Amazon Conservation Complex"));
				coord.add(new Coord(-14.01, -47.68, "Cerrado Protected Areas: Chapada dos Veadeiros and Emas National Parks"));
				
				coord.add(new Coord(-16.50, -39.25, "Discovery Coast Atlantic Forest Reserves"));
				coord.add(new Coord(-12.98, -38.50, "Historic Centre of Salvador de Bahia"));
				coord.add(new Coord(-2.51, -44.30, "Historic Centre of Sao Luis"));
				coord.add(new Coord(-18.22, -43.60, "Historic Centre of the Town of Diamantina"));
				coord.add(new Coord(-15.96, -50.12, "Historic Centre of the Town of Goias"));
				
				coord.add(new Coord(-8.01, -34.90, "Historic Centre of the Town of Olinda"));
				coord.add(new Coord(-20.43, -43.50, "Historic Town of Ouro Preto"));
				coord.add(new Coord(19.1, 20.3, "Iguazu National Park"));
				coord.add(new Coord(-28.53, -54.26, "Ruins of Sao Miguel das Missoes"));
				coord.add(new Coord(19.1, 20.3, "Pantanal Conservation Area"));
				
				coord.add(new Coord(-22.92, -43.30, "Rio de Janeiro: Carioca Landscapes Between the Mountain and the Sea"));
				coord.add(new Coord(-20.30, -43.87, "Sanctuary of Bom Jesus do Congonhas"));
				coord.add(new Coord(-11.01, -37.21, "Sao Francisco Square in the Town of Sao Cristovao"));
				coord.add(new Coord(-8.42, -42.30, "Serra da Capivara National Park"));
			} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 1)
					&& (((HeritageDetailActivity) getActivity()).getRegionId() == 2)
					&& (((HeritageDetailActivity) getActivity()).getCountryId() == 3)) {	
				//chile
				latitude = -30.0;
		        longitude = -72.0;
		        
				coord.add(new Coord(-42.5, -73.76, "Churches of Chiloe"));	
				coord.add(new Coord(-33.3, -71.62, "Historic Quarter of the Seaport City of Valparaiso"));
				coord.add(new Coord(-20.20, -69.79, "Humberstone and Santa Laura Saltpeter Works"));
				coord.add(new Coord(-18.25, -69.58, "Qhapaq Nan, Andean Road System"));
				coord.add(new Coord(-27.12, -109.45, "Rapa Nui National Park"));
				coord.add(new Coord(-34.8, -70.38, "Sewell Mining Town"));
			}  else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 1)
					&& (((HeritageDetailActivity) getActivity()).getRegionId() == 2)
					&& (((HeritageDetailActivity) getActivity()).getCountryId() == 4)) {	
				// colombia
				latitude = 6.50;
		        longitude = -76.50;
								
				coord.add(new Coord(-18.25, -69.58, "Qhapaq Nan, Andean Road System"));
		        coord.add(new Coord(7.67, -77.0, "Los Katios National Park"));
				coord.add(new Coord(1.95, -76.23, "San Agustin Archaeological Park"));	
				coord.add(new Coord(10.42, -75.52, "Port, Fortresses and Group of Monuments, Cartagena"));					
				coord.add(new Coord(2.58, -76.02, "National Archeological Park of Tierradentro"));	
				coord.add(new Coord(3.98, -81.59, "Malpelo Fauna and Flora Sanctuary"));	
				coord.add(new Coord(9.23, -74.42, "Historic Centre of Santa Cruz de Mompox"));		
				coord.add(new Coord(5.47, -75.67, "Coffee Cultural Landscape of Colombia"));	
			} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 1)
					&& (((HeritageDetailActivity) getActivity()).getRegionId() == 2)
					&& (((HeritageDetailActivity) getActivity()).getCountryId() == 5)) {
				//ecuador
				latitude = -1.0;
		        longitude = -85.4;
		        
				coord.add(new Coord(0.83, -91.0, "Galapagos Islands"));	
				coord.add(new Coord(0.0, -78.50, "City of Quito"));	
				coord.add(new Coord(-2.88, -78.98, "Historic Centre of Santa Ana de los Rios de Cuenca"));	
				coord.add(new Coord(-1.83, -78.33, "Sangay National Park"));	
			} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 1)
					&& (((HeritageDetailActivity) getActivity()).getRegionId() == 2)
					&& (((HeritageDetailActivity) getActivity()).getCountryId() == 6)) {	
				latitude = -27.0;
		        longitude = -56.0;
		        
				coord.add(new Coord(-27.11, -55.70, "Jesuit Missions of La Santisima Trinidad de Parana and Jesus de Tavarangue"));	
			} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 1)
					&& (((HeritageDetailActivity) getActivity()).getRegionId() == 2)
					&& (((HeritageDetailActivity) getActivity()).getCountryId() == 7)) {
				//peru
				latitude = -12.0;
		        longitude = -75.4;
		        
				coord.add(new Coord(-13.51, -71.98, "City of Cuzco"));					
				coord.add(new Coord(-9.58, -77.17, "Chavin (Archaeological Site)"));
				coord.add(new Coord(-9.33, -77.42, "Huascaran National Park"));
				coord.add(new Coord(-8.08, -79.07, "Chan Chan Archaeological Zone"));
				
				coord.add(new Coord(-12.25, -71.75, "Manu National Park"));
				coord.add(new Coord(-12.05, -77.04, "Historic Center of Lima"));
				coord.add(new Coord(-7.75, -77.25, "Rio Abiseo National Park"));
				coord.add(new Coord(-14.89, -75.12, "Lines and Geoglyphs of Nasca and Pampas"));
				coord.add(new Coord(-16.38, -71.52, "Historic Center of the City of Arequipa"));
				
				coord.add(new Coord(-10.88, -77.51, "Sacred City of Caral-Supe"));
				//coord.add(new Coord(19.1, 20.3, "Qhapaq Nan, Andean Road System"));
				coord.add(new Coord(-13.11, -72.57, "Historic Sanctuary of Machu Picchu"));
			} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 1)
					&& (((HeritageDetailActivity) getActivity()).getRegionId() == 2)
					&& (((HeritageDetailActivity) getActivity()).getCountryId() == 8)) {	
				latitude = 5.0;
		        longitude = -55.8;
		        
				coord.add(new Coord(4.0, -56.50, "Central Suriname Nature Reserve"));	
				coord.add(new Coord(5.83, -55.12, "Historic Inner City of Paramaribo"));
			} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 1)
					&& (((HeritageDetailActivity) getActivity()).getRegionId() == 2)
					&& (((HeritageDetailActivity) getActivity()).getCountryId() == 9)) {	
				latitude = -34.4;
		        longitude = -57.8;
		        
				coord.add(new Coord(-34.47, -57.85, "Historic Quarter of the City of Colonia del Sacramento"));	
			} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 1)
					&& (((HeritageDetailActivity) getActivity()).getRegionId() == 2)
					&& (((HeritageDetailActivity) getActivity()).getCountryId() == 10)) {	
				//Venezuela
				latitude = 8.0;
		        longitude = -65.4;
		        
				coord.add(new Coord(11.40, -69.84, "Coro and its Port"));	
				coord.add(new Coord(5.33, -61.50, "Canaima National Park"));	
				coord.add(new Coord(10.49, -66.89, "Ciudad Universitaria de Caracas"));	
			} 
			  
			  
			else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 2)
					&& (((HeritageDetailActivity) getActivity()).getRegionId() == 0)
					&& (((HeritageDetailActivity) getActivity()).getCountryId() == 0)) {	
				latitude = 46.0;
		        longitude = 72.4;
		        
				coord.add(new Coord(50.43, 69.18, "Saryarka - Steppe and Lakes of Northern Kazakhstan"));	

				coord.add(new Coord(43.28, 68.26, "Mausoleum of Khoja Ahmed Yasawi"));	
				coord.add(new Coord(42.30, 75.23, "Silk Roads: the Routes Network of Chang'an-Tianshan Corridor"));	
				coord.add(new Coord(43.81, 75.53, "Petroglyphs within the Archaeological Landscape of Tamgaly"));
				
			} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 2)
					&& (((HeritageDetailActivity) getActivity()).getRegionId() == 0)
					&& (((HeritageDetailActivity) getActivity()).getCountryId() == 1)) {
				//Kyrgyzstan
				latitude = 40.0;
		        longitude = 72.4;
		        
				coord.add(new Coord(40.51, 72.76, "Sulaiman-Too Sacred Mountain"));	
			} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 2)
					&& (((HeritageDetailActivity) getActivity()).getRegionId() == 0)
					&& (((HeritageDetailActivity) getActivity()).getCountryId() == 2)) {	
				latitude = 39.0;
		        longitude = 69.4;
		        
				coord.add(new Coord(38.75, 72.31, "Tajik National Park"));	
				coord.add(new Coord(39.50, 67.45, "Proto-urban site of Sarazm"));	
			} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 2)
					&& (((HeritageDetailActivity) getActivity()).getRegionId() == 0)
					&& (((HeritageDetailActivity) getActivity()).getCountryId() == 3)) {	
				//Turkmenistan
				latitude = 39.0;
		        longitude = 60.4;
		        
				coord.add(new Coord(37.87, 62.17, "State Historical and Cultural Park \"Ancient Merv\""));	
				coord.add(new Coord(37.99, 58.18, "Parthian Fortresses of Nisa"));	
				coord.add(new Coord(42.17, 59.8, "Kunya-Urgench"));
			} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 2)
					&& (((HeritageDetailActivity) getActivity()).getRegionId() == 0)
					&& (((HeritageDetailActivity) getActivity()).getCountryId() == 4)) {	
				latitude = 40.0;
		        longitude = 64.4;
		        
				coord.add(new Coord(39.84, 67.0, "Samarkand-Crossroad of Cultures"));	
				coord.add(new Coord(39.03, 66.83, "Historical Center of Shakhrisyabz"));	
				coord.add(new Coord(39.76, 64.42, "Historical Center of Bukhara"));
				coord.add(new Coord(41.37, 60.35, "Itchan Kala"));
			} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 2)
					&& (((HeritageDetailActivity) getActivity()).getRegionId() == 1)
					&& (((HeritageDetailActivity) getActivity()).getCountryId() == 0)) {	
				// CHINA
				latitude = 34.0;
		        longitude = 106.7;
		        
				coord.add(new Coord(36.26, 117.8, "Mount Taishan"));	
				coord.add(new Coord(40.42, 116.07, "The Great Wall"));	
				coord.add(new Coord(41.78, 123.42, "Imperial Palaces of the Ming and Qing Dynasty"));
				coord.add(new Coord(34.37, 109.09, "Mausoleum of the First Qin Emperor"));
				coord.add(new Coord(40.12, 94.82, "Mogao Caves"));
				
				coord.add(new Coord(39.72, 115.91, "Peking Man Site at Zhoukoudian"));	
				coord.add(new Coord(30.17, 118.18, "Mount Huangshan"));	
				coord.add(new Coord(33.7, 103.92, "Jiuzhaigou Valley Scenic and Historic Interest Area"));
				coord.add(new Coord(32.75, 103.83, "Huanglong Scenic and Historic Interest Area"));
				coord.add(new Coord(29.33, 110.50, "Wulingyuan Valley Scenic and Historic Interest Area"));
				
				coord.add(new Coord(32.48, 111.0, "Ancient Building Complex in the Wudang Mountains"));	
				coord.add(new Coord(40.99, 117.93, "Mountain Resort and its Outlying Temples in Chengde"));	
				coord.add(new Coord(35.60, 116.98, "Temple and Cemetery of Confucius, and the Kong Family Mansion"));
				coord.add(new Coord(29.66, 91.11, "Historic Ensemble of the Potala Palace, Lhasa"));
				coord.add(new Coord(29.53, 103.76, "Mount Emei Scenic Area, including Leshan Giant Buddha Scenic Area"));

				coord.add(new Coord(29.42, 115.88, "Lushan National Park"));	
				coord.add(new Coord(37.22, 112.14, "Ancient City of Ping Yao"));	
				coord.add(new Coord(31.33, 120.45, "Classical Gardens of Suzhou"));
				coord.add(new Coord(26.87, 100.22, "Old Town of Lijiang"));
				coord.add(new Coord(39.93, 116.13, "Summer Palace"));

				coord.add(new Coord(39.84, 116.43, "Temple of Heaven"));	
				coord.add(new Coord(29.70, 105.70, "Dazu Rock Carvings"));	
				coord.add(new Coord(27.72, 117.68, "Mount Wuyi"));
				coord.add(new Coord(29.91, 117.99, "Ancient Villages in Southern Anhui - Xidi and Hongcun"));
				coord.add(new Coord(41.70, 124.78, "Imperial Tombs of the Ming and Qing Dynasties"));

				coord.add(new Coord(34.47, 112.47, "Longmen Grottoes"));	
				coord.add(new Coord(31.01, 103.60, "Mount Qingcheng and the Dujiangyan Irrigation System"));	
				coord.add(new Coord(40.11, 113.12, "Yungang Grottoes"));
				coord.add(new Coord(27.89, 98.41, "Three Parallel Rivers of Yunnan Protected Areas"));
				coord.add(new Coord(41.14, 126.19, "Capital Cities and Tombs of the Ancient Koguryo Kingdom"));
				
				coord.add(new Coord(22.18, 113.53, "Historic Centre of Macau"));	
				coord.add(new Coord(36.11, 114.29, "Yin Xu"));	
				coord.add(new Coord(30.83, 103.00, "Sichuan Giant Panda Sanctuaries"));
				coord.add(new Coord(22.28, 112.55, "Kaiping Diaolou and Villages"));
				coord.add(new Coord(24.92, 110.35, "South China Karst"));
				
				coord.add(new Coord(25.02, 117.68, "Fujian Tulou"));	
				coord.add(new Coord(28.90, 118.6, "Mount Sanqingshan National Park"));	
				coord.add(new Coord(39.03, 113.55, "Mount Wutai"));
				coord.add(new Coord(34.45, 113.07, "Historic Monuments of Dengfeng in \"The Centre of Heaven and Earth\""));
				coord.add(new Coord(28.42, 106.4, "China Danxia"));

				coord.add(new Coord(30.25, 120.13, "West Lake Cultural Landscape of Hangzhou"));	
				coord.add(new Coord(24.84, 102.98, "Chengjiang Fossil Site"));	
				coord.add(new Coord(42.35, 116.18, "Site of Xanadu"));
				coord.add(new Coord(41.98, 80.35, "Xinjiang Tianshan"));
				coord.add(new Coord(23.08, 102.77, "Cultural Landscape of Honghe Hani Rice Terraces"));	

				coord.add(new Coord(34.30, 108.85, "Silk Roads: the Routes Network of Chang'an-Tianshan Corridor"));	
				coord.add(new Coord(34.68, 112.47, "The Grand Canal"));
			} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 2)
					&& (((HeritageDetailActivity) getActivity()).getRegionId() == 1)
					&& (((HeritageDetailActivity) getActivity()).getCountryId() == 1)) {	
				// JAPAN
				latitude = 36.0;
		        longitude = 135.4;
		        
				coord.add(new Coord(34.62, 135.72, "Buddhist Monuments in the Horyu-ji Area"));	
				coord.add(new Coord(34.83, 134.68, "Himeji-jo"));	
				coord.add(new Coord(30.33, 130.51, "Yakushima"));
				coord.add(new Coord(40.47, 140.11, "Shirakami-Sanchi"));
				coord.add(new Coord(34.98, 135.76, "Historic Monuments of Ancient Kyoto"));
				
				coord.add(new Coord(36.39, 136.87, "Historic Villages of Shirakawa-go and Gokayama"));	
				coord.add(new Coord(34.37, 132.43, "Hiroshima Peace Memorial"));	
				coord.add(new Coord(34.28, 132.33, "Itsukushima Shinto Shrine"));
				coord.add(new Coord(34.67, 135.84, "Historic Monuments of Ancient Nara"));
				coord.add(new Coord(36.74, 139.61, "Shrines and Temples of Nikko"));
				
				coord.add(new Coord(26.20, 127.67, "Gusuku Sites and Related Properties of the Kingdom of Ryukyu"));	
				coord.add(new Coord(33.87, 135.76, "Sacred Sites and Pilgrimage Routes in the Kii Mountain Range"));	
				coord.add(new Coord(43.93, 144.95, "Shiretoko National Park"));
				coord.add(new Coord(35.11, 132.43, "Iwami Ginzan Silver Mine and its Cultural Landscape"));
				coord.add(new Coord(39.01, 141.10, "Hiraizumi"));

				coord.add(new Coord(27.72, 142.9, "Ogasawara Islands"));	
				coord.add(new Coord(35.35, 138.71, "Fujisan"));	
				coord.add(new Coord(36.28, 138.90, "Tomioka Silk Mill and Related Sites"));

			} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 2)
					&& (((HeritageDetailActivity) getActivity()).getRegionId() == 1)
					&& (((HeritageDetailActivity) getActivity()).getCountryId() == 2)) {	
				// SKorea
				latitude = 36.0;
		        longitude = 127.4;
		        
				coord.add(new Coord(35.76, 129.34, "Seokguram Grotto and Bulguksa Temple"));	
				coord.add(new Coord(35.78, 128.08, "Haeinsa Temple Janggyeong Panjeon"));	
				coord.add(new Coord(37.54, 126.98, "Jongmyo Shrine"));
				coord.add(new Coord(37.53, 126.98, "Changdeokgung Palace Complex"));
				coord.add(new Coord(37.26, 127.01, "Hwaseong Fortress"));
				
				coord.add(new Coord(35.78, 129.22, "Gyeongju Historic Areas"));	
				coord.add(new Coord(34.98, 126.92, "Gochang, Hwasun and Ganghwa Dolmen Sites"));	
				coord.add(new Coord(33.48, 126.88, "Jeju Volcanic Island and Lava Tubes"));
				coord.add(new Coord(37.18, 128.46, "Royal Tombs of the Joseon Dynasty"));
				coord.add(new Coord(36.53, 128.52, "Historic Villages of Korea: Hahoe and Yangdong"));
				
				coord.add(new Coord(37.47, 127.18, "Namhansanseong"));	

			} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 2)
					&& (((HeritageDetailActivity) getActivity()).getRegionId() == 1)
					&& (((HeritageDetailActivity) getActivity()).getCountryId() == 3)) {	
				// Mongolia
				latitude = 48.6;
		        longitude = 95.4;
		        
				coord.add(new Coord(47.55, 102.83, "Orkhon Valley Cultural Landscape"));	
				coord.add(new Coord(49.34, 88.39, "Petroglyphic Complexes of the Mongolian Altai"));	
				coord.add(new Coord(50.26, 92.72, "Uvs Nuur Basin"));
				
			} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 2)
					&& (((HeritageDetailActivity) getActivity()).getRegionId() == 1)
					&& (((HeritageDetailActivity) getActivity()).getCountryId() == 4)) {	
				// NKorea
				latitude = 38.0;
		        longitude = 126.0;
		        
				coord.add(new Coord(37.98, 126.50, "Historic Monuments and Sites in Kaesong"));	
				coord.add(new Coord(38.85, 125.40, "Complex of Koguryo Tombs"));	
				
			} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 2)
					&& (((HeritageDetailActivity) getActivity()).getRegionId() == 2)
					&& (((HeritageDetailActivity) getActivity()).getCountryId() == 0)) {	
				// bangladesh
				latitude = 23.0;
		        longitude = 89.0;
		        
				coord.add(new Coord(22.67, 89.78, "Historic Mosque City of Bagerhat"));	
				coord.add(new Coord(25.2, 88.97, "Ruins of the Buddhist Vihara at Paharpur"));	
				coord.add(new Coord(21.54, 89.17, "The Sundarbans"));					
			} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 2)
					&& (((HeritageDetailActivity) getActivity()).getRegionId() == 2)
					&& (((HeritageDetailActivity) getActivity()).getCountryId() == 1)) {	
				// india
				latitude = 31.0;
		        longitude = 81.0;
		        
				coord.add(new Coord(27.17, 78.02, "Agra Fort"));	
				coord.add(new Coord(20.55, 75.70, "Ajanta Caves"));	
				coord.add(new Coord(23.47, 77.74, "Buddhist Monuments at Sanchi"));	
				coord.add(new Coord(20.02, 75.17, "Ellora Caves"));	
				coord.add(new Coord(27.17, 78.04, "Taj Mahal"));		

				coord.add(new Coord(19.89, 86.8, "Sun Temple, Konarak"));	
				coord.add(new Coord(12.63, 80.18, "Group of Monuments at Mahabalipuram"));	
				coord.add(new Coord(26.67, 93.41, "Kaziranza National Park"));	
				coord.add(new Coord(27.15, 77.50, "Keoladeo National Park"));	
				coord.add(new Coord(26.73, 91.02, "Manas Wildlife Sanctuary"));	

				coord.add(new Coord(15.50, 73.90, "Churches and Convents of Goa"));	
				coord.add(new Coord(18.97, 72.93, "Elephanta Caves"));	
				coord.add(new Coord(21.94, 88.89, "Sundarbans National Park"));	
				coord.add(new Coord(27.8, 77.66, "Fatehpur Sikri"));	
				coord.add(new Coord(15.32, 76.47, "Group Monuments of Hampi"));	

				coord.add(new Coord(10.76, 79.12, "Great Living Chola Temples"));	
				coord.add(new Coord(15.93, 75.83, "Group of Monuments at Pattadakal"));	
				coord.add(new Coord(24.85, 79.91, "Khajuraho Group of Monuments"));	
				coord.add(new Coord(30.72, 79.67, "Nanda Devi and Valley of Flowers National Parks"));	
				coord.add(new Coord(28.59, 77.30, "Humayun's Tomb, Dehli"));	

				coord.add(new Coord(28.51, 77.18, "Qutb Minar and its Monuments"));	
				coord.add(new Coord(11.50, 76.93, "Mountain Railways of India"));	
				coord.add(new Coord(24.68, 84.99, "Mahabodhi Temple Complex at Bodh Gaya"));	
				coord.add(new Coord(22.92, 77.56, "Rock Shelters of Bhimbetka"));	
				coord.add(new Coord(22.47, 73.52, "Champaner Pavagadh Archaeological Park"));	

				coord.add(new Coord(18.93, 72.84, "Chhatrapati Shivaji Terminus"));	
				coord.add(new Coord(28.66, 77.24, "Red Fort Complex, Delhi"));	
				coord.add(new Coord(26.92, 75.83, "The Jantar Mantar, Jaipur"));	
				coord.add(new Coord(8.51, 77.25, "Western Ghats"));	
				coord.add(new Coord(24.87, 74.62, "Hill Forts of Rajasthan"));	
coord.add(new Coord(31.83, 77.57, "Great Himalayan National Park Conservation Area"));	
				
			} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 2)
					&& (((HeritageDetailActivity) getActivity()).getRegionId() == 2)
					&& (((HeritageDetailActivity) getActivity()).getCountryId() == 2)) {	
				// nepal
				latitude = 27.5;
		        longitude = 84.4;
		        
				coord.add(new Coord(27.69, 85.32, "Kathmandu Valley"));	
				coord.add(new Coord(27.55, 86.90, "Sagarmatha National Park"));	
				coord.add(new Coord(27.50, 84.33, "Chitwan National Park"));	
				coord.add(new Coord(27.32, 83.26, "Lumbini, the Birthplace of the Lord Buddha"));		
			} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 2)
					&& (((HeritageDetailActivity) getActivity()).getRegionId() == 2)
					&& (((HeritageDetailActivity) getActivity()).getCountryId() == 3)) {	
				// pakis
				latitude = 31.0;
		        longitude = 71.0;
		        
				coord.add(new Coord(27.33, 68.13, "Archeaological Ruins at Moenjodaro"));	
				coord.add(new Coord(34.33, 71.93, "Buddhist Ruins of Takht-i-Bahi and Neighboring City Remains at Sahr-i-Bahlol"));	
				coord.add(new Coord(33.76, 72.89, "Taxila"));	
				coord.add(new Coord(31.42, 74.81, "Fort and Shalamar Gardens in Lahore"));	
				coord.add(new Coord(24.76, 67.90, "Historical Monuments at Makli, Thatta"));	
				
				coord.add(new Coord(32.95, 73.58, "Rohtas Fort"));	
			} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 2)
					&& (((HeritageDetailActivity) getActivity()).getRegionId() == 2)
					&& (((HeritageDetailActivity) getActivity()).getCountryId() == 4)) {	
				// srilangka
				latitude = 7.0;
		        longitude = 80.6;
		        
				coord.add(new Coord(7.91, 81.01, "Ancient City of Polonnaruwa"));	
				coord.add(new Coord(7.94, 80.75, "Ancient City of Sigiriya"));	
				coord.add(new Coord(7.85, 80.63, "Golden Temple of Dambulla"));	
				coord.add(new Coord(6.2, 80.23, "Old Town of Galle and its Fortifications"));	
				coord.add(new Coord(8.33, 80.38, "Sacred City of Anuradhapura"));	
				
				coord.add(new Coord(7.28, 80.64, "Sacred City of Kandy"));	
				coord.add(new Coord(7.45, 80.82, "Central Highlands of Sri Lanka"));	
				coord.add(new Coord(6.41, 80.30, "Sinharaja Forest Reserve"));		
			} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 2)
					&& (((HeritageDetailActivity) getActivity()).getRegionId() == 3)
					&& (((HeritageDetailActivity) getActivity()).getCountryId() == 0)) {	
				// cambodia
				latitude = 14.0;
		        longitude = 104.0;
		        
				coord.add(new Coord(14.38, 104.68, "Temple of Preah Vihear"));	
				coord.add(new Coord(13.42, 103.83, "Angkor"));	
					
			} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 2)
					&& (((HeritageDetailActivity) getActivity()).getRegionId() == 3)
					&& (((HeritageDetailActivity) getActivity()).getCountryId() == 1)) {	
				// indonesia
				latitude = -5.0;
		        longitude = 111.0;
						        
				coord.add(new Coord(-2.50, 101.50, "Tropical Rainforest Heritage of Sumatra"));	
				coord.add(new Coord(-7.60, 110.20, "Borobudur Temple Compounds"));	
				coord.add(new Coord(-7.75, 110.50, "Prambanan Temple Compounds"));	
				coord.add(new Coord(-8.53, 119.49, "Komodo National Park"));	
				coord.add(new Coord(-6.75, 105.33, "Ujung Kulon National Park"));		
		        
				coord.add(new Coord(-7.41, 110.83, "Sangiran Early Man Site"));	
				coord.add(new Coord(-4.75, 137.83, "Lorentz National Park"));	
				coord.add(new Coord(-8.25, 115.41, "Bali"));	
				
			} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 2)
					&& (((HeritageDetailActivity) getActivity()).getRegionId() == 3)
					&& (((HeritageDetailActivity) getActivity()).getCountryId() == 2)) {	
				// laos
				latitude = 16.0;
		        longitude = 103.6;
		        
				coord.add(new Coord(14.84, 105.83, "Vat Phou "));	
				coord.add(new Coord(19.88, 102.12, "Town of Luang Prabang"));	
					
			} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 2)
					&& (((HeritageDetailActivity) getActivity()).getRegionId() == 3)
					&& (((HeritageDetailActivity) getActivity()).getCountryId() == 3)) {	
				// malaysia
				latitude = 5.0;
		        longitude = 103.0;
		        
				coord.add(new Coord(5.06, 100.87, "Archaeological Heritage of the Lenggong Valley"));	
				coord.add(new Coord(4.11, 114.92, "Gunung Mulu National Park"));	
				coord.add(new Coord(6.25, 116.50, "Kinabalu Park"));	
				coord.add(new Coord(5.42, 100.34, "Melaka and George Town"));						
			} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 2)
					&& (((HeritageDetailActivity) getActivity()).getRegionId() == 3)
					&& (((HeritageDetailActivity) getActivity()).getCountryId() == 4)) {	
				// myanmar
				latitude = 22.0;
		        longitude = 95.0;
		        
				coord.add(new Coord(22.48, 95.83, "Pyu Ancient Cities"));	
				
			} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 2)
					&& (((HeritageDetailActivity) getActivity()).getRegionId() == 3)
					&& (((HeritageDetailActivity) getActivity()).getCountryId() == 5)) {	
				// philippines
				latitude = 12.0;
		        longitude = 121.0;
		        
				coord.add(new Coord(16.94, 121.13, "Rice Terraces of the Philippine Cordilleras"));
				coord.add(new Coord(8.95, 119.90, "Tubbataha Reefs Natural Park"));	
				coord.add(new Coord(6.72, 126.17, "Mount Hamiguitan Range Wildlife Sanctuary"));	
				coord.add(new Coord(10.17, 118.92, "Puerto Princesa Subterranean River National Park"));	
				coord.add(new Coord(17.56, 120.39, "Historic Town of Vigan"));	
				coord.add(new Coord(14.58, 120.87, "Baroque Churches of the Philippines"));					
			} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 2)
					&& (((HeritageDetailActivity) getActivity()).getRegionId() == 3)
					&& (((HeritageDetailActivity) getActivity()).getCountryId() == 6)) {	
				// thailand
				latitude = 16.0;
		        longitude = 100.0;
		        
				coord.add(new Coord(17.53, 103.35, "Ban Chiang Archaeological Site"));	
				coord.add(new Coord(14.33, 102.03, "Dong Phayayen-Khao Yai Forest Complex"));	
				coord.add(new Coord(15.34, 98.92, "Thungyai-Huai Kha Khaeng Wildlife Sanctuaries"));	
				coord.add(new Coord(17.01, 99.78, "Historic Town of Sukhothai"));	
				coord.add(new Coord(14.34, 100.55, "Historic City of Ayutthaya"));					
			} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 2)
					&& (((HeritageDetailActivity) getActivity()).getRegionId() == 3)
					&& (((HeritageDetailActivity) getActivity()).getCountryId() == 7)) {	
				// vietnam
				latitude = 18.0;
		        longitude = 106.6;
		        
				coord.add(new Coord(16.48, 107.56, "Complex of Hue Monuments"));	
				coord.add(new Coord(15.87, 108.33, "Hoi An Ancient Town"));	
				coord.add(new Coord(15.51, 108.56, "My Son Sanctuary"));	
				coord.add(new Coord(17.53, 106.15, "Phong Nha-Ke Bang National Park"));	
				coord.add(new Coord(21.03, 105.84, "Central Sector of the Imperial Citadel of Thang Long-Hanoi"));	

				coord.add(new Coord(20.07, 105.60, "Citadel of the Ho Dynasty"));	
				coord.add(new Coord(20.25, 105.89, "Trang An Scenic Landscape Complex"));	
				coord.add(new Coord(20.89, 107.08, "Ha Long Bay"));										
			} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 2)
					&& (((HeritageDetailActivity) getActivity()).getRegionId() == 4)
					&& (((HeritageDetailActivity) getActivity()).getCountryId() == 0)) {	
				// afghan
				latitude = 34.4;
		        longitude = 66.0;
		        
				coord.add(new Coord(34.84, 67.83, "Cultural Landscape and Archaeological Remains of the Bamiyan Valley"));	
				coord.add(new Coord(34.38, 64.50, "Minaret and Archaeological Remains of Jam"));						
			} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 2)
					&& (((HeritageDetailActivity) getActivity()).getRegionId() == 4)
					&& (((HeritageDetailActivity) getActivity()).getCountryId() == 1)) {	
				// bahrain
				latitude = 26.0;
		        longitude = 50.5;
		        
				coord.add(new Coord(26.24, 50.60, "Pearling, Testimony of an Island Economy"));
				coord.add(new Coord(26.22, 50.52, "Qal'at al-Bahrain"));					
			} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 2)
					&& (((HeritageDetailActivity) getActivity()).getRegionId() == 4)
					&& (((HeritageDetailActivity) getActivity()).getCountryId() == 2)) {	
				// iran
				latitude = 34.0;
		        longitude = 53.0;
		        
				coord.add(new Coord(32.66, 51.67, "Meidan Emam, Esfahan"));	
				coord.add(new Coord(32.07, 48.51, "Tchogha Zanbil"));	
				coord.add(new Coord(36.60, 47.23, "Takht-e Soleyman"));	
				coord.add(new Coord(29.11, 58.35, "Bam and its Cultural Landscape"));	
				coord.add(new Coord(30.18, 53.17, "Pasargadae"));	
				
				coord.add(new Coord(36.42, 48.79, "Soltaniyeh"));	
				coord.add(new Coord(34.39, 47.43, "Bisotun"));	
				coord.add(new Coord(38.98, 45.48, "Armenian Monastic Ensembles of Iran"));	
				coord.add(new Coord(32.02, 48.84, "Shushtar Historical Hydraulic System"));	
				coord.add(new Coord(38.07, 46.29, "Tabriz Historic Bazaar Complex"));		

				coord.add(new Coord(30.17, 53.17, "The Persian Garden"));	
				coord.add(new Coord(32.67, 51.68, "Masjed-e Jame of Isfahan"));	
				coord.add(new Coord(37.25, 55.17, "Gonbad-e Qabus"));	
				coord.add(new Coord(35.67, 51.42, "Golestan Palace"));	
				coord.add(new Coord(30.58, 61.33, "Shahr-e Sukhteh"));	

				coord.add(new Coord(38.23, 48.28, "Sheikh Safi al-din Khanegah and Shrine Ensemble in Ardabil"));								
				coord.add(new Coord(29.93, 52.88, "Persepolis"));				
			} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 2)
					&& (((HeritageDetailActivity) getActivity()).getRegionId() == 4)
					&& (((HeritageDetailActivity) getActivity()).getCountryId() == 3)) {	
				// iraq
				latitude = 35.0;
		        longitude = 43.0;
		        
				coord.add(new Coord(35.58, 42.72, "Hatra"));	
				coord.add(new Coord(34.34, 43.83, "Samarra Archaeological City"));	
				coord.add(new Coord(35.45, 43.30, "Ashur"));	
			
			} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 2)
					&& (((HeritageDetailActivity) getActivity()).getRegionId() == 4)
					&& (((HeritageDetailActivity) getActivity()).getCountryId() == 4)) {	
				// israel
				latitude = 31.7;
		        longitude = 35.0;
		        
				coord.add(new Coord(32.83, 34.97, "Bahá’i Holy Places in Haifa"));		
				coord.add(new Coord(32.58, 35.17, "Biblical Tels"));	
				coord.add(new Coord(31.60, 34.89, "Caves of Maresha and Bet-Guvrin in the Judean Lowlands"));		
				coord.add(new Coord(30.54, 35.15, "Desert Cities in the Negev"));	

				coord.add(new Coord(31.31, 35.35, "Masada"));		
				coord.add(new Coord(32.92, 35.08, "Old City of Acre"));	
				coord.add(new Coord(32.67, 34.95, "Mount Carmel"));	
				coord.add(new Coord(32.06, 34.76, "White City of Tel-Aviv"));	
					
			} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 2)
					&& (((HeritageDetailActivity) getActivity()).getRegionId() == 4)
					&& (((HeritageDetailActivity) getActivity()).getCountryId() == 5)) {	
				// jordan
				latitude = 30.5;
		        longitude = 36.0;
		        
				coord.add(new Coord(29.63, 35.44, "Wadi Rum"));		
				coord.add(new Coord(31.50, 35.92, "Um er-Rasas"));	
				coord.add(new Coord(31.81, 36.58, "Quseir Amra"));	
				coord.add(new Coord(30.33, 35.24, "Petra"));		
				
			} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 2)
					&& (((HeritageDetailActivity) getActivity()).getRegionId() == 4)
					&& (((HeritageDetailActivity) getActivity()).getCountryId() == 6)) {	
				// lebanon
				latitude = 34.0;
		        longitude = 36.0;
		        
				coord.add(new Coord(33.72, 35.92, "Anjar"));		
				coord.add(new Coord(34.01, 36.20, "Baalbek"));	
				coord.add(new Coord(34.12, 35.64, "Byblos"));	
				coord.add(new Coord(34.24, 36.04, " Ouadi Qadisha"));	
				coord.add(new Coord(33.26, 35.18, "Tyre"));	
				
			} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 2)
					&& (((HeritageDetailActivity) getActivity()).getRegionId() == 4)
					&& (((HeritageDetailActivity) getActivity()).getCountryId() == 7)) {	
				// oman
				latitude = 21.0;
		        longitude = 56.0;
		        
				coord.add(new Coord(22.99, 57.53, "Aflaj Irrigation Systems of Oman"));		
				coord.add(new Coord(23.26, 56.74, "Archaeological Sites of Bat, Al-Khutm and Al-Ayn"));	
				coord.add(new Coord(22.95, 57.30, "Bahla Fort"));	
				coord.add(new Coord(18.25, 53.64, "Land of Frankincense"));		
				
			} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 2)
					&& (((HeritageDetailActivity) getActivity()).getRegionId() == 4)
					&& (((HeritageDetailActivity) getActivity()).getCountryId() == 8)) {	
				// qatar
				latitude = 26.0;
		        longitude = 51.0;
		        
				coord.add(new Coord(25.97, 51.02, "Al Zubarah Archaeological Site"));		
				
			} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 2)
					&& (((HeritageDetailActivity) getActivity()).getRegionId() == 4)
					&& (((HeritageDetailActivity) getActivity()).getCountryId() == 9)) {	
				// saudi arabia
				latitude = 24.0;
		        longitude = 41.2;
		        
				coord.add(new Coord(26.78, 37.95, "Al-Hijr Archaeological Site "));		
				coord.add(new Coord(24.74, 46.56, "At-Turaif District in ad-Diriyah"));	
				coord.add(new Coord(21.49, 39.18, "Historic Jeddah"));		
				
			} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 2)
					&& (((HeritageDetailActivity) getActivity()).getRegionId() == 4)
					&& (((HeritageDetailActivity) getActivity()).getCountryId() == 10)) {	
				// syria
				latitude = 35.0;
		        longitude = 37.0;
		        		
				coord.add(new Coord(34.55, 38.26, "Site of Palmyra"));	
				coord.add(new Coord(32.51, 36.58, "Ancient City of Bosra"));	
				coord.add(new Coord(36.21, 37.17, "Ancient City of Aleppo"));	
				coord.add(new Coord(34.77, 36.25, "Crac des Chevaliers and Qal√ïat Salah El-Din"));	
				coord.add(new Coord(36.34, 36.84, "Ancient Villages of Northern Syria"));
				
				coord.add(new Coord(33.50, 36.32, "Ancient City of Damascus"));
				
			} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 2)
					&& (((HeritageDetailActivity) getActivity()).getRegionId() == 4)
					&& (((HeritageDetailActivity) getActivity()).getCountryId() == 11)) {	
				// turkey
				latitude = 38.0;
		        longitude = 32.0;
		        					
				coord.add(new Coord(39.37, 38.11, "Divrigi Great Mosque and Hospital"));	
				coord.add(new Coord(41.01, 28.97, "Historic Areas of Istanbul"));	
				coord.add(new Coord(40.01, 34.62, "Hattusha: the Hittite Capital"));	
				coord.add(new Coord(38.03, 38.75, "Nemrut Dag"));								
				coord.add(new Coord(37.92, 29.12, "Hierapolis - Pamukkale"));	
				
				coord.add(new Coord(36.34, 29.33, "Xanthos - Letoon"));	
				coord.add(new Coord(41.25, 32.68, "City of Safranbolu"));	
				coord.add(new Coord(39.95, 26.23, "Archaeological Site of Troy"));	
				coord.add(new Coord(41.67, 26.55, "Selimiye Mosque and its Social Complex"));
				coord.add(new Coord(37.67, 32.83, "Neolithic Site of Catalhoyuk"));	
				
				coord.add(new Coord(40.18, 29.05, "Bursa and Cumalikizik"));	
				coord.add(new Coord(39.12, 27.17, "Pergamon and its Multi-Layered Cultural Landscape"));	
				coord.add(new Coord(38.67, 34.85, "Cappadocia"));	
			
			} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 3)
					&& (((HeritageDetailActivity) getActivity()).getRegionId() == 0)
					&& (((HeritageDetailActivity) getActivity()).getCountryId() == 0)) {	
				// austria
				latitude = 47.4;
		        longitude = 15.0;		        
		        
				coord.add(new Coord(47.07, 15.39, "Graz"));		
				coord.add(new Coord(47.72, 16.72, "Fertö/Neusiedlersee"));	
				coord.add(new Coord(47.55, 13.64, " Hallstatt-Dachstein/Salzkammergut"));	
				coord.add(new Coord(47.81, 13.04, "Salzburg"));	
				coord.add(new Coord(48.22, 16.37, "Vienna"));
				
				coord.add(new Coord(48.18, 16.31, "Palace and Gardens of Schönbrunn"));		
				coord.add(new Coord(47.27, 8.20, "Prehistoric Pile dwellings around the Alps"));	
				coord.add(new Coord(47.64, 15.83, "Semmering Railway"));	
				coord.add(new Coord(48.36, 15.43, "Wachau Cultural Landscape"));	
							
			} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 3)
					&& (((HeritageDetailActivity) getActivity()).getRegionId() == 0)
					&& (((HeritageDetailActivity) getActivity()).getCountryId() == 1)) {	
				// czech
				latitude = 49.3;
		        longitude = 16.0;			
		        
				coord.add(new Coord(49.28, 17.35, "Gardens and Castle at Kromeriz "));		
				coord.add(new Coord(48.83, 14.33, "Historic Centre of Cesky Krumlov"));	
				coord.add(new Coord(50.08, 14.42, "Historic Centre of Prague"));	
				coord.add(new Coord(49.17, 15.44, "Historic Centre of Telc"));	
				coord.add(new Coord(48.95, 14.25, "Holasovice Historical Village Reservation"));	
				
				coord.add(new Coord(49.58, 17.25, "Holy Trinity Column in Olomouc"));		
				coord.add(new Coord(49.21, 15.87, "Jewish Quarter and St Procopius' Basilica in Trebic"));	
				coord.add(new Coord(49.95, 15.26, "Kutna Hora"));	
				coord.add(new Coord(48.76, 16.76, "Lednice-Valtice"));	
				coord.add(new Coord(49.87, 16.31, "Litomysl Castle"));
				
				coord.add(new Coord(49.56, 15.94, "Pilgrimage Church at Zelená Hora"));		
				coord.add(new Coord(49.20, 16.60, "Tugendhat Villa in Brno"));
			} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 3)
					&& (((HeritageDetailActivity) getActivity()).getRegionId() == 0)
					&& (((HeritageDetailActivity) getActivity()).getCountryId() == 2)) {	
				// germany
				latitude = 50.0;
		        longitude = 10.0;
						
				coord.add(new Coord(50.76, 6.08, "Aachen Cathedral"));
				coord.add(new Coord(52.15, 9.93, "St Mary's Cathedral and St Michael's Church at Hildesheim"));	
				coord.add(new Coord(49.33, 8.44, "Speyer Cathedral "));	
				coord.add(new Coord(49.75, 6.61, "Roman Monuments, Cathedral of St Peter and Church of Our Lady in Trier"));	
				coord.add(new Coord(48.27, 8.20, "Prehistoric Pile dwellings around the Alps"));		

				coord.add(new Coord(52.52, 13.39, "Museumsinsel (Museum Island), Berlin"));		
				coord.add(new Coord(51.56, 14.72, "Muskauer Park"));	
				coord.add(new Coord(49.02, 12.09, "Old town of Regensburg with Stadtamhof"));	
				coord.add(new Coord(52.39, 13.02, "Palaces and Parks of Potsdam and Berlin"));	
				coord.add(new Coord(47.67, 10.90, "Pilgrimage Church of Wies"));	       

				coord.add(new Coord(53.52, 8.55, "Wadden Sea"));		
				//coord.add(new Coord(49.8, 22.53, "Primeval Beech Forests of the Carpathians and the Ancient Beech Forests of Germany"));	
				coord.add(new Coord(49.92, 8.75, "Messel Pit Fossil Site"));	
				coord.add(new Coord(51.49, 7.04, "Zollverein Coal Mine Industrial Complex in Essen"));	
				coord.add(new Coord(49.78, 9.94, "Würzburg Residence with the Court Gardens and Residence Square"));	
				
				coord.add(new Coord(50.97,10.30, "Wartburg Castle"));		
				coord.add(new Coord(49.24, 6.84, "Völklingen Ironworks"));	
				coord.add(new Coord(50.17, 7.68, "Upper Middle Rhine Valley"));	
				coord.add(new Coord(49.88, 10.88, "Town of Bamberg"));	
				coord.add(new Coord(53.07, 8.81, "Town Hall and Roland on the Marketplace of Bremen"));	
				
				coord.add(new Coord(47.69, 9.05, "Monastic Island of Reichenau"));		
				coord.add(new Coord(51.83, 10.34, "Mines of Rammelsberg, Historic Town of Goslar and Upper Harz Water Management System "));	
				coord.add(new Coord(49.01, 8.81, "Maulbronn Monastery Complex "));	
				coord.add(new Coord(49.94, 11.57, "Margravial Opera House Bayreuth"));	
				coord.add(new Coord(51.86, 12.66, "Luther Memorials in Eisleben and Wittenberg"));	
				
				coord.add(new Coord(54.31, 13.08, "Historic Centres of Stralsund and Wismar"));		
				coord.add(new Coord(53.86, 10.68, "Hanseatic City of Lübeck"));	
				coord.add(new Coord(51.84, 12.42, "Garden Kingdom of Dessau-Wörlitz"));	
				//coord.add(new Coord(54.99, -2.63, "Frontiers of the Roman Empire"));	
				coord.add(new Coord(51.99, 9.81, "Fagus Factory in Alfeld"));	
				
				coord.add(new Coord(50.93, 6.95, "Cologne Cathedral"));		
				coord.add(new Coord(51.77, 11.15, "Collegiate Church, Castle and Old Town of Quedlinburg "));		
				coord.add(new Coord(50.83, 6.90, "Castles of Augustusburg and Falkenlust at Brühl"));	
				coord.add(new Coord(51.76, 9.40, "Carolingian Westwork and Civitas Corvey"));	
				
				coord.add(new Coord(52.43, 13.43, "Berlin Modernism Housing Estates"));		
				coord.add(new Coord(51.31, 9.39, "Bergpark Wilhelmshöhe"));	
				coord.add(new Coord(50.97, 11.33, "Bauhaus and its Sites in Weimar and Dessau"));	
				coord.add(new Coord(49.66, 8.57, "Abbey and Altenmünster of Lorsch"));	
				coord.add(new Coord(50.97, 11.33, "Classical Weimar"));
			        		        
			} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 3)
					&& (((HeritageDetailActivity) getActivity()).getRegionId() == 0)
					&& (((HeritageDetailActivity) getActivity()).getCountryId() == 3)) {	
				// hungary
				latitude = 47.5;
		        longitude = 19.0;
						
				coord.add(new Coord(46.06, 18.22, "Early Christian Necropolis of Pecs"));		
				coord.add(new Coord(47.72, 16.72, "Ferto/Neusiedlersee"));	
				coord.add(new Coord(47.58, 21.15, "Hortobagy National Park - The Puszta"));	
				coord.add(new Coord(47.55, 17.78, "Millebary Benedictine Abbey of Pannonhalma"));	
				coord.add(new Coord(47.99, 19.52, "Old Village of Holloko"));	
				
				coord.add(new Coord(48.12, 21.35, "Tokaj Wine Region"));		
				coord.add(new Coord(48.47, 20.49, "Caves of Aggtelek Karst and Slovak karst"));	
				coord.add(new Coord(47.47,19.06, "Budapest"));	

			} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 3)
					&& (((HeritageDetailActivity) getActivity()).getRegionId() == 0)
					&& (((HeritageDetailActivity) getActivity()).getCountryId() == 4)) {	
				// poland
				latitude = 51.0;
		        longitude = 19.5;
						
				coord.add(new Coord(54.03, 19.02, "Castle of the Teutonic Order in Malbork"));	
				coord.add(new Coord(51.10, 17.06, "Centennial Hall in Wroclaw"));	
				coord.add(new Coord(51.05, 16.18, "Churches of Peace in Jawor and Swidnica"));	
				coord.add(new Coord(50.06, 19.95, "Historic Center of Krakow"));	
				
				coord.add(new Coord(52.25, 21.01, "Historic Center of Warsaw"));		
				coord.add(new Coord(49.88, 19.67, "Kalwaria Zebrzydowska"));	
				coord.add(new Coord(53.01, 18.60, "Medieval Town of Torun"));	
				coord.add(new Coord(51.56, 14.72, "Park Muzakowski"));	
				coord.add(new Coord(50.72, 23.26, "Old City of Zamosc"));	
				
				coord.add(new Coord(49.97, 20.05, "Wieliczka and Bochnia Royal Salt Mines"));		
				coord.add(new Coord(49.53, 21.02, "Wooden Tserkvas of the Carpathian Region in Poland and Ukraine"));	
				coord.add(new Coord(49.75, 21.22, "Wooden Churches of Southern Mazopolska"));	
				coord.add(new Coord(52.72, 23.97, "Bialowieza Forest"));	
				coord.add(new Coord(50.03, 19.17, "Auschwitz Birkenau"));
	
			} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 3)
					&& (((HeritageDetailActivity) getActivity()).getRegionId() == 0)
					&& (((HeritageDetailActivity) getActivity()).getCountryId() == 5)) {	
				// slovakia
				latitude = 49.0;
		        longitude = 20.0;
			
				coord.add(new Coord(49.28, 21.26, "Bardejov Town Conservation Reserve"));			
				coord.add(new Coord(48.99, 20.76, "Levoca, Spissky Hrad and the Associated Cultural Monuments"));	
				coord.add(new Coord(49.03, 19.26, "Vlkolínec"));	
				coord.add(new Coord(49.34, 19.55, "Wooden Churches of the Slovak"));		
				coord.add(new Coord(48.47, 20.48, "Caves of Aggtelek Karst and Slovak Karst"));	
				coord.add(new Coord(49.8, 22.53, "Primeval Beech Forests of the Carpathians"));
				coord.add(new Coord(48.46, 18.90, "Historic Town of Banska Stiavnica"));
				
			} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 3)
					&& (((HeritageDetailActivity) getActivity()).getRegionId() == 0)
					&& (((HeritageDetailActivity) getActivity()).getCountryId() == 6)) {	
				// switzer
				latitude = 46.4;
		        longitude = 9.0;

				coord.add(new Coord(47.42, 9.37, "Abbey of St Gall"));		
				coord.add(new Coord(46.60, 10.43, "Benedictine Convent of St John at Mustair"));	
				coord.add(new Coord(47.09, 6.83, "La Chaux-de-Fonds/Le Loclem Watchmaking Town"));	
				coord.add(new Coord(46.49, 6.74, "Lavaux, Vineyard Terraces"));	
				coord.add(new Coord(46.93, 7.45, "Old City of Berne"));	
				
				coord.add(new Coord(47.27, 8.21, "Prehistoric Pile dwellings around the Alps"));		
				coord.add(new Coord(46.49, 9.84, "Rhaetian Railway in the Albula / Bernina Landscapes"));	
				coord.add(new Coord(46.18, 9.02, "Market-Town of Bellinzona"));	
				coord.add(new Coord(45.88, 8.90, "Monte San Giorgio"));	
				coord.add(new Coord(46.50, 8.02, "Swiss Alps Jungfrau-Aletsch"));
				
				coord.add(new Coord(46.92, 9.25, "Swiss Tectonic Arena Sardona"));
				
			} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 3)
					&& (((HeritageDetailActivity) getActivity()).getRegionId() == 1)
					&& (((HeritageDetailActivity) getActivity()).getCountryId() == 0)) {	
				// Azer
				latitude = 40.2;
		        longitude = 49.0;

				coord.add(new Coord(40.11, 49.37, "Gobustan Rock Art"));		
				coord.add(new Coord(40.37, 49.83, "Walled City of Baku"));	
		
			} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 3)
					&& (((HeritageDetailActivity) getActivity()).getRegionId() == 1)
					&& (((HeritageDetailActivity) getActivity()).getCountryId() == 1)) {	
				// Belarus
				latitude = 55.0;
		        longitude = 25.0;

				coord.add(new Coord(53.22, 26.85, "Cultural Complex of the Radziwill Family at Nesvizh"));	
				coord.add(new Coord(53.45, 26.46, "Mir Castle Complex"));	
				coord.add(new Coord(54.05, 26.34, "Struve Geodetic Arc"));	
				coord.add(new Coord(52.72, 23.97, "Biazowieza Forest"));	
				
			} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 3)
					&& (((HeritageDetailActivity) getActivity()).getRegionId() == 1)
					&& (((HeritageDetailActivity) getActivity()).getCountryId() == 2)) {	
				// Bulgaria
				latitude = 42.0;
		        longitude = 25.0;
						
				coord.add(new Coord(42.66, 27.72, "Ancient City of Nessebar"));		
				coord.add(new Coord(42.65, 23.26, "Boyana Church"));	
				coord.add(new Coord(43.28, 27.13, "Madara Rider"));	
				coord.add(new Coord(42.11, 23.39, "Rila Monastery"));	
				coord.add(new Coord(43.72, 25.97, "Rock-Hewn Churches of Ivanovo"));	
				
				coord.add(new Coord(42.61, 25.39, "Thracian Tomb of Kazanlak"));		
				coord.add(new Coord(43.67, 26.67, "Thracian Tomb of Sveshtari"));	
				coord.add(new Coord(41.74, 23.42, "Pirin National Park"));	
				coord.add(new Coord(44.10, 27.06, "Srebarna Nature Reserve"));	

			} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 3)
					&& (((HeritageDetailActivity) getActivity()).getRegionId() == 1)
					&& (((HeritageDetailActivity) getActivity()).getCountryId() == 3)) {	
				// Estonia
				latitude = 59.0;
		        longitude = 25.0;
		       
				coord.add(new Coord(59.05, 26.34, "Struve Geodetic Arc"));	
				coord.add(new Coord(59.42, 24.72, "Historic Centre (Old Town) of Tallinn"));		
			
			} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 3)
					&& (((HeritageDetailActivity) getActivity()).getRegionId() == 1)
					&& (((HeritageDetailActivity) getActivity()).getCountryId() == 4)) {	
				// Georgia
				latitude = 42.0;
		        longitude = 43.4;

		        coord.add(new Coord(42.25, 42.70, "Bagrati Cathedral and Gelati Monastery"));		
				coord.add(new Coord(41.84, 44.70, "Historical Monuments of Mtskheta"));	
				coord.add(new Coord(42.90, 43.01, "Upper Svaneti"));	
			
			} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 3)
					&& (((HeritageDetailActivity) getActivity()).getRegionId() == 1)
					&& (((HeritageDetailActivity) getActivity()).getCountryId() == 5)) {	
				// Latvia
				latitude = 58.0;
		        longitude = 25.0;
		       	
				coord.add(new Coord(57.05, 25.34, "Struve Geodetic Arc"));
				coord.add(new Coord(56.95, 24.11, "Historic Centre of Riga"));	
		
			} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 3)
					&& (((HeritageDetailActivity) getActivity()).getRegionId() == 1)
					&& (((HeritageDetailActivity) getActivity()).getCountryId() == 6)) {	
				// Lithuania
				latitude = 55.2;
		        longitude = 24.0;
						
				coord.add(new Coord(55.75, 26.34, "Struve Geodetic Arc"));		
				coord.add(new Coord(55.26, 20.95, "Curonian Spit"));	
				coord.add(new Coord(54.90, 24.83, "Kernave Archaeological Site"));	
				coord.add(new Coord(54.68, 25.28, "Vilnius Historic Centre"));	
		
			} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 3)
					&& (((HeritageDetailActivity) getActivity()).getRegionId() == 1)
					&& (((HeritageDetailActivity) getActivity()).getCountryId() == 7)) {	
				// Romania
				latitude = 46.0;
		        longitude = 26.2;

				coord.add(new Coord(47.77, 25.70, "Churches of Moldavia"));		
				coord.add(new Coord(45.62, 23.30, "Dacian Fortresses of the Orastie Mountains"));	
				coord.add(new Coord(46.21, 24.78, "Historic Centre of Sighisoara"));	
				coord.add(new Coord(45.17, 24.01, "Monastery of Horezu"));	
				coord.add(new Coord(46.12, 24.77, "Villages with Fortified Churches in Transylvania"));	
							
				coord.add(new Coord(45.07, 29.50, "Danube Delta"));	
				coord.add(new Coord(47.83, 24.05, "Wooden Churches of Maramures"));
			} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 3)
					&& (((HeritageDetailActivity) getActivity()).getRegionId() == 1)
					&& (((HeritageDetailActivity) getActivity()).getCountryId() == 8)) {	
				// Russia
				latitude = 54.0;
		        longitude = 51.0;		       
		        
				coord.add(new Coord(56.31, 38.12, "Sergiev Posad"));		
				coord.add(new Coord(54.97, 49.05, "Bolgar Historical and Archaeological Complex"));	
				coord.add(new Coord(55.66, 37.67, "Church of the Ascension, Kolomenskoye"));	
				coord.add(new Coord(42.05, 48.28, "Ancient City and Fortress Buildings of Derbent"));	
				coord.add(new Coord(65.07, 35.67, "Cultural and Historic Ensemble of the Solovetsky Islands"));	
				
				coord.add(new Coord(55.27, 20.95, "Curonian Spit"));		
				coord.add(new Coord(59.95, 38.56, "Ensemble of the Ferapontov Monastery"));	
				coord.add(new Coord(55.72, 37.55, "Ensemble of the Novodevichy Convent"));	
				coord.add(new Coord(55.78, 49.08, "Kazan Kremlin"));	
				coord.add(new Coord(59.95, 30.33, "Historic Centre of Saint Petersburg"));	
				
				coord.add(new Coord(58.52, 31.27, "Historic Monuments of Novgorod"));		
				coord.add(new Coord(57.66, 39.88, "Historical Centre of Yaroslavl"));	
				coord.add(new Coord(62.06, 35.22, "Kizhi Pogost"));	
				coord.add(new Coord(55.06, 21.95, "Struve Geodetic Arc"));	
				
				coord.add(new Coord(56.13, 40.42, "White Monuments of Vladimir and Suzdal"));		
				coord.add(new Coord(45.33, 136.17, "Central Sikhote-Alin"));	
				coord.add(new Coord(50.47, 86.00,  "Golden Mountains of Altai"));	
				coord.add(new Coord(53.17, 107.66, "Lake Baikal"));	
				coord.add(new Coord(60.67, 127.00, "Lena Pillars Nature Park"));	
				
				coord.add(new Coord(71.18, 179.71,  "Natural System of Wrangel Island Reserve"));		
				coord.add(new Coord(69.04, 94.15, "Putorana Plateau"));	
				coord.add(new Coord(50.27, 92.72,  "Uvs Nuur Basin "));	
				coord.add(new Coord(65.06, 60.13, "Virgin Komi Forests"));	
				coord.add(new Coord(56.33, 158.50, "Volcanoes of Kamchatka"));	
				
				coord.add(new Coord(44.0, 40.0, "Western Caucasus"));
				coord.add(new Coord(55.73, 37.62, "Kremlin and Red Square, Moscow"));	
				
			} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 3)
					&& (((HeritageDetailActivity) getActivity()).getRegionId() == 1)
					&& (((HeritageDetailActivity) getActivity()).getCountryId() == 9)) {	
				// ukraine
				latitude = 49.0;
		        longitude = 28.6;

				coord.add(new Coord(44.60, 33.49, "Ancient City of Tauric Chersonese and its Chora"));		
				coord.add(new Coord(49.84, 24.03, "L'viv ñ the Ensemble of the Historic Centre"));	
				coord.add(new Coord(48.28, 25.92, "Residence of Bukovinian and Dalmatian Metropolitans"));	
				coord.add(new Coord(51.06, 23.95, "Struve Geodetic Arc"));
				
				coord.add(new Coord(49.53, 22.53, "Wooden Tserkvas of the Carpathian Region in Poland and Ukraine"));		
				coord.add(new Coord(49.8, 22.93, "Primeval Beech Forests of the Carpathians"));	
				coord.add(new Coord(50.45, 30.51, "Kiev: Saint-Sophia Cathedral"));	
				
			} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 3)
					&& (((HeritageDetailActivity) getActivity()).getRegionId() == 2)
					&& (((HeritageDetailActivity) getActivity()).getCountryId() == 0)) {	
				// denmark
				latitude = 54.0;
		        longitude = 11.0;
		       		       
				
				coord.add(new Coord(53.51, 8.85, "Wadden Sea"));
				coord.add(new Coord(55.75, 9.42, "Jelling Mounds, Runic Stones and Church"));		
				coord.add(new Coord(56.03, 12.63, "Kronborg Castle"));	
				coord.add(new Coord(55.64, 12.07, "Roskilde Cathedral"));	
				coord.add(new Coord(69.12, -49.50, "Ilulissat Icefjord"));	
				coord.add(new Coord(55.26, 12.42, "Stevns Klint"));
								
			} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 3)
					&& (((HeritageDetailActivity) getActivity()).getRegionId() == 2)
					&& (((HeritageDetailActivity) getActivity()).getCountryId() == 1)) {	
				// finland
				latitude = 61.0;
		        longitude = 23.0;

				coord.add(new Coord(61.11, 21.77, "Bronze Age Burial Site of Sammallahdenmäki"));				
				coord.add(new Coord(61.12, 21.50, "Old Rauma"));	
				coord.add(new Coord(62.25, 25.17, "Petäjävesi Old Church"));	
				coord.add(new Coord(60.35, 26.34, "Struve Geodetic Arc"));	
				coord.add(new Coord(61.95, 26.64, "Verla Groundwood and Board Mill"));	
				
				coord.add(new Coord(63.28, 21.31, "High Coast / Kvarken Archipelago"));	
				coord.add(new Coord(60.13, 24.99, "Fortress of Suomenlinna"));
				
			} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 3)
					&& (((HeritageDetailActivity) getActivity()).getRegionId() == 2)
					&& (((HeritageDetailActivity) getActivity()).getCountryId() == 2)) {	
				// iceland
				latitude = 64.0;
		        longitude = -21.0;

				coord.add(new Coord(64.265, -21.03, "ﬁingvellir National Park"));		
				coord.add(new Coord(63.31, -20.60, "Surtsey"));	
		
			} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 3)
					&& (((HeritageDetailActivity) getActivity()).getRegionId() == 2)
					&& (((HeritageDetailActivity) getActivity()).getCountryId() == 3)) {	
				// norway
				latitude = 62.0;
		        longitude = 11.0;

				coord.add(new Coord(60.39, 5.33, "Bryggen"));		
				coord.add(new Coord(69.95, 23.17, "Rock Art of Alta"));	
				coord.add(new Coord(62.56, 11.38, "Roros Mining Town"));	
				coord.add(new Coord(69.05, 26.34, "Struve Geodetic Arc"));	
				coord.add(new Coord(61.28, 7.33, "Urnes Stave Church"));	
				
				coord.add(new Coord(65.60, 11.75, "Vegaoyan"));		
				coord.add(new Coord(62.11, 7.17, "Geirangerfjord and Nærøyfjord"));	
				
			} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 3)
					&& (((HeritageDetailActivity) getActivity()).getRegionId() == 2)
					&& (((HeritageDetailActivity) getActivity()).getCountryId() == 4)) {	
				// sweden
				latitude = 60.0;
		        longitude = 16.0;
						
				coord.add(new Coord(56.33, 16.48, "Agricultural Landscape of Southern Oland"));		
				coord.add(new Coord(65.63, 22.03, "Church Town of Gammelstad, Lulea"));	
				coord.add(new Coord(61.64, 16.18, "Decorated Farmhouses of Halsingland"));	
				coord.add(new Coord(59.97, 16.01, "Engelsberg Ironworks"));		
		        
				coord.add(new Coord(57.10, 12.372, "Grimeton Radio Station, Varberg"));		
				coord.add(new Coord(57.64, 18.28, "Hanseatic Town of Visby"));	
				coord.add(new Coord(60.60,  15.61, "Mining Area of the Great Copper Mountain in Falun"));	
				coord.add(new Coord(56.17,  15.57, "Naval Port of Karlskrona"));	
				coord.add(new Coord(58.37, 11.34, "Rock Carvings in Tanum"));	
		        
				coord.add(new Coord(59.33, 17.89, "Royal Domain of Drottningholm"));		
				coord.add(new Coord(59.26, 18.08, "Skogskyrkogarden"));	
				coord.add(new Coord(68.85, 21.34, "Struve Geodetic Arc"));	
				coord.add(new Coord(63.28, 21.30, "High Coast / Kvarken Archipelago"));	
				coord.add(new Coord(67.33, 17.57, "Laponian Area"));
				
				coord.add(new Coord(59.34, 17.53, "Birka and Hovgarden"));	
				
			} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 3)
					&& (((HeritageDetailActivity) getActivity()).getRegionId() == 3)
					&& (((HeritageDetailActivity) getActivity()).getCountryId() == 0)) {	
				// albania
				latitude = 41.0;
		        longitude = 20.0;

				coord.add(new Coord(40.06, 20.12, "Historic Centres of Berat and Gjirokastra"));	
				coord.add(new Coord(39.75, 20.02, "Butrint"));
												
			} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 3)
					&& (((HeritageDetailActivity) getActivity()).getRegionId() == 3)
					&& (((HeritageDetailActivity) getActivity()).getCountryId() == 1)) {	
				// armenia
				latitude = 40.3;
		        longitude = 44.4;

				coord.add(new Coord(40.15, 44.28, "Cathedral and Churches of Echmiatsin"));	
				coord.add(new Coord(41.08, 44.70, "Monasteries of Haghpat and Sanahin"));
				coord.add(new Coord(40.15, 44.69, "Monastery of Geghard and the Upper Azat Valley"));
				
			}  else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 3)
					&& (((HeritageDetailActivity) getActivity()).getRegionId() == 3)
					&& (((HeritageDetailActivity) getActivity()).getCountryId() == 2)) {	
				// bosnia
				latitude = 43.0;
		        longitude = 18.0;

				coord.add(new Coord(43.77, 19.28, "Mehmed Paöa Sokolovic Bridge in Viöegrad"));	
				coord.add(new Coord(43.34, 17.81, "Old City of Mostar"));
												
			}  else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 3)
					&& (((HeritageDetailActivity) getActivity()).getRegionId() == 3)
					&& (((HeritageDetailActivity) getActivity()).getCountryId() == 3)) {	
				// croatia
				latitude = 44.0;
		        longitude = 16.0;
						
				coord.add(new Coord(45.22, 13.58, "Historic Centre of Porec"));	
				coord.add(new Coord(43.50, 16.25, "Historic City of Trogir"));
				coord.add(new Coord(43.50, 16.44, "Historical Complex of Split "));		
				coord.add(new Coord(43.17, 16.64, "Stari Grad Plain"));	
				
				coord.add(new Coord(43.74, 15.90, "The Cathedral of St James in Sibenik"));
				coord.add(new Coord(44.88, 15.61, "Plitvice Lakes National Park"));	
				coord.add(new Coord(42.63, 18.08, "Old City of Dubrovnik"));

			} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 3)
					&& (((HeritageDetailActivity) getActivity()).getRegionId() == 3)
					&& (((HeritageDetailActivity) getActivity()).getCountryId() == 4)) {	
				// cyprus
				latitude = 34.7;
		        longitude = 33.0;

				coord.add(new Coord(34.78, 33.34, "Choirokoitia"));	
				coord.add(new Coord(34.92, 33.08, "Painted Churches in the Troodos Region"));
				coord.add(new Coord(34.75, 32.40, "Paphos"));
				
			} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 3)
					&& (((HeritageDetailActivity) getActivity()).getRegionId() == 3)
					&& (((HeritageDetailActivity) getActivity()).getCountryId() == 5)) {	
				// greece
				latitude = 38.3;
		        longitude = 24.0;						
				
				coord.add(new Coord(37.97, 23.72, "Acropolis, Athens"));	
				coord.add(new Coord(40.47, 22.33, "Archaeological Site of Aigai"));
				coord.add(new Coord(38.31, 22.33, "Archaeological Site of Delphi "));
				coord.add(new Coord(37.07, 22.37, "Archaeological Site of Mystras"));
				coord.add(new Coord(37.32, 21.67, "Archaeological Site of Olympia"));
				
				coord.add(new Coord(37.72, 22.75, "Archaeological Sites of Mycenae and Tiryns"));	
				coord.add(new Coord(37.39, 25.26, "Delos"));
				coord.add(new Coord(36.43, 28.22, "Medieval City of Rhodes"));
				coord.add(new Coord(38.39, 22.75, "Monasteries of Daphni, Hosios Loukas and Nea Moni of Chios"));
				coord.add(new Coord(39.62, 19.92, "Old Town of Corfu"));
				
				coord.add(new Coord(40.64, 22.95, "Paleochristian and Byzantine Monuments of Thessalonika"));	
				coord.add(new Coord(37.68, 26.94, "Pythagoreion and Heraion of Samos"));
				coord.add(new Coord(37.67, 23.12, "Sanctuary of Asklepios at Epidaurus"));
				coord.add(new Coord(37.44, 21.89, "Temple of Apollo Epicurius at Bassae"));
				coord.add(new Coord(37.28, 26.55, " Island of Patmos"));
				
				coord.add(new Coord(40.26, 24.22, "Mount Athos"));
				coord.add(new Coord(39.72, 21.62, "Meteora"));
			} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 3)
					&& (((HeritageDetailActivity) getActivity()).getRegionId() == 3)
					&& (((HeritageDetailActivity) getActivity()).getCountryId() == 6)) {	
				// holysee
				latitude = 42.0;
		        longitude = 11.5;

				coord.add(new Coord(41.92, 12.45, "Vatican City"));
				coord.add(new Coord(41.89, 12.49, "Historic Centre of Rome"));	

			} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 3)
					&& (((HeritageDetailActivity) getActivity()).getRegionId() == 3)
					&& (((HeritageDetailActivity) getActivity()).getCountryId() == 7)) {	
				// italy
				latitude = 43.4;
		        longitude = 11.7;

				coord.add(new Coord(41.06, 14.33, "Royal Palace at Caserta"));
				coord.add(new Coord(45.97, 9.17, "Sacri Monti of Piedmont and Lombardy"));	
				coord.add(new Coord(45.76, 13.37, "Patriarchal Basilica of Aquileia"));
				coord.add(new Coord(37.28, 13.58, "Archaeological Area of Agrigento"));	
				coord.add(new Coord(40.75, 14.33, "Archaeological Areas of Pompei, Herculaneum and Torre Annunziata"));
				
				coord.add(new Coord(43.06, 12.63, "Assisi, the Basilica of San Francesco"));
				coord.add(new Coord(45.38, 11.88, "Botanical Garden, Padua"));	
				coord.add(new Coord(41.08, 16.26, "Castel del Monte"));
				coord.add(new Coord(44.64, 10.92, "Cathedral, Torre Civica and Piazza Grande, Modena"));	
				coord.add(new Coord(45.45, 9.17, "Church and Dominican Convent of Santa Maria delle Grazie"));
				
				coord.add(new Coord(40.26, 15.26, "Cilento and Vallo di Diano National Park"));
				coord.add(new Coord(45.43, 10.99, "City of Verona"));	
				coord.add(new Coord(45.54, 11.54, "City of Vicenza"));
				coord.add(new Coord(40.64, 14.58, "Costiera Amalfitana"));	
				coord.add(new Coord(45.58, 9.43, "Crespi d'Adda"));
				
				coord.add(new Coord(44.42, 12.18, "Early Christian Monuments of Ravenna"));
				coord.add(new Coord(44.01, 12.10,"Etruscan Necropolises of Cerveteri and Tarquinia"));	
				coord.add(new Coord(44.84, 11.61, "Ferrara, City of the Renaissance"));
				coord.add(new Coord(44.40, 8.92, "Genoa"));	
				coord.add(new Coord(43.76, 11.25, "Historic Centre of Florence"));
				
				coord.add(new Coord(40.86, 14.25, "Historic Centre of Naples"));
				coord.add(new Coord(41.89, 12.49, "Historic Centre of Rome"));	
				coord.add(new Coord(43.47, 11.04, "Historic Centre of San Gimignano"));
				coord.add(new Coord(43.33, 11.33, "Historic Centre of Siena"));	
				coord.add(new Coord(43.06, 11.67, "Historic Centre of the City of Pienza"));
				
				coord.add(new Coord(43.72, 12.61, "Historic Centre of Urbino"));
				coord.add(new Coord(36.89, 15.06, "Late Baroque Towns of the Val di Noto"));	
				coord.add(new Coord(46.08, 13.42, "Longobards in Italy"));
				coord.add(new Coord(45.15, 10.80, "Mantua and Sabbioneta"));	
				coord.add(new Coord(43.85, 11.30, "Medici Villas and Gardens in Tuscany"));
				
				coord.add(new Coord(43.72, 10.39, "Piazza del Duomo, Pisa"));
				coord.add(new Coord(44.10, 9.72, "Portovenere, Cinque Terre, and the Islands"));	
				coord.add(new Coord(47.26, 8.20, "Prehistoric Pile dwellings around the Alps"));
				coord.add(new Coord(45.06, 7.68, "Residences of the Royal House of Savoy"));
				coord.add(new Coord(46.49, 9.84, "Rhaetian Railway in the Albula / Bernina Landscapes"));	
				
				coord.add(new Coord(45.95, 10.30, "Rock Drawings in Valcamonica" ));
				coord.add(new Coord(39.70, 8.98, "Su Nuraxi di Barumini"));
				coord.add(new Coord(37.05, 15.28, "Syracuse and the Rocky Necropolis of Pantalica"));	
				coord.add(new Coord(40.77, 17.24, "The Trulli of Alberobello"));
				coord.add(new Coord(40.66, 16.60, "The Sassi and the Park of the Rupestrian Churches of Matera"));	
				
				coord.add(new Coord(43.06, 11.55, "Val d'Orcia"));				
				coord.add(new Coord(41.94, 12.76, "Villa Adriana (Tivoli)"));	
				coord.add(new Coord(41.95, 12.78, "Villa d'Este, Tivoli"));
				coord.add(new Coord(37.35, 14.34, "Villa Romana del Casale"));					
				coord.add(new Coord(44.60, 7.95, "Vineyard Landscape of Piedmont"));	
				
				coord.add(new Coord(38.49, 14.94, "Isole Eolie"));
				coord.add(new Coord(45.90, 8.91, "Monte San Giorgio"));	
				coord.add(new Coord(37.75, 14.99, "Mount Etna"));
				coord.add(new Coord(46.60, 12.15, "The Dolomites"));
				coord.add(new Coord(45.44, 12.34, "Venice and its Lagoon"));
				
			} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 3)
					&& (((HeritageDetailActivity) getActivity()).getRegionId() == 3)
					&& (((HeritageDetailActivity) getActivity()).getCountryId() == 8)) {	
				// Macedonia
				latitude = 41.0;
		        longitude = 21.0;

		        coord.add(new Coord(41.11, 20.80, "Natural and Cultural Heritage of the Ohrid region"));
		        
			} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 3)
					&& (((HeritageDetailActivity) getActivity()).getRegionId() == 3)
					&& (((HeritageDetailActivity) getActivity()).getCountryId() == 9)) {	
				// Malta
				latitude = 36.0;
		        longitude = 14.5;

				coord.add(new Coord(35.92, 14.50, "City of Valletta"));
				coord.add(new Coord(36.04, 14.26, "Megalithic Temples of Malta"));	
				coord.add(new Coord(35.88, 14.50, "Hal Saflieni Hypogeum"));

			} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 3)
					&& (((HeritageDetailActivity) getActivity()).getRegionId() == 3)
					&& (((HeritageDetailActivity) getActivity()).getCountryId() == 10)) {	
				// Montenegro
				latitude = 43.0;
		        longitude = 19.0;

				coord.add(new Coord(42.48, 18.68, "Historical Region of Kotor"));
				coord.add(new Coord(43.12, 19.01, "Durmitor National Park"));	

			} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 3)
					&& (((HeritageDetailActivity) getActivity()).getRegionId() == 3)
					&& (((HeritageDetailActivity) getActivity()).getCountryId() == 11)) {	
				// portugal
				latitude = 40.0;
		        longitude = -8.0;
		        		
				coord.add(new Coord(41.10, -7.78, "Alto Douro Wine Region"));
				coord.add(new Coord(38.66, -27.23, "Central Zone of the Town of Angra do Heroismo in the Azores"));	
				coord.add(new Coord(39.60, -8.42, "Convent of Christ in Tomar"));
				coord.add(new Coord(38.77, -9.42, "Cultural Landscape of Sintra"));	
				coord.add(new Coord(38.88, -7.15, "Garrison Border Town of Elvas and its Fortifications "));
		        
				coord.add(new Coord(38.56, -7.91, "Historic Centre of Evora"));
				coord.add(new Coord(41.44, -8.28, "Historic Centre of Guimaraes"));	
				coord.add(new Coord(41.12, -8.61, "Historic Centre of Oporto"));
				coord.add(new Coord(38.50, -28.54, "Landscape of the Pico Island Vineyard Culture"));	
				coord.add(new Coord(39.44, -8.97, "Monastery of Alcobaca"));
		        
				coord.add(new Coord(38.66, -9.20, "Monastery of the Hieronymites and Tower of Belem in Lisbon"));	
				coord.add(new Coord(40.68, -6.66, "Prehistoric Rock Art Sites in the Coa Valley and Siega Verde"));
				coord.add(new Coord(40.20, -8.42, "University of Coimbra - Alta and Sofia"));	
				coord.add(new Coord(32.76, -17.0 ,"Laurisilva of Madeira"));
				coord.add(new Coord(39.66, -8.83, "Monastery of Batalha"));
		        		
			} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 3)
					&& (((HeritageDetailActivity) getActivity()).getRegionId() == 3)
					&& (((HeritageDetailActivity) getActivity()).getCountryId() == 12)) {	
				// sanmarino
		        latitude = 44.0;
		        longitude = 12.45;
		        
				coord.add(new Coord(43.92, 12.45, "San Marino Historic Centre and Mount Titano"));

			} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 3)
					&& (((HeritageDetailActivity) getActivity()).getRegionId() == 3)
					&& (((HeritageDetailActivity) getActivity()).getCountryId() == 13)) {	
				// Serbia
				latitude = 43.0;
		        longitude = 21.0;

				coord.add(new Coord(43.90, 22.18, "Gamzigrad-Romuliana"));
				coord.add(new Coord(42.66, 20.25, "Medieval Monuments in Kosovo"));	
				coord.add(new Coord(43.11, 20.42, "Stari Ras and Sopocani"));
				coord.add(new Coord(43.49, 20.53, "Studenica Monastery"));	
			
			} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 3)
					&& (((HeritageDetailActivity) getActivity()).getRegionId() == 3)
					&& (((HeritageDetailActivity) getActivity()).getCountryId() == 14)) {	
				// slovenia
				latitude = 45.0;
		        longitude = 14.0;

				coord.add(new Coord(45.76 ,14.84, "Heritage of Mercury. Almaden and Idrija"));
				//coord.add(new Coord(47.26, 14.20, "Prehistoric Pile dwellings around the Alps"));	
				coord.add(new Coord(45.67, 14.0, "Skocjan Caves"));
	
			} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 3)
					&& (((HeritageDetailActivity) getActivity()).getRegionId() == 3)
					&& (((HeritageDetailActivity) getActivity()).getCountryId() == 15)) {	
				// spain
				latitude = 40.0;
		        longitude = -2.3;
		        
				coord.add(new Coord(37.17, -3.58, "Alhambra, Generalife and Albayzin, Granada"));
				coord.add(new Coord(40.03, -3.60, "Aranjuez Cultural Landscape"));	
				coord.add(new Coord(38.90, -6.34, "Archaeological Ensemble of Merida"));
				coord.add(new Coord(41.10,  1.25, "Archaeological Ensemble of Tarraco"));	
				coord.add(new Coord(42.37, -3.53, "Archaeological Site of Atapuerca"));
				
				coord.add(new Coord(42.34, -3.70, "Burgos Cathedral"));
				coord.add(new Coord(42.50, 0.81, "Catalan Romanesque Churches of the Vall de Boi"));	
				coord.add(new Coord(37.39, -5.99, "Cathedral, Alcazar and Archivo de Indias in Seville"));
				coord.add(new Coord(43.37, -4.09, "Cave of Altamira and Paleolithic Cave Art of Northern Spain"));	
				coord.add(new Coord(39.72, 2.68, "Cultural Landscape of the Serra de Tramuntana"));
				
				coord.add(new Coord(38.76, -4.84, "Heritage of Mercury. Almaden and Idrija"));
				coord.add(new Coord(37.87, -4.77, "Historic Centre of Cordoba"));	
				coord.add(new Coord(39.87, -4.02, "Historic City of Toledo"));
				coord.add(new Coord(40.06, -2.11, "Historic Walled Town of Cuenca"));	
				coord.add(new Coord(39.47, 0.37, "La Lonja de la Seda de Valencia"));
				
				coord.add(new Coord(42.47, -6.76, "Las Medulas"));
				coord.add(new Coord(40.56, -4.11, "Monastery and Site of the Escurial, Madrid"));	
				coord.add(new Coord(43.35, -5.84, "Monuments of Oviedo and the Kingdom of the Asturias"));
				coord.add(new Coord(40.34, -1.09, "Mudejar Architecture of Aragon"));	
				coord.add(new Coord(40.95, -5.66, "Old City of Salamanca"));		        
				
				coord.add(new Coord(40.66, -4.70, "Old Town of Avila with its Extra-Muros Churches "));
				coord.add(new Coord(39.47, -6.37, "Old Town of Caceres"));	
				coord.add(new Coord(40.93, -4.11, "Old Town of Segovia and its Aqueduct"));
				coord.add(new Coord(41.38, 2.17, "Palau de la Musica Catalana and Hospital de Sant Pau, Barcelona"));	
				coord.add(new Coord(38.26, 0.72, "Palmeral of Elche"));
				
				coord.add(new Coord(41.37, 1.06, "Poblet Monastery"));
				coord.add(new Coord(40.68, -6.66, "Prehistoric Rock Art Sites in the Coa Valley and Siega Verde"));	
				coord.add(new Coord(38.01, -3.37, "Renaissance Monumental Ensembles of Ubeda and Baeza "));
				coord.add(new Coord(39.78, -1.03, "Rock Art of the Mediterranean Basin on the Iberian Peninsula"));	
				coord.add(new Coord(43.01, -7.55, "Roman Walls of Lugo"));
		        		
				coord.add(new Coord(42.45, -5.88, "Route of Santiago de Compostela"));
				coord.add(new Coord(39.45, -5.33, "Royal Monastery of Santa MarÌa de Guadalupe"));	
				coord.add(new Coord(28.47, -16.31, "San Cristobal de La Laguna"));
				coord.add(new Coord(42.33, -2.86, "San Mill·n Yuso and Suso Monasteries"));	
				coord.add(new Coord(42.88, -8.53, "Santiago de Compostela"));
		        		
				coord.add(new Coord(43.37, -8.39, "Tower of Hercules"));
				coord.add(new Coord(40.47, -3.36, "University and Historic Precinct of Alcal· de Henares"));	
				coord.add(new Coord(43.33, -3.02, "Vizcaya Bridge"));
				coord.add(new Coord(41.40, 2.15, "Works of Antoni Gaudi"));	
				coord.add(new Coord(36.93, -6.35, "Donana National Park"));
		        
		        coord.add(new Coord(28.11, -17.24, "Garajonay National Park"));
				coord.add(new Coord(28.26, -16.64, "Teide National Park"));	
				coord.add(new Coord(38.93, 1.44, "Ibiza, Biodiversity and Culture"));
				coord.add(new Coord(42.68, 0.01, "Pyrenees - Mont Perdu"));							   
		        
			} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 3)
					&& (((HeritageDetailActivity) getActivity()).getRegionId() == 4)
					&& (((HeritageDetailActivity) getActivity()).getCountryId() == 0)) {	
				// belgium
				latitude = 50.4;
		        longitude = 4.0;
		       
				coord.add(new Coord(50.17, 3.23, "Belfries of Belgium and France"));
				coord.add(new Coord(51.03, 4.47, "Flemish Beguinages"));	
				coord.add(new Coord(51.20, 3.22, "Historic Centre of Brugge"));
				coord.add(new Coord(50.84, 4.35, "La Grand-Place, Brussels"));	
				coord.add(new Coord(50.44, 3.84, "Major Mining Sites of Wallonia"));
		        		
				coord.add(new Coord(50.83, 4.35, "Major Town Houses of the Architect Victor Horta "));
				coord.add(new Coord(50.42, 3.97, "Neolithic Flint Mines at Spiennes"));	
				coord.add(new Coord(50.60, 3.38, "Notre-Dame Cathedral in Tournai"));
				coord.add(new Coord(51.23, 4.38, "Plantin-Moretus House-Workshops-Museum Complex"));	
				coord.add(new Coord(50.84, 4.40, "Stoclet House "));
				coord.add(new Coord(50.47, 4.12, "Hainaut")); 
		        		
			} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 3)
					&& (((HeritageDetailActivity) getActivity()).getRegionId() == 4)
					&& (((HeritageDetailActivity) getActivity()).getCountryId() == 1)) {	
				// France
				latitude = 48.0;
		        longitude = 2.3;

				coord.add(new Coord(46.55, 0.86, "Abbey Church of Saint-Savin sur Gartempe"));
				coord.add(new Coord(49.88, 2.31, "Amiens Cathedral"));	
				coord.add(new Coord(43.67, 4.61, "Arles, Roman and Romanesque Monuments"));
				coord.add(new Coord(50.17, 3.23, "Belfries of Belgium and France "));	
				coord.add(new Coord(44.84, 0.56, "Bordeaux, Port of the Moon"));
				
				coord.add(new Coord(47.07, 2.39, "Bourges Cathedral"));
				coord.add(new Coord(43.60, 1.40, "Canal du Midi"));	
				coord.add(new Coord(49.25, 4.03, "Cathedral of Notre-Dame, Former Abbey of Saint-RÈmi and Palace of Tau, Reims"));
				coord.add(new Coord(48.44, 1.49, "Chartres Cathedral"));	
				coord.add(new Coord(47.64, 4.38, "Cistercian Abbey of Fontenay"));
				
				coord.add(new Coord(44.39, 4.40, "Grotte Chauvet-Pont d'Arc, Ardeche"));
				coord.add(new Coord(43.92, 2.12, "Episcopal City of Albi"));	
				coord.add(new Coord(50.26, 2.75, "Fortifications of Vauban"));
				coord.add(new Coord(46.94, 5.89, "Production of Open-pan Salt"));	
				coord.add(new Coord(43.95, 4.80, "Historic Centre of Avignon"));			
						
				coord.add(new Coord(43.20, 2.35, "Historic Fortified City of Carcassonne"));
				coord.add(new Coord(45.76, 4.83, "Historic Site of Lyons"));	
				coord.add(new Coord(44.89, 0.15, "Jurisdiction of Saint-Emilion"));
				coord.add(new Coord(49.49, 0.12, "Le Havre, the City Rebuilt by Auguste Perret"));	
				coord.add(new Coord(48.64, -1.50, "Mont-Saint-Michel and its Bay"));
						
				coord.add(new Coord(50.45, 3.53, "Nord-Pas de Calais Mining Basin"));
				coord.add(new Coord(48.41, 2.68, "Palace and Park of Fontainebleau"));	
				coord.add(new Coord(48.81, 2.11, "Palace and Park of Versailles"));
				coord.add(new Coord(48.68, 6.17,  "Place Stanislas, Place de la Carrière and Place d'Alliance in Nancy"));
						
				coord.add(new Coord(43.94, 4.53, "Pont du Gard"));
				//coord.add(new Coord(47.26, 8.20, "Prehistoric Pile dwellings around the Alps"));	
				coord.add(new Coord(45.05, 1.17, "Prehistoric Sites and Decorated Caves of the Vézère Valley"));
				coord.add(new Coord(48.55, 3.30, "Provins, Town of Medieval Fairs"));	
				coord.add(new Coord(44.12, 4.81, "Roman Theatre and its Surroundings"));			
						
				coord.add(new Coord(45.18, 0.72, "Routes of Santiago de Compostela"));
				coord.add(new Coord(48.56, 7.70,  "Strasbourg – Grande île"));	
				coord.add(new Coord(44.22, 3.47,  "The Causses and the Cévennes"));
				coord.add(new Coord(47.39, 0.70,  "The Loire Valley"));	
				coord.add(new Coord(47.45, 3.74,  "Vézelay, Church and Hill"));	

				coord.add(new Coord(42.33, 8.61, "Gulf of Porto: Calanche of Piana, Gulf of Girolata, Scandola Reserve"));	
				coord.add(new Coord(-20.41, 164.55, "Lagoons of New Caledonia"));
				coord.add(new Coord(-21.08, 55.47, "Pitons, cirques and remparts of Reunion Island"));	
				coord.add(new Coord(42.68, 0.01, "Pyrénées - Mont Perdu"));				
				coord.add(new Coord(48.85, 2.28, "Paris, Banks of the Seine"));	
				
			} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 3)
					&& (((HeritageDetailActivity) getActivity()).getRegionId() == 4)
					&& (((HeritageDetailActivity) getActivity()).getCountryId() == 2)) {	
				// Ireland
				latitude = 52.2;
		        longitude = -8.0;

				coord.add(new Coord(53.68, -6.45, "Archaeological Ensemble of the Bend of the Boyn"));
				coord.add(new Coord(51.76, -10.53, "Sceilg Mhichil"));	

			} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 3)
					&& (((HeritageDetailActivity) getActivity()).getRegionId() == 4)
					&& (((HeritageDetailActivity) getActivity()).getCountryId() == 3)) {	
				// Luxembourg
				latitude = 50.0;
		        longitude = 6.0;
		        
				coord.add(new Coord(49.60, 6.12, "City of Luxembourg: its Old Quarters and Fortifications"));

			} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 3)
					&& (((HeritageDetailActivity) getActivity()).getRegionId() == 4)
					&& (((HeritageDetailActivity) getActivity()).getCountryId() == 4)) {	
				// Netherlands
				latitude = 52.0;
		        longitude = 5.3;		       
		        		
				coord.add(new Coord(53.51, 6.55, "Wadden Sea"));
				coord.add(new Coord(51.92, 4.42, "Van Nellefabriek"));	
				coord.add(new Coord(52.36, 4.89, "Seventeenth-Century Canal Ring Area of Amsterdam"));
				coord.add(new Coord(52.64, 5.76, "Schokland and Surroundings"));	
				coord.add(new Coord(52.08, 5.13, "Rietveld Schroderhuis"));
				
				coord.add(new Coord(51.87, 4.64, "Mill Network at Kinderdijk-Elshout"));
				coord.add(new Coord(52.84, 5.67, "Ir.D.F. Woudagemaal"));	
				coord.add(new Coord(12.10, -68.91, "Historic Area of Willemstad"));
				coord.add(new Coord(52.54, 4.90, "Droogmakerij de Beemster"));	
				coord.add(new Coord(52.37, 4.89, "Defence Line of Amsterdam"));

			} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 3)
					&& (((HeritageDetailActivity) getActivity()).getRegionId() == 4)
					&& (((HeritageDetailActivity) getActivity()).getCountryId() == 5)) {	
				// uk
				latitude = 53.0;
		        longitude = -1.6;
		        		
				coord.add(new Coord(51.76, -3.08, "Blaenavon Industrial Landscape"));
				coord.add(new Coord(51.84, -1.35,  "Blenheim Palace"));	
				coord.add(new Coord(51.26, 1.07, "Canterbury Cathedral, St Augustine's Abbey, and St Martin's Church"));
				coord.add(new Coord(53.12, -4.26, "Castles and Town Walls of King Edward in Gwynedd"));	
				coord.add(new Coord(51.37, -2.35, "City of Bath"));
		        
				coord.add(new Coord(50.12, -5.38, "Cornwall and West Devon Mining Landscape"));
				coord.add(new Coord(53.02, -1.49, "Derwent Valley Mills"));	
				coord.add(new Coord(54.76, -1.57, "Durham Castle and Cathedral"));
				coord.add(new Coord(54.99, -2.60, "Frontiers of the Roman Empire"));	
				coord.add(new Coord(58.99, -3.18, "Heart of Neolithic Orkney"));
		        
				coord.add(new Coord(32.37, -64.67, "Historic Town of St George and Related Fortifications, Bermuda"));
				coord.add(new Coord(52.61, -2.47, "Ironbridge Gorge"));	
				coord.add(new Coord(53.40, -2.99, "Liverpool ñ Maritime Mercantile City"));
				//coord.add(new Coord( "Maritime Greenwich"));	
				coord.add(new Coord(55.66, -3.77, "New Lanark"));
		        
				coord.add(new Coord(55.95, -3.22, "Old and New Towns of Edinburgh"));
				coord.add(new Coord(51.49, 0.11, "Palace of Westminster and Westminster Abbey "));	
				coord.add(new Coord(52.96, -3.08, "Pontcysyllte Aqueduct and Canal"));
				coord.add(new Coord(51.47, 0.29, "Royal Botanic Gardens, Kew"));	
				coord.add(new Coord(53.84, -1.78, "Saltaire"));
		        		
						coord.add(new Coord(51.17, -1.83, "Stonehenge"));
						coord.add(new Coord(54.11, -1.56, "Studley Royal Park"));							
						coord.add(new Coord(50.70, -2.99, "Dorset and East Devon Coast"));	
						coord.add(new Coord(55.25, -6.49, "Giant's Causeway and Causeway Coast"));
		        		
						coord.add(new Coord(-40.33, -9.92, "Gough and Inaccessible Islands"));
						coord.add(new Coord(-24.37, -128.33, "Henderson Island"));	
						coord.add(new Coord(57.83, -8.56, "St Kilda"));		
						coord.add(new Coord(51.50, 0.06, "Tower of London"));
		        		
			} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 4)
					&& (((HeritageDetailActivity) getActivity()).getRegionId() == 0)
					&& (((HeritageDetailActivity) getActivity()).getCountryId() == 0)) {	
				// Australia
				latitude = -40.0;
		        longitude = 140.0;

						coord.add(new Coord(-34.0, 143.0, "Willandra Lakes Region"));
						coord.add(new Coord(-25.33, 131.0, "Uluru-Kata Tjuta National Park"));	
						coord.add(new Coord(-41.73, 145.42, "Tasmanian Wilderness"));
						coord.add(new Coord(-12.83, 132.83, "Kakadu National Park"));	
						coord.add(new Coord(-15.66, 144.96, "Wet Tropics of Queensland"));
						
						coord.add(new Coord(-25.49, 113.43, "Shark Bay, Western Australia"));
						coord.add(new Coord(-17.50, 128.50, "Purnululu National Park"));	
						coord.add(new Coord(-22.55, 113.81, "Ningaloo Coast"));
						coord.add(new Coord(-54.58, 158.89,"Macquarie Island"));	
						coord.add(new Coord(-31.55, 159.08, "Lord Howe Island Group"));
						
						coord.add(new Coord(-53.10, 73.50, "Heard and McDonald Islands"));
						coord.add(new Coord(-33.70, 150.00, "Greater Blue Mountains Area"));	
						coord.add(new Coord(-18.28, 147.68, "Great Barrier Reef"));
						coord.add(new Coord(-28.25, 150.05, "Gondwana Rainforests of Australia"));	
						coord.add(new Coord(-25.22, 153.11, "Fraser Island "));
						
				coord.add(new Coord(-19.07, 138.71, "Australian Fossil Mammal Sites"));
				coord.add(new Coord(-33.85, 151.20, "Sydney Opera House"));	
				coord.add(new Coord(-37.81, 144.97, "Royal Exhibition Building and Carlton Gardens"));
				coord.add(new Coord(-33.37, 150.99, "Australian Convict Sites"));	
				
						
			} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 4)
					&& (((HeritageDetailActivity) getActivity()).getRegionId() == 0)
					&& (((HeritageDetailActivity) getActivity()).getCountryId() == 1)) {	
				// NZ
				latitude = -45.0;
		        longitude = 170.0;
		        		
				coord.add(new Coord(-50.75, 166.10, "New Zealand Sub-Antarctic Islands"));
				coord.add(new Coord(-45.03, 167.33, "Te Wahipounamu ñ South West New Zealand"));	
				coord.add(new Coord(-39.28, 175.55, "Tongariro National Park"));
				
			} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 4)
					&& (((HeritageDetailActivity) getActivity()).getRegionId() == 1)
					&& (((HeritageDetailActivity) getActivity()).getCountryId() == 0)) {	
				// fiji
				latitude = -17.0;
		        longitude = 178.0;
		        
				coord.add(new Coord(-17.68, 178.84, "Levuka Historical Port Town"));
		
			} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 4)
					&& (((HeritageDetailActivity) getActivity()).getRegionId() == 1)
					&& (((HeritageDetailActivity) getActivity()).getCountryId() == 1)) {	
				// kiribati
				latitude = -3.0;
		        longitude = -172.0;
		        
				coord.add(new Coord(-3.66, -172.85,  "Phoenix Islands Protected Area"));
			
			}
	    } catch (InflateException e) {
	        /* map is already there, just return view as it is */
	    }
	    
		return mView;
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
		// For showing a move to my location button
		mMap.setMyLocationEnabled(true);
		
		for (Integer i = 0; i < coord.size(); i++) {
			LatLng latlng=new LatLng(coord.get(i).getX(), coord.get(i).getY());	
			// For dropping a marker at a point on the Map

			Marker locationMarker = mMap.addMarker(new MarkerOptions().position(latlng).title(coord.get(i).getDesc()));
			locationMarker.showInfoWindow();
			
			/*Bitmap.Config conf = Bitmap.Config.ARGB_8888;
			Bitmap bitmap = Bitmap.createBitmap(4 , 8, conf);	Paint paint = new Paint();
			Canvas canvas = new Canvas(bitmap);
			canvas.drawText("Text", 4, 8, paint);
			MarkerOptions options = new MarkerOptions().position(latlng).icon(BitmapDescriptorFactory.fromBitmap(bitmap));
			mMap.addMarker(options);*/
		}		
		
		LatLng latlng=new LatLng(latitude, longitude);							
		mMap.moveCamera(CameraUpdateFactory.newLatLng(latlng));//Moves the camera to users current longitude and latitude
		
		// For zooming automatically to the Dropped PIN Location		
		if ((((HeritageDetailActivity) getActivity()).getContinentId() == 0)
				&& (((HeritageDetailActivity) getActivity()).getRegionId() == 0)
				&& (((HeritageDetailActivity) getActivity()).getCountryId() == 3)) 
		{
			//Congo
			mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latlng, 5.0f));
		} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 0)
				&& (((HeritageDetailActivity) getActivity()).getRegionId() == 3)
				&& (((HeritageDetailActivity) getActivity()).getCountryId() == 2)) 
		{
			//SAfrica
			mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latlng, 5.0f));
		} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 1)
				&& (((HeritageDetailActivity) getActivity()).getRegionId() == 1)
				&& (((HeritageDetailActivity) getActivity()).getCountryId() == 0)) 
		{
			//Canada
			mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latlng, 3.0f));
		} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 1)
				&& (((HeritageDetailActivity) getActivity()).getRegionId() == 1)
				&& (((HeritageDetailActivity) getActivity()).getCountryId() == 1)) 
		{
			//Mexico
			mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latlng, 5.0f));
		} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 1)
				&& (((HeritageDetailActivity) getActivity()).getRegionId() == 1)
				&& (((HeritageDetailActivity) getActivity()).getCountryId() == 2)) 
		{
			//USA
			mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latlng, 4.0f));
		} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 1)
				&& (((HeritageDetailActivity) getActivity()).getRegionId() == 2)
				&& (((HeritageDetailActivity) getActivity()).getCountryId() == 0)) 
		{
			//argentina
			mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latlng, 4.0f));
		} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 1)
				&& (((HeritageDetailActivity) getActivity()).getRegionId() == 2)
				&& (((HeritageDetailActivity) getActivity()).getCountryId() == 2)) 
		{
			//Brazil
			mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latlng, 4.0f));
		} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 1)
				&& (((HeritageDetailActivity) getActivity()).getRegionId() == 2)
				&& (((HeritageDetailActivity) getActivity()).getCountryId() == 3)) 
		{
			//chile
			mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latlng, 5.0f));
		} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 1)
				&& (((HeritageDetailActivity) getActivity()).getRegionId() == 2)
				&& (((HeritageDetailActivity) getActivity()).getCountryId() == 5)) 
		{
			//ecuador
			mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latlng, 5.0f));
		} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 2)
				&& (((HeritageDetailActivity) getActivity()).getRegionId() == 0)
				&& (((HeritageDetailActivity) getActivity()).getCountryId() == 0)) 
		{
			//kazakh
			mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latlng, 5.0f));
		} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 2)
				&& (((HeritageDetailActivity) getActivity()).getRegionId() == 1)
				&& (((HeritageDetailActivity) getActivity()).getCountryId() == 0)) 
		{
			//China
			mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latlng, 4.0f));
		} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 2)
				&& (((HeritageDetailActivity) getActivity()).getRegionId() == 2)
				&& (((HeritageDetailActivity) getActivity()).getCountryId() == 1)) 
		{
			//India
			mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latlng, 4.0f));
		} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 2)
				&& (((HeritageDetailActivity) getActivity()).getRegionId() == 2)
				&& (((HeritageDetailActivity) getActivity()).getCountryId() == 4)) 
		{
			//sri langka
			mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latlng, 7.0f));
		} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 2)
				&& (((HeritageDetailActivity) getActivity()).getRegionId() == 3)
				&& (((HeritageDetailActivity) getActivity()).getCountryId() == 1)) 
		{
			//Indon
			mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latlng, 5.0f));
		} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 2)
				&& (((HeritageDetailActivity) getActivity()).getRegionId() == 4)
				&& (((HeritageDetailActivity) getActivity()).getCountryId() == 1)) 
		{
			//bahrain
			mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latlng, 9.0f));
		} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 2)
				&& (((HeritageDetailActivity) getActivity()).getRegionId() == 4)
				&& (((HeritageDetailActivity) getActivity()).getCountryId() == 4)) 
		{
			//israel
			mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latlng, 8.0f));
		} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 2)
				&& (((HeritageDetailActivity) getActivity()).getRegionId() == 4)
				&& (((HeritageDetailActivity) getActivity()).getCountryId() == 6)) 
		{
			//lebanon
			mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latlng, 8.0f));
		} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 3)
				&& (((HeritageDetailActivity) getActivity()).getRegionId() == 0)
				&& (((HeritageDetailActivity) getActivity()).getCountryId() == 6)) 
		{
			//switzer
			mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latlng, 7.0f));
		} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 3)
				&& (((HeritageDetailActivity) getActivity()).getRegionId() == 1)
				&& (((HeritageDetailActivity) getActivity()).getCountryId() == 8)) 
		{
			//russia
			mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latlng, 4.0f));
		} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 3)
				&& (((HeritageDetailActivity) getActivity()).getRegionId() == 3)
				&& (((HeritageDetailActivity) getActivity()).getCountryId() == 0)) 
		{
			//albania
			mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latlng, 8.0f));
		} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 3)
				&& (((HeritageDetailActivity) getActivity()).getRegionId() == 3)
				&& (((HeritageDetailActivity) getActivity()).getCountryId() == 1)) 
		{
			//armenia
			mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latlng, 8.0f));
		}  else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 3)
				&& (((HeritageDetailActivity) getActivity()).getRegionId() == 3)
				&& (((HeritageDetailActivity) getActivity()).getCountryId() == 2)) 
		{
			//bosnia
			mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latlng, 7.0f));
		} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 3)
				&& (((HeritageDetailActivity) getActivity()).getRegionId() == 3)
				&& (((HeritageDetailActivity) getActivity()).getCountryId() == 4)) 
		{
			//armenia
			mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latlng, 8.0f));
		} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 3)
				&& (((HeritageDetailActivity) getActivity()).getRegionId() == 3)
				&& (((HeritageDetailActivity) getActivity()).getCountryId() == 6)) 
		{
			//holysee
			mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latlng, 9.0f));
		} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 3)
				&& (((HeritageDetailActivity) getActivity()).getRegionId() == 3)
				&& (((HeritageDetailActivity) getActivity()).getCountryId() == 7)) 
		{
			//italy
			mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latlng, 6.0f));
		} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 3)
				&& (((HeritageDetailActivity) getActivity()).getRegionId() == 3)
				&& (((HeritageDetailActivity) getActivity()).getCountryId() == 8)) 
		{
			//macedonia
			mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latlng, 7.0f));
		} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 3)
				&& (((HeritageDetailActivity) getActivity()).getRegionId() == 3)
				&& (((HeritageDetailActivity) getActivity()).getCountryId() == 9)) 
		{
			//malta
			mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latlng, 10.0f));
		} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 3)
				&& (((HeritageDetailActivity) getActivity()).getRegionId() == 4)
				&& (((HeritageDetailActivity) getActivity()).getCountryId() == 0)) 
		{
			//belgium
			mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latlng, 8.0f));
		} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 4)
				&& (((HeritageDetailActivity) getActivity()).getRegionId() == 0)
				&& (((HeritageDetailActivity) getActivity()).getCountryId() == 0)) 
		{
			//australia
			mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latlng, 4.0f));
		}
		else 
			mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latlng, 6.0f));
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
