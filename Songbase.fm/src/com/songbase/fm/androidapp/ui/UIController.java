package com.songbase.fm.androidapp.ui;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.songbase.fm.androidapp.R;

public class UIController {

	//Main Activity
	private Activity activity;
	//Prograss bar for song
	private ProgressBar songProgressBar;
	private ListView listView;
	
	@SuppressLint("NewApi")
	public void init(Activity activity) {

		this.activity = activity;
		
		activity.setContentView(R.layout.activity_main);

		// Black title bar
		if (Build.VERSION.SDK_INT >= 11) {
			ActionBar bar = activity.getActionBar();
			// for color
			bar.setBackgroundDrawable(new ColorDrawable(Color
					.parseColor("#111111")));
		}
		
		
		listView = (ListView) this.activity.findViewById(R.id.listView);
		
		listView.setBackgroundColor(Color.WHITE);
		
		
		
		
		
		songProgressBar = (ProgressBar) activity.findViewById(R.id.progressBarSong);
		songProgressBar.setProgress(50);
		
		

	}
	
	
	
	
	
	
	

}
