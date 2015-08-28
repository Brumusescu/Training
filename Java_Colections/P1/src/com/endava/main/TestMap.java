package com.endava.main;

import com.endava.errors.PersonNotFoundException;
import com.endava.map.operations.MapOperations;
import com.endava.person.Person;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created by dbrumusescu on 8/27/2015.
 *
 * Create a test class TestMap that will call all the previously define methods.
 */
public class TestMap {
    private static Map<String, Person> personMap = new HashMap<>();

    public static void main(String[] args) throws PersonNotFoundException, PersonNotFoundException{
        Person alex = new Person("Alex", 1988);
        personMap.put(alex.getName(), alex);
        Person adrian = new Person("Adrian", 1990);
        personMap.put(adrian.getName(), adrian);
        Person cornelia = new Person("Cornelia", 1991);
        personMap.put(cornelia.getName(), cornelia);
        Person diana = new Person("Diana", 1992);
        personMap.put(diana.getName(), diana);

        System.out.println("Get person: ");
        MapOperations mapOperations = new MapOperations(personMap);

        Person personFound = mapOperations.getPerson("Diana");
        Person personMissing = mapOperations.getPerson("doe");

        System.out.println("Find person: ");
        if (mapOperations.findPerson("Alex")){
            System.out.println("Person found!");
        }
        else {
            System.out.println("Person not found!");
        }

        System.out.println("Remove person: ");
        mapOperations.removePerson("Alex");

        System.out.println("Print persons with get(): ");
        mapOperations.printPersonsWithGet();

        System.out.println("Print persons with getValue(): ");
        mapOperations.printPersonsWithGetValue();
    }

}
