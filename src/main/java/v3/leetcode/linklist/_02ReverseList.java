package v3.leetcode.linklist;


/**
 * @description: 反转链表 5-4-3-2-1 反转 1-2-3-4-5
 * @date: 2019-10-10 00:38
 * @author: 十一
 */
public class _02ReverseList {

    public static void main(String[] args) {

        Node n5 = Node.getSortNode(5);
        System.out.println("===反转前===");
        Node.printNode(n5);
        Node r = m1(n5);
        System.out.println("===反转后===");
        Node.printNode(r);
    }



    /**
     * 用一个变量来暂存节点
     * 用一个保存反转后的节点
     * @param head
     * @return
     */
    public static Node m1(Node head) {
        Node prev = null;
        while (head != null) {
            // 暂存下一个节点
            Node nextTemp = head.next;

            // 节点数据追加
            head.next = prev;
            prev = head;

            // 把暂存的节点重新赋值给curr
            head = nextTemp;
        }
        return prev;
    }


}
