package v;

import sun.jvm.hotspot.utilities.Assert;

/**
 * @description: 斐波那契
 * @date: 2021-06-05 15:42
 * @author: liuziqing
 */
public class Test {


    public static void main(String[] args) {
        Assert.that(f1(3) == 2,"error");
        Assert.that(f1(4) == 3,"error");
        Assert.that(f1(6) == 8,"error");

        Assert.that(f2(4) == 3,"error");
    }

    /**
     * 输入下标返回斐波那契的下标值
     * @param i
     * @return
     */
    private static int f2(int i) {
        if (i <= 1) {
            return i;
        }

        return f2(i - 1) + f2(i - 2);
    }

    /**
     * 输入下标返回斐波那契的下标值
     * @param i
     * @return
     */
    private static int f1(int i) {
        if (i < 0) {
            return -1;
        }
        int i1 = 0, i2 = 1;
        while (i > 1) {
            int next = i1 + i2;
            i1 = i2;
            i2 = next;
            i--;
        }

        return i2;
    }

}
