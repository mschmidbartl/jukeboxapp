package com.songbase.fm.androidapp.list;


import java.util.List;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.SectionIndexer;
import android.widget.TextView;

import com.songbase.fm.androidapp.R;
import com.songbase.fm.androidapp.media.Planet;

public class SonglistAdapter extends ArrayAdapter<Planet> implements SectionIndexer  {

	private List<Planet> planetList;
	private Context context;
	private static String sections = "abcdefghilmnopqrstuvz";

	
	
	public SonglistAdapter(List<Planet> planetList, Context ctx) {
		super(ctx, R.layout.img_row_layout, planetList);
		this.planetList = planetList;
		this.context = ctx;
	}
	
	public int getCount() {
		return planetList.size();
	}

	public Planet getItem(int position) {
		return planetList.get(position);
	}

	public long getItemId(int position) {
		return planetList.get(position).hashCode();
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		View v = convertView;
		
		PlanetHolder holder = new PlanetHolder();
		
		// First let's verify the convertView is not null
		if (convertView == null) {
			// This a new view we inflate the new layout
			LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			v = inflater.inflate(R.layout.img_row_layout, null);
			// Now we can fill the layout with the right values
			TextView tv = (TextView) v.findViewById(R.id.name);
			TextView distView = (TextView) v.findViewById(R.id.dist);

			
			holder.planetNameView = tv;
			holder.distView = distView;
			
			v.setTag(holder);
		}
		else 
			holder = (PlanetHolder) v.getTag();
		
		Planet p = planetList.get(position);
		holder.planetNameView.setText(p.getName());
		holder.distView.setText("" + p.getDistance());
		
		
		return v;
	}
	
	/* *********************************
	 * We use the holder pattern        
	 * It makes the view faster and avoid finding the component
	 * **********************************/
	
	private static class PlanetHolder {
		public TextView planetNameView;
		public TextView distView;
	}
	
	
	@Override
	public int getPositionForSection(int section) {
		Log.d("ListView", "Get position for section");
		for (int i=0; i < this.getCount(); i++) {
			String item = this.getItem(i).getName().toLowerCase();
			if (item.charAt(0) == sections.charAt(section))
				return i;
		}
		return 0;
	}

	@Override
	public int getSectionForPosition(int arg0) {
		Log.d("ListView", "Get section");
		return 0;
	}

	@Override
	public Object[] getSections() {
		Log.d("ListView", "Get sections");
		String[] sectionsArr = new String[sections.length()];
		for (int i=0; i < sections.length(); i++)
			sectionsArr[i] = "" + sections.charAt(i);

		return sectionsArr;

	}

	

}