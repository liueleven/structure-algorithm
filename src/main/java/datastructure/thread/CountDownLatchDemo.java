package datastructure.thread;

import java.lang.annotation.Target;
import java.util.concurrent.CountDownLatch;

/**
 * @description: 一定要写注释啊
 * @date: 2019-03-28 22:07
 * @author: 十一
 */
public class CountDownLatchDemo {

    public static void main(String[] args) {
        try {
            new CountDownLatchDemo().go();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void go() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(3);
        new Thread(new Task(countDownLatch),"Thread1").start();
        Thread.sleep(1000);
        System.out.println(countDownLatch.getCount());
        new Thread(new Task(countDownLatch),"Thread2").start();
        Thread.sleep(1000);
        System.out.println(countDownLatch.getCount());
        new Thread(new Task(countDownLatch),"Thread3").start();
        Thread.sleep(1000);
        System.out.println(countDownLatch.getCount());
        while (countDownLatch.getCount() > 0) {
            System.out.println("开始循环减减");
            countDownLatch.countDown();
        }
        countDownLatch.await();
        System.out.println("所有线程已经到达，祝线程开始执行 " + System.currentTimeMillis());

    }

    class Task implements Runnable {
        private CountDownLatch countDownLatch;

        public Task(CountDownLatch countDownLatch) {
            this.countDownLatch = countDownLatch;
        }

        @Override
        public void run() {
            System.out.println("线程  " + Thread.currentThread().getName() + "已到达 " + System.currentTimeMillis());
            // 正常情况下这里可以减一个
//            this.countDownLatch.countDown();
        }
    }
}
