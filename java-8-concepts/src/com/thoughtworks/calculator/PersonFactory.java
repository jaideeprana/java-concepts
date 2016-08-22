package com.thoughtworks.calculator;

public interface PersonFactory<Person> {
  Person create(String firstName, String lastName);
}
