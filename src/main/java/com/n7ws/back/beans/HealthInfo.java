package com.n7ws.back.beans;

public record HealthInfo (

    String device_name,
    Device device,
    int[] ping,
    int[] ram,
    int[] cpu
){}