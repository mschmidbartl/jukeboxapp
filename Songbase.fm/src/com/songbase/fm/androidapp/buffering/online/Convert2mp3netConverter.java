package com.songbase.fm.androidapp.buffering.online;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.media.MediaPlayer;

import com.songbase.fm.androidapp.MainActivity;
import com.songbase.fm.androidapp.buffering.Vid2mp3Converter;
import com.songbase.fm.androidapp.misc.HttpController;
import com.songbase.fm.androidapp.misc.Utils;

public class Convert2mp3netConverter implements Vid2mp3Converter {

	private final String HOST = "convert2mp3.net";

	@Override
	public boolean bufferSong(String url) {
		
			
		try {

			String urlParameters = "url="
					+ URLEncoder
							.encode(url)
					+ "&format=mp3&quality=1&85tvb5=43450768";
			String htmlConversionStart = HttpController.instance.sendPost(
					"http://" + HOST + "/index.php?p=convert", urlParameters,
					HOST);

			Pattern pattern = Pattern.compile("convert\\((.*?)\\)");
			Matcher matcher = pattern.matcher(htmlConversionStart);
			if (matcher.find()) {

				// Get Video id and key

				String parameters = matcher.group(1).replace("\"", "")
						.replace(" ", "");

				String[] parameter = parameters.split(",");

				String id = parameter[0];
				String key = parameter[1];
				// cs:parameter[2];
				// format:parameter[3]

				pattern = Pattern.compile("\"convertFrame\" src=\"(.*?)\"");
				matcher = pattern.matcher(htmlConversionStart);
				if (matcher.find()) {

					try {
						Thread.sleep(1000);
					} catch (InterruptedException ex) {
						Thread.currentThread().interrupt();
					}
					// Trigger Conversion

					String triggerConversionURL = matcher.group(1);

					pattern = Pattern.compile("http://(.*?)/");
					matcher = pattern.matcher(triggerConversionURL);
					if (matcher.find()) {

						String host = matcher.group(1);

						String htmlConversionTrigger = HttpController.instance
								.sendGet(triggerConversionURL, host, "http://"
										+ HOST + "/index.php?p=convert");


						String completeURL = "http://" + HOST
								+ "/index.php?p=complete&id=" + id + "&key="
								+ key;

						String htmlComplete = HttpController.instance.sendGet(
								completeURL, HOST, "http://" + HOST
										+ "/index.php?p=convert");


						pattern = Pattern
								.compile("btn-success btn-large\" href=\"(.*?)\"");
						matcher = pattern.matcher(htmlComplete);
						if (matcher.find()) {

							String downloadURL = matcher.group(1);

							Utils.log("Download: "+downloadURL);


							//Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(downloadURL));
							//MainActivity.instance.startActivity(browserIntent);

							byte[] song = HttpController.instance.sendGetBinary(
									downloadURL, host, "http://" + HOST
											+ "/index.php?p=complete");
							
							
							Utils.log("Error: "+Boolean.toString(song==null));

							Utils.log("Size: "+Integer.toString(song.length)+" Bytes");
							
													
							
						}
					}
					

					// CHECKING STATUS, not neccessary, its asynchronous here

					/*
					 * do { try { Thread.sleep(1000); } catch
					 * (InterruptedException ex) {
					 * Thread.currentThread().interrupt(); }
					 * 
					 * time = String.valueOf(new Date().getTime());
					 * 
					 * Utils.log("http://" + HOST + "/status.php?id=" + id +
					 * "&key=" + key + "&cs=" + cs + "&time=" + time +
					 * "        http://" + HOST + "/index.php?p=convert");
					 * 
					 * html = HttpController.instance.sendGet("http://" + HOST +
					 * "/status.php?id=" + id + "&key=" + key + "&cs=" + cs +
					 * "&time=" + time, HOST, "http://" + HOST +
					 * "/index.php?p=convert");
					 * 
					 * Utils.log(html);
					 * 
					 * } while (Integer.parseInt(html) == 0);
					 * 
					 * }
					 */

				}

			}
			// TODO EXTRACT

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;

		}

		return true;

	}
	
	
	private void playMp3(byte[] mp3SoundByteArray) {
	    try {
	        // create temp file that will hold byte array
	        File tempMp3 = File.createTempFile("kurchina", "mp3", MainActivity.instance.getCacheDir());
	        tempMp3.deleteOnExit();
	        FileOutputStream fos = new FileOutputStream(tempMp3);
	        fos.write(mp3SoundByteArray);
	        fos.close();

	        // Tried reusing instance of media player
	        // but that resulted in system crashes...  
	        MediaPlayer mediaPlayer = new MediaPlayer();

	        // Tried passing path directly, but kept getting 
	        // "Prepare failed.: status=0x1"
	        // so using file descriptor instead
	        FileInputStream fis = new FileInputStream(tempMp3);
	        mediaPlayer.setDataSource(fis.getFD());

	        mediaPlayer.prepare();
	        mediaPlayer.start();
	    } catch (IOException ex) {
	        String s = ex.toString();
	        ex.printStackTrace();
	    }
	}
}
