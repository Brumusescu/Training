package com.endava.errors;

/**
 * Created by dbrumusescu on 8/27/2015.
 */
public class PersonNotRemovedException extends RuntimeException{
    public PersonNotRemovedException() {
        System.out.println("Person not removed!");
    }
}
