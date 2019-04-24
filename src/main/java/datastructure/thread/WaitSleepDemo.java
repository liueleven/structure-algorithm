package datastructure.thread;

import java.security.PublicKey;

/**
 * @description: 一定要写注释啊
 * @date: 2019-03-21 12:37
 * @author: 十一
 */
public class WaitSleepDemo {


    public static void main(String[] args) {
        final Object lock = new Object();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(" t1 try to get lock...");
                synchronized (lock) {
                    System.out.println(" t1 get lock.");
                    System.out.println(" t1 ready sleep 2s.");
                    try {
                        // 会让出cpu，还会释放锁
                        lock.wait(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("t1 ok.");

                }
            }
        }).start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(" t2 try to get lock...");
                synchronized (lock) {
                    System.out.println(" t2 get lock.");
                    System.out.println(" t2 ready sleep 1s.");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("t2 ok.");

                }
            }
        }).start();


    }



}
