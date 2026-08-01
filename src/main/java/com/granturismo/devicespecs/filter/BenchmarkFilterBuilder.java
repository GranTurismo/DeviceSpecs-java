package com.granturismo.devicespecs.filter;

public class BenchmarkFilterBuilder {
    private final DeviceFilterBuilder parent;

    public BenchmarkFilterBuilder(DeviceFilterBuilder parent) {
        this.parent = parent;
    }

    public BenchmarkFilterBuilder antutuContains(String value) {
        parent.addParam("antutu_contains", value);
        return this;
    }

    public BenchmarkFilterBuilder geekbenchContains(String value) {
        parent.addParam("geekbench_contains", value);
        return this;
    }

    public DeviceFilterBuilder endBenchmark() {
        return parent;
    }
}
