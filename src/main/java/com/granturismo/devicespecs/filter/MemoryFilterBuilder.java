package com.granturismo.devicespecs.filter;

public class MemoryFilterBuilder {
    private final DeviceFilterBuilder parent;

    public MemoryFilterBuilder(DeviceFilterBuilder parent) {
        this.parent = parent;
    }

    public MemoryFilterBuilder ram(int value) {
        parent.addParam("ram", String.valueOf(value));
        return this;
    }

    public MemoryFilterBuilder ramGte(int value) {
        parent.addParam("ram_gte", String.valueOf(value));
        return this;
    }

    public MemoryFilterBuilder ramBetween(int min, int max) {
        parent.addParam("ram_between", min + "," + max);
        return this;
    }

    public MemoryFilterBuilder storage(int value) {
        parent.addParam("storage", String.valueOf(value));
        return this;
    }

    public MemoryFilterBuilder storageGte(int value) {
        parent.addParam("storage_gte", String.valueOf(value));
        return this;
    }

    public MemoryFilterBuilder storageBetween(int min, int max) {
        parent.addParam("storage_between", min + "," + max);
        return this;
    }

    public MemoryFilterBuilder hasCardSlot(boolean value) {
        parent.addParam("card_slot_has", String.valueOf(value));
        return this;
    }

    public MemoryFilterBuilder storageTechnologyContains(String value) {
        parent.addParam("memory.storage_technology_contains", value);
        return this;
    }

    public DeviceFilterBuilder endMemory() {
        return parent;
    }
}
