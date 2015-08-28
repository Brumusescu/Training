package com.endava.person;

/**
 * Created by dbrumusescu on 8/27/2015.
 *
 * Create an object Person that contains name and birth year and overwrite the toString method.
 */
public class Person {
    private String name;
    private int birthYear;

    public Person(String name, int birthDate) {
        this.name = name;
        this.birthYear = birthDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    @Override
    public String toString() {
        return ("Name: " + this.getName() + "\n" + "Birth date: " + this.getBirthYear());
    }
}
