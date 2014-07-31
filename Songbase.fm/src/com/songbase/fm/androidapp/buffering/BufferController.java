package com.songbase.fm.androidapp.buffering;

import android.os.AsyncTask;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

import com.songbase.fm.androidapp.MainActivity;
import com.songbase.fm.androidapp.R;
import com.songbase.fm.androidapp.buffering.online.Convert2mp3netConverter;


public class BufferController {

    private Vid2mp3Converter vid2mp3Converter;
	
    private BufferTask bufferTask;
   
    private static BufferController instance; 
    
    
	public BufferController() {
		
		BufferController.instance = this;
		
		this.vid2mp3Converter = new Convert2mp3netConverter();
	
		this.bufferTask = new BufferTask();

		this.bufferTask.execute();
		
	}
	
	
	
	
	private class BufferTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... params) {
            

        	String html = BufferController.instance.vid2mp3Converter.bufferSong();


            return html;
        }

        @Override
        protected void onPostExecute(String result) { 
        	TextView t=(TextView) MainActivity.instance.findViewById(R.id.textView1); 
        	t.setMovementMethod(new ScrollingMovementMethod());
		    t.setText(result);
        	
        }

        @Override
        protected void onPreExecute() {}

        @Override
        protected void onProgressUpdate(Void... values) {}
    }
	
	
	
}