package org.example.interview;

public class TuringInterview {

    public static void main(String[] args) {
        OddEven oe = new OddEven();
        Thread evenT = new Thread(()->oe.printEven(10));
        Thread oddT = new Thread(()->oe.printOdd(10));
        oddT.start();
        evenT.start();
    }

}

class OddEven {
    volatile  int counter = 1;

    synchronized void printEven(int limit) {
        while(limit >= counter) {
            if(counter % 2 == 0) {
                System.out.println(counter);
                counter ++;
                notify();
            }
            try{
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
    synchronized void printOdd(int limit) {
        while(limit >= counter) {
            if(counter % 2 == 1) {
                System.out.println(counter);
                counter ++;
                notify();
            }
            try{
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
