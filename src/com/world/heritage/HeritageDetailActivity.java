package com.world.heritage;

import java.util.ArrayList;
import java.util.List;

import com.world.heritage.R;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v7.app.ActionBarActivity;
import android.app.ActionBar;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.TabHost.OnTabChangeListener;


public class HeritageDetailActivity extends FragmentActivity implements OnTabChangeListener, OnPageChangeListener  {
	private int HEIGHT = 62;
    private ViewPager mViewPager;
	private MyPageAdapter pageAdapter;
	private TabHost mTabHost;
	public long mRegionId;
	private long mContinentId;
	private long mCountryId;
	public static FragmentManager fragmentManager;
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
	    if (savedInstanceState != null) {
	        //savedInstanceState.remove("android:support:fragments");
	        //savedInstanceState.remove("com.google.android.gms.maps.SupportMapFragment");
	    }
        setContentView(R.layout.activity_main);
        Bundle extras = getIntent().getExtras();
   	 
		if (extras != null) {
			mCountryId = extras.getLong("country_id");
			mRegionId = extras.getLong("region_id");	
			mContinentId = extras.getLong("continent_id");
		}
		
        
		final ActionBar actionBar = getActionBar();
		if (actionBar != null) {
			actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#3A456E")));
			actionBar.setTitle(this.getResources().getString(R.string.heritage_text));
			actionBar.setDisplayHomeAsUpEnabled(true);
			if (ContinentActivity.mFbUsername != null)
				actionBar.setTitle(this.getResources().getString(R.string.heritage_text) + " (Logged in as " + ContinentActivity.mFbUsername + ")");	
			
		}
		
		// initialising the object of the FragmentManager. Here I'm passing getSupportFragmentManager(). You can pass getFragmentManager() if you are coding for Android 3.0 or above.
	    fragmentManager = getSupportFragmentManager();
	    
	    int screenSize = this.getResources().getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_NORMAL;
	    if (screenSize == Configuration.SCREENLAYOUT_SIZE_NORMAL)
	    	HEIGHT = 72;
	    else
	    	HEIGHT = 62;
    }

	@Override
	protected void onResume() {
		super.onResume();
	    mViewPager = (ViewPager) findViewById(R.id.viewpager);
		// Tab Initialization
		initialiseTabHost();
	
		// Fragments and ViewPager Initialization
		List<Fragment> fragments = getFragments();
		pageAdapter = new MyPageAdapter(getSupportFragmentManager(), fragments);
		if (mViewPager != null && pageAdapter != null) {
			mViewPager.setAdapter(pageAdapter);
			mViewPager.setOnPageChangeListener(HeritageDetailActivity.this);
		}
	}
	
	// Method to add a TabHost
	private static void AddTab(HeritageDetailActivity activity, TabHost tabHost,
			TabHost.TabSpec tabSpec) {
		tabSpec.setContent(new TabFactory(activity));
		tabHost.addTab(tabSpec);
	}

	// Manages the Tab changes, synchronizing it with Pages
	public void onTabChanged(String tag) {
		int pos = this.mTabHost.getCurrentTab();
		this.mViewPager.setCurrentItem(pos);
	}

	// Manages the Page changes, synchronizing it with Tabs
	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {
		int pos = this.mViewPager.getCurrentItem();
		this.mTabHost.setCurrentTab(pos);
	}
	
	@Override
	public void onPageSelected(int arg0) {
	}

	public List<Fragment> getFragments() {
		List<Fragment> fList = new ArrayList<Fragment>();

		// Put here your Fragments
		HeritageDetailFragment f0 = HeritageDetailFragment.newInstance(this.getResources().getString(R.string.show_heritage_text));
		HeritageDetailMapFragment f1 = HeritageDetailMapFragment.newInstance(this.getResources().getString(R.string.show_map_text));
		
		fList.add(f0);
		fList.add(f1);

		return fList;
	}

	// Tabs Creation
	private void initialiseTabHost() {
		if (mTabHost != null)
			mTabHost.clearAllTabs();

		mTabHost = (TabHost) findViewById(android.R.id.tabhost);
		if (mTabHost == null) {
			Toast.makeText(this, "mTabHost null", Toast.LENGTH_SHORT).show();
			return;
		}
		mTabHost.setup();		

		mTabHost.getTabWidget().setBackgroundColor(Color.parseColor("#f4f4f4"));

		// TODO Put here your Tabs
		HeritageDetailActivity.AddTab(this, this.mTabHost, this.mTabHost.newTabSpec("Tab0").setIndicator(this.getResources().getString(R.string.show_heritage_text)));
		HeritageDetailActivity.AddTab(this, this.mTabHost, this.mTabHost.newTabSpec("Tab1").setIndicator(this.getResources().getString(R.string.show_map_text)));
		
		int height = HEIGHT;
		mTabHost.getTabWidget().getChildAt(0).getLayoutParams().height = height;
		mTabHost.getTabWidget().getChildAt(1).getLayoutParams().height = height;
		
		/*
		 * Customizing text for tab ALL & MESSAGES
		 */
		TextView x0 = (TextView) mTabHost.getTabWidget().getChildAt(0).findViewById(android.R.id.title);
		x0.setTypeface(Typeface.SANS_SERIF);
		x0.setTextSize(14);

		TextView x1 = (TextView) mTabHost.getTabWidget().getChildAt(1).findViewById(android.R.id.title);
		x1.setTypeface(Typeface.SANS_SERIF);
		x1.setTextSize(14);
		
		mTabHost.setOnTabChangedListener(this);
	}

	
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.secondary, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_about) {
        	AlertDialog.Builder builder = new AlertDialog.Builder(
        			HeritageDetailActivity.this);
			builder.setTitle(R.string.about_text);
			builder.setMessage(R.string.author_text);
			builder.setPositiveButton(this.getResources().getString(R.string.ok_text),
					new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int which) {
			
				}
			});

			builder.show();
			return super.onOptionsItemSelected(item);         
        } else if (id == android.R.id.home) {
        	onBackPressed();        	
        } else if (id == R.id.action_home) {
        	Intent i = new Intent(HeritageDetailActivity.this, ContinentActivity.class);
        	i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP|Intent.FLAG_ACTIVITY_SINGLE_TOP);
        	startActivity(i);        	
        }
        return super.onOptionsItemSelected(item);
    }
    
    long getCountryId(){
    	return mCountryId;
    }
    
    long getRegionId(){
    	return mRegionId;
    }
    
    long getContinentId(){
    	return mContinentId;
    }

	@Override
	public void onPageScrollStateChanged(int arg0) {
		// TODO Auto-generated method stub
		
	}
}