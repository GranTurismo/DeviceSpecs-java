package com.granturismo.devicespecs.models;

import com.google.gson.annotations.SerializedName;

public class EuLabelMetrics {
    @SerializedName("id")
    private int id;

    @SerializedName("energy_class")
    private String energyClass = "";

    @SerializedName("battery_endurance")
    private String batteryEndurance = "";

    @SerializedName("battery_endurance_hours")
    private double batteryEnduranceHours;

    @SerializedName("free_fall_class")
    private String freeFallClass = "";

    @SerializedName("repairability_class")
    private String repairabilityClass = "";

    public EuLabelMetrics() {}

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getEnergyClass() { return energyClass; }
    public void setEnergyClass(String energyClass) { this.energyClass = energyClass; }

    public String getBatteryEndurance() { return batteryEndurance; }
    public void setBatteryEndurance(String batteryEndurance) { this.batteryEndurance = batteryEndurance; }

    public double getBatteryEnduranceHours() { return batteryEnduranceHours; }
    public void setBatteryEnduranceHours(double batteryEnduranceHours) { this.batteryEnduranceHours = batteryEnduranceHours; }

    public String getFreeFallClass() { return freeFallClass; }
    public void setFreeFallClass(String freeFallClass) { this.freeFallClass = freeFallClass; }

    public String getRepairabilityClass() { return repairabilityClass; }
    public void setRepairabilityClass(String repairabilityClass) { this.repairabilityClass = repairabilityClass; }

    @Override
    public String toString() {
        return "EuLabelMetrics{" +
                "id=" + id +
                ", energyClass='" + energyClass + '\'' +
                ", batteryEndurance='" + batteryEndurance + '\'' +
                ", batteryEnduranceHours=" + batteryEnduranceHours +
                ", freeFallClass='" + freeFallClass + '\'' +
                ", repairabilityClass='" + repairabilityClass + '\'' +
                '}';
    }
}
