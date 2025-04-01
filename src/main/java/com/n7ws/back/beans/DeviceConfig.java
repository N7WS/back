package com.n7ws.back.beans;

public record DeviceConfig(
    String device_name,
    Device device,
    String CPU,
    int cpu_count,
    int cpu_freq,
    int ram_size,
    int ram_freq
){}
