package v5;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
 *
 * 二叉树的前序遍历
 *
 * @date: 2021-09-05 23:54
 * @author: liuziqing
 */
public class LeetCode144 {

    @Test
    public void test_true() {
        // root = [1,null,2,3]
        TreeNode root = new TreeNode(1, null,
                new TreeNode(2, new TreeNode(3, null, null), null));

        List<Integer> integers = preorderTraversal(root);
        Assert.assertTrue(integers.get(0) == 1);
        Assert.assertTrue(integers.get(1) == 2);
        Assert.assertTrue(integers.get(2) == 3);
    }

    public List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> integers = new ArrayList<>();
        doSome(root, integers);

        return integers;
    }

    public void doSome(TreeNode root, List<Integer> integers) {
        if (root == null) {
            return;
        }
        integers.add(root.val);
        if (root.left != null) {
            doSome(root.left, integers);
        }
        if (root.right != null) {
            doSome(root.right, integers);
        }
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
