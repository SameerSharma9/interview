package org.example.concurrency;

import java.util.concurrent.CompletableFuture;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

import static java.lang.Thread.sleep;

public class OddEven8 {

    private static Object obj = new Object();

    private static IntPredicate evenCondition = x -> x % 2 == 0;
    private static IntPredicate oddCondition = x -> x % 2 != 0;

    public static void print(IntPredicate cond) {
        IntStream.range(1,20)
                .filter(cond)
                .forEach(OddEven8::execute);
    }

    public static void main(String[] args) throws InterruptedException {
        CompletableFuture.runAsync(() -> OddEven8.print(oddCondition));
        CompletableFuture.runAsync(() -> OddEven8.print(evenCondition));


        sleep(10000);
    }

    public static void execute(int i){
        synchronized (obj) {
            System.out.println(Thread.currentThread().getName()+ "  " +i);
            obj.notify();
            try {
                System.out.println("Hi");
                //sleep(1000);
                obj.wait();
               // sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println(Thread.currentThread().getName()+ "  " +i);
        System.out.println("Bye");
    }
}
