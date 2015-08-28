package com.endava.errors;

/**
 * Created by dbrumusescu on 8/27/2015.
 */
public class PersonNotFoundException extends RuntimeException {
    public PersonNotFoundException() {
        System.out.println("Person not found!");
    }
}
