package datastructure.binary;

import java.util.*;

/**
 * @description: 使用栈非递归来遍历二叉树
 * @date: 2019-04-07 15:30
 * @author: 十一
 */
public class StackTraversal {


    private List<Node> list = new ArrayList<>();

    private String[] arr = {"A","B","C","D","E","F","G"};


    public static void main(String[] args) {

        StackTraversal stackTraversal = new StackTraversal();
        stackTraversal.createBinTree();

        // 前序遍历
//        System.out.println("--------前序遍历---------");
//        List<String> preTraversal = stackTraversal.preTraversal(stackTraversal.list.get(0));
//        System.out.println(preTraversal.toString());
//
////         后序遍历
//        System.out.println("--------后序遍历---------");
//        List<String> backTraversal = stackTraversal.backTraversal(stackTraversal.list.get(0));
//        System.out.println(backTraversal.toString());
//
//        // 中序遍历
//        System.out.println("--------中序遍历---------");
//        List<String> midTraversal = stackTraversal.midTraversal(stackTraversal.list.get(0));
//        System.out.println(midTraversal.toString());

        // 层序遍历
        System.out.println("--------层序遍历---------");
        List<List<String>> levelTraversal = stackTraversal.levelTraversal(stackTraversal.list.get(0));
        System.out.println(levelTraversal.toString());

        // 层序遍历
        System.out.println("--------层序遍历2---------");
        List<String> levelTraversal2 = stackTraversal.levelTraversal2(stackTraversal.list.get(0));
        System.out.println(levelTraversal2.toString());
    }


    /**
     * 前序遍历，栈，先进后出,根-左-右
     * @param root
     */
    public List<String> preTraversal(Node root) {
        List<String> resultList = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            resultList.add(node.data);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }

        }
        return resultList;
    }

    /**
     * 中序遍历，栈，先进后出,左-根-右
     * @param root
     */
    public List<String> midTraversal(Node root) {
        List<String> resultList = new ArrayList<>();
        Stack<Node> stack = new Stack<>();

        do {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            if(!stack.isEmpty()){
                Node node = stack.pop();
                resultList.add(node.data);
                root = node.right;
            }
        }while (!stack.isEmpty() || root != null);
        return resultList;
    }

    /**
     * 后序遍历，栈，先进后出,左-右-根
     * @param root
     */
    public List<String> backTraversal(Node root) {
        List<String> resultList = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            Node node = stack.pop();

            if (node.left != null) {
                stack.push(node.left);
            }

            if (node.right != null) {
                stack.push(node.right);
            }
            //之前的数据向右移动
            resultList.add(0,node.data);

        }
        return resultList;
    }

    /**
     * 使用队列结构
     * @param root
     * @return
     */
    public List<String> levelTraversal2(Node root) {
        if (root == null) {
            return new ArrayList<>(0);
        }
        Queue<Node> queue = new LinkedList<>();
        List<String> list = new ArrayList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node curNode = queue.poll();
            list.add(curNode.data);
            if(curNode.left != null) {
                queue.offer(curNode.left);
            }
            if(curNode.right != null) {
                queue.offer(curNode.right);
            }
        }
        return list;
    }

    /**
     * 层序遍历，从上到下，从左到右，使用队列，先进先出
     * @param root
     * @return
     */
    public List<List<String>> levelTraversal(Node root) {
        if (root == null) {
            return new ArrayList<>(0);
        }

        List<List<String>> result = new ArrayList<>();

        Queue<Node> queue = new LinkedList<Node>();
        queue.offer(root);

        Queue<Node> curLevelNodes = new LinkedList<Node>();

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            curLevelNodes.offer(node);

            if (queue.isEmpty()) {
                List<String> list = new ArrayList<>(curLevelNodes.size());
                while (!curLevelNodes.isEmpty()) {
                    Node curNode = curLevelNodes.poll();
                    list.add(curNode.data);

                    if (curNode.left != null) {
                        queue.offer(curNode.left);
                    }

                    if (curNode.right != null) {
                        queue.offer(curNode.right);
                    }

                }
                result.add(list);
            }
        }


        return result;
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

    private  class Node {
        private String data;
        private Node left;
        private Node right;

        public Node(String data) {
            this.data = data;
        }
    }
}
