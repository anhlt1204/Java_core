package com.leanh.Exercises50;

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
        locations.put(QUIT, new Location(QUIT, "You are sitting in front of a computer learning Java"));
        locations.put(ROAD, new Location(ROAD, "You are standing at the end of a road before a small brick building"));
        locations.put(HILL, new Location(HILL, "You are at the top of a hill"));
        locations.put(BUILDING, new Location(BUILDING, "You are inside a building, a well house for a small spring"));
        locations.put(VALLEY, new Location(VALLEY, "You are in a valley beside a stream"));
        locations.put(FOREST, new Location(FOREST, "You are in the forest"));

        locations.get(ROAD).addExit("W", HILL);
        locations.get(ROAD).addExit("E", BUILDING);
        locations.get(ROAD).addExit("S", VALLEY);
        locations.get(ROAD).addExit("N", FOREST);

        locations.get(HILL).addExit("N", FOREST);

        locations.get(BUILDING).addExit("W", ROAD);

        locations.get(VALLEY).addExit("N", ROAD);
        locations.get(VALLEY).addExit("W", HILL);

        locations.get(FOREST).addExit("S", ROAD);
        locations.get(FOREST).addExit("W", HILL);
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
