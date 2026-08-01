package com.granturismo.devicespecs.filter;

public class SoundFilterBuilder {
    private final DeviceFilterBuilder parent;

    public SoundFilterBuilder(DeviceFilterBuilder parent) {
        this.parent = parent;
    }

    public SoundFilterBuilder hasStereoSpeakers(boolean value) {
        parent.addParam("stereo_speakers_has", String.valueOf(value));
        return this;
    }

    public SoundFilterBuilder has35mmJack(boolean value) {
        parent.addParam("headphone_jack_has", String.valueOf(value));
        return this;
    }

    public DeviceFilterBuilder endSound() {
        return parent;
    }
}
