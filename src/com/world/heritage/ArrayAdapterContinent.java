package com.world.heritage;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import com.world.heritage.R;

import android.content.Context;
import android.content.res.Configuration;
import android.database.SQLException;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.text.format.DateFormat;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ArrayAdapterContinent extends ArrayAdapter<ClassProfile>  {
	private String TAG = "ArrayAdapterContinent";

	private Context context;
	private int layoutResourceId;
	public ArrayList<ClassProfile> country;
	private String typeSearch = "";	
	URL url;
	Bitmap bmImg;

	public ArrayAdapterContinent(Context context, int resLayout, ArrayList<ClassProfile> objects, String findType) {
		super(context, resLayout, objects);
		this.context = context;
		this.layoutResourceId = resLayout;
		this.country = objects;
		this.typeSearch = findType;
	}

	public static class ViewHolder {
		TextView imageTitle;
		ImageView image;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent){
		View row = convertView;
		ViewHolder viewHolder = null;

		if (row == null) {

			LayoutInflater mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			row = mInflater.inflate(layoutResourceId, parent, false);

			viewHolder = new ViewHolder();
		
			viewHolder.imageTitle = (TextView) row.findViewById(R.id.item_text);
			viewHolder.image = (ImageView) row.findViewById(R.id.item_image);
			
			row.setTag(viewHolder);
		} else {
			viewHolder = (ViewHolder) row.getTag();
		}

		int screenSize = context.getResources().getConfiguration().screenLayout &
				Configuration.SCREENLAYOUT_SIZE_MASK;
		if (screenSize == Configuration.SCREENLAYOUT_SIZE_NORMAL)
		{
			viewHolder.imageTitle.setTextSize(18);
		}	
		
		ClassProfile item = (ClassProfile) country.get(position);
		if(item != null){
			//        viewHolder.imageTitle.setTypeface(null, Typeface.BOLD);
			viewHolder.imageTitle.setText(item.Name);
			
			int resID = context.getResources().getIdentifier(item.ImageUrl, "drawable", context.getPackageName());
			viewHolder.image.setImageResource(resID);
		}
				
		return row;
	}


	public static String getFormattedDateFromTimestamp(long timestampInMilliSeconds){
		Date date = new Date(); 
		date.setTime(timestampInMilliSeconds);
		String formattedDate=new SimpleDateFormat("MMM d, yyyy").format(date);
		return formattedDate;
	}

	public String getFormattedDate(Context context, long smsTimeInMilis) {
		Calendar smsTime = Calendar.getInstance();
		smsTime.setTimeInMillis(smsTimeInMilis);

		Calendar now = Calendar.getInstance();

		final String timeFormatString;
		if ((Locale.getDefault().getLanguage()).equals("zh")) {
			timeFormatString = "kk:mm";
		}
		else {
			timeFormatString = "h:mmaa";
		}
		
		final String dateTimeFormatString;
		if ((Locale.getDefault().getLanguage()).equals("zh")) {
			dateTimeFormatString = "yyyy-MM-dd, kk:mm";
		}
		else{
			dateTimeFormatString = "h:mmaa, dd-MMM-yyyy";
		}	

		final long HOURS = 60 * 60 * 60;
		
		return DateFormat.format(dateTimeFormatString, smsTime).toString();
	}


}
