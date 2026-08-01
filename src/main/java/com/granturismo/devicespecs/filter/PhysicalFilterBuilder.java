package com.granturismo.devicespecs.filter;

public class PhysicalFilterBuilder {
    private final DeviceFilterBuilder parent;

    public PhysicalFilterBuilder(DeviceFilterBuilder parent) {
        this.parent = parent;
    }

    public PhysicalFilterBuilder weightGramsLte(int value) {
        parent.addParam("weight_lte", String.valueOf(value));
        return this;
    }

    public PhysicalFilterBuilder ipRatingContains(String value) {
        parent.addParam("ip_rating_contains", value);
        return this;
    }

    public PhysicalFilterBuilder isWaterResistant(boolean value) {
        parent.addParam("water_resistant_has", String.valueOf(value));
        return this;
    }

    public DeviceFilterBuilder endPhysical() {
        return parent;
    }
}
