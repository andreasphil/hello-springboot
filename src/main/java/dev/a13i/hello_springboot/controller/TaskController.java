package dev.a13i.hello_springboot.controller;

import dev.a13i.hello_springboot.controller.payload.CreateTaskBody;
import dev.a13i.hello_springboot.model.Task;
import dev.a13i.hello_springboot.service.TaskService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskController {
  private final TaskService taskService;

  TaskController(TaskService taskService) {
    this.taskService = taskService;
  }

  @GetMapping(path = "/tasks", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<Task>> getTasks() {
    final var tasks = taskService.getAllTasks();
    return ResponseEntity.ok(tasks);
  }

  @GetMapping(path = "/tasks/{taskId}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Task> getTask(@PathVariable final String taskId) {
    final var task = taskService.getTask(taskId);
    return ResponseEntity.ok(task);
  }

  @PostMapping(path = "/tasks", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Task> createTask(@RequestBody final CreateTaskBody body) {
    final var newTask = taskService.createTask(body.text());
    return ResponseEntity.ok(newTask);
  }

  @PutMapping(path = "/tasks/{taskId}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Task> updateTask(@PathVariable String taskId, @RequestBody final Task body) {
    return ResponseEntity.ok(taskService.updateTask(taskId, body));
  }

  @DeleteMapping(path = "/tasks/{taskId}")
  public void deleteTask(@PathVariable String taskId) {
    taskService.deleteTask(taskId);
  }
}

