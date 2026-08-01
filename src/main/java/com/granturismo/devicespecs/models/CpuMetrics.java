package com.granturismo.devicespecs.models;

import com.google.gson.annotations.SerializedName;

public class CpuMetrics {
    @SerializedName("id")
    private int id;

    @SerializedName("total_cores")
    private int totalCores;

    @SerializedName("max_clock_speed_ghz")
    private double maxClockSpeedGhz;

    public CpuMetrics() {}

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getTotalCores() { return totalCores; }
    public void setTotalCores(int totalCores) { this.totalCores = totalCores; }

    public double getMaxClockSpeedGhz() { return maxClockSpeedGhz; }
    public void setMaxClockSpeedGhz(double maxClockSpeedGhz) { this.maxClockSpeedGhz = maxClockSpeedGhz; }

    @Override
    public String toString() {
        return "CpuMetrics{" +
                "id=" + id +
                ", totalCores=" + totalCores +
                ", maxClockSpeedGhz=" + maxClockSpeedGhz +
                '}';
    }
}
