package com.songbase.fm.androidapp.list;


import java.util.List;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.SectionIndexer;
import android.widget.TextView;

import com.songbase.fm.androidapp.R;

public class ListAdapter extends ArrayAdapter<MainListElement> implements SectionIndexer  {

	
	private List<MainListElement> list;
	private Context context;
	private static String sections = "abcdefghilmnopqrstuvz";

	public static enum ListLayout {NAME, NAMEINFO};

	
	public ListAdapter(List<MainListElement> list, Context ctx) {
		super(ctx, R.layout.nameinforowlayout, list);
		this.list = list;
		this.context = ctx;
	}
	
	
	public List<MainListElement> getList() {
		return list;
	}

	
	public int getCount() {
		return list.size();
	}

	public MainListElement getItem(int position) {
		return list.get(position);
	}

	public long getItemId(int position) {
		return list.get(position).hashCode();
	}
	
	//TODO adapt layout 

	public View getView(int position, View convertView, ViewGroup parent) {
		View v = convertView;
		
		
		MainListElement listElement = list.get(position);

		
		ListHolder holder = new ListHolder();
		
		// First let's verify the convertView is not null
		if (convertView == null) {			
			
			LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

			if(listElement.getListLayout()==ListLayout.NAMEINFO){
				v = inflater.inflate(R.layout.nameinforowlayout, null);
							
				TextView infoView = (TextView) v.findViewById(R.id.infolist);
				   /*YOUR CHOICE OF COLOR*/
				infoView.setTextColor(Color.BLACK);
				
				holder.infoView = infoView;
				
			}else{
				v = inflater.inflate(R.layout.namerowlayout, null);

			}
			
			ImageView imageView = (ImageView) v.findViewById(R.id.imglist);
			holder.imageView = imageView;

			TextView nameView = (TextView) v.findViewById(R.id.namelist);
			holder.nameView = nameView;
			nameView.setTextColor(Color.BLACK);

			
			v.setTag(holder);
		}
		else 
			holder = (ListHolder) v.getTag();
		
		Log.e("i",listElement.getIcon().toString());
		Log.e("v",holder.imageView.toString());

		holder.imageView.setImageBitmap(listElement.getIcon());

		holder.nameView.setText(listElement.getName());
		
		if(holder.infoView!=null)
		holder.infoView.setText(listElement.getInfo());
		

		
		
		return v;
	}
	
	/* *********************************
	 * We use the holder pattern        
	 * It makes the view faster and avoid finding the component
	 * **********************************/
	
	private static class ListHolder {
		public ImageView imageView;
		public TextView nameView;
		public TextView infoView;
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