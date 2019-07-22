package datastructure.linkedlist;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Queue;

/**
 * @description: 基于队列实现的lru算法
 * @date: 2019-07-22 20:02
 * @author: 十一
 */
public class LruQueue {

    public static void main(String[] args) {
        LruQueue lruQueue = new LruQueue(5);
        lruQueue.add(1);
        lruQueue.add(2);
        lruQueue.add(3);
        lruQueue.add(4);
        lruQueue.add(5);
        lruQueue.add(6);
        lruQueue.printAll();

        System.out.println("---------------");
        lruQueue.del(3);
        lruQueue.printAll();

        System.out.println("---------------");
        System.out.println(lruQueue.isExist(2));

    }

    private void printAll() {
        Iterator<Integer> iterator = queue.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }


    private int len;

    private Queue<Integer> queue;

    public LruQueue(int len) {
        this.len = len;
        queue = new ArrayDeque<Integer>(len);
    }

    public boolean add(int num) {
        // 或者报错
//        if (queue.size() >= len) {
//            throw new RuntimeException("toooooooooooo long");
//        }
        if (queue.size() >= len) {
            queue.poll();
        }
        queue.add(num);
        return true;
    }

    public boolean isExist(int num) {
        Iterator<Integer> iterator = queue.iterator();
        while (iterator.hasNext()) {
            if (iterator.next() == num) {
                return true;
            }
        }
        return false;
    }

    public void del(int num) {
        Iterator<Integer> iterator = queue.iterator();
        while (iterator.hasNext()) {
            if (iterator.next() == num) {
                iterator.remove();
                break;
            }
        }
    }


}
