package com.granturismo.devicespecs.filter;

public class ProcessorFilterBuilder {
    private final DeviceFilterBuilder parent;

    public ProcessorFilterBuilder(DeviceFilterBuilder parent) {
        this.parent = parent;
    }

    public ProcessorFilterBuilder totalCores(int value) {
        parent.addParam("cores", String.valueOf(value));
        return this;
    }

    public ProcessorFilterBuilder totalCoresGte(int value) {
        parent.addParam("cores_gte", String.valueOf(value));
        return this;
    }

    public ProcessorFilterBuilder maxClockSpeedGhzGt(double value) {
        parent.addParam("clock_speed_gt", String.valueOf(value));
        return this;
    }

    public ProcessorFilterBuilder maxClockSpeedGhzGte(double value) {
        parent.addParam("clock_speed_gte", String.valueOf(value));
        return this;
    }

    public DeviceFilterBuilder endProcessor() {
        return parent;
    }
}
