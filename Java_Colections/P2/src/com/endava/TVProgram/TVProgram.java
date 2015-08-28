package com.endava.TVProgram;

import com.endava.TVseries.TVSeries;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * Created by dbrumusescu on 8/27/2015.
 */
public class TVProgram {
    private Map<String, List<TVSeries>> programsMap = new HashMap<>();

    public void getProgram() {
        try {
            BufferedReader in = new BufferedReader(new FileReader("info.txt"));
            String key = "";
            String line = "";
            List<TVSeries> tvSeriesList = new ArrayList<>();

            while ((line = in.readLine()) != null) {
                String[] mapParts = line.split(" ");
                TVSeries tvSeries = new TVSeries(mapParts[1], mapParts[2], mapParts[3], mapParts[4]);
                if(!key.equals(mapParts[0]) && !key.equals("")) {
                    programsMap.put(key, tvSeriesList);
                    key = mapParts[0];
                    tvSeriesList = new ArrayList<TVSeries>();
                    tvSeriesList.add(tvSeries);
                } else {
                    key = mapParts[0];
                    tvSeriesList.add(tvSeries);
                }
                programsMap.put(key, tvSeriesList);
            }
            in.close();
        }
        catch (IOException exception) {
            System.out.println(exception.getMessage());
        }

    }

    public void printMap() {
        Iterator iterator = programsMap.keySet().iterator();
        for (int i = 0; i < programsMap.size(); i++) {
            String key = (String) iterator.next();
            System.out.println(key + " : " + programsMap.get(key));
        }
    }

    public void printAiringDates (String channel) {
        List<TVSeries> tvSeriesList = new ArrayList<>();
        TVSeries tvSeries = null;
        final Set set = programsMap.keySet();

        for (Map.Entry<String, List<TVSeries>> currentProgram : programsMap.entrySet()) {
            if (currentProgram.getKey().equalsIgnoreCase(channel)) {
                System.out.println(channel);
                tvSeriesList = currentProgram.getValue();
                for (TVSeries currentTVSeries : tvSeriesList){
                    System.out.println(currentTVSeries.getDay() + " " + currentTVSeries.getHour());
                }
            }
        }
    }

    public void printSeriesByType (String type) {
        List<TVSeries> tvSeriesList = new ArrayList<>();
        TVSeries tvSeries = null;
        final Set set = programsMap.keySet();

        for (Map.Entry<String, List<TVSeries>> currentProgram : programsMap.entrySet()) {
            tvSeriesList = currentProgram.getValue();
            for (TVSeries currentTVSeries : tvSeriesList){
                if (currentTVSeries.getType().equalsIgnoreCase(type)) {
                    System.out.println(currentTVSeries.getType() + " " + currentTVSeries.getName() + " " +currentTVSeries.getDay() + " " + currentTVSeries.getHour());
                }
            }
        }
    }

    public void updateAiringDateForSeries (String channel, String name, String day) {
        List<TVSeries> tvSeriesList = new ArrayList<>();
        TVSeries tvSeries = null;
        final Set set = programsMap.keySet();

        for (Map.Entry<String, List<TVSeries>> currentProgram : programsMap.entrySet()) {
            if (currentProgram.getKey().equalsIgnoreCase(channel)) {
                System.out.println(channel);
                tvSeriesList = currentProgram.getValue();
                for (TVSeries currentTVSeries : tvSeriesList){
                    if (currentTVSeries.getName().equalsIgnoreCase(name)) {
                        currentTVSeries.setDay(day);
                    }
                }
            }
        }
    }

}
