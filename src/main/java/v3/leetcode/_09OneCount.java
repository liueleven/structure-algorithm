package v3.leetcode;

/**
 * @description: 位1的个数
 * @date: 2019-10-12 12:55
 * @author: 十一
 */
public class _09OneCount {

    public static void main(String[] args) {
        _09OneCount oneCount = new _09OneCount();
        System.out.println(oneCount.hammingWeight(8));
        System.out.println(oneCount.hammingWeight(1));
        System.out.println(oneCount.hammingWeight(2));
        System.out.println(oneCount.hammingWeight(3));
    }

    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0){
            n = n & (n-1);
            count ++;
        }
        return count;
    }
}
