package v4.list;

/**
 * @description: 链表反转
 * @date: 2021-06-05 22:42
 * @author: liuziqing
 */
public class ReversList {

    public static void main(String[] args) {
        Node n1 = new Node("1");
        Node n2 = new Node("2");
        Node n3 = new Node("3");
        Node n4 = new Node("4");

        n1.setNextNode(n2);
        n2.setNextNode(n3);
        n3.setNextNode(n4);

        Node p = n1;
        printList(p);

        Node rNode = revers(n1);
        System.out.println("反转后：-------");
        printList(rNode);


    }

    public static Node revers(Node n) {
        Node node = new Node(n.data);
        n = n.next;
        while (n != null) {
           Node tmp = new Node(n.data);
           tmp.setNextNode(node);
           node = tmp;
           n = n.next;
        }
        return node;
    }

    public static void printList(Node n) {
        while (n != null) {
            System.out.println(n.data);
            n = n.next;
        }
    }

    static class Node {

        public String data;
        private Node next;

        public Node(String data) {
            this.data = data;
            this.next = null;
        }

        public void setNextNode(Node node) {
            this.next = node;
        }

        public Node getNextNode() {
            return this.next;
        }
    }
}
