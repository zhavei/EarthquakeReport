package com.example.earthquakereport.json;

import com.google.gson.annotations.SerializedName;

public class Properties{

	@SerializedName("dmin")
	private Object dmin;

	@SerializedName("code")
	private String code;

	@SerializedName("sources")
	private String sources;

	@SerializedName("tz")
	private Object tz;

	@SerializedName("mmi")
	private Object mmi;

	@SerializedName("type")
	private String type;

	@SerializedName("title")
	private String title;

	@SerializedName("magType")
	private String magType;

	@SerializedName("nst")
	private int nst;

	@SerializedName("sig")
	private int sig;

	@SerializedName("tsunami")
	private int tsunami;

	@SerializedName("mag")
	private double mag;

	@SerializedName("alert")
	private Object alert;

	@SerializedName("gap")
	private double gap;

	@SerializedName("rms")
	private double rms;

	@SerializedName("place")
	private String place;

	@SerializedName("net")
	private String net;

	@SerializedName("types")
	private String types;

	@SerializedName("felt")
	private Object felt;

	@SerializedName("cdi")
	private Object cdi;

	@SerializedName("url")
	private String url;

	@SerializedName("ids")
	private String ids;

	@SerializedName("time")
	private long time;

	@SerializedName("detail")
	private String detail;

	@SerializedName("updated")
	private long updated;

	@SerializedName("status")
	private String status;

	public void setDmin(Object dmin){
		this.dmin = dmin;
	}

	public Object getDmin(){
		return dmin;
	}

	public void setCode(String code){
		this.code = code;
	}

	public String getCode(){
		return code;
	}

	public void setSources(String sources){
		this.sources = sources;
	}

	public String getSources(){
		return sources;
	}

	public void setTz(Object tz){
		this.tz = tz;
	}

	public Object getTz(){
		return tz;
	}

	public void setMmi(Object mmi){
		this.mmi = mmi;
	}

	public Object getMmi(){
		return mmi;
	}

	public void setType(String type){
		this.type = type;
	}

	public String getType(){
		return type;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public String getTitle(){
		return title;
	}

	public void setMagType(String magType){
		this.magType = magType;
	}

	public String getMagType(){
		return magType;
	}

	public void setNst(int nst){
		this.nst = nst;
	}

	public int getNst(){
		return nst;
	}

	public void setSig(int sig){
		this.sig = sig;
	}

	public int getSig(){
		return sig;
	}

	public void setTsunami(int tsunami){
		this.tsunami = tsunami;
	}

	public int getTsunami(){
		return tsunami;
	}

	public void setMag(double mag){
		this.mag = mag;
	}

	public double getMag(){
		return mag;
	}

	public void setAlert(Object alert){
		this.alert = alert;
	}

	public Object getAlert(){
		return alert;
	}

	public void setGap(double gap){
		this.gap = gap;
	}

	public double getGap(){
		return gap;
	}

	public void setRms(double rms){
		this.rms = rms;
	}

	public double getRms(){
		return rms;
	}

	public void setPlace(String place){
		this.place = place;
	}

	public String getPlace(){
		return place;
	}

	public void setNet(String net){
		this.net = net;
	}

	public String getNet(){
		return net;
	}

	public void setTypes(String types){
		this.types = types;
	}

	public String getTypes(){
		return types;
	}

	public void setFelt(Object felt){
		this.felt = felt;
	}

	public Object getFelt(){
		return felt;
	}

	public void setCdi(Object cdi){
		this.cdi = cdi;
	}

	public Object getCdi(){
		return cdi;
	}

	public void setUrl(String url){
		this.url = url;
	}

	public String getUrl(){
		return url;
	}

	public void setIds(String ids){
		this.ids = ids;
	}

	public String getIds(){
		return ids;
	}

	public void setTime(long time){
		this.time = time;
	}

	public long getTime(){
		return time;
	}

	public void setDetail(String detail){
		this.detail = detail;
	}

	public String getDetail(){
		return detail;
	}

	public void setUpdated(long updated){
		this.updated = updated;
	}

	public long getUpdated(){
		return updated;
	}

	public void setStatus(String status){
		this.status = status;
	}

	public String getStatus(){
		return status;
	}

	@Override
 	public String toString(){
		return 
			"Properties{" + 
			"dmin = '" + dmin + '\'' + 
			",code = '" + code + '\'' + 
			",sources = '" + sources + '\'' + 
			",tz = '" + tz + '\'' + 
			",mmi = '" + mmi + '\'' + 
			",type = '" + type + '\'' + 
			",title = '" + title + '\'' + 
			",magType = '" + magType + '\'' + 
			",nst = '" + nst + '\'' + 
			",sig = '" + sig + '\'' + 
			",tsunami = '" + tsunami + '\'' + 
			",mag = '" + mag + '\'' + 
			",alert = '" + alert + '\'' + 
			",gap = '" + gap + '\'' + 
			",rms = '" + rms + '\'' + 
			",place = '" + place + '\'' + 
			",net = '" + net + '\'' + 
			",types = '" + types + '\'' + 
			",felt = '" + felt + '\'' + 
			",cdi = '" + cdi + '\'' + 
			",url = '" + url + '\'' + 
			",ids = '" + ids + '\'' + 
			",time = '" + time + '\'' + 
			",detail = '" + detail + '\'' + 
			",updated = '" + updated + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}