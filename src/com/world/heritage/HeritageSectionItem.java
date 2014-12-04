package com.world.heritage;

public class HeritageSectionItem implements HeritageItem{
	 private final String title;
	  
	 public HeritageSectionItem(String title) {
	  this.title = title;
	 }
	  
	 public String getTitle(){
	  return title;
	 }
	  
	 @Override
	 public boolean isSection() {
	  return true;
	 }
	 
}
