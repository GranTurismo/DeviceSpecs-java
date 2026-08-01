package com.granturismo.devicespecs.models;

import com.google.gson.annotations.SerializedName;

public class NormalizedSpecs {
    @SerializedName("id")
    private int id;

    @SerializedName("display")
    private DisplayMetrics display = new DisplayMetrics();

    @SerializedName("processor")
    private CpuMetrics processor = new CpuMetrics();

    @SerializedName("memory_options")
    private MemoryMetrics memoryOptions = new MemoryMetrics();

    @SerializedName("battery_and_charging")
    private PowerMetrics batteryAndCharging = new PowerMetrics();

    @SerializedName("cameras")
    private CameraSummary cameras = new CameraSummary();

    @SerializedName("physical")
    private PhysicalMetrics physical = new PhysicalMetrics();

    @SerializedName("sound")
    private SoundMetrics sound = new SoundMetrics();

    @SerializedName("connectivity")
    private ConnectivityMetrics connectivity = new ConnectivityMetrics();

    @SerializedName("benchmarks")
    private BenchmarkMetrics benchmarks = new BenchmarkMetrics();

    @SerializedName("eu_label")
    private EuLabelMetrics euLabel = new EuLabelMetrics();

    public NormalizedSpecs() {}

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public DisplayMetrics getDisplay() { return display; }
    public void setDisplay(DisplayMetrics display) { this.display = display; }

    public CpuMetrics getProcessor() { return processor; }
    public void setProcessor(CpuMetrics processor) { this.processor = processor; }

    public MemoryMetrics getMemoryOptions() { return memoryOptions; }
    public void setMemoryOptions(MemoryMetrics memoryOptions) { this.memoryOptions = memoryOptions; }

    public PowerMetrics getBatteryAndCharging() { return batteryAndCharging; }
    public void setBatteryAndCharging(PowerMetrics batteryAndCharging) { this.batteryAndCharging = batteryAndCharging; }

    public CameraSummary getCameras() { return cameras; }
    public void setCameras(CameraSummary cameras) { this.cameras = cameras; }

    public PhysicalMetrics getPhysical() { return physical; }
    public void setPhysical(PhysicalMetrics physical) { this.physical = physical; }

    public SoundMetrics getSound() { return sound; }
    public void setSound(SoundMetrics sound) { this.sound = sound; }

    public ConnectivityMetrics getConnectivity() { return connectivity; }
    public void setConnectivity(ConnectivityMetrics connectivity) { this.connectivity = connectivity; }

    public BenchmarkMetrics getBenchmarks() { return benchmarks; }
    public void setBenchmarks(BenchmarkMetrics benchmarks) { this.benchmarks = benchmarks; }

    public EuLabelMetrics getEuLabel() { return euLabel; }
    public void setEuLabel(EuLabelMetrics euLabel) { this.euLabel = euLabel; }

    @Override
    public String toString() {
        return "NormalizedSpecs{" +
                "id=" + id +
                ", display=" + display +
                ", processor=" + processor +
                ", memoryOptions=" + memoryOptions +
                ", batteryAndCharging=" + batteryAndCharging +
                ", cameras=" + cameras +
                ", physical=" + physical +
                ", sound=" + sound +
                ", connectivity=" + connectivity +
                ", benchmarks=" + benchmarks +
                ", euLabel=" + euLabel +
                '}';
    }
}
