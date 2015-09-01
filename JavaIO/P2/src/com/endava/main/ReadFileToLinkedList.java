package com.endava.main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.LinkedList;

/**
 * Created by dbrumusescu on 9/1/2015.
 *
 * Open a text file so that you can read the file one line at a time.
 * Read each line as a String and place that String object into a LinkedList.
 * Print all of the lines in the LinkedList in reverse order.
 */
public class ReadFileToLinkedList {
    public static void main(String[] args) {
        try{
            BufferedReader br = new BufferedReader(new FileReader("file.in"));
            LinkedList<String> linkedList = new LinkedList <>();
            String line;

            while ((line = br.readLine()) != null){
                linkedList.add(line);
            }

            for (int printLine = linkedList.size()-1; printLine >= 0; printLine--){
                System.out.println(linkedList.get(printLine));
                linkedList.remove(printLine);
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
