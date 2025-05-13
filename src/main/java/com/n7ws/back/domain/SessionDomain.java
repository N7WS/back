package com.n7ws.back.domain;

import java.time.LocalDateTime;

public record SessionDomain(
    String uid,
    UserDomain owner,
    LocalDateTime expiration
) {}
