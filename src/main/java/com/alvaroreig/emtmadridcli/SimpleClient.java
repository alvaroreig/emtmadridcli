package com.alvaroreig.emtmadridcli;

import com.alvaroreig.emtmadridcli.util.Helper;
import com.alvaroreig.emtmadridcli.util.IncomingBusList;

/**
 * Hello world!
 *
 */
public class SimpleClient {
	
	
	public static void main(String[] args) {
		System.out.println("Client Working");

		IncomingBusList incomingBusList = Api.getTimesFromStop(2127);

		if (incomingBusList.getArrives() != null){
		for (int i = 0; i < incomingBusList.getArrives().size(); i++) {
			System.out.println(incomingBusList.getArrives().get(i).getLineId());
			System.out.println(incomingBusList.getArrives().get(i).getBusTimeLeft());
			System.out.println(Helper.secondsToHuman(incomingBusList.getArrives().get(i).getBusTimeLeft()));
			System.out.println("----");
		}
		}else{
			System.out.println("Shomething went wrong");
		}
	}
}
