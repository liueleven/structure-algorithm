package v5;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: N 叉树的前序遍历
 *
 * https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/
 *
 *
 * @date: 2021-09-06 06:37
 * @author: liuziqing
 */
public class LeetCode589 {

    @Test
    public void test_true() {
        // input: root = [1,null,3,2,4,null,5,6]
        // result: [1,3,5,6,2,4]
        Node node = new Node(1);
        List<Node> children1 = new ArrayList<>();
        List<Node> children3 = new ArrayList<>();
        Node node3 = new Node(3);
        Node node2 = new Node(2);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);

        children1.add(node3);
        children1.add(node2);
        children1.add(node4);

        children3.add(node5);
        children3.add(node6);

        node.children = children1;
        node3.children = children3;



        List<Integer> integers = preorder(node);
        Assert.assertTrue(integers.get(0) == 1);
        Assert.assertTrue(integers.get(1) == 3);
        Assert.assertTrue(integers.get(2) == 5);
        Assert.assertTrue(integers.get(3) == 6);
        Assert.assertTrue(integers.get(4) == 2);
        Assert.assertTrue(integers.get(5) == 4);
    }

    public List<Integer> preorder(Node root) {
        List<Integer> vals = new ArrayList<>();
        dfs(root, vals);
        return vals;
    }

    private void dfs(Node root, List<Integer> vals) {
        if (root == null) {
            return;
        }
        vals.add(root.val);
        List<Node> children = root.children;
        if (children == null) {
            return;
        }
        for (Node child : children) {
            dfs(child, vals);
        }
    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };
}
