package v5;

import org.junit.Assert;
import org.junit.Test;

/**
 * @description:
 *
 * 25. K 个一组翻转链表
 *
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 *
 * k 是一个正整数，它的值小于或等于链表的长度。
 *
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-nodes-in-k-group
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date: 2021-07-25 17:25
 * @author: liuziqing
 */
public class LeetCode25 {


    @Test
    public void test_true() {
        ListNode n1 = new ListNode(1, null);
        ListNode n2 = new ListNode(2, n1);
        ListNode n3 = new ListNode(3, n2);
        ListNode n4 = new ListNode(4, n3);
        ListNode n5 = new ListNode(5, n4);

        ListNode r = reverseKGroup(n5,2);
        Assert.assertEquals(r.val, 4);
        Assert.assertEquals(r.next.val, 5);
        Assert.assertEquals(r.next.next.val, 2);
        Assert.assertEquals(r.next.next.next.val, 3);
        Assert.assertEquals(r.next.next.next.next.val, 1);

    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1, head);
        ListNode pre = dummy;
        // 待翻转链表尾部节点
        ListNode tail = null;

        while (head != null) {
            tail = pre;
            for (int i = 0; i < k; i++) {
                tail = tail.next;
                // 不足k个节点了，直接返回
                if (tail == null) {
                    return dummy.next;
                }

            }
            ListNode[] revers = revers(head, tail);
            head = revers[0];
            tail = revers[1];
            pre.next = head;
            pre = tail;
            head = pre.next;
        }
        return dummy.next;
    }

    private ListNode[] revers(ListNode head, ListNode tail) {
        ListNode pre = tail.next;
        ListNode cur = head;
        ListNode next = null;
        while (pre != tail) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return new ListNode[] {tail, head};
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
