package com.stripe.interview.urlparsing;

import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import kong.unirest.UnirestException;
import kong.unirest.json.JSONObject;

import java.util.logging.Logger;

public class WeatherAPIClient {
    private static final String API_KEY = "a280faafe4msh7f9ad872327c9b5p1154f3jsna5acac31ffb6";
    private static final String BASE_URL = "http://api.weatherapi.com/v1";
    private static final Logger logger = Logger.getLogger(WeatherAPIClient.class.getName());

    public WeatherData getCurrentWeather(String city, String outputFormat) {
        String url = "https://weatherapi-com.p.rapidapi.com/current.json?q=";

        final String URL = url + city;
        HttpResponse<String> response = Unirest.get(URL)
                .header("X-RapidAPI-Key",API_KEY)
                .header("X-RapidAPI-Host", "weatherapi-com.p.rapidapi.com")
                .asString();

        if (response.isSuccess()) {
            String responseBody = response.getBody();
            WeatherData weatherData;

            if (outputFormat.equals("json")) {
                weatherData = parseJsonResponse(responseBody);
            } else if (outputFormat.equals("xml")) {
                // Parse XML response and extract the required data
                // weatherData = parseXmlResponse(responseBody);
                // ...
                throw new UnsupportedOperationException("XML response parsing not implemented yet");
            } else {
                throw new IllegalArgumentException("Invalid output format specified");
            }

            return weatherData;
        } else {
            throw new IllegalStateException("Request failed with status code: " + response.getStatus());
        }
    }

    private WeatherData parseJsonResponse(String stringResponse) {
        JSONObject jsonResponse = new JSONObject(stringResponse);
        JSONObject current = jsonResponse.getJSONObject("current");
        JSONObject location = jsonResponse.getJSONObject("location");
        final String weather = current.getJSONObject("condition").toString();
        final double latitude = location.getDouble("lat");
        final double longitude = location.getDouble("lon");
        final String city = location.getString("name");

        return new WeatherData(weather, latitude, longitude, city);
    }

    // Other methods for XML parsing and extraction if needed

    public static void main(String[] args) {
        WeatherAPIClient client = new WeatherAPIClient();

        // Test case 1: Single language
        String city = "Paris";
        String outputFormat = "json";
        try{
            final WeatherData weatherData = client.getCurrentWeather(city, outputFormat);
            logger.info("Weather: " + weatherData.getConditionText());
            logger.info("Latitude: " + weatherData.getLatitude());
            logger.info("Longitude: " + weatherData.getLongitude());
            logger.info("City: " + weatherData.getCityName());
        }
        catch (UnirestException e){
            logger.severe("Error occurred while fetching weather data: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
