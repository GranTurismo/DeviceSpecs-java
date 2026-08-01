package com.granturismo.devicespecs.filter;

public class CameraFilterBuilder {
    private final DeviceFilterBuilder parent;

    public CameraFilterBuilder(DeviceFilterBuilder parent) {
        this.parent = parent;
    }

    public CameraFilterBuilder mainLensesCountGte(int value) {
        parent.addParam("main_camera_lenses_gte", String.valueOf(value));
        return this;
    }

    public CameraFilterBuilder maxMainResolutionMpGte(int value) {
        parent.addParam("main_camera_mp_gte", String.valueOf(value));
        return this;
    }

    public CameraFilterBuilder selfieLensesCountGte(int value) {
        parent.addParam("selfie_camera_lenses_gte", String.valueOf(value));
        return this;
    }

    public DeviceFilterBuilder endCameras() {
        return parent;
    }
}
