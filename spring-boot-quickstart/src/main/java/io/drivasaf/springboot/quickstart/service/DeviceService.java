package io.drivasaf.springboot.quickstart.service;

import io.drivasaf.springboot.quickstart.entity.Device;
import io.drivasaf.springboot.quickstart.entity.Laptop;
import io.drivasaf.springboot.quickstart.entity.Smartphone;
import org.springframework.stereotype.Service;

@Service
public class DeviceService {

    public String processDevice(Device device) {
        if (device instanceof Smartphone smartphone) {
            return "Smartphone model: " + smartphone.getModel() + " with OS version: " + smartphone.getOsVersion();
        } else if (device instanceof Laptop laptop) {
            return "Laptop model: " + laptop.getModel() + " with RAM size: " + laptop.getRamSize() + " GB";
        } else {
            return "Unknown device type";
        }
    }
}
