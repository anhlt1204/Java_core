package com.leanh.Ex15;

public class Main {

    public static void main(String[] args) {
        System.out.println(isPalindrome(-1221));
        System.out.println(isPalindrome(707));
        System.out.println(isPalindrome(11212));
    }

    public static boolean isPalindrome(int number) {
        int absNumber = Math.abs(number);
        int reverseNumber = 0;

        while (absNumber != 0) {
            reverseNumber *= 10;
            reverseNumber += absNumber % 10;
            absNumber /= 10;
        }

        absNumber = Math.abs(number);
        if (absNumber - reverseNumber == 0) {
            return true;
        }
        return false;
    }
}
