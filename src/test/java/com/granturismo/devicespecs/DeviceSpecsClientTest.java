package com.granturismo.devicespecs;

import com.google.gson.Gson;
import com.granturismo.devicespecs.filter.DeviceFilterBuilder;
import com.granturismo.devicespecs.models.DeviceSpecsResponse;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DeviceSpecsClientTest {

    @Test
    public void testClientInitialization() {
        DeviceSpecsClient client = new DeviceSpecsClient("test-key");
        assertEquals("test-key", client.getApiKey());
        assertEquals("https://prod.api.market/api/v1/granturismo/device-specs-api", client.getBaseUrl());
    }

    @Test
    public void testFluentFilterBuilderQueryString() {
        DeviceFilterBuilder filter = DeviceFilterBuilder.builder()
                .manufacturer("Samsung")
                .ramGte(8)
                .batteryCapacityGte(5000)
                .chipsetContains("Snapdragon")
                .display(d -> d.refreshRateHzGte(120).sizeInchesGte(6.5))
                .connectivity(c -> c.hasNfc(true).bluetoothVersionGte(5.0));

        String queryString = filter.toQueryString();

        assertTrue(queryString.contains("manufacturer=Samsung"));
        assertTrue(queryString.contains("ram_gte=8"));
        assertTrue(queryString.contains("battery_gte=5000"));
        assertTrue(queryString.contains("chipset_contains=Snapdragon"));
        assertTrue(queryString.contains("refresh_rate_hz_gte=120"));
        assertTrue(queryString.contains("display.size_inches_gte=6.5"));
        assertTrue(queryString.contains("nfc_has=true"));
        assertTrue(queryString.contains("connectivity.bluetooth_version_gte=5.0"));
    }

    @Test
    public void testJsonDeserialization() {
        String json = "{\n" +
                "  \"id\": 1,\n" +
                "  \"manufacturer\": \"Samsung\",\n" +
                "  \"model\": \"Galaxy S21 5G\",\n" +
                "  \"chipset\": \"Snapdragon 888\",\n" +
                "  \"price_usd\": 329.99,\n" +
                "  \"colors\": [\"Phantom Gray\", \"Phantom White\"],\n" +
                "  \"variants\": [{\"id\": 101, \"model_number\": \"SM-G991B\"}],\n" +
                "  \"normalized_specs\": {\n" +
                "    \"display\": {\n" +
                "      \"size_inches\": 6.2,\n" +
                "      \"panel_type\": \"Dynamic AMOLED 2X\",\n" +
                "      \"refresh_rate_hz\": 120\n" +
                "    },\n" +
                "    \"processor\": {\n" +
                "      \"total_cores\": 8,\n" +
                "      \"max_clock_speed_ghz\": 2.84\n" +
                "    },\n" +
                "    \"battery_and_charging\": {\n" +
                "      \"capacities_mah\": [4000],\n" +
                "      \"has_wireless_charging\": true\n" +
                "    },\n" +
                "    \"connectivity\": {\n" +
                "      \"has_nfc\": true,\n" +
                "      \"bluetooth_version\": 5.0\n" +
                "    }\n" +
                "  }\n" +
                "}";

        Gson gson = new Gson();
        DeviceSpecsResponse response = gson.fromJson(json, DeviceSpecsResponse.class);

        assertNotNull(response);
        assertEquals(1, response.getId());
        assertEquals("Samsung", response.getManufacturer());
        assertEquals("Galaxy S21 5G", response.getModel());
        assertEquals("Snapdragon 888", response.getChipset());
        assertEquals(329.99, response.getPriceUsd());
        assertEquals(2, response.getColors().size());
        assertEquals("SM-G991B", response.getVariants().get(0).getModelNumber());

        assertNotNull(response.getNormalizedSpecs());
        assertEquals(6.2, response.getNormalizedSpecs().getDisplay().getSizeInches());
        assertEquals(120, response.getNormalizedSpecs().getDisplay().getRefreshRateHz());
        assertEquals(8, response.getNormalizedSpecs().getProcessor().getTotalCores());
        assertTrue(response.getNormalizedSpecs().getBatteryAndCharging().isHasWirelessCharging());
        assertTrue(response.getNormalizedSpecs().getConnectivity().isHasNfc());
    }
}
