package datastructure.bintree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @description: 二叉查找树
 * @date: 2019-04-08 11:49
 * @author: 十一
 */
public class BinSearchTree {

//    private Integer[] arr = {"A","B","C","D","E","F","G"};

    private Node tree;

    public static void main(String[] args) {
        Node root = new Node(13);
        Node n1 = new Node(10);
        Node n2 = new Node(16);

        Node n3 = new Node(9);
        Node n4 = new Node(11);

        Node n5 = new Node(14);

        root.left = n1;
        root.right = n2;

        n1.left = n3;
        n1.right = n4;

        n2.left = n5;

        BinSearchTree bst = new BinSearchTree();
        bst.tree = root;

//        Node node = bst.find(9);
//        System.out.println(node);
        List<Integer> list = bst.levelTraversal(bst.tree);
        System.out.println(list.toString());
//        bst.insert(12);
//        bst.tree = root;
//        List<Integer> list1 = bst.levelTraversal(bst.tree);
//        System.out.println(list1.toString());
        bst.midTraversal(root);
    }

    /**
     * 查找某个节点
     * @param data
     * @return
     */
    public Node find(int data) {
        while (tree != null) {
            if(tree.data == data) {
                return tree;
            }
            if(tree.data > data) {
                tree = tree.left;
            }else {
                tree = tree.right;
            }
        }
        return null;
    }

    public void insert(int data) {
        Node tmp = null;
        while (tree != null) {
            tmp = tree;
            if(tree.data > data) {
                tree = tree.left;
            }else {
                tree = tree.right;
            }

        }
        if(tmp.data > data) {
            tmp.left = new Node(data);
        }else {
            tmp.right = new Node(data);
        }
    }

    public List<Integer> levelTraversal(Node root) {
        List<Integer> list = new ArrayList<>();
        Queue<Node> queue = new ArrayDeque<>();
        Node node = root;
        while (node != null) {
            list.add(node.data);
            if(node.left != null) {
                queue.offer(node.left);
            }
            if(node.right != null) {
                queue.offer(node.right);
            }
            node = queue.poll();
        }
        return list;
    }

    public void midTraversal(Node root) {
        if(root == null) {
            return;
        }
        midTraversal(root.left);
        System.out.println(root.data);
        midTraversal(root.right);
    }




    private static class Node {
        private Integer data;
        private Node left;
        private Node right;

        public Node(Integer data) {
            this.data = data;
        }
    }
}
