package com.granturismo.devicespecs.models;

import com.google.gson.annotations.SerializedName;

public class DisplayMetrics {
    @SerializedName("id")
    private int id;

    @SerializedName("size_inches")
    private double sizeInches;

    @SerializedName("panel_type")
    private String panelType = "";

    @SerializedName("refresh_rate_hz")
    private int refreshRateHz;

    @SerializedName("peak_brightness_nits")
    private int peakBrightnessNits;

    @SerializedName("protection_type")
    private String protectionType = "";

    public DisplayMetrics() {}

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public double getSizeInches() { return sizeInches; }
    public void setSizeInches(double sizeInches) { this.sizeInches = sizeInches; }

    public String getPanelType() { return panelType; }
    public void setPanelType(String panelType) { this.panelType = panelType; }

    public int getRefreshRateHz() { return refreshRateHz; }
    public void setRefreshRateHz(int refreshRateHz) { this.refreshRateHz = refreshRateHz; }

    public int getPeakBrightnessNits() { return peakBrightnessNits; }
    public void setPeakBrightnessNits(int peakBrightnessNits) { this.peakBrightnessNits = peakBrightnessNits; }

    public String getProtectionType() { return protectionType; }
    public void setProtectionType(String protectionType) { this.protectionType = protectionType; }

    @Override
    public String toString() {
        return "DisplayMetrics{" +
                "id=" + id +
                ", sizeInches=" + sizeInches +
                ", panelType='" + panelType + '\'' +
                ", refreshRateHz=" + refreshRateHz +
                ", peakBrightnessNits=" + peakBrightnessNits +
                ", protectionType='" + protectionType + '\'' +
                '}';
    }
}
