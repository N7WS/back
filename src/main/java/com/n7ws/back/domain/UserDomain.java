package com.n7ws.back.domain;

public record UserDomain(
    String uid,
    String lastname,
    String firstname,
    String password,
    boolean admin
) {}
