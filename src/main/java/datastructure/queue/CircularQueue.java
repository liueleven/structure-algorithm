package datastructure.queue;


/**
 * @description: 循环队列,因为环形结构，会浪费一个存储空间
 * @date: 2019-02-27 22:50
 * @author: 十一
 */
public class CircularQueue {

    // store queue element
    private String[] items;

    // queue capacity
    private int n = 0;

    // queue head index
    private int head = 0;

    // queue tail index
    private int tail = 0;

    public CircularQueue(int n) {
        items = new String[n];
        this.n = n;
    }

    public boolean enQueue(String item) {
        // 判断队满
        if((tail+1) % n == head) {
            return false;
        }
        items[tail] = item;
        // 循环队列
        tail = (tail+1) % n;
        return true;
    }

    public String deQueue() {
        if(head == tail) {
            return null;
        }
        String ret = items[head];
        head = (head + 1)  % n;
        return ret;
    }
    public  void printAll() {
        for (int i=0; i<items.length-1; i++) {
            System.out.println(items[i]);
            items[i] = null;
            head ++;
        }
    }

    public static void main(String[] args) {
        CircularQueue queue = new CircularQueue(3);
        queue.enQueue("1");
        queue.enQueue("2");
        queue.enQueue("3");
        queue.enQueue("4");

        queue.printAll();
    }

}
