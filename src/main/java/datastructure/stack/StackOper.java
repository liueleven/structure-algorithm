package datastructure.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * @description: 使用栈进行运算操作，思路：
 *                  例如表达式：3+5*8-6
 *                  用两个栈来操作，一个用来存数字，一个用来存运算符
 *                  当遇到数字，我们就直接存入栈，如果是运算符，就和运算符栈的栈顶元素进行比较，
 *                  如果大就入栈，如果小就将前面的全部运算，结果放入数据栈中
 *
 *                  todo 有bug
 * @date: 2019-02-22 14:50
 * @author: 十一
 */
public class StackOper {

    static Map<String,Integer> map = new HashMap<String, Integer>();

    public static void main(String[] args) {

        map.put("/",4);
        map.put("*",4);
        map.put("-",2);
        map.put("+",2);

        ArrayStack<Double> stackNums = new ArrayStack<Double>(new Double[20],0,20);
        ArrayStack<String> stackSymbol = new ArrayStack<String>(new String[20],0,20);
        String express = "3+5*8-6";
//        String express = "3+5*8-6-8/2";
        String[] split = express.split("");
        for(int i=0; i<split.length; i++) {
            if(Pattern.matches("[0-9]",split[i])) {
                stackNums.push(Double.valueOf(split[i]));
            }else {
                Integer newLevel = map.get(split[i]);
                String oldSymbol = stackSymbol.pop();
                Integer oldLevel = map.get(oldSymbol);
                stackSymbol.push(oldSymbol);
                if(oldLevel == null) {
                    stackSymbol.push(split[i]);
                    continue;
                }
                // 如果小就将前面的全部运算，结果放入数据栈中
                if(newLevel < oldLevel) {
                    while (stackNums.getCount() > 1) {

                        String symbol = stackSymbol.pop();
                        if(newLevel >= map.get(symbol)) {
                            stackSymbol.push(symbol);
                            break;
                        }
                        Double pop1 = stackNums.pop();
                        Double pop2 = stackNums.pop();
                        double result = oper(symbol, pop1, pop2);
                        stackNums.push(result);
                    }
                }
                stackSymbol.push(split[i]);
            }
        }

        double result = operStack(stackNums, stackSymbol);
        System.out.println("表达式：" + express + " \n 运算结果：" + result);
    }

    /**
     * 运算
     * @param symbol
     * @param num1
     * @param num2
     * @return
     */
    public static double oper(String symbol,Double num1,Double num2) {
        char[] chars = symbol.toCharArray();
        switch (chars[0]) {
            case '/' : return num1 / num2;
            case '*' : return num1 * num2;
            case '-' : return num1 - num2;
            case '+' : return num1 + num2;
            default: return 0 ;
        }
    }

    /**
     * 对栈内进行运算
     * @return
     */
    public static double operStack(ArrayStack<Double> stackNums,  ArrayStack<String> stackSymbol) {

        while (stackNums.getCount() > 1) {
            Double pop1 = stackNums.pop();
            Double pop2 = stackNums.pop();
            String symbol = stackSymbol.pop();
            double result = oper(symbol, pop2, pop1);
            stackNums.push(result);
        }
        return stackNums.pop();
    }
}
