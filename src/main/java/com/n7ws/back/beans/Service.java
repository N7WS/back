package com.n7ws.back.beans;

public record Service(
    String uid,
    String name,
    Integer port,
    Script[] script
){}
