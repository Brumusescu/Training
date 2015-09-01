package com.endava.main;

import com.endava.sort.SortFilesByFileSize;

import java.io.File;
import java.util.Arrays;

/**
 * Created by dbrumusescu on 9/1/2015.
 *
 * Write a Java program that lists the contents of a folder (eg. C:\Windows) to a file, from the smallest to the largest.
 * Mention type (file/folder), name size.
 * Also experiment with filtering for specific filenames or extensions.
 */
public class ListFolderContents {
    public static void main(String[] args) {
        File folder = new File("C:\\Windows");
        File [] listOfFiles = folder.listFiles();

        Arrays.sort(listOfFiles, new SortFilesByFileSize());

        for (File currentFile : listOfFiles) {
            if (currentFile.isFile()){
                System.out.println("FILE: " + currentFile.getName() + ", SIZE: " + currentFile.length());
            }
            else {
                System.out.println("FOLDER: " + currentFile.getName() + ", SIZE: " + currentFile.length());
            }
        }
    }
}
