package com.n7ws.back.entities;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="health_infos")
public class HealthInfo implements Serializable {
    @Id private String device_name;

    private Device device;

    private int[] ping;

    private int[] ram;

    private int[] cpu;

    public HealthInfo(String device_name, Device device, int[] ping, int[] ram, int[] cpu) {
        this.device_name = device_name;
        this.device = device;
        this.ping = ping;
        this.ram = ram;
        this.cpu = cpu;
    }
}