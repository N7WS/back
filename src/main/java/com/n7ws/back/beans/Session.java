package com.n7ws.back.beans;

import java.time.LocalDate;

public record Session(
    String uid,
    String owner_id,
    User owner,
    LocalDate expiration
) {}