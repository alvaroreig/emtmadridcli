package com.alvaroreig.emtmadridcli.util;

public class Helper {
	
	static final int MAX_SECONDS = 999999;
	static final int SECONDS_PER_MINUTE = 60;
	public static String secondsToHuman(int seconds){
		
		String retorno = "-2";
		if (seconds == MAX_SECONDS){
			retorno = "+20m";
		}else
		
		if (seconds < SECONDS_PER_MINUTE){
			retorno = Integer.toString(seconds) + " secs.";
		}
		else{
			int module = seconds % SECONDS_PER_MINUTE;
			retorno = Integer.toString((seconds - module)/SECONDS_PER_MINUTE) + " min " +
					Integer.toString(module) + " secs.";
		}
		return retorno;
	}

}
