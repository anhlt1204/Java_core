package com.leanh;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Bài tập về mảng
 */
public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = 0;
        int x = 0;
        double[] numbersArray;
        boolean inputN = true;

        System.out.println("Nhập số lượng phần tử n của mảng (Là số nguyên dương)");
        System.out.print("Nhập n = ");
        inputN = scanner.hasNextInt();

        if(inputN) {
            n = scanner.nextInt();

            if (n < 1) {
                System.out.println("Số lượng phần tử không hợp lệ");
            } else {
                numbersArray = initNumbersArray(n);
                System.out.print("Mảng ban đầu : ");
                printNumbersArray(numbersArray, n);
                System.out.println();

                x = removeNumberLessThan50(numbersArray);
                System.out.print("\n\nMảng sau khi xóa : ");
                printNumbersArray(numbersArray, x);
            }
        } else {
            System.out.println("Vui lòng nhập n là 1 số nguyên dương");
        }

    }

    // Khởi tạo mảng ngẫu nhiên có n phần tử double < 100
    public static double[] initNumbersArray(int n) {
        double[] numbersArray = new double[n];

        for(int i = 0; i < n; i++) {
            numbersArray[i] = Math.random() * 100;
        }

        return numbersArray;
    }

    // Xóa phần tử trong mảng có giá trị < 50 và trả về số lượng phần tử còn lại của mảng
    public static int removeNumberLessThan50 (double[] numbersArray) {
        int n = numbersArray.length;

        for(int i = 0; i < n - 1; i++) {
            double currenNumber = numbersArray[i];
            double nextNumber = numbersArray[i + 1];
            if (currenNumber < 50) {
                deleteNumberByIndex(numbersArray, i);
                System.out.printf("\nXóa phần tử có giá trị %5.2f", currenNumber);
                n--;

                /**
                 * Kiểm tra phần tử kế tiếp có < 50 ko
                 *  - Nếu có phải i-- để ko bị bỏ xót khi xóa
                 */
                if(nextNumber < 50) {
                    i--;
                }
            }
        }

        // Kiểm tra phần tử cuối cùng trong mảng, nếu < 50 thì xóa
        if (numbersArray[n - 1] < 50) {
            deleteNumberByIndex(numbersArray, n - 1);
            System.out.printf("\nXóa phần tử có giá trị %5.2f", numbersArray[n - 1]);
            n--;
        }
        return  n;
    }

    // Xóa phần tử theo vị trí k cho trước
    public static void deleteNumberByIndex(double[] numbersArray, int k) {
        int n = numbersArray.length;
        if(k < 0 || k > n - 1) {
            System.out.println("Vị trí không hợp lệ");
        } else {
            for(int i = k; i < n - 1; i++) {
                numbersArray[i] = numbersArray[i+1];
            }
            n--;
        }
    }

    // In danh sách mảng
    public static void printNumbersArray(double[] numbersArray, int n) {
        if (n == 0) {
            System.out.println("Mảng rỗng");
        } else {
            for (int i = 0; i < n; i++) {
                System.out.printf("%-10.2f", numbersArray[i]);
            }
        }

    }
}
