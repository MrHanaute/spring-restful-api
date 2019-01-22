package com.api.service.task;

import com.api.model.task.Task;
import com.api.model.task.TaskRequestModel;
import org.springframework.stereotype.Service;

@Service
public interface TaskService {
    Task createTask(TaskRequestModel taskReq);
}
