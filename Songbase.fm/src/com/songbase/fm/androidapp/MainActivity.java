package com.songbase.fm.androidapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.webkit.WebView;

import com.songbase.fm.androidapp.buffering.BufferController;

public class MainActivity extends Activity {

	
	
	private WebView webView;
	 
	private BufferController bufferController;
	
	public static MainActivity instance;
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		instance = this;
		
		//Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.songbase.fm"));
		///startActivity(browserIntent);

		bufferController = new BufferController();
		
		
		
 
	}



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
