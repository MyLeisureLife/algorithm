package com.leisure.exercise;

import com.mysql.jdbc.MiniAdmin;

import java.util.Arrays;

/**
 * ClassName: Algorithm_3689_LeetCode
 * Package: com.leisure.exercise
 * Description:3689. 最大子数组总值 I
 *
 * @Author: MyLeisureLife
 * @Date: 2026/6/9:13:12:01 星期二
 */
public class Algorithm_3689_LeetCode {

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * @param nums 数组
     * @param k 子数组数量
     * @return 子数组最大最小值差值和
     */
    public long maxTotalValue(int[] nums, int k) {
        int m1 = Integer.MAX_VALUE, m2 = Integer.MIN_VALUE;
        for (int x : nums) {
            m1 = Math.min(m1, x);
            m2 = Math.max(m2, x);
        }
        return (long)(m2 - m1) * k;
    }

    public static void main(String[] args) {
        Algorithm_3689_LeetCode algorithm3689LeetCode = new Algorithm_3689_LeetCode();
        long l = algorithm3689LeetCode.maxTotalValue(new int[]{4, 2, 5, 1}, 3);
        System.out.println(l);

    }

}