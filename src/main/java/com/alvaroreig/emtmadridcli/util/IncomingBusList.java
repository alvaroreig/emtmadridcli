package com.alvaroreig.emtmadridcli.util;

import java.util.List;

public class IncomingBusList {
	private List<IncomingBus> arrives;

	public IncomingBusList(List<IncomingBus> arrives) {
		super();
		this.arrives = arrives;
	}

	public List<IncomingBus> getArrives() {
		return arrives;
	}

	public void setArrives(List<IncomingBus> arrives) {
		this.arrives = arrives;
	}
	
	

}
