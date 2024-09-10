package io.drivesaf.springboot.quickstart.controller;


import io.drivesaf.springboot.quickstart.entity.Device;
import io.drivesaf.springboot.quickstart.entity.Laptop;
import io.drivesaf.springboot.quickstart.entity.Smartphone;
import io.drivesaf.springboot.quickstart.service.DeviceService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/device")
public class DeviceController {

    private final DeviceService deviceService;

    public DeviceController(DeviceService deviceService) {
        this.deviceService = deviceService;
    }

    @GetMapping("/process")
    public String processDevice(@RequestParam String type, @RequestParam String model, @RequestParam(required = false) String extra) {
        Device device;
        if ("smartphone".equalsIgnoreCase(type)) {
            device = new Smartphone(model, extra != null ? extra : "Unknown");
        } else if ("laptop".equalsIgnoreCase(type)) {
            int ramSize = Integer.parseInt(extra != null ? extra : "0");
            device = new Laptop(model, ramSize);
        } else {
            return "Invalid device type";
        }
        return deviceService.processDevice(device);
    }
}