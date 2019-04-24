package datastructure.thread;

/**
 * @description: 一定要写注释啊
 * @date: 2019-03-25 21:00
 * @author: 十一
 */
public class SyncBlockAndMethod {
    public void syncsTask() {
        // 对象锁
        synchronized (this) {
            System.out.println("Hello");
        }
    }

    // 对象锁
    public synchronized void syncTask() {
        System.out.println("hello again");
    }
}
