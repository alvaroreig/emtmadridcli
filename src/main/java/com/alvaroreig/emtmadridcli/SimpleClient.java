package com.alvaroreig.emtmadridcli;

/**
 * Hello world!
 *
 */
public class SimpleClient {
	
	
	public static void main(String[] args) {
		System.out.println("Client Working");

		StopList stopList = Api.getTimesFromStop(2127);

		for (int i = 0; i < stopList.getArrives().size(); i++) {
			System.out.println(stopList.getArrives().get(i).getLineId());
			System.out.println(stopList.getArrives().get(i).getBusTimeLeft());
			System.out.println(Helper.secondsToHuman(stopList.getArrives().get(i).getBusTimeLeft()));
			System.out.println("----");
		}
	}
}
