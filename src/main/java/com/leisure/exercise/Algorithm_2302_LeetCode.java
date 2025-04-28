package com.leisure.exercise;

/**
 * ClassName: Algorithm_2302_LeetCode
 * Package: com.leisure.exercise
 * Description:一个数组的 分数 定义为数组之和 乘以 数组的长度。
 * 比方说，[1, 2, 3, 4, 5] 的分数为 (1 + 2 + 3 + 4 + 5) * 5 = 75 。
 * 给你一个正整数数组 nums 和一个整数 k ，请你返回 nums 中分数 严格小于 k 的 非空整数子数组数目。
 * 子数组 是数组中的一个连续元素序列。
 *
 * @Author: MyLeisureLife
 * @Date: 2025/4/28:10:37:40 星期一
 */
public class Algorithm_2302_LeetCode {

    public long countSubarrays(int[] nums, long k) {
        // 答案数量
        long ans = 0;
        // 数组各个数的和
        long sum = 0;
        // 窗口的左边界
        int i = 0;
        // 使用滑动窗口来处理这个问题
        for (int j = 0; j < nums.length; j++){
            sum += nums[j];
            // 当滑动窗口不满足条件时就需要有边界缩小来使满足条件
            while (sum * (j - i + 1) >= k && i<= j){
                // 有边界缩小
                sum = sum - nums[i];
                i ++;

            }
            // 统计满足条件的个数
            ans = j - i + 1 + ans;
        }

        return ans;
    }

    public static void main(String[] args) {
        long l = new Algorithm_2302_LeetCode().countSubarrays(new int[]{5, 2, 6, 8, 9, 7}, 50);
        System.out.println(l);
    }

}
