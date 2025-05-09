package com.n7ws.back.seeds;

import java.util.ArrayList;

import com.n7ws.back.SeedApplication;
import com.n7ws.back.repository.DeviceConfigRepository;

public class DeviceConfigSeed extends Seed {
    public DeviceConfigSeed() {
        this.repository = SeedApplication.context.getBean(DeviceConfigRepository.class);
        this.entities = new ArrayList<>();
        this.count = 50;
    }

    public void seed() {
    }
}
