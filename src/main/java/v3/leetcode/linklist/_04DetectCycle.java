package v3.leetcode.linklist;

import java.util.HashSet;
import java.util.Set;

/**
 * @description: 判断链表是否有环
 * @date: 2019-10-10 08:21
 * @author: 十一
 */
public class _04DetectCycle {


    public static void main(String[] args) {
        Node node = Node.getcycleNode();
//        Node node = Node.getSortNode(6);
//        boolean r = m1(node);
//        boolean r = m2(node);
        boolean r = m3(node);
        System.out.println("是否为循环链表：" + r);
    }
    /**
     * 暴力法，给定一个时间，如果还在循序中，说明有环
     */
    private static boolean m1(Node node) {
        long start = System.currentTimeMillis();
        while (node != null) {
            node = node.next;
            if ((System.currentTimeMillis() - start) > 2000) {
                return true;
            }
        }
        return false;

    }

    /**
     * 去重法，使用一个set保存节点，来判断
     */
    private static boolean m2(Node node) {
        Set<Integer> set = new HashSet<Integer>();
        while (node != null) {
           if (set.contains(node.data)) {
               return true;
           }else {
               set.add(node.data);
           }
            node = node.next;
        }
        return false;
    }

    /**
     * 快慢指针，一个快指针走2步，一个慢指针走1步，如果两个相遇了，说明碰上循环了
     */
    private static boolean m3(Node node) {
        Node fast = node;
        Node slow = node;
        while (fast != null && fast.next != null && slow != null) {

            Node f = fast.next.next;
            Node s = slow;
            System.out.println(f.data + "--" + s.data);
            if (f.data.equals(s.data)) {
                return true;
            }
            slow = s.next;
            fast = f.next;
        }
        return false;
    }

}
