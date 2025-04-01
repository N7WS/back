package com.n7ws.back.entities;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity @Table(name="device_configs")
public class DeviceConfig implements Serializable {
    @Id private String device_name;

    private Device device;

    private String CPU;

    private int cpu_count;

    private int cpu_freq;

    private int ram_size;

    private int ram_freq;

    public DeviceConfig(String device_name, Device device, String CPU, int cpu_count, int cpu_freq, int ram_size, int ram_freq) {
        this.device_name = device_name;
        this.device = device;
        this.CPU = CPU;
        this.cpu_count = cpu_count;
        this.cpu_freq = cpu_freq;
        this.ram_size = ram_size;
        this.ram_freq = ram_freq;
    }
}
