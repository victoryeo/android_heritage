package com.world.heritage;

import java.util.Arrays;
import java.util.List;

import com.facebook.Request;
import com.facebook.Response;
import com.facebook.Session;
import com.facebook.Session.OpenRequest;
import com.facebook.Session.StatusCallback;
import com.facebook.SessionState;
import com.facebook.UiLifecycleHelper;
import com.facebook.model.GraphUser;
import com.facebook.widget.LoginButton;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class FBDialogFragment extends DialogFragment {
	private static final String TAG = "FBDialogFragment";
	
	//private Button loginButton;
	private LoginButton loginButton;
	private UiLifecycleHelper uiHelper;
	
	private Session.StatusCallback callback = new Session.StatusCallback() {
	    @Override
	    public void call(Session session, SessionState state, Exception exception) {
	        onSessionStateChange(session, state, exception);
	    }
	};
	
	public static interface OnCompleteListener {
	    public abstract void onComplete(String time);
	}

	private OnCompleteListener mListener;

	// make sure the Activity implemented it
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
	    try {
	        this.mListener = (OnCompleteListener)activity;
	    }
	    catch (final ClassCastException e) {
	        throw new ClassCastException(activity.toString() + " must implement OnCompleteListener");
	    }
	}
	
	public static FBDialogFragment newInstance(String string) {

		FBDialogFragment frag = new FBDialogFragment();
		Bundle args = new Bundle();
		args.putString("Title", string);
		frag.setArguments(args);
		return frag;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    uiHelper = new UiLifecycleHelper(getActivity(), callback);
	    uiHelper.onCreate(savedInstanceState);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		getDialog().setTitle(getActivity().getResources().getString(R.string.fb_text));
		View v = inflater.inflate(R.layout.fragment_fblogin, container, false);

		loginButton = (LoginButton) v.findViewById(R.id.login_button);
		loginButton.setFragment(this);
		
		loginButton.setReadPermissions(Arrays.asList("user_likes", "user_status", "public_profile"));
			 
		// publish permission
	    /*Session.NewPermissionsRequest newPermissionsRequest = new Session
	    	      .NewPermissionsRequest(this, Arrays.asList("publish_actions"));
	    Session session = Session.getActiveSession();
	    if (session != null && session.isOpened()) {
	        // Get the user's data
	        makeMeRequest(session);
	        
	        session.requestNewPublishPermissions(newPermissionsRequest);
	    }*/	    
	    	    
		loginButton.setUserInfoChangedCallback(new LoginButton.UserInfoChangedCallback() {			
			@Override
			public void onUserInfoFetched(GraphUser user) {
				((ContinentActivity)getActivity()).user = user;
				
			}
		}); 			
		
		/*loginButton = (Button) v.findViewById(R.id.login_button);
		View.OnClickListener handler = new View.OnClickListener() {
			public void onClick(View v) {
				openFacebookSession();
			}
		};
		loginButton.setOnClickListener(handler);*/

		return v;
	}

	private void openFacebookSession(){
		// set the permissions in the third parameter of the call
		openActiveSession(getActivity(), true, Arrays.asList("email", "user_birthday", "user_hometown", "user_location"), 
				new Session.StatusCallback() {
			@Override
			public void call(Session session, SessionState state, Exception exception) {
			       // you can make request to the /me API or do other stuff like post, etc. here
			}
		});
	    
	}

	private static Session openActiveSession(Activity activity,
			boolean allowLoginUI, List permissions, StatusCallback callback) {
		OpenRequest openRequest = new OpenRequest(activity).setPermissions(
				permissions).setCallback(callback);
		Session session = new Session.Builder(activity).build();
		if (SessionState.CREATED_TOKEN_LOADED.equals(session.getState())
				|| allowLoginUI) {
			Session.setActiveSession(session);
			session.openForRead(openRequest);
			return session;
		}
		return null;
	}
	
	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
	    super.onActivityResult(requestCode, resultCode, data);
	    Session.getActiveSession().onActivityResult(this.getActivity(), requestCode, resultCode, data);
	}
	
	@Override
	public void onResume() {
	    super.onResume();
	    // For scenarios where the main activity is launched and user
	    // session is not null, the session state change notification
	    // may not be triggered. Trigger it if it's open/closed.
	    Session session = Session.getActiveSession();
	    if (session != null &&
	           (session.isOpened() || session.isClosed()) ) {
	        onSessionStateChange(session, session.getState(), null);
	    }

	    uiHelper.onResume();
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
	public void onSaveInstanceState(Bundle outState) {
	    super.onSaveInstanceState(outState);
	    uiHelper.onSaveInstanceState(outState);
	}
	
	private void onSessionStateChange(Session session, SessionState state, Exception exception) {
	    if (session != null && state.isOpened()) {
	        Log.i(TAG, "Logged in...");
	        makeMeRequest(session);
	    } else if (state.isClosed()) {
	        Log.i(TAG, "Logged out...");
	        
	        mListener.onComplete(null);
	    }
	}
	
	private void onClickLogin() {
	    Session session = Session.getActiveSession();
	    if (!session.isOpened() && !session.isClosed()) {
	        session.openForRead(new Session.OpenRequest(this)
	            .setPermissions(Arrays.asList("public_profile"))
	            .setCallback(callback));
	    } else {
	        Session.openActiveSession(getActivity(), this, true, callback);
	    }
	}
	
	private void makeMeRequest(final Session session) {
	    // Make an API call to get user data and define a 
	    // new callback to handle the response.
	    Request request = Request.newMeRequest(session, 
	            new Request.GraphUserCallback() {
	        @Override
	        public void onCompleted(GraphUser user, Response response) {
	        	String fbId;
	        	String fbName;
	        	
	            // If the response is successful
	            if (session == Session.getActiveSession()) {
	                if (user != null) {
	                		
						fbId = user.getId();
						fbName = user.getName();
						
						mListener.onComplete(fbName);
	                }
	            }
	            if (response.getError() != null) {
	                // Handle errors, will do so later.
	            }
	        }
	    });
	    request.executeAsync();
	}
}
