package com.granturismo.devicespecs.models;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;

public class PhysicalMetrics {
    @SerializedName("id")
    private int id;

    @SerializedName("height_mm")
    private double heightMm;

    @SerializedName("width_mm")
    private double widthMm;

    @SerializedName("thickness_mm")
    private double thicknessMm;

    @SerializedName("weight_g")
    private int weightG;

    @SerializedName("build_materials")
    private List<String> buildMaterials = new ArrayList<>();

    @SerializedName("sim_options")
    private List<String> simOptions = new ArrayList<>();

    @SerializedName("ip_rating")
    private String ipRating = "";

    @SerializedName("is_water_resistant")
    private boolean isWaterResistant;

    public PhysicalMetrics() {}

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public double getHeightMm() { return heightMm; }
    public void setHeightMm(double heightMm) { this.heightMm = heightMm; }

    public double getWidthMm() { return widthMm; }
    public void setWidthMm(double widthMm) { this.widthMm = widthMm; }

    public double getThicknessMm() { return thicknessMm; }
    public void setThicknessMm(double thicknessMm) { this.thicknessMm = thicknessMm; }

    public int getWeightG() { return weightG; }
    public void setWeightG(int weightG) { this.weightG = weightG; }

    public List<String> getBuildMaterials() { return buildMaterials; }
    public void setBuildMaterials(List<String> buildMaterials) { this.buildMaterials = buildMaterials; }

    public List<String> getSimOptions() { return simOptions; }
    public void setSimOptions(List<String> simOptions) { this.simOptions = simOptions; }

    public String getIpRating() { return ipRating; }
    public void setIpRating(String ipRating) { this.ipRating = ipRating; }

    public boolean isWaterResistant() { return isWaterResistant; }
    public void setWaterResistant(boolean waterResistant) { isWaterResistant = waterResistant; }

    @Override
    public String toString() {
        return "PhysicalMetrics{" +
                "id=" + id +
                ", heightMm=" + heightMm +
                ", widthMm=" + widthMm +
                ", thicknessMm=" + thicknessMm +
                ", weightG=" + weightG +
                ", buildMaterials=" + buildMaterials +
                ", simOptions=" + simOptions +
                ", ipRating='" + ipRating + '\'' +
                ", isWaterResistant=" + isWaterResistant +
                '}';
    }
}
