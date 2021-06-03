package v4.list;

/**
 * @description: 链表有环判断
 * @date: 2021-06-03 00:05
 * @author: liuziqing
 */
public class ListCircle {


    public static void main(String[] args) {

        ListNode listNode = getHasCycle();
        ListNode listNode2 = get2();

        System.out.println(new ListCircle().hasCycle(listNode));
        System.out.println(new ListCircle().hasCycle(listNode2));
    }


    private static ListNode get2() {
        ListNode listNode = new ListNode(1, null);
        ListNode listNode2 = new ListNode(2, listNode);
        ListNode listNode3 = new ListNode(3, listNode2);
        return listNode3;
    }

    private static ListNode getHasCycle() {
        ListNode listNode = new ListNode(1, null);
        ListNode listNode2 = new ListNode(1, listNode);
        ListNode listNode3 = new ListNode(1, listNode2);
        listNode.next = listNode3;
        return listNode3;
    }

    public boolean hasCycle(ListNode node) {
        if (node == null || node.next == null) {
            return false;
        }
        ListNode fast = node.next;
        ListNode slow = node;
        while (fast != null && fast.next != null && slow != null) {
//            if (fast.val == slow.val) {
            if (fast.equals(slow)) {
                return true;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        return false;
    }

    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
