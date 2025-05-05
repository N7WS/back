package com.n7ws.back.model;

public record DeviceConfigModel(
    String uid,
    String cpuName,
    Integer cpuCount,
    Integer cpuFreq,
    Integer ramSize,
    Integer ramFreq
) {}
