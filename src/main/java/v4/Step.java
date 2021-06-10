package v4;

import sun.jvm.hotspot.utilities.Assert;

/**
 * @description: 数台阶
 * @date: 2021-06-06 19:30
 * @author: liuziqing
 */
public class Step {

    public static void main(String[] args) {
        Assert.that(climbStairs(2) == 2,"");
        Assert.that(climbStairs(3) == 3,"");
    }

    /**
     * 数台阶，每次走1，2步有几种走法
     * @param n
     * @return
     */
    private static int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }

        return climbStairs(n - 1) + climbStairs(n - 2);
    }
}
