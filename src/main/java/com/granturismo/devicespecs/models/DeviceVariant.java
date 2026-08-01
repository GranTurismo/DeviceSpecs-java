package com.granturismo.devicespecs.models;

import com.google.gson.annotations.SerializedName;
import java.util.Objects;

public class DeviceVariant {
    @SerializedName("id")
    private int id;

    @SerializedName("model_number")
    private String modelNumber = "";

    public DeviceVariant() {}

    public DeviceVariant(int id, String modelNumber) {
        this.id = id;
        this.modelNumber = modelNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModelNumber() {
        return modelNumber;
    }

    public void setModelNumber(String modelNumber) {
        this.modelNumber = modelNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DeviceVariant that = (DeviceVariant) o;
        return id == that.id && Objects.equals(modelNumber, that.modelNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, modelNumber);
    }

    @Override
    public String toString() {
        return "DeviceVariant{" +
                "id=" + id +
                ", modelNumber='" + modelNumber + '\'' +
                '}';
    }
}
