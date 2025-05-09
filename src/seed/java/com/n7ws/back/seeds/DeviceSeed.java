package com.n7ws.back.seeds;

import java.util.ArrayList;

import com.n7ws.back.SeedApplication;
import com.n7ws.back.entity.DeviceEntity;
import com.n7ws.back.enums.DeviceState;
import com.n7ws.back.repository.DeviceRepository;

public class DeviceSeed extends Seed {
    public DeviceSeed() {
        this.repository = SeedApplication.context.getBean(DeviceRepository.class);
        this.entities = new ArrayList<>();
        this.count = 50;
    }

    public void seed() {
        for(int i = 0; i < this.count; i++) {
            String deviceName = "device" + i;
            String deviceId = "c" + (i + 200);
            DeviceEntity device = new DeviceEntity(deviceName, DeviceState.OFFLINE, deviceId, new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
            this.entities.add(device);
        }
    }
}
