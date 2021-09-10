package com.leanh;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class Producer extends Thread {
    private static int sizeOfQueue = 5;
    private static int sizeOfList = 10;
    // Biến đo tốc độ dequeue
    private static int enqueue = 0;
    // Biến đếm số thread Producer đã hoàn thành
    public static int count = 0;

    private List<Message> queue;
    private String color;
    private ReentrantLock queueLock;

    public Producer(List<Message> queue, String color, ReentrantLock queueLock) {
        this.queue = queue;
        this.color = color;
        this.queueLock = queueLock;
    }

    @Override
    public void run() {
        List<Message> messages = new LinkedList<Message>();
        for (int i = 0; i < sizeOfList; i++) {
            Message m = new Message(this.getName() + "'s message");
            messages.add(m);
        }

        for(Message m : messages) {
            try {
                queueLock.lock();
                try {
                    // Kiểm tra queue đầy, nếu đầy Producer sẽ chờ khi có queue có chỗ trống
                    if (queue.size() >= sizeOfQueue) {
                        System.out.println("Queue is full. Wait ...");
                        continue;
                    } else {
                        System.out.println(color + "-----> Send ... " + m);
                        queue.add(m);
                        enqueue++;
                    }
                } finally {
                    queueLock.unlock();
                }

                Thread.sleep(1000);

            } catch(InterruptedException e) {
                System.out.println("Producer was interrupted");
            }
        }
        count++;
    }

    public static int getEnqueue() {
        return enqueue;
    }

    public static void setEnqueue(int enqueue) {
        Producer.enqueue = enqueue;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Producer.count = count;
    }
}
