package datastructure.recursion;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 假如这里有 n 个台阶，每次你可以跨 1 个台阶或者 2 个台阶，请问走这 n 个台阶有多少种走法？
 *              如果有 7 个台阶，你可以 2，2，2，1 这样子上去，也可以 1，2，1，1，2
 *
 *              要写出递归公式，和临界点
 *              f(1) = 1;
 *              f(2) = 2;
 *              f(n) = f(n-1)+f(n-2);
 * @date: 2019-02-28 17:27
 * @author: 十一
 */
public class Sidestep {

    public static Map<Integer,Integer> map = new HashMap<Integer,Integer>();
    public static int depth = 0;


    public static void main(String[] args) throws Exception{
//        System.out.println(func(3));
//        System.out.println(func(4));
        System.out.println(func(5));
    }

    // 有重复代码
//    public static int func(int num) {
//        if(num == 1) {
//            return 1;
//        }
//        if(num == 2) {
//            return 2;
//        }
//
//        return func(num - 1) + func(num - 2);
//
//    }

    // 有堆栈溢出风险
//    public static int func(int num) {
//        if(num == 1) {
//            return 1;
//        }
//        if(num == 2) {
//            return 2;
//        }
//        if(map.containsKey(num)) {
//            return map.get(num);
//        }
//
//        int ret =  func(num - 1) + func(num - 2);
//        map.put(num,ret);
//        return ret;
//
//    }

//    public static int func(int num) throws Exception {
//        depth += 1;
//        // 通过一个flag来判断深度
//        if(depth > 10) {
//            throw new Exception("溢出！");
//        }
//        if(num == 1) {
//            return 1;
//        }
//        if(num == 2) {
//            return 2;
//        }
//        if(map.containsKey(num)) {
//            return map.get(num);
//        }
//
//        int ret =  func(num - 1) + func(num - 2);
//        map.put(num,ret);
//        return ret;
//
//    }

    // 递归有内存风险，使用迭代
    public static int func(int num) {
        if(num == 1) {
            return 1;
        }
        if(num == 2) {
            return 2;
        }

        int ret = 0;
        int pre = 2;
        int prepre = 1;
        for (int i=3; i<=num; i++) {
            System.out.println("ret:"+ret+"  pre:"+pre+"   prepre:"+prepre);
            ret = pre + prepre;
            prepre = pre;
            pre = ret;
        }
        return ret;
    }

}
