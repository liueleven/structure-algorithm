package v4.list;

/**
 * @description: 链表
 * @date: 2021-06-02 22:33
 * @author: liuziqing
 */
public class List {

    public static void main(String[] args) {
        Node node = new Node(1, new Node(2,new Node(3,new Node(4,null))));

        while (node != null) {
            System.out.println(node.data);
            node = node.node;
        }
    }




    static class Node {
        private int data;

        private Node node;

        public Node(int data, Node node) {
            this.data = data;
            this.node = node;
        }
    }
}
