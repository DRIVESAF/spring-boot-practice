package io.drivesaf.springboot.quickstart.entity;

public abstract class Device {
    private final String model;

    public Device(String model) {
        this.model = model;
    }

    public String getModel() {
        return model;
    }
}