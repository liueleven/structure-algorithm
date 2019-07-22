package datastructure.thread;

import sun.print.SunMinMaxPage;

import java.util.concurrent.*;

/**
 * @description: 一定要写注释啊
 * @date: 2019-03-21 07:11
 * @author: 十一
 */
public class ThreadPoolDemo {

    public static void main(String[] args) {
        // 创建线程池
        ExecutorService service = Executors.newCachedThreadPool();
        // 调用
        Future<String> submit = service.submit(new MyCallable());
        if (!submit.isDone()) {
            System.out.println("任务执行中。。。");
        }
        try {
            System.out.println(submit.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }finally {
            // 一定要关闭池
            service.shutdown();
        }
    }
}
