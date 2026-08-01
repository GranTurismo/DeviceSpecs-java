package com.granturismo.devicespecs.models;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;

public class ConnectivityMetrics {
    @SerializedName("id")
    private int id;

    @SerializedName("wlan_features")
    private List<String> wlanFeatures = new ArrayList<>();

    @SerializedName("bluetooth_version")
    private double bluetoothVersion;

    @SerializedName("bluetooth_features")
    private List<String> bluetoothFeatures = new ArrayList<>();

    @SerializedName("positioning_tech")
    private List<String> positioningTech = new ArrayList<>();

    @SerializedName("has_nfc")
    private boolean hasNfc;

    @SerializedName("has_infrared")
    private boolean hasInfrared;

    @SerializedName("has_radio")
    private boolean hasRadio;

    @SerializedName("usb_type")
    private String usbType = "";

    @SerializedName("usb_has_otg")
    private boolean usbHasOtg;

    public ConnectivityMetrics() {}

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public List<String> getWlanFeatures() { return wlanFeatures; }
    public void setWlanFeatures(List<String> wlanFeatures) { this.wlanFeatures = wlanFeatures; }

    public double getBluetoothVersion() { return bluetoothVersion; }
    public void setBluetoothVersion(double bluetoothVersion) { this.bluetoothVersion = bluetoothVersion; }

    public List<String> getBluetoothFeatures() { return bluetoothFeatures; }
    public void setBluetoothFeatures(List<String> bluetoothFeatures) { this.bluetoothFeatures = bluetoothFeatures; }

    public List<String> getPositioningTech() { return positioningTech; }
    public void setPositioningTech(List<String> positioningTech) { this.positioningTech = positioningTech; }

    public boolean isHasNfc() { return hasNfc; }
    public void setHasNfc(boolean hasNfc) { this.hasNfc = hasNfc; }

    public boolean isHasInfrared() { return hasInfrared; }
    public void setHasInfrared(boolean hasInfrared) { this.hasInfrared = hasInfrared; }

    public boolean isHasRadio() { return hasRadio; }
    public void setHasRadio(boolean hasRadio) { this.hasRadio = hasRadio; }

    public String getUsbType() { return usbType; }
    public void setUsbType(String usbType) { this.usbType = usbType; }

    public boolean isUsbHasOtg() { return usbHasOtg; }
    public void setUsbHasOtg(boolean usbHasOtg) { this.usbHasOtg = usbHasOtg; }

    @Override
    public String toString() {
        return "ConnectivityMetrics{" +
                "id=" + id +
                ", wlanFeatures=" + wlanFeatures +
                ", bluetoothVersion=" + bluetoothVersion +
                ", bluetoothFeatures=" + bluetoothFeatures +
                ", positioningTech=" + positioningTech +
                ", hasNfc=" + hasNfc +
                ", hasInfrared=" + hasInfrared +
                ", hasRadio=" + hasRadio +
                ", usbType='" + usbType + '\'' +
                ", usbHasOtg=" + usbHasOtg +
                '}';
    }
}
