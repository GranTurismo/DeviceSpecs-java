package com.granturismo.devicespecs.models;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;

public class DeviceSpecsResponse {
    @SerializedName("id")
    private int id;

    @SerializedName("manufacturer")
    private String manufacturer = "";

    @SerializedName("model")
    private String model = "";

    @SerializedName("network")
    private String network = "";

    @SerializedName("announceDate")
    private String announceDate = "";

    @SerializedName("status")
    private String status = "";

    @SerializedName("chipset")
    private String chipset = "";

    @SerializedName("androidVersion")
    private String androidVersion = "";

    @SerializedName("battery_raw")
    private String batteryRaw = "";

    @SerializedName("cpu_raw")
    private String cpuRaw = "";

    @SerializedName("displayResolution_raw")
    private String displayResolutionRaw = "";

    @SerializedName("displaySize_raw")
    private String displaySizeRaw = "";

    @SerializedName("displayType_raw")
    private String displayTypeRaw = "";

    @SerializedName("gpu")
    private String gpu = "";

    @SerializedName("internal_raw")
    private String internalRaw = "";

    @SerializedName("mainCameraFeatures")
    private String mainCameraFeatures = "";

    @SerializedName("mainCameraSpecs_raw")
    private String mainCameraSpecsRaw = "";

    @SerializedName("mainVideoSpecs")
    private String mainVideoSpecs = "";

    @SerializedName("selfieCameraFeatures")
    private String selfieCameraFeatures = "";

    @SerializedName("selfieCameraSpecs_raw")
    private String selfieCameraSpecsRaw = "";

    @SerializedName("selfieVideoSpecs")
    private String selfieVideoSpecs = "";

    @SerializedName("sensors")
    private String sensors = "";

    @SerializedName("charging_raw")
    private String chargingRaw = "";

    @SerializedName("price_usd")
    private double priceUsd;

    @SerializedName("price_eur")
    private double priceEur;

    @SerializedName("price_gbp")
    private double priceGbp;

    @SerializedName("imageUrl")
    private String imageUrl = "";

    @SerializedName("colors")
    private List<String> colors = new ArrayList<>();

    @SerializedName("variants")
    private List<DeviceVariant> variants = new ArrayList<>();

    @SerializedName("normalized_specs")
    private NormalizedSpecs normalizedSpecs = new NormalizedSpecs();

    public DeviceSpecsResponse() {}

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getManufacturer() { return manufacturer; }
    public void setManufacturer(String manufacturer) { this.manufacturer = manufacturer; }

    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }

    public String getNetwork() { return network; }
    public void setNetwork(String network) { this.network = network; }

    public String getAnnounceDate() { return announceDate; }
    public void setAnnounceDate(String announceDate) { this.announceDate = announceDate; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getChipset() { return chipset; }
    public void setChipset(String chipset) { this.chipset = chipset; }

    public String getAndroidVersion() { return androidVersion; }
    public void setAndroidVersion(String androidVersion) { this.androidVersion = androidVersion; }

    public String getBatteryRaw() { return batteryRaw; }
    public void setBatteryRaw(String batteryRaw) { this.batteryRaw = batteryRaw; }

    public String getCpuRaw() { return cpuRaw; }
    public void setCpuRaw(String cpuRaw) { this.cpuRaw = cpuRaw; }

    public String getDisplayResolutionRaw() { return displayResolutionRaw; }
    public void setDisplayResolutionRaw(String displayResolutionRaw) { this.displayResolutionRaw = displayResolutionRaw; }

    public String getDisplaySizeRaw() { return displaySizeRaw; }
    public void setDisplaySizeRaw(String displaySizeRaw) { this.displaySizeRaw = displaySizeRaw; }

    public String getDisplayTypeRaw() { return displayTypeRaw; }
    public void setDisplayTypeRaw(String displayTypeRaw) { this.displayTypeRaw = displayTypeRaw; }

    public String getGpu() { return gpu; }
    public void setGpu(String gpu) { this.gpu = gpu; }

    public String getInternalRaw() { return internalRaw; }
    public void setInternalRaw(String internalRaw) { this.internalRaw = internalRaw; }

    public String getMainCameraFeatures() { return mainCameraFeatures; }
    public void setMainCameraFeatures(String mainCameraFeatures) { this.mainCameraFeatures = mainCameraFeatures; }

    public String getMainCameraSpecsRaw() { return mainCameraSpecsRaw; }
    public void setMainCameraSpecsRaw(String mainCameraSpecsRaw) { this.mainCameraSpecsRaw = mainCameraSpecsRaw; }

    public String getMainVideoSpecs() { return mainVideoSpecs; }
    public void setMainVideoSpecs(String mainVideoSpecs) { this.mainVideoSpecs = mainVideoSpecs; }

    public String getSelfieCameraFeatures() { return selfieCameraFeatures; }
    public void setSelfieCameraFeatures(String selfieCameraFeatures) { this.selfieCameraFeatures = selfieCameraFeatures; }

    public String getSelfieCameraSpecsRaw() { return selfieCameraSpecsRaw; }
    public void setSelfieCameraSpecsRaw(String selfieCameraSpecsRaw) { this.selfieCameraSpecsRaw = selfieCameraSpecsRaw; }

    public String getSelfieVideoSpecs() { return selfieVideoSpecs; }
    public void setSelfieVideoSpecs(String selfieVideoSpecs) { this.selfieVideoSpecs = selfieVideoSpecs; }

    public String getSensors() { return sensors; }
    public void setSensors(String sensors) { this.sensors = sensors; }

    public String getChargingRaw() { return chargingRaw; }
    public void setChargingRaw(String chargingRaw) { this.chargingRaw = chargingRaw; }

    public double getPriceUsd() { return priceUsd; }
    public void setPriceUsd(double priceUsd) { this.priceUsd = priceUsd; }

    public double getPriceEur() { return priceEur; }
    public void setPriceEur(double priceEur) { this.priceEur = priceEur; }

    public double getPriceGbp() { return priceGbp; }
    public void setPriceGbp(double priceGbp) { this.priceGbp = priceGbp; }

    public String getImageUrl() { return imageUrl; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }

    public List<String> getColors() { return colors; }
    public void setColors(List<String> colors) { this.colors = colors; }

    public List<DeviceVariant> getVariants() { return variants; }
    public void setVariants(List<DeviceVariant> variants) { this.variants = variants; }

    public NormalizedSpecs getNormalizedSpecs() { return normalizedSpecs; }
    public void setNormalizedSpecs(NormalizedSpecs normalizedSpecs) { this.normalizedSpecs = normalizedSpecs; }

    @Override
    public String toString() {
        return "DeviceSpecsResponse{" +
                "id=" + id +
                ", manufacturer='" + manufacturer + '\'' +
                ", model='" + model + '\'' +
                ", chipset='" + chipset + '\'' +
                ", androidVersion='" + androidVersion + '\'' +
                ", priceUsd=" + priceUsd +
                '}';
    }
}
