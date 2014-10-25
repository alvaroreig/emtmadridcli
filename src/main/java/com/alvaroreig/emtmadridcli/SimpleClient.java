package com.alvaroreig.emtmadridcli;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

/**
 * Hello world!
 *
 */
public class SimpleClient {
	public static void main(String[] args) {
		System.out.println("Client Working");

		try {
			HttpResponse<JsonNode> jsonResponse = Unirest
					.post("https://openbus.emtmadrid.es:9443/emt-proxy-server/last/geo/GetArriveStop.php")
					.header("accept", "application/json")
					.field("idClient", "XXXXXXXXX")
					.field("passKey", "YYYYYY")
					.field("idStop", "31232")
					.field("cultureInfo", "ES")
					.asJson();
			
			System.out.println(jsonResponse.getCode());
			System.out.println(jsonResponse.getBody());
		} catch (UnirestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
