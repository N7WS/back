package com.n7ws.back;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.n7ws.back.enums.DeviceState;

public class Random {
    private static final String ADJECTIVES_FILE = "./src/seed/resources/seeding/adjectives.txt";
    private static final String ANIMAL_NAMES_FILE = "./src/seed/resources/seeding/animals.txt";

    public static String randomName() {
        String[] adjectives;
        String[] animals;
        try {
            adjectives = new String(Files.readAllBytes(Paths.get(ADJECTIVES_FILE))).split("\n");
            animals = new String(Files.readAllBytes(Paths.get(ANIMAL_NAMES_FILE))).split("\n");
        } catch (IOException e) {
            throw new RuntimeException("Error reading files", e);
        }
        return adjectives[(int) (Math.random() * adjectives.length)] + "-" +
               animals[(int) (Math.random() * animals.length)];
    }

    public static DeviceState randomState() {
        DeviceState[] states = DeviceState.values();
        return states[(int) (Math.random() * states.length)];
    }

    public static String randomRoom() {
        String[] buildings = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
        String[] floors = {"1", "2", "3"};
        String[] rooms = {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20"};
        return buildings[(int) (Math.random() * buildings.length)] +
               floors[(int) (Math.random() * floors.length)] +
               rooms[(int) (Math.random() * rooms.length)];
    }

    public static Integer randomPort(){
        return(int) (Math.random() * 10000) %1024 ;
    }
}
