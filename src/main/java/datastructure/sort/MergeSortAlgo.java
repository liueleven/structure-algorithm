package datastructure.sort;


import java.util.ArrayList;
import java.util.Arrays;

/**
 * 归并算法：
 * 先将一个数组分为2个数组，2个数组排序好，再合并
 *
 * @description: 排序算法2 O(nlogn)
 * @date: 2019-03-01 10:17
 * @author: 十一
 */
public class MergeSortAlgo {

    public static void main(String[] args) {
        int arr[] = new int[10];
        SortAlgo.random(arr,arr.length);
        System.out.println("排序前：" +  Arrays.toString(arr));
        mergeSort(arr,arr.length-1);
        System.out.println("排序后：" +  Arrays.toString(arr));
    }

    /**
     *
     * @param a 要排序的数组
     * @param n 数组的长度
     */
    public static void  mergeSort(int[] a,int n) {
        subMergeSort(a,0,n);
    }

    /**
     * 先将数组不断的拆分
     * @param arr 要排序的数组
     * @param p 该数组起始下标
     * @param r 该数组末尾下标
     */
    public static void subMergeSort(int[] arr,int p,int r) {

        if(p >= r) {
            return;
        }

        // 这里不要使用(m+n)/2,防止超过相加后超过int的最大值
        int q = p + (r-p) / 2;
//        System.out.println("--- q1: " + q);
        subMergeSort(arr,p,q);
//        System.out.println("--- q2: " + q);
        subMergeSort(arr,q+1,r);
        merge(arr,p,q,r);

    }

    /**
     *
     * 关键是这个算法，核心思想：将拆分的数组进行合并
     * @param arr 要排序的数组
     * @param p 要合并的数组一起始下标
     * @param q 要合并的数组一末尾下标
     * @param r 要合并的数组二末尾下标
     */
    public static void merge(int[] arr,int p,int q,int r) {
        // 要合并的数组一起始下标
        int i = p;
        // 要合并的数组二起始下标
        int j = q + 1;
        //
        int k = 0;
        // 开辟新数组,大小为p，r
        int[] tmp = new int[r-p+1];
        // 比较2个数组的大小，小的放入新数组中，并且后移一位
        while (i<=q && j<=r) {
            if(arr[i] <= arr[j]) {
                tmp[k++] = arr[i++];
            }else {
                tmp[k++] = arr[j++];
            }
        }

        // 如果有哪个数组还有剩余的，就全部放到新数组中
        int start = i;
        int end = q;
        if (j <= r) {
            start = j;
            end = r;
        }

        while (start <= end) {
            tmp[k++] = arr[start++];
        }

        // 将tmp中排好序的数组放到arr中
        for (i = 0; i<=r-p; i++) {
            arr[p+i] = tmp[i];
        }
    }
}
