package datastructure.sort;


import java.util.Arrays;

/**
 * @description: 快速排序
 * 也用到分治思想，从一个数组中随便取一个值叫做分区点pivot，比这个分区点小的就放左边，大的放右边数组;
 * @date: 2019-03-13 15:30
 * @author: 十一
 */
public class QuickSort {

    public static void main(String[] args) {
        int arr[] = {11,8,3,9,7,1,2,5};
        System.out.println("排序前：" +  Arrays.toString(arr));
        sort(arr,0,arr.length-1);
        System.out.println("排序后：" +  Arrays.toString(arr));
    }

    public static void sort(int[] arr,int p, int r) {
        System.out.println("p: " + p + "  r: " + r  );
        if (p >= r) {
            return;
        }
        int q = partition(arr,p,r);
        System.out.println("q: "+q);
        sort(arr,p,q-1);
        sort(arr,q+1,r);
    }

    /**
     * 核心：原地分区算法
     * @param arr 要排序的数组
     * @param p
     * @param r
     * @return
     */
    private static int partition(int[] arr, int p, int r) {
        // 最后一个为分区点
        int pivot = arr[r];
        // 从这个下标p开始比较
        int i = p;
        for(int j=p; j<r; j++) {
            // 如果该元素比分区点小
            if(arr[j] < pivot) {
                // 如果相等就后移
                if (i == j) {
                    ++i;
                }else {
                    // 否则，换位置
                    int tmp = arr[i];
                    arr[i++] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
        System.out.println("---" + Arrays.toString(arr));
        int tmp = arr[i];
        arr[i] = arr[r];
        arr[r] = tmp;
        System.out.println("===" + Arrays.toString(arr));
        return i;
    }

}
