package com.example.demo;

// java class POJO -plain old java object
// Greeting class is where data stored
public class Greeting {
  private final long id; // final mean constance in java..cannot change
  private final String content;

  // constructor
  public Greeting(long id, String content) {
    this.id = id;
    this.content = content;
  }

  public long getId() {
    return id;
  }

  public String getContent() {
    return content;
  }
}
