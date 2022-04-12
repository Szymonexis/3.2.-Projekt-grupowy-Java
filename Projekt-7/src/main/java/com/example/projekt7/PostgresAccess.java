package com.example.projekt7;

public enum PostgresAccess {
    USERNAME("postgres"),
    PASSWORD("docker");

    private final String value;

    PostgresAccess(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
