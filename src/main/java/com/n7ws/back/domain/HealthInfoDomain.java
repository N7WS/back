package com.n7ws.back.domain;

import java.util.Collection;

public record HealthInfoDomain(
    String uid,
    Collection<Integer> ping,
    Collection<Integer> cpu,
    Collection<Integer> ram
) {}
