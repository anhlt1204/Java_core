package com.leanh;

public class Main {

    public static void main(String[] args) {
        printYearsAndDays(525600);
        printYearsAndDays(1051200);
        printYearsAndDays(561600);
    }

    public static void printYearsAndDays(long minutes) {
        if(minutes < 0) {
            System.out.println("Invalid Value");
        } else {
            long years = minutes / 525600;
            long days = (minutes % 525600) / (24 * 60);
            System.out.println(minutes + " min = " + years + " y and " + days + " d");
        }
    }
}
