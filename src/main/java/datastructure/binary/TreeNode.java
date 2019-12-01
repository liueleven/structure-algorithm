package datastructure.binary;


import com.sun.javafx.scene.NodeHelper;

import java.util.*;
import java.util.function.Function;

/**
 * @description: 前序、中序、后序，指的是根节点出现的位置
 * @date: 2019-04-06 19:37
 * @author: 十一
 */
public class TreeNode {


    public static void main(String[] args) {
        Node nodeA = new Node("A");
        Node nodeB = new Node("B");
        Node nodeC = new Node("C");
        Node nodeD = new Node("D");
        Node nodeE = new Node("E");
        Node nodeF = new Node("F");
        Node nodeG = new Node("G");

        nodeA.left = nodeB;
        nodeA.right = nodeC;

        nodeB.left = nodeD;
        nodeB.right = nodeE;

        nodeC.left = nodeF;
        nodeC.right = nodeG;

        TreeNode tr = new TreeNode();
        // 前序非递归,栈 根-左-右
//        List<String> list = tr.preTraversal(nodeA);
//        System.out.println(list.toString());
        // 前序非递归,队列 根-左-右
//        List<String> queueList = tr.preQueueTraversal(nodeA);
//        System.out.println(queueList.toString());
        // 前序递归
        tr.prePrint(nodeA);

        // 后序非递归,栈，左-右-根
//        List<String> list = tr.backTraversal(nodeA);
//        System.out.println(list.toString());
//         后序递归
//        tr.backPrint(nodeA);

//        // 中序非递归
//        List<String> list = tr.midTraversal(nodeA);
//        System.out.println(list.toString());
//         中序递归
//        tr.midPrint(nodeA);

        // 层序遍历
//        tr.levelTraversal(nodeA);


    }


    /**
     * 前序遍历 根->左->右
     * @param root
     */
    public void prePrint(Node root) {
        if (root ==  null) {
            return;
        }

        System.out.print(root.data + ",");

        prePrint(root.left);

        prePrint(root.right);
    }

    /**
     * 非递归前序遍历,利用栈来辅助,先进后出
     * @param root
     * @return
     */
    public List<String> preTraversal(Node root) {
        if (root ==  null) {
            return null;
        }

        List<String> list = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            Node node = stack.pop();
            list.add(node.data);
            if(node.right != null) {
                stack.push(node.right);
            }
            if(node.left != null) {
                stack.push(node.left);
            }
        }

        return list;
    }

    /**
     * 非递归前序遍历,利用队列来辅助,先进先出
     * @param root
     * @return
     */
//    public List<String> preQueueTraversal(Node root) {
//        if (root ==  null) {
//            return null;
//        }
//
//        List<String> list = new ArrayList<>();
//        Queue<Node> queue = new ArrayDeque<>();
//        queue.add(root);
//
//        while (!queue.isEmpty()) {
//            Node node = queue.poll();
//            list.add(node.data);
//
//            if(node.left != null) {
//                queue.add(node.left);
//            }
//            if(node.right != null) {
//                queue.add(node.right);
//            }
//        }
//
//        return list;
//    }

    /**
     * 中序遍历 左->根->右
     * @param root
     */
    public void midPrint(Node root) {
        if (root ==  null) {
            return;
        }

        midPrint(root.left);

        System.out.print(root.data + ", ");

        midPrint(root.right);
    }

    /**
     * 非递归中序遍历,利用栈来辅助,
     * @param root
     * @return
     */
    public List<String> midTraversal(Node root) {
        if (root ==  null) {
            return null;
        }

        List<String> list = new ArrayList<>();
        Stack<Node> stack = new Stack<>();

        stack.push(root);

        while (!stack.isEmpty()) {
            Node node = stack.pop();
            list.add(node.data);
            if(node.right != null) {
                stack.push(node.right);

            }

            if(node.left != null) {
                stack.push(node.left);
            }
        }

        return list;
    }

    /**
     * 后序遍历 左->右->根
     * @param root
     */
    public void backPrint(Node root) {
        if (root ==  null) {
            return;
        }

        midPrint(root.left);

        midPrint(root.right);

        System.out.print(root.data + ",");

    }

    /**
     * 非递归后序遍历,利用栈来辅助,
     * @param root
     * @return
     */
    public List<String> backTraversal(Node root) {
        if (root ==  null) {
            return null;
        }
        List<String> list = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            Node node = stack.pop();

            if(node.left != null) {
                stack.push(node.left);
            }

            if(node.right != null) {
                stack.push(node.right);
            }
            // 将数据插入到0下标，其它元素，向右移动
            list.add(0,node.data);

        }

        return list;
    }

    /**
     * 非递归，层序遍历，上->下，左->右
     * @param root
     */
    public void levelTraversal(Node root) {
        if (root == null) {
            return;
        }
        LinkedList<Node> queue = new LinkedList<Node>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node curr = queue.remove();
            System.out.print(curr.data + " ");
            if (curr.left != null) {
                queue.add(curr.left);
            }
            if (curr.right != null) {
                queue.add(curr.right);
            }

        }
    }









    static class Node {
        private String data;
        private Node left;
        private Node right;

        public Node(String data) {
            this.data = data;
        }
    }

}
