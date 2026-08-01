package com.granturismo.devicespecs.filter;

public class ConnectivityFilterBuilder {
    private final DeviceFilterBuilder parent;

    public ConnectivityFilterBuilder(DeviceFilterBuilder parent) {
        this.parent = parent;
    }

    public ConnectivityFilterBuilder hasNfc(boolean value) {
        parent.addParam("nfc_has", String.valueOf(value));
        return this;
    }

    public ConnectivityFilterBuilder hasInfrared(boolean value) {
        parent.addParam("infrared_has", String.valueOf(value));
        return this;
    }

    public ConnectivityFilterBuilder hasRadio(boolean value) {
        parent.addParam("radio_has", String.valueOf(value));
        return this;
    }

    public ConnectivityFilterBuilder bluetoothVersionGte(double value) {
        parent.addParam("connectivity.bluetooth_version_gte", String.valueOf(value));
        return this;
    }

    public ConnectivityFilterBuilder usbTypeContains(String value) {
        parent.addParam("connectivity.usb_type_contains", value);
        return this;
    }

    public ConnectivityFilterBuilder usbHasOtg(boolean value) {
        parent.addParam("usb_otg_has", String.valueOf(value));
        return this;
    }

    public DeviceFilterBuilder endConnectivity() {
        return parent;
    }
}
