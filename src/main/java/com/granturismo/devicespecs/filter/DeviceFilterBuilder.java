package com.granturismo.devicespecs.filter;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Consumer;

public class DeviceFilterBuilder {
    private final Map<String, String> queryParams = new LinkedHashMap<>();

    public static DeviceFilterBuilder builder() {
        return new DeviceFilterBuilder();
    }

    public DeviceFilterBuilder addParam(String key, String value) {
        if (key != null && !key.isEmpty() && value != null) {
            queryParams.put(key, value);
        }
        return this;
    }

    public DeviceFilterBuilder where(String key, String value) {
        return addParam(key, value);
    }

    public DeviceFilterBuilder where(String property, String operator, String value) {
        if (operator == null || operator.isEmpty() || operator.equalsIgnoreCase("eq")) {
            return addParam(property, value);
        }
        return addParam(property + "_" + operator.toLowerCase(), value);
    }

    // Root Filters
    public DeviceFilterBuilder manufacturer(String value) {
        return addParam("manufacturer", value);
    }

    public DeviceFilterBuilder manufacturerIn(String... values) {
        return addParam("manufacturer_in", String.join(",", values));
    }

    public DeviceFilterBuilder model(String value) {
        return addParam("model", value);
    }

    public DeviceFilterBuilder modelContains(String value) {
        return addParam("model_contains", value);
    }

    public DeviceFilterBuilder chipset(String value) {
        return addParam("chipset", value);
    }

    public DeviceFilterBuilder chipsetContains(String value) {
        return addParam("chipset_contains", value);
    }

    public DeviceFilterBuilder androidVersion(String value) {
        return addParam("android", value);
    }

    public DeviceFilterBuilder priceUsdLte(double value) {
        return addParam("price_lte", String.valueOf(value));
    }

    public DeviceFilterBuilder priceUsdGt(double value) {
        return addParam("price_gt", String.valueOf(value));
    }

    public DeviceFilterBuilder priceUsdBetween(double min, double max) {
        return addParam("price_between", min + "," + max);
    }

    // Direct convenience shortcuts
    public DeviceFilterBuilder ramGte(int value) {
        return addParam("ram_gte", String.valueOf(value));
    }

    public DeviceFilterBuilder ramBetween(int min, int max) {
        return addParam("ram_between", min + "," + max);
    }

    public DeviceFilterBuilder batteryCapacityGte(int value) {
        return addParam("battery_gte", String.valueOf(value));
    }

    public DeviceFilterBuilder displaySizeGte(double value) {
        return addParam("display.size_inches_gte", String.valueOf(value));
    }

    public DeviceFilterBuilder refreshRateGte(int value) {
        return addParam("refresh_rate_hz_gte", String.valueOf(value));
    }

    public DeviceFilterBuilder hasNfc(boolean value) {
        return addParam("nfc_has", String.valueOf(value));
    }

    public DeviceFilterBuilder isWaterResistant(boolean value) {
        return addParam("water_resistant_has", String.valueOf(value));
    }

    // Category builder chain
    public DisplayFilterBuilder display() {
        return new DisplayFilterBuilder(this);
    }

    public DeviceFilterBuilder display(Consumer<DisplayFilterBuilder> consumer) {
        consumer.accept(display());
        return this;
    }

    public ProcessorFilterBuilder processor() {
        return new ProcessorFilterBuilder(this);
    }

    public DeviceFilterBuilder processor(Consumer<ProcessorFilterBuilder> consumer) {
        consumer.accept(processor());
        return this;
    }

    public MemoryFilterBuilder memory() {
        return new MemoryFilterBuilder(this);
    }

    public DeviceFilterBuilder memory(Consumer<MemoryFilterBuilder> consumer) {
        consumer.accept(memory());
        return this;
    }

    public PowerFilterBuilder power() {
        return new PowerFilterBuilder(this);
    }

    public DeviceFilterBuilder power(Consumer<PowerFilterBuilder> consumer) {
        consumer.accept(power());
        return this;
    }

    public CameraFilterBuilder cameras() {
        return new CameraFilterBuilder(this);
    }

    public DeviceFilterBuilder cameras(Consumer<CameraFilterBuilder> consumer) {
        consumer.accept(cameras());
        return this;
    }

    public PhysicalFilterBuilder physical() {
        return new PhysicalFilterBuilder(this);
    }

    public DeviceFilterBuilder physical(Consumer<PhysicalFilterBuilder> consumer) {
        consumer.accept(physical());
        return this;
    }

    public SoundFilterBuilder sound() {
        return new SoundFilterBuilder(this);
    }

    public DeviceFilterBuilder sound(Consumer<SoundFilterBuilder> consumer) {
        consumer.accept(sound());
        return this;
    }

    public ConnectivityFilterBuilder connectivity() {
        return new ConnectivityFilterBuilder(this);
    }

    public DeviceFilterBuilder connectivity(Consumer<ConnectivityFilterBuilder> consumer) {
        consumer.accept(connectivity());
        return this;
    }

    public BenchmarkFilterBuilder benchmarks() {
        return new BenchmarkFilterBuilder(this);
    }

    public DeviceFilterBuilder benchmarks(Consumer<BenchmarkFilterBuilder> consumer) {
        consumer.accept(benchmarks());
        return this;
    }

    public Map<String, String> getQueryParams() {
        return Collections.unmodifiableMap(queryParams);
    }

    public String toQueryString() {
        if (queryParams.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder("?");
        boolean first = true;
        for (Map.Entry<String, String> entry : queryParams.entrySet()) {
            if (!first) {
                sb.append("&");
            }
            sb.append(URLEncoder.encode(entry.getKey(), StandardCharsets.UTF_8));
            sb.append("=");
            sb.append(URLEncoder.encode(entry.getValue(), StandardCharsets.UTF_8));
            first = false;
        }
        return sb.toString();
    }
}
