package com.thoughtworks.calculator;

//Functional enforces that only one interface is being used
@FunctionalInterface
interface Converter<F, T> {
  T convert(F From);
}