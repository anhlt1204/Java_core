package com.leanh.Ex17;

public class Main {

    public static void main(String[] args) {

    }

    public static int getEvenDigitSum(int number) {
        int sum = 0;
        if (number < 0) {
            return -1;
        }

        while (number > 0) {
            int currentDigit = number % 10;
            if (currentDigit % 2 == 0) {
                sum += currentDigit;
            }
            number /= 10;
        }

        return sum;
    }
}
