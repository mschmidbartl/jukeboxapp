package com.songbase.fm.androidapp.misc;

import java.util.ArrayList;

import android.util.Log;

public class Utils {
	    /**
	     * Divides a string into chunks of a given character size.
	     * 
	     * @param text                  String text to be sliced
	     * @param sliceSize             int Number of characters
	     * @return  ArrayList<String>   Chunks of strings
	     */
	    public static ArrayList<String> splitString(String text, int sliceSize) {
	        ArrayList<String> textList = new ArrayList<String>();
	        String aux;
	        int left = -1, right = 0;
	        int charsLeft = text.length();
	        while (charsLeft != 0) {
	            left = right;
	            if (charsLeft >= sliceSize) {
	                right += sliceSize;
	                charsLeft -= sliceSize;
	            }
	            else {
	                right = text.length();
	                aux = text.substring(left, right);
	                charsLeft = 0;
	            }
	            aux = text.substring(left, right);
	            textList.add(aux);
	        }
	        return textList;
	    }

	    /**
	     * Divides a string into chunks.
	     * 
	     * @param text                  String text to be sliced
	     * @return  ArrayList<String>   
	     */
	    public static ArrayList<String> splitString(String text) {
	        return splitString(text, 80);
	    }

	    /**
	     * Divides the string into chunks for displaying them
	     * into the Eclipse's LogCat.
	     * 
	     * @param text      The text to be split and shown in LogCat
	     * @param tag       The tag in which it will be shown.
	     */
	    public static void splitAndLog(String tag, String text) {
	        ArrayList<String> messageList = Utils.splitString(text);
	        for (String message : messageList) {
	            Log.d(tag, message);
	        }
	    }
	    
	    /**
	     * Uses short and simple syntax and divides the string into chunks for displaying them
	     * into the Eclipse's LogCat.
	     * 
	     * @param text      The text to be split and shown in LogCat
	     * @param tag       The tag in which it will be shown.
	     */ 
	    public static void log(String text) {
	        ArrayList<String> messageList = Utils.splitString(text);
	        for (String message : messageList) {
	            Log.d("log", message);
	        }
	    }
	
}
