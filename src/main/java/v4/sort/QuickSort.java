package v4.sort;

import java.util.Arrays;

/**
 * @description: 快排
 *
 * 快速排序，它的基本思想是在一个数组中找到一个 基准值，分别对每个集合排序，来达到整体是有序的
 *
 * 时间复杂度：最优 O(nlogn) 最差 O(n^2)
 * 空间复杂度：最优 O(logn) 最差 O(n)
 *
 *
 * @date: 2021-06-06 09:13
 * @author: liuziqing
 */
public class QuickSort {

    private static int count = 0;
    public static void main(String[] args) {
//        int[] arr = {9,3,2,1,10,6,8,7,5,4};
        int[] arr = {1,88,23,4,52,3,7};
        System.out.println(Arrays.toString(arr));
        quickSort3(arr, 0, arr.length - 1);
//        quickSort2(arr, 0, arr.length - 1);
//        qs2(arr,0,arr.length-1);
//        qs(arr,0,arr.length-1);
//        quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    private static void quickSort3(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int emptyIndex = left;
        int i = left,j = right;
        int key = arr[emptyIndex];
        while (i <j ) {

            while (i < j && arr[j] > key) {
                j--;
            }
            arr[emptyIndex] = arr[j];
            emptyIndex = j;

            while (i < j && arr[i] < key) {
                i++;
            }
            arr[emptyIndex] = arr[i];
            emptyIndex = i;
        }
        count++;
        System.out.println(count);
        arr[emptyIndex] = key;
        quickSort3(arr,left,i-1);
        quickSort3(arr,i+1,right);
    }

    /**
     * 有问题
     * @param arr
     * @param left
     * @param right
     */
    private static void quickSort2(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int emptyIndex = left;
        int key = arr[emptyIndex];
        int i = left;
        int j = right;
        while (i < j) {

            while (i < j && arr[j] > key) {
                j--;
            }
            arr[emptyIndex] = arr[j];
            emptyIndex = j;

            while (i < j && arr[i] < key) {
                i++;
            }
            arr[emptyIndex] = arr[i];
            emptyIndex = i;

        }

        arr[emptyIndex] = key;
        count++;
        System.out.println("count:"+count);
        quickSort2(arr, left+1, right);
        quickSort2(arr, left, right-1);

    }

    private static void qs2(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int emptyIndex = left;
        int i = left;
        int j = right;
        // 基准值
        int key = arr[emptyIndex];
        while (i < j) {
            // 从右边开始找，找到小于基准值的下标
            while (i < j && arr[j] > key) {
                j--;
            }
            if (i < j) {
                arr[emptyIndex] = arr[j];
                emptyIndex = j;
            }

            // 和上面相反
            while (i < j && arr[i] < key) {
                i++;
            }
            if (i < j) {
                arr[emptyIndex] = arr[i];
                emptyIndex = i;
            }
        }
        arr[emptyIndex] = key;
        count++;
        System.out.println("count:"+count);
        qs2(arr,left,i-1);
        qs2(arr,i+1,right);
    }


    private static void quickSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int emptyIndex = right;
        int i = left, j = right;
        // 指定一个基准值
        int key = arr[emptyIndex];
        while (i < j) {
            // 从左开始比较，找出大的值，如果i比基准值大，那就要把i放到右边去
            while (i < j && arr[i] < key) {
                i++;
            }
            if (i < j) {
                arr[emptyIndex] = arr[i];
                emptyIndex = i;
            }

            // 从右开始比较，找出小的值，如果j比基准值小，那就要把i放到左边去
            while (i < j && arr[j] > key) {
                j--;
            }
            if (i < j) {
                arr[emptyIndex] = arr[j];
                emptyIndex = j;
            }
        }
        arr[emptyIndex] = key;
        count ++;
        System.out.println("count: " + count +", i:"+i+", "+", j:"+j+", "+ Arrays.toString(arr));
        quickSort(arr,left,i-1);
        quickSort(arr,i+1,right);
    }


    /**
     *
     * @param arr
     * @param left  左边的下标索引
     * @param right 右边的下标索引
     */
    private static void qs(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int key = arr[left];
        int i = left;
        int j = right;
        int emptyIndex = i;

        while (i < j) {
            //从右边开始找，找到小于基准值的值
            while (i < j && arr[j] >= key) {
                j--;
            }
            if (i < j) {
                arr[emptyIndex] = arr[j];
                emptyIndex = j;
            }

            //从左边开始找，找到大于基准值的值
            while (i < j && arr[i] <= key) {
                i++;
            }
            if (i < j) {
                arr[emptyIndex] = arr[i];
                emptyIndex = i;
            }

        }
        arr[emptyIndex] = key;
        count ++;
        System.out.println("count: " + count +", i:"+i+", "+", j:"+j+", "+ Arrays.toString(arr));
        // 不断的缩小范围，对left,i-1这一部分进行排序
        qs(arr,left, i-1);
        // 不断的缩小范围，对i+1, right这一部分进行排序
        qs(arr,i+1, right);
    }
}
