package dev.a13i.hello_springboot.controller.payload;

import jakarta.validation.constraints.NotBlank;
import org.springframework.validation.annotation.Validated;

@Validated
public record CreateTaskBody(
  @NotBlank(message = "Text is required")
  String text
) {}
