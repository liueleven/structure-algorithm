package datastructure.sort;

import javax.sound.midi.Soundbank;
import java.util.Arrays;
import java.util.Random;


/**
 * @description: 排序算法
 * @date: 2019-03-01 10:17
 * @author: 十一
 */
public class SortAlgo {

    public static void main(String[] args) {
//        int[] array = {4,5,6,3,2,1};
        int[] array = new int[100000];
        random(array,100000);
        long s = System.currentTimeMillis();
        // 1.15631  2.15530  3.15137
        bubble(array);
        // 100000   1.1095  2.1078  3.1102
//        insertion(array);
//        100000 1.4350  2.4356  3.4277
//        select(array);
        long e = System.currentTimeMillis();
        System.out.println(e - s);
        System.out.println(Arrays.toString(array));

    }

    public static void random(int[] array,int n) {
        for (int i=0; i<n; i++) {
            array[i] = new Random().nextInt(10);
        }
    }

    /**
     * 冒泡的思想：相邻两个数进行比较，大的往后移动
     * 是稳定的，如果相邻两个数一样，则不变
     * 是原地的，
     * @param array
     * @return
     */
    public static void bubble(int[] array) {
        if(array == null || array.length < 2) {
            return;
        }
        boolean flag = false;
        for (int i=0; i<array.length; i++) {
            for (int k=0; k<array.length-1-i; k++) {
                if(array[k] > array[k+1]) {
                    int tmp = array[k];
                    array[k] = array[k+1];
                    array[k+1] = tmp;
                    flag = true;
                }
            }
//            System.out.println(Arrays.toString(array));
            if(!flag){
                break;
            }
        }
    }

    /**
     * 插入排序思想：分为两个区域一个是已排区域，一个是未排区域，将未排的区域插入已排中合适的位置，已排序区域始终保证是有序
     * @param array 两两之间进行排序，当前值小于上一个值，上一个值代替当前值
     * @return
     */
    public static void insertion(int[] array) {
        if(array == null || array.length < 2) {
            return;
        }

        // 假设第一个是有序的 4,5,6,1,3,2
        for (int i=1; i<array.length; i++) {
            // i=3,current=1
            int current = array[i];
            // pre=2
            int pre = i - 1;

            for (; pre>=0; pre--) {
                // 上一个和当前比较，如果大，上一个替换当前的,不断重复
//                System.out.println("pre:"+array[pre]+"  cur:"+current);
                if (array[pre] > current) {
                    array[pre+1] = array[pre];
                }else {
                    break;
                }
            }
            // 当前的放到上
            array[pre+1] = current;
        }

    }

    /**
     * 选择排序的思想和插入差不多，也是要分成已排序和未排序，每次从未排序中选出最小值放入有序中的末尾
     * @param array
     */
    public static void select(int[] array) {
        if(array == null || array.length < 2) {
            return;
        }
        int len = array.length;

        for (int i=0; i<len; i++) {
            int min = array[i];
            int idx = i;
            for (int j=i; j<len-1; j++) {
                if(min > array[j+1]){
                    min = array[j+1];
                    idx = j+1;
                }
            }
            array[idx] = array[i];
            array[i] = min;
        }

    }
}
