package v4.list;

/**
 * @description: 刘子清是个大傻逼
 * @date: 2021-06-04 22:23
 * @author: liuziqing
 */
public class Node {

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

    public static void main(String[] args) {

        Node first = new Node("1");
        Node second = new Node("2");
        Node third = new Node("3");

        first.setNextNode(second);
        second.setNextNode(third);

        Node current = first;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }

    }

}
