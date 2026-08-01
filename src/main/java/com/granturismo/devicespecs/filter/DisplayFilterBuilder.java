package com.granturismo.devicespecs.filter;

import java.util.Map;

public class DisplayFilterBuilder {
    private final DeviceFilterBuilder parent;

    public DisplayFilterBuilder(DeviceFilterBuilder parent) {
        this.parent = parent;
    }

    public DisplayFilterBuilder sizeInches(double value) {
        parent.addParam("display.size_inches", String.valueOf(value));
        return this;
    }

    public DisplayFilterBuilder sizeInchesGt(double value) {
        parent.addParam("display.size_inches_gt", String.valueOf(value));
        return this;
    }

    public DisplayFilterBuilder sizeInchesGte(double value) {
        parent.addParam("display.size_inches_gte", String.valueOf(value));
        return this;
    }

    public DisplayFilterBuilder sizeInchesLt(double value) {
        parent.addParam("display.size_inches_lt", String.valueOf(value));
        return this;
    }

    public DisplayFilterBuilder sizeInchesLte(double value) {
        parent.addParam("display.size_inches_lte", String.valueOf(value));
        return this;
    }

    public DisplayFilterBuilder sizeInchesBetween(double min, double max) {
        parent.addParam("display.size_inches_between", min + "," + max);
        return this;
    }

    public DisplayFilterBuilder panelType(String value) {
        parent.addParam("panel_type", value);
        return this;
    }

    public DisplayFilterBuilder panelTypeContains(String value) {
        parent.addParam("panel_type_contains", value);
        return this;
    }

    public DisplayFilterBuilder refreshRateHz(int value) {
        parent.addParam("refresh_rate_hz", String.valueOf(value));
        return this;
    }

    public DisplayFilterBuilder refreshRateHzGte(int value) {
        parent.addParam("refresh_rate_hz_gte", String.valueOf(value));
        return this;
    }

    public DisplayFilterBuilder peakBrightnessNitsGte(int value) {
        parent.addParam("brightness_gte", String.valueOf(value));
        return this;
    }

    public DisplayFilterBuilder protectionType(String value) {
        parent.addParam("display.protection_type", value);
        return this;
    }

    public DeviceFilterBuilder endDisplay() {
        return parent;
    }
}
