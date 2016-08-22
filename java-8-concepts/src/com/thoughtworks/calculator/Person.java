package com.thoughtworks.calculator;

public class Person {
  String firstName;
  String lastName;

  Person() {
    System.out.println("default constructor called");
  }

  Person(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
    System.out.println("awesome constructor called");
  }
}
