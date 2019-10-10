package v3.leetcode.stack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @description: 括号匹配，【[()]】正确，]][[错误，【】()正确
 * @date: 2019-10-10 08:44
 * @author: 十一
 */
public class _05SymbolMatch {

    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>();
        map.put("(",")");
        map.put("[","]");
        map.put("<",">");
        String arr1 = "([<>])";
        String arr2 = "][<>";
        String arr3 = "()[]<>";
        String arr4 = "[";
        boolean r = m1(arr4,map);
//        boolean r = m2(arr4,map);
        System.out.println("是否匹配：" + r);
    }
    /**
     * 使用栈，匹配元素就从栈pop，否则就push，最后判断栈是否为空，即匹配正确
     * 时间复杂度：O(n),每个元素都遍历一遍
     * 空间复杂度：O(n),每个元素都要入栈
     *
     */
    private static boolean m1(String s,Map<String,String> map) {
        if (s == null) return false;
        if (s.trim().length() == 0) return true;
        String[] arr = s.split("");
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.get(arr[i]) != null) {
                stack.push(arr[i]);
            }else {
                if (!stack.isEmpty() && arr[i].equals(map.get(stack.peek()))) {
                    stack.pop();
                }else {
                    return false;
                }
            }
        }
        return stack.isEmpty();

    }

    /**
     * 两两消除
     * 时间复杂度：O(n^2/2)
     *
     */
    private static boolean m2(String s,Map<String,String> map) {
        if (s == null) return false;
        if (s.trim().length() == 0) return true;
        System.out.println(s);
        while (s.length() > 0) {
            int l1 = s.length();
            s = s.replace("<>","").replace("()","").replace("[]","");
            int l2 = s.length();
            if (l1 == l2) {
                return false;
            }
        }
        return true;
    }
}
