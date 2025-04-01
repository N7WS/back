package com.n7ws.back.entities;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity @Table(name="users")
public class User implements Serializable {
    @Id private String uid;

    private String lastname;

    private String fristname;

    private String password;

    @OneToMany private Session[] session;

    private boolean admin;

    public User(String uid, String lastname, String fristname, String password, Session[] session, boolean admin) {
        this.uid = uid;
        this.lastname = lastname;
        this.fristname = fristname;
        this.password = password;
        this.session = session;
        this.admin = admin;
    }
}