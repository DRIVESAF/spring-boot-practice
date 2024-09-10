package io.drivesaf.springboot.quickstart.entity;

public class Smartphone extends Device {
    private final String osVersion;

    public Smartphone(String model, String osVersion) {
        super(model);
        this.osVersion = osVersion;
    }

    public String getOsVersion() {
        return osVersion;
    }
}
