package com.world.heritage;

public class HeritageEntryItem implements HeritageItem {
	private final String name;
	private final String year;
	private final String type;
	private final String imageUrl;
	
	public HeritageEntryItem(String name, String year, String type, String url) {
		this.name = name;
		this.year = year;
		this.type = type;		
		this.imageUrl = url;
	}

	@Override
	public boolean isSection() {
		return false;
	}
	
	String getName() {
		return this.name;
	}
	
	String getType() {
		return this.type;
	}
	
	String getYear() {
		return this.year;
	}
	String getImageUrl() {
		return this.imageUrl;
	}
}
