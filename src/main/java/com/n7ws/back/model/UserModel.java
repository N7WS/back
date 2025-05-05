package com.n7ws.back.model;

public record UserModel(
    String uid,
    String lastname,
    String firstname,
    String password,
    boolean admin
) {}
