package v3.leetcode.linklist;

/**
 * @description: 链表中两两节点交换，1-2-3-4 交换 2-1-4-3
 * @date: 2019-10-10 08:14
 * @author: 十一
 */
public class _03SwapNodeInPairs {

    public static void main(String[] args) {
        Node node = Node.getSortNode(4);
        System.out.println("==before==");
        Node.printNode(node);
        Node n1 = m1(node);
        System.out.println("==after==");
        Node.printNode(n1);
    }


    public static Node m1(Node head) {
        Node r = null;
        while (head != null && head.next != null) {
            // 暂存n-2的节点
            Node tmp = head.next.next;
            // 结果集赋值
            head.next.next = r;
            // head的结果赋值给r
            r = head;
            // 继续下一组交换
            head = tmp;

        }
        return r;
    }







}
