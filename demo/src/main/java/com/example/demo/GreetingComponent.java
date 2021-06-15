package com.example.demo;

import org.springframework.stereotype.Component;

// convert POJO become component
@Component
public class GreetingComponent {

  public String getMessage() {
    return "Hello from GreetingComponent";
  }
}
