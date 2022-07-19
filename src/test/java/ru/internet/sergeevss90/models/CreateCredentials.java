package ru.internet.sergeevss90.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CreateCredentials {

    private String name;
    private String content;
    @JsonProperty("project_id")
    private String projectId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }
}