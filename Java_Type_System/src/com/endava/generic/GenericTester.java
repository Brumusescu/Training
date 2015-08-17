package com.endava.generic;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dbrumusescu on 8/17/2015.
 *
 * 2) Update the Tester class to use a Generic List instead of a List of Strings.
 * You will create a generic type declaration by introducing the type variable, T,
 * that can be used anywhere inside the class.
 * In the main method instantiate a Tester class that uses a List of Integers
 * and another one that uses a List of Floats.
 */
public class GenericTester <T>{
    /* The list of bugs */
    private List<T> bugs;

    /* Constuctor where you initialize the list of bugs */
    public GenericTester(){
        this.bugs = new ArrayList<T>();
    }

    /* Method for adding a bug to the bug list */
    public void addBug(T newBug) {
        bugs.add(newBug);
    }

    /* Method for getting the last bug from the bug list */
    public T getLastBug() {
        return bugs.get(bugs.size()-1);
    }

    /* Main method for testing the class functionality */
    public static void main (String[] args){
        //Integers:
        GenericTester<Integer> integerGenericTester = new GenericTester<>();
        integerGenericTester.addBug(1);
        integerGenericTester.addBug(2);
        integerGenericTester.addBug(3);

        System.out.println(integerGenericTester.getLastBug());

        //Floats:
        GenericTester<Float> floatGenericTester = new GenericTester<>();
        floatGenericTester.addBug((float)1.1);
        floatGenericTester.addBug((float)2.2);
        floatGenericTester.addBug((float)3.3);

        System.out.println(floatGenericTester.getLastBug());
    }
}
