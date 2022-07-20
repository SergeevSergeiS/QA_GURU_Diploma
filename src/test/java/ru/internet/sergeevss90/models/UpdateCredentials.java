package ru.internet.sergeevss90.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UpdateCredentials {
    private String name;
    @JsonProperty("id")
    private long id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(long id) {
        this.id = id;
    }
}