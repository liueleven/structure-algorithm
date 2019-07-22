package datastructure.binary;

import sun.tools.java.BinaryCode;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;

/**
 * @description: 一定要写注释啊
 * @date: 2019-03-14 21:52
 * @author: 十一
 */
public class BinarySearch {

    public static void main(String[] args) {

//        int [] a = {1,3,4,5,6,8,8,8,11,18,};
        int [] a = {1,3,4,5,6,8,8,9,9,11,11,18,};
        int value = 11;
//        int val = bsearch(a, a.length, value);
//        int val = mybsearch(a, a.length, value);
//        int val = mybsearchmax(a, a.length, value);
        int val = mybsearchLastMin(a, a.length, value);
        System.out.println(val);
//        for(int i=0; i<=10; i++){
//            System.out.println(i + "  " + (i>>1));
//        }

    }

    public static int search(int[] a,int n, int val) {
        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if(a[mid] == val) {
                return mid;
            }else if (a[mid] < val) {
                low = mid + 1;
            } else{
                high = mid - 1;
            }
        }

        return -1;
    }

    public static int search2(int[] a,int n, int val) {
        int low = 0;
        int high = n - 1;
        int minIdx = a[a.length];
        while (low <= high) {
            int mid = (low + high) / 2;
            if(a[mid] == val) {
                high = mid;
                if(minIdx > mid) {
                    minIdx = mid;
                }
            }else if (a[mid] < val) {
                low = mid + 1;
            } else{
                high = mid - 1;
            }
        }

        return minIdx;
    }

    /**
     * 这个算法是查询在一组有序的数组中，找到某个值最先出现的下标
     * 思想：利用二分法，每次比较区间是上次的一半；
     * 唯一要处理的是判断当前下标是不是第一次出现的？
     * 这个也很好解决，因为是有序的，如果某次二分找到了这个value，但是又不确定是不是第一次出现，只要拿这个下标减1再比较即可
     * 如果比较的结果是不等于的，那就是了，否则说明还不是第一次出现的值
     * 同理，找到一个有序数组中某个值最后一次出现的位置也类似
     * @param a
     * @param n
     * @param value
     * @return
     */
    public static int bsearch(int [] a, int n, int value) {
        int count = 1;
        int low = 0;
        // high = 数组的长度 - 1；
        int high = n - 1;
        // 如果 low <= high，不断比较
        while (low <= high) {
            // mid = 0 + (10 - 0) >> 1) 每次右移动相当于除2 mid = 5
            int mid = low + ((high - low) >> 1);
            System.out.println("count: " + count + "\t low: " + low + "\t high: " + high + "\t mid: " + mid + "\t value: " + value);
            if(a[mid] > value){
                // 如果中值 > value，因为是有序的，所以比较区间变为[0,arr.length/2]，high值变小
                high = mid - 1;
            } else if (a[mid] < value) {
                // 如果中值 < value，因为是有序的，所以比较区间变为[arr.length/2,arr.length],low值变大
                low = mid + 1;
            } else {
                // 如果中值 = value，但是我们要取的是第一次出现的value值，所以中值前面的一个值是不是等于value，如果
                // 是的话，说明value在中值前面，需要再次比较
                if((mid == 0) || (a[mid - 1]) != value) {
                    return mid;
                } else {
                    // 说明value在中值前面，需要再次比较，缩小比较范围，[arr.length/2,mid]
                    high = mid - 1;
                }
            }
            count ++;
        }
        return -1;
    }

    public static int mybsearch(int [] a, int n, int value) {
        int low = 0;
        int hight = n - 1;
        while (low <= hight) {
            int mid = low + ((hight - low) >> 1);
            if(a[mid] > value) {
                hight = mid - 1;
            }else if(a[mid] < value) {
                low = mid + 1;
            }else {
                if((mid == n-1) || a[mid + 1] != value) {
                    return mid;
                }else {
                    low = mid + 1;
                }
            }
        }
        return -1;
    }

    public static int mybsearchmax(int [] a, int n, int value) {
        int low = 0;
        int hight = n - 1;
        while (low <= hight) {
            int mid = low + ((hight - low) >> 1);

            if(a[mid] > value) {
                if(a[mid - 1] <= value) {
                    System.out.println("idx: " + mid + "\tval: " + a[mid]);
                    return mid;
                }
                hight = mid;

            }else  {
                low = mid + 1;
            }

        }
        return -1;
    }

    /**
     * 最后一个小于等于给定值的元素
     * @param a
     * @param n
     * @param value
     * @return
     */
    public static int mybsearchLastMin(int [] a, int n, int value) {
        int low = 0;
        int hight = n - 1;
        int count = 1;
        while (low <= hight) {
            int mid = low + ((hight - low) >> 1);
            System.out.println("count: " + count + "\t low: " + low + "\t high: " + hight + "\t mid: " + mid + "\t value: " + value);
            if(a[mid] > value) {
                hight = mid - 1;

            }else if(a[mid] < value){

                low = mid + 1;
            }
            else {
                if(a[mid - 1] <= value) {
                    System.out.println("idx: " + mid + "\tval: " + a[mid]);
                    return mid;
                }else {
                    low = mid + 1;
                }
            }

            count ++;
        }
        return -1;
    }




}
