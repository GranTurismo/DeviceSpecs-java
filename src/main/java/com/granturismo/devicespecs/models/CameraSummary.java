package com.granturismo.devicespecs.models;

import com.google.gson.annotations.SerializedName;

public class CameraSummary {
    @SerializedName("id")
    private int id;

    @SerializedName("main_lenses_count")
    private int mainLensesCount;

    @SerializedName("max_main_resolution_mp")
    private int maxMainResolutionMp;

    @SerializedName("selfie_lenses_count")
    private int selfieLensesCount;

    public CameraSummary() {}

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getMainLensesCount() { return mainLensesCount; }
    public void setMainLensesCount(int mainLensesCount) { this.mainLensesCount = mainLensesCount; }

    public int getMaxMainResolutionMp() { return maxMainResolutionMp; }
    public void setMaxMainResolutionMp(int maxMainResolutionMp) { this.maxMainResolutionMp = maxMainResolutionMp; }

    public int getSelfieLensesCount() { return selfieLensesCount; }
    public void setSelfieLensesCount(int selfieLensesCount) { this.selfieLensesCount = selfieLensesCount; }

    @Override
    public String toString() {
        return "CameraSummary{" +
                "id=" + id +
                ", mainLensesCount=" + mainLensesCount +
                ", maxMainResolutionMp=" + maxMainResolutionMp +
                ", selfieLensesCount=" + selfieLensesCount +
                '}';
    }
}
