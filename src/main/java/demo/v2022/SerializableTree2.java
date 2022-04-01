package demo.v2022;


import java.util.*;

/**
 * @description: 序列号有层级关系的数据
 * @date: 2022-03-15 19:59
 * @author: liuziqing
 */
public class SerializableTree2 {
    /**
     * 序列号有层级关系的数据
     * @param args
     */
    public static void main(String[] args) {
        List<String> inputStrList = Arrays.asList("中国", "中国 浙江", "中国 浙江 杭州",
                "中国 浙江 杭州 余杭", "中国 广东", "中国 广东 广州", "中国 广东 广州 白云", "中国 江西");
        Map<String, Node> map = new HashMap<>();
        for (String addr : inputStrList) {
            System.out.println(addr);
            String[] addrArr = addr.split(" ");
            handleStr(addrArr, map);
        }
//        printJson(map);
        for (Map.Entry<String, Node> entry : map.entrySet()) {
            entry.getValue().print();
        }


    }


    private static void handleStr(String[] addrArr, Map<String, Node> map) {
        for (int i = 0; i < addrArr.length; i++) {
            String e = addrArr[i];

            if (map.isEmpty()) {
                map.put(e, new Node(e, null, null, 0));
            } else {
                if (i > 0) {
                    Node pre = findPre(map.get(addrArr[0]), addrArr[i - 1]);
                    append(map.get(addrArr[0]), e, i, pre);
                } else {
                    append(map.get(addrArr[0]), e, i, null);
                }

            }

        }
    }

    private static Node findPre(Node root, String s) {
        while (root.next != null) {
            if (root.data.equals(s)) {
                return root;
            }
            for (Object o : root.next) {
                return findPre((Node) o, s);
            }

        }
        return null;
    }

    private static void append(Node  cur, String e, int level, Node  pre) {
        if (cur == null) {
            return;
        }
        if (cur.data.equals(e)) {
            return;
        }
        if (cur.next != null) {
            if (cur.level == level) {
                return;
            }
            Iterator<Node> iterator = cur.next.iterator();
            while (iterator.hasNext()) {
                Node  node = iterator.next();
                if (node.level == level) {
                    if (!exists(cur.next, e) && pre != null && pre.data.equals(cur.data)) {
                        cur.next.add(new Node (e, null, null, level));
                    }
                    break;
                }
                append(node, e, level, node.pre);

            }
        }
        if (cur.next == null) {
            cur.next = new ArrayList<>();
            cur.next.add(new Node (e, cur, null, level));
        }
    }

    private static boolean exists(List<Node> n, String e) {
        for (Node node : n) {
            if (node.data.equals(e)) {
                return true;
            }
        }
        return false;
    }


    static class Node  {
        private static String l = "{";
        private static String r = "}";


        String data;

        Node pre;

        List<Node> next;

        int level;


        public Node(String data, Node pre, List next, int level) {
            this.data = data;
            this.pre = pre;
            this.next = next;
            this.level = level;
        }

        public void print() {
            StringBuilder s = new StringBuilder();
            doPrint(this, s);
            System.out.println(s.toString());
        }

        private void doPrint(Node root, StringBuilder s) {
            s.append(l);
            s.append(getStr(root.data));
            if (root.next == null) {
                s.append("{}");
                s.append(r);
                return;
            }
            for (int i = 0; i < root.next.size(); i++) {
                Node node = root.next.get(i);
                doPrint(node, s);
                if (root.next.size() > 0 && root.next.size() - 1 != i) {
                    s.append(",");
                }
            }
            s.append(r);
        }

        public String getStr(String s) {
            return "\"" + s + "\":";
        }


    }

}
