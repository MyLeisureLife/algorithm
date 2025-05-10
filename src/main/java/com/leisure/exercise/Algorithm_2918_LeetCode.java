package com.leisure.exercise;

/**
 * ClassName: Algorithm_2918_LeetCode
 * Package: com.leisure.exercise
 * Description:
 *给你两个由正整数和 0 组成的数组 nums1 和 nums2 。
 * 你必须将两个数组中的 所有 0 替换为 严格 正整数，并且满足两个数组中所有元素的和 相等 。
 * 返回 最小 相等和 ，如果无法使两数组相等，则返回 -1 。
 * @Author: MyLeisureLife
 * @Date: 2025/5/10:10:56:03 星期六
 */
public class Algorithm_2918_LeetCode {
    public long minSum(int[] nums1, int[] nums2) {
        //首先记录 两个数组 的和 是多少  sum1 sum2
        // 同时需要记录 两个数组中0 出现的个数 count1 count2
        long sum1 = 0, sum2 = 0;
        int count1 = 0, count2 = 0;

        for (int j : nums1) {
            sum1 += j;
            if (j == 0) {
                count1++;
            }
        }

        for (int j : nums2) {
            sum2 += j;
            if (j == 0) {
                count2++;
            }
        }

        if (count1 == 0 &&  sum1 < sum2 + count2) {
            return -1;
        }
        if (count2 == 0 &&  sum2 < sum1 + count1) {
            return -1;
        }

        return Math.max((sum1 + count1), (sum2 + count2));
    }
}
