package v4.sort;

import java.util.Arrays;

/**
 * @description: 插入排序
 *
 *
 * @date: 2021-06-06 09:13
 * @author: liuziqing
 */
public class InsertionSort {

    private static int count = 0;
    public static void main(String[] args) {
//        int[] arr = {9,3,2,1,10,6,8,7,5,4};
        int[] arr = {1,88,23,4,52,3,7};
//        insertionSort(arr);
        insertionSort2(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void insertionSort2(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int curVal = arr[i];
            int before = i - 1;
            while (before > 0 && arr[before] > curVal) {
                arr[before+1] = arr[before];
                before--;
            }
            arr[before+1] = curVal;
        }
    }


    /**
     * O(n^2)时间复杂度
     * @param arr
     */
    private static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {

            int curValue = arr[i];
            int j = i -1;
            while (j > 0 && arr[j] > curValue) {
                // 当前的值比前面的值要小，就要将前面的值往后面移1位
                arr[j+1] = arr[j];
                j--;

            }
            arr[j+1] = curValue;
        }
    }


}
