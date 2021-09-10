package com.leanh;

import java.util.LinkedList;
import java.util.List;
import java.util.Timer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

public class Main {

    private static List<Message> queue = new LinkedList<Message>();
    private static Timer timer = new Timer();
    // Biến thể hiện số lượng Producer đc chạy
    public static int numberOfProducer = 5;
    // Biến thể hiện số lượng Consumer đc chạy
    public static int numberOfConsumer = 2;

    public static void main(String[] args) throws InterruptedException {

        ReentrantLock queueLock = new ReentrantLock();

        // tạo một pool chứa số lượng thread của Producer và Consumer
        ExecutorService executor = Executors.newFixedThreadPool(numberOfProducer + numberOfConsumer);

        // Đo tốc độ enqueue và dequeue, hiển thị sau mỗi 3s
        Speed speed = new Speed();
        timer.schedule(speed, 0, 3000);

        for (int i = 0; i < numberOfProducer; i++) {
            Producer producer = new Producer(queue, ThreadColor.ANSI_RED, queueLock);
//            producer.start();
            executor.execute(producer);
        }

        for (int i = 0; i < numberOfConsumer; i++) {
            Consumer consumer = new Consumer(queue, ThreadColor.ANSI_CYAN, queueLock);
//            consumer.start();
            executor.execute(consumer);
        }

        executor.shutdown();
    }

    public static List<Message> getQueue() {
        return queue;
    }

    public static Timer getTimer() {
        return timer;
    }
}
