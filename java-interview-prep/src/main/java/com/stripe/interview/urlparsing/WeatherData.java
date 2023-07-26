package com.stripe.interview.urlparsing;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class WeatherData {
    private String cityName;
    private String region;
    private String country;
    private double latitude;
    private double longitude;
    private String timeZoneId;
    private long localTimeEpoch;
    private String localTime;
    private long lastUpdatedEpoch;
    private String lastUpdated;
    private double temperatureC;
    private double temperatureF;
    private int isDay;
    private String conditionText;
    private String conditionIcon;
    private int conditionCode;
    private double windMph;
    private double windKph;
    private int windDegree;
    private String windDirection;
    private double pressureMb;
    private double pressureIn;
    private double precipMm;
    private double precipIn;
    private int humidity;
    private int cloud;
    private double feelsLikeC;
    private double feelsLikeF;
    private double visibilityKm;
    private double visibilityMiles;
    private int uv;
    private double gustMph;
    private double gustKph;

    public WeatherData(String weather, double latitude, double longitude, String city) {
    }
}
