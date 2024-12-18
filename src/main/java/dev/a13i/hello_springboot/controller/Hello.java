package dev.a13i.hello_springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello {

  @GetMapping("/hello")
  public String hello(
    @RequestParam(name = "name", defaultValue = "World") String name
  ) {
    return String.format("Hello %s!", name);
  }
}
