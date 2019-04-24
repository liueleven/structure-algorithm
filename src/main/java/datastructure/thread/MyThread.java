package datastructure.thread;

import java.util.concurrent.*;

/**
 * @description: 一定要写注释啊
 * @date: 2019-03-21 00:53
 * @author: 十一
 */
public class MyThread implements Runnable {

    private String name = null;

    @Override
    public void run() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        name = "123";
    }

    public static void main(String[] args) {
        MyThread mt1 = new MyThread();
        new Thread(mt1).start();
        while (mt1.name == null) {

        }
        System.out.println(mt1.name);
    }

}
class MyThread2 extends Thread {

    private String value = null;

    @Override
    public void run() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        value = "123";
    }

    public static void main(String[] args) {
        MyThread2 mt2 = new MyThread2();
        mt2.start();
        try {
            // 使用join阻塞当前线程等子线程执行完
            mt2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(mt2.value);
    }

}
class MyCallable implements Callable<String> {

    @Override
    public String call() throws Exception {
        String result = "考试完成";
        System.out.println("入考场...");
        System.out.println("考试中...");
        Thread.sleep(5000);

        return result;
    }
}

class MyFutureTaskTest {
    public static void main(String[] args) {
        FutureTask<String> task = new FutureTask<String>(new MyCallable());
        new Thread(task).start();
        // 判断任务是否完成
        if(!task.isDone()) {
            System.out.println("考试还未完成...");
        }
        try {
            System.out.println(task.get());
            System.out.println(task.isDone());
        }catch (Exception e){
            e.getCause();
        }
    }
}
