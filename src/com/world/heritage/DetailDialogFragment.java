package com.world.heritage;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class DetailDialogFragment extends DialogFragment {
	private static final String TAG = "DetailDialogFragment";
	
	public static DetailDialogFragment newInstance(String string) {

		DetailDialogFragment frag = new DetailDialogFragment();
		Bundle args = new Bundle();
		args.putString("Title", string);
		frag.setArguments(args);
		return frag;
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		getDialog().setTitle(getActivity().getResources().getString(R.string.detail_text));
		View v = inflater.inflate(R.layout.fragment_detaildialog, container, false);
		
		return v;
	}
}
