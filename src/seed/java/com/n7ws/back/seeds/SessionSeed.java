package com.n7ws.back.seeds;

import java.util.ArrayList;

import com.n7ws.back.SeedApplication;
import com.n7ws.back.repository.SessionRepository;

public class SessionSeed extends Seed {
    public SessionSeed() {
        this.repository = SeedApplication.context.getBean(SessionRepository.class);
        this.entities = new ArrayList<>();
        this.count = 50;
    }

    public void seed() {
    }
}
