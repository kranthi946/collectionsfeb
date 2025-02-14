package org.example.testpackage;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.stream.Collectors;

/*
* In Java, you can **initialize an `ArrayList`** in several different ways, depending on the specific use case. Here are the main ways you can initialize an `ArrayList`:

### 1. **Default Initialization (Empty ArrayList)**
   - This is the most common way to initialize an `ArrayList`. It creates an empty list.
   ```java
   List<String> list = new ArrayList<>();
   ```

   - **Explanation**: The `<>` (diamond operator) infers the type from the variable declaration.

---

### 2. **Initialization with a Specific Capacity**
   - You can specify the initial capacity of the `ArrayList`. The initial capacity determines how many elements the list can hold before it needs to resize.
   ```java
   List<String> list = new ArrayList<>(10);  // List with an initial capacity of 10
   ```

   - **Explanation**: This creates an `ArrayList` with a capacity to hold 10 elements. It does not mean that the list is populated with 10 elements, only that it can grow to hold 10 elements before needing to resize.

---

### 3. **Initialization with Another Collection (Copy Constructor)**
   - You can initialize an `ArrayList` by passing an existing collection (like a `List`, `Set`, or another `ArrayList`) to the constructor.
   ```java
   List<String> list1 = new ArrayList<>();
   list1.add("Apple");
   list1.add("Banana");

   List<String> list2 = new ArrayList<>(list1);  // Creates a new list with the elements of list1
   ```

   - **Explanation**: This initializes `list2` with the elements from `list1`.

---

### 4. **Initialization Using `Arrays.asList()`**
   - You can initialize an `ArrayList` using `Arrays.asList()` to create a fixed-size list from a set of values. This method returns a list backed by an array (not a true `ArrayList`), but you can still use it like a normal list in most cases.
   ```java
   List<String> list = new ArrayList<>(Arrays.asList("Apple", "Banana", "Orange"));
   ```

   - **Explanation**: This creates a list with the elements `"Apple"`, `"Banana"`, and `"Orange"`. However, note that the list created by `Arrays.asList()` is fixed in size, so you can't add or remove elements from it. But when passing it to an `ArrayList` constructor, you can still modify the list.

---

### 5. **Initialization Using Java 9+ `List.of()`**
   - Starting from Java 9, you can initialize an immutable list with a set of elements using `List.of()`. This creates a **fixed-size list** (can't add or remove elements).
   ```java
   List<String> list = List.of("Apple", "Banana", "Orange");
   ```

   - **Explanation**: The list is **immutable**, so you cannot add, remove, or modify its elements once it’s created.

---

### 6. **Using a `for` Loop to Populate the List**
   - You can also populate an `ArrayList` using a loop (for example, using a `for` loop).
   ```java
   List<Integer> list = new ArrayList<>();
   for (int i = 0; i < 5; i++) {
       list.add(i * 2);  // Adds elements 0, 2, 4, 6, 8
   }
   ```

   - **Explanation**: This dynamically adds elements to the list inside a loop.

---

### 7. **Using `Collections.addAll()` Method**
   - The `Collections.addAll()` method can be used to initialize the `ArrayList` with multiple elements at once.
   ```java
   List<String> list = new ArrayList<>();
   Collections.addAll(list, "Apple", "Banana", "Orange");
   ```

   - **Explanation**: This adds multiple elements to an existing list.

---

### 8. **Using Java Streams (Java 8+)**
   - You can initialize an `ArrayList` from a stream of data using the `Stream` API.
   ```java
   List<Integer> list = Stream.of(1, 2, 3, 4, 5)
                               .collect(Collectors.toList());
   ```

   - **Explanation**: This creates an `ArrayList` from a stream of elements (in this case, the integers 1 through 5).

---

### Summary of Ways to Initialize an `ArrayList`:

| **Method**                          | **Description**                                                                  | **Example**                                  |
|-------------------------------------|----------------------------------------------------------------------------------|----------------------------------------------|
| **Default initialization**          | Creates an empty list.                                                           | `List<String> list = new ArrayList<>();`     |
| **With specific capacity**          | Creates an empty list with a specified initial capacity.                         | `List<String> list = new ArrayList<>(10);`   |
| **Copy constructor (from another collection)** | Creates a new list with elements from another collection.                        | `List<String> list = new ArrayList<>(list1);` |
| **Using `Arrays.asList()`**         | Creates a list from a fixed set of elements.                                     | `List<String> list = new ArrayList<>(Arrays.asList("Apple", "Banana"));` |
| **Using `List.of()` (Java 9+)**     | Creates an immutable list (no modification allowed).                             | `List<String> list = List.of("Apple", "Banana");` |
| **Using a `for` loop**              | Dynamically add elements in a loop.                                              | `List<Integer> list = new ArrayList<>(); for (int i = 0; i < 5; i++) list.add(i);` |
| **Using `Collections.addAll()`**    | Adds multiple elements at once to a list.                                        | `Collections.addAll(list, "Apple", "Banana");` |
| **Using Streams (Java 8+)**         | Creates a list from a stream of data.                                            | `List<Integer> list = Stream.of(1, 2, 3).collect(Collectors.toList());` |

---

Each of these methods serves a different purpose depending on the situation. Let me know if you’d like to see examples for any of these in more detail!
* */
public class ArrayListExamples {

    public static void main(String[] args) {

        int i [] = new int[4];

        ArrayList <? super Integer>  a = new ArrayList<>();  // it allows

        a.add(2);
        a.add(3);

        System.out.println(a.size());

        a.add(4);

        a.add(4);
        System.out.println(a.size());


        List<String> s = new ArrayList<>(Arrays.asList("abc", "b", "c","e"));

        List<String> d = List.of("abc", "b", "c");

  s.stream().filter(e -> e.startsWith("a")).forEach(System.out::println);


        List<Integer> numbers = Arrays.asList(1, 3, 5, 7, 9, 1, 4, 2, 8, 6, 10, 1, 3, 5, 7, 4, 9, 2, 8, 6);
        System.out.println(numbers);

        LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<>(numbers);
        System.out.println(linkedHashSet);


        List<Integer> marks = Arrays.asList(1, 3, 5, 7, 9, 1, 4, 2, 8, 6, 10, 1, 3, 5, 7, 4, 9, 2, 8, 6);


       List<Integer>  r = marks.stream().distinct().collect(Collectors.toList());
       System.out.println(r);

       marks.stream().filter(e -> e>5).forEach(System.out::println);
    List<Integer> www =    marks.stream().filter(e -> e> 5).collect(Collectors.toList());

   System.out.println(www);
    }


}
