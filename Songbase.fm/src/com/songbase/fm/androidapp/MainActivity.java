package com.songbase.fm.androidapp;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.Button;
import android.widget.EditText;

import com.songbase.fm.androidapp.buffering.BufferController;
import com.songbase.fm.androidapp.list.FastSearchListView;
import com.songbase.fm.androidapp.list.SonglistAdapter;
import com.songbase.fm.androidapp.media.Planet;

public class MainActivity extends Activity {


	private BufferController bufferController;

	public static MainActivity instance;

	List<Planet> planetsList = new ArrayList<Planet>();
	SonglistAdapter aAdpt;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		instance = this;

		// Intent browserIntent = new Intent(Intent.ACTION_VIEW,
		// Uri.parse("http://www.songbase.fm"));
		// /startActivity(browserIntent);

		bufferController = new BufferController();
		// bufferController.bufferSong( url);

		   initList();
	        
	        // We get the ListView component from the layout
		   FastSearchListView lv = (FastSearchListView) findViewById(R.id.listView);
	        
	        
	        // This is a simple adapter that accepts as parameter
	        // Context
	        // Data list
	        // The row layout that is used during the row creation
	        // The keys used to retrieve the data
	        // The View id used to show the data. The key number and the view id must match
	        //aAdpt = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, planetsList);
	        aAdpt = new SonglistAdapter(planetsList, this);
	        lv.setAdapter(aAdpt);
	        
	        // React to user clicks on item
	        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

				public void onItemClick(AdapterView<?> parentAdapter, View view, int position,
						long id) {


				//	TextView clickedView = (TextView) view;

				//	Toast.makeText(MainActivity.this, "Item with id ["+id+"] - Position ["+position+"] - Planet ["+clickedView.getText()+"]", Toast.LENGTH_SHORT).show();

				}
			   });
	        
	          // we register for the contextmneu        
	          registerForContextMenu(lv);
	        }
	   
	    
	   // We want to create a context Menu when the user long click on an item
	    @Override
		public void onCreateContextMenu(ContextMenu menu, View v,
				ContextMenuInfo menuInfo) {

			super.onCreateContextMenu(menu, v, menuInfo);
			AdapterContextMenuInfo aInfo = (AdapterContextMenuInfo) menuInfo;

			// We know that each row in the adapter is a Map
			Planet planet =  aAdpt.getItem(aInfo.position);

			menu.setHeaderTitle("Options for " + planet.getName());
			menu.add(1, 1, 1, "Details");
			menu.add(1, 2, 2, "Delete");

		}
	    
	    
	    

	    // This method is called when user selects an Item in the Context menu
		@Override
		public boolean onContextItemSelected(MenuItem item) {
			int itemId = item.getItemId();
			AdapterContextMenuInfo aInfo = (AdapterContextMenuInfo) item.getMenuInfo();
			planetsList.remove(aInfo.position);
			aAdpt.notifyDataSetChanged();
			return true;
		}


	
	    
	    
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
					MainActivity.this.planetsList.add(new Planet(planetName, 0));
					MainActivity.this.aAdpt.notifyDataSetChanged(); // We notify the data model is changed
					d.dismiss();
				}
			});
	    	
	    	d.show();
	    }

	private void initList() {
		// We populate the planets

		  planetsList.add(new Planet("Mercury", 10));
	        planetsList.add(new Planet("Venus", 20));
	        planetsList.add(new Planet("Mars", 30));
	        planetsList.add(new Planet("Jupiter", 40));
	        planetsList.add(new Planet("Saturn", 50));
	        planetsList.add(new Planet("Uranus", 60));
	        planetsList.add(new Planet("Neptune", 70));
	        planetsList.add(new Planet("Mercury", 10));
	        planetsList.add(new Planet("Venus", 20));
	        planetsList.add(new Planet("Mars", 30));
	        planetsList.add(new Planet("Jupiter", 40));
	        planetsList.add(new Planet("Saturn", 50));
	        planetsList.add(new Planet("Uranus", 60));
	        planetsList.add(new Planet("Neptune", 70));
	        planetsList.add(new Planet("Mercury", 10));
	        planetsList.add(new Planet("Venus", 20));
	        planetsList.add(new Planet("Mars", 30));
	        planetsList.add(new Planet("Jupiter", 40));
	        planetsList.add(new Planet("Saturn", 50));
	        planetsList.add(new Planet("Uranus", 60));
	        planetsList.add(new Planet("Neptune", 70));
	        planetsList.add(new Planet("Mercury", 10));
	        planetsList.add(new Planet("Venus", 20));
	        planetsList.add(new Planet("Mars", 30));
	        planetsList.add(new Planet("Jupiter", 40));
	        planetsList.add(new Planet("Saturn", 50));
	        planetsList.add(new Planet("Uranus", 60));
	        planetsList.add(new Planet("Neptune", 70));
	        planetsList.add(new Planet("Mercury", 10));
	        planetsList.add(new Planet("Venus", 20));
	        planetsList.add(new Planet("Mars", 30));
	        planetsList.add(new Planet("Jupiter", 40));
	        planetsList.add(new Planet("Saturn", 50));
	        planetsList.add(new Planet("Uranus", 60));
	        planetsList.add(new Planet("Neptune", 70));
	        planetsList.add(new Planet("Mercury", 10));
	        planetsList.add(new Planet("Venus", 20));
	        planetsList.add(new Planet("Mars", 30));
	        planetsList.add(new Planet("Jupiter", 40));
	        planetsList.add(new Planet("Saturn", 50));
	        planetsList.add(new Planet("Uranus", 60));
	        planetsList.add(new Planet("Neptune", 70));
	        planetsList.add(new Planet("Mercury", 10));
	        planetsList.add(new Planet("Venus", 20));
	        planetsList.add(new Planet("Mars", 30));
	        planetsList.add(new Planet("Jupiter", 40));
	        planetsList.add(new Planet("Saturn", 50));
	        planetsList.add(new Planet("Uranus", 60));
	        planetsList.add(new Planet("Neptune", 70));

	}


}
