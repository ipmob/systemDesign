# Weather API - README

This API provides weather data for a given city, including current weather, latitude, and longitude. The response format can be specified using the `output_format` flag, supporting JSON and XML formats.

## API Endpoint

- Endpoint: POST /getCurrentWeather

## Request

The API expects the following request body parameters:

- `city`: The name of the city for which weather data is requested.
- `output_format`: The desired format of the response. Options are "json" or "xml".

Example Request Body (JSON):
```json
{
    "city": "Bangalore",
    "output_format": "json"
}
```

## Response

The API response contains the weather-related data for the requested city. The format of the response is dictated by the `output_format` flag.

### JSON Response Example

```json
{
    "Weather": "20 C",
    "Latitude": "12.9716",
    "Longitude": "77.5946",
    "City": "Bangalore India"
}
```

### XML Response Example

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<root>
    <Temperature>24.0</Temperature>
    <City>Bangalore</City>
    <Latitude>12.98</Latitude>
    <Longitude>77.58</Longitude>
</root>
```

## API Key

To access the API, you need to include the API key in the headers of your request:

- Header: x-rapidapi-key
- Value: 31371bc5c3msh34f399b07961d46p192883jsn2ba7562e3194

**Note:** Ensure not to push the API key to any public source control system to maintain its security.

## Useful Links

- [Weather API on RapidAPI](https://rapidapi.com/weatherapi/api/weatherapi-com)

---

Feel free to modify the code provided to suit your project's requirements. Follow the PEP 8 standards while writing the Python code.