package com.songbase.fm.androidapp.list;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.Toast;

import com.songbase.fm.androidapp.MainActivity;
import com.songbase.fm.androidapp.R;
import com.songbase.fm.androidapp.list.MainListElement.Action;

public class ListController {

	
	
	
	List<MainListElement> list = new ArrayList<MainListElement>();
	
	ListAdapter listAdapter;
	
	static boolean useSections = false;

	public void init(Activity activity) {
		initList();

		FastSearchListView lv = (FastSearchListView) activity
				.findViewById(R.id.listView);

		listAdapter = new ListAdapter(list, activity);
		lv.setAdapter(listAdapter);

		// React to user clicks on item
		lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			public void onItemClick(AdapterView<?> parentAdapter, View view,
					int position, long id) {
				
				
				MainListElement listElement = list.get(position);
				
				listElement.executeAction();
				

				// TextView clickedView = (TextView) view;


			}
		});

		// we register for the contextmneu
		activity.registerForContextMenu(lv);

	}

	public void onMenu(ContextMenu menu, ContextMenuInfo menuInfo) {

		AdapterContextMenuInfo aInfo = (AdapterContextMenuInfo) menuInfo;
		// We know that each row in the adapter is a Map
		MainListElement listElement = listAdapter.getItem(aInfo.position);

		menu.setHeaderTitle("Options for " + listElement.getName());
		menu.add(1, 1, 1, "Details");
		menu.add(1, 2, 2, "Delete");
		

	}

	public void onItemSelected(MenuItem item) {
		int itemId = item.getItemId();

		AdapterContextMenuInfo aInfo = (AdapterContextMenuInfo) item
				.getMenuInfo();
		list.remove(aInfo.position);
		listAdapter.notifyDataSetChanged();

	}
	
	public class SearchAction implements Action 
    {
		@Override
		public void execute() {
			Toast.makeText(MainActivity.instance, "SEARCH", 
					   Toast.LENGTH_LONG).show();
			
		}    
    }
	
	
	public class ExploreAction implements Action 
    {
		@Override
		public void execute() {
			Toast.makeText(MainActivity.instance, "EXPLORE", 
					   Toast.LENGTH_LONG).show();
			
		}    
    }
	
	public class GenresAction implements Action 
    {
		@Override
		public void execute() {
			Toast.makeText(MainActivity.instance, "GENRES", 
					   Toast.LENGTH_LONG).show();
			
		}    
    }
	
	
	public class MyMusicAction implements Action 
    {
		@Override
		public void execute() {
			Toast.makeText(MainActivity.instance, "My Music", 
					   Toast.LENGTH_LONG).show();
			
		}    
    }
	

	// TODO remove
	public void initList() {
		// We populate the planets

		
		 
		
		list.add(new OptionListElement("Search", new SearchAction()));
		
		list.add(new OptionListElement("Explore", new ExploreAction()));
		
		list.add(new OptionListElement("Genres", new GenresAction()));
		
		list.add(new OptionListElement("My Music", new MyMusicAction()));
		
		

	}

	/*
	 * // Handle user click public void addPlanet(View view) { final Dialog d =
	 * new Dialog(this); d.setContentView(R.layout.dialog);
	 * d.setTitle("Add planet"); d.setCancelable(true);
	 * 
	 * final EditText edit = (EditText) d.findViewById(R.id.editTextPlanet);
	 * Button b = (Button) d.findViewById(R.id.button1);
	 * b.setOnClickListener(new View.OnClickListener() {
	 * 
	 * public void onClick(View v) { String planetName =
	 * edit.getText().toString(); MainActivity.this.songlist.add(new
	 * Song(planetName, 0)); MainActivity.this.aAdpt.notifyDataSetChanged(); //
	 * We notify the // data model is // changed d.dismiss(); } });
	 * 
	 * d.show(); }
	 */

}
