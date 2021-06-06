package v4.list;

/**
 * @description: 字符串算法
 * @date: 2021-06-06 00:24
 * @author: liuziqing
 */
public class StringTest {

    public static void main(String[] args) {
        // 字符串反转，空间使用为O(1)
        char[] arr = new char[] {'h','e','l','l','o'};
        stringReverse(arr);
        System.out.println(new String(arr));
    }

    private static void stringReverse(char[] arr) {

        helper(0,arr.length-1,arr);
    }

    private static void helper(int start, int end, char[] arr) {
        if (start >= end) {
            return;
        }
        char tmp = arr[start];
        arr[start] = arr[end];
        arr[end] = tmp;

        helper(start+1,end-1,arr);
    }
}
