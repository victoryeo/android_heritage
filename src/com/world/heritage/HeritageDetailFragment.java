package com.world.heritage;

import java.util.ArrayList;

import com.world.heritage.R;

import android.os.Bundle;
import android.os.StrictMode;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

public class HeritageDetailFragment extends Fragment {
	public static String TAG = "HeritageDetailFragment";
	
	public static final HeritageDetailFragment newInstance(String sampleText) {
		HeritageDetailFragment f = new HeritageDetailFragment();

		Bundle b = new Bundle();
		if (b != null)
			b.putString("bString", sampleText);
		if (f != null)
			f.setArguments(b);
		return f;
	}

	private View mView;
	private ListView mHList;
	private TextView mHTitle;
	
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
		mView = inflater.inflate(R.layout.fragment_heritage, container, false);
		mHList = (ListView) mView.findViewById(R.id.h_list);
		mHTitle = (TextView) mView.findViewById(R.id.h_title);

		return mView;
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		
		ArrayList<HeritageItem> items = new ArrayList<HeritageItem> ();
		
		getHeritage(items);
		
		if (items != null) {
			HeritageEntryAdapter adapter = new HeritageEntryAdapter(getActivity(), items);
			mHList.setAdapter(adapter);
		}		
		
	}
	
	@Override
	public void onDestroyView() {
	    super.onDestroyView();
	    
	    HeritageEntryAdapter adapter  = (HeritageEntryAdapter) mHList.getAdapter();
	    adapter.clear();
	}
	
	private void getHeritage(ArrayList<HeritageItem> items) {
		if ((((HeritageDetailActivity) getActivity()).getContinentId() == 0)
				&& (((HeritageDetailActivity) getActivity()).getRegionId() == 0)
				&& (((HeritageDetailActivity) getActivity()).getCountryId() == 0)) {
			items.add(new HeritageEntryItem("Dja Faunal Reserve","1987","Natural", "cameroon_01"));
			items.add(new HeritageEntryItem("Sangha Trinational","2012","Natural", "cameroon_02"));
			mHTitle.setText("Cameroon");
		} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 0)
				&& (((HeritageDetailActivity) getActivity()).getRegionId() == 0)
				&& (((HeritageDetailActivity) getActivity()).getCountryId() == 1)) {
			items.add(new HeritageEntryItem("Manovo-Gounda St. Floris National Park","1988","Natural", "car_01"));
			items.add(new HeritageEntryItem("Sangha Trinational","2012","Natural", "cameroon_02"));
			mHTitle.setText("Central Africa Republic");
		} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 0)
				&& (((HeritageDetailActivity) getActivity()).getRegionId() == 0)
				&& (((HeritageDetailActivity) getActivity()).getCountryId() == 2)) {	
			items.add(new HeritageEntryItem("Lakes of Ounianga","2012","Natural", "chad_01"));
			mHTitle.setText("Chad");
		} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 0)
				&& (((HeritageDetailActivity) getActivity()).getRegionId() == 0)
				&& (((HeritageDetailActivity) getActivity()).getCountryId() == 3)) {	
			items.add(new HeritageEntryItem("Virunga National Park","1979","Natural", "congo_01"));
			items.add(new HeritageEntryItem("Garamba National Park","1980","Natural", "congo_02"));
			items.add(new HeritageEntryItem("Kahuzi-Niega National Park","2012","Natural", "congo_03"));
			
			items.add(new HeritageEntryItem("Okapi Wildlife Reserve","2012","Natural", "congo_05"));			
			items.add(new HeritageEntryItem("Salango National Park","2012","Natural", "congo_04"));
			items.add(new HeritageEntryItem("Sangha Trinational","2012","Natural", "cameroon_02"));
			mHTitle.setText("Congo");			
		} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 0)
				&& (((HeritageDetailActivity) getActivity()).getRegionId() == 0)
				&& (((HeritageDetailActivity) getActivity()).getCountryId() == 4)) {	
			items.add(new HeritageEntryItem("Ecosystem and Relict Cultural Landscape of Lope-Okanda","2007","Natural", "gabon_01"));
			mHTitle.setText("Gabon");
		} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 0)
				&& (((HeritageDetailActivity) getActivity()).getRegionId() == 1)
				&& (((HeritageDetailActivity) getActivity()).getCountryId() == 0)) {
			items.add(new HeritageEntryItem("Rock-Hewn Churches, Lalibela","1978","Cultural", "ethiopia_01"));
			items.add(new HeritageEntryItem("Simien National Park","1978","Natural", "ethiopia_02"));
			items.add(new HeritageEntryItem("Fasil Ghebbi, Gondar Region","1979","Cultural", "ethiopia_03"));
			items.add(new HeritageEntryItem("Aksum","1980","Cultural", "ethiopia_04"));		
			items.add(new HeritageEntryItem("Lower Valley of the Awash","1980","Cultural", "ethiopia_05"));
			
			items.add(new HeritageEntryItem("Lower Valley of the Omo","1980","Cultural", "ethiopia_06"));	
			items.add(new HeritageEntryItem("Tiya","1980","Cultural", "ethiopia_07"));
			items.add(new HeritageEntryItem("Harar Jugol, the Fortified Historic Town","2006","Cultural", "ethiopia_08"));
			items.add(new HeritageEntryItem("Konso Cultural Landscape","2011","Cultural", "ethiopia_09"));
			mHTitle.setText("Ethiopia");
			
		} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 0)
				&& (((HeritageDetailActivity) getActivity()).getRegionId() == 1)
				&& (((HeritageDetailActivity) getActivity()).getCountryId() == 1)) {
			items.add(new HeritageEntryItem("Mount Kenya National Park/Natural Forest","1997","Natural", "kenya_01"));
			items.add(new HeritageEntryItem("Lake Turkana National Parks","1997","Natural", "kenya_02"));
			items.add(new HeritageEntryItem("Lamu Old Town","2001","Cultural", "kenya_03"));
			items.add(new HeritageEntryItem("Sacred Mijikenda Kaya Forests","2008","Cultural", "kenya_04"));		
			items.add(new HeritageEntryItem("Lake System in the Great Rift Valley","2011","Natural", "kenya_05"));
			items.add(new HeritageEntryItem("Fort Jesus","2011","Cultural", "kenya_06"));
			mHTitle.setText("Kenya");
		}  else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 0)
				&& (((HeritageDetailActivity) getActivity()).getRegionId() == 1)
				&& (((HeritageDetailActivity) getActivity()).getCountryId() == 2)) {
			items.add(new HeritageEntryItem("Tsingy de Bemaraha Strict Nature Reserve","1990","Natural", "madagascar_01"));
			items.add(new HeritageEntryItem("Royal Hill of Ambohimanga","2001","Cultural", "madagascar_02"));
			items.add(new HeritageEntryItem("Rainforests of the Atsinanana","2007","Natural", "madagascar_03"));
			mHTitle.setText("Madagascar");
		} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 0)
				&& (((HeritageDetailActivity) getActivity()).getRegionId() == 1)
				&& (((HeritageDetailActivity) getActivity()).getCountryId() == 3)) {
			items.add(new HeritageEntryItem("Lake Malawi National Park","1984","Natural", "malawi_01"));
			items.add(new HeritageEntryItem("Chongoni Rock-Art Area","2006","Cultural", "malawi_02"));
			mHTitle.setText("Malawi");
		} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 0)
				&& (((HeritageDetailActivity) getActivity()).getRegionId() == 1)
				&& (((HeritageDetailActivity) getActivity()).getCountryId() == 4)) {
			items.add(new HeritageEntryItem("Aapravasi Ghat","2006","Cultural", "mauritius_aa"));
			items.add(new HeritageEntryItem("Le Morne Cultural Landscape","2008","Cultural", "mauritius_le"));
			mHTitle.setText("Mauritius");
		} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 0)
				&& (((HeritageDetailActivity) getActivity()).getRegionId() == 1)
				&& (((HeritageDetailActivity) getActivity()).getCountryId() == 5)) {
			items.add(new HeritageEntryItem("Island of Mozambique","1991","Cultural", "mozambique_island"));
			mHTitle.setText("Mozambique");
		} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 0)
				&& (((HeritageDetailActivity) getActivity()).getRegionId() == 1)
				&& (((HeritageDetailActivity) getActivity()).getCountryId() == 6)) {
			items.add(new HeritageEntryItem("Aldabra Atoll","1982","Natural", "sey_atoll"));
			items.add(new HeritageEntryItem("Vallee de Mai Nature Reserve","1983","Natural", "sey_val"));
			mHTitle.setText("Seychelles");						
	    } else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 0)
				&& (((HeritageDetailActivity) getActivity()).getRegionId() == 1)
				&& (((HeritageDetailActivity) getActivity()).getCountryId() == 7)) {
			items.add(new HeritageEntryItem("Kondoa Rock-Art Sites","2006","Cultural", "malawi_02"));
			items.add(new HeritageEntryItem("Ruins of Kilwa Kisiwani and Ruins of Songo Mnara","1981","Cultural", "tanz_ruins"));
			items.add(new HeritageEntryItem("Stone Town of Zanzibar","2000","Cultural", "tanz_zan"));
			items.add(new HeritageEntryItem("Kilimanjaro National Park ","1987","Natural", "tanz_kili"));
			items.add(new HeritageEntryItem("Selous Game Reserve ","1982","Natural", "tanz_sel"));
			
			items.add(new HeritageEntryItem("Serengeti National Park","1981","Natural", "tanz_ser"));
			items.add(new HeritageEntryItem("Ngorongoro Conservation Area ","1979","Mixed", "tanz_ngo"));
			
			mHTitle.setText("Tanzania");						
	    } else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 0)
				&& (((HeritageDetailActivity) getActivity()).getRegionId() == 1)
				&& (((HeritageDetailActivity) getActivity()).getCountryId() == 8)) {
			items.add(new HeritageEntryItem("Tombs of Buganda Kings at Kasubi ","2001","Cultural", "uganda_bu"));
			items.add(new HeritageEntryItem("Bwindi Impenetrable National Park ","1994","Natural", "uganda_bwi"));
			items.add(new HeritageEntryItem("Rwenzori Mountains National Park ","1994","Natural", "uganda_rwe"));
									
			mHTitle.setText("Uganda");						
	    } else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 0)
				&& (((HeritageDetailActivity) getActivity()).getRegionId() == 1)
				&& (((HeritageDetailActivity) getActivity()).getCountryId() == 9)) {
			items.add(new HeritageEntryItem("Great Zimbabwe National Monument ","1986","Cultural", "zim_nat"));
			items.add(new HeritageEntryItem("Khami Ruins National Monument  ","1986","Cultural", "zim_khami"));
			items.add(new HeritageEntryItem("Matobo Hills ","2003","Cultural", "zim_mato"));
			items.add(new HeritageEntryItem("Mana Pools National Park, Sapi and Chewore Safari Areas ","1984","Natural", "zim_mana"));			
			items.add(new HeritageEntryItem("Mosi-oa-Tunya / Victoria Falls ","1989","Natural", "zim_mosi"));
			
			mHTitle.setText("Zimbabwe");						
	    } else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 0)
				&& (((HeritageDetailActivity) getActivity()).getRegionId() == 2)
				&& (((HeritageDetailActivity) getActivity()).getCountryId() == 0)) {
			items.add(new HeritageEntryItem("Al Qal'a of Beni Hammad","1980","Cultural", "algeria_alqala"));
			items.add(new HeritageEntryItem("Djemila","1982","Cultural", "algeria_djemila"));
			items.add(new HeritageEntryItem("Kasbah of Algiers","1992","Cultural", "algeria_algiers"));
			items.add(new HeritageEntryItem("M'Zab Valley","1982","Cultural", "algeria_mzab"));
			items.add(new HeritageEntryItem("Timgad","1982","Cultural", "algeria_timgad"));
			
			items.add(new HeritageEntryItem("Tipasa","1982","Cultural", "algeria_tipasa"));
			items.add(new HeritageEntryItem("Tassili n'Ajjer","1982","Mixed", "algeria_tassili"));
			mHTitle.setText("Algeria");
		} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 0)
				&& (((HeritageDetailActivity) getActivity()).getRegionId() == 2)
				&& (((HeritageDetailActivity) getActivity()).getCountryId() == 1)) {						
			items.add(new HeritageEntryItem("Abu Mena","1979","Cultural", "egypt_abu"));
			items.add(new HeritageEntryItem("Ancient Thebes with its Necropolis","1979","Cultural", "egypt_thebes"));
			items.add(new HeritageEntryItem("Historic Cairo","1979","Cultural", "egypt_cairo"));
			items.add(new HeritageEntryItem("Memphis and its Necropolis - the Pyramid Fields from Giza to Dahshur","1979","Cultural", "egypt_pyramid"));
			items.add(new HeritageEntryItem("Nubian Monuments from Abu Simbel to Philae","1979","Cultural", "egypt_nubian"));
			
			items.add(new HeritageEntryItem("Saint Catherine Area","2002","Cultural", "egypt_saint"));
			items.add(new HeritageEntryItem("Wadi Al-Hitan (Whale Valley)","2005","Natural", "egypt_wadi"));
			mHTitle.setText("Egypt");
		} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 0)
				&& (((HeritageDetailActivity) getActivity()).getRegionId() == 2)
				&& (((HeritageDetailActivity) getActivity()).getCountryId() == 2)) {
			items.add(new HeritageEntryItem("Archaeological Site of Cyrene","1982","Cultural", "libya_cyrene"));		
			items.add(new HeritageEntryItem("Archaeological Site of Leptis Magna","1982","Cultural", "libya_leptis"));
			items.add(new HeritageEntryItem("Archaeological Site of Sabratha","1982","Cultural", "libya_sabratha"));
			items.add(new HeritageEntryItem("Old Town of Ghadam's","1986","Cultural", "libya_gha"));
			items.add(new HeritageEntryItem("Rock-Art Sites of Tadrart Acacus","1985","Cultural", "libya_acacus"));
			
			mHTitle.setText("Libya");
		} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 0)
				&& (((HeritageDetailActivity) getActivity()).getRegionId() == 2)
				&& (((HeritageDetailActivity) getActivity()).getCountryId() == 3)) {
			items.add(new HeritageEntryItem("Medina of Fez","1981","Cultural", "morocco_fez"));
			items.add(new HeritageEntryItem("Medina of Marrakesh","1985","Cultural", "morocco_marrakesh"));			
			items.add(new HeritageEntryItem("Ksar of Ait-Ben-Haddou","1987","Cultural", "morocco_ksar"));
			items.add(new HeritageEntryItem("Historic City of Meknes","1996","Cultural", "morocco_meknes"));			
			items.add(new HeritageEntryItem("Archaeological Site of Volubilis","1997","Cultural", "morocco_volu"));
			
			items.add(new HeritageEntryItem("Medina of Tztouan (formerly known as Titawin)","1997","Cultural", "morocco_tetouan"));
			items.add(new HeritageEntryItem("Medina of Essaouira (formerly Mogador)","2001","Cultural", "morocco_mogador"));
			items.add(new HeritageEntryItem("Portuguese City of Mazagan (El Jadida)","2004","Cultural", "morocco_mazagan"));
			items.add(new HeritageEntryItem("Rabat, Modern Capital and Historic City: a Shared Heritage","2012","Cultural", "morocco_rabat"));
			
			mHTitle.setText("Morocco");
		} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 0)
				&& (((HeritageDetailActivity) getActivity()).getRegionId() == 2)
				&& (((HeritageDetailActivity) getActivity()).getCountryId() == 4)) {
			items.add(new HeritageEntryItem("Gebel Barkal and the Sites of the Napatan Region","2004","Cultural", "sudan_gebel"));
			items.add(new HeritageEntryItem("Archaeological Sites of the Island of Meroe","2011","Cultural", "sudan_meroe"));
			
			mHTitle.setText("Sudan");
		} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 0)
				&& (((HeritageDetailActivity) getActivity()).getRegionId() == 2)
				&& (((HeritageDetailActivity) getActivity()).getCountryId() == 5)) {
			items.add(new HeritageEntryItem("Amphitheatre of El Jem","1979","Cultural", "tunisia_eljem"));
			items.add(new HeritageEntryItem("Archaeological Site of Carthage","1979","Cultural", "tunisia_carthage"));
			items.add(new HeritageEntryItem("Medina of Tunis","1979","Cultural", "tunisia_tunis"));
			items.add(new HeritageEntryItem("Ichkeul National Park","1980","Natural", "tunisia_ichkeul"));
			items.add(new HeritageEntryItem("Punic Town of Kerkuana and its Necropolis","1985","Cultural", "tunisia_punic"));

			items.add(new HeritageEntryItem("Kairouan","1988","Cultural", "tunisia_kairou"));
			items.add(new HeritageEntryItem("Medina of Sousse","1988","Cultural", "tunisia_sousse"));
			items.add(new HeritageEntryItem("Dougga/Thugga","1997","Cultural", "tunisia_dougga"));
						
			mHTitle.setText("Tunisia");
		} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 0)
				&& (((HeritageDetailActivity) getActivity()).getRegionId() == 3)
				&& (((HeritageDetailActivity) getActivity()).getCountryId() == 0)) {
			items.add(new HeritageEntryItem("Tsodilo","2001","Cultural", "bots_tso"));
			items.add(new HeritageEntryItem("Okavango Delta","2014","Natural", "bots_oka"));
			mHTitle.setText("Botswana");
		} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 0)
				&& (((HeritageDetailActivity) getActivity()).getRegionId() == 3)
				&& (((HeritageDetailActivity) getActivity()).getCountryId() == 1)) {
			items.add(new HeritageEntryItem("Twyfelfontein","2007","Cultural", "namib_twy"));
			items.add(new HeritageEntryItem("Namib Sand Sea","2014","Natural", "namib_des"));
			mHTitle.setText("Namibia");
		} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 0)
				&& (((HeritageDetailActivity) getActivity()).getRegionId() == 3)
				&& (((HeritageDetailActivity) getActivity()).getCountryId() == 2)) {
			items.add(new HeritageEntryItem("Fossil Hominid Sites of South Africa","1999","Cultural", "safrica_fossil"));
			items.add(new HeritageEntryItem("Robben Island","1999","Cultural", "safrica_robben"));						
			items.add(new HeritageEntryItem("Simangaliso Wetland Park","1999","Natural", "safrica_sima"));
			items.add(new HeritageEntryItem("Maloti Drakensberg Park","2000","Mixed", "safrica_maloti"));
			items.add(new HeritageEntryItem("Mapungubwe Cultural Landscape","2003","Cultural", "safrica_mapun"));
			
			items.add(new HeritageEntryItem("Cape Floral Region Protected Areas","2004","Natural", "safrica_floral"));
			items.add(new HeritageEntryItem("Vredefort Dome","2005","Natural", "safrica_vrede"));
			items.add(new HeritageEntryItem("Richtersveld Cultural and Botanical Landscape","2007","Cultural", "safrica_rich"));
			
			mHTitle.setText("South Africa");
		} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 0)
				&& (((HeritageDetailActivity) getActivity()).getRegionId() == 4)
				&& (((HeritageDetailActivity) getActivity()).getCountryId() == 0)) {
			items.add(new HeritageEntryItem("Royal Palaces of Abomey","1985","Cultural", "benin_abomey"));
			mHTitle.setText("Benin");
		} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 0)
				&& (((HeritageDetailActivity) getActivity()).getRegionId() == 4)
				&& (((HeritageDetailActivity) getActivity()).getCountryId() == 1)) {
			items.add(new HeritageEntryItem("Ruins of Loropeni","2009","Cultural", "burkina_ruins"));
			mHTitle.setText("Burkina Faso");
		} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 0)
				&& (((HeritageDetailActivity) getActivity()).getRegionId() == 4)
				&& (((HeritageDetailActivity) getActivity()).getCountryId() == 2)) {
			items.add(new HeritageEntryItem("Cidade Velha, Historic Center of Ribeira Grande","2009","Cultural", "cape_cidade"));

			mHTitle.setText("Cape Verde");
		} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 0)
				&& (((HeritageDetailActivity) getActivity()).getRegionId() == 4)
				&& (((HeritageDetailActivity) getActivity()).getCountryId() == 3)) {
			items.add(new HeritageEntryItem("Historic Town of Grand Bassam ","2012","Cultural", "cote_bassam"));

			mHTitle.setText("Cote D'lvoire");
		} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 0)
				&& (((HeritageDetailActivity) getActivity()).getRegionId() == 4)
				&& (((HeritageDetailActivity) getActivity()).getCountryId() == 4)) {
			items.add(new HeritageEntryItem("Kunta Kinteh Island and Related Sites","2003","Cultural", "gambia_kunta"));
			items.add(new HeritageEntryItem("Stone Circles of Senegambia","2006","Cultural", "gambia_stone"));
			mHTitle.setText("Gambia");
		} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 0)
				&& (((HeritageDetailActivity) getActivity()).getRegionId() == 4)
				&& (((HeritageDetailActivity) getActivity()).getCountryId() == 5)) {
			items.add(new HeritageEntryItem("Asante Traditional Buildings","1980","Cultural", "ghana_asante"));
			items.add(new HeritageEntryItem("Forts and Castles, Volta, Greater Accra, Central and Western Regions","1979","Cultural", "ghana_forts"));
			mHTitle.setText("Ghana");
		} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 0)
				&& (((HeritageDetailActivity) getActivity()).getRegionId() == 4)
				&& (((HeritageDetailActivity) getActivity()).getCountryId() == 6)) {
			items.add(new HeritageEntryItem("Old Towns of Djenne","1988","Cultural", "mali_djenne"));
			items.add(new HeritageEntryItem("Timbuktu","1988","Cultural", "mali_timbuktu"));
			items.add(new HeritageEntryItem("Tomb of Askia","2004","Cultural", "mali_askia"));
			items.add(new HeritageEntryItem("Cliff of Bandiagara","1989","Mixed", "mali_cliff"));
			
			mHTitle.setText("Mali");
		} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 0)
				&& (((HeritageDetailActivity) getActivity()).getRegionId() == 4)
				&& (((HeritageDetailActivity) getActivity()).getCountryId() == 7)) {
			items.add(new HeritageEntryItem("Banc d'Arguin National Park","1989","Natural", "mauritania_park"));
			items.add(new HeritageEntryItem("Ancient Ksour of Ouadane, Chinuetti, Tichitt and Oualate","1996","Cultural", "mauritania_ksour"));
			mHTitle.setText("Mauritania");
		} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 0)
				&& (((HeritageDetailActivity) getActivity()).getRegionId() == 4)
				&& (((HeritageDetailActivity) getActivity()).getCountryId() == 8)) {
			items.add(new HeritageEntryItem("Air and Tenere Natural Reserves","1991","Natural", "niger_tenere"));
			items.add(new HeritageEntryItem("Historic ceter of Agadez","2013","Cultural", "niger_agadez"));
			items.add(new HeritageEntryItem("W National Park of Niger","1996","Natural", "niger_w"));
			mHTitle.setText("Niger");
		} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 0)
				&& (((HeritageDetailActivity) getActivity()).getRegionId() == 4)
				&& (((HeritageDetailActivity) getActivity()).getCountryId() == 9)) {
			items.add(new HeritageEntryItem("Osun Osogbo Sacred Grove","2005","Cultural", "nigeria_osun"));
			items.add(new HeritageEntryItem("Sukur Cultural Landscape","1999","Cultural", "nigeria_sukur"));
			mHTitle.setText("Nigeria");
		} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 0)
				&& (((HeritageDetailActivity) getActivity()).getRegionId() == 4)
				&& (((HeritageDetailActivity) getActivity()).getCountryId() == 10)) {
			items.add(new HeritageEntryItem("Bassari Country: Bassari, Fula and Bedik Cultural Landscapes","2012","Cultural", "senegal_bassari"));
			items.add(new HeritageEntryItem("Djoudj National Bird Sanctuary","1981","Natural", "senegal_bird"));
			items.add(new HeritageEntryItem("Island of Goree","1978","Cultural", "senegal_goree"));
			items.add(new HeritageEntryItem("Island of Saint-Louis","2000","Cultural", "senegal_saint"));
			items.add(new HeritageEntryItem("Niokolo-Koba National Park","1981","Natural", "senegal_nio"));
			
			items.add(new HeritageEntryItem("Saloum Delta","2011","Cultural", "senegal_saloum"));
			items.add(new HeritageEntryItem("Stone Circles of Senegambia","2006","Cultural", "gambia_stone"));
									
			mHTitle.setText("Senegal");
		} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 0)
				&& (((HeritageDetailActivity) getActivity()).getRegionId() == 4)
				&& (((HeritageDetailActivity) getActivity()).getCountryId() == 11)) {			
			items.add(new HeritageEntryItem("Koutammakou, the Land of the Batammariba","2004","Cultural", "togo_kou"));
			
			mHTitle.setText("Togo");
		} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 1)
				&& (((HeritageDetailActivity) getActivity()).getRegionId() == 0)
				&& (((HeritageDetailActivity) getActivity()).getCountryId() == 0)) {
			items.add(new HeritageEntryItem("Belize Barrier Reef Reserve System","1996","Natural", "belize_reef"));

			mHTitle.setText("Belize");
		} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 1)
				&& (((HeritageDetailActivity) getActivity()).getRegionId() == 0)
				&& (((HeritageDetailActivity) getActivity()).getCountryId() == 1)) {
			items.add(new HeritageEntryItem("Talamanca Range-La Amistad Reserves / La Amistad National Park","1983","Natural", "panama_tala"));	
			items.add(new HeritageEntryItem("Cocos Island National Park","1997","Natural", "costa_cocos"));
			items.add(new HeritageEntryItem("Area de Conservacion Guanacaste","1999","Natural", "costa_guana"));			
			items.add(new HeritageEntryItem("Precolumbian chiefdom settlements with stone spheres of the Diquis","2014","Cultural", "costa_diquis"));
			
			mHTitle.setText("Costa Rica");
		} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 1)
				&& (((HeritageDetailActivity) getActivity()).getRegionId() == 0)
				&& (((HeritageDetailActivity) getActivity()).getCountryId() == 2)) {
			items.add(new HeritageEntryItem("Old Havana and its Fortifications","1982","Cultural", "cuba_havana"));
			items.add(new HeritageEntryItem("Trinidad and the Valley de los Ingenios","1988","Cultural", "cuba_trinidad"));
			items.add(new HeritageEntryItem("San Pedro de la Roca Castle, Santiago de Cuba","1997","Cultural", "cuba_santiago"));
			items.add(new HeritageEntryItem("Vinales Valley","1999","Cultural", "cuba_vinales"));
			items.add(new HeritageEntryItem("Desembarco del Granma National Park","1999","Natural", "cuba_desem"));
			
			items.add(new HeritageEntryItem("Archaeological Landscape of the First Coffee Plantations in the South-East of Cuba","2000","Cultural", "colombia_coffee"));
			items.add(new HeritageEntryItem("Alejandro de Humboldt National Park","2001","Natural", "cuba_alejandro"));
			items.add(new HeritageEntryItem("Urban Historic Centre of Cienfuegos","2005","Cultural", "cuba_cien"));
			items.add(new HeritageEntryItem("Historic Centre of Camaguey","2008","Cultural", "cuba_cama"));			
			
			mHTitle.setText("Cuba");				
		} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 1)
				&& (((HeritageDetailActivity) getActivity()).getRegionId() == 0)
				&& (((HeritageDetailActivity) getActivity()).getCountryId() == 3)) {
			items.add(new HeritageEntryItem("Joya de Ceren Archaeological Site","1993","Cultural", "salvador_joya"));
			
			mHTitle.setText("El Salvador");
		} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 1)
				&& (((HeritageDetailActivity) getActivity()).getRegionId() == 0)
				&& (((HeritageDetailActivity) getActivity()).getCountryId() == 4)) {
			items.add(new HeritageEntryItem("Antigua Guatemala","1979","Cultural", "guate_antigua"));
			items.add(new HeritageEntryItem("Archaeological Park and Ruins of Quirigua","1981","Cultural", "guate_quiri"));
			items.add(new HeritageEntryItem("Tikal National Park","1985","Mixed", "guate_tikal"));
			
			mHTitle.setText("Guatemala");
		} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 1)
				&& (((HeritageDetailActivity) getActivity()).getRegionId() == 0)
				&& (((HeritageDetailActivity) getActivity()).getCountryId() == 5)) {
			items.add(new HeritageEntryItem("Maya Site of Copan","1980","Cultural", "honduras_copan"));
			items.add(new HeritageEntryItem("Rio Platano Biosphere Reserve","1982","Natural", "honduras_rio"));
			mHTitle.setText("Honduras");
		} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 1)
				&& (((HeritageDetailActivity) getActivity()).getRegionId() == 0)
				&& (((HeritageDetailActivity) getActivity()).getCountryId() == 6)) {
			items.add(new HeritageEntryItem("Leon Cathedral","2011","Cultural", "nicaragua_leon"));
			items.add(new HeritageEntryItem("Ruins of Leon Viejo","2000","Cultural", "nicaragua_ruins"));
			mHTitle.setText("Nicaragua");
		} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 1)
				&& (((HeritageDetailActivity) getActivity()).getRegionId() == 0)
				&& (((HeritageDetailActivity) getActivity()).getCountryId() == 7)) {
			items.add(new HeritageEntryItem("Archaeological Site of Panama Viejo and Historic District of Panama City","1997","Cultural", "panama_viejo"));
			items.add(new HeritageEntryItem("Coiba National Park and its Special Zone of Marine Protection","2005","Natural", "panama_coiba"));
			items.add(new HeritageEntryItem("Darien National Park","1981","Natural", "panama_darien"));
			items.add(new HeritageEntryItem("Fortifications on the Caribbean Side of Panama: Portobelo-San Lorenzo","1980","Cultural", "panama_fort"));
			items.add(new HeritageEntryItem("Talamanca Range-La Amistad Reserves / La Amistad National Park","1983","Natural", "panama_tala"));
			
			mHTitle.setText("Panama");
		} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 1)
				&& (((HeritageDetailActivity) getActivity()).getRegionId() == 1)
				&& (((HeritageDetailActivity) getActivity()).getCountryId() == 0)) {
			items.add(new HeritageEntryItem("L'Anse aux Meadows National Historic Site","1978","Cultural", "canada_lanse"));			
			items.add(new HeritageEntryItem("Nahanni National Park","1978","Natural", "canada_nahanni"));
			items.add(new HeritageEntryItem("Dinosaur Provincial Park","1979","Natural", "canada_dinosaur"));
			items.add(new HeritageEntryItem("Kluane/Wrangell-St.Elias/Glacier Bay/Tatshenshini-Alsek","1979","Natural", "canada_kluane"));
			
			items.add(new HeritageEntryItem("SGang Gwaay","1981","Cultural", "canada_gwaay"));	
			items.add(new HeritageEntryItem("Head-Smashed-In Buffalo Jump","1981","Cultural", "canada_head"));
			items.add(new HeritageEntryItem("Wood Buffalo National Park","1983","Natural", "canada_buffalo"));
			items.add(new HeritageEntryItem("Canadian Rocky Mountain Parks","1984","Natural", "canada_rocky"));
			items.add(new HeritageEntryItem("Historic District of Old Quebec","1985","Cultural", "canada_quebec"));
			items.add(new HeritageEntryItem("Gros Morne National Park","1987","Natural", "canada_gros"));

			items.add(new HeritageEntryItem("Waterton Glacier International Peace Park","1995","Natural", "canada_peace"));
			items.add(new HeritageEntryItem("Old Town Lunenburg","1995","Cultural", "canada_lunen"));
			items.add(new HeritageEntryItem("Miguasha National Park","1999","Natural", "canada_miguasha"));							

			items.add(new HeritageEntryItem("Rideau Canal","2007","Cultural", "canada_rideau"));			
			items.add(new HeritageEntryItem("Joggins Fossil Cliffs","2008","Natural", "canada_fossil"));
			items.add(new HeritageEntryItem("Landscape of Grand-Pre","2012","Cultural", "canada_grand"));
			items.add(new HeritageEntryItem("Red Bay Basque Whaling Station","2013","Cultural", "canada_redbay"));	
			
			mHTitle.setText("Canada");
		} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 1)
				&& (((HeritageDetailActivity) getActivity()).getRegionId() == 1)
				&& (((HeritageDetailActivity) getActivity()).getCountryId() == 1)) {
			items.add(new HeritageEntryItem("Historic Center of Mexico City and Xochimilco","1987","Cultural", "mex_city"));
			items.add(new HeritageEntryItem("Historic Center of Oaxaca and Monte Alban","1987","Cultural", "mex_oaxaca"));
			items.add(new HeritageEntryItem("Historic Center of Puebla","1987","Cultural", "mex_puebla"));
			items.add(new HeritageEntryItem("Pre-Hispanic City and National Park of Palenque","1987","Cultural", "mex_palenque"));			
			items.add(new HeritageEntryItem("Pre-Hispanic City of Teotihuacan","1987","Cultural", "mex_teoti"));
			items.add(new HeritageEntryItem("Sian Ka'an","1987","Natural", "mex_sian"));
			items.add(new HeritageEntryItem("Historic Town of Guanajuato and Adjacent Mines","1988","Cultural", "mex_mines"));
			items.add(new HeritageEntryItem("Pre-Hispanic City of Chichen-Itza","1988","Cultural", "mex_chichen"));
			items.add(new HeritageEntryItem("Historic Centre of Morelia","1991","Cultural", "mex_morelia"));
			items.add(new HeritageEntryItem("El Tajin","1992","Cultural", "mex_tajin"));			
			items.add(new HeritageEntryItem("Historic Centre of Zacatecas","1993","Cultural", "mex_zacatecas"));
			items.add(new HeritageEntryItem("Rock Paintings of the Sierra de San Francisco","1993","Cultural", "mex_rock"));			
			items.add(new HeritageEntryItem("Whale Sanctuary of El Vizcaino","1993","Natural", "mex_whale"));
			items.add(new HeritageEntryItem("Earliest 16th century monasteries on the slopes of Popocatepetl","1994","Cultural", "mex_slope"));
			items.add(new HeritageEntryItem("Historic Monuments Zone of Queretaro","1996","Cultural", "mex_queretaro"));
			items.add(new HeritageEntryItem("Pre-Hispanic Town of Uxmal","1996","Cultural", "mex_uxmal"));
			items.add(new HeritageEntryItem("Hospicio Cabanas","1997","Cultural", "mex_hospicio"));
			
			items.add(new HeritageEntryItem("Archaeological Zone of Paquime, Casas Grandes","1997","Cultural", "mex_casas"));
			items.add(new HeritageEntryItem("Historic Monuments Zone of Tlacotalpan","1998","Cultural", "mex_tlaco"));
			items.add(new HeritageEntryItem("Archaeological Monuments Zone of Xochicalco","1999","Cultural", "mex_xochi"));			
			items.add(new HeritageEntryItem("Historic Fortified Town of Campeche","1999","Cultural", "mex_campeche"));
			items.add(new HeritageEntryItem("Ancient Maya City and Protected Tropical Forests of Calakmul, Campeche","2002","Mixed", "mex_maya"));			
			
			items.add(new HeritageEntryItem("Franciscan Missions in the Sierra Gorda","2003","Cultural", "mex_franciscan"));
			items.add(new HeritageEntryItem("Luis Barragan House and Studio","2003","Cultural", "mex_luis"));
			items.add(new HeritageEntryItem("Islands and Protected Areas of the Gulf of California","2005","Natural", "mex_california"));		
			items.add(new HeritageEntryItem("Agave Landscape and Ancient Industrial Facilities of Tequila","2006","Cultural", "mex_agave"));
			items.add(new HeritageEntryItem("Central University City Campus of the Universidad Nacional Autonoma de Mexico (UNAM)","2007","Cultural", "mex_unam"));
			
			items.add(new HeritageEntryItem("Protective town of San Miguel de Allende and Sanctuary of Jesus Nazareno de Atotonilco","2008","Cultural", "mex_sanmiguel"));
			items.add(new HeritageEntryItem("Monarch Butterfly Biosphere Reserve","2008","Natural", "mex_monarch"));
			items.add(new HeritageEntryItem("Camino Real de Tierra Adentro","2010","Cultural", "mex_camino"));
			items.add(new HeritageEntryItem("Prehistoric Caves of Yagul and Mitla in the Central Valley of Oaxaca","2010","Cultural", "mex_yagul"));
			items.add(new HeritageEntryItem("El Pinacate y Gran Desierto de Altar Biosphere Reserve","2013","Natural", "mex_pinacate"));									
			mHTitle.setText("Mexico");
		} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 1)
				&& (((HeritageDetailActivity) getActivity()).getRegionId() == 1)
				&& (((HeritageDetailActivity) getActivity()).getCountryId() == 2)) {
			items.add(new HeritageEntryItem("Mesa Verde National Park","1978","Natural", "usa_mesa"));
			items.add(new HeritageEntryItem("Yellowstone National Park","1978","Natural", "usa_yellowstone"));
			items.add(new HeritageEntryItem("Everglades National Park","1979","Natural", "usa_everglades"));
			items.add(new HeritageEntryItem("Kluane / Wrangell and St. Elias / Glacier Bay / Tatshenshini-Alsek","1979","Natural", "usa_kluane"));
			items.add(new HeritageEntryItem("Grand Canyon National Park","1979","Natural", "usa_canyon"));
			
			items.add(new HeritageEntryItem("Independence Hall ","1979","Cultural", "usa_independence"));			
			items.add(new HeritageEntryItem("Mammoth Cave National Park","1981","Natural", "usa_mammoth"));
			items.add(new HeritageEntryItem("Olympic National Park","1981","Natural", "usa_olympic"));
			items.add(new HeritageEntryItem("Carlsbad Caverns National Park","1981","Natural", "usa_carlsbad"));
			items.add(new HeritageEntryItem("Cahokia Mounds State Historic Site","1982","Cultural", "usa_cahokia"));
			
			items.add(new HeritageEntryItem("Great Smoky Mountains National Park","1983","Natural", "usa_smoky"));			
			items.add(new HeritageEntryItem("La Fortaleza and San Juan National Historic Site","1983","Cultural", "usa_la"));
			items.add(new HeritageEntryItem("Statue of Liberty","1984","Cultural", "usa_liberty"));
			items.add(new HeritageEntryItem("Yosemite National Park","1984","Natural", "usa_yosemite"));
			items.add(new HeritageEntryItem("Chaco Culture National Historical Park","1987","Cultural", "usa_chaco"));
			
			items.add(new HeritageEntryItem("Hawaii Volcanoes National Park ","1987","Natural", "usa_hawaii"));
			items.add(new HeritageEntryItem("Monticello and the University of Virginia","1987","Cultural", "usa_monticello"));
			items.add(new HeritageEntryItem("Taos Pueblo","1992","Cultural", "usa_taos"));			
			items.add(new HeritageEntryItem("Redwood National and State Parks","1980","Natural", "usa_red"));
			items.add(new HeritageEntryItem("Waterton-Glacier International Peace Park","1995","Natural", "usa_waterton"));
			
			items.add(new HeritageEntryItem("Papahanaumokuakea","2010","Mixed", "usa_papa"));
			items.add(new HeritageEntryItem("Monumental Earthworks of Poverty Point","2014","Cultural", "usa_poverty"));

			mHTitle.setText("USA");
		} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 1)
				&& (((HeritageDetailActivity) getActivity()).getRegionId() == 2)
				&& (((HeritageDetailActivity) getActivity()).getCountryId() == 0)) {
			items.add(new HeritageEntryItem("Los Glaciares National Park","1981","Natural", "arg_los"));
			items.add(new HeritageEntryItem("Jesuit Missions of the Guaranis: San Ignacio Mini, Santa Ana, Nuestra Señora de Loreto and Santa Maria Mayors","1983","Cultural", "arg_jesuit"));
			items.add(new HeritageEntryItem("Iguazu National Park","1984","Natural", "arg_iguazu"));			
			items.add(new HeritageEntryItem("Cueva de las Manos, Rio Pinturas","1999","Cultural", "arg_cueva"));
			items.add(new HeritageEntryItem("Peninsula Valdes","1999","Natural", "arg_valdes"));		
			
			items.add(new HeritageEntryItem("Ischigualasto / Talampaya Natural Parks","2000","Natural", "arg_ischi"));
			items.add(new HeritageEntryItem("Jesuit Block and Estancias of Cordoba","2000","Cultural", "arg_cordoba"));			
			items.add(new HeritageEntryItem("Quebrada de Humahuaca","2003","Cultural", "arg_quebrada"));
			items.add(new HeritageEntryItem("Qhapaq Nan, Andean Road System","2014","Cultural", "arg_qhapaq"));
			mHTitle.setText("Argentina");
		} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 1)
				&& (((HeritageDetailActivity) getActivity()).getRegionId() == 2)
				&& (((HeritageDetailActivity) getActivity()).getCountryId() == 1)) {
			items.add(new HeritageEntryItem("City of Potosi","1987","Cultural", "bolivia_potosi"));
			items.add(new HeritageEntryItem("Fuerte de Samaipata","1998","Cultural", "bolivia_fuerte"));
			items.add(new HeritageEntryItem("Historic City of Sucre","1997","Cultural", "bolivia_sucre"));
			items.add(new HeritageEntryItem("Jesuit Missions of Chiquitos","1990","Cultural", "bolivia_jesuit"));
			items.add(new HeritageEntryItem("Noel Kempff Mercado National Park","2000","Natural", "bolivia_noel"));
			
			items.add(new HeritageEntryItem("Tiwanaku: Spiritual and Political Centre of the Tiwanaku Culture","2000","Cultural", "bolivia_tiwanaku"));
			items.add(new HeritageEntryItem("Qhapaq Nan, Andean Road System","2014","Cultural", "arg_qhapaq"));
			mHTitle.setText("Bolivia");
		} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 1)
				&& (((HeritageDetailActivity) getActivity()).getRegionId() == 2)
				&& (((HeritageDetailActivity) getActivity()).getCountryId() == 2)) {
			items.add(new HeritageEntryItem("Atlantic Forest South-East Reserves","1999","Natural", "bra_atlantic"));
			items.add(new HeritageEntryItem("Brasilia","1987","Cultural", "bra_brasilia"));
			items.add(new HeritageEntryItem("Brazilian Atlantic Islands: Fernando de Noronha and Atol das Rocas Reserves","2001","Natural", "bra_islands"));
			items.add(new HeritageEntryItem("Central Amazon Conservation Complex","2000","Natural", "bra_amazon"));
			items.add(new HeritageEntryItem("Cerrado Protected Areas: Chapada dos Veadeiros and Emas National Parks","2001","Natural", "bra_cerrado"));

			items.add(new HeritageEntryItem("Discovery Coast Atlantic Forest Reserves","1999","Natural", "bra_discovery"));
			items.add(new HeritageEntryItem("Historic Centre of Salvador de Bahia","1985","Cultural", "bra_salvador"));
			items.add(new HeritageEntryItem("Historic Centre of Sao Luis","1997","Cultural", "bra_saoluis"));
			items.add(new HeritageEntryItem("Historic Centre of the Town of Diamantina","1999","Cultural", "bra_diaman"));
			items.add(new HeritageEntryItem("Historic Centre of the Town of Goias","2001","Cultural", "bra_goias"));

			items.add(new HeritageEntryItem("Historic Centre of the Town of Olinda","1982","Cultural", "bra_olinda"));
			items.add(new HeritageEntryItem("Historic Town of Ouro Preto","1980","Cultural", "bra_ouro"));
			items.add(new HeritageEntryItem("Iguazu National Park","1986","Natural", "bra_iguazu"));
			items.add(new HeritageEntryItem("Ruins of Sao Miguel das Missoes","1983","Cultural", "bra_saomiguel"));
			items.add(new HeritageEntryItem("Pantanal Conservation Area","2000","Natural", "bra_pantanal"));

			items.add(new HeritageEntryItem("Rio de Janeiro: Carioca Landscapes Between the Mountain and the Sea","2012","Cultural", "bra_rio"));
			items.add(new HeritageEntryItem("Sanctuary of Bom Jesus do Congonhas","1985","Cultural", "bra_bom"));
			items.add(new HeritageEntryItem("Sao Francisco Square in the Town of Sao Cristovao","2010","Cultural", "bra_sao"));
			items.add(new HeritageEntryItem("Serra da Capivara National Park","1991","Natural", "bra_serra"));		
			
			mHTitle.setText("Brazil");
		} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 1)
				&& (((HeritageDetailActivity) getActivity()).getRegionId() == 2)
				&& (((HeritageDetailActivity) getActivity()).getCountryId() == 3)) {
			items.add(new HeritageEntryItem("Churches of Chiloe","2010","Cultural", "chile_chiloe"));
			items.add(new HeritageEntryItem("Historic Quarter of the Seaport City of Valparaiso","2003","Cultural", "chile_valpa"));			
			items.add(new HeritageEntryItem("Humberstone and Santa Laura Saltpeter Works","2005","Natural", "chile_humberstone"));
			items.add(new HeritageEntryItem("Qhapaq Nan, Andean Road System","2014","Cultural", "arg_qhapaq"));
			items.add(new HeritageEntryItem("Rapa Nui National Park","1995","Cultural", "chile_rapa"));
			items.add(new HeritageEntryItem("Sewell Mining Town","2006","Cultural", "chile_sewell"));			
			mHTitle.setText("Chile");
		} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 1)
				&& (((HeritageDetailActivity) getActivity()).getRegionId() == 2)
				&& (((HeritageDetailActivity) getActivity()).getCountryId() == 4)) {
			items.add(new HeritageEntryItem("Port, Fortresses and Group of Monuments, Cartagena","1984","Cultural","colombia_cartagena"));
			items.add(new HeritageEntryItem("Los Katios National Park","1994","Cultural", "colombia_los"));
			items.add(new HeritageEntryItem("Historic Centre of Santa Cruz de Mompox","1995","Cultural", "colombia_santa"));
			items.add(new HeritageEntryItem("National Archeological Park of Tierradentro","1995","Cultural", "colombia_tierra"));			
			items.add(new HeritageEntryItem("San Agustin Archaeological Park","2005","Cultural", "colombia_agustin"));
			items.add(new HeritageEntryItem("Malpelo Fauna and Flora Sanctuary","2006","Natural", "colombia_malpelo"));			
			items.add(new HeritageEntryItem("Coffee Cultural Landscape of Colombia","2011","Cultural", "colombia_coffee"));		
			items.add(new HeritageEntryItem("Qhapaq Nan, Andean Road System","2014","Cultural", "arg_qhapaq"));			
			
			mHTitle.setText("Colombia");
		} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 1)
				&& (((HeritageDetailActivity) getActivity()).getRegionId() == 2)
				&& (((HeritageDetailActivity) getActivity()).getCountryId() == 5)) {
			items.add(new HeritageEntryItem("Galapagos Islands","1978","Natural", "ecuador_galapagos"));
			items.add(new HeritageEntryItem("City of Quito","1978","Cultural", "ecuador_quito"));
			items.add(new HeritageEntryItem("Historic Centre of Santa Ana de los Rios de Cuenca","1999","Cultural", "ecuador_santa"));
			items.add(new HeritageEntryItem("Sangay National Park","1983","Natural", "ecuador_sangay"));
			items.add(new HeritageEntryItem("Qhapaq Nan, Andean Road System","2014","Cultural", "arg_qhapaq"));			
			mHTitle.setText("Ecuador");
		} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 1)
				&& (((HeritageDetailActivity) getActivity()).getRegionId() == 2)
				&& (((HeritageDetailActivity) getActivity()).getCountryId() == 6)) {
			items.add(new HeritageEntryItem("Jesuit Missions of La Santisima Trinidad de Parana and Jesus de Tavarangue","1993","Cultural", "paraguay_01"));
			mHTitle.setText("Paraguay");
		}
		else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 1)
				&& (((HeritageDetailActivity) getActivity()).getRegionId() == 2)
				&& (((HeritageDetailActivity) getActivity()).getCountryId() == 7)) {
			items.add(new HeritageEntryItem("City of Cuzco","1983","Cultural", "peru_cuzco"));
			items.add(new HeritageEntryItem("Historic Sanctuary of Machu Picchu","1983","Mixed", "peru_machupicchu"));
			items.add(new HeritageEntryItem("Chavin (Archaeological Site)","1985","Cultural", "peru_chavin"));
			items.add(new HeritageEntryItem("Huascaran National Park","1985","Natural", "peru_huascaran"));	
			items.add(new HeritageEntryItem("Chan Chan Archaeological Zone","1986","Cultural", "peru_chan"));
			items.add(new HeritageEntryItem("Manu National Park","1987","Natural", "peru_manu"));
			items.add(new HeritageEntryItem("Historic Center of Lima","1988","Cultural", "peru_lima"));
			items.add(new HeritageEntryItem("Rio Abiseo National Park","1990","Mixed", "peru_rio"));
			items.add(new HeritageEntryItem("Lines and Geoglyphs of Nasca and Pampas","1994","Cultural", "peru_nasca"));
			items.add(new HeritageEntryItem("Historic Center of the City of Arequipa","2000","Cultural", "peru_are"));
			items.add(new HeritageEntryItem("Sacred City of Caral-Supe","2009","Cultural", "peru_caral"));
			items.add(new HeritageEntryItem("Qhapaq Nan, Andean Road System","2014","Cultural", "arg_qhapaq"));
			mHTitle.setText("Peru");
		} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 1)
				&& (((HeritageDetailActivity) getActivity()).getRegionId() == 2)
				&& (((HeritageDetailActivity) getActivity()).getCountryId() == 8)) {
			items.add(new HeritageEntryItem("Central Suriname Nature Reserve","2000","Natural", "suriname_nature"));
			items.add(new HeritageEntryItem("Historic Inner City of Paramaribo","2002","Cultural", "suriname_para"));
			mHTitle.setText("Suriname");
		} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 1)
				&& (((HeritageDetailActivity) getActivity()).getRegionId() == 2)
				&& (((HeritageDetailActivity) getActivity()).getCountryId() == 9)) {
			items.add(new HeritageEntryItem("Historic Quarter of the City of Colonia del Sacramento","1995","Cultural", "uruguay_sacramento"));
			mHTitle.setText("Uruguay");
		} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 1)
				&& (((HeritageDetailActivity) getActivity()).getRegionId() == 2)
				&& (((HeritageDetailActivity) getActivity()).getCountryId() == 10)) {
			items.add(new HeritageEntryItem("Coro and its Port","1993","Cultural", "venezuela_coro"));
			items.add(new HeritageEntryItem("Canaima National Park","1994","Natural", "venezuela_park"));
			items.add(new HeritageEntryItem("Ciudad Universitaria de Caracas","2000","Cultural", "venezuela_ciudad"));			
			mHTitle.setText("Venezuela");
		} 
		
		
		else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 2)
				&& (((HeritageDetailActivity) getActivity()).getRegionId() == 0)
				&& (((HeritageDetailActivity) getActivity()).getCountryId() == 0)){
			items.add(new HeritageEntryItem("Mausoleum of Khoja Ahmed Yasawi","2003","Cultural",  "kazakhstan_01"));
			items.add(new HeritageEntryItem("Petroglyphs within the Archaeological Landscape of Tamgaly","2004","Cultural", "kazakhstan_02"));
			items.add(new HeritageEntryItem("Saryarka - Steppe and Lakes of Northern Kazakhstan","2008","Natural",  "kazakhstan_03"));
			items.add(new HeritageEntryItem("Silk Roads: the Routes Network of Chang'an-Tianshan Corridor","2014","Cultural",  "china_silkroad"));
			
			mHTitle.setText("Kazakhstan");
		} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 2)
				&& (((HeritageDetailActivity) getActivity()).getRegionId() == 0)
				&& (((HeritageDetailActivity) getActivity()).getCountryId() == 1)){
			items.add(new HeritageEntryItem("Sulaiman-Too Sacred Mountain","2009","Cultural", "kyrgyzstan_01"));
			mHTitle.setText("Kyrgyzstan");
		} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 2)
				&& (((HeritageDetailActivity) getActivity()).getRegionId() == 0)
				&& (((HeritageDetailActivity) getActivity()).getCountryId() == 2)){
			items.add(new HeritageEntryItem("Proto-urban site of Sarazm","2010","Cultural", "tajikistan_01"));	
			items.add(new HeritageEntryItem("Tajik National Park (Mountains of the Pamirs)","2013","Natural", "tajikistan_02"));
			mHTitle.setText("Tajikistan");
		} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 2)
				&& (((HeritageDetailActivity) getActivity()).getRegionId() == 0)
				&& (((HeritageDetailActivity) getActivity()).getCountryId() == 3)){
			items.add(new HeritageEntryItem("State Historical and Cultural Park \"Ancient Merv\"","1999","Cultural", "turkmenistan_01"));
			items.add(new HeritageEntryItem("Kunya-Urgench","2005","Cultural", "turkmenistan_02"));
			items.add(new HeritageEntryItem("Parthian Fortresses of Nisa","2007","Cultural", "turkmenistan_03"));	
			mHTitle.setText("Turkmenistan");
		} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 2)
				&& (((HeritageDetailActivity) getActivity()).getRegionId() == 0)
				&& (((HeritageDetailActivity) getActivity()).getCountryId() == 4)){
			items.add(new HeritageEntryItem("Itchan Kala","1990","Cultural", "uzbekistan_01"));
			items.add(new HeritageEntryItem("Historical Center of Bukhara","1993","Cultural", "uzbekistan_02"));
			items.add(new HeritageEntryItem("Historical Center of Shakhrisyabz","2000","Cultural", "uzbekistan_03"));	
			items.add(new HeritageEntryItem("Samarkand-Crossroad of Cultures","2001","Cultural", "uzbekistan_04"));
			mHTitle.setText("Uzbekistan");
		} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 2)
				&& (((HeritageDetailActivity) getActivity()).getRegionId() == 1)
				&& (((HeritageDetailActivity) getActivity()).getCountryId() == 0)){
			items.add(new HeritageEntryItem("Mount Taishan","1987","Mixed",  "china_taishan"));
			items.add(new HeritageEntryItem("The Great Wall","1987","Cultural", "china_greatwall"));
			items.add(new HeritageEntryItem("Imperial Palaces of the Ming and Qing Dynasty in Beijing and Shenyang","1987","Cultural",  "china_imperialpalaces"));
			items.add(new HeritageEntryItem("Mausoleum of the First Qin Emperor","1987","Cultural",  "china_mausoleum"));
			items.add(new HeritageEntryItem("Mogao Caves","1987","Cultural",  "china_mogao"));
			items.add(new HeritageEntryItem("Peking Man Site at Zhoukoudian","1987","Cultural",  "china_pekingman"));
			items.add(new HeritageEntryItem("Mount Huangshan","1990","Mixed",  "china_huangshan"));
			items.add(new HeritageEntryItem("Jiuzhaigou Valley Scenic and Historic Interest Area","1992","Natural",  "china_jiuzhaigou"));
			items.add(new HeritageEntryItem("Huanglong Scenic and Historic Interest Area","1992","Natural",  "china_huanglong"));
			items.add(new HeritageEntryItem("Wulingyuan Valley Scenic and Historic Interest Area","1992","Natural",  "china_wulingyuan"));
			items.add(new HeritageEntryItem("Ancient Building Complex in the Wudang Mountains","1994","Cultural",  "china_wudang"));
			items.add(new HeritageEntryItem("Mountain Resort and its Outlying Temples in Chengde","1994","Cultural",  "china_chengde"));
			items.add(new HeritageEntryItem("Temple and Cemetery of Confucius, and the Kong Family Mansion in Qufu","1994","Cultural",  "china_kong"));
			items.add(new HeritageEntryItem("Historic Ensemble of the Potala Palace, Lhasa","1994","Cultural",  "china_potala"));
			items.add(new HeritageEntryItem("Mount Emei Scenic Area, including Leshan Giant Buddha Scenic Area","1996","Mixed",  "china_emei"));
			items.add(new HeritageEntryItem("Lushan National Park","1996","Natural",  "china_lushan"));
			items.add(new HeritageEntryItem("Ancient City of Ping Yao","1997","Cultural",  "china_pingyao"));
			items.add(new HeritageEntryItem("Classical Gardens of Suzhou","1997","Cultural",  "china_suzhou"));
			items.add(new HeritageEntryItem("Old Town of Lijiang","1997","Cultural",  "china_lijiang"));
			items.add(new HeritageEntryItem("Summer Palace","1998","Cultural",  "china_summerpalace"));
			items.add(new HeritageEntryItem("Temple of Heaven: an Imperial Sacrificial Altar in Beijing","1998","Cultural",  "china_templeheaven"));
			items.add(new HeritageEntryItem("Dazu Rock Carvings","1999","Cultural",  "china_dazu"));
			items.add(new HeritageEntryItem("Mount Wuyi","1999","Mixed",  "china_wuyi"));
			items.add(new HeritageEntryItem("Ancient Villages in Southern Anhui - Xidi and Hongcun","2000","Cultural",  "china_xidi"));
			items.add(new HeritageEntryItem("Imperial Tombs of the Ming and Qing Dynasties, including the Ming Dynasty Tombs and the Ming Xiaoling Mausoleum","2000","Cultural",  "china_tomb"));
			items.add(new HeritageEntryItem("Longmen Grottoes","2000","Cultural",  "china_longmen"));
			items.add(new HeritageEntryItem("Mount Qingcheng and the Dujiangyan Irrigation System","2000","Cultural",  "china_qingcheng"));
			items.add(new HeritageEntryItem("Yungang Grottoes","2001","Cultural",  "china_yungang"));
			items.add(new HeritageEntryItem("Three Parallel Rivers of Yunnan Protected Areas","2003","Natural",  "china_threeparallel"));
			items.add(new HeritageEntryItem("Capital Cities and Tombs of the Ancient Koguryo Kingdom","2004","Cultural",  "china_koguryo"));
			items.add(new HeritageEntryItem("Historic Centre of Macau","2005","Cultural",  "china_macau"));
			items.add(new HeritageEntryItem("Yin Xu","2006","Cultural",  "china_yinxu"));
			items.add(new HeritageEntryItem("Sichuan Giant Panda Sanctuaries","2006","Natural",  "china_panda"));
			items.add(new HeritageEntryItem("Kaiping Diaolou and Villages","2007","Cultural",  "china_kaiping"));
			items.add(new HeritageEntryItem("South China Karst","2007","Natural",  "china_karst"));
			items.add(new HeritageEntryItem("Fujian Tulou","2008","Cultural",  "china_tulou"));
			items.add(new HeritageEntryItem("Mount Sanqingshan National Park","2008","Natural",  "china_sanqingshan"));
			items.add(new HeritageEntryItem("Mount Wutai","2009","Cultural",  "china_wutai"));
			items.add(new HeritageEntryItem("Historic Monuments of Dengfeng in \"The Centre of Heaven and Earth\"","2010","Cultural",  "china_dengfeng"));
			items.add(new HeritageEntryItem("China Danxia","2010","Natural",  "china_danxia"));
			items.add(new HeritageEntryItem("West Lake Cultural Landscape of Hangzhou","2011","Cultural",  "china_westlake"));
			items.add(new HeritageEntryItem("Chengjiang Fossil Site","2012","Natural",  "china_fossil"));
			items.add(new HeritageEntryItem("Site of Xanadu","2012","Cultural",  "china_xanadu"));
			items.add(new HeritageEntryItem("Xinjiang Tianshan","2013","Natural",  "china_tianshan"));
			items.add(new HeritageEntryItem("Cultural Landscape of Honghe Hani Rice Terraces","2013","Cultural",  "china_honghe"));
			items.add(new HeritageEntryItem("Silk Roads: the Routes Network of Chang'an-Tianshan Corridor","2014","Cultural",  "china_silkroad"));
			items.add(new HeritageEntryItem("The Grand Canal","2014","Cultural",  "china_canal"));
			mHTitle.setText("China");
			
		} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 2)
				&& (((HeritageDetailActivity) getActivity()).getRegionId() == 1)
				&& (((HeritageDetailActivity) getActivity()).getCountryId() == 1)){
			items.add(new HeritageEntryItem("Buddhist Monuments in the Horyu-ji Area","1993","Cultural",  "japan_horyu"));
			items.add(new HeritageEntryItem("Himeji-jo","1993","Cultural", "japan_himeji"));
			items.add(new HeritageEntryItem("Yakushima","1993","Natural",  "japan_yakushima"));
			items.add(new HeritageEntryItem("Shirakami-Sanchi","1993","Natural",  "japan_shirakami"));
			items.add(new HeritageEntryItem("Historic Monuments of Ancient Kyoto","1994","Cultural",  "japan_kyoto"));
			items.add(new HeritageEntryItem("Historic Villages of Shirakawa-go and Gokayama","1995","Cultural",  "japan_shirakawa"));
			items.add(new HeritageEntryItem("Hiroshima Peace Memorial (Genbaku Dome)","1996","Cultural",  "japan_hiroshima"));
			items.add(new HeritageEntryItem("Itsukushima Shinto Shrine","1996","Cultural",  "japan_shinto"));
			items.add(new HeritageEntryItem("Historic Monuments of Ancient Nara","1998","Cultural",  "japan_nara"));
			items.add(new HeritageEntryItem("Shrines and Temples of Nikko","1999","Cultural",  "japan_nikko"));
			items.add(new HeritageEntryItem("Gusuku Sites and Related Properties of the Kingdom of Ryukyu","2000","Cultural",  "japan_ryukyu"));
			items.add(new HeritageEntryItem("Sacred Sites and Pilgrimage Routes in the Kii Mountain Range","2004","Cultural",  "japan_kii"));
			items.add(new HeritageEntryItem("Shiretoko National Park","2005","Natural",  "japan_shiretoko"));
			items.add(new HeritageEntryItem("Iwami Ginzan Silver Mine and its Cultural Landscape","2010","Cultural",  "japan_iwami"));
			items.add(new HeritageEntryItem("Hiraizumi – Temples, Gardens and Archaeological Sites Representing the Buddhist Pure Land","2011","Cultural",  "japan_hiraizumi"));
			items.add(new HeritageEntryItem("Ogasawara Islands","2011","Natural",  "japan_ogasawara"));
			items.add(new HeritageEntryItem("Fujisan, sacred place and source of artistic inspiration","2013","Cultural",  "japan_fujisan"));
			items.add(new HeritageEntryItem("Tomioka Silk Mill and Related Sites","2014","Cultural",  "japan_tomioka"));	
			mHTitle.setText("Japan");
		} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 2)
				&& (((HeritageDetailActivity) getActivity()).getRegionId() == 1)
				&& (((HeritageDetailActivity) getActivity()).getCountryId() == 2)){
			items.add(new HeritageEntryItem("Seokguram Grotto and Bulguksa Temple","1995","Cultural",  "skorea_seokguram"));
			items.add(new HeritageEntryItem("Haeinsa Temple Janggyeong Panjeon, the Depositories for the Tripitaka Koreana Woodblocks","1995","Cultural", "skorea_haeinsa"));
			items.add(new HeritageEntryItem("Jongmyo Shrine","1995","Cultural",  "skorea_jongmyo"));
			items.add(new HeritageEntryItem("Changdeokgung Palace Complex","1997","Cultural",  "skorea_changdeokgung"));
			items.add(new HeritageEntryItem("Hwaseong Fortress","1997","Cultural",  "skorea_hwaseong"));
			items.add(new HeritageEntryItem("Gyeongju Historic Areas","2000","Cultural",  "skorea_gyeongju"));
			items.add(new HeritageEntryItem("Gochang, Hwasun and Ganghwa Dolmen Sites","2000","Cultural",  "skorea_gochang"));
			items.add(new HeritageEntryItem("Jeju Volcanic Island and Lava Tubes","2007","Natural",  "skorea_jeju"));
			items.add(new HeritageEntryItem("Royal Tombs of the Joseon Dynasty","2009","Cultural",  "skorea_tomb"));
			items.add(new HeritageEntryItem("Historic Villages of Korea: Hahoe and Yangdong","2010","Cultural",  "skorea_hahoe"));			
			items.add(new HeritageEntryItem("Namhansanseong","2014","Cultural",  "skorea_namhan"));
			mHTitle.setText("South Korea");
		} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 2)
				&& (((HeritageDetailActivity) getActivity()).getRegionId() == 1)
				&& (((HeritageDetailActivity) getActivity()).getCountryId() == 3)){
			items.add(new HeritageEntryItem("Uvs Nuur Basin","2003","Natural",  "mongolia_basin"));
			items.add(new HeritageEntryItem("Orkhon Valley Cultural Landscape","2004","Cultural", "mongolia_valley"));
			items.add(new HeritageEntryItem("Petroglyphic Complexes of the Mongolian Altai","2011","Cultural", "mongolia_altai"));
			mHTitle.setText("Mongolia");
			
		} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 2)
				&& (((HeritageDetailActivity) getActivity()).getRegionId() == 1)
				&& (((HeritageDetailActivity) getActivity()).getCountryId() == 4)){
			items.add(new HeritageEntryItem("Complex of Koguryo Tombs","2004","Cultural",  "nkorea_cave"));
			items.add(new HeritageEntryItem("Historic Monuments and Sites in Kaesong","2013","Cultural", "nkorea_kaesong"));
			mHTitle.setText("North Korea");
			
		} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 2)
				&& (((HeritageDetailActivity) getActivity()).getRegionId() == 2)
				&& (((HeritageDetailActivity) getActivity()).getCountryId() == 0)){
			items.add(new HeritageEntryItem("Historic Mosque City of Bagerhat","1985","Cultural",  "bangla_mosque"));
			items.add(new HeritageEntryItem("Ruins of the Buddhist Vihara at Paharpur","1985","Cultural", "bangla_ruins"));
			items.add(new HeritageEntryItem("The Sundarbans","1997","Cultural", "bangla_sundarbans"));
			
			mHTitle.setText("Bangladesh");
		} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 2)
		 		&& (((HeritageDetailActivity) getActivity()).getRegionId() == 2)
				&& (((HeritageDetailActivity) getActivity()).getCountryId() == 1)){
			items.add(new HeritageEntryItem("Agra Fort","1983","Cultural",  "india_agra"));
			items.add(new HeritageEntryItem("Ajanta Caves","1983","Cultural", "india_ajanta"));
			items.add(new HeritageEntryItem("Buddhist Monuments at Sanchi ","1983","Cultural", "india_sanchi"));
			items.add(new HeritageEntryItem("Ellora Caves ","1983","Cultural", "india_ellora"));
			items.add(new HeritageEntryItem("Taj Mahal","1983","Cultural", "india_taj"));
			items.add(new HeritageEntryItem("Sun Temple, Konarak","1984","Cultural", "india_konarak"));	
			items.add(new HeritageEntryItem("Group of Monuments at Mahabalipuram","1984","Cultural", "india_mahabali"));
			items.add(new HeritageEntryItem("Kaziranza National Park","1985","Natural", "india_kaziranza"));
			items.add(new HeritageEntryItem("Keoladeo National Park","1985","Natural", "india_keoladeo"));
			items.add(new HeritageEntryItem("Manas Wildlife Sanctuary","1985","Natural", "india_manas"));
			items.add(new HeritageEntryItem("Churches and Convents of Goa ","1986","Cultural", "india_goa"));
			items.add(new HeritageEntryItem("Elephanta Caves ","1987","Cultural", "india_elephanta"));
			items.add(new HeritageEntryItem("Sundarbans National Park","1987","Cultural", "india_sundarbans"));			
			items.add(new HeritageEntryItem("Fatehpur Sikri ","1986","Cultural", "india_sikri"));
			items.add(new HeritageEntryItem("Group Monuments of Hampi","1986","Cultural", "india_hampi"));
			items.add(new HeritageEntryItem("Great Living Chola Temples","1987","Cultural", "india_chola"));
			items.add(new HeritageEntryItem("Group of Monuments at Pattadakal","1987","Cultural", "india_pattadakal"));
			items.add(new HeritageEntryItem("Khajuraho Group of Monuments","1986","Cultural", "india_khajuraho"));
			items.add(new HeritageEntryItem("Nanda Devi and Valley of Flowers National Parks","1988","Natural", "india_nanda"));
			
			items.add(new HeritageEntryItem("Humayun's Tomb, Dehli","1993","Cultural", "india_humayun"));
			items.add(new HeritageEntryItem("Qutb Minar and its Monuments, Delhi","1993","Cultural", "india_qutb"));
			items.add(new HeritageEntryItem("Mountain Railways of India","1999","Cultural", "india_railways"));

			items.add(new HeritageEntryItem("Mahabodhi Temple Complex at Bodh Gaya","2002","Cultural", "india_mahabodhi"));
			items.add(new HeritageEntryItem("Rock Shelters of Bhimbetka","2003","Cultural", "india_rock"));
			items.add(new HeritageEntryItem("Champaner Pavagadh Archaeological Park ","2004","Cultural", "india_pava"));
			items.add(new HeritageEntryItem("Chhatrapati Shivaji Terminus ","2004","Cultural", "india_shivaji"));
			items.add(new HeritageEntryItem("Red Fort Complex, Delhi","2007","Cultural", "india_red"));
			
			items.add(new HeritageEntryItem("The Jantar Mantar, Jaipur","2010","Cultural", "india_jaipur"));
			items.add(new HeritageEntryItem("Western Ghats","2012","Natural", "india_ghat"));
			items.add(new HeritageEntryItem("Hill Forts of Rajasthan","2013","Cultural", "india_rajasthan"));
			items.add(new HeritageEntryItem("Great Himalayan National Park Conservation Area","2014","Natural", "india_hima"));
			
			mHTitle.setText("India");
		} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 2)
				&& (((HeritageDetailActivity) getActivity()).getRegionId() == 2)
				&& (((HeritageDetailActivity) getActivity()).getCountryId() == 2)){
			items.add(new HeritageEntryItem("Kathmandu Valley","1979","Cultural", "nepal_kathmandu"));
			items.add(new HeritageEntryItem("Sagarmatha National Park","1979","Natural", "nepal_sagarmatha"));
			items.add(new HeritageEntryItem("Chitwan National Park ","1984","Natural",  "nepal_chitwan"));
			items.add(new HeritageEntryItem("Lumbini, the Birthplace of the Lord Buddha","1997","Cultural", "nepal_lumbini"));
			
			mHTitle.setText("Nepal");
		} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 2)
				&& (((HeritageDetailActivity) getActivity()).getRegionId() == 2)
				&& (((HeritageDetailActivity) getActivity()).getCountryId() == 3)){
			items.add(new HeritageEntryItem("Archeaological Ruins at Moenjodaro","1980","Cultural",  "pakis_ruins"));
			items.add(new HeritageEntryItem("Buddhist Ruins of Takht-i-Bahi and Neighboring City Remains at Sahr-i-Bahlol  ","1980","Cultural", "pakis_buddhist"));			
			items.add(new HeritageEntryItem("Taxila","1980","Cultural",  "pakis_taxila"));
			items.add(new HeritageEntryItem("Fort and Shalamar Gardens in Lahore","1981","Cultural", "pakis_lahore"));
			items.add(new HeritageEntryItem("Historical Monuments at Makli, Thatta","1981","Cultural", "pakis_thatta"));
			items.add(new HeritageEntryItem("Rohtas Fort","1997","Cultural",  "pakis_rohtas"));
			mHTitle.setText("Pakistan");
		} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 2)
				&& (((HeritageDetailActivity) getActivity()).getRegionId() == 2)
				&& (((HeritageDetailActivity) getActivity()).getCountryId() == 4)){
			items.add(new HeritageEntryItem("Ancient City of Polonnaruwa","1982","Cultural",  "sri_polo"));
			items.add(new HeritageEntryItem("Ancient City of Sigiriya ","1982","Cultural", "sri_sigi"));			
			items.add(new HeritageEntryItem("Golden Temple of Dambulla","1991","Cultural",  "sri_dam"));
			items.add(new HeritageEntryItem("Old Town of Galle and its Fortifications","1988","Cultural", "sri_galle"));
			items.add(new HeritageEntryItem("Sacred City of Anuradhapura","1982","Cultural", "sri_anu"));
			items.add(new HeritageEntryItem("Sacred City of Kandy","1988","Cultural",  "sri_kandy"));
			
			items.add(new HeritageEntryItem("Central Highlands of Sri Lanka","2010","Natural",  "sri_high"));
			items.add(new HeritageEntryItem("Sinharaja Forest Reserve","1988","Natural",  "sri_sin"));

			mHTitle.setText("Sri Langka");
		} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 2)
				&& (((HeritageDetailActivity) getActivity()).getRegionId() == 3)
				&& (((HeritageDetailActivity) getActivity()).getCountryId() == 0)){
			items.add(new HeritageEntryItem("Temple of Preah Vihear","2008","Cultural",  "cambodia_preah"));
			items.add(new HeritageEntryItem("Angkor","1992","Cultural", "cambodia_angkor"));
			
			mHTitle.setText("Cambodia");
		} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 2)
				&& (((HeritageDetailActivity) getActivity()).getRegionId() == 3)
				&& (((HeritageDetailActivity) getActivity()).getCountryId() == 1)){
			items.add(new HeritageEntryItem("Borobudur Temple Compounds","1991","Cultural",  "indon_borobudur"));
			items.add(new HeritageEntryItem("Prambanan Temple Compounds","1991","Cultural",  "indon_prambanan"));
			items.add(new HeritageEntryItem("Komodo National Park","1991","Natural",  "indon_komodo"));
			items.add(new HeritageEntryItem("Ujung Kulon National Park","1991","Natural",  "indon_ujung"));
			items.add(new HeritageEntryItem("Sangiran Early Man Site","1996","Cultural", "indon_sangiran"));
			
			items.add(new HeritageEntryItem("Lorentz National Park","1999","Natural",  "indon_lorentz"));
			items.add(new HeritageEntryItem("Cultural Landscape of Bali Province","2012","Cultural", "indon_bali"));
			items.add(new HeritageEntryItem("Tropical Rainforest Heritage of Sumatra","2004","Natural",  "indon_sumatra"));
			mHTitle.setText("Indonesia");
		} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 2)
				&& (((HeritageDetailActivity) getActivity()).getRegionId() == 3)
				&& (((HeritageDetailActivity) getActivity()).getCountryId() == 2)){
			items.add(new HeritageEntryItem("Town of Luang Prabang","1995","Cultural", "laos_luang"));
			items.add(new HeritageEntryItem("Vat Phou and Associated Ancient Settlements within Champasak Cultural Landscape","2001","Cultural",  "laos_vatphou"));
			
			mHTitle.setText("Laos");
		} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 2)
				&& (((HeritageDetailActivity) getActivity()).getRegionId() == 3)
				&& (((HeritageDetailActivity) getActivity()).getCountryId() == 3)){
			items.add(new HeritageEntryItem("Gunung Mulu National Park","2000","Natural", "mal_mulu"));
			items.add(new HeritageEntryItem("Kinabalu Park","2000","Natural", "mal_kinabalu"));
			items.add(new HeritageEntryItem("Melaka and George Town","2008","Cultural",  "mal_melaka"));
			items.add(new HeritageEntryItem("Archaeological Heritage of the Lenggong Valley","2012","Cultural",  "mal_lenggong"));
			mHTitle.setText("Malaysia");
		} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 2)
				&& (((HeritageDetailActivity) getActivity()).getRegionId() == 3)
				&& (((HeritageDetailActivity) getActivity()).getCountryId() == 4)){
			items.add(new HeritageEntryItem("Pyu Ancient Cities","2014","Cultural",  "myanmar_pyu"));
			
			mHTitle.setText("Myanmar");
		} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 2)
				&& (((HeritageDetailActivity) getActivity()).getRegionId() == 3)
				&& (((HeritageDetailActivity) getActivity()).getCountryId() == 5)){
			items.add(new HeritageEntryItem("Tubbataha Reefs Natural Park","1993","Natural",  "phil_tubbataha"));
			items.add(new HeritageEntryItem("Historic Town of Vigan","1999","Cultural",  "phil_vigan"));
			items.add(new HeritageEntryItem("Baroque Churches of the Philippines","1993","Cultural", "phil_baroque"));
			items.add(new HeritageEntryItem("Puerto Princesa Subterranean River National Park","1999 ","Natural",  "phil_puerto"));
			items.add(new HeritageEntryItem("Mount Hamiguitan Range Wildlife Sanctuary","2014","Natural",  "phil_mount"));
			items.add(new HeritageEntryItem("Rice Terraces of the Philippine Cordilleras","1995","Cultural",  "phil_rice"));
			mHTitle.setText("Philippines");
		} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 2)
				&& (((HeritageDetailActivity) getActivity()).getRegionId() == 3)
				&& (((HeritageDetailActivity) getActivity()).getCountryId() == 6)){
			items.add(new HeritageEntryItem("Historic City of Ayutthaya","1991","Cultural", "thai_ayutthaya"));
			items.add(new HeritageEntryItem("Historic Town of Sukhothai and Associated Historic Towns","1991","Cultural", "thai_sukhothai"));
			items.add(new HeritageEntryItem("Thungyai-Huai Kha Khaeng Wildlife Sanctuaries","1991","Natural",  "thai_thungyai"));
			items.add(new HeritageEntryItem("Ban Chiang Archaeological Site","1992","Cultural", "thai_ban"));
			items.add(new HeritageEntryItem("Dong Phayayen-Khao Yai Forest Complex","2005","Natural", "thai_khaoyai"));

			mHTitle.setText("Thailand");
		} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 2)
				&& (((HeritageDetailActivity) getActivity()).getRegionId() == 3)
				&& (((HeritageDetailActivity) getActivity()).getCountryId() == 7)){
			items.add(new HeritageEntryItem("Complex of Hue Monuments","1993","Cultural", "vn_complex"));
			items.add(new HeritageEntryItem("Ha Long Bay","1993","Natural", "vn_halong"));
			items.add(new HeritageEntryItem("Hoi An Ancient Town","1999","Cultural", "vn_hoian"));
			items.add(new HeritageEntryItem("My Son Sanctuary","1999","Cultural", "vn_myson"));
			items.add(new HeritageEntryItem("Phong Nha-Ke Bang National Park","2003","Natural", "vn_phong"));
			items.add(new HeritageEntryItem("Central Sector of the Imperial Citadel of Thang Long-Hanoi","2010","Cultural",  "vn_thanglong"));
			items.add(new HeritageEntryItem("Citadel of the Ho Dynasty","2011","Cultural", "vn_ho"));
			
			items.add(new HeritageEntryItem("Trang An Scenic Landscape Complex","2014","Cultural", "vn_trangan"));
			mHTitle.setText("Vietnam");
		} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 2)
				&& (((HeritageDetailActivity) getActivity()).getRegionId() == 4)
				&& (((HeritageDetailActivity) getActivity()).getCountryId() == 0)){
			items.add(new HeritageEntryItem("Cultural Landscape and Archaeological Remains of the Bamiyan Valley","2003","Cultural",  "afghan_bami"));
			items.add(new HeritageEntryItem("Minaret and Archaeological Remains of Jam","2002","Cultural",  "afghan_jam"));
			
			mHTitle.setText("Afghanistan");
		} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 2)
				&& (((HeritageDetailActivity) getActivity()).getRegionId() == 4)
				&& (((HeritageDetailActivity) getActivity()).getCountryId() == 1)){
			items.add(new HeritageEntryItem("Pearling, Testimony of an Island Economy ","2012","Cultural",  "bah_pear"));
			items.add(new HeritageEntryItem("Qal'at al-Bahrain - Ancient Harbour and Capital of Dilmun","2005","Cultural",  "bah_qal"));
			
			mHTitle.setText("Bahrain");
		} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 2)
				&& (((HeritageDetailActivity) getActivity()).getRegionId() == 4)
				&& (((HeritageDetailActivity) getActivity()).getCountryId() == 2)){
			items.add(new HeritageEntryItem("Meidan Emam, Esfahan","1979","Cultural",  "iran_meidan"));
			items.add(new HeritageEntryItem("Persepolis","1979","Cultural",  "iran_perse"));
			items.add(new HeritageEntryItem("Tchogha Zanbil","1979","Cultural", "iran_tchogha"));
			items.add(new HeritageEntryItem("Takht-e Soleyman","2003","Cultural",  "iran_takht"));
			items.add(new HeritageEntryItem("Bam and its Cultural Landscape","2004","Cultural", "iran_bam"));
			items.add(new HeritageEntryItem("Pasargadae","2004","Cultural", "iran_pasar"));
			items.add(new HeritageEntryItem("Soltaniyeh","2005","Cultural",  "iran_soltan"));
			items.add(new HeritageEntryItem("Bisotun","2006","Cultural",  "iran_bisotun"));
			items.add(new HeritageEntryItem("Armenian Monastic Ensembles of Iran","2008","Cultural",  "iran_armenian"));
			items.add(new HeritageEntryItem("Shushtar Historical Hydraulic System","2009","Cultural", "iran_shushtar"));	
			items.add(new HeritageEntryItem("Tabriz Historic Bazaar Complex","2010","Cultural", "iran_tabriz"));
			items.add(new HeritageEntryItem("The Persian Garden","2011","Cultural", "iran_persian"));
			items.add(new HeritageEntryItem("Masjed-e Jame of Isfahan","2012","Cultural", "iran_masjed"));
			items.add(new HeritageEntryItem("Gonbad-e Qabus","2012","Cultural",  "iran_gonbad"));
			items.add(new HeritageEntryItem("Golestan Palace","2013","Cultural", "iran_golestan"));					
			items.add(new HeritageEntryItem("Shahr-e Sukhteh","2014","Cultural", "iran_shahr"));
			items.add(new HeritageEntryItem("Sheikh Safi al-din Khanegah and Shrine Ensemble in Ardabil","2014","Cultural",  "iran_sheikh"));
	
			mHTitle.setText("Iran");
		} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 2)
				&& (((HeritageDetailActivity) getActivity()).getRegionId() == 4)
				&& (((HeritageDetailActivity) getActivity()).getCountryId() == 3)){
			items.add(new HeritageEntryItem("Hatra","1985","Cultural", "iraq_hatra"));
			items.add(new HeritageEntryItem("Samarra Archaeological City","1985","Cultural", "iraq_samarra"));
			items.add(new HeritageEntryItem("Ashur (Qal'at Sherqat)","2003","Cultural",  "iraq_ashur"));
									
			mHTitle.setText("Iraq");
		} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 2)
				&& (((HeritageDetailActivity) getActivity()).getRegionId() == 4)
				&& (((HeritageDetailActivity) getActivity()).getCountryId() == 4)){
			items.add(new HeritageEntryItem("Masada","2001","Cultural",  "israel_masada"));
			items.add(new HeritageEntryItem("Old City of Acre","2001","Cultural", "israel_acre"));

			items.add(new HeritageEntryItem("White City of Tel-Aviv - the Modern Movement","2003","Cultural",  "israel_telaviv"));
			items.add(new HeritageEntryItem("Biblical Tels - Megiddo, Hazor, Beer Sheba","2005","Cultural", "israel_biblical"));
			items.add(new HeritageEntryItem("Incense Route - Desert Cities in the Negev","2005","Cultural",  "israel_negev"));
			items.add(new HeritageEntryItem("Bahá’i Holy Places in Haifa and the Western Galilee","2008","Cultural", "israel_haifa"));
			items.add(new HeritageEntryItem("Sites of Human Evolution at Mount Carmel: The Nahal Me’arot / Wadi el-Mughara Caves","2012","Cultural",  "israel_carmel"));
			items.add(new HeritageEntryItem("Caves of Maresha and Bet-Guvrin in the Judean Lowlands as a Microcosm of the Land of the Caves","2014","Cultural", "israel_cave"));
						
			mHTitle.setText("Israel");
		} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 2)
				&& (((HeritageDetailActivity) getActivity()).getRegionId() == 4)
				&& (((HeritageDetailActivity) getActivity()).getCountryId() == 5)){
			items.add(new HeritageEntryItem("Petra","1985","Cultural",  "jordan_petra"));
			items.add(new HeritageEntryItem("Qasr Amra","1985","Cultural", "jordan_qasr"));
			items.add(new HeritageEntryItem("Um er-Rasas (Kastrom Mefa'a)","2005","Cultural",  "jordan_um"));
			items.add(new HeritageEntryItem("Wadi Rum Protected Area","2005","Mixed", "jordan_wadi"));			
			mHTitle.setText("Jordan");
		} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 2)
				&& (((HeritageDetailActivity) getActivity()).getRegionId() == 4)
				&& (((HeritageDetailActivity) getActivity()).getCountryId() == 6)){
			items.add(new HeritageEntryItem("Anjar","1984","Cultural",  "lebanon_anjar"));
			items.add(new HeritageEntryItem("Baalbek","1984","Cultural", "lebanon_baalbek"));
			items.add(new HeritageEntryItem("Byblos","1984","Cultural",  "lebanon_byblos"));
			items.add(new HeritageEntryItem("Tyre","1984","Cultural",  "lebanon_tyre"));
			items.add(new HeritageEntryItem("Ouadi Qadisha (the Holy Valley) and the Forest of the Cedars of God (Horsh Arz el-Rab)","1998","Natural", "lebanon_ouadi"));			
			mHTitle.setText("Lebanon");
		} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 2)
				&& (((HeritageDetailActivity) getActivity()).getRegionId() == 4)
				&& (((HeritageDetailActivity) getActivity()).getCountryId() == 7)){
			items.add(new HeritageEntryItem("Bahla Fort","1987","Cultural",  "oman_bahla"));
			items.add(new HeritageEntryItem("Archaeological Sites of Bat, Al-Khutm and Al-Ayn","1988","Cultural", "oman_bat"));
			items.add(new HeritageEntryItem("Land of Frankincense","2000","Mixed",  "oman_oasis"));
			items.add(new HeritageEntryItem("Aflaj Irrigation Systems of Oman","2006","Cultural", "oman_irrigation"));			
			mHTitle.setText("Oman");
		} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 2)
				&& (((HeritageDetailActivity) getActivity()).getRegionId() == 4)
				&& (((HeritageDetailActivity) getActivity()).getCountryId() == 8)){
			items.add(new HeritageEntryItem("Al Zubarah Archaeological Site","2013","Cultural",  "qatar_01"));
			
			mHTitle.setText("Qatar");
		} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 2)
				&& (((HeritageDetailActivity) getActivity()).getRegionId() == 4)
				&& (((HeritageDetailActivity) getActivity()).getCountryId() == 9)){
			items.add(new HeritageEntryItem("Al-Hijr Archaeological Site (Madain Salih)","2008","Cultural",  "saudi_hijr"));
			items.add(new HeritageEntryItem("At-Turaif District in ad-Diriyah","2010","Cultural", "saudi_turaif"));
			items.add(new HeritageEntryItem("Historic Jeddah, the Gate to Makkah","2014","Cultural", "saudi_mak"));
			
			mHTitle.setText("Saudi Arabia");
		} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 2)
				&& (((HeritageDetailActivity) getActivity()).getRegionId() == 4)
				&& (((HeritageDetailActivity) getActivity()).getCountryId() == 10)){
			items.add(new HeritageEntryItem("Ancient City of Damascus","1979","Cultural", "syria_damascus"));
			items.add(new HeritageEntryItem("Site of Palmyra","1980","Cultural", "syria_palmyra"));
			items.add(new HeritageEntryItem("Ancient City of Bosra","1980","Cultural",  "syria_bosra"));	
			items.add(new HeritageEntryItem("Ancient City of Aleppo","1986","Cultural",  "syria_aleppo"));
			items.add(new HeritageEntryItem("Crac des Chevaliers and Qal’at Salah El-Din","2006","Cultural",  "syria_crac"));
			items.add(new HeritageEntryItem("Ancient Villages of Northern Syria","2011","Cultural",  "syria_village"));
			mHTitle.setText("Syria");
		} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 2)
				&& (((HeritageDetailActivity) getActivity()).getRegionId() == 4)
				&& (((HeritageDetailActivity) getActivity()).getCountryId() == 11)){
			items.add(new HeritageEntryItem("Goreme National Park and the Rock Sites of Cappadocia","1985","Mixed",  "turkey_goreme"));
			items.add(new HeritageEntryItem("Divrigi Great Mosque and Hospital","1985","Cultural", "turkey_divrigi"));
			items.add(new HeritageEntryItem("Historic Areas of Istanbul","1986","Cultural",  "turkey_istanbul"));
			items.add(new HeritageEntryItem("Hattusha: the Hittite Capital","1986","Cultural", "turkey_hattusha"));		
			items.add(new HeritageEntryItem("Nemrut Dag","1987","Cultural",  "turkey_dag"));
			items.add(new HeritageEntryItem("Hierapolis - Pamukkale","1988","Mixed", "turkey_pamukkale"));
			items.add(new HeritageEntryItem("Xanthos - Letoon","1988","Cultural",  "turkey_xanthos"));
			items.add(new HeritageEntryItem("City of Safranbolu","1994","Cultural", "turkey_safranbolu"));			
			items.add(new HeritageEntryItem("Archaeological Site of Troy","1998","Cultural",  "turkey_troy"));
			items.add(new HeritageEntryItem("Selimiye Mosque and its Social Complex","2011","Cultural", "turkey_selimiye"));
			items.add(new HeritageEntryItem("Neolithic Site of Catalhoyuk","2012","Cultural",  "turkey_neolithic"));
			items.add(new HeritageEntryItem("Bursa and Cumalikizik: the Birth of the Ottoman Empire","2014","Cultural", "turkey_bursa"));		
			items.add(new HeritageEntryItem("Pergamon and its Multi-Layered Cultural Landscape","2014","Cultural",  "turkey_pergamon"));
	
			mHTitle.setText("Turkey");
		} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 3)
				&& (((HeritageDetailActivity) getActivity()).getRegionId() == 0)
				&& (((HeritageDetailActivity) getActivity()).getCountryId() == 0)){
			items.add(new HeritageEntryItem("City of Graz, Historic Center and Schloss Eggenberg","1979","Cultural",  "austria_graz"));
			items.add(new HeritageEntryItem("Historic Center of the city of Salzburg","1996","Cultural",  "austria_salzburg"));
			items.add(new HeritageEntryItem("Palace and Gardens of Schonbrunn","1996","Cultural",  "austria_schonbrunn"));
			items.add(new HeritageEntryItem("Hallstatt Dachstein","1997","Cultural",  "austria_hallstatt"));	
			items.add(new HeritageEntryItem("Semmering Railway","1998","Cultural",  "austria_railway"));
			items.add(new HeritageEntryItem("Wachau Cultural Landscape","2000","Cultural",  "austria_wachau"));
			items.add(new HeritageEntryItem("Historic Center of Vienna","2001","Cultural",  "austria_vienna"));
			items.add(new HeritageEntryItem("Ferto/Neusiedlersee Cultural Landscape","2001","Cultural",  "austria_ferto"));			
			items.add(new HeritageEntryItem("Prehistoric Pile Dwellings aroudn the Alps","2011","Cultural",  "swiss_alps"));
			
			mHTitle.setText("Austria");
		} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 3)
				&& (((HeritageDetailActivity) getActivity()).getRegionId() == 0)
				&& (((HeritageDetailActivity) getActivity()).getCountryId() == 1)){
			items.add(new HeritageEntryItem("Gardens and Castle at Kromenz","1998","Cultural",  "czech_gardens"));
			items.add(new HeritageEntryItem("Historic Center of Cesky Krumlov","1992","Cultural",  "czech_krumlov"));
			items.add(new HeritageEntryItem("Historic Center of Prague","1992","Cultural",  "czech_prague"));
			items.add(new HeritageEntryItem("Historic Center of Telc","1992","Cultural",  "czech_telc"));
			items.add(new HeritageEntryItem("Holasovice Historical Village Reservation","1998","Cultural",  "czech_hola"));			
			items.add(new HeritageEntryItem("Holy trinity Column in Olomouc","2000","Cultural",  "czech_olomouc"));
			items.add(new HeritageEntryItem("Jewish Quarter and St procopius Basilica in Trebic","2003","Cultural",  "czech_jewish"));
			items.add(new HeritageEntryItem("Kutna Hora","1995","Cultural",  "czech_kutna"));
			items.add(new HeritageEntryItem("Lednice Valtice Cultural Landscape","1996","Cultural",  "czech_lednice"));
			items.add(new HeritageEntryItem("Litomysl Castle","1999","Cultural",  "czech_castle"));
			items.add(new HeritageEntryItem("Pilgrimage Church of St John of Nepomuk","1999","Cultural",  "czech_church"));
			items.add(new HeritageEntryItem("Tugendhat Villa in Brno ","2001","Cultural",  "czech_brno"));
			mHTitle.setText("Czech");
		}  else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 3)
				&& (((HeritageDetailActivity) getActivity()).getRegionId() == 0)
				&& (((HeritageDetailActivity) getActivity()).getCountryId() == 2)){
			items.add(new HeritageEntryItem("Aachen Cathedral","1978","Cultural",  "ger_aachen"));
			items.add(new HeritageEntryItem("Abbey and Altenmunster of Lorsch","1991","Cultural",  "ger_abbey"));
			items.add(new HeritageEntryItem("Bauhaus ad its Sites in Weimar and Dessau","1996","Cultural",  "ger_bauhaus"));
			items.add(new HeritageEntryItem("Bergpark Wihelmshohe","2013","Cultural",  "ger_bergpark"));
			items.add(new HeritageEntryItem("Berlin Modernism Housing Estates","2008","Cultural",  "ger_berlin"));			
			items.add(new HeritageEntryItem("Carolingian Westwork and Civitas Corvey","2014","Cultural",  "ger_carolingian"));
			items.add(new HeritageEntryItem("Castles of Augustusburg and Falkenlust at Bruhl","1984","Cultural",  "ger_bruhl"));
			items.add(new HeritageEntryItem("Classical Weimar","1998","Cultural",  "ger_weimar"));
			items.add(new HeritageEntryItem("Collegiate church, Castle and Old town of Quedlinburg","1994","Cultural",  "ger_quedlin"));
			items.add(new HeritageEntryItem("Cologne Cathedral","1996","Cultural",  "ger_cologne"));
			items.add(new HeritageEntryItem("Fagus Factory in Alfeld","2011","Cultural",  "ger_fagus"));
			items.add(new HeritageEntryItem("Frontiers of the Roman Empire","1987","Cultural",  "ger_frontier"));			
			items.add(new HeritageEntryItem("Garden Kingdom of Dessau Worlitz ","2000","Cultural",  "ger_dessau"));
			items.add(new HeritageEntryItem("Hanseatic City of Lubeck ","1987","Cultural",  "ger_lubeck"));
			items.add(new HeritageEntryItem("Historic Centers of Stralsund and Wismar","2002","Cultural",  "ger_wismar"));			
			items.add(new HeritageEntryItem("Luther Memorials in Eisleben and Wittenberg ","1996","Cultural",  "ger_luther"));
			
			items.add(new HeritageEntryItem("Margravial Opera House Bayreuth","2012","Cultural",  "ger_margra"));
			items.add(new HeritageEntryItem("Maulbronn Monastery Complex","1993","Cultural",  "ger_maulbronn"));
			items.add(new HeritageEntryItem("Mines of Rammelsberg, Historic Town of Goslar and Upper Harz Water Management System ","1992","Cultural",  "ger_rammel"));
			items.add(new HeritageEntryItem("Monastic Island of Reichenau","2000","Cultural",  "ger_reichen"));
			items.add(new HeritageEntryItem("Museumsinsel (Museum Island), Berlin ","1999","Cultural",  "ger_museum"));
			items.add(new HeritageEntryItem("Muskauer Park / Park Muzakowski","2004","Cultural",  "ger_muskauer"));
			items.add(new HeritageEntryItem("Old town of Regensburg with Stadtamhof","2006","Cultural",  "ger_regen"));
			items.add(new HeritageEntryItem("Palaces and Parks of Potsdam and Berlin ","1990","Cultural",  "ger_potsdam"));
			
			items.add(new HeritageEntryItem("Pilgrimage Church of Wies ","1983","Cultural",  "ger_wies"));
			items.add(new HeritageEntryItem("Prehistoric Pile dwellings around the Alps ","2011","Cultural",  "austria_alps"));
			items.add(new HeritageEntryItem("Roman Monuments, Cathedral of St Peter and Church of Our Lady in Trier  ","1986","Cultural",  "ger_roman"));
			items.add(new HeritageEntryItem("Speyer Cathedral  ","1981","Cultural",  "ger_speyer"));
			items.add(new HeritageEntryItem("St Mary's Cathedral and St Michael's Church at Hildesheim ","1985","Cultural",  "ger_stmary"));
			items.add(new HeritageEntryItem("Town Hall and Roland on the Marketplace of Bremen ","2004","Cultural",  "ger_bremen"));
			items.add(new HeritageEntryItem("Town of Bamberg  ","1993","Cultural",  "ger_bamberg"));
			items.add(new HeritageEntryItem("Upper Middle Rhine Valley ","2002","Cultural",  "ger_rhine"));
			items.add(new HeritageEntryItem("Völklingen Ironworks ","194","Cultural",  "ger_volk"));
			items.add(new HeritageEntryItem("Wartburg Castle","1999","Cultural",  "ger_wart"));
			items.add(new HeritageEntryItem("Würzburg Residence with the Court Gardens and Residence Square","1981","Cultural",  "ger_wurz"));
			items.add(new HeritageEntryItem("Zollverein Coal Mine Industrial Complex in Essen ","2001","Cultural",  "ger_essen"));
			
			items.add(new HeritageEntryItem("Messel Pit Fossil Site","1995","Natural",  "ger_fossil"));
			items.add(new HeritageEntryItem("Primeval Beech Forests of the Carpathians and the Ancient Beech Forests of Germany","2007","Natural",  "ukraine_primeval"));
			items.add(new HeritageEntryItem("Wadden Sea ","2009","Natural",  "ger_wadden"));
			
			mHTitle.setText("Germany");
		} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 3)
				&& (((HeritageDetailActivity) getActivity()).getRegionId() == 0)
				&& (((HeritageDetailActivity) getActivity()).getCountryId() == 3)){
			items.add(new HeritageEntryItem("Budapest","1987","Cultural",  "hungary_budapest"));
			items.add(new HeritageEntryItem("Early Christian Necropolis of Pecs","2000","Cultural",  "hungary_early"));
			items.add(new HeritageEntryItem("Ferto/ Neusiedlersee Cultural Landscape","2001","Cultural",  "hungary_ferto"));
			items.add(new HeritageEntryItem("Hortobagy National Park - The Puszta ","1999","Cultural",  "hungary_pustz"));
			items.add(new HeritageEntryItem("Millebary Benedictine Abbey of Pannonhalma","1996","Cultural",  "hungary_mille"));			
			items.add(new HeritageEntryItem("Old Village of Holloko","1987","Cultural",  "hungary_hollo"));
			items.add(new HeritageEntryItem("Tokaj Wine Region","2002","Cultural",  "hungary_tokaj"));
			items.add(new HeritageEntryItem("Caves of Aggtelek Karst and Slovak karst","1995","Natural",  "hungary_caves"));
			
			mHTitle.setText("Hungary");
		} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 3)
				&& (((HeritageDetailActivity) getActivity()).getRegionId() == 0)
				&& (((HeritageDetailActivity) getActivity()).getCountryId() == 4)){
			items.add(new HeritageEntryItem("Auschwitz Birkenau","1979","Cultural",  "poland_ausch"));
			items.add(new HeritageEntryItem("Castle of the Teutonic Order in Malbork","1997","Cultural",  "poland_malbork"));
			items.add(new HeritageEntryItem("Centennial Hall in Wroclaw ","2006","Cultural",  "poland_wroclaw"));
			items.add(new HeritageEntryItem("Churches of Peace in Jawor and Swidnica ","2001","Cultural",  "poland_jawor"));
			items.add(new HeritageEntryItem("Historic Center of Krakow ","1978","Cultural",  "poland_krakow"));
			items.add(new HeritageEntryItem("Historic Center of Warsaw ","1980","Cultural",  "poland_warsaw"));
			
			items.add(new HeritageEntryItem("Kalwaria Zebrzydowska: the Mannerist Architectural and Park Landscape Complex and Pilgrimage Park ","1999","Cultural",  "poland_kalwaria"));
			items.add(new HeritageEntryItem("Medieval Town of Torun  ","1997","Cultural",  "poland_torun"));
			items.add(new HeritageEntryItem("Muskauer Park / Park Muzakowski ","2004","Cultural",  "poland_muskauer"));
			items.add(new HeritageEntryItem("Old City of Zamosc  ","1992","Cultural",  "poland_zamo"));
			items.add(new HeritageEntryItem("Wieliczka and Bochnia Royal Salt Mines ","1978","Cultural",  "poland_mine"));
			items.add(new HeritageEntryItem("Wooden Tserkvas of the Carpathian Region in Poland and Ukraine  ","2013","Cultural",  "poland_carpa"));
			items.add(new HeritageEntryItem("Wooden Churches of Southern Mazopolska ","2003","Cultural",  "poland_mazo"));
			items.add(new HeritageEntryItem("Bialowieza Forest","1979","Natural",  "poland_bia"));
			
			mHTitle.setText("Poland");
		} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 3)
				&& (((HeritageDetailActivity) getActivity()).getRegionId() == 0)
				&& (((HeritageDetailActivity) getActivity()).getCountryId() == 5)){
			items.add(new HeritageEntryItem("Bardejov Town Conservation Reserve ","2000","Cultural",  "slovak_barde"));
			items.add(new HeritageEntryItem("Historic Town of Banska Stiavnica ","1993","Cultural",  "slovak_banskia"));
			items.add(new HeritageEntryItem("Levoca, Spissky Hrad and the Associated Cultural Monuments ","1993","Cultural",  "slovak_levoca"));
			items.add(new HeritageEntryItem("Vlkolínec","1993","Cultural",  "slovak_vlko"));
			items.add(new HeritageEntryItem("Wooden Churches of the Slovak part of the Carpathian Mountain Area","2008","Cultural",  "slovak_wood"));
			items.add(new HeritageEntryItem("Caves of Aggtelek Karst and Slovak Karst ","1995","Natural",  "slovak_karst"));
			items.add(new HeritageEntryItem("Primeval Beech Forests of the Carpathians and the Ancient Beech Forests of Germany","2007","Natural",  "ukraine_primeval"));
			
			mHTitle.setText("Slovakia");
		} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 3)
				&& (((HeritageDetailActivity) getActivity()).getRegionId() == 0)
				&& (((HeritageDetailActivity) getActivity()).getCountryId() == 6)){
			items.add(new HeritageEntryItem("Abbey of St Gall","1983","Cultural",  "swiss_abbey"));
			items.add(new HeritageEntryItem("Benedictine Convent of St John at Mustair ","1983","Cultural",  "swiss_mustair"));
			items.add(new HeritageEntryItem("La Chaux-de-Fonds/Le Loclem Watchmaking Town Planning","2009","Cultural",  "swiss_la"));
			items.add(new HeritageEntryItem("Lavaux, Vineyard Terraces","2007","Cultural",  "swiss_lavaux"));
			items.add(new HeritageEntryItem("Old City of Berne","1983","Cultural",  "swiss_berne"));
			items.add(new HeritageEntryItem("Prehistoric Pile dwellings around the Alps","2011","Cultural",  "swiss_alps"));
			items.add(new HeritageEntryItem("Rhaetian Railway in the Albula / Bernina Landscapes","2008","Cultural",  "italy_railway"));
			items.add(new HeritageEntryItem("Three Castles, Defensive Wall and Ramparts of the Market-Town of Bellinzona","2000","Cultural",  "swiss_castles"));

			items.add(new HeritageEntryItem("Monte San Giorgio","2003","Natural",  "swiss_monte"));
			items.add(new HeritageEntryItem("Swiss Alps Jungfrau-Aletsch","2001","Natural",  "swiss_jungfrau"));
			items.add(new HeritageEntryItem("Swiss Tectonic Arena Sardona","2008","Natural",  "swiss_tectonic"));
												
			mHTitle.setText("Switzerland");
		} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 3)
				&& (((HeritageDetailActivity) getActivity()).getRegionId() == 1)
				&& (((HeritageDetailActivity) getActivity()).getCountryId() == 0)){
			items.add(new HeritageEntryItem("Gobustan Rock Art Cultural Landscape","2007","Cultural",  "azer_gobustan"));
			items.add(new HeritageEntryItem("Walled City of Baku with the Shirvanshah's Palace and Maiden Tower","2000","Cultural",  "azer_baku"));

			mHTitle.setText("Azerbaijan");
		} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 3)
				&& (((HeritageDetailActivity) getActivity()).getRegionId() == 1)
				&& (((HeritageDetailActivity) getActivity()).getCountryId() == 1)){
			items.add(new HeritageEntryItem("Architectural, Residential and Cultural Complex of the Radziwill Family at Nesvizh","2005","Cultural",  "belarus_nesvizh"));
			items.add(new HeritageEntryItem("Mir Castle Complex","2000","Cultural",  "belarus_mir"));
			items.add(new HeritageEntryItem("Struve Geodetic Arc","2005","Cultural",  "belarus_arc"));
			items.add(new HeritageEntryItem("Biazowieza Forest","1979","Natural",  "belarus_bia"));
			
			mHTitle.setText("Belarus");
		} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 3)
				&& (((HeritageDetailActivity) getActivity()).getRegionId() == 1)
				&& (((HeritageDetailActivity) getActivity()).getCountryId() == 2)){
			items.add(new HeritageEntryItem("Ancient City of Nessebar","1983","Cultural",  "bulgaria_nesse"));
			items.add(new HeritageEntryItem("Boyana Church","1979","Cultural",  "bulgaria_boyana"));
			items.add(new HeritageEntryItem("Madara Rider ","1979","Cultural",  "bulgaria_madara"));
			items.add(new HeritageEntryItem("Rila Monastery  ","1983","Cultural",  "bulgaria_rila"));
			items.add(new HeritageEntryItem("Rock-Hewn Churches of Ivanovo ","1979","Cultural",  "bulgaria_ivanovo"));
			items.add(new HeritageEntryItem("Thracian Tomb of Kazanlak  ","1979","Cultural",  "bulgaria_thra"));
			items.add(new HeritageEntryItem("Thracian Tomb of Sveshtari ","1985","Cultural",  "bulgaria_thrac"));
			items.add(new HeritageEntryItem("Pirin National Park ","1983","Natural",  "bulgaria_pirin"));
			items.add(new HeritageEntryItem("Srebarna Nature Reserve ","1983","Natural",  "bulgaria_sreba"));

			mHTitle.setText("Bulgaria");
		} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 3)
				&& (((HeritageDetailActivity) getActivity()).getRegionId() == 1)
				&& (((HeritageDetailActivity) getActivity()).getCountryId() == 3)){
			items.add(new HeritageEntryItem("Historic Centre (Old Town) of Tallinn","1997","Cultural",  "esto_tallinn"));
			items.add(new HeritageEntryItem("Struve Geodetic Arc","2005","Cultural",  "esto_arc"));
			
			mHTitle.setText("Estonia");
		} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 3)
				&& (((HeritageDetailActivity) getActivity()).getRegionId() == 1)
				&& (((HeritageDetailActivity) getActivity()).getCountryId() == 4)){
			items.add(new HeritageEntryItem("Bagrati Cathedral and Gelati Monastery","1994","Cultural",  "geo_gelati"));
			items.add(new HeritageEntryItem("Historical Monuments of Mtskheta","1994","Cultural",  "geo_mtskheta"));
			items.add(new HeritageEntryItem("Upper Svaneti","1996","Cultural",  "geo_svaneti"));
					
			mHTitle.setText("Georgia");
		} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 3)
				&& (((HeritageDetailActivity) getActivity()).getRegionId() == 1)
				&& (((HeritageDetailActivity) getActivity()).getCountryId() == 5)){
			items.add(new HeritageEntryItem("Historic Centre of Riga","1997","Cultural",  "latvia_riga"));
			items.add(new HeritageEntryItem("Struve Geodetic Arc","2005","Cultural",  "belarus_arc"));
		
			mHTitle.setText("Latvia");
		} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 3)
				&& (((HeritageDetailActivity) getActivity()).getRegionId() == 1)
				&& (((HeritageDetailActivity) getActivity()).getCountryId() == 6)){
			items.add(new HeritageEntryItem("Curonian Spit","2000","Cultural",  "lithu_curo"));
			items.add(new HeritageEntryItem("Kernave Archaeological Site (Cultural Reserve of Kernave)","2004","Cultural",  "lithu_kernave"));
			items.add(new HeritageEntryItem("Struve Geodetic Arc","2005","Cultural",  "belarus_arc"));
			items.add(new HeritageEntryItem("Vilnius Historic Centre","1994","Cultural",  "lithu_vilnius"));
		
			mHTitle.setText("Lithuania");
		} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 3)
				&& (((HeritageDetailActivity) getActivity()).getRegionId() == 1)
				&& (((HeritageDetailActivity) getActivity()).getCountryId() == 7)){
			items.add(new HeritageEntryItem("Churches of Moldavia ","1993","Cultural",  "romania_moldavia"));
			items.add(new HeritageEntryItem("Dacian Fortresses of the Orastie Mountains ","1999","Cultural",  "romania_dacian"));
			items.add(new HeritageEntryItem("Historic Centre of Sighisoara ","1999","Cultural",  "romania_sighi"));
			items.add(new HeritageEntryItem("Monastery of Horezu ","1993","Cultural",  "romania_horezu"));
			items.add(new HeritageEntryItem("Villages with Fortified Churches in Transylvania ","1993","Cultural",  "romania_tran"));
			items.add(new HeritageEntryItem("Wooden Churches of Maramures","1999","Cultural",  "romania_mara"));
			items.add(new HeritageEntryItem("Danube Delta ","1991","Natural",  "romania_danube"));
			
			mHTitle.setText("Romania");
		} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 3)
				&& (((HeritageDetailActivity) getActivity()).getRegionId() == 1)
				&& (((HeritageDetailActivity) getActivity()).getCountryId() == 8)){
			items.add(new HeritageEntryItem("Architectural Ensemble of the Trinity Sergius Lavra in Sergiev Posad","1993","Cultural",  "russia_posad"));
			items.add(new HeritageEntryItem("Bolgar Historical and Archaeological Complex","2004","Cultural",  "russia_bolgar"));
			items.add(new HeritageEntryItem("Church of the Ascension, Kolomenskoye","1994","Cultural",  "russia_ascen"));
			items.add(new HeritageEntryItem("Citadel, Ancient City and Fortress Buildings of Derbent","2003","Cultural",  "russia_derbent"));
			items.add(new HeritageEntryItem("Cultural and Historic Ensemble of the Solovetsky Islands","1992","Cultural",  "russia_solo"));
			items.add(new HeritageEntryItem("Curonian Spit","2000","Cultural",  "russia_curo"));
			items.add(new HeritageEntryItem("Ensemble of the Ferapontov Monastery","2000","Cultural",  "russia_fera"));
			items.add(new HeritageEntryItem("Ensemble of the Novodevichy Convent","2004","Cultural",  "russia_novo"));
			items.add(new HeritageEntryItem("Historic and Architectural Complex of the Kazan Kremlin ","2000","Cultural",  "russia_kazan"));
			items.add(new HeritageEntryItem("Historic Centre of Saint Petersburg and Related Groups of Monuments","1990","Cultural",  "russia_petersburg"));
			items.add(new HeritageEntryItem("Historic Monuments of Novgorod and Surroundings","1992","Cultural",  "russia_novgorod"));
			items.add(new HeritageEntryItem("Historical Centre of the City of Yaroslavl","2005","Cultural",  "russia_yaro"));
			items.add(new HeritageEntryItem("Kizhi Pogost","1990","Cultural",  "russia_kizhi"));
			items.add(new HeritageEntryItem("Kremlin and Red Square, Moscow","1990","Cultural",  "russia_kremlin"));
			items.add(new HeritageEntryItem("Struve Geodetic Arc ","2005","Cultural",  "belarus_arc"));
			items.add(new HeritageEntryItem("White Monuments of Vladimir and Suzdal","1992","Cultural",  "russia_white"));
			
			items.add(new HeritageEntryItem("Central Sikhote-Alin ","2001","Natural",  "russia_sikh"));
			items.add(new HeritageEntryItem("Golden Mountains of Altai","1993","Natural",  "russia_altai"));
			items.add(new HeritageEntryItem("Lake Baikal","1998","Natural",  "russia_baikal"));
			items.add(new HeritageEntryItem("Lena Pillars Nature Park","2012","Natural",  "russia_lena"));
			items.add(new HeritageEntryItem("Natural System of Wrangel Island Reserve","2004","Natural",  "russia_wrangel"));
			items.add(new HeritageEntryItem("Putorana Plateau","2010","Natural",  "russia_putorana"));
			items.add(new HeritageEntryItem("Uvs Nuur Basin ","2003","Natural",  "russia_uvs"));
			items.add(new HeritageEntryItem("Virgin Komi Forests","1995","Natural",  "russia_komi"));
			items.add(new HeritageEntryItem("Volcanoes of Kamchatka  ","1996","Natural",  "russia_kam"));
			items.add(new HeritageEntryItem("Western Caucasus","1999","Natural",  "russia_west"));
				
			mHTitle.setText("Russia");
		} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 3)
				&& (((HeritageDetailActivity) getActivity()).getRegionId() == 1)
				&& (((HeritageDetailActivity) getActivity()).getCountryId() == 9)){
			items.add(new HeritageEntryItem("Ancient City of Tauric Chersonese and its Chora","2013","Cultural",  "ukraine_tau"));
			items.add(new HeritageEntryItem("Kiev: Saint-Sophia Cathedral and Related Monastic Buildings, Kiev-Pechersk Lavra","1990","Cultural",  "ukraine_kiev"));
			items.add(new HeritageEntryItem("L'viv ñ the Ensemble of the Historic Centre","1998","Cultural",  "ukraine_lviv"));
			items.add(new HeritageEntryItem("Residence of Bukovinian and Dalmatian Metropolitans","2011","Cultural",  "ukraine_buko"));
			items.add(new HeritageEntryItem("Struve Geodetic Arc","2005","Cultural",  "belarus_arc"));
			items.add(new HeritageEntryItem("Wooden Tserkvas of the Carpathian Region in Poland and Ukraine","2013","Cultural",  "ukraine_wood"));
			items.add(new HeritageEntryItem("Primeval Beech Forests of the Carpathians and the Ancient Beech Forests of Germany","2007","Natural",  "ukraine_primeval"));

			mHTitle.setText("Ukraine");
		} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 3)
				&& (((HeritageDetailActivity) getActivity()).getRegionId() == 2)
				&& (((HeritageDetailActivity) getActivity()).getCountryId() == 0)){
			items.add(new HeritageEntryItem("Jelling Mounds, Runic Stones and Church","1994","Cultural",  "den_jelling"));
			items.add(new HeritageEntryItem("Kronborg Castle ","2000","Cultural",  "den_kron"));
			items.add(new HeritageEntryItem("Roskilde Cathedral","1995","Cultural",  "den_ros"));
			items.add(new HeritageEntryItem("Ilulissat Icefjord","2011","Natural",  "den_ilu"));
			items.add(new HeritageEntryItem("Stevns Klint ","2005","Natural",  "den_ste"));
			items.add(new HeritageEntryItem("Wadden Sea","2013","Natural",  "ger_wadden"));
			
			mHTitle.setText("Denmark");
		} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 3)
				&& (((HeritageDetailActivity) getActivity()).getRegionId() == 2)
				&& (((HeritageDetailActivity) getActivity()).getCountryId() == 1)){
			items.add(new HeritageEntryItem("Bronze Age Burial Site of Sammallahdenmäki","1999","Cultural",  "fin_bronze"));
			items.add(new HeritageEntryItem("Fortress of Suomenlinna ","1991","Cultural",  "fin_fort"));
			items.add(new HeritageEntryItem("Old Rauma","1991","Cultural",  "fin_rauma"));
			items.add(new HeritageEntryItem("Petäjävesi Old Church","1994","Cultural",  "fin_peta"));
			items.add(new HeritageEntryItem("Struve Geodetic Arc","2005","Cultural",  "belarus_arc"));
			items.add(new HeritageEntryItem("Verla Groundwood and Board Mill","1996","Cultural",  "fin_verla"));
			items.add(new HeritageEntryItem("High Coast / Kvarken Archipelago ","2000","Natural",  "fin_kvar"));
			
			mHTitle.setText("Finland");
		} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 3)
				&& (((HeritageDetailActivity) getActivity()).getRegionId() == 2)
				&& (((HeritageDetailActivity) getActivity()).getCountryId() == 2)){
			items.add(new HeritageEntryItem("ﬁingvellir National Park","2004","Cultural",  "ice_park"));
			items.add(new HeritageEntryItem("Surtsey","2008","Natural",  "ice_surt"));
			
			mHTitle.setText("Iceland");
		} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 3)
				&& (((HeritageDetailActivity) getActivity()).getRegionId() == 2)
				&& (((HeritageDetailActivity) getActivity()).getCountryId() == 3)){
			items.add(new HeritageEntryItem("Bryggen","1979","Cultural",  "nor_bry"));
			items.add(new HeritageEntryItem("Rock Art of Alta","1985","Cultural",  "nor_alta"));
			items.add(new HeritageEntryItem("Roros Mining Town and the Circumference","1980","Cultural",  "nor_roros"));
			items.add(new HeritageEntryItem("Struve Geodetic Arc","2005","Cultural",  "belarus_arc"));
			items.add(new HeritageEntryItem("Urnes Stave Church","1979","Cultural",  "nor_urnes"));
			items.add(new HeritageEntryItem("Vegaoyan -- The Vega Archipelago","2004","Cultural",  "nor_vega"));
			items.add(new HeritageEntryItem("West Norwegian Fjords - Geirangerfjord and Nærøyfjord","2005","Natural",  "nor_fjord"));

			mHTitle.setText("Norway");
		} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 3)
				&& (((HeritageDetailActivity) getActivity()).getRegionId() == 2)
				&& (((HeritageDetailActivity) getActivity()).getCountryId() == 4)){
			items.add(new HeritageEntryItem("Agricultural Landscape of Southern Oland ","2000","Cultural",  "swe_oland"));
			items.add(new HeritageEntryItem("Birka and Hovgarden","1993","Cultural",  "swe_birka"));
			items.add(new HeritageEntryItem("Church Town of Gammelstad, Lulea","1996","Cultural",  "swe_lulea"));
			items.add(new HeritageEntryItem("Decorated Farmhouses of Halsingland","2012","Cultural",  "swe_halsing"));
			items.add(new HeritageEntryItem("Engelsberg Ironworks","1993","Cultural",  "swe_engel"));
			items.add(new HeritageEntryItem("Grimeton Radio Station, Varberg ","2004","Cultural",  "swe_varberg"));
			items.add(new HeritageEntryItem("Hanseatic Town of Visby","1995","Cultural",  "swe_visby"));
			items.add(new HeritageEntryItem("Mining Area of the Great Copper Mountain in Falun ","2001","Cultural",  "swe_falun"));
			items.add(new HeritageEntryItem("Naval Port of Karlskrona","1998","Cultural",  "swe_karl"));
			items.add(new HeritageEntryItem("Rock Carvings in Tanum","1994","Cultural",  "swe_tanum"));
			items.add(new HeritageEntryItem("Royal Domain of Drottningholm","1991","Cultural",  "swe_drott"));
			items.add(new HeritageEntryItem("Skogskyrkogarden ","1994","Cultural",  "swe_sko"));
			items.add(new HeritageEntryItem("Struve Geodetic Arc ","2005","Cultural",  "belarus_arc"));
			items.add(new HeritageEntryItem("High Coast / Kvarken Archipelago ","2000","Natural",  "swe_kvar"));
			items.add(new HeritageEntryItem("Laponian Area","1996","Mixed",  "swe_lapo"));

			mHTitle.setText("Sweden");
		} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 3)
				&& (((HeritageDetailActivity) getActivity()).getRegionId() == 3)
				&& (((HeritageDetailActivity) getActivity()).getCountryId() == 0)){
			items.add(new HeritageEntryItem("Butrint","1992","Cultural",  "albania_but"));
			items.add(new HeritageEntryItem("Historic Centres of Berat and Gjirokastra","2005","Cultural",  "albania_berat"));

			mHTitle.setText("Albania");			
		}  else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 3)
				&& (((HeritageDetailActivity) getActivity()).getRegionId() == 3)
				&& (((HeritageDetailActivity) getActivity()).getCountryId() == 1)){
			items.add(new HeritageEntryItem("Cathedral and Churches of Echmiatsin and the Archaeological Site of Zvartnots","2000","Cultural",  "armenia_ech"));
			items.add(new HeritageEntryItem("Monasteries of Haghpat and Sanahin","1996","Cultural",  "armenia_hagh"));
			items.add(new HeritageEntryItem("Monastery of Geghard and the Upper Azat Valley","2000","Cultural",  "armenia_geghard"));
			
			mHTitle.setText("Armenia");			
		}  else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 3)
				&& (((HeritageDetailActivity) getActivity()).getRegionId() == 3)
				&& (((HeritageDetailActivity) getActivity()).getCountryId() == 2)){
			items.add(new HeritageEntryItem("Mehmed Paöa Sokolovic Bridge in Viöegrad","2007","Cultural",  "bosnia_meh"));
			items.add(new HeritageEntryItem("Old Bridge Area of the Old City of Mostar","2005","Cultural",  "bosnia_mostar"));

			mHTitle.setText("Bosnia");			
		} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 3)
				&& (((HeritageDetailActivity) getActivity()).getRegionId() == 3)
				&& (((HeritageDetailActivity) getActivity()).getCountryId() == 3)){
			items.add(new HeritageEntryItem("Episcopal Complex of the Euphrasian Basilica in the Historic Centre of Porec","1997","Cultural",  "croa_porec"));
			items.add(new HeritageEntryItem("Historic City of Trogir","1997","Cultural",  "croa_trogir"));
			items.add(new HeritageEntryItem("Historical Complex of Split with the Palace of Diocletian","1979","Cultural",  "croa_split"));
			items.add(new HeritageEntryItem("Old City of Dubrovnik ","1979","Cultural",  "croa_dub"));
			items.add(new HeritageEntryItem("Stari Grad Plain","2008","Cultural",  "croa_stari"));
			items.add(new HeritageEntryItem("The Cathedral of St James in Sibenik","2000","Cultural",  "croa_sibe"));
			items.add(new HeritageEntryItem("Plitvice Lakes National Park ","1979","Natural",  "croa_plit"));
			
			mHTitle.setText("Croatia");			
		} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 3)
				&& (((HeritageDetailActivity) getActivity()).getRegionId() == 3)
				&& (((HeritageDetailActivity) getActivity()).getCountryId() == 4)){
			items.add(new HeritageEntryItem("Choirokoitia","1998","Cultural",  "cyp_choi"));
			items.add(new HeritageEntryItem("Painted Churches in the Troodos Region","1985","Cultural",  "cyp_troo"));
			items.add(new HeritageEntryItem("Paphos","1980","Cultural",  "cyp_paphos"));

			mHTitle.setText("Cyprus");			
		} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 3)
				&& (((HeritageDetailActivity) getActivity()).getRegionId() == 3)
				&& (((HeritageDetailActivity) getActivity()).getCountryId() == 5)){
			items.add(new HeritageEntryItem("Acropolis, Athens","1987","Cultural",  "greece_acropolis"));
			items.add(new HeritageEntryItem("Archaeological Site of Aigai (modern name Vergina)","1996","Cultural",  "greece_aigai"));
			items.add(new HeritageEntryItem("Archaeological Site of Delphi ","1987","Cultural",  "greece_delphi"));
			items.add(new HeritageEntryItem("Archaeological Site of Mystras","1989","Cultural",  "greece_mystras"));
			items.add(new HeritageEntryItem("Archaeological Site of Olympia","1989","Cultural",  "greece_olympia"));
			items.add(new HeritageEntryItem("Archaeological Sites of Mycenae and Tiryns","1999","Cultural",  "greece_myce"));
			items.add(new HeritageEntryItem("Delos","1990","Cultural",  "greece_delos"));
			items.add(new HeritageEntryItem("Medieval City of Rhodes","1998","Cultural",  "greece_rhodes"));
			items.add(new HeritageEntryItem("Monasteries of Daphni, Hosios Loukas and Nea Moni of Chios","1990","Cultural",  "greece_daphni"));
			items.add(new HeritageEntryItem("Old Town of Corfu","2007","Cultural",  "greece_corfu"));
			items.add(new HeritageEntryItem("Paleochristian and Byzantine Monuments of Thessalonika","1988","Cultural",  "greece_paleo"));
			items.add(new HeritageEntryItem("Pythagoreion and Heraion of Samos","1992","Cultural",  "greece_pytha"));
			items.add(new HeritageEntryItem("Sanctuary of Asklepios at Epidaurus ","1988","Cultural",  "greece_askle"));
			items.add(new HeritageEntryItem("Temple of Apollo Epicurius at Bassae","1986","Cultural",  "greece_bassae"));
			items.add(new HeritageEntryItem("The Historic Centre (Chora) with the Monastery of Saint-John the Theologian and the Cave of the Apocalypse on the Island of Patmos ","1999","Cultural",  "greece_chora"));
			items.add(new HeritageEntryItem("Meteora","1988","Mixed",  "greece_meteora"));
			items.add(new HeritageEntryItem("Mount Athos","1988","Mixed",  "greece_athos"));

			mHTitle.setText("Greece");			
		} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 3)
				&& (((HeritageDetailActivity) getActivity()).getRegionId() == 3)
				&& (((HeritageDetailActivity) getActivity()).getCountryId() == 6)){
			items.add(new HeritageEntryItem("Vatican City","1984","Cultural",  "holy_vatican"));
			items.add(new HeritageEntryItem("Historic Centre of Rome, the Properties of the Holy See in that City Enjoying Extraterritorial Rights and San Paolo Fuori le Mura","1980","Cultural",  "holy_rome"));

			mHTitle.setText("Holy See");			
		} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 3)
				&& (((HeritageDetailActivity) getActivity()).getRegionId() == 3)
				&& (((HeritageDetailActivity) getActivity()).getCountryId() == 7)){
items.add(new HeritageEntryItem("18th-Century Royal Palace at Caserta with the Park, the Aqueduct of Vanvitelli, and the San Leucio Complex ","1997","Cultural",  "italy_caserta"));
items.add(new HeritageEntryItem("Sacri Monti of Piedmont and Lombardy","2003","Cultural",  "italy_sacri"));
items.add(new HeritageEntryItem("Archaeological Area and the Patriarchal Basilica of Aquileia","1998","Cultural",  "italy_aqui"));
items.add(new HeritageEntryItem("Archaeological Area of Agrigento","1997","Cultural",  "italy_agri"));
items.add(new HeritageEntryItem("Archaeological Areas of Pompei, Herculaneum and Torre Annunziata ","1997","Cultural",  "italy_pompei"));
items.add(new HeritageEntryItem("Assisi, the Basilica of San Francesco and Other Franciscan Sites","2000","Cultural",  "italy_assisi"));
items.add(new HeritageEntryItem("Botanical Garden (Orto Botanico), Padua","1997","Cultural",  "italy_padua"));
items.add(new HeritageEntryItem("Castel del Monte","1996","Cultural",  "italy_monte"));
items.add(new HeritageEntryItem("Cathedral, Torre Civica and Piazza Grande, Modena","1997","Cultural",  "italy_modena"));
items.add(new HeritageEntryItem("Church and Dominican Convent of Santa Maria delle Grazie with ìThe Last Supperî by Leonardo da Vinci","1980","Cultural",  "italy_supper"));
items.add(new HeritageEntryItem("Cilento and Vallo di Diano National Park with the Archeological Sites of Paestum and Velia, and the Certosa di Padula","1998","Cultural",  "italy_cliento"));
items.add(new HeritageEntryItem("City of Verona","2000","Cultural",  "italy_verona"));
items.add(new HeritageEntryItem("City of Vicenza and the Palladian Villas of the Veneto","1994","Cultural",  "italy_vicenza"));
items.add(new HeritageEntryItem("Costiera Amalfitana","1997","Cultural",  "italy_amalfi"));
items.add(new HeritageEntryItem("Crespi d'Adda","1995","Cultural",  "italy_crespi"));
items.add(new HeritageEntryItem("Early Christian Monuments of Ravenna","1996","Cultural",  "italy_ravenna"));
items.add(new HeritageEntryItem("Etruscan Necropolises of Cerveteri and Tarquinia","2004","Cultural",  "italy_etru"));
items.add(new HeritageEntryItem("Ferrara, City of the Renaissance, and its Po Delta","1995","Cultural",  "italy_ferr"));
items.add(new HeritageEntryItem("Genoa: Le Strade Nuove and the system of the Palazzi dei Rolli ","2006","Cultural",  "italy_genoa"));
items.add(new HeritageEntryItem("Historic Centre of Florence","1982","Cultural",  "italy_flo"));
items.add(new HeritageEntryItem("Historic Centre of Naples","1995","Cultural",  "italy_naples"));
items.add(new HeritageEntryItem("Historic Centre of Rome, the Properties of the Holy See in that City Enjoying Extraterritorial Rights and San Paolo Fuori le Mura","1980","Cultural",  "holy_rome"));
items.add(new HeritageEntryItem("Historic Centre of San Gimignano ","1990","Cultural",  "italy_gimi"));
items.add(new HeritageEntryItem("Historic Centre of Siena","1995","Cultural",  "italy_siena"));
items.add(new HeritageEntryItem("Historic Centre of the City of Pienza","1996","Cultural",  "italy_pienza"));
items.add(new HeritageEntryItem("Historic Centre of Urbino ","1998","Cultural",  "italy_urbino"));
items.add(new HeritageEntryItem("Late Baroque Towns of the Val di Noto (South-Eastern Sicily)","2002","Cultural",  "italy_noto"));
items.add(new HeritageEntryItem("Longobards in Italy. Places of the Power (568-774 A.D.) ","2011","Cultural",  "italy_longo"));
items.add(new HeritageEntryItem("Mantua and Sabbioneta","2008","Cultural",  "italy_mantua"));
items.add(new HeritageEntryItem("Medici Villas and Gardens in Tuscany","2013","Cultural",  "italy_medici"));
items.add(new HeritageEntryItem("Piazza del Duomo, Pisa","1987","Cultural",  "italy_pisa"));
items.add(new HeritageEntryItem("Portovenere, Cinque Terre, and the Islands (Palmaria, Tino and Tinetto) ","1997","Cultural",  "italy_palma"));
items.add(new HeritageEntryItem("Prehistoric Pile dwellings around the Alps","2011","Cultural",  "swiss_alps"));
items.add(new HeritageEntryItem("Residences of the Royal House of Savoy ","1997","Cultural",  "italy_savoy"));
items.add(new HeritageEntryItem("Rhaetian Railway in the Albula / Bernina Landscapes","2008","Cultural",  "italy_railway"));
items.add(new HeritageEntryItem("Rock Drawings in Valcamonica ","1979","Cultural",  "italy_rock"));
items.add(new HeritageEntryItem("Su Nuraxi di Barumini","1997","Cultural",  "italy_su"));
items.add(new HeritageEntryItem("Syracuse and the Rocky Necropolis of Pantalica ","2005","Cultural",  "italy_syracuse"));
items.add(new HeritageEntryItem("The Trulli of Alberobello ","1996","Cultural",  "italy_trulli"));
items.add(new HeritageEntryItem("The Sassi and the Park of the Rupestrian Churches of Matera","1993","Cultural",  "italy_sassi"));
items.add(new HeritageEntryItem("Val d'Orcia","2004","Cultural",  "italy_val"));
items.add(new HeritageEntryItem("Venice and its Lagoon ","1987","Cultural",  "italy_venice"));
items.add(new HeritageEntryItem("Villa Adriana (Tivoli)","1999","Cultural",  "italy_tivoli"));
items.add(new HeritageEntryItem("Villa d'Este, Tivoli ","2001","Cultural",  "italy_tivoli2"));
items.add(new HeritageEntryItem("Villa Romana del Casale","1997","Cultural",  "italy_romana"));
items.add(new HeritageEntryItem("Vineyard Landscape of Piedmont: Langhe-Roero and Monferrato","2014","Cultural",  "italy_pied"));
items.add(new HeritageEntryItem("Isole Eolie (Aeolian Islands)","2000","Natural",  "italy_aeo"));
items.add(new HeritageEntryItem("Monte San Giorgio","2003","Natural",  "italy_gio"));
items.add(new HeritageEntryItem("Mount Etna","2013","Natural",  "italy_etna"));
items.add(new HeritageEntryItem("The Dolomites","2009","Natural",  "italy_dolo"));

			mHTitle.setText("Italy");			
		}  else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 3)
				&& (((HeritageDetailActivity) getActivity()).getRegionId() == 3)
				&& (((HeritageDetailActivity) getActivity()).getCountryId() == 8)){
			items.add(new HeritageEntryItem("Natural and Cultural Heritage of the Ohrid region","1979","Mixed",  "mace_01"));

			mHTitle.setText("Macedonia");			
		} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 3)
				&& (((HeritageDetailActivity) getActivity()).getRegionId() == 3)
				&& (((HeritageDetailActivity) getActivity()).getCountryId() == 9)){
			items.add(new HeritageEntryItem("City of Valletta","1980","Cultural",  "malta_val"));
			items.add(new HeritageEntryItem("Megalithic Temples of Malta","1980","Cultural",  "malta_mega"));
			items.add(new HeritageEntryItem("Hal Saflieni Hypogeum","1980","Cultural",  "malta_hal"));

			mHTitle.setText("Malta");			
		} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 3)
				&& (((HeritageDetailActivity) getActivity()).getRegionId() == 3)
				&& (((HeritageDetailActivity) getActivity()).getCountryId() == 10)){
			items.add(new HeritageEntryItem("Natural and Culturo-Historical Region of Kotor","1979","Cultural",  "monte_kotor"));
			items.add(new HeritageEntryItem("Durmitor National Park","1980","Natural",  "monte_dur"));

			mHTitle.setText("Montenegro");			
		} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 3)
				&& (((HeritageDetailActivity) getActivity()).getRegionId() == 3)
				&& (((HeritageDetailActivity) getActivity()).getCountryId() == 11)){
			items.add(new HeritageEntryItem("Alto Douro Wine Region ","2001","Cultural",  "por_wine"));
items.add(new HeritageEntryItem("Central Zone of the Town of Angra do Heroismo in the Azores","1983","Cultural",  "por_azo"));
items.add(new HeritageEntryItem("Convent of Christ in Tomar","1983","Cultural",  "por_tomar"));
items.add(new HeritageEntryItem("Cultural Landscape of Sintra","1995","Cultural",  "por_sintra"));
items.add(new HeritageEntryItem("Garrison Border Town of Elvas and its Fortifications ","2012","Cultural",  "por_elvas"));
items.add(new HeritageEntryItem("Historic Centre of Evora","1986","Cultural",  "por_evora"));
items.add(new HeritageEntryItem("Historic Centre of Guimaraes","2001","Cultural",  "por_gui"));
items.add(new HeritageEntryItem("Historic Centre of Oporto ","1996","Cultural",  "por_oporto"));
items.add(new HeritageEntryItem("Landscape of the Pico Island Vineyard Culture ","2004","Cultural",  "por_pico"));
items.add(new HeritageEntryItem("Monastery of Alcobaca ","1989","Cultural",  "por_alco"));
items.add(new HeritageEntryItem("Monastery of Batalha","1983","Cultural",  "por_bata"));
items.add(new HeritageEntryItem("Monastery of the Hieronymites and Tower of Belem in Lisbon","1983","Cultural",  "por_lisbon"));
items.add(new HeritageEntryItem("Prehistoric Rock Art Sites in the Coa Valley and Siega Verde","2013","Cultural",  "por_pre"));
items.add(new HeritageEntryItem("University of Coimbra - Alta and Sofia ","2013","Cultural",  "por_univ"));
items.add(new HeritageEntryItem("Laurisilva of Madeira ","1999","Natural",  "por_lau"));

			mHTitle.setText("Portugal");			
		} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 3)
				&& (((HeritageDetailActivity) getActivity()).getRegionId() == 3)
				&& (((HeritageDetailActivity) getActivity()).getCountryId() == 12)){
			items.add(new HeritageEntryItem("San Marino Historic Centre and Mount Titano","2008","Cultural",  "sanmarino_01"));

			mHTitle.setText("San Marino");			
		} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 3)
				&& (((HeritageDetailActivity) getActivity()).getRegionId() == 3)
				&& (((HeritageDetailActivity) getActivity()).getCountryId() == 13)){
			items.add(new HeritageEntryItem("Gamzigrad-Romuliana, Palace of Galerius","2007","Cultural",  "ser_gam"));
			items.add(new HeritageEntryItem("Medieval Monuments in Kosovo","2004","Cultural",  "ser_kosovo"));
			items.add(new HeritageEntryItem("Stari Ras and Sopocani","1979","Cultural",  "ser_stari"));
			items.add(new HeritageEntryItem("Studenica Monastery","1986","Cultural",  "ser_stu"));

			mHTitle.setText("Serbia");			
		} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 3)
				&& (((HeritageDetailActivity) getActivity()).getRegionId() == 3)
				&& (((HeritageDetailActivity) getActivity()).getCountryId() == 14)){
			items.add(new HeritageEntryItem("Heritage of Mercury. Almaden and Idrija ","2012","Cultural",  "slo_mercury"));
			items.add(new HeritageEntryItem("Prehistoric Pile dwellings around the Alps","2011","Cultural",  "swiss_alps"));
			items.add(new HeritageEntryItem("Skocjan Caves","1986","Natural",  "slo_cave"));

			mHTitle.setText("Slovenia");			
		} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 3)
				&& (((HeritageDetailActivity) getActivity()).getRegionId() == 3)
				&& (((HeritageDetailActivity) getActivity()).getCountryId() == 15)){
			items.add(new HeritageEntryItem("Alhambra, Generalife and Albayzin, Granada","1984","Cultural",  "spain_alham"));
items.add(new HeritageEntryItem("Aranjuez Cultural Landscape ","2001","Cultural",  "spain_aran"));
items.add(new HeritageEntryItem("Archaeological Ensemble of Merida ","1993","Cultural",  "spain_merida"));
items.add(new HeritageEntryItem("Archaeological Ensemble of Tarraco","2000","Cultural",  "spain_tarraco"));
items.add(new HeritageEntryItem("Archaeological Site of Atapuerca ","2000","Cultural",  "spain_ata"));
items.add(new HeritageEntryItem("Burgos Cathedral ","1984","Cultural",  "spain_burgos"));
items.add(new HeritageEntryItem("Catalan Romanesque Churches of the Vall de Boi","2000","Cultural",  "spain_catalan"));
items.add(new HeritageEntryItem("Cathedral, Alcazar and Archivo de Indias in Seville","1987","Cultural",  "spain_seville"));
items.add(new HeritageEntryItem("Cave of Altamira and Paleolithic Cave Art of Northern Spain ","1985","Cultural",  "spain_cave"));
items.add(new HeritageEntryItem("Cultural Landscape of the Serra de Tramuntana","2011","Cultural",  "spain_serra"));
items.add(new HeritageEntryItem("Heritage of Mercury. Almaden and Idrija","2012","Cultural",  "slo_mercury"));
items.add(new HeritageEntryItem("Historic Centre of Cordoba","1984","Cultural",  "spain_cordoba"));
items.add(new HeritageEntryItem("Historic City of Toledo","1986","Cultural",  "spain_toledo"));
items.add(new HeritageEntryItem("Historic Walled Town of Cuenca","1996","Cultural",  "spain_cuenca"));
items.add(new HeritageEntryItem("La Lonja de la Seda de Valencia","1996","Cultural",  "spain_valencia"));
items.add(new HeritageEntryItem("Las Medulas","1997","Cultural",  "spain_medulas"));
items.add(new HeritageEntryItem("Monastery and Site of the Escurial, Madrid","1984","Cultural",  "spain_escu"));
items.add(new HeritageEntryItem("Monuments of Oviedo and the Kingdom of the Asturias","1985","Cultural",  "spain_oviedo"));
items.add(new HeritageEntryItem("Mudejar Architecture of Aragon","1986","Cultural",  "spain_aragon"));
items.add(new HeritageEntryItem("Old City of Salamanca","1988","Cultural",  "spain_sala"));
items.add(new HeritageEntryItem("Old Town of Avila with its Extra-Muros Churches ","1985","Cultural",  "spain_avila"));
items.add(new HeritageEntryItem("Old Town of Caceres ","1986","Cultural",  "spain_cace"));
items.add(new HeritageEntryItem("Old Town of Segovia and its Aqueduct","1985","Cultural",  "spain_sego"));
items.add(new HeritageEntryItem("Palau de la Musica Catalana and Hospital de Sant Pau, Barcelona","1997","Cultural",  "spain_bcn"));
items.add(new HeritageEntryItem("Palmeral of Elche","2000","Cultural",  "spain_elche"));
items.add(new HeritageEntryItem("Poblet Monastery ","1991","Cultural",  "spain_poblet"));
items.add(new HeritageEntryItem("Prehistoric Rock Art Sites in the Coa Valley and Siega Verde","1998","Cultural",  "por_pre"));
items.add(new HeritageEntryItem("Renaissance Monumental Ensembles of Ubeda and Baeza ","2003","Cultural",  "spain_ubeda"));
items.add(new HeritageEntryItem("Rock Art of the Mediterranean Basin on the Iberian Peninsula","1998","Cultural",  "spain_rock"));
items.add(new HeritageEntryItem("Roman Walls of Lugo","2000","Cultural",  "spain_lugo"));
items.add(new HeritageEntryItem("Route of Santiago de Compostela","1993","Cultural",  "spain_route"));
items.add(new HeritageEntryItem("Royal Monastery of Santa MarÌa de Guadalupe","1993","Cultural",  "spain_guada"));
items.add(new HeritageEntryItem("San Cristobal de La Laguna","1999","Cultural",  "spain_cris"));
items.add(new HeritageEntryItem("San Mill·n Yuso and Suso Monasteries","1997","Cultural",  "spain_millan"));
items.add(new HeritageEntryItem("Santiago de Compostela (Old Town)","1985","Cultural",  "spain_oldtown"));
items.add(new HeritageEntryItem("Tower of Hercules","2009","Cultural",  "spain_her"));
items.add(new HeritageEntryItem("University and Historic Precinct of Alcal· de Henares","1998","Cultural",  "spain_alcala"));
items.add(new HeritageEntryItem("Vizcaya Bridge","2006","Cultural",  "spain_viz"));
items.add(new HeritageEntryItem("Works of Antoni Gaudi","1984","Cultural",  "spain_gaudi"));
items.add(new HeritageEntryItem("Donana National Park ","1994","Natural",  "spain_donana"));
items.add(new HeritageEntryItem("Garajonay National Park ","1986","Natural",  "spain_gara"));
items.add(new HeritageEntryItem("Teide National Park","2007","Natural",  "spain_teide"));
items.add(new HeritageEntryItem("Ibiza, Biodiversity and Culture","1999","Mixed",  "spain_ibiza"));
items.add(new HeritageEntryItem("Pyrenees - Mont Perdu","1997","Mixed",  "spain_perdu"));

			mHTitle.setText("Spain");			
		} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 3)
				&& (((HeritageDetailActivity) getActivity()).getRegionId() == 4)
				&& (((HeritageDetailActivity) getActivity()).getCountryId() == 0)){
		
items.add(new HeritageEntryItem("Belfries of Belgium and France","1999","Cultural",  "belgium_bel"));
items.add(new HeritageEntryItem("Flemish Beguinages","1998","Cultural",  "belgium_fle"));
items.add(new HeritageEntryItem("Historic Centre of Brugge","2000","Cultural",  "belgium_brug"));
items.add(new HeritageEntryItem("La Grand-Place, Brussels","1998","Cultural",  "belgium_brus"));
items.add(new HeritageEntryItem("Major Mining Sites of Wallonia","2012","Cultural",  "belgium_wallo"));
items.add(new HeritageEntryItem("Major Town Houses of the Architect Victor Horta (Brussels)","2000","Cultural",  "belgium_town"));
items.add(new HeritageEntryItem("Neolithic Flint Mines at Spiennes (Mons)","2000","Cultural",  "belgium_mons"));
items.add(new HeritageEntryItem("Notre-Dame Cathedral in Tournai","2000","Cultural",  "belgium_tour"));
items.add(new HeritageEntryItem("Plantin-Moretus House-Workshops-Museum Complex","2005","Cultural",  "belgium_plant"));
items.add(new HeritageEntryItem("Stoclet House ","2009","Cultural",  "belgium_stoc"));
items.add(new HeritageEntryItem("The Four Lifts on the Canal du Centre and their Environs, La Louviere and Le Roeulx (Hainaut)","1998","Cultural",  "belgium_hai"));

			mHTitle.setText("Belgium");			
		} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 3)
				&& (((HeritageDetailActivity) getActivity()).getRegionId() == 4)
				&& (((HeritageDetailActivity) getActivity()).getCountryId() == 1)){
			
			items.add(new HeritageEntryItem("Abbey Church of Saint-Savin sur Gartempe ","1983","Cultural",  "fra_abbey"));
			items.add(new HeritageEntryItem("Amiens Cathedral ","1981","Cultural",  "fra_amiens"));
			items.add(new HeritageEntryItem("Arles, Roman and Romanesque Monuments","1981","Cultural",  "fra_arles"));
			items.add(new HeritageEntryItem("Belfries of Belgium and France ","1999","Cultural",  "belgium_bel"));
			items.add(new HeritageEntryItem("Bordeaux, Port of the Moon ","2007","Cultural",  "fra_bor"));

items.add(new HeritageEntryItem("Bourges Cathedral ","1992","Cultural",  "fra_bou"));
items.add(new HeritageEntryItem("Canal du Midi ","1996","Cultural",  "fra_midi"));
items.add(new HeritageEntryItem("Cathedral of Notre-Dame, Former Abbey of Saint-RÈmi and Palace of Tau, Reims ","1991","Cultural",  "fra_reims"));
items.add(new HeritageEntryItem("Chartres Cathedral ","1979","Cultural",  "fra_char"));
items.add(new HeritageEntryItem("Cistercian Abbey of Fontenay ","1981","Cultural",  "fra_font"));

items.add(new HeritageEntryItem("Decorated Cave of Pont d'Arc, known as Grotte Chauvet-Pont d'Arc, Ardeche ","2014","Cultural",  "fra_arde"));
items.add(new HeritageEntryItem("Episcopal City of Albi ","2010","Cultural",  "fra_albi"));
items.add(new HeritageEntryItem("Fortifications of Vauban ","2008","Cultural",  "fra_vau"));
items.add(new HeritageEntryItem("From the Great Saltworks of Salins-les-Bains to the Royal Saltworks of Arc-et-Senans, the Production of Open-pan Salt ","1982","Cultural",  "fra_salt"));
items.add(new HeritageEntryItem("Historic Centre of Avignon: Papal Palace, Episcopal Ensemble and Avignon Bridge ","1995","Cultural",  "fra_avig"));

			items.add(new HeritageEntryItem("Historic Fortified City of Carcassonne","1997","Cultural",  "fra_carca"));
			items.add(new HeritageEntryItem("Historic Site of Lyons ","1998","Cultural",  "fra_lyon"));
			items.add(new HeritageEntryItem("Jurisdiction of Saint-Emilion ","1999","Cultural",  "fra_emil"));
			items.add(new HeritageEntryItem("Le Havre, the City Rebuilt by Auguste Perret","2005","Cultural",  "fra_havre"));
			items.add(new HeritageEntryItem("Mont-Saint-Michel and its Bay","1979","Cultural",  "fra_michel"));

			items.add(new HeritageEntryItem("Nord-Pas de Calais Mining Basin  ","2012","Cultural",  "fra_calais"));
			items.add(new HeritageEntryItem("Palace and Park of Fontainebleau ","1981","Cultural",  "fra_bleau"));
			items.add(new HeritageEntryItem("Palace and Park of Versailles ","1979","Cultural",  "fra_versa"));
			items.add(new HeritageEntryItem("Paris, Banks of the Seine ","1991","Cultural",  "fra_paris"));
			items.add(new HeritageEntryItem("Place Stanislas, Place de la Carrière and Place d'Alliance in Nancy ","1983","Cultural",  "fra_nancy"));
			
			items.add(new HeritageEntryItem("Pont du Gard (Roman Aqueduct) ","1985","Cultural",  "fra_pont"));
			items.add(new HeritageEntryItem("Prehistoric Pile dwellings around the Alps ","2011","Cultural",  "swiss_alps"));
			items.add(new HeritageEntryItem("Prehistoric Sites and Decorated Caves of the Vézère Valley ","1979","Cultural",  "fra_pre"));
			items.add(new HeritageEntryItem("Provins, Town of Medieval Fairs ","2001","Cultural",  "fra_provins"));
			items.add(new HeritageEntryItem("Roman Theatre and its Surroundings and the \"Triumphal Arch\" of Orange","1981","Cultural",  "fra_roman"));
			
			items.add(new HeritageEntryItem("Routes of Santiago de Compostela in France ","1998","Cultural",  "fra_santia"));
			items.add(new HeritageEntryItem("Strasbourg – Grande île  ","1988","Cultural",  "fra_stras"));
			items.add(new HeritageEntryItem("The Causses and the Cévennes, Mediterranean agro-pastoral Cultural Landscape","2011","Cultural",  "fra_ceven"));
			items.add(new HeritageEntryItem("The Loire Valley between Sully-sur-Loire and Chalonnes ","2000","Cultural",  "fra_loire"));
			items.add(new HeritageEntryItem("Vézelay, Church and Hill ","1979","Cultural",  "fra_veze"));
			
			items.add(new HeritageEntryItem("Gulf of Porto: Calanche of Piana, Gulf of Girolata, Scandola Reserve ","1983","Natural",  "fra_porto"));
			items.add(new HeritageEntryItem("Lagoons of New Caledonia: Reef Diversity and Associated Ecosystems ","2008","Natural",  "fra_lag"));
			items.add(new HeritageEntryItem("Pitons, cirques and remparts of Reunion Island ","2010","Natural",  "fra_reu"));
			items.add(new HeritageEntryItem("Pyrénées - Mont Perdu ","1997","Mixed",  "spain_perdu"));
			
			mHTitle.setText("France");			
		} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 3)
				&& (((HeritageDetailActivity) getActivity()).getRegionId() == 4)
				&& (((HeritageDetailActivity) getActivity()).getCountryId() == 2)){
			items.add(new HeritageEntryItem("Archaeological Ensemble of the Bend of the Boyne","1993","Cultural",  "ire_bru"));
items.add(new HeritageEntryItem("Sceilg Mhichil","1996","Cultural",  "ire_rock"));

			mHTitle.setText("Ireland");			
		} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 3)
				&& (((HeritageDetailActivity) getActivity()).getRegionId() == 4)
				&& (((HeritageDetailActivity) getActivity()).getCountryId() == 3)){
			items.add(new HeritageEntryItem("City of Luxembourg: its Old Quarters and Fortifications","1994","Cultural",  "lux_city"));

			mHTitle.setText("Luxembourg");			
		} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 3)
				&& (((HeritageDetailActivity) getActivity()).getRegionId() == 4)
				&& (((HeritageDetailActivity) getActivity()).getCountryId() == 4)){
			items.add(new HeritageEntryItem("Defence Line of Amsterdam ","1996","Cultural",  "nether_ams"));
items.add(new HeritageEntryItem("Droogmakerij de Beemster (Beemster Polder)","1999","Cultural",  "nether_polder"));
items.add(new HeritageEntryItem("Historic Area of Willemstad, Inner City and Harbour, Curacao","1997","Cultural",  "nether_cura"));
items.add(new HeritageEntryItem("Ir.D.F. Woudagemaal (D.F. Wouda Steam Pumping Station)","1998","Cultural",  "nether_df"));
items.add(new HeritageEntryItem("Mill Network at Kinderdijk-Elshout","1997","Cultural",  "nether_mill"));
items.add(new HeritageEntryItem("Rietveld Schroderhuis (Rietveld Schrˆder House)","2000","Cultural",  "nether_riet"));
items.add(new HeritageEntryItem("Schokland and Surroundings","1995","Cultural",  "nether_schok"));
items.add(new HeritageEntryItem("Seventeenth-Century Canal Ring Area of Amsterdam inside the Singelgracht","2010","Cultural",  "nether_canal"));
items.add(new HeritageEntryItem("Van Nellefabriek ","2014","Cultural",  "nether_van"));
items.add(new HeritageEntryItem("Wadden Sea ","2009","Natural",  "ger_wadden"));

			mHTitle.setText("Netherlands");			
		} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 3)
				&& (((HeritageDetailActivity) getActivity()).getRegionId() == 4)
				&& (((HeritageDetailActivity) getActivity()).getCountryId() == 5)){
			items.add(new HeritageEntryItem("Blaenavon Industrial Landscape ","2000","Cultural",  "uk_blaen"));
items.add(new HeritageEntryItem("Blenheim Palace","1987","Cultural",  "uk_blen"));
items.add(new HeritageEntryItem("Canterbury Cathedral, St Augustine's Abbey, and St Martin's Church ","1988","Cultural",  "uk_canter"));
items.add(new HeritageEntryItem("Castles and Town Walls of King Edward in Gwynedd ","1986","Cultural",  "uk_gwy"));
items.add(new HeritageEntryItem("City of Bath","1987","Cultural",  "uk_bath"));
items.add(new HeritageEntryItem("Cornwall and West Devon Mining Landscape","2006","Cultural",  "uk_cornwall"));
items.add(new HeritageEntryItem("Derwent Valley Mills","2001","Cultural",  "uk_derwent"));
items.add(new HeritageEntryItem("Durham Castle and Cathedral ","1986","Cultural",  "uk_durham"));
items.add(new HeritageEntryItem("Frontiers of the Roman Empire","1987","Cultural",  "ger_frontier"));
items.add(new HeritageEntryItem("Heart of Neolithic Orkney","1999","Cultural",  "uk_ork"));
items.add(new HeritageEntryItem("Historic Town of St George and Related Fortifications, Bermuda ","2000","Cultural",  "uk_bermuda"));
items.add(new HeritageEntryItem("Ironbridge Gorge","1986","Cultural",  "uk_ironb"));
items.add(new HeritageEntryItem("Liverpool ñ Maritime Mercantile City","2004","Cultural",  "uk_liver"));
items.add(new HeritageEntryItem("Maritime Greenwich","1997","Cultural",  "uk_greenwich"));
items.add(new HeritageEntryItem("New Lanark","2001","Cultural",  "uk_lana"));
items.add(new HeritageEntryItem("Old and New Towns of Edinburgh","1995","Cultural",  "uk_edin"));
items.add(new HeritageEntryItem("Palace of Westminster and Westminster Abbey including Saint Margaretís Church ","1987","Cultural",  "uk_palace"));
items.add(new HeritageEntryItem("Pontcysyllte Aqueduct and Canal","2009","Cultural",  "uk_canal"));
items.add(new HeritageEntryItem("Royal Botanic Gardens, Kew","2003","Cultural",  "uk_kew"));
items.add(new HeritageEntryItem("Saltaire","2001","Cultural",  "uk_salt"));
items.add(new HeritageEntryItem("Stonehenge, Avebury and Associated Sites","1986","Cultural",  "uk_stone"));
items.add(new HeritageEntryItem("Studley Royal Park including the Ruins of Fountains Abbey","1986","Cultural",  "uk_ruins"));
items.add(new HeritageEntryItem("Tower of London ","1988","Cultural",  "uk_tower"));

			items.add(new HeritageEntryItem("Dorset and East Devon Coast ","2001","Natural",  "uk_dor"));
			items.add(new HeritageEntryItem("Giant's Causeway and Causeway Coast","1986","Natural",  "uk_giant"));
			items.add(new HeritageEntryItem("Gough and Inaccessible Islands","1995","Natural",  "uk_gough"));
			items.add(new HeritageEntryItem("Henderson Island ","1988","Natural",  "uk_hen"));
			items.add(new HeritageEntryItem("St Kilda","1986","Mixed",  "uk_kilda"));

			mHTitle.setText("United Kingdom");			
		}  else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 4)
				&& (((HeritageDetailActivity) getActivity()).getRegionId() == 0)
				&& (((HeritageDetailActivity) getActivity()).getCountryId() == 0)){
			items.add(new HeritageEntryItem("Australian Convict Sites ","2010","Cultural",  "aus_convict"));
			items.add(new HeritageEntryItem("Royal Exhibition Building and Carlton Gardens","2004","Cultural",  "aus_roy"));
			items.add(new HeritageEntryItem("Sydney Opera House","2007","Cultural",  "aus_opera"));
			
			items.add(new HeritageEntryItem("Australian Fossil Mammal Sites (Riversleigh / Naracoorte)","1994","Natural",  "aus_fossil"));
			items.add(new HeritageEntryItem("Fraser Island ","1992","Natural",  "aus_fraser"));
			items.add(new HeritageEntryItem("Gondwana Rainforests of Australia","1986","Natural",  "aus_gond"));
			items.add(new HeritageEntryItem("Great Barrier Reef ","1981","Natural",  "aus_reef"));
			items.add(new HeritageEntryItem("Greater Blue Mountains Area","2000","Natural",  "aus_blue"));
			
			items.add(new HeritageEntryItem("Heard and McDonald Islands","1997","Natural",  "aus_heard"));
			items.add(new HeritageEntryItem("Lord Howe Island Group","1982","Natural",  "aus_howe"));
			items.add(new HeritageEntryItem("Macquarie Island","1997","Natural",  "aus_mac"));
			items.add(new HeritageEntryItem("Ningaloo Coast","2011","Natural",  "aus_ning"));
			items.add(new HeritageEntryItem("Purnululu National Park","2003","Natural",  "aus_pur"));
			
			items.add(new HeritageEntryItem("Shark Bay, Western Australia","1991","Natural",  "aus_shark"));
			items.add(new HeritageEntryItem("Wet Tropics of Queensland","1988","Natural",  "aus_wet"));
			
			items.add(new HeritageEntryItem("Kakadu National Park ","1981","Mixed",  "aus_kaka"));
			items.add(new HeritageEntryItem("Tasmanian Wilderness ","1982","Mixed",  "aus_tas"));
			items.add(new HeritageEntryItem("Uluru-Kata Tjuta National Park","1987","Mixed",  "aus_uluru"));
			items.add(new HeritageEntryItem("Willandra Lakes Region","1981","Mixed",  "aus_will"));		

			mHTitle.setText("Australia");	
		} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 4)
				&& (((HeritageDetailActivity) getActivity()).getRegionId() == 0)
				&& (((HeritageDetailActivity) getActivity()).getCountryId() == 1)){
			items.add(new HeritageEntryItem("New Zealand Sub-Antarctic Islands","1998","Natural",  "nz_ant"));
items.add(new HeritageEntryItem("Te Wahipounamu ñ South West New Zealand","1990","Natural",  "nz_te"));
items.add(new HeritageEntryItem("Tongariro National Park","1990","Mixed",  "nz_ton"));

			mHTitle.setText("New Zealand");	
		} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 4)
				&& (((HeritageDetailActivity) getActivity()).getRegionId() == 1)
				&& (((HeritageDetailActivity) getActivity()).getCountryId() == 0)){
			items.add(new HeritageEntryItem("Levuka Historical Port Town","2013","Cultural",  "fiji_01"));

			mHTitle.setText("Fiji");	
		} else if ((((HeritageDetailActivity) getActivity()).getContinentId() == 4)
				&& (((HeritageDetailActivity) getActivity()).getRegionId() == 1)
				&& (((HeritageDetailActivity) getActivity()).getCountryId() == 1)){
			items.add(new HeritageEntryItem("Phoenix Islands Protected Area","2010","Natural",  "kiri_01"));

			mHTitle.setText("Kiribati");	
		}
	
	}
}
