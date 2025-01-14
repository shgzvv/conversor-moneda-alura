package org.example;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Backend {
    public static double cambioMoneda (String countryValueFrom, String countryValueTo) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://v6.exchangerate-api.com/v6/05661c71ef69ced45998ce21/latest/"+countryValueFrom))
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());


        JsonParser parser = new JsonParser();
        JsonObject jsonObject = (JsonObject) parser.parse(response.body())
                .getAsJsonObject().get("conversion_rates");

        return jsonObject.get(countryValueTo).getAsDouble();
    }

}
