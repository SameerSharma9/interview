package org.example.concurrency;

public class PrintOddEven {

    public static void main(String[] args) {
        OddEvenNumbers obj = new OddEvenNumbers(10);
        Thread odd = new Thread(new Runnable() {
            @Override
            public void run() {
                obj.printOdd();
            }
        });
        Thread even = new Thread(new Runnable() {
            @Override
            public void run() {
                obj.printEven();
            }
        });

        odd.start();
        even.start();

    }
}

class OddEvenNumbers {
    private volatile int counter = 1;
    private int limit;

    public OddEvenNumbers(int limit) {
        this.limit = limit;
    }

    synchronized void printOdd() {
        while(counter <= limit) {
            if(counter % 2 == 1) {
                System.out.println(counter);
                counter++;
                notifyAll();
            }
            try {
                wait();
            } catch (InterruptedException e) {}
        }
    }

    synchronized void printEven() {
        while(counter <= limit) {
            if(counter % 2 == 0) {
                System.out.println(counter);
                counter++;
                notifyAll();
            }
            try {
                wait();
            } catch (InterruptedException e) {}
        }
    }
}
