package dev.a13i.hello_springboot.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Task {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private String id;

  private String text;

  private boolean completed;

  protected Task() {
    // This only exists for JPA and is not used directly, hence "protected"
  }

  public Task(String text, boolean completed) {
    this.text = text;
    this.completed = completed;
  }

  @Override
  public String toString() {
    return String.format("Task[id='%s' text='%s' completed='%b'", id, text, completed);
  }

  public String getId() {
    return id;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public boolean getCompleted() {
    return completed;
  }

  public void setCompleted(boolean completed) {
    this.completed = completed;
  }
}
