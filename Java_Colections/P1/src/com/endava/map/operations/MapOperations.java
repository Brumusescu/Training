package com.endava.map.operations;

import com.endava.errors.PersonNotFoundException;
import com.endava.errors.PersonNotRemovedException;
import com.endava.person.Person;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created by dbrumusescu on 8/27/2015.
 *
 * Create a class that will contain a new HashMap() and several (3/4) Person objects (for example person = new Person("Johan", 1947)). Add each Person object to the Map using Map.put() (as key you will use the Person name and as value the Person object).
 Create methods that will:
 -	Get and print a Person object by its name from the Map.
 -	Get and print the result of containsKey() to check if a name is in the Map.
 -	Remove a Person object by its name from the Map using remove() and also check if the object was removed from the map using containsKey().
 -	Print the content of the Map using java.util.Iterator in a while() loop. Use the method Map.keySet().iterator() to obtain a Iterator object with keys.
 o	Use the Iterator.hasNext() for the loop condition.
 o	Use the Iterator.next() to obtain the next key.
 o	Use the Map.get() to obtain the next value with each key.
 -	Same as previous step but print all the Person objects using an Iterator gotten through Map.values().
 */
public class MapOperations{
    private Map<String, Person> personMap = new HashMap<>();

    public MapOperations(Map<String, Person> personMap) {
        this.personMap = personMap;
    }

    public Person getPerson (String name) {
        try {
            final Set set = personMap.keySet();
            for (Map.Entry<String, Person> currentPerson : personMap.entrySet()) {
                if (name.equalsIgnoreCase(currentPerson.getKey())) {
                    System.out.println(currentPerson.getKey() + ": " + currentPerson.getValue());
                    return currentPerson.getValue();
                }
            }
            throw new PersonNotFoundException();
        }
        catch (PersonNotFoundException exception) {
            System.out.println(exception.getMessage());
            return null;
        }
    }

    public boolean findPerson(String name) {
        try {
            if (personMap.containsKey(name)) {
                System.out.println("Person is present!");
                return true;
            }
            else {
                throw new PersonNotFoundException();
            }
        }
        catch (PersonNotFoundException exception) {
            System.out.println(exception.getMessage());
            return false;
        }

    }

    public void removePerson (String name) {
        try {
            if (personMap.containsKey(name)) {
                personMap.remove(name);
                if (personMap.containsKey(name)) {
                    throw new PersonNotRemovedException();
                }
            }
        }
        catch (PersonNotFoundException exception) {
            System.out.println(exception.getMessage());
        }
    }

    public void printPersonsWithGet () {
        final Set set = personMap.keySet();
        final Iterator iterator = set.iterator();

        for (int i = 0; i < personMap.size(); i++) {
            String key = (String) iterator.next();
            System.out.println(personMap.get(key));
        }
    }

    public void printPersonsWithGetValue () {
        final Set set = personMap.keySet();

        for (Map.Entry<String, Person> currentPerson : personMap.entrySet()) {
            System.out.println(currentPerson.getKey() + ": " + currentPerson.getValue());
        }
    }
}
