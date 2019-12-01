package v3.leetcode.concurrent;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @description: 交替打印FooBar
 * @date: 2019-11-04 21:25
 * @author: 十一
 */
public class _1115PrintFooBar {

    /**
     * 自旋打印是为了更好的看到自旋效果
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
//        FooBar fooBar = new FooBar(2);
        FooBar fooBar = new FooBar(20);
//        FooBar fooBar = new FooBar(2);
//        FooBar fooBar = new FooBar(200);
//        FooBar fooBar = new FooBar(50);



        new Thread(() -> {
            try {
                fooBar.bar(new Work("bar"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        // 测试 自旋
        TimeUnit.SECONDS.sleep(1);
        new Thread(() -> {
            try {
                fooBar.foo(new Work("foo"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

    }

    private static class Work implements Runnable {
        private String msg;
        public Work(String msg) {
            this.msg = msg;
        }
        @Override
        public void run() {
            System.out.print(msg);
        }
    }

    private static class FooBar {
        private Lock lock = new ReentrantLock(true);
        private boolean flag = true;
        private int n;

        public FooBar(int n) {
            this.n = n;
        }

        public void foo(Runnable printFoo) throws InterruptedException {

            for (int i = 0; i < n; i++) {
                // 自旋
                while (!flag);
                try {
                    lock.lock();
                    flag = false;
                    // printFoo.run() outputs "foo". Do not change or remove this line.
                    printFoo.run();
                } finally {
                    lock.unlock();
                }

            }
        }

        public void bar(Runnable printBar) throws InterruptedException {

            for (int i = 0; i < n; i++) {
                // 自旋
                while (flag) {
                    System.out.print("=");
                }
                try {
                    lock.lock();
                    flag = true;
                    // printBar.run() outputs "bar". Do not change or remove this line.
                    printBar.run();
                } finally {
                    System.out.println();
                    lock.unlock();
                }

            }
        }
    }
}
