package com.songbase.fm.androidapp.media;



public class Song {

	private String name;
	private Integer distance;
	private String descr;
	private int idImg;



	public Song(String name, Integer distance) {
		this.name = name;
		this.distance = distance;
	}

	public Song(String name, String descr) {
		this.name = name;
		this.descr = descr;
	}

	public Song(String name, Integer distance, String descr, int idImg) {
		this.name = name;
		this.distance = distance;
		this.descr = descr;
		this.idImg = idImg;
	}


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getDistance() {
		return distance;
	}
	public void setDistance(Integer distance) {
		this.distance = distance;
	}
	public int getIdImg() {
		return idImg;
	}
	public void setIdImg(int idImg) {
		this.idImg = idImg;
	}


}