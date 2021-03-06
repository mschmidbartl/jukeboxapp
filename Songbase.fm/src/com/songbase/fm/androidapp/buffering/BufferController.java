package com.songbase.fm.androidapp.buffering;

import android.os.AsyncTask;

import com.songbase.fm.androidapp.buffering.online.Convert2mp3netConverter;


public class BufferController {

    private Vid2mp3Converter vid2mp3Converter;
	
    private BufferTask bufferTask;
   
    private static BufferController instance; 
    
    
	public BufferController() {
		
		BufferController.instance = this;
		
		this.vid2mp3Converter = new Convert2mp3netConverter();
	
		
		
	}
	

	
	public void bufferSong(String url){
		
		this.bufferTask = new BufferTask();

		this.bufferTask.execute(url);	
		
		
	}
	
	
	
	private class BufferTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... params) {
            

        	BufferController.instance.vid2mp3Converter.bufferSong(params[0]);

        	return "";

        }

        @Override
        protected void onPostExecute(String result) { 
        	
        	
        }

        @Override
        protected void onPreExecute() {}

        @Override
        protected void onProgressUpdate(Void... values) {}
    }
	
	
	
}
