package datastructure.linkedlist;

import java.util.Stack;

/**
 * @description: 使用链表判断回文,判断是否回文的关键在于中间节点，如果该链表是偶数
 * @date: 2019-04-23 18:55
 * @author: 十一
 */
public class Plalindrome {


    public static void main(String[] args) {
        // 偶数
//        ListNode node5 = new ListNode(0,null);
//        ListNode node4 = new ListNode(1,node5);
//        ListNode node3 = new ListNode(3,node4);
//        ListNode node2 = new ListNode(3,node3);
//        ListNode node1 = new ListNode(1,node2);
//        ListNode root = new ListNode(0,node1);
        // 奇数
        ListNode node4 = new ListNode(1,null);
        ListNode node3 = new ListNode(3,node4);
        ListNode node2 = new ListNode(-2,node3);
        ListNode node1 = new ListNode(3,node2);
        ListNode root = new ListNode(1,node1);
        Plalindrome p = new Plalindrome();
        boolean result = p.isPalindrome(root);
        System.out.println(result);
    }

    public boolean isPalindrome(ListNode root) {

        if(root == null) {
            return true;
        }

        // 使用快慢指针
        ListNode fast = root;
        ListNode slow = root;
        // 使用栈先进后出的特点，相当于反转链表了
        Stack<ListNode> stack = new Stack();
        while (fast != null && fast.next != null) {
           stack.push(slow);
           fast = fast.next.next;
           slow = slow.next;
        }

        // 如果是奇数
        if (fast != null) {
            slow = slow.next;
        }

        while (!stack.isEmpty()) {
            if(stack.pop().val != slow.val) {
                return false;
            }
            slow = slow.next;
        }
        return true;

    }




    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        public ListNode() {
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
