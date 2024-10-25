package org.example;

import java.util.Comparator;

public record Intern(String name, int age, Haircolour haircolour) {

    public static Comparator<Intern> byAge() {
        return (intern1, intern2) -> intern1.age - intern2.age;
    }

    public static Comparator<Intern> byName() {
        return Comparator.comparing(Intern::name);
    }

    public static Comparator<Intern> byHaircolour() {
        return (intern1, intern2) -> intern1.haircolour().order - intern2.haircolour().order;
    }

    public static Comparator<Intern> byNameLength() {
        return (intern1, intern2) -> intern1.name.length() - intern2.name().length();
    }


    @Override
    public String toString() {
        return "Intern{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", haircolour=" + haircolour +
                '}';
    }
}

