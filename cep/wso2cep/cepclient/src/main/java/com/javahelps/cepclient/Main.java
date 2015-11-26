package com.javahelps.cepclient;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import com.google.gson.JsonObject;

public class Main {
	/**
	 * URL of the event receiver.
	 */
	private static final String URL = "http://localhost:9763/endpoints/TemperatureReceiver";

	public static void main(String[] args) {
		// Create an HTTP client.
		HttpClient httpClient = HttpClientBuilder.create().build();

		// Create a POST method using the receiver URL.
		HttpPost method = new HttpPost(URL);

		// Create a JsonObject for the event.
		JsonObject event = new JsonObject();

		// Create another JsonObject for pay-load data.
		JsonObject payLoadData = new JsonObject();

		// Set the temperature.
		payLoadData.addProperty("temp", 42.6f);

		event.add("payloadData", payLoadData);

		// Convert the JsonObject to String.
		String eventString = "{\"event\": " + event + "}";

		try {
			// Create an entity and add it to the method.
			StringEntity entity = new StringEntity(eventString);
			method.setEntity(entity);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		try {
			// Execute the method and retrieve the response.
			HttpResponse response = httpClient.execute(method);

			// Get the entity out of the response.
			HttpEntity httpEntity = response.getEntity();

			int status = response.getStatusLine().getStatusCode();

			// Check the status code for successful completion.
			if (status == 200) {
				System.out.println("Published");
			} else {
				System.out.println("Failed to publish");
			}

			// Close the connection and release the resources.
			try {
				EntityUtils.consume(httpEntity);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
