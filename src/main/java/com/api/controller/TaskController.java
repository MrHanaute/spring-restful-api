package com.api.controller;

import com.api.model.task.Task;
import com.api.model.task.TaskRequestModel;
import com.api.service.task.TaskServiceIm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import javax.validation.Valid;
import java.util.Map;

/**
 * <p>This is a API of Task</p>
 * <p>Path: tasks/</p>
 * @since 1.0
 */
@RestController
@RequestMapping("tasks") // tasks/
public class TaskController {

    Map<String, Task> tasks;

    @Autowired
    TaskServiceIm taskService = new TaskServiceIm();

    /**
     * <p>This is GET default of PATH 'tasks/' API Task</p>
     * @param limit this is the limit of all data
     * @param page this is the page
     * @param sort is the order of data, is not required
     * @return Return an collection of tasks
     * @since 1.0
     */
    @GetMapping
    public String getTasks(@RequestParam(value="page", defaultValue="1") int page,
               @RequestParam(value="limit", defaultValue="25") int limit,
               @RequestParam(value="sort", defaultValue="desc", required=false
       ) int sort){
        return "Get user Method - page: " +page+ ", Limit: "+ limit;
    }

    @GetMapping(path="/{taskId}", produces = {
            MediaType.APPLICATION_XML_VALUE,
            MediaType.APPLICATION_JSON_VALUE
    })
    public ResponseEntity<Task> getTask(@PathVariable String taskId){
        if(this.taskService.getTasks().containsKey(taskId)) {
            return new ResponseEntity<>(this.taskService.getTasks().get(taskId), HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @PostMapping(consumes = {
            MediaType.APPLICATION_XML_VALUE,
            MediaType.APPLICATION_JSON_VALUE
    }, produces = {
            MediaType.APPLICATION_XML_VALUE,
            MediaType.APPLICATION_JSON_VALUE
    })
    public ResponseEntity<Task> createTask(@RequestBody TaskRequestModel TasksReq){

        Task task = this.taskService.createTask(TasksReq);

        return new ResponseEntity<>(task, HttpStatus.OK);
    }

    @PutMapping(path="/{taskId}", consumes = {
            MediaType.APPLICATION_XML_VALUE,
            MediaType.APPLICATION_JSON_VALUE
    }, produces = {
            MediaType.APPLICATION_XML_VALUE,
            MediaType.APPLICATION_JSON_VALUE
    })
    public ResponseEntity<Task> updateUser(@PathVariable String taskId, @Valid @RequestBody TaskRequestModel TasksReq){
        if(this.taskService.getTasks().containsKey(taskId)) {
            Task task = this.taskService.getTasks().get(taskId);

            task.setName(TasksReq.getName());
            task.setStatus(TasksReq.getStatus());

            this.taskService.getTasks().put(taskId, task);

            return new ResponseEntity<>(task, HttpStatus.OK);

        }else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

    }

    @DeleteMapping(path="/{taskId}")
    public ResponseEntity<Task> deleteUser(@PathVariable String taskId){

        if(this.taskService.getTasks().containsKey(taskId)) {
            this.taskService.getTasks().remove(taskId);
            return new ResponseEntity<>(HttpStatus.OK);
        }else {
            //return ResponseEntity.noContent().build();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

}
