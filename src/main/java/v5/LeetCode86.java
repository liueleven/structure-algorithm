package v5;

import org.junit.Assert;
import org.junit.Test;

/**
 * @description: 86 https://leetcode-cn.com/problems/partition-list/
 *
 * 其实就是遍历比较，用两个链表分别顺序保存大小，最后拼接成一个链表就行了
 *
 * @date: 2021-07-14 22:54
 * @author: liuziqing
 */
public class LeetCode86 {


    @Test
    public void test_true() {
        ListNode n1 = new ListNode(2, null);
        ListNode n2 = new ListNode(5, n1);
        ListNode n3 = new ListNode(2, n2);
        ListNode n4 = new ListNode(4, n3);
        ListNode n5 = new ListNode(1, n4);
        ListNode r = null;

        r = partition(n5, 3);
        Assert.assertEquals(r.val, 1);
        Assert.assertEquals(r.next.val, 2);
        Assert.assertEquals(r.next.next.val, 2);
        Assert.assertEquals(r.next.next.next.val, 4);
        Assert.assertEquals(r.next.next.next.next.val, 5);
    }

    public ListNode partition(ListNode head, int x) {
        if (head == null) {
            return null;
        }
        ListNode big = new ListNode(-1);
        ListNode bigHead = big;
        ListNode small = new ListNode(-1);
        ListNode smallHead = small;

        while (head != null) {

            if (head.val > x) {
                big.next = head;
                big = big.next;
            }else {
                small.next = head;
                small = small.next;
            }
            head = head.next;

        }
        big.next = null;
        small.next = bigHead.next;
        return smallHead.next;
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
