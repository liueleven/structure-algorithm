package v3.leetcode.tree;

/**
 * @description: 一定要写注释啊
 * @date: 2019-10-12 19:25
 * @author: 十一
 */
public class _10ValidateBST {

    public static void main(String[] args) {

        Node n5 = new Node(1,null,null);
        Node n4 = new Node(1,null,null);
        Node n3 = new Node(1,null,null);
        Node n2 = new Node(1,n4,n5);
        Node n1 = new Node(1,n2,n3);
        midTraversal(n1);
    }

    private static void midTraversal(Node root) {
        Node n = root;
//        while ()
    }

    static class Node {
        private int data;
        private Node left,right;

        public Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
}
