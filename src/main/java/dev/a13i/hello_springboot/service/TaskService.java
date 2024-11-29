package dev.a13i.hello_springboot.service;

import dev.a13i.hello_springboot.model.Task;
import dev.a13i.hello_springboot.repository.TaskRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
  private final TaskRepository taskRepository;

  TaskService(TaskRepository taskRepository) {
    this.taskRepository = taskRepository;
  }

  public List<Task> getAllTasks() {
    return this.taskRepository.findAll();
  }

  public Task getTask(String id) {
    return this.taskRepository.findById(id).orElseThrow();
  }

  public Task createTask(String text) {
    return this.taskRepository.save(new Task(text, false));
  }

  @Transactional
  public Task updateTask(String id, Task newTask) {
    if (!newTask.getId().equals(id)) throw new IllegalArgumentException("Cannot update the ID");

    var existingTask = this.taskRepository.findById(id).orElseThrow();
    existingTask.setText(newTask.getText());
    existingTask.setCompleted(newTask.getCompleted());

    return this.taskRepository.save(existingTask);
  }

  public void deleteTask(String id) {
    this.taskRepository.deleteById(id);
  }
}
