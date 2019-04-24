package datastructure.thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @description: 一定要写注释啊
 * @date: 2019-03-28 22:31
 * @author: 十一
 */
public class CyclicBarrierDemo {

    public static void main(String[] args) {
        try {
            new CyclicBarrierDemo().go();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void go() throws InterruptedException {

        CyclicBarrier cyclicBarrier = new CyclicBarrier(4);
        new Thread(new Task(cyclicBarrier),"Thread1").start();
        Thread.sleep(1000);
        new Thread(new Task(cyclicBarrier),"Thread2").start();
        Thread.sleep(1000);
        new Thread(new Task(cyclicBarrier),"Thread3").start();
        Thread.sleep(1000);
        System.out.println("所有线程已经完成：" + System.currentTimeMillis());
    }

    class Task implements Runnable {
        private CyclicBarrier cyclicBarrier;

        public Task(CyclicBarrier cyclicBarrier) {
            this.cyclicBarrier = cyclicBarrier;
        }

        @Override
        public void run() {
            System.out.println("线程：" + Thread.currentThread().getName() + " 已到达 " + System.currentTimeMillis());
            try {

                System.out.println("等待数量：" + cyclicBarrier.getNumberWaiting());
                System.out.println("总共数量：" + cyclicBarrier.getParties());
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }
}
