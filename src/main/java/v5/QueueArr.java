package v5;

/**
 * @description: 基于数组的普通队列
 * @date: 2021-08-22 16:15
 * @author: liuziqing
 */
public class QueueArr {

    public static void main(String[] args) {
        QueueArr queue = new QueueArr(5);
        queue.push(1);
        queue.print();
        queue.push(2);
        queue.print();
        queue.push(3);
        queue.print();
        queue.pop();
        queue.print();
        System.out.println("队首元素：" + queue.front());
        System.out.println("队尾元素：" + queue.backend());
        System.out.println("队列元素长度：" + queue.size());
    }
    /**
     * 队首指针
     */
    private int head;
    /**
     * 队尾指针
     */
    private int tail;
    private int[] arr;

    public QueueArr(int size) {
        this.arr = new int[size];
    }

    public void push(int v) {
        if (full()) {
            return;
        }
        arr[tail] = v;
        tail++;
    }
    public void pop() {
        if (empty()) {
            return;
        }
        head++;
    }

    public void print() {
        StringBuilder s = new StringBuilder();
        for (int i = head; i < tail; i++) {
            s.append(arr[i]).append(" ");
        }
        System.out.println(s.toString());
    }

    /**
     * 差值就是队列有多少元素
     * @return
     */
    public int size() {
        return tail - head;
    }

    public int front() {
        if (empty()) {
            return -1;
        }
        return arr[head];
    }
    public int backend() {
        if (empty()) {
            return -1;
        }
        return arr[tail-1];
    }



    public boolean full() {
        return arr.length == tail;
    }

    public boolean empty() {
        return head == tail;
    }
}
