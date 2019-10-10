package v3.leetcode.arr;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @description: 两数之和
 * @date: 2019-10-10 00:26
 * @author: 十一
 */
public class _01TwoSum {


    public static void main(String[] args) {
        int[] arr = {2,7,9,11,3};
        int target = 9;
        int[] ints = m1(arr, target);
        System.out.println("m1: " + Arrays.toString(ints));

        ints = m1(arr, target);
        System.out.println("m2: " + Arrays.toString(ints));
    }

    /**
     * 暴力破解法
     * 时间复杂度：O(n)的平方
     * @param arr
     * @param target
     * @return
     */
    public static int[] m1(int[] arr,int target) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == target) {
                    return new int[]{i,j};
                }
            }

        }
        return null;
    }

    /**
     * 利用map
     * 时间复杂度：O(n)
     * @param arr
     * @param target
     * @return
     */
    public static int[] m2(int[] arr,int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.get(target - arr[i]) != null) {
                return new int[]{i,map.get(target - arr[i])};
            } else {
                map.put(arr[i],i);
            }
        }
        return null;
    }
}
