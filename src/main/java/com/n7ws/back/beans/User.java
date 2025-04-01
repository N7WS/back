package com.n7ws.back.beans;

public record User (
    String uid,
    String lastname,
    String fristname,
    String password,
    Session[] session,
    boolean admin
) {}
