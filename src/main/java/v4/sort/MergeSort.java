package v4.sort;

import java.util.Arrays;

/**
 * @description:
 * 归并排序
 *
 * 时间复杂度：O(nlogn)
 *
 * @date: 2021-06-11 00:43
 * @author: liuziqing
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] arr = {1,4,7,11,88};
        int[] arr2 = {3,6,13,22,52};

        int[] r = merge(arr, arr2, 10);
        System.out.println(Arrays.toString(r));
    }

    private static int[] merge(int[] arr,int[] arr2,int length) {
        int j = 0, k = 0;
        int[] r = new int[length];
        for (int i = 0; i < length; i++) {
            if (arr[j] > arr2[k]) {
                r[i] = arr2[k];
                k++;
            }else {
                r[i] = arr[j];
                j++;
            }
            if (j >= length/2) {
                System.arraycopy(arr2,k,r,j+k,arr2.length-k);

                return r;
            }
            if (k >= length/2) {
                System.arraycopy(arr,j,r,j+k,arr.length-j);
                return r;
            }
        }
        return r;
    }
}
