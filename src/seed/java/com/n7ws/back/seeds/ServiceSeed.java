package com.n7ws.back.seeds;

import java.util.ArrayList;

import com.n7ws.back.Random;
import com.n7ws.back.SeedApplication;
import com.n7ws.back.entity.ServiceEntity;
import com.n7ws.back.repository.ServiceRepository;

public class ServiceSeed extends Seed {
    public ServiceSeed() {
        this.repository = SeedApplication.context.getBean(ServiceRepository.class);
        this.entities = new ArrayList<>();
        this.count = 50;
    }

    public void seed() {
        for(int i = 0; i < this.count; i++) {
            String serviceName = Random.randomName();
            Integer servicePort = Random.randomPort();
            ServiceEntity service = new ServiceEntity(serviceName, servicePort, new ArrayList<>());
            this.entities.add(service);
        }
    }
}
