package io.drivasaf.springboot.quickstart.entity;

public class Laptop extends Device {
    private final int ramSize;

    public Laptop(String model, int ramSize) {
        super(model);
        this.ramSize = ramSize;
    }

    public int getRamSize() {
        return ramSize;
    }
}