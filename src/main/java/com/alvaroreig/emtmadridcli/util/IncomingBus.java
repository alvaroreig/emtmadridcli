package com.alvaroreig.emtmadridcli.util;

public class IncomingBus {
	private String busId;
	private int busDistantce;
	private float latitude;
	private String destination;
	private int stopId;
	private int lineId;
	private boolean isHead;
	private int busPositionType;
	private int busTimeLeft;
	private float longitude;
	public String getBusId() {
		return busId;
	}
	public void setBusId(String busId) {
		this.busId = busId;
	}
	public int getBusDistantce() {
		return busDistantce;
	}
	public void setBusDistantce(int busDistantce) {
		this.busDistantce = busDistantce;
	}
	public float getLatitude() {
		return latitude;
	}
	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public int getStopId() {
		return stopId;
	}
	public void setStopId(int stopId) {
		this.stopId = stopId;
	}
	public int getLineId() {
		return lineId;
	}
	public void setLineId(int lineId) {
		this.lineId = lineId;
	}
	public boolean isHead() {
		return isHead;
	}
	public void setHead(boolean isHead) {
		this.isHead = isHead;
	}
	public int getBusPositionType() {
		return busPositionType;
	}
	public void setBusPositionType(int busPositionType) {
		this.busPositionType = busPositionType;
	}
	public int getBusTimeLeft() {
		return busTimeLeft;
	}
	public void setBusTimeLeft(int busTimeLeft) {
		this.busTimeLeft = busTimeLeft;
	}
	public float getLongitude() {
		return longitude;
	}
	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}
	
	
}
