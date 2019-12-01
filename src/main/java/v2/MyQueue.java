package v2;

import java.util.HashMap;

/**
 * @description: 链表lru
 * @date: 2019-10-29 13:15
 * @author: 十一
 */
public class MyQueue<T> {

    /**
     * 队列长度
     */
    private int length;
    /**
     * 队列已有的元素
     */
    private int capacity;

    /**
     * 头结点
     */
    private Node head;

    public MyQueue(int length) {
        this.length = length;
        this.capacity = 0;
    }

    public MyQueue() {
        this.length = 3;
        this.capacity = 0;
    }

    public boolean add(T data) {
        // 队列是空的，就是头结点
        if (head == null) {
            head = new Node(null, data);
            capacity++;
            return true;
        }
        if (head.data.equals(data)) {
            return true;
        }
        // 看看这个结点是否已经存在队列中
        Node node = findPreNode(data);
        if (node == null) {
            if (capacity < length) {
                insertToHead(data);
                capacity++;
                return true;
            }
        } else {
            deleteNextNode(node);
            insertToHead(data);
            return true;
        }

        // 队列满了，剔除尾部的
        deleteEndNode();
        insertToHead(data);
        return true;
    }

    private void deleteEndNode() {
        Node node = head;
        while (node.next != null) {
            if (node.next.next == null) {
                node.next = null;
                return;
            }
            node = node.next;
        }
    }

    /**
     * 删除下一个节点
     *
     * @param node
     */
    private void deleteNextNode(Node node) {
        if (node.next.next != null) {
            node.next = node.next.next;
        }
    }

    /**
     * 看看这个结点是否已经存在队列中，存在就找到它的头结点
     *
     * @param data
     * @return
     */
    private Node findPreNode(T data) {
        Node tmp = head;
        while (tmp.next != null && tmp.next.next != null) {
            if (data.equals(tmp.next.data)) {
                return tmp;
            }
            tmp = tmp.next;
        }
        return null;
    }

    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(1);
        queue.add(4);
        queue.add(4);
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.printAll();
    }

    private void printAll() {
        Node tmp = head;
        if (tmp == null) {
            return;
        }

        while (tmp != null) {
            System.out.println(tmp.data);
            if (tmp.next == null) {
                break;
            }
            tmp = tmp.next;
        }
    }

    private void insertToHead(T data) {
        if (data.equals(head.data)) {
            return;
        }
        head = new Node(head, data);
    }


    private static class Node<T> {

        private Node next;
        private T data;

        public Node(Node next, T data) {
            this.next = next;
            this.data = data;
        }
    }
}
