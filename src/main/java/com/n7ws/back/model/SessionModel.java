package com.n7ws.back.model;

import java.time.LocalDate;

public record SessionModel(
    String uid,
    UserModel owner,
    LocalDate expiration
) {}
