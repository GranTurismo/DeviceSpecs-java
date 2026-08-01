package com.granturismo.devicespecs.models;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;

public class SoundMetrics {
    @SerializedName("id")
    private int id;

    @SerializedName("has_stereo_speakers")
    private boolean hasStereoSpeakers;

    @SerializedName("has_jack_35mm")
    private boolean has35mmJack;

    @SerializedName("audio_quality_features")
    private List<String> audioQualityFeatures = new ArrayList<>();

    public SoundMetrics() {}

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public boolean isHasStereoSpeakers() { return hasStereoSpeakers; }
    public void setHasStereoSpeakers(boolean hasStereoSpeakers) { this.hasStereoSpeakers = hasStereoSpeakers; }

    public boolean isHas35mmJack() { return has35mmJack; }
    public void setHas35mmJack(boolean has35mmJack) { this.has35mmJack = has35mmJack; }

    public List<String> getAudioQualityFeatures() { return audioQualityFeatures; }
    public void setAudioQualityFeatures(List<String> audioQualityFeatures) { this.audioQualityFeatures = audioQualityFeatures; }

    @Override
    public String toString() {
        return "SoundMetrics{" +
                "id=" + id +
                ", hasStereoSpeakers=" + hasStereoSpeakers +
                ", has35mmJack=" + has35mmJack +
                ", audioQualityFeatures=" + audioQualityFeatures +
                '}';
    }
}
