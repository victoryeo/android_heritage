package com.world.heritage;

import java.util.ArrayList;
import java.util.List;

import com.facebook.AppEventsLogger;
import com.facebook.Session;
import com.facebook.SessionState;
import com.facebook.UiLifecycleHelper;
import com.facebook.model.GraphUser;
import com.world.heritage.R;

import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v7.app.ActionBarActivity;
import android.app.ActionBar;
import android.app.AlertDialog;
import android.support.v4.app.Fragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.TabHost.OnTabChangeListener;


public class ContinentActivity extends FragmentActivity implements OnTabChangeListener, OnPageChangeListener, FBDialogFragment.OnCompleteListener
{
	private static final String TAG = "ContinentActivity";
	
	private int HEIGHT = 62;
    private ViewPager mViewPager;
	private MyPageAdapter pageAdapter;
	private TabHost mTabHost;
	//public static FragmentManager fragmentManager;
	
	public GraphUser user;
    private UiLifecycleHelper uiHelper;
    private Session.StatusCallback callback = new Session.StatusCallback() {
        @Override
        public void call(Session session, SessionState state, Exception exception) {
            
        }
    };

	public static String mFbUsername = null;
    
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
		final ActionBar actionBar = getActionBar();
		if (actionBar != null) {
			actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#3A456E")));
			actionBar.setTitle(this.getResources().getString(R.string.heritage_text));
			
		}
		
		// initialising the object of the FragmentManager. Here I'm passing getSupportFragmentManager(). You can pass getFragmentManager() if you are coding for Android 3.0 or above.
	    //fragmentManager = getSupportFragmentManager();
	    
	    int screenSize = this.getResources().getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_NORMAL;
	    if (screenSize == Configuration.SCREENLAYOUT_SIZE_NORMAL)
	    	HEIGHT = 72;
	    else
	    	HEIGHT = 62;
	    
        uiHelper = new UiLifecycleHelper(this, callback);
        uiHelper.onCreate(savedInstanceState);
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
			mViewPager.setOnPageChangeListener(ContinentActivity.this);
		}
		
	    uiHelper.onResume();
	}
	
	// Method to add a TabHost
	private static void AddTab(ContinentActivity activity, TabHost tabHost,
			TabHost.TabSpec tabSpec) {
		tabSpec.setContent(new TabFactory(activity));
		tabHost.addTab(tabSpec);
	}

	// Manages the Tab changes, synchronizing it with Pages
	public void onTabChanged(String tag) {
		int pos = this.mTabHost.getCurrentTab();
		this.mViewPager.setCurrentItem(pos);
	}

	@Override
	public void onPageScrollStateChanged(int arg0) {
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
		ContinentFragment f0 = ContinentFragment.newInstance(this.getResources().getString(R.string.country_text));
		ContinentMapFragment f1 = ContinentMapFragment.newInstance(this.getResources().getString(R.string.map_text));
		
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
		ContinentActivity.AddTab(this, this.mTabHost, this.mTabHost.newTabSpec("Tab0").setIndicator(this.getResources().getString(R.string.continent_text)));
		ContinentActivity.AddTab(this, this.mTabHost, this.mTabHost.newTabSpec("Tab1").setIndicator(this.getResources().getString(R.string.map_text)));
		
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
        getMenuInflater().inflate(R.menu.main, menu);
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
					ContinentActivity.this);
			builder.setTitle(R.string.about_text);
			builder.setMessage(R.string.author_text);
			builder.setPositiveButton(this.getResources().getString(R.string.ok_text),
					new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int which) {
			
				}
			});

			builder.show();
			//return super.onOptionsItemSelected(item);         
        } /*else if (id == R.id.action_settings)  {
        	
        	
        }*/ else if (id == R.id.action_fblogin)  {
        	
        	FragmentTransaction ft = getSupportFragmentManager()
					.beginTransaction();
			Fragment prev = getSupportFragmentManager()
					.findFragmentByTag("dialog");
			if (prev != null) {
				ft.remove(prev);
			}
			ft.addToBackStack(null);

			// it was the 1st button
			DialogFragment newFragment = FBDialogFragment
					.newInstance("Title");
			newFragment.setTargetFragment(null, 0);
			newFragment.setShowsDialog(true);
			newFragment.show(getSupportFragmentManager(), "dialog");
			        	
        }
        return super.onOptionsItemSelected(item);
    }   
    
    @Override
    public void onPause() {
        super.onPause();
        uiHelper.onPause();
    }
    
    @Override
    public void onDestroy() {
        super.onDestroy();
        uiHelper.onDestroy();
    }
    
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        uiHelper.onActivityResult(requestCode, resultCode, data);
    }
    
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        uiHelper.onSaveInstanceState(outState);       
    }

	@Override
	public void onComplete(String time) {
		// TODO Auto-generated method stub
		
		//Log.d(TAG, time);
		mFbUsername  = time;
		
		final ActionBar actionBar = getActionBar();
		if (actionBar != null && mFbUsername!=null && !(mFbUsername.equals(null)) && !(mFbUsername.equals("null"))) {
			actionBar.setTitle(this.getResources().getString(R.string.heritage_text) + " (Logged in as " + time + ")");			
		} else {
			actionBar.setTitle(this.getResources().getString(R.string.heritage_text));
		}
		
	}
}
