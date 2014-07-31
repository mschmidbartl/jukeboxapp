package com.songbase.fm.androidapp.buffering.online;

import java.net.URLEncoder;

import misc.HttpController;

import com.songbase.fm.androidapp.buffering.Vid2mp3Converter;

public class Convert2mp3netConverter implements Vid2mp3Converter {


	
	
	

	@Override
	public String bufferSong() {
		
		String html = "";
		
		try {
			
			
			
			String urlParameters = "url="+URLEncoder.encode("https://www.youtube.com/watch?v=SMiVJ4mmbQM")+"&format=mp3&quality=1&85tvb5=43450768";
				
			
			
			 html = HttpController.instance.sendPost("http://convert2mp3.net/index.php?p=convert",urlParameters);


			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
        return html;

		
	}
	
	
	
	
	
	
	
	

}