package com.leanh.Exercises51;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static final int QUIT = 0;
    public static final int ROAD = 1;
    public static final int HILL = 2;
    public static final int BUILDING = 3;
    public static final int VALLEY = 4;
    public static final int FOREST = 5;

    private static Map<Integer, Location> locations = new HashMap<Integer, Location>();
    private static Map<String, String> vocabulary = new HashMap<String, String>();
    private static Scanner scanner = new Scanner(System.in);

    public Main() {
        Map<String, Integer> tempExit = new HashMap<>();
        locations.put(QUIT, new Location(QUIT, "You are sitting in front of a computer learning Java", tempExit));

        tempExit = new HashMap<>();
        tempExit.put("W", HILL);
        tempExit.put("E", BUILDING);
        tempExit.put("S", VALLEY);
        tempExit.put("N", FOREST);
        locations.put(ROAD, new Location(ROAD, "You are standing at the end of a road before a small brick building", tempExit));

        tempExit = new HashMap<>();
        tempExit.put("N", FOREST);
        locations.put(HILL, new Location(HILL, "You are at the top of a hill", tempExit));

        tempExit = new HashMap<>();
        tempExit.put("W", ROAD);
        locations.put(BUILDING, new Location(BUILDING, "You are inside a building, a well house for a small spring", tempExit));

        tempExit = new HashMap<>();
        tempExit.put("N", ROAD);
        tempExit.put("W", HILL);
        locations.put(VALLEY, new Location(VALLEY, "You are in a valley beside a stream", tempExit));

        tempExit = new HashMap<>();
        tempExit.put("S", ROAD);
        tempExit.put("W", HILL);
        locations.put(FOREST, new Location(FOREST, "You are in the forest", tempExit));
    }

    public static void command() {
        initLibraryDirection();

        int loc = ROAD;
        while (true) {
            System.out.println(locations.get(loc).getDescription());
            if (loc == QUIT) {
                break;
            }
            Map<String, Integer> exist = locations.get(loc).getExits();
            System.out.print("Available exits are ");
            for (String exit : exist.keySet()) {
                System.out.print(exit + ", ");
            }
            System.out.println("\b\b");

            System.out.print("You choose ");
            String direction = scanner.nextLine().toUpperCase();
            if (direction.length() > 1) {
                String[] words = direction.split(" ");
                for (String word : words) {
                    if (vocabulary.containsKey(word)) {
                        direction = vocabulary.get(word);
                        break;
                    }
                }
            }
            if (exist.containsKey(direction)) {
                loc = exist.get(direction);
            } else {
                System.out.println("You cannot go in that direction");
            }
        }
    }

    // Khởi tạo thư viện lệnh di chuyển
    private static void initLibraryDirection() {
        vocabulary.put("QUIT", "Q");
        vocabulary.put("NORTH", "N");
        vocabulary.put("SOUTH", "S");
        vocabulary.put("EAST", "E");
        vocabulary.put("WEST", "W");
    }

    public static void main(String[] args) {
        Main m = new Main();
        command();
    }
}
