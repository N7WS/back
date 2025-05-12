package com.n7ws.back.seeds;

import java.util.ArrayList;

import com.n7ws.back.Random;
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
            String deviceName = Random.randomName();
            DeviceState deviceState = Random.randomState();
            String deviceRoom = Random.randomRoom();
            DeviceEntity device = new DeviceEntity(deviceName, deviceState, deviceRoom, new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
            this.entities.add(device);
        }
    }
}
