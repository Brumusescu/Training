package com.endava.main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

/**
 * Created by dbrumusescu on 9/1/2015.
 *
 * Write a Java program that counts the number of times a particular character,
 * such as a, appears in a txt file.
 * The character can be specified at the command line.
 */
public class CountAppearanceOfACharacter {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        char character;

        System.out.print("Give the character you want to count: ");
        character = reader.next().charAt(0);

        System.out.println("You want to count character " + character);

        try{
            BufferedReader br = new BufferedReader(new FileReader("fis.in"));
            int count = 0;

            int c;
            while ((c = br.read()) != -1) {
                char ch = (char) c;
                if (ch == character)
                    count++;
            }

            br.close();

            System.out.println("Character " + character + " was written for: " + count + " times!");
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
