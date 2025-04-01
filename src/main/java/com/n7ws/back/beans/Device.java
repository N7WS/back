package com.n7ws.back.beans;

public record Device(
    String name,
    Status status,
    String room,
    Service[] services
) {}