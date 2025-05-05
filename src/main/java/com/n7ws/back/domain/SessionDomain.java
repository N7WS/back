package com.n7ws.back.domain;

import java.time.LocalDate;

public record SessionDomain(
    String uid,
    UserDomain owner,
    LocalDate expiration
) {}
