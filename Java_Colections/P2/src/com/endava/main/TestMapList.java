package com.endava.main;

import com.endava.TVProgram.TVProgram;

/**
 * Created by dbrumusescu on 8/28/2015.
 */
public class TestMapList {
    public static void main(String[] args) {
        TVProgram program = new TVProgram();

        System.out.println("Get program: ");
        program.getProgram();

        System.out.println("\n Print map: ");
        program.printMap();

        System.out.println("\n Print airing dates of a channel: ");
        program.printAiringDates("protv");

        System.out.println("\n Print series by type: ");
        program.printSeriesByType("sf");

        System.out.println("\n Update the airing date for a series from a program: ");
        program.updateAiringDateForSeries("protv", "suleyman", "Friday");
        program.printMap();
    }
}
