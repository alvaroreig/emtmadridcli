package com.alvaroreig.emtmadridcli.util;

import java.util.logging.Logger;

public class Helper {

	static final int MAX_SECONDS = 999999;
	static final int SECONDS_PER_MINUTE = 60;
	private final static Logger log = Logger.getLogger(Helper.class.getName());

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
		log.severe("Usage");
		log.severe("java -jar emtmadridcli.jar API_CLIENT_ID API_PASSKEY incomingBusToStop pretty-console STOP_NUMBER");
		log.severe("java -jar emtmadridcli.jar API_CLIENT_ID API_PASSKEY incomingBusToStop pretty-console STOP_NUMBER LINE_NUMBER");
		log.severe("java -jar emtmadridcli.jar API_CLIENT_ID API_PASSKEY incomingBusToStop bare-seconds STOP_NUMBER LINE_NUMBER INSTANCE");
	}
	
	public static void prettyPrintToConsole(IncomingBusList incomingBusList){
		if (incomingBusList.getArrives() != null) {
			for (int i = 0; i < incomingBusList.getArrives().size(); i++) {
				System.out.println(incomingBusList.getArrives().get(i)
						.getLineId() + ": " + Helper.secondsToHuman(incomingBusList
								.getArrives().get(i).getBusTimeLeft()));
			}
		}
	}
	
	public static void printSecondsToInstance(IncomingBusList incomingBusList, int position){
		if ((incomingBusList.getArrives() != null)&&(incomingBusList.getArrives().get(position) != null)) {
			System.out.println(incomingBusList.getArrives().get(position).getBusTimeLeft());
		} 
		
	}

}
