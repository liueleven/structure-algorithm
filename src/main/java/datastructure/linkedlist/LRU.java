package datastructure.linkedlist;


/**
 * @description: 简单链表实现LRU缓存
 *                  1. 新增一个结点数据
 *                      1.1 如果存在，移动到头部
 *                      1.2 如果满了，删除尾结点，再放到头结点
 *                      1.3 如果没满，直接放到头结点
 *                  2. 查找一个结点数据
 *                      2.1 如果存在，返回，该结点在头部，不动，否则把该结点移动到头部
 *                      2.2 如果不存在返回 -1
 *
 *                  note：
 * @date: 2019-02-20 10:22
 * @author: 十一
 */
public class LRU<T> {



    /**
     * lru默认容量
     */
    private final static Integer DEFAULT_CAPACITY = 3;

    /**
     * 头结点
     */
    private Node<T> headNode;

    /**
     * 当前lru的容量
     */
    private Integer capacity;

    /**
     * 该lru当前长度
     */
    private Integer length;

    /**
     * 添加一个数据
     * @param data
     */
    public void add(T data) {
        if(data == null) {
            return;
        }
        // 查找上一结点
        Node preNode = findPreNode(data);
        // 如果存在
        if(preNode != null) {
            deleteNextNode(preNode);
            insertToHead(data);
        }else {
            if(this.length >= this.capacity) {
                deleteEndNode();
            }
            insertToHead(data);

        }
    }

    /**
     * 删除尾结点
     */
    private void deleteEndNode() {
        Node ptr = headNode;
        // 空链表直接返回
        if (ptr.getNext() == null) {
            return;
        }

        // 倒数第二个结点
        while (ptr.getNext().getNext() != null && ptr.getNext().getNext().getData() != null) {
            ptr = ptr.getNext();
        }

        Node tmp = ptr.getNext();
        ptr.setNext(null);
        tmp = null;
        length--;
    }

    private void deleteNextNode(Node preNode) {
        Node tmp = preNode.next;
        preNode.next = tmp.next;
        tmp = null;
        length --;
    }


    /**
     * 查找该数据上一个结点
     * @param data
     * @return
     */
    public Node findPreNode(T data) {

        Node node = headNode;
        while (node.next != null) {
            if(data.equals(node.next.data)) {

                return node;
            }
            node = node.next;
        }
        return null;
    }

    /**
     * 打印所有
     */
    public void printAll() {
        System.out.println("==========打印数据============");
        Node node = headNode;
        while (node != null) {
            System.out.println(node.data);
            node = node.next;
        }
        System.out.println("lru lenght: " + this.length);
    }


    public void insertToHead(T data) {
        if(data == null) {
            return;
        }
        Node<T> next = headNode.getNext();
        headNode.setNext(new Node<T>(headNode.getData(),next));
        headNode.setData(data);
        length ++;
    }


    public LRU() {
        this.headNode = new Node<T>();
        this.capacity = DEFAULT_CAPACITY;
        this.length = 0;
    }

    public static void main(String[] args) {
        LRU<Integer> lru = new LRU<Integer>();
        lru.add(1);
        lru.add(2);
        lru.add(3);
        lru.add(4);
        lru.add(2);
        lru.add(5);
        lru.add(1);
        lru.printAll();


    }

    class Node<T> {
        T data;
        Node<T> next;

        public Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }

        public Node() {
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }
    }
}
