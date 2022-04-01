package demo.v2022;


import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description: 序列号有层级关系的数据
 * @date: 2022-03-15 19:59
 * @author: liuziqing
 */
public class SerializableTree {

    public static void main(String[] args) {
        List<String> inputStrList = Arrays.asList("中国", "中国 浙江", "中国 浙江 杭州",
                "中国 浙江 杭州 余杭", "中国 广东");
        Map<String, Node<Node>> map = new HashMap<>();
        for (String addr : inputStrList) {
            String[] addrArr = addr.split(" ");
            handleStr(addrArr, map);
        }

        System.out.println(map.toString());


    }

    //    private static void handleStr(String[] addrArr, Map<String, Node<Node>> map) {
//        for (int i = 0; i < addrArr.length; i++) {
//            String e = addrArr[0];
//            if (map.containsKey(e)) {
//                Node<Node> p = map.get(e);
//                while (p != null) {
//                    if (p.data.equals(addrArr[i])) {
//                        break;
//                    }
//                    System.out.println(p.data);
//                    if (p.next == null) {
////                        p.setNext(new Node(addrArr[i], p, null));
//                        p.next = new Node(addrArr[i], null, null);
//                        return;
//                    }
//                    p = p.next;
//                }
//
//            } else {
//                map.put(e, new Node<>(e, null, null));
//            }
//        }
//    }
    private static void handleStr(String[] addrArr, Map<String, Node<Node>> map) {
        for (int i = 0; i < addrArr.length; i++) {
            String e = addrArr[i];
            if (map.containsKey(e)) {
                Node<Node> p = map.get(e);
                while (p != null) {
                    if (p.data.equals(e)) {
                        break;
                    }
                    System.out.println(p.data);
                    if (p.next == null) {
//                        p.setNext(new Node(addrArr[i], p, null));
                        p.next = new Node(e, p, null);
                        return;
                    }
                    p = p.next;
                }

            } else {
                if (i != 0 && map.containsKey(addrArr[i-1])) {
                    Node<Node> p = map.get(addrArr[i - 1]);
                    Node<Node> node = new Node<>(e, p, null);
                    p.next = node;
                    map.put(e, node);
                } else {
                    map.put(e, new Node<>(e, null, null));
                }

            }
        }
    }


    static class Node<T> {

        public Node(String data, T pre, T next) {
            this.data = data;
            this.pre = pre;
            this.next = next;
        }

        String data;

        T pre;

        T next;

        public String getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }

        public T getPre() {
            return pre;
        }

        public void setPre(T pre) {
            this.pre = pre;
        }

        public T getNext() {
            return next;
        }

        public void setNext(T next) {
            this.next = next;
        }
    }

}
