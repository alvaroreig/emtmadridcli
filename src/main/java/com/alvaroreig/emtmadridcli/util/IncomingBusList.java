package com.alvaroreig.emtmadridcli.util;

import java.util.ArrayList;
import java.util.List;

public class IncomingBusList {
	private List<IncomingBus> arrives;

	public IncomingBusList(List<IncomingBus> arrives) {
		super();
		this.arrives = arrives;
	}

	public IncomingBusList() {
		arrives = new ArrayList<IncomingBus>();
	}

	public List<IncomingBus> getArrives() {
		return arrives;
	}

	public void setArrives(List<IncomingBus> arrives) {
		this.arrives = arrives;
	}
	
	public void addIncomingBus(IncomingBus incomingBus){
		arrives.add(incomingBus);
	}
	
	

}
