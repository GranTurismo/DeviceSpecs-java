package com.granturismo.devicespecs;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.granturismo.devicespecs.filter.DeviceFilterBuilder;
import com.granturismo.devicespecs.models.DeviceSpecsResponse;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class DeviceSpecsClient {
    public static final String DEFAULT_BASE_URL = "https://prod.api.market/api/v1/granturismo/device-specs-api";
    public static final String HEADER_API_KEY = "x-api-market-key";

    private final String apiKey;
    private final String baseUrl;
    private final HttpClient httpClient;
    private final Gson gson;

    public DeviceSpecsClient(String apiKey) {
        this(apiKey, DEFAULT_BASE_URL);
    }

    public DeviceSpecsClient(String apiKey, String baseUrl) {
        this(apiKey, baseUrl, HttpClient.newBuilder()
                .connectTimeout(Duration.ofSeconds(10))
                .build());
    }

    public DeviceSpecsClient(String apiKey, String baseUrl, HttpClient httpClient) {
        if (apiKey == null || apiKey.trim().isEmpty()) {
            throw new IllegalArgumentException("API Key must not be null or empty.");
        }
        this.apiKey = apiKey;
        this.baseUrl = (baseUrl != null && baseUrl.endsWith("/")) ? baseUrl.substring(0, baseUrl.length() - 1) : (baseUrl != null ? baseUrl : DEFAULT_BASE_URL);
        this.httpClient = httpClient;
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
        return executeGetListAsync("/api/values/clean/devices" + (filter != null ? filter.toQueryString() : ""));
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
        String path = "/api/values/clean/getdevices/" + encodePathSegment(manufacturer) + (filter != null ? filter.toQueryString() : "");
        return executeGetListAsync(path);
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
        String path = "/api/values/clean/devicesbychipset/" + encodePathSegment(chipset) + (filter != null ? filter.toQueryString() : "");
        return executeGetListAsync(path);
    }

    // Specific Specs by Manufacturer and Model
    public DeviceSpecsResponse getDeviceSpecs(String manufacturer, String model) {
        String path = "/api/values/clean/getspecs/" + encodePathSegment(manufacturer) + "/" + encodePathSegment(model);
        return executeGetSingle(path);
    }

    public CompletableFuture<DeviceSpecsResponse> getDeviceSpecsAsync(String manufacturer, String model) {
        String path = "/api/values/clean/getspecs/" + encodePathSegment(manufacturer) + "/" + encodePathSegment(model);
        return executeGetSingleAsync(path);
    }

    // Helper HTTP execution methods
    private List<DeviceSpecsResponse> executeGetList(String pathAndQuery) {
        HttpRequest request = buildRequest(pathAndQuery);
        try {
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            validateResponse(response);
            Type listType = new TypeToken<List<DeviceSpecsResponse>>() {}.getType();
            List<DeviceSpecsResponse> result = gson.fromJson(response.body(), listType);
            return result != null ? result : Collections.emptyList();
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Error executing request to DeviceSpecs API: " + e.getMessage(), e);
        }
    }

    private CompletableFuture<List<DeviceSpecsResponse>> executeGetListAsync(String pathAndQuery) {
        HttpRequest request = buildRequest(pathAndQuery);
        return httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(response -> {
                    validateResponse(response);
                    Type listType = new TypeToken<List<DeviceSpecsResponse>>() {}.getType();
                    List<DeviceSpecsResponse> result = gson.fromJson(response.body(), listType);
                    return result != null ? result : Collections.emptyList();
                });
    }

    private DeviceSpecsResponse executeGetSingle(String pathAndQuery) {
        HttpRequest request = buildRequest(pathAndQuery);
        try {
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            validateResponse(response);
            return gson.fromJson(response.body(), DeviceSpecsResponse.class);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Error executing request to DeviceSpecs API: " + e.getMessage(), e);
        }
    }

    private CompletableFuture<DeviceSpecsResponse> executeGetSingleAsync(String pathAndQuery) {
        HttpRequest request = buildRequest(pathAndQuery);
        return httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(response -> {
                    validateResponse(response);
                    return gson.fromJson(response.body(), DeviceSpecsResponse.class);
                });
    }

    private HttpRequest buildRequest(String pathAndQuery) {
        return HttpRequest.newBuilder()
                .uri(URI.create(baseUrl + pathAndQuery))
                .header(HEADER_API_KEY, apiKey)
                .header("Accept", "application/json")
                .GET()
                .build();
    }

    private void validateResponse(HttpResponse<String> response) {
        int status = response.statusCode();
        if (status < 200 || status >= 300) {
            throw new RuntimeException("DeviceSpecs API request failed with status code " + status + ": " + response.body());
        }
    }

    private String encodePathSegment(String value) {
        if (value == null) return "";
        return URLEncoder.encode(value, StandardCharsets.UTF_8).replace("+", "%20");
    }
}
