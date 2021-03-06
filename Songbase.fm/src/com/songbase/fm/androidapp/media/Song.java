package com.songbase.fm.androidapp.media;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.songbase.fm.androidapp.MainActivity;
import com.songbase.fm.androidapp.list.ListAdapter;
import com.songbase.fm.androidapp.list.MainListElement;



public class Song extends MainListElement{

	private String name;

	private Bitmap icon;


	public ListAdapter.ListLayout getListLayout(){
		return ListAdapter.ListLayout.NAMEINFO;
	}

	public Song(String name,Action action) {
		
		this.name = name;
		this.action = action;

		int imageResource = MainActivity.instance.getResources().getIdentifier("playlist", "drawable", MainActivity.instance.getPackageName());
		this.icon = BitmapFactory.decodeResource(MainActivity.instance.getResources(), imageResource);
	}

	
	public Bitmap getIcon() {
		
		return this.icon;
	}
	

	public String getName() {
		return name;
	}
	
	/**
	 * Get Info to Songs displayed in List
	 */
	public String getInfo() {
		return "TODO Artist";
	}
	
	public void setName(String name) {
		this.name = name;
	}

	

	
}