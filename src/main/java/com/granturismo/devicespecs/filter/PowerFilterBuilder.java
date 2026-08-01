package com.granturismo.devicespecs.filter;

public class PowerFilterBuilder {
    private final DeviceFilterBuilder parent;

    public PowerFilterBuilder(DeviceFilterBuilder parent) {
        this.parent = parent;
    }

    public PowerFilterBuilder capacityMah(int value) {
        parent.addParam("battery", String.valueOf(value));
        return this;
    }

    public PowerFilterBuilder capacityMahGte(int value) {
        parent.addParam("battery_gte", String.valueOf(value));
        return this;
    }

    public PowerFilterBuilder capacityMahBetween(int min, int max) {
        parent.addParam("battery_between", min + "," + max);
        return this;
    }

    public PowerFilterBuilder chargingWattsGte(int value) {
        parent.addParam("charging_gte", String.valueOf(value));
        return this;
    }

    public PowerFilterBuilder hasWirelessCharging(boolean value) {
        parent.addParam("wireless_charging_has", String.valueOf(value));
        return this;
    }

    public DeviceFilterBuilder endPower() {
        return parent;
    }
}
