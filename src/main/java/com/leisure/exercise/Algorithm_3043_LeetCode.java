package com.leisure.exercise;

import java.util.HashSet;
import java.util.Set;

/**
 * ClassName: Algorithm_3043_LeetCode
 * Package: com.leisure.exercise
 * Description: 3043. 最长公共前缀的长度
 *
 * @Author: MyLeisureLife
 * @Date: 2026/5/21:16:57:18 星期四
 */
public class Algorithm_3043_LeetCode {
    /**
     * 时间复杂度太高了
     * @param arr1 数组1
     * @param arr2 数组2
     * @return 最长相同前缀
     */
    public int longestCommonPrefix1(int[] arr1, int[] arr2) {
        int ans = 0;
        for (int j : arr1) {
            for (int value : arr2) {
                String a = String.valueOf(j);
                String b = String.valueOf(value);
                int len = Math.min(a.length(), b.length());
                int num = 0;
                for (int k = 0; k < len; k++) {
                    if (a.charAt(k) == b.charAt(k)) {
                        num++;
                    } else {
                        break;
                    }
                }
                ans = Math.max(ans, num);
            }
        }
        return ans;
    }

    /**
     * O(n + m)
     * @param arr1 数组1
     * @param arr2 数组2
     * @return 最长相同前缀
     */
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        int ans = 0;
        Set<String> set = new HashSet<>();
        for (int k : arr1) {
            String s = String.valueOf(k);
            for (int j = 1; j < s.length(); j++) {
                String str = s.substring(0, j);
                set.add(str);
            }
        }
        for (int j : arr2) {
            String s = String.valueOf(j);
            for (int i = 1; i < s.length(); i++) {
                String str = s.substring(0, i);
                if (set.contains(str)) {
                    ans = Math.max(ans, i);
                }else {
                    break;
                }
            }
        }
        return ans;
    }

        public static void main(String[] args) {
        int i = new Algorithm_3043_LeetCode().longestCommonPrefix(new int[]{1, 10, 100}, new int[]{1000});
        System.out.println(i);
    }
}
