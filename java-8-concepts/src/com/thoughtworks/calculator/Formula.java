package com.thoughtworks.calculator;

public interface Formula {
  double calculate(int number);

    default double sqrt(int a){
      return Math.sqrt(a);
    }
}
