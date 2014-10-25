package com.alvaroreig.emtmadridcli.util;

public class Helper {

	static final int MAX_SECONDS = 999999;
	static final int SECONDS_PER_MINUTE = 60;

	public static String secondsToHuman(int seconds) {

		String retorno;
		
		if (seconds == MAX_SECONDS) {
			retorno = "+20m";
		} else if (seconds < SECONDS_PER_MINUTE) {
			retorno = Integer.toString(seconds) + " secs.";
		} else {
			int module = seconds % SECONDS_PER_MINUTE;
			retorno = Integer.toString((seconds - module) / SECONDS_PER_MINUTE)
				+ " min " + Integer.toString(module) + " secs.";
		}
		return retorno;
	}
	
	public static void printUsageDirectives(){
		System.out.println("Usage");
		System.out.println("java -jar emtmadridcli.jar API_CLIENT_ID API_PASSKEY incomingBusToStop STOP_NUMBER");
		System.out.println("java -jar emtmadridcli.jar API_CLIENT_ID API_PASSKEY incomingBusToStop STOP_NUMBER LINE_NUMBER");
	}
	
	public static void printResultAllLines(IncomingBusList incomingBusList){
		if (incomingBusList.getArrives() != null) {
			for (int i = 0; i < incomingBusList.getArrives().size(); i++) {
				System.out.println(incomingBusList.getArrives().get(i)
						.getLineId());
				System.out.println(incomingBusList.getArrives().get(i)
						.getBusTimeLeft());
				System.out.println(Helper.secondsToHuman(incomingBusList
						.getArrives().get(i).getBusTimeLeft()));
				System.out.println("----");
			}
		} else {
			System.out.println("Something went wrong");
		}
	}

}
