package com.n7ws.back.seeds;

import java.util.ArrayList;

import com.n7ws.back.Random;
import com.n7ws.back.SeedApplication;
import com.n7ws.back.entity.UserEntity;
import com.n7ws.back.repository.UserRepository;

public class UserSeed extends Seed {
    public UserSeed() {
        this.repository = SeedApplication.context.getBean(UserRepository.class);
        this.entities = new ArrayList<>();
        this.count = 50;
    }

    public void seed() {
        for(int i = 0; i < this.count; i++) { 
            String userLastName = Random.randomName();
            String userFirstName = Random.randomName();
            String userPassword = Random.randomName();
            Boolean userAdmin = Random.randomAdmin();
            String userUid = userFirstName + "." + userLastName + "@mail.com";
            UserEntity user = new UserEntity(userUid,userLastName, userFirstName, userPassword, new ArrayList<>(),userAdmin);
            this.entities.add(user);
        }
    }
}
