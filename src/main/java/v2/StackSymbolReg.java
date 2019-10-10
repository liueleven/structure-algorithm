package v2;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 栈匹配括号是否是对称
 * @date: 2019-08-05 23:13
 * @author: 十一
 */
public class StackSymbolReg {

    private static String symbol = "{{{{{【}】}}}}";
    public static void main(String[] args) {
        if (symbol.length()%2 != 0) {
            throw new RuntimeException("匹配符号不能为单数");
        }
        LArrayStack<String> stack = new LArrayStack<String>(new String[symbol.length()]);
        String[] strings = symbol.split("");
        Map<String,String> map = new HashMap<>();
        map.put("{","}");
        map.put("[","]");
        map.put("【","】");
        for (int i = 0; i < strings.length; i++) {
            if (map.get(strings[i]) != null) {
                stack.push(strings[i]);
            }else {
                String e = stack.pop();
                if (!map.get(e).equals(strings[i])) {
                    int min = symbol.length() - i;
                    System.out.println("第 " + min + " 和第 " + (i+1) + " 个有错误！");
                    System.out.println(symbol);
                    break;
                }

            }
        }
        System.out.println("perfect!");
    }
}
