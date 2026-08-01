package com.granturismo.devicespecs.models;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;

public class PowerMetrics {
    @SerializedName("id")
    private int id;

    @SerializedName("capacities_mah")
    private List<Integer> capacitiesMah = new ArrayList<>();

    @SerializedName("max_wired_charging_w")
    private int maxWiredChargingW;

    @SerializedName("has_wireless_charging")
    private boolean hasWirelessCharging;

    public PowerMetrics() {}

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public List<Integer> getCapacitiesMah() { return capacitiesMah; }
    public void setCapacitiesMah(List<Integer> capacitiesMah) { this.capacitiesMah = capacitiesMah; }

    public int getMaxWiredChargingW() { return maxWiredChargingW; }
    public void setMaxWiredChargingW(int maxWiredChargingW) { this.maxWiredChargingW = maxWiredChargingW; }

    public boolean isHasWirelessCharging() { return hasWirelessCharging; }
    public void setHasWirelessCharging(boolean hasWirelessCharging) { this.hasWirelessCharging = hasWirelessCharging; }

    @Override
    public String toString() {
        return "PowerMetrics{" +
                "id=" + id +
                ", capacitiesMah=" + capacitiesMah +
                ", maxWiredChargingW=" + maxWiredChargingW +
                ", hasWirelessCharging=" + hasWirelessCharging +
                '}';
    }
}
