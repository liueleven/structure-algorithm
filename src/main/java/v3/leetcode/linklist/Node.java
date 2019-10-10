package v3.leetcode.linklist;

import java.util.Random;

/**
 * @description: 一定要写注释啊
 * @date: 2019-10-10 14:56
 * @author: 十一
 */
public class Node {
    Integer data;
    Node next;

    public Node(Integer data, Node next) {
        this.data = data;
        this.next = next;
    }

    /**
     * 打印
     * @param node
     */
    public static void printNode(Node node) {
        System.out.println("-start-");
        while (node != null) {
            System.out.println(node.data);
            node = node.next;
        }
        System.out.println("-end-");
    }

    /**
     * 有序节点
     * @param nodeSize 节点数
     * @return
     */
    public static Node getSortNode(int nodeSize) {
        Node n1 = null;
        for (int i = 1; i <= nodeSize; i++) {
            if (n1 == null) {
                n1 = new Node(i,null);
            }else {
                n1 = new Node(i,n1);
            }

        }
        return n1;
    }

    /**
     * 随机节点
     * @param nodeSize 节点数
     * @return
     */
    public static Node getRandomNode(int nodeSize,int bound) {
        Random random = new Random();
        Node n1 = null;
        for (int i = 1; i <= nodeSize; i++) {
            if (n1 == null) {
                n1 = new Node(random.nextInt(bound),null);
            }else {
                n1 = new Node(random.nextInt(bound),n1);
            }

        }
        return n1;
    }

    /**
     * 循环节点
     * @return
     */
    public static Node getcycleNode() {
        Node n1 = new Node(1,null);
        Node n2 = new Node(2,n1);
        Node n3 = new Node(3,n2);
        Node n4 = new Node(4,n3);
        Node n5 = new Node(5,n4);
        Node n6 = new Node(6,n5);
        n1.next = n6;
        return n6;
    }

    public static void main(String[] args) {
//        Node node = getSortNode(5);
//        Node node = getRandomNode(5,10);
        Node node = getcycleNode();
        printNode(node);
    }
}
