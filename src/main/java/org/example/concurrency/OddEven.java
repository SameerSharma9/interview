package org.example.concurrency;

public class OddEven implements Runnable {
    Object obj;
    static Integer count = 1;

    public OddEven(Object obj) {
        super();
        this.obj = obj;
    }

    @Override
    public void run() {

            while(count<20) {
                if(count % 2 == 0 && Thread.currentThread().getName().equals("even")) {
                    synchronized (obj) {
                        System.out.println(Thread.currentThread().getName()+" "+count);
                        count++;
                        try {
                            obj.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }

                } else if(count % 2 != 0 && Thread.currentThread().getName().equals("odd")) {
                    synchronized (obj) {
                        System.out.println(Thread.currentThread().getName()+" "+count);
                        count++;
                        obj.notify();
                    }
                }
            }
    }

    public static void main(String[] args) {
        Object o = new Object();
        Thread t1 = new Thread(new OddEven(o));
        Thread t2 = new Thread(new OddEven(o));
        t1.setName("even");
        t2.setName("odd");
        t1.start();
        t2.start();

    }
}
