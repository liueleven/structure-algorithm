package datastructure.queue;

/**
 * @description: 基于数组实现队列
 * @date: 2019-02-22 20:54
 * @author: 十一
 */
public class ArrayQueue {

    private String[] items;

    /**
     * 数组的大小
     */
    private int n = 0;

    /**
     * 数组头部下标，head=0，说明
     */
    private int head = 0;

    /**
     * 数组尾部下标,tail=n，说明队列满了
     */
    private int tail = 0;


    public ArrayQueue(int capacity) {
        items = new String[capacity];
        n = capacity;
    }

    // 入队
    public boolean enQueue(String item) {
        // 如果尾部tail指针 等于 队列n的长度，说明该队列"曾经"满过，需要进行数据搬移
        if (tail == n) {
            System.out.println("queue has full. entry fail: " + item);
            // 如果head头部指针==0说明队列还是满的状态，没有位置可用
            if (head == 0) {
                return false;
            }
            // 如果尾部指针已经等于队列长度了，head不等于0，说明有出队过的操作，这是头部有空缺，可以向前移动n位
            // 进行数据搬移
            for (int i=head; i<tail; ++i) {
                items[i-head] = items[i];
            }
            tail -= head;
            head = 0;

        }

        items[tail] = item;
        tail++;
        return true;
    }

    // 出队
    public String dequeue() {
        if(head == tail) {
            return null;
        }
        items[head] = null;
        head ++;
        return items[head];
    }

    public  void printall() {
        for (int i=0; i<items.length; i++) {
            System.out.println(items[i]);
            items[i] = null;
            head ++;
            System.out.println("head: " + head);
        }
    }

    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(3);
        queue.enQueue("1");
        queue.enQueue("2");
        queue.enQueue("3");
        queue.enQueue("4");
        queue.dequeue();
        queue.enQueue("4");

        queue.printall();
    }
}
