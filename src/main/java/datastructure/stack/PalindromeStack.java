package datastructure.stack;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @description: 最大回文子串
 * @date: 2019-07-23 09:37
 * @author: 十一
 */
public class PalindromeStack {

    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            System.out.println(String.format("i: %s, s:%s",i,s));
            int len1 = expandAroundCenter(s, i, i);

            System.out.println(String.format("len1: %s, i:%s ",len1,i));
            int len2 = expandAroundCenter(s, i, i + 1);
            System.out.println(String.format("len2: %s, i:%s ",len2,i));
            int len = Math.max(len1, len2);
            System.out.println(String.format("len: %s",len));
            System.out.println(String.format("start: %s, end: %s",start,end));
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
            System.out.println(String.format("start: %s, end: %s",start,end));
            System.out.println("-----------");
        }
        return s.substring(start, end + 1);
    }

    // abccbaaabb
    private int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        System.out.println(String.format("L: %s, R:%s",L,R));
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }

    public static void main(String[] args) {
        PalindromeStack palindromeStac = new PalindromeStack();
        String str = "aaabccba";
        System.out.println(palindromeStac.longestPalindrome(str));
    }

}
