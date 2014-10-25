package com.alvaroreig.emtmadridcli;

import java.util.List;

public class StopList {
	private List<Stop> arrives;

	public StopList(List<Stop> arrives) {
		super();
		this.arrives = arrives;
	}

	public List<Stop> getArrives() {
		return arrives;
	}

	public void setArrives(List<Stop> arrives) {
		this.arrives = arrives;
	}
	
	

}
