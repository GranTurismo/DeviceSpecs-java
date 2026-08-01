package com.granturismo.devicespecs.models;

import com.google.gson.annotations.SerializedName;

public class BenchmarkMetrics {
    @SerializedName("id")
    private int id;

    @SerializedName("antutu_score")
    private String antutuScore = "";

    @SerializedName("geekbench_score")
    private String geekbenchScore = "";

    @SerializedName("measured_display_brightness_nits")
    private int measuredDisplayBrightnessNits;

    @SerializedName("measured_loudspeaker_lufs")
    private double measuredLoudspeakerLufs;

    @SerializedName("measured_battery_active_use_hours")
    private double measuredBatteryActiveUseHours;

    public BenchmarkMetrics() {}

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getAntutuScore() { return antutuScore; }
    public void setAntutuScore(String antutuScore) { this.antutuScore = antutuScore; }

    public String getGeekbenchScore() { return geekbenchScore; }
    public void setGeekbenchScore(String geekbenchScore) { this.geekbenchScore = geekbenchScore; }

    public int getMeasuredDisplayBrightnessNits() { return measuredDisplayBrightnessNits; }
    public void setMeasuredDisplayBrightnessNits(int measuredDisplayBrightnessNits) { this.measuredDisplayBrightnessNits = measuredDisplayBrightnessNits; }

    public double getMeasuredLoudspeakerLufs() { return measuredLoudspeakerLufs; }
    public void setMeasuredLoudspeakerLufs(double measuredLoudspeakerLufs) { this.measuredLoudspeakerLufs = measuredLoudspeakerLufs; }

    public double getMeasuredBatteryActiveUseHours() { return measuredBatteryActiveUseHours; }
    public void setMeasuredBatteryActiveUseHours(double measuredBatteryActiveUseHours) { this.measuredBatteryActiveUseHours = measuredBatteryActiveUseHours; }

    @Override
    public String toString() {
        return "BenchmarkMetrics{" +
                "id=" + id +
                ", antutuScore='" + antutuScore + '\'' +
                ", geekbenchScore='" + geekbenchScore + '\'' +
                ", measuredDisplayBrightnessNits=" + measuredDisplayBrightnessNits +
                ", measuredLoudspeakerLufs=" + measuredLoudspeakerLufs +
                ", measuredBatteryActiveUseHours=" + measuredBatteryActiveUseHours +
                '}';
    }
}
