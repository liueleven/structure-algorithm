//package demo.v2022;
//
//import java.util.*;
//
//
///**
// * @description: 刘子清是个大傻逼
// * @date: 2022-03-13 11:05
// * @author: liuziqing
// */
//public class HashMapTest {
//
//    static final int MAXIMUM_CAPACITY = 1 << 30;
//
//
//    public static void main(String[] args) {
//        String s = "pwwkew";
//        int left = 0;
//        int max = 0;
//        Map<Character, Integer> map = new HashMap<>();
//        for (int i = 0; i < s.length(); i++) {
//            if (map.containsKey(s.charAt(i))) {
//                map.put(s.charAt(i), left);
//            }
//
//        }
//        System.out.println(queue.size());
//    }
//
//    static int tableSizeFor(int cap) {
//        int n = cap - 1;
//        n |= n >>> 1;
//        n |= n >>> 2;
//        n |= n >>> 4;
//        n |= n >>> 8;
//        n |= n >>> 16;
//        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
//    }
//}
