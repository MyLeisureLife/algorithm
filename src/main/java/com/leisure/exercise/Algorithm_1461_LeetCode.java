package com.leisure.exercise;

import java.util.HashSet;
import java.util.Set;

/**
 * ClassName: Algorithm_1461_LeetCode
 * Package: com.leisure.exercise
 * Description:
 *
 * @Author: MyLeisureLife
 * @Date: 2026/2/23:06:33:34 星期一
 */
public class Algorithm_1461_LeetCode {
    /**
     * @param s 二进制字符串
     * @return 所有的二进制位是否全部都在s字符串中
     */
    public boolean hasAllCodes(String s, int k) {
        int number = (int)Math.pow(2,k);
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < number; i++) {
            set.add(i);
        }
        for (int i = 0; i <= s.length() - k; i++) {
            String sub = s.substring(i, i + k);
            // 将二进制字符转化为int
            int subInt = 0;
            for (int j = sub.length() - 1; j >= 0; j--) {
                int last = sub.charAt(j) - '0';
                if (last == 1) {
                    subInt = subInt + (int)Math.pow(2, sub.length() - 1 - j);
                }
            }
            set.remove(subInt);
        }
        return set.isEmpty();
    }

    public static void main(String[] args) {
        boolean b = new Algorithm_1461_LeetCode().hasAllCodes("00110", 2);
        System.out.println(b);
    }
}
