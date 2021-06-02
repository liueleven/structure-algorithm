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
        int[] arr = {2951,1,2,3,4,5,6,7,2049};
//        int[] arr = {2, 7, 9, 11, 3};
//        int[] arr = {12, 2, 2, 11, 3};
        int target = 5000;
//        int[] ints = m1(arr, target);
//        System.out.println("m1: " + Arrays.toString(ints));

//        ints = m1(arr, target);
//        System.out.println("m2: " + Arrays.toString(ints));
        int[] ints = m3(arr, target);
        System.out.println(Arrays.toString(ints));
    }

    /**
     * 暴力破解法
     * 时间复杂度：O(n)的平方
     *
     * @param arr
     * @param target
     * @return
     */
    public static int[] m1(int[] arr, int target) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == target) {
                    return new int[]{i, j};
                }
            }

        }
        return new int[]{};
    }

    /**
     * 利用map
     * 时间复杂度：O(n)
     *
     * @param arr
     * @param target
     * @return
     */
    public static int[] m2(int[] arr, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.get(target - arr[i]) != null) {
                return new int[]{i, map.get(target - arr[i])};
            } else {
                map.put(arr[i], i);
            }
        }
        return new int[]{};
    }

    /**
     * 思路：一个数 & 上一个数 ，例如 A&B，只要B大于A，就不会重复（0是特殊情况）
     * @param nums
     * @param target
     * @return
     */
    public static int[] m3(int[] nums, int target) {
        // 这个值一定要比数组最大的值要大
        int n = 2951;
        int[] map = new int[n];
        int max = n - 1;
        for (int i = 0; i < nums.length; i++) {
            int b = map[(target - nums[i]) & max];
            if (b != 0) {
                return new int[]{b - 1, i};
            }
            map[nums[i] & max] = i + 1;
        }
        return null;
    }




}
