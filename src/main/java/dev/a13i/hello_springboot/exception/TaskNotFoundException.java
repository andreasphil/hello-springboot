package dev.a13i.hello_springboot.exception;

public class TaskNotFoundException extends RuntimeException {

  public TaskNotFoundException(String taskId) {
    super(String.format("Task with ID %s not found", taskId));
  }
}
