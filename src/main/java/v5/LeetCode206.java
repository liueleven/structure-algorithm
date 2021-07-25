package v5;

import org.junit.Assert;
import org.junit.Test;

/**
 * @description: https://leetcode-cn.com/problems/reverse-linked-list/ 反转链表
 *
 * @date: 2021-07-14 22:54
 * @author: liuziqing
 */
public class LeetCode206 {

    @Test
    public void test2_true() {
        ListNode n1 = new ListNode(1, null);
        ListNode n2 = new ListNode(2, n1);
        ListNode n3 = new ListNode(3, n2);
        ListNode n4 = new ListNode(4, n3);
        ListNode n5 = new ListNode(5, n4);

        ListNode listNode = reverseList2(n5);
        Assert.assertEquals(listNode.val, 1);
        Assert.assertEquals(listNode.next.val, 2);
    }

    @Test
    public void test_true() {
        ListNode n1 = new ListNode(1, null);
        ListNode n2 = new ListNode(2, n1);
        ListNode n3 = new ListNode(3, n2);
        ListNode n4 = new ListNode(4, n3);
        ListNode n5 = new ListNode(5, n4);
        ListNode r = null;

        r = reverseList(n5);
        Assert.assertEquals(r.val, 1);
        Assert.assertEquals(r.next.val, 2);
    }


    /**
     * 反转链表
     * @param head
     * @return
     */
    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode r = null;

        while (head != null) {


            ListNode t = r;

            r = head;
            head = head.next;
            r.next = t;
        }

        return r;
    }

    /**
     * 反转链表，递归
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if(head.next == null){
            return head;
        }

        ListNode tailNode = reverseList(head.next);
        // 反正赋值
        head.next.next = head;
        // 清除回环
        head.next =  null;

        return tailNode;
    }



    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
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
