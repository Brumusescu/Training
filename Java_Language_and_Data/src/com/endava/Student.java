package com.endava;

import java.math.BigDecimal;

/**
 * Created by dbrumusescu on 8/16/2015.
 */
public class Student {
    public static void main(String[] args) {
        //Excercise 1
        System.out.println("abc" + 1 + 2); //abc12
        System.out.println(1 + 2 + "abc"); //3abc

        //Exercise 2
        boolean c1 = true;
        boolean c2 = false;
        if (c1 | c2) {
            System.out.println("Bitwise OR");
        }

        if (c1 || c2) {
            System.out.println("Conditional OR");
        }

        //Exercise 3
        Student s1 = new Student();
        Student s2 = new Student();
        s1 = s2;
        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));
        System.out.println("Both statements return true because the value of s2 is given to s1 and there are both instances of Student class.");

        //Exercise 4
        System.out.println(5 == new Integer(5));
        //System.out.println(5.0 == new BigDecimal(5.0));
        //Error to second statement

        //Exercise 5
        //Boxing:
        int i = 5;
        Integer I = i;
        System.out.println(I);
        //Autoboxing:
        Integer sum = 0;
        for (Integer index = 0; i < 5; index++) {
            sum += index;
        }
        System.out.println("Sum = " + sum);
        //Unboxing:
        I = 10;
        i = I;
        System.out.println(i);

        //Exercise 6:
        String s3 = "abc";
        String s4 = "def";
        s3 = "abcdef";
        System.out.println("3 String objects were created.");

        //Exercise 7:
        Student s5 = new Student();
        Student s6 = new Student();
        s5 = s6;
        System.out.println("s1 and s2 are referencing to the same object.");

        //Exercise 8:
        System.out.println("When creating an object inside a method Java save the variable in a stack.");
        System.out.println("The object's own attributes get saved on the stack.");

        //Exercise 9:
        double d = 1/1234.5678;
        System.out.println(d);
        System.out.println("The answer's dimension is bigger than doubles.");


        //Exercise 10:
        System.out.println("Classes are named with capital in Camel way.");
        System.out.println("Variables and methods are named with small letter in Camel way.");
    }
}
