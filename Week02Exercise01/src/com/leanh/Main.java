package com.leanh;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int n = getInt("Nhập số dòng cuối cùng muốn in: ");
        if (n < 0) {
            System.out.println("Vui lòng nhập số nguyên dương");
        } else {
            String path = getString("Nhập đường dẫn file: ");
            if (path == null) {
                System.out.println("Đường dẫn không hợp lệ");
            } else {
                printTail(n, path);
            }
        }
    }

    private static void printTail(int n, String path) {
        int count = 0;
        RandomAccessFile raf = null;

        try {
            // tạo RandomAccessFile chế độ đọc "r"
            raf = new RandomAccessFile(path,"r");

            // Tạo array lưu chỉ mục từng dòng
            ArrayList<Long> arrayList = new ArrayList<>();

            String line = "";

            // Duyệt từng dòng trong file
            while((line = raf.readLine()) != null)
            {
                // Kiểm tra độ dài trên 1 dòng
                if (line.length()>256) {
                    System.out.println("File không hợp lệ, trong file tồn tại dòng có nhiều hơn 256 ký tự");
                    return;
                }
                // Lưu chỉ mục từng dòng vào array
                arrayList.add(raf.getFilePointer());
                count++;
            }

            // Kiểm tra số dòng muốn in có hợp lệ không
            if (n > count) {
                System.out.println("File chỉ có " + count + " dòng");
                System.out.println("Không thể in " + n + " dòng");
                return;
            }

            System.out.println("File có " + count + " dòng");
            System.out.println("In " + n + " dòng cuối cùng");

            raf = new RandomAccessFile(path,"r");
            int startPoint = count - n - 1;
            if (startPoint >= 0) {
                // Chuyển con trỏ đến trước dòng đầu tiên muốn in
                raf.seek(arrayList.get(startPoint));
            }
            while((line = raf.readLine()) != null)
            {
                System.out.println(line);
            }

        } catch (IOException e) {
            System.out.println("File không tồn tại, vui lòng kiểm tra lại.");
        } finally {
            if (raf != null) {
                try {
                    raf.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // Hàm nhập đường dẫn
    private static String getString(String alert) {
        if (alert == null || alert.trim().length() < 1) {
            System.out.println("Thông báo không hợp lệ");
            return null;
        }

        scanner.nextLine();

        String path = "aaa";

        do {
            if (path.trim().length() < 1) {
                System.out.println("Đường dẫn không hợp lệ");
            }
            System.out.print(alert);
            path = scanner.nextLine();
        } while (path.trim().length() < 1);

        return path;
    }

    // Hàm nhập số dòng
    private static int getInt(String alert) {
        if (alert == null || alert.trim().length() < 1) {
            System.out.println("Thông báo không hợp lệ");
            return -1;
        }
        while (true) {
            try {
                System.out.print(alert);
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                scanner.nextLine();
                System.out.println("Vui lòng nhập vào 1 số nguyên");
            } catch (NoSuchElementException e) {
                scanner.nextLine();
                System.out.println("Vui lòng nhập vào 1 số nguyên");
            }
        }
    }
}
