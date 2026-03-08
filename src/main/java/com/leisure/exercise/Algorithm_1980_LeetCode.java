package com.leisure.exercise;

import java.util.HashSet;
import java.util.Set;

/**
 * ClassName: Algorithm_1980_LeetCode
 * Package: com.leisure.exercise
 * Description:
 *给你一个字符串数组 nums ，该数组由 n 个 互不相同 的二进制字符串组成，
 * 且每个字符串长度都是 n 。请你找出并返回一个长度为 n 且 没有出现 在 nums 中的二进制字符串。
 * 如果存在多种答案，只需返回 任意一个 即可。
 * n == nums.length
 * 1 <= n <= 16
 * nums[i].length == n
 * nums[i] 为 '0' 或 '1'
 * @Author: MyLeisureLife
 * @Date: 2026/3/8:16:11:33 星期日
 */
public class Algorithm_1980_LeetCode {
    /**
     * brute-force algorithm
     * Time complexity: O(n * n)  Space Complexity:O(n)
     * @param nums: Array of binary strings
     * @return Binary strings representing numbers from 0 to 2^n that are not in the nums array.
     */
    public String findDifferentBinaryString(String[] nums) {
        Set<Integer> set = new HashSet<>();
        int n = nums.length;
        for (String num : nums) {
            set.add(Integer.parseInt(num, 2));
        }
        for (int i = 0; i < Math.pow(2, nums.length); i++) {
            if (!set.contains(i)) {
                // 将i变成nums.length 长度的二进制字符串
                StringBuilder sb = new StringBuilder();
                while (sb.length() < n) {
                    int c = i % 2;
                    i >>= 1;
                    sb.append(c);
                }
                return sb.reverse().toString();
            }
        }
        return "";
    }

    public static void main(String[] args) {
        String differentBinaryString = new Algorithm_1980_LeetCode().findDifferentBinaryString(new String[]{
                "01", "10"
        });
        System.out.println(differentBinaryString);


    }
}
