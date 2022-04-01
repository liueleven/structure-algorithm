package demo.v2022;

import java.util.PriorityQueue;

/**
 * @description: 刘子清是个大傻逼
 * @date: 2022-03-08 22:07
 * @author: liuziqing
 */
public class Notify {

    public static void main(String[] args) throws InterruptedException {

        int num = 1;
        Object o = new Object();

        Thread t1 = new Thread(() -> {
            int n = 26;
            synchronized (o) {

                for (int i = 0; i < n; i++) {
                    if (i % 2 == 1) {
                        System.out.println("a="+i);
                        o.notifyAll();
                    }else {
                        try {
                            o.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }

        });

        Thread t2 = new Thread(() -> {
            int n = 26;
            synchronized (o) {

                for (int i = 0; i < n; i++) {
                    if (i % 2 == 0) {
                        System.out.println("b="+i);
                        o.notifyAll();
                    }else {
                        try {
                            o.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }

        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();


    }
}
