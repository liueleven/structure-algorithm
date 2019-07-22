package datastructure.thread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @description: ReentrantLock 公平锁
 * @date: 2019-03-26 08:10
 * @author: 十一
 */
public class ReentrantLockDemo implements Runnable{

    /**
     * true设置为公平锁
     */
    private ReentrantLock lock = new ReentrantLock(true);

    @Override
    public void run() {
        while (true) {
            try {
                lock.lock();
                System.out.println(Thread.currentThread().getName() + " get lock");
                Thread.sleep(1);

            }catch (Exception e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        ReentrantLockDemo rntrt = new ReentrantLockDemo();
        Thread t1 = new Thread(rntrt);
        Thread t2 = new Thread(rntrt);
        t1.start();
        t2.start();
        // 打印结果，交替获取锁
//        Thread-0 get lock
//        Thread-1 get lock
//        Thread-0 get lock
//        Thread-1 get lock
//        Thread-0 get lock
    }
}
