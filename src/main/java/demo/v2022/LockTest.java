package demo.v2022;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @description: 刘子清是个大傻逼
 * @date: 2022-03-06 17:27
 * @author: liuziqing
 */
public class LockTest {

    private static int num = 0;
    private static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();

        t1.start();
        t2.start();

        t1.join();
        t2.join();
        System.out.println("num: " + num);

    }

    static class MyThread extends Thread {

        @Override
        public void run() {
            try {
                // 加锁
                lock.lock();
                for (int i = 0; i < 1000000; i++) {
                    num++;
                }
            } finally {
                // 释放锁
                lock.unlock();
            }
        }
    }
}
