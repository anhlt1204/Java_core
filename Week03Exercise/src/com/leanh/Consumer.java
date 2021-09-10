package com.leanh;

import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class Consumer extends Thread {
    private List<Message> queue;
    private String color;
    private ReentrantLock queueLock;

    private static int dequeue = 0;
    public static boolean flag = false;

    public Consumer(List<Message> queue, String color, ReentrantLock queueLock) {
        this.queue = queue;
        this.color = color;
        this.queueLock = queueLock;
    }

    @Override
    public void run() {
        int counter = 0;
        int count = 0;

        while(true) {
            if(queueLock.tryLock()) {
                try {
                    // Kiểm tra queue rỗng, nếu rỗng Consumer sẽ chờ khi có message
                    if(queue.isEmpty()) {
//                        System.out.println("Queue is empty. Wait ...");
                        continue;
                    }
                    // Nếu nhận ddc message EOF thì cờ flag sẽ báo để dừng chương trình
                    if(queue.get(0).getContent().equals("EOF")) {
                        System.out.println(color + "-----> Receive " + queue.remove(0));
                        dequeue++;
                        System.out.println(color + "Exiting");
                        flag = true;
                        break;
                    } else {
                        System.out.println(color + "-----> Receive " + queue.remove(0));
                        dequeue++;
                    }

                    Thread.sleep(500);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    queueLock.unlock();
                }
            } else {
                counter++;
            }
        }
    }

    public static int getDequeue() {
        return dequeue;
    }

    public static void setDequeue(int dequeue) {
        Consumer.dequeue = dequeue;
    }
}
