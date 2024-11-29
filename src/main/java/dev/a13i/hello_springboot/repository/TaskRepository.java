package dev.a13i.hello_springboot.repository;

import dev.a13i.hello_springboot.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, String> {
}
