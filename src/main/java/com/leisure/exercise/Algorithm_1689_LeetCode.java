package com.leisure.exercise;

/**
 * ClassName: Algorithm_1689_LeetCode
 * Package: com.leisure.exercise
 * Description:
 * 如果一个十进制数字不含任何前导零，且每一位上的数字不是 0 就是 1 ，那么该数字就是一个 十-二进制数 。例如，101 和 1100 都是 十-二进制数，而 112 和 3001 不是。
 * 给你一个表示十进制整数的字符串 n ，返回和为 n 的 十-二进制数 的最少数目。
 * @Author: MyLeisureLife
 * @Date: 2026/3/1:21:02:39 星期日
 */
public class Algorithm_1689_LeetCode {
    public int minPartitions(String n) {
        int ans = 0;
        for (int i = 0; i < n.length(); i++) {
            ans = Math.max(ans, n.charAt(i) - '0');
        }
        return ans;
    }
}
