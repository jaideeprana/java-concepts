package com.thoughtworks.calculator;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Consumer;

// Taken from http://winterbe.com/posts/2014/03/16/java-8-tutorial/
public class Main {
  public static void main(String[] args) {
    // Using interface(which uses extension methods to define method)
    // as an anonymous class object.

    Formula formula = new Formula() {
      @Override
      public double calculate(int number) {
        return 0;
      }
    };

//    System.out.println(formula.calculate(100));
//    System.out.println(formula.sqrt(4));

    // Sample string for experimenting

    List<String> techNames = Arrays.asList("Jackson", "AngularJS", "Backbone", "MongoDB");

//    // Using foreach
//    for (String techName :
//        techNames) {
//      System.out.println(techName);
//    }
//
//    // Using iterator
//    Iterator<String> iterator = techNames.iterator();
//    while (iterator.hasNext()){
//      System.out.println(iterator.next());
//    }


    //Comparable interface(which is differnt from Comparator interface)

//    Integer a = 0;
//    Integer b = 1;
//    System.out.println("Equals "  + a.compareTo(a));
//    System.out.println("Lesser "  + a.compareTo(b));
//    System.out.println("Greater " + b.compareTo(a));

//    // without lambda using comparator interface
//
//    Collections.sort(techNames, new Comparator<String>() {
//      @Override
//      public int compare(String o1, String o2) {
//        return o1.compareTo(o2);
//      }
//    });
//
//    // with lambda
//    Collections.sort(techNames, (String name1, String name2) -> { return name2.compareTo(name1); });
//
//    Collections.sort(techNames, (String name1, String name2) -> name2.compareTo(name1));
//
//    Collections.sort(techNames, (name1, name2) -> name2.compareTo(name1));
//
//    // functional interface equivalent of lambda
//    Converter<String, Integer> converter = (from) -> Integer.valueOf(from);
//    // Another way from writing the above code, the newer way is called static method reference
//    //    Converter<String, Integer> converter = Integer::valueOf;
//
//    Integer converted = converter.convert("123");
//
//    System.out.println(converted);
//
//    //Another example of using static method reference
//    Something something = new Something();
//    Converter<String, String> stringConverter = something::startsWith;
//    String stringConverted = stringConverter.convert("Java");
//    System.out.println(stringConverted);    // "J"

    //Using :: fror constructor
    PersonFactory<Person> personFactory = Person::new;
    Person person = personFactory.create("Peter", "Parker");


    // If num is uncommented the below code won't compile. Num should be final implicitly as a local variable.
    int num = 1;
    Converter<Integer, String> stringConverter =
        (from) -> String.valueOf(from + num);
//    num = 3;

    //default methods can't be accessed in lambda

    //But the Java 8 API is also full of new functional interfaces to make your life easier. Some of those new interfaces are well known from the Google Guava library.

//    Predicate<String> predicate = (s) -> s.length() > 0;
//
//    predicate.test("foo");              // true
//    predicate.negate().test("foo");     // false
//
//    Predicate<Boolean> nonNull = Objects::nonNull;
//    Predicate<Boolean> isNull = Objects::isNull;
//
//    Predicate<String> isEmpty = String::isEmpty;
//
//    // Not working
//    Function<String, Integer> toInteger = Integer::valueOf;
//    Function<String, String> backToString = toInteger.andThen(String::valueOf);
//    //
//
//    backToString.apply("123");     // "123"
//        Consumer<Person> greeter = (p) -> System.out.println("Hello, " + p.firstName);
//    greeter.accept(new Person("Luke", "Skywalker"));
//
//    Streams
//      A java.util.Stream represents a sequence of elements on which one or more operations can be performed.
    List<String> stringCollection = new ArrayList<>();
    stringCollection.add("ddd2");
    stringCollection.add("aaa2");
    stringCollection.add("bbb1");
    stringCollection.add("aaa1");
    stringCollection.add("bbb3");
    stringCollection.add("ccc");
    stringCollection.add("bbb2");
    stringCollection.add("ddd1");

//    stringCollection
//        .stream()
//        .filter((s) -> s.contains("c"))
//        .forEach(System.out::println);

//    stringCollection.stream().sorted().forEach(System.out::println);

    stringCollection.stream().map((a) -> a.toUpperCase()).forEach(System.out::println);

    boolean noneStartsWithZ =
        stringCollection
            .stream()
            .noneMatch((s) -> s.startsWith("z"));
    System.out.println("Doesn't starts with z " + noneStartsWithZ);

    Long total =
        stringCollection
            .stream()
            .count();
    System.out.println("Total items " + total);

    Optional<String> reduce = stringCollection.stream().reduce((s1, s2) -> s1 + " | " + s2 + " ((()))");

    reduce.ifPresent(System.out::println);

//// Parallel streams
//
    int max = 1000000;
    List<String> values = new ArrayList<>(max);
    for (int i = 0; i < max; i++) {
      UUID uuid = UUID.randomUUID();
      values.add(uuid.toString());
    }
//
//    //
//    long t0 = System.nanoTime();
//
//    long count = values.stream().sorted().count();
//    System.out.println(count);
//
//    long t1 = System.nanoTime();
//
//    long millis = TimeUnit.NANOSECONDS.toMillis(t1 - t0);
//    System.out.println(String.format("sequential sort took: %d ms", millis));
//
//// sequential sort took: 671 ms

    long t0 = System.nanoTime();

    long count = values.parallelStream().sorted().count();
    System.out.println(count);

    long t1 = System.nanoTime();

    long millis = TimeUnit.NANOSECONDS.toMillis(t1 - t0);
    System.out.println(String.format("parallel sort took: %d ms", millis));

// parallel sort took: 372 ms

    // So many map utility methods

    Map<Integer, String> map = new HashMap<>();

    for (int i = 0; i < 10; i++) {
      map.putIfAbsent(i, "val" + i);
    }

    map.forEach((id, val) -> System.out.println(val));
  }
}
