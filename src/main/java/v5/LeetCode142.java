package v5;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * https://leetcode-cn.com/problems/linked-list-cycle-ii/
 * @date: 2021-07-10 06:37
 * @author: liuziqing
 */
public class LeetCode142 {

    @Test
    public void test_false() {
        ListNode n1 = new ListNode(1, null);
        ListNode n2 = new ListNode(2, n1);
        ListNode n3 = new ListNode(3, n2);
        ListNode n4 = new ListNode(4, n3);
        ListNode n5 = new ListNode(5, n4);

        Assert.assertEquals(new LeetCode142().detectCycle(n5), null);
    }

    @Test
    public void test_true() {
        ListNode n1 = new ListNode(1, null);
        ListNode n2 = new ListNode(2, n1);
        ListNode n3 = new ListNode(3, n2);
        ListNode n4 = new ListNode(4, n3);
        ListNode n5 = new ListNode(5, n4);
        n1.next = n5;

        Assert.assertEquals(new LeetCode142().detectCycle(n5).val, n5.val);
    }

    @Test
    public void test2_false() {
        ListNode n1 = new ListNode(1, null);
        ListNode n2 = new ListNode(2, n1);
        ListNode n3 = new ListNode(3, n2);
        ListNode n4 = new ListNode(4, n3);
        ListNode n5 = new ListNode(5, n4);

        Assert.assertEquals(new LeetCode142().detectCycle2(n5), null);
    }

    @Test
    public void test2_true() {
        ListNode n1 = new ListNode(1, null);
        ListNode n2 = new ListNode(2, n1);
        ListNode n3 = new ListNode(3, n2);
        ListNode n4 = new ListNode(4, n3);
        ListNode n5 = new ListNode(5, n4);
        n1.next = n5;

        Assert.assertEquals(new LeetCode142().detectCycle2(n5).val, n5.val);
    }
    /**
     * 快慢指针
     * @param head
     * @return
     */
    public ListNode detectCycle2(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode fast = head.next.next;
        ListNode slow = head.next;
        while (fast != null && fast.next != null) {
            if (fast == slow) {
                ListNode n1 = fast;
                ListNode n2 = head;
                // 由公式推导可知，当快慢指针相遇，那么最初的有环节点=当前节点和起始节点相遇的终点
                while (n1 != n2) {
                    n1 = n1.next;
                    n2 = n2.next;
                }
                return n2;

            }
            fast = fast.next.next;
            slow = slow.next;

        }
        return null;
    }

    /**
     * hashMap
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return head;
        }
        Map<ListNode,Integer> map = new HashMap<>();
        while (head != null) {
            if (map.containsKey(head)) {
                return head;
            }
            map.put(head, head.val);
            head = head.next;
        }
        return null;
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
