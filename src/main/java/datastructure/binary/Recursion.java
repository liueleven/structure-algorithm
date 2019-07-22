package datastructure.binary;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 递归方式遍历树
 * @date: 2019-04-07 11:36
 * @author: 十一
 */
public class Recursion {


    private List<Node> list = new ArrayList<>();

    private String[] arr = {"A","B","C","D","E","F","G"};


    public static void main(String[] args) {
        Recursion recursion = new Recursion();
        recursion.createBinTree();

        // 递归前序遍历
//        System.out.println("---------递归前序遍历------------");
//        recursion.recursionPreTraversal(recursion.list.get(0));
//        // 递归中序遍历
//        System.out.println("\n---------递归中序遍历------------");
//        recursion.recursionMidTraversal(recursion.list.get(0));
//        // 递归后序遍历
//        System.out.println("\n---------递归后序遍历------------");
//        recursion.recursionBackTraversal(recursion.list.get(0));

    }
    /**
     * 创建一棵二叉树
     * 二叉树的节点关系：
     */
    public void createBinTree() {
        for (int i = 0; i< arr.length; i++) {
            list.add(new Node(arr[i]));
        }

        int level = (list.size() / 2);
        for (int i = 0; i< level; i++) {
            list.get(i).left = list.get(i*2+1);
            if((i*2+2) < list.size()) {

                list.get(i).right = list.get(i*2+2);
            }
        }

    }

    /**
     * 递归前序遍历，根-左-右
     * @param root
     */
    public void recursionPreTraversal(Node root) {

        if (root == null) {
            return;
        }
        System.out.print(root.data + ",");

        recursionPreTraversal(root.left);
        recursionPreTraversal(root.right);
    }

    /**
     * 递归中序遍历，左-根-右
     * @param root
     */
    public void recursionMidTraversal(Node root) {

        if (root == null) {
            return;
        }
        recursionMidTraversal(root.left);
        System.out.print(root.data + ",");

        recursionMidTraversal(root.right);
    }



    /**
     * 递归后序遍历，左-右-根
     * @param root
     */
    public void recursionBackTraversal(Node root) {

        if (root == null) {
            return;
        }
        recursionBackTraversal(root.left);
        recursionBackTraversal(root.right);
        System.out.print(root.data + ",");

    }



    private static class Node {
        private String data;
        private Node left;
        private Node right;

        public Node(String data) {
            this.data = data;
        }
    }
}
