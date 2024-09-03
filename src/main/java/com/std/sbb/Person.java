package com.std.sbb;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

//@ToString
@AllArgsConstructor
@Getter
@Setter
public class Person {
    private static int lastId;
    private final int id;
    private final String name;
    private final int age;

    static {
        lastId = 0;
    }

    Person (String name, int age) {
        this.id = ++lastId;
        this.name = name;
        this.age = age;
    }
}
