package com.alvaroreig.emtmadridcli;

import com.alvaroreig.emtmadridcli.util.Helper;
import com.alvaroreig.emtmadridcli.util.IncomingBusList;
import com.google.gson.Gson;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;

public class Api {
	static final String BASE_URL = "https://openbus.emtmadrid.es:9443/emt-proxy-server/last";
	static final String TIMES_FROM_STOP_URL = "/geo/GetArriveStop.php";
	static String API_CLIENT_ID = "XXXXX";
	static String API_PASSKEY = "YYYYYY";

	/* Returns bus times from stop if 200, null otherwise */
	public static IncomingBusList getTimesFromStop(int stopCode) {
		try {
			HttpResponse<JsonNode> jsonResponse = Unirest
					.post(BASE_URL + TIMES_FROM_STOP_URL)
					.header("accept", "application/json")
					.field("idClient", API_CLIENT_ID)
					.field("passKey", API_PASSKEY).field("idStop", stopCode)
					.field("cultureInfo", "ES").asJson();

			String json = jsonResponse.getBody().toString();

			final Gson gson = new Gson();
			final IncomingBusList stopList = gson.fromJson(json,
					IncomingBusList.class);

			if (jsonResponse.getCode() == 200) {
				return stopList;
			} else {
				return null;
			}

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	public static void main(String[] args) {
		IncomingBusList incomingBusList;
		

		switch (args.length){
			case 4: {
				if ( args[2].equals("incomingBusToStop")){
					try{
						API_CLIENT_ID = args[0];
						API_PASSKEY = args[1];
						int busStop = Integer.parseInt(args[3]);
						
						incomingBusList = Api.getTimesFromStop(busStop);
						Helper.printResultAllLines(incomingBusList);
						break;
						
					}catch (NumberFormatException  e){
						System.out.println("STOP_NUMBER format incorrect");
						Helper.printUsageDirectives();
						break;
					}
				}
			}
			default: {
				Helper.printUsageDirectives();
				break;
			}
			
		}
		
		//incomingBusToStop 2127
		//incomingBusToStop 2127 32

		//incomingBusList = Api.getTimesFromStop(2127);

		//Helper.printResultAllLines(incomingBusList);
	}

}