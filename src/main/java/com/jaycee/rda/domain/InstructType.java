package com.jaycee.rda.domain;

public enum InstructType {
    LME("LME"),
    PRIME("PRIME");


    private final String type;

    private InstructType(String type) {
        this.type = type;
    }
}
