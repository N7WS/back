package com.n7ws.back.model;

import java.time.LocalDateTime;

public record SessionModel(
    String uid,
    UserModel owner,
    LocalDateTime expiration
) {}
