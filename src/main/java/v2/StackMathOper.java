package v2;

import datastructure.stack.ArrayStack;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * @description: 四则运算,思想是一个栈用来存操作符，一个用栈来存数字，操作符的那个栈
 * 无论如何都要保证栈顶的运算符优先级大于栈底的运算符
 * @date: 2019-08-06 12:57
 * @author: 十一
 */
public class StackMathOper {

    static Map<String,Integer> symbolMap = new HashMap();

    static ArrayStack<String> symbolStack = new ArrayStack<String>(new String[20]);
    static ArrayStack<Double> numStack = new ArrayStack<Double>(new Double[20]);

    public static void main(String[] args) {
        String express = "2/2+8-5*2/2";
        init();
        String[] strings = express.split("");
        for (int i = 0; i < strings.length; i++) {
            if(Pattern.matches("[0-9]",strings[i])) {
                if (symbolStack.peek() == null) {
                    numStack.push(Double.valueOf(strings[i]));
                    continue;
                }
                String s1 = symbolStack.pop();
                if (symbolStack.peek() == null) {
                    symbolStack.push(s1);
                    numStack.push(Double.valueOf(strings[i]));
                    continue;
                }
                numStack.push(Double.valueOf(strings[i]));
                // 2个符号以上就要比较优先级
                String s2 = symbolStack.pop();
                Integer upLevel = symbolMap.get(s1);
                Integer downLevel = symbolMap.get(s2);

                if (upLevel >=  downLevel) {
                    Double p1 = numStack.pop();
                    Double p2 = numStack.pop();
                    double v = calcResult(s1, p2, p1);
                    numStack.push(v);
                    symbolStack.push(s2);
                }else {

                    Double p1 = numStack.pop();
                    Double p2 = numStack.pop();
                    Double p3 = numStack.pop();
                    double v = calcResult(s2, p3, p2);
                    numStack.push(v);
                    numStack.push(p1);
                    symbolStack.push(s1);
                }



            }else {
                symbolStack.push(strings[i]);
            }
        }
        printResult();
        System.out.println(String.format("%s 结果：%s",express,numStack.pop()));

    }

   
    private static void printResult() {
        while (symbolStack.peek() != null) {
            String p1 = symbolStack.pop();
            Double n1 = numStack.pop();
            Double n2 = numStack.pop();
            double v = calcResult(p1, n2, n1);
            numStack.push(v);
        }
    }


    private static double calcResult(String symbol, double num1, double num2) {
        switch (symbol) {
            case "+" : return num1 + num2;
            case "-" : return num1 - num2;
            case "*" : return num1 * num2;
            case "/" : return num1 / num2;
            default:  throw new RuntimeException(" symbol not exist!");

        }
    }


    public static void init() {
        symbolMap.put("+",0);
        symbolMap.put("-",0);
        symbolMap.put("*",1);
        symbolMap.put("/",1);
    }
}
