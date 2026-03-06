package com.leisure.exercise;

/**
 * ClassName: Algorithm_1784_LeetCode
 * Package: com.leisure.exercise
 * Description: 1784. 检查二进制字符串字段
 * 给你一个二进制字符串 s ，该字符串 不含前导零 。
 * 如果 s 包含 零个或一个由连续的 '1' 组成的字段 ，返回 true 。否则，返回 false 。
 * 1 <= s.length <= 100
 * s[i] 为 '0' 或 '1'
 * s[0] 为 '1'
 * @Author: MyLeisureLife
 * @Date: 2026/3/6:11:18:25 星期五
 */
public class Algorithm_1784_LeetCode {
    /**
     * Time Complexity: O(n)  Space Complexity: O(n) n: The length of string s
     * @param s Binary string
     * @return Return true if s has at most one contiguous group of '1's.
     */
    public boolean checkOnesSegment(String s) {
        char[] charArray = s.toCharArray();
        int count = 0;
        int pre = 0;
        for (int i = 0; i < s.length(); i++) {
            // 只有前面是0的情况才+1
            if('1' == charArray[i] && pre == 0) {
                count++;
                pre = 1;
            }else if('0' == charArray[i]) {
                pre = 0;
            }
        }
        return count == 1 || count == 0;
    }
    public static void main(String[] args) {
        boolean b = new Algorithm_1784_LeetCode().checkOnesSegment("1111");
        System.out.println(b);
    }
}
