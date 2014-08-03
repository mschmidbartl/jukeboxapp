package com.songbase.fm.androidapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.View;

import com.songbase.fm.androidapp.buffering.BufferController;
import com.songbase.fm.androidapp.list.ListController;
import com.songbase.fm.androidapp.ui.UIController;

public class MainActivity extends Activity {

	public static MainActivity instance;
	private UIController uiController;
	private ListController listController;
	private BufferController bufferController;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		instance = this;

		uiController = new UIController();
		uiController.init(this);

		listController = new ListController();
		listController.init(this);

		bufferController = new BufferController();
		// bufferController.bufferSong( url);

		// Intent browserIntent = new Intent(Intent.ACTION_VIEW,
		// Uri.parse("http://www.songbase.fm"));
		// /startActivity(browserIntent);

	}

	// We want to create a context Menu when the user long click on an item
	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {

		super.onCreateContextMenu(menu, v, menuInfo);

		listController.onMenu(menu, menuInfo);

	}

	// This method is called when user selects an Item in the Context menu
	@Override
	public boolean onContextItemSelected(MenuItem item) {

		listController.onItemSelected(item);

		return true;
	}

}
