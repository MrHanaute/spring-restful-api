package com.api.service.task;

import com.api.model.task.Task;
import com.api.model.task.TaskRequestModel;
import com.api.shared.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class TaskServiceIm implements TaskService{
    Map<String, Task> tasks;

    Utils utils;

    public TaskServiceIm() {}

    @Autowired
    public TaskServiceIm(Utils utils) {
        this.utils = utils;
    }

    public Map<String, Task> getTasks(){
        return tasks;
    }

    @Override
    public Task createTask(TaskRequestModel taskReq) {
        Task task = new Task();

        task.setName(taskReq.getName());
        task.setStatus(taskReq.getStatus());
        task.setTaskId( this.utils.generateId());

        String taskId = this.utils.generateId();
        task.setTaskId(taskId);

        if(this.tasks == null) this.tasks = new HashMap<>();

        this.tasks.put(taskId, task);

        return task;
    }
}
