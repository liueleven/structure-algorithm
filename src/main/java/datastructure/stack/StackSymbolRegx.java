package datastructure.stack;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 使用栈匹配括号[],{},()
 *                  思路：
 *                      从左到右一次入栈，如果到了右括号，就从栈顶取元素，如果不行等就是错的，否则一直遍历
 * @date: 2019-02-22 19:01
 * @author: 十一
 */
public class StackSymbolRegx {

    public static void main(String[] args) {
        ArrayStack<String> stack = new ArrayStack<String>(new String[20]);
        String bracket = "{{[([])]]]";
        Map<String,String> map = new HashMap<String, String>(6);
        map.put("{","}");
        map.put("}","{");
        map.put("(","}");
        map.put(")","(");
        map.put("[","]");
        map.put("]","[");
        String[] brackets = bracket.split("");
        for(int i=0; i<bracket.length(); i++) {
            int idx = ")]}".indexOf(brackets[i]);
            if(idx >= 0) {
                String pop = stack.pop();
                if(!pop.equals(map.get(brackets[i]))) {
                    System.out.println("不匹配下标【 " + i + " 】 错误！");
                }
            }else {
                stack.push(brackets[i]);
            }

        }
    }
}
