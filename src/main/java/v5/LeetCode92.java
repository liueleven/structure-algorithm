package v5;

import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedHashMap;

/**
 * @description: https://leetcode-cn.com/problems/reverse-linked-list-ii/ 反转链表 2
 *
 * @date: 2021-07-14 22:54
 * @author: liuziqing
 */
public class LeetCode92 {


    @Test
    public void test_true() {
        ListNode n1 = new ListNode(1, null);
        ListNode n2 = new ListNode(2, n1);
        ListNode n3 = new ListNode(3, n2);
        ListNode n4 = new ListNode(4, n3);
        ListNode n5 = new ListNode(5, n4);
        ListNode r = null;

        r = reverseBetween4(n5, 2, 4);
        Assert.assertEquals(r.val, 5);
        Assert.assertEquals(r.next.val, 2);
        Assert.assertEquals(r.next.next.val, 3);
        Assert.assertEquals(r.next.next.next.val, 4);
        Assert.assertEquals(r.next.next.next.next.val, 1);
    }

    @Test
    public void test2_true() {
        ListNode n1 = new ListNode(1, null);
        ListNode r = null;

        r = reverseBetween2(n1, 1, 1);
        Assert.assertEquals(r.val, 1);
    }

    @Test
    public void test3_true() {
        ListNode n1 = new ListNode(1, null);
        ListNode n2 = new ListNode(2, n1);
        ListNode r = null;

        r = reverseBetween2(n2, 1, 1);
        Assert.assertEquals(r.val, 2);
        Assert.assertEquals(r.next.val, 1);
    }

    @Test
    public void test4_true() {
        ListNode n1 = new ListNode(1, null);
        ListNode n2 = new ListNode(2, n1);
        ListNode n3 = new ListNode(3, n2);
        ListNode r = null;

        r = reverseBetween2(n3, 1, 2);
        Assert.assertEquals(r.val, 2);
        Assert.assertEquals(r.next.val, 3);
        Assert.assertEquals(r.next.next.val, 1);
    }



    /**
     * 算法思路
     * 1. 先截取 left 前面的节点
     * 2. 再截取 right 后面的节点
     * 3. 再反正 left-right 这段节点
     * 4. 拼接
     *
     * @param head
     * @param left
     * @param right
     * @return
     */
    public ListNode reverseBetween2(ListNode head, int left, int right) {
        if (left == right) {
            return head;
        }
        // 保留left左边的节点
        ListNode leftNode = head;
        for (int i = 0; i <= left- 1; i++) {
            leftNode = leftNode.next;
        }

        ListNode tmpNode = leftNode;
        for (int i = 0; i < right-left+1; i++) {
            tmpNode = tmpNode.next;
        }
        // 保留中间那段节点
        ListNode midNode = leftNode.next;
        // 保留right右边的节点
        ListNode rightNode = tmpNode.next;

        leftNode.next = null;
        tmpNode.next = null;

        ListNode reverNode = reverse(midNode);
        // 拼接
        leftNode.next = reverNode;
        midNode.next = rightNode;
        return leftNode;

    }

    /**
     * 链表反转
     * @param midNode
     * @return
     */
    private ListNode reverse(ListNode midNode) {
        // 存反正后的结果
        ListNode r = null;
        while (midNode != null) {
            ListNode t = r;
            r = midNode;
            midNode = midNode.next;
            r.next = t;
        }
        return r;
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        // 因为头节点有可能发生变化，使用虚拟头节点可以避免复杂的分类讨论
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;

        ListNode pre = dummyNode;
        // 第 1 步：从虚拟头节点走 left - 1 步，来到 left 节点的前一个节点
        // 建议写在 for 循环里，语义清晰
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }

        // 第 2 步：从 pre 再走 right - left + 1 步，来到 right 节点
        ListNode rightNode = pre;
        for (int i = 0; i < right - left + 1; i++) {
            rightNode = rightNode.next;
        }

        // 第 3 步：切断出一个子链表（截取链表）
        ListNode leftNode = pre.next;
        ListNode curr = rightNode.next;

        // 注意：切断链接
        pre.next = null;
//        rightNode.next = null;
        rightNode = null;

        // 第 4 步：同第 206 题，反转链表的子区间
        reverseLinkedList(leftNode);

        // 第 5 步：接回到原来的链表中
        pre.next = rightNode;
        leftNode.next = curr;
        return dummyNode.next;
    }

    private void reverseLinkedList(ListNode head) {
        // 也可以使用递归反转一个链表
        ListNode pre = null;
        ListNode cur = head;

        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
    }

    public ListNode reverseBetween4(ListNode head, int left, int right) {
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode pre = dummyNode;
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }
        ListNode cur = pre.next;
        ListNode next;
        for (int i = 0; i < right - left; i++) {
            next = cur.next;
            cur.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }
        return dummyNode.next;
    }



    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        public ListNode(int val) {
            this.val = val;
        }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public ListNode getNext() {
            return next;
        }

        public void setNext(ListNode next) {
            this.next = next;
        }
    }
}
