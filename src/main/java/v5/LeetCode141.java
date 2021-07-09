package v5;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * https://leetcode-cn.com/problems/linked-list-cycle/
 *
 * @date: 2021-07-09 01:57
 * @author: liuziqing
 */
public class LeetCode141 {


    @Test
    public void test_false() {
        ListNode n1 = new ListNode(1, null);
        ListNode n2 = new ListNode(2, n1);
        ListNode n3 = new ListNode(3, n2);
        ListNode n4 = new ListNode(4, n3);
        ListNode n5 = new ListNode(5, n4);

        Assert.assertFalse(new LeetCode141().hasCycle(n5));
    }

    @Test
    public void test_true() {
        ListNode n1 = new ListNode(1, null);
        ListNode n2 = new ListNode(2, n1);
        ListNode n3 = new ListNode(3, n2);
        ListNode n4 = new ListNode(4, n3);
        ListNode n5 = new ListNode(5, n4);
        n1.next = n5;

        Assert.assertTrue(new LeetCode141().hasCycle(n5));
    }


    @Test
    public void test2_false() {
        ListNode n1 = new ListNode(1, null);
        ListNode n2 = new ListNode(2, n1);
        ListNode n3 = new ListNode(3, n2);
        ListNode n4 = new ListNode(4, n3);
        ListNode n5 = new ListNode(5, n4);

        Assert.assertFalse(new LeetCode141().hasCycle2(n5));
    }

    @Test
    public void test2_true() {
        ListNode n1 = new ListNode(1, null);
        ListNode n2 = new ListNode(2, n1);
        ListNode n3 = new ListNode(3, n2);
        ListNode n4 = new ListNode(4, n3);
        ListNode n5 = new ListNode(5, n4);
        n1.next = n5;

        Assert.assertTrue(new LeetCode141().hasCycle2(n5));
    }

    /**
     * hashMap
     * @param node
     * @return
     */
    public boolean hasCycle(ListNode node) {
        if (node == null) {
            return false;
        }
        Map<Integer,Integer> map = new HashMap<>();
        while (node != null) {
            if (map.containsKey(node.val)) {
                return true;
            }
            map.put(node.val, node.val);
            node = node.next;
        }
        return false;
    }

    /**
     * 快慢指针
     * @param node
     * @return
     */
    public boolean hasCycle2(ListNode node) {
        if (node == null || node.next == null) {
            return false;
        }
        ListNode q = node.next.next;
        ListNode s = node;

        while (q != null  && q.next != null) {

            System.out.println("s:"+s.val+", q:"+q.val);
            if (q.val == s.val) {
                return true;
            }
            q = q.next.next;
            s = s.next;
        }
        return false;
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
