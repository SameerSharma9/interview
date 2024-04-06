package org.example.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static java.lang.Thread.sleep;

public class Counter {

    private AtomicInteger count = new AtomicInteger(0);
    //int count;

    private  void updateCount() throws InterruptedException {
        sleep(50);
        count.addAndGet(1);
        //count++;
        System.out.println(count);
    }

    public static void main(String[] args) {
        Counter c = new Counter();
        Thread t1 = new Thread(()-> {
            for (int i = 0; i < 50; i++) {
                try {
                    c.updateCount();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        Thread t2 = new Thread(()-> {
            for (int i = 0; i < 50; i++) {
                try {
                    c.updateCount();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        Thread t3 = new Thread(()-> {
            for (int i = 0; i < 50; i++) {
                try {
                    c.updateCount();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        t1.start();
        t2.start();
        t3.start();
    }
}
