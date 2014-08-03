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

import com.songbase.fm.androidapp.R;
import com.songbase.fm.androidapp.media.Song;

public class ListController {

	List<Song> list = new ArrayList<Song>();
	ListAdapter listAdapter;

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

				// TextView clickedView = (TextView) view;

				// Toast.makeText(MainActivity.this,
				// "Item with id ["+id+"] - Position ["+position+"] - Planet ["+clickedView.getText()+"]",
				// Toast.LENGTH_SHORT).show();

			}
		});

		// we register for the contextmneu
		activity.registerForContextMenu(lv);

	}

	public void onMenu(ContextMenu menu, ContextMenuInfo menuInfo) {

		AdapterContextMenuInfo aInfo = (AdapterContextMenuInfo) menuInfo;
		// We know that each row in the adapter is a Map
		Song planet = listAdapter.getItem(aInfo.position);

		menu.setHeaderTitle("Options for " + planet.getName());
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
	
	

	
	

	// TODO remove
	public void initList() {
		// We populate the planets

		list.add(new Song("Mercury", 10));
		list.add(new Song("Venus", 20));
		list.add(new Song("Mars", 30));
		list.add(new Song("Jupiter", 40));
		list.add(new Song("Saturn", 50));
		list.add(new Song("Uranus", 60));
		list.add(new Song("Neptune", 70));
		list.add(new Song("Mercury", 10));
		list.add(new Song("Venus", 20));
		list.add(new Song("Mars", 30));
		list.add(new Song("Jupiter", 40));
		list.add(new Song("Saturn", 50));
		list.add(new Song("Uranus", 60));
		list.add(new Song("Neptune", 70));
		list.add(new Song("Mercury", 10));
		list.add(new Song("Venus", 20));
		list.add(new Song("Mars", 30));
		list.add(new Song("Jupiter", 40));
		list.add(new Song("Saturn", 50));
		list.add(new Song("Uranus", 60));
		list.add(new Song("Neptune", 70));
		list.add(new Song("Mercury", 10));
		list.add(new Song("Venus", 20));
		list.add(new Song("Mars", 30));
		list.add(new Song("Jupiter", 40));
		list.add(new Song("Saturn", 50));
		list.add(new Song("Uranus", 60));
		list.add(new Song("Neptune", 70));
		list.add(new Song("Mercury", 10));
		list.add(new Song("Venus", 20));
		list.add(new Song("Mars", 30));
		list.add(new Song("Jupiter", 40));
		list.add(new Song("Saturn", 50));
		list.add(new Song("Uranus", 60));
		list.add(new Song("Neptune", 70));
		list.add(new Song("Mercury", 10));
		list.add(new Song("Venus", 20));
		list.add(new Song("Mars", 30));
		list.add(new Song("Jupiter", 40));
		list.add(new Song("Saturn", 50));
		list.add(new Song("Uranus", 60));
		list.add(new Song("Neptune", 70));
		list.add(new Song("Mercury", 10));
		list.add(new Song("Venus", 20));
		list.add(new Song("Mars", 30));
		list.add(new Song("Jupiter", 40));
		list.add(new Song("Saturn", 50));
		list.add(new Song("Uranus", 60));
		list.add(new Song("Neptune", 70));

	}
	
	
	/*
	// Handle user click
		public void addPlanet(View view) {
			final Dialog d = new Dialog(this);
			d.setContentView(R.layout.dialog);
			d.setTitle("Add planet");
			d.setCancelable(true);

			final EditText edit = (EditText) d.findViewById(R.id.editTextPlanet);
			Button b = (Button) d.findViewById(R.id.button1);
			b.setOnClickListener(new View.OnClickListener() {

				public void onClick(View v) {
					String planetName = edit.getText().toString();
					MainActivity.this.songlist.add(new Song(planetName, 0));
					MainActivity.this.aAdpt.notifyDataSetChanged(); // We notify the
																	// data model is
																	// changed
					d.dismiss();
				}
			});

			d.show();
		}

	*/
	

}
