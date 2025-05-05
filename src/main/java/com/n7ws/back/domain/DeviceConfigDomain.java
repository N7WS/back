package com.n7ws.back.domain;

public record DeviceConfigDomain(
    String uid,
    String cpuName,
    Integer cpuCount,
    Integer cpuFreq,
    Integer ramSize,
    Integer ramFreq
) {}
