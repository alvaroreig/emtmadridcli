package com.alvaroreig.emtmadridcli;

import com.alvaroreig.emtmadridcli.util.Helper;
import com.alvaroreig.emtmadridcli.util.IncomingBus;
import com.alvaroreig.emtmadridcli.util.IncomingBusList;
import com.google.gson.Gson;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;

public class Api {
	static final String BASE_URL = "https://openbus.emtmadrid.es:9443/emt-proxy-server/last";
	static final String TIMES_FROM_STOP_URL = "/geo/GetArriveStop.php";
	static String API_CLIENT_ID;
	static String API_PASSKEY;

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

			Unirest.shutdown();

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

	public static IncomingBusList getTimesFromStopSpecificLine(int stopCode,
			int lineNumber) {
		IncomingBusList original = getTimesFromStop(stopCode);
		IncomingBusList filtered = new IncomingBusList();
		IncomingBus currentBus;

		for (int i = 0; i < original.getArrives().size(); i++) {
			currentBus = original.getArrives().get(i);
			if (currentBus.getLineId() == lineNumber) {
				filtered.addIncomingBus(currentBus);
			}
		}
		return filtered;
	}

	public static void main(String[] args) {
		IncomingBusList incomingBusList;

		switch (args.length) {
			/*This case pretty console returns all bus lines for a bus stop*/
			/*5 arguments expected: CLIENT_ID, PASSKEY, incomingBusStop, console-pretty, busStop*/
			case 5: {
				if ((args[2].equals("incomingBusToStop"))&&(args[3].equals("console-pretty"))) {
					try {
						API_CLIENT_ID = args[0];
						API_PASSKEY = args[1];
						int busStop = Integer.parseInt(args[4]);
	
						incomingBusList = Api.getTimesFromStop(busStop);
						Helper.prettyPrintToConsole(incomingBusList);
						break;
	
					} catch (NumberFormatException e) {
						System.out.println("STOP_NUMBER format incorrect");
						Helper.printUsageDirectives();
						break;
					}
				} else {
					System.out.println("Unrecognized action");
					Helper.printUsageDirectives();
					break;
				}
			}
			/*This case pretty console returns bus for a given line in a given bus stop*/
			/*6 arguments expected: CLIENT_ID, PASSKEY, incomingBusStop,console-pretty, busStop, busLine*/
			case 6: {
				if ((args[2].equals("incomingBusToStop"))&&(args[3].equals("console-pretty"))) {
					try {
						API_CLIENT_ID = args[0];
						API_PASSKEY = args[1];
						int busStop = Integer.parseInt(args[4]);
						int busLine = Integer.parseInt(args[5]);
	
						incomingBusList = Api.getTimesFromStopSpecificLine(busStop,
								busLine);
						Helper.prettyPrintToConsole(incomingBusList);
						break;
	
					} catch (NumberFormatException e) {
						System.out
								.println("STOP_NUMBER or BUS_LINE format incorrect");
						Helper.printUsageDirectives();
						break;
					}
				} else {
					System.out.println("Unrecognized action");
					Helper.printUsageDirectives();
					break;
				}
			}
			/*This case returns the seconds for a given instance(first or second bus) for a given line 
			 * in a given bus stop 
			/* 7 arguments expected: CLIENT_ID, PASSKEY, incomingBusStop,bare-seconds, 
			 * busStop, busLine, instance */
			case 7: {
				if ((args[2].equals("incomingBusToStop"))&&(args[3].equals("bare-seconds"))) {
					try {
						API_CLIENT_ID = args[0];
						API_PASSKEY = args[1];
						int busStop = Integer.parseInt(args[4]);
						int busLine = Integer.parseInt(args[5]);
						int instance = Integer.parseInt(args[6]);
	
						incomingBusList = Api.getTimesFromStopSpecificLine(busStop,
								busLine);
						Helper.printSecondsToInstance(incomingBusList, instance);
						break;
	
					} catch (NumberFormatException e) {
						System.out
								.println("STOP_NUMBER or BUS_LINE format incorrect");
						Helper.printUsageDirectives();
						break;
					}
				} else {
					System.out.println("Unrecognized action");
					Helper.printUsageDirectives();
					break;
				}
			}
			default: {
				Helper.printUsageDirectives();
				break;
			}

		}
	}
}