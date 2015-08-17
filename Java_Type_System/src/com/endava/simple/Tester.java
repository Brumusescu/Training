package com.endava.simple;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dbrumusescu on 8/17/2015.
 *
 * 1) Create a non-generic Tester class that contains on a List of String types.
 * This class needs to provide two methods:
 *      * addBug, which adds a String to the List,
 *      * and getLastBug, which retrieves the last String from the List.
 */
public class Tester {
    /* The list of bugs */
    private List<String> bugs;

    /* Constuctor where you initialize the list of bugs */
    public Tester(){
        this.bugs = new ArrayList<>();
    }

    /* Method for adding a bug to the bug list */
    public void addBug(String newBug) {
        bugs.add(newBug);
    }

    /* Method for getting the last bug from the bug list */
    public String getLastBug() {
        return bugs.get(bugs.size()-1);
    }

    /* Main method for testing the class functionality */
    public static void main (String[] args){
        Tester tester = new Tester();
        tester.addBug("First bug");
        tester.addBug("Second bug");
        tester.addBug("Third bug");

        System.out.println(tester.getLastBug());
    }

}
