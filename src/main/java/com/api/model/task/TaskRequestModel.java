package com.api.model.task;

import javax.validation.constraints.NotNull;

public class TaskRequestModel {
    @NotNull(message="nome não pode ser nulo")
    private String name;

    @NotNull(message="status não pode ser nulo")
    private boolean status;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
