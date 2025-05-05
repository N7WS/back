package com.n7ws.back.model;

import java.util.Collection;

public record HealthInfoModel(
    String uid,
    Collection<Integer> ping,
    Collection<Integer> cpu,
    Collection<Integer> ram
) {}
