package com.api.model.task;

public class Task {

    private String taskId;
    private String name;
    private boolean status;

    public String getTaskId() {  return taskId;  }

    public void setTaskId(String taskId) {  this.taskId = taskId; }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
