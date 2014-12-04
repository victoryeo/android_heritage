package com.world.heritage;

import java.io.InputStream;
import java.util.ArrayList;

import com.world.heritage.R;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class HeritageEntryAdapter extends ArrayAdapter<HeritageItem> {

	private Context context;
	private ArrayList<HeritageItem> items;
	private LayoutInflater vi;
	private ImageView igIcon;

	public HeritageEntryAdapter(Context context, ArrayList<HeritageItem> items) {
		super(context, 0, items);
		this.context = context;
		this.items = items;
		vi = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View v = convertView;

		final HeritageItem i = items.get(position);
		if (i != null) {
			if (i.isSection()) {
				HeritageSectionItem si = (HeritageSectionItem) i;
				v = vi.inflate(R.layout.heritage_list_section, null);
				
				v.setOnClickListener(null);
				v.setOnLongClickListener(null);
				v.setLongClickable(false);

			} else {
				HeritageEntryItem ei = (HeritageEntryItem) i;
				v = vi.inflate(R.layout.heritage_list_item, null);
				
				View.OnClickListener handler = new View.OnClickListener() {
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						FragmentTransaction ft = ((HeritageDetailActivity) context).getSupportFragmentManager()
								.beginTransaction();
						Fragment prev = ((HeritageDetailActivity) context).getSupportFragmentManager()
								.findFragmentByTag("dialog");
						if (prev != null) {
							ft.remove(prev);
						}
						ft.addToBackStack(null);

						// it was the 1st button
						DialogFragment newFragment = DetailDialogFragment
								.newInstance("Title");
						newFragment.setTargetFragment(null, 0);
						newFragment.setShowsDialog(true);
						newFragment.show(((HeritageDetailActivity) context).getSupportFragmentManager(), "detail");
					}					
				};
				v.setOnClickListener(handler);
				
				//if (igIcon != null)
				//	igIcon.setImageDrawable(null);
				igIcon = (ImageView) v.findViewById(R.id.h_icon);
				final TextView name = (TextView) v.findViewById(R.id.name);
				final TextView year = (TextView) v.findViewById(R.id.year);
				final TextView type = (TextView) v.findViewById(R.id.type);

				try {
					name.setText(ei.getName());
				} catch (Exception e) {
					name.setText("");
				}

				try {
					year.setText(ei.getYear());

				} catch (Exception e) {
					year.setText("");
				}

				try {
					if (ei.getType().equals("Cultural"))
						type.setTextColor(Color.parseColor("#FF4444"));
					else if (ei.getType().equals("Natural"))
						type.setTextColor(Color.parseColor("#99CC00"));
					else if (ei.getType().equals("Mixed"))
						type.setTextColor(Color.parseColor("#9933CC"));
					type.setText(ei.getType());

				} catch (Exception e) {
					type.setText("");
				}

				int resID = context.getResources().getIdentifier(
						ei.getImageUrl(), "drawable", context.getPackageName());
				if (resID != 0) {
					Bitmap ii = readBitMap(context, resID);
					igIcon.setImageBitmap(ii);
					//igIcon.setImageResource(resID);
				}

			}
		}
		return v;
	}

	/**
	 * @param context
	 * @param resId
	 * @return
	 */
	public static Bitmap readBitMap(Context context, int resId) {
		BitmapFactory.Options opt = new BitmapFactory.Options();
		opt.inPreferredConfig = Bitmap.Config.RGB_565;
		opt.inPurgeable = true;
		opt.inInputShareable = true;
	
		InputStream is = context.getResources().openRawResource(resId);
		return BitmapFactory.decodeStream(is, null, opt);
	}
}
