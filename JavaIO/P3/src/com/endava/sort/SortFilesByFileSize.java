package com.endava.sort;

import java.io.File;
import java.util.Comparator;

/**
 * Created by dbrumusescu on 9/1/2015.
 */
public class SortFilesByFileSize implements Comparator<File> {
    public int compare (File a, File b ) {
        long aSize = a.length();
        long bSize = b.length();
        if ( aSize == bSize ) {
            return 0;
        }
        else {
            return Long.compare(aSize, bSize);
        }
    }
}
