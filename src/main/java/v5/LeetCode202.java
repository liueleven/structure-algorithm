package v5;

import org.junit.Assert;
import org.junit.Test;

/**
 * @description: https://leetcode-cn.com/problems/happy-number/
 *
 * 根据快乐数的定义得知：如果一个数不是快乐数，那么就类似一个循环链表，可以用快慢指针的思想来做了
 *
 * @date: 2021-07-14 22:32
 * @author: liuziqing
 */
public class LeetCode202 {

    @Test
    public void test_true() {

        Assert.assertTrue(isHappy(19));
        Assert.assertFalse(isHappy(202));
    }

    public boolean isHappy(int n) {

        int q = n, p = n;
        do {
            q = getNext(q);
            p = getNext(getNext(p));
        }while (q != 1 && q != p);
        return q == 1;
    }

    public int getNext(int n) {
        int x = 0;
        while (n != 0) {
            int t = (n % 10) * (n % 10);
            n = n / 10;
            x += t;
        }
        return x;
    }

    static class ListNode {
        int val;
        LeetCode142.ListNode next;

        public ListNode(int val, LeetCode142.ListNode next) {
            this.val = val;
            this.next = next;
        }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public LeetCode142.ListNode getNext() {
            return next;
        }

        public void setNext(LeetCode142.ListNode next) {
            this.next = next;
        }
    }
}
