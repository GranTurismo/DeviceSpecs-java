package com.granturismo.devicespecs.models;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;

public class MemoryMetrics {
    @SerializedName("id")
    private int id;

    @SerializedName("available_ram_gb")
    private List<Integer> availableRamGb = new ArrayList<>();

    @SerializedName("available_storage_gb")
    private List<Integer> availableStorageGb = new ArrayList<>();

    @SerializedName("has_card_slot")
    private boolean hasCardSlot;

    @SerializedName("storage_technology")
    private String storageTechnology = "";

    public MemoryMetrics() {}

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public List<Integer> getAvailableRamGb() { return availableRamGb; }
    public void setAvailableRamGb(List<Integer> availableRamGb) { this.availableRamGb = availableRamGb; }

    public List<Integer> getAvailableStorageGb() { return availableStorageGb; }
    public void setAvailableStorageGb(List<Integer> availableStorageGb) { this.availableStorageGb = availableStorageGb; }

    public boolean isHasCardSlot() { return hasCardSlot; }
    public void setHasCardSlot(boolean hasCardSlot) { this.hasCardSlot = hasCardSlot; }

    public String getStorageTechnology() { return storageTechnology; }
    public void setStorageTechnology(String storageTechnology) { this.storageTechnology = storageTechnology; }

    @Override
    public String toString() {
        return "MemoryMetrics{" +
                "id=" + id +
                ", availableRamGb=" + availableRamGb +
                ", availableStorageGb=" + availableStorageGb +
                ", hasCardSlot=" + hasCardSlot +
                ", storageTechnology='" + storageTechnology + '\'' +
                '}';
    }
}
