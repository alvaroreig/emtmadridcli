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
					.post("http://httpbin.org/post")
					.header("accept", "application/json")
					.field("parameter", "value").field("foo", "bar").asJson();
			
			System.out.println(jsonResponse.getCode());
			System.out.println(jsonResponse.getBody());
		} catch (UnirestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
