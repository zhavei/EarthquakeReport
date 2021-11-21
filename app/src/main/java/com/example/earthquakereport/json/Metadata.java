package com.example.earthquakereport.json;

import com.google.gson.annotations.SerializedName;

public class Metadata{

	@SerializedName("offset")
	private int offset;

	@SerializedName("generated")
	private long generated;

	@SerializedName("limit")
	private int limit;

	@SerializedName("count")
	private int count;

	@SerializedName("api")
	private String api;

	@SerializedName("title")
	private String title;

	@SerializedName("url")
	private String url;

	@SerializedName("status")
	private int status;

	public void setOffset(int offset){
		this.offset = offset;
	}

	public int getOffset(){
		return offset;
	}

	public void setGenerated(long generated){
		this.generated = generated;
	}

	public long getGenerated(){
		return generated;
	}

	public void setLimit(int limit){
		this.limit = limit;
	}

	public int getLimit(){
		return limit;
	}

	public void setCount(int count){
		this.count = count;
	}

	public int getCount(){
		return count;
	}

	public void setApi(String api){
		this.api = api;
	}

	public String getApi(){
		return api;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public String getTitle(){
		return title;
	}

	public void setUrl(String url){
		this.url = url;
	}

	public String getUrl(){
		return url;
	}

	public void setStatus(int status){
		this.status = status;
	}

	public int getStatus(){
		return status;
	}

	@Override
 	public String toString(){
		return 
			"Metadata{" + 
			"offset = '" + offset + '\'' + 
			",generated = '" + generated + '\'' + 
			",limit = '" + limit + '\'' + 
			",count = '" + count + '\'' + 
			",api = '" + api + '\'' + 
			",title = '" + title + '\'' + 
			",url = '" + url + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}