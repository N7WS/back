package com.n7ws.back.seeds;

import java.util.ArrayList;

import com.n7ws.back.SeedApplication;
import com.n7ws.back.repository.HealthInfoRepository;

public class HealthInfoSeed extends Seed {
    public HealthInfoSeed() {
        this.repository = SeedApplication.context.getBean(HealthInfoRepository.class);
        this.entities = new ArrayList<>();
        this.count = 50;
    }

    public void seed() {
    }
}
