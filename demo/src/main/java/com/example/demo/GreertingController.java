package com.example.demo;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// add annotation to GreetingController to convert it to a Rest Controller component
// POJO
// java manage component;obj instance will create auto ; tell server/container take component when
// run appl
@RestController
public class GreertingController {
  // final - constant
  // static -class variable (mean can shared use by other place)
  private static final String template = "Hello, %s!";
  private final AtomicLong counter = new AtomicLong();

  // define a  GreetingComponent variable without initializzation
  private GreetingComponent g;

  // inject/initialize GreetingComponent in the Constrcutor

  @Autowired
  public GreertingController(GreetingComponent g) {
    this.g = g;
  }

  // test the greeting component
  @GetMapping("/testgreeting")
  public ResponseEntity<String> getMessage() {
    return ResponseEntity.ok(g.getMessage());
  }

  @GetMapping("/greeting")
  // public Greeting greeting(String name)
  public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
    return new Greeting(counter.incrementAndGet(), String.format(template, name));
  }
  // not use ? to filer name "emma", so use this way instead
  @GetMapping("/add/{num1}/{num2}")
  // public int addTwoNumers(@PathVariable("num1"), @RequestParam int num2)
  public int addTwoNumers(@PathVariable("num1") int num1, @PathVariable("num2") int num2) {
    return num1;
  }
}
