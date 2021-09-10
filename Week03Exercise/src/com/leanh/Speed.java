package com.leanh;

import java.util.TimerTask;
import java.util.concurrent.locks.ReentrantLock;

public class Speed extends TimerTask {
    ReentrantLock queueLock = new ReentrantLock();
    @Override
    public void run() {

        // Nếu số thread Producer được chạy ở main đã chạy xong thì gửi message EOF vào queue
        if (Producer.getCount() == Main.numberOfProducer) {
            System.out.println("Adding EOF and exiting...");
            queueLock.lock();
            try {
                Message m = new Message("EOF");
                Main.getQueue().add(m);
            } finally {
                queueLock.unlock();
            }
            Producer.setCount(0);
        }
        System.out.println("\n--------------> Size of queue " + Main.getQueue().size());
        // Do thời gian đo ở main là 3s nên speed sẽ x20/minute
        System.out.println("--------------> Speed enqueue " + Producer.getEnqueue() / 3 * 60 + " messages/minutes");
        Producer.setEnqueue(0);
        System.out.println("--------------> Speed dequeue " + Consumer.getDequeue() / 3 * 60 + " messages/minutes");
        Consumer.setDequeue(0);
        System.out.println();

        // Nếu cờ báo true thì hủy timer và dừng chương trình
        if (Consumer.flag) {
            Main.getTimer().cancel();
            Main.getTimer().purge();
            System.exit(0);
        }
    }
}
