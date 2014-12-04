package com.world.heritage;

import java.util.Date;

public class ClassProfile{
	int id;  
	long remoteId;
	String Name, Region, Subregion;
	String ImageUrl;
	int Number;

	Date lastDurationDate;
	//end message sorting
	String lastNote, lastNoteDuration;

	public ClassProfile(){
		super();	
	}

	public ClassProfile(int id, long remoteId, String Name , String Region, String Subregion, String ImageUrl, int Number){
		super();
		this.id = id;
		this.remoteId = remoteId;
		this.Name = Name ;
		this.Region = Region ;
		this.Subregion = Subregion ;
		this.ImageUrl = ImageUrl;
		this.Number = Number;
	}

	public String getRegion() {
		return Region;
	}

	public void setRegion(String Region) {
		this.Region = Region;
	}
	
	public String getSubregion() {
		return Subregion;
	}

	public void setSubregion(String Subregion) {
		this.Subregion = Subregion;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public long getRemoteId() {
		return remoteId;
	}

	public void setRemoteId(long remoteId) {
		this.remoteId = remoteId;
	}
	
	public String getName() {
		return Name;
	}

	public void setName(String Name) {
		this.Name = Name;
	}
	
	public String getImageUrl() {
		return ImageUrl;
	}

	public void setImageUrl(String ImageUrl) {
		this.ImageUrl = ImageUrl;
	}
	
	public int getNumber() {
		return Number;
	}

	public void setNumber(int Number) {
		this.Number = Number;
	}
}
