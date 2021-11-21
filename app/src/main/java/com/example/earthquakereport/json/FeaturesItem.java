package com.example.earthquakereport.json;

import com.google.gson.annotations.SerializedName;

public class FeaturesItem{

	@SerializedName("geometry")
	private Geometry geometry;

	@SerializedName("id")
	private String id;

	@SerializedName("type")
	private String type;

	@SerializedName("properties")
	private Properties properties;

	public void setGeometry(Geometry geometry){
		this.geometry = geometry;
	}

	public Geometry getGeometry(){
		return geometry;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setType(String type){
		this.type = type;
	}

	public String getType(){
		return type;
	}

	public void setProperties(Properties properties){
		this.properties = properties;
	}

	public Properties getProperties(){
		return properties;
	}

	@Override
 	public String toString(){
		return 
			"FeaturesItem{" + 
			"geometry = '" + geometry + '\'' + 
			",id = '" + id + '\'' + 
			",type = '" + type + '\'' + 
			",properties = '" + properties + '\'' + 
			"}";
		}
}