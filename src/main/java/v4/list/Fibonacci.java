package v4.list;

import datastructure.TimeUtil;
import sun.jvm.hotspot.utilities.Assert;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: Fibonacci
 * @date: 2021-06-06 07:11
 * @author: liuziqing
 */
public class Fibonacci {

    private static Map<Integer,Integer> indexCacheOfVal = new HashMap<>();
    public static void main(String[] args) {
        Assert.that(recursionWithCache(3) == 2,"error");
        Assert.that(recursionWithCache(4) == 3,"error");
        Assert.that(recursionWithCache(6) == 8,"error");
        TimeUtil.execute("recursionWithCache", new TimeUtil.Task() {
            @Override
            public void execute() {
                System.out.println(recursionWithCache(45));
            }
        });
        TimeUtil.execute("recursion", new TimeUtil.Task() {
            @Override
            public void execute() {
                System.out.println(recursion(45));
            }
        });

    }

    /**
     * 输入下标返回斐波那契的下标值
     * @param i
     * @return
     */
    private static int recursion(int i) {
        if (i <= 1) {
            return i;
        }

        return recursion(i - 1) + recursion(i - 2);
    }

    /**
     * 递归,缓存已经计算过的值
     * 斐波那契，输入下标，返回对应的下标值
     * @param i
     * @return
     */
    private static int recursionWithCache(int i) {
        if (i <= 1) {
            return i;
        }
        if (indexCacheOfVal.containsKey(i)) {
            return indexCacheOfVal.get(i);
        }
        int v = recursionWithCache(i-1) + recursionWithCache(i-2);
        if (!indexCacheOfVal.containsKey(i)) {
            indexCacheOfVal.put(Integer.valueOf(i),v);

        }
        return v;
    }
}
