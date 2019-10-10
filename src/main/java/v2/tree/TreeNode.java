package v2.tree;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @description: 构建一棵二叉树
 * @date: 2019-08-07 21:18
 * @author: 十一
 */
public class TreeNode {


    public static void main(String[] args) {
        Node<String> node1 = new Node<>("A");
        Node<String> node2 = new Node<>("B");
        Node<String> node3 = new Node<>("C");
        Node<String> node4 = new Node<>("D");
        Node<String> node5 = new Node<>("E");
        Node<String> node6 = new Node<>("F");
        Node<String> node7 = new Node<>("G");

        node1.left = node2;
        node1.right = node3;

        node2.left = node4;
        node2.right = node5;

        node3.left = node6;
        node3.right = node7;

        TreeNode treeNode = new TreeNode();
//        treeNode.prePrint(node1);
//        treeNode.preStackPrint(node1);

//        treeNode.midPrint(node1);
        treeNode.midStackPrint(node1);
    }

    /**
     * 递归，中序遍历,左->根->右
     * @param root 根节点
     */
    public void midPrint(Node root) {

        if (root == null) {

            return;
        }
        midPrint(root.left);
        System.out.println(root.data);
        midPrint(root.right);
    }

    /**
     * 非递归，中序遍历,左->根->右
     * @param root 根节点
     */
    public void midStackPrint(Node root) {
        if (root ==  null) {
            return;
        }

        // ???
    }

    /**
     * 递归，前序遍历,根->左->右
     * @param root 根节点
     */
    public void prePrint(Node root) {

        if (root.left == null || root.right == null) {
            System.out.println(root.data);
            return;
        }
        System.out.println(root.data);
        prePrint(root.left);
        prePrint(root.right);
    }

    /**
     * 非递归，前序遍历,根->左->右
     * @param root 根节点
     */
    public void preStackPrint(Node<String> root) {
        Stack<Node> stack = new Stack<Node>();
        List<Object> list = new ArrayList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node tmp = stack.pop();
            list.add(tmp.data);
            if (tmp.right != null) {
                stack.push(tmp.right);
            }
            if (tmp.left != null) {
                stack.push(tmp.left);
            }
        }
        System.out.println(Arrays.toString(list.toArray()));
    }






    static class Node<T> {
        private Node left;
        private Node right;
        private T data;

        public Node(T data) {
            this.data = data;
        }

        public Node() {
        }
    }
}
