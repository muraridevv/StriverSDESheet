package com.murari.corejava;

public class EqualsExample {
    public static void main(String[] args) {
        int a=5;
        int b=5;
        System.out.println("Using == with primitive types: " + (a == b));// true

        // Example 2: Using == with objects
        String str1 = new String("hello");
        String str2 = new String("hello");
        System.out.println("Using == with objects: " + (str1 == str2)); // false

        // Example 3: Using .equals() method
        String str3 = new String("hello");
        String str4 = new String("hello");
        System.out.println("Using .equals() method: " + (str3.equals(str4))); // true

        // Example 4: Custom class
        Person person1 = new Person("John", 30);
        Person person2 = new Person("John", 30);
        System.out.println("Using == with custom class: " + (person1 == person2)); // false
        System.out.println("Using .equals() method with custom class: " + (person1.equals(person2))); // true

    }
}

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Overriding equals() method
    @Override
    public boolean equals(Object obj) {
        if(this==obj) return true;
        if(obj==null || getClass()!=obj.getClass()) return false;

        Person person= (Person) obj;
        return age== person.age && name.equals(person.name);
    }
}
