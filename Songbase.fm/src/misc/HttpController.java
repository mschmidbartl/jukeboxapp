package misc;

import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.commons.io.IOUtils;

public class HttpController {

	
	 public static HttpController instance = new HttpController();;

	 private final String USER_AGENT = "Mozilla/5.0 (Windows NT 6.3; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/36.0.1985.125 Safari/537.36";

	 
	/*
	 public static String excuteGet(String url)  throws Exception
	 {
	         URL obj; 

	         obj = new URL(url);
	         HttpURLConnection con = (HttpURLConnection) obj.openConnection();
	         con.setRequestMethod("GET");
	         int responseCode = con.getResponseCode();

	         BufferedReader in = new BufferedReader(
	                 new InputStreamReader(con.getInputStream()));
	         String inputLine;
	         StringBuffer response = new StringBuffer();

	         while ((inputLine = in.readLine()) != null) {
	             response.append(inputLine);
	         }
	         in.close();         
	         return response.toString();
	 }
	 
	 
	 public static String executePost(String targetURL, String urlParameters)
	  {
	    URL url;
	    HttpURLConnection connection = null;  
	    try {
	      //Create connection
	      url = new URL(targetURL);
	      connection = (HttpURLConnection)url.openConnection();
	      connection.setRequestMethod("POST");
	      connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
				
	      connection.setRequestProperty("Content-Length", "" + 
	               Integer.toString(urlParameters.getBytes().length));
	      connection.setRequestProperty("Content-Language", "en-US");  
	      connection.setRequestProperty("Content-Language", "en-US");  
	      connection.setRequestProperty("Content-Language", "en-US");  
	      connection.setRequestProperty("Host", "convert2mp3.net");  
	      connection.setRequestProperty("Origin", "http://convert2mp3.net");  
	      connection.setRequestProperty("Pragma", "no-cache");  

	  
	      connection.setRequestProperty("Cookie", "WSID=72792175053a1614db9390HJmJhcY0tb3t8az1qjScKh5K3slywH4966657f59da54e838c4331e9ff0cad2; forcelng=de; __utma=92236808.1686580310.1403085117.1406833512.1406842646.8; __utmb=92236808.12.10.1406842646; __utmc=92236808; __utmz=92236808.1406833512.7.7.utmcsr=google|utmccn=(organic)|utmcmd=organic|utmctr=(not%20provided)");  


	      
	      
	      connection.setUseCaches (false);
	      connection.setDoInput(true);
	      connection.setDoOutput(true);

	      
	      //Send request
	      DataOutputStream wr = new DataOutputStream (
	                  connection.getOutputStream ());
	      wr.writeBytes (urlParameters);
	      wr.flush ();
	      wr.close ();

	      //Get Response	
	      InputStream is = connection.getInputStream();
	      BufferedReader rd = new BufferedReader(new InputStreamReader(is));
	      String line;
	      StringBuffer response = new StringBuffer(); 
	      while((line = rd.readLine()) != null) {
	        response.append(line);
	        response.append('\r');
	      }
	      rd.close();
	      return response.toString();

	    } catch (Exception e) {

	      e.printStackTrace();
	      return null;

	    } finally {

	      if(connection != null) {
	        connection.disconnect(); 
	      }
	    }
	  }
	
	*/
	 
	// HTTP GET request
		private String sendGet() throws Exception {
	 
			String url = "http://www.google.com/search?q=mkyong";
	 
			URL obj = new URL(url);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();
	 
			// optional default is GET
			con.setRequestMethod("GET");
	 
			//add request header
			con.setRequestProperty("User-Agent", USER_AGENT);
	 
			int responseCode = con.getResponseCode();
			System.out.println("\nSending 'GET' request to URL : " + url);
			System.out.println("Response Code : " + responseCode);
			System.out.println("Response Len : " + con.getContentLength());

			
			return IOUtils.toString(con.getInputStream(), "UTF-8");
			
			

			/*
			BufferedReader in = new BufferedReader(
			        new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();
	 
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
				response.append('\r');
			}
			in.close();
	 
			//print result
		      return response.toString();*/
	 
		}
	 
		// HTTP POST request
		public String sendPost(String url,String urlParameters) throws Exception {
	 
			URL obj = new URL(url);
			HttpURLConnection connection = (HttpURLConnection) obj.openConnection();

			
			//add reuqest header
			connection.setRequestMethod("POST");
			connection.setRequestProperty("User-Agent", USER_AGENT);
			connection.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
	 

			 
			 connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			
			      connection.setRequestProperty("Content-Length", "" + 
			               Integer.toString(urlParameters.getBytes().length));
			      connection.setRequestProperty("Content-Language", "en-US");  
			      connection.setRequestProperty("Content-Language", "en-US");  
			      connection.setRequestProperty("Content-Language", "en-US");  
			      connection.setRequestProperty("Host", "convert2mp3.net");  
			      connection.setRequestProperty("Origin", "http://convert2mp3.net");  
			      connection.setRequestProperty("Pragma", "no-cache");  

			  
			      connection.setRequestProperty("Cookie", "WSID=72792175053a1614db9390HJmJhcY0tb3t8az1qjScKh5K3slywH4966657f59da54e838c4331e9ff0cad2; forcelng=de; __utma=92236808.1686580310.1403085117.1406833512.1406842646.8; __utmb=92236808.12.10.1406842646; __utmc=92236808; __utmz=92236808.1406833512.7.7.utmcsr=google|utmccn=(organic)|utmcmd=organic|utmctr=(not%20provided)");  


			      
			
			
			
	 
			// Send post request
			connection.setDoOutput(true);
			DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
			wr.writeBytes(urlParameters);
			wr.flush();
			wr.close();
	 
			int responseCode = connection.getResponseCode();
			
			
			System.out.println("\nSending 'POST' request to URL : " + url);
			System.out.println("Post parameters : " + urlParameters);
			System.out.println("Response Code : " + responseCode);

			
			return IOUtils.toString(connection.getInputStream(), "UTF-8");
			
			
			

			

			/*
			
			BufferedReader in = new BufferedReader(
			        new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();
	 
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
			
			if(con != null) {
				con.disconnect(); 
		   }

			return response.toString();*/
	 
		}
	 
	 
	
}