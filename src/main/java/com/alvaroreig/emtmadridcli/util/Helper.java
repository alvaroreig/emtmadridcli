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
		System.out.println("java -jar emtmadridcli.jar API_CLIENT_ID API_PASSKEY incomingBusToStop console-pretty STOP_NUMBER");
		System.out.println("java -jar emtmadridcli.jar API_CLIENT_ID API_PASSKEY incomingBusToStop console-pretty STOP_NUMBER LINE_NUMBER");
		System.out.println("java -jar emtmadridcli.jar API_CLIENT_ID API_PASSKEY incomingBusToStop bare-seconds STOP_NUMBER LINE_NUMBER INSTANCE");
	}
	
	public static void prettyPrintToConsole(IncomingBusList incomingBusList){
		if (incomingBusList.getArrives() != null) {
			for (int i = 0; i < incomingBusList.getArrives().size(); i++) {
				System.out.println(incomingBusList.getArrives().get(i)
						.getLineId() + ": " + Helper.secondsToHuman(incomingBusList
								.getArrives().get(i).getBusTimeLeft()));
			}
		} else {
			System.out.println("Something went wrong");
		}
	}
	
	public static void printSecondsToInstance(IncomingBusList incomingBusList, int position){
		if ((incomingBusList.getArrives() != null)&&(incomingBusList.getArrives().get(position) != null)) {
			System.out.println(incomingBusList.getArrives().get(position).getBusTimeLeft());
		} 
		
	}

}
