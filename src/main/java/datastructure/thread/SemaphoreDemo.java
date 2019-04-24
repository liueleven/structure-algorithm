package datastructure.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @description: 一定要写注释啊
 * @date: 2019-03-28 22:43
 * @author: 十一
 */
public class SemaphoreDemo {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();

        // 只有5个可以同时拿到许可
        final Semaphore semaphore = new Semaphore(5);

        //模拟用户访问
        for (int i = 0; i < 10;  i++) {
            final int No = i;
            Runnable runnable = new Runnable() {
                @Override
                public void run() {

                    try {
                        // 拿到许可
                        semaphore.acquire();
                        System.out.println("Accessing: " + No);
                        Thread.sleep(1000);
                        // 释放
                        semaphore.release();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }


                }
            };
            // 放到线程池中执行
            executorService.execute(runnable);
        }
        // 关闭线程池
        executorService.shutdown();
    }
}
