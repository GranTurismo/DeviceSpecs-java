package com.granturismo.devicespecs;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.granturismo.devicespecs.filter.DeviceFilterBuilder;
import com.granturismo.devicespecs.models.DeviceSpecsResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class DeviceSpecsClient {
    public static final String DEFAULT_BASE_URL = "https://prod.api.market/api/v1/granturismo/device-specs-api";
    public static final String HEADER_API_KEY = "x-api-market-key";

    private final String apiKey;
    private final String baseUrl;
    private final int connectTimeoutMs;
    private final int readTimeoutMs;
    private final Gson gson;

    public DeviceSpecsClient(String apiKey) {
        this(apiKey, DEFAULT_BASE_URL);
    }

    public DeviceSpecsClient(String apiKey, String baseUrl) {
        this(apiKey, baseUrl, 10000, 15000);
    }

    public DeviceSpecsClient(String apiKey, String baseUrl, int connectTimeoutMs, int readTimeoutMs) {
        if (apiKey == null || apiKey.trim().isEmpty()) {
            throw new IllegalArgumentException("API Key must not be null or empty.");
        }
        this.apiKey = apiKey;
        this.baseUrl = (baseUrl != null && baseUrl.endsWith("/")) ? baseUrl.substring(0, baseUrl.length() - 1) : (baseUrl != null ? baseUrl : DEFAULT_BASE_URL);
        this.connectTimeoutMs = connectTimeoutMs;
        this.readTimeoutMs = readTimeoutMs;
        this.gson = new Gson();
    }

    public String getApiKey() {
        return apiKey;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    // List all devices
    public List<DeviceSpecsResponse> getDevices() {
        return getDevices(null);
    }

    public List<DeviceSpecsResponse> getDevices(DeviceFilterBuilder filter) {
        return executeGetList("/api/values/clean/devices" + (filter != null ? filter.toQueryString() : ""));
    }

    public CompletableFuture<List<DeviceSpecsResponse>> getDevicesAsync() {
        return getDevicesAsync(null);
    }

    public CompletableFuture<List<DeviceSpecsResponse>> getDevicesAsync(DeviceFilterBuilder filter) {
        return CompletableFuture.supplyAsync(() -> getDevices(filter));
    }

    // Devices by Manufacturer
    public List<DeviceSpecsResponse> getDevicesByManufacturer(String manufacturer) {
        return getDevicesByManufacturer(manufacturer, null);
    }

    public List<DeviceSpecsResponse> getDevicesByManufacturer(String manufacturer, DeviceFilterBuilder filter) {
        String path = "/api/values/clean/getdevices/" + encodePathSegment(manufacturer) + (filter != null ? filter.toQueryString() : "");
        return executeGetList(path);
    }

    public CompletableFuture<List<DeviceSpecsResponse>> getDevicesByManufacturerAsync(String manufacturer, DeviceFilterBuilder filter) {
        return CompletableFuture.supplyAsync(() -> getDevicesByManufacturer(manufacturer, filter));
    }

    // Devices by Chipset
    public List<DeviceSpecsResponse> getDevicesByChipset(String chipset) {
        return getDevicesByChipset(chipset, null);
    }

    public List<DeviceSpecsResponse> getDevicesByChipset(String chipset, DeviceFilterBuilder filter) {
        String path = "/api/values/clean/devicesbychipset/" + encodePathSegment(chipset) + (filter != null ? filter.toQueryString() : "");
        return executeGetList(path);
    }

    public CompletableFuture<List<DeviceSpecsResponse>> getDevicesByChipsetAsync(String chipset, DeviceFilterBuilder filter) {
        return CompletableFuture.supplyAsync(() -> getDevicesByChipset(chipset, filter));
    }

    // Specific Specs by Manufacturer and Model
    public DeviceSpecsResponse getDeviceSpecs(String manufacturer, String model) {
        String path = "/api/values/clean/getspecs/" + encodePathSegment(manufacturer) + "/" + encodePathSegment(model);
        return executeGetSingle(path);
    }

    public CompletableFuture<DeviceSpecsResponse> getDeviceSpecsAsync(String manufacturer, String model) {
        return CompletableFuture.supplyAsync(() -> getDeviceSpecs(manufacturer, model));
    }

    // Helper HTTP execution methods using Android-compatible HttpURLConnection
    private List<DeviceSpecsResponse> executeGetList(String pathAndQuery) {
        String jsonBody = httpGet(pathAndQuery);
        Type listType = new TypeToken<List<DeviceSpecsResponse>>() {}.getType();
        List<DeviceSpecsResponse> result = gson.fromJson(jsonBody, listType);
        return result != null ? result : Collections.emptyList();
    }

    private DeviceSpecsResponse executeGetSingle(String pathAndQuery) {
        String jsonBody = httpGet(pathAndQuery);
        return gson.fromJson(jsonBody, DeviceSpecsResponse.class);
    }

    private String httpGet(String pathAndQuery) {
        HttpURLConnection connection = null;
        try {
            URL url = new URL(baseUrl + pathAndQuery);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(connectTimeoutMs);
            connection.setReadTimeout(readTimeoutMs);
            connection.setRequestProperty(HEADER_API_KEY, apiKey);
            connection.setRequestProperty("Accept", "application/json");

            int status = connection.getResponseCode();
            InputStream inputStream = (status >= 200 && status < 300) ? connection.getInputStream() : connection.getErrorStream();

            String responseBody = readStream(inputStream);
            if (status < 200 || status >= 300) {
                throw new RuntimeException("DeviceSpecs API request failed with status code " + status + ": " + responseBody);
            }
            return responseBody;
        } catch (IOException e) {
            throw new RuntimeException("Error executing request to DeviceSpecs API: " + e.getMessage(), e);
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
    }

    private String readStream(InputStream inputStream) throws IOException {
        if (inputStream == null) return "";
        StringBuilder sb = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8))) {
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line).append("\n");
            }
        }
        return sb.toString().trim();
    }

    private String encodePathSegment(String value) {
        if (value == null) return "";
        try {
            return URLEncoder.encode(value, "UTF-8").replace("+", "%20");
        } catch (Exception e) {
            return value;
        }
    }
}
