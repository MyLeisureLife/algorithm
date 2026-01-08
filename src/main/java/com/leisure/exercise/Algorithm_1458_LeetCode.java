package com.leisure.exercise;

/**
 * ClassName: Algorithm_1458_LeetCode
 * Package: com.leisure.exercise
 * Description:
 * 给你两个数组 nums1 和 nums2 。
 * 请你返回 nums1 和 nums2 中两个长度相同的 非空 子序列的最大点积。
 * 数组的非空子序列是通过删除原数组中某些元素（可能一个也不删除）后剩余数字组成的序列，
 * 但不能改变数字间相对顺序。比方说，[2,3,5] 是 [1,2,3,4,5] 的一个子序列
 * 而 [1,5,3] 不是。
 * @Author: MyLeisureLife
 * @Date: 2026/1/8:10:58:19 星期四
 */
public class Algorithm_1458_LeetCode {
    /**
     * 动态规划 Dynamic Programming
     * 将问题划分为最优秀子
     * 让后使用二维数组存储这些子
     * 时间复杂度O(nm)，空间复杂度O(nm)
     * @param nums1 数组1
     * @param nums2 数组2
     * @return 子数组最大乘积
     */
    public int maxDotProduct(int[] nums1, int[] nums2) {
        // 创建二维数组
        int [][] dp = new int[nums1.length][nums2.length];
        for (int i = 0; i < nums1.length; i++){
            for (int j = 0; j < nums2.length; j++){
                dp[i][j] = nums1[i] * nums2[j];
                // 当nums2数组长度为1时的特殊情况
                if (i > 0){
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j]);
                }
                // 当nums1数组长度为1时的特殊情况
                if (j > 0){
                    dp[i][j] = Math.max(dp[i][j], dp[i][j - 1]);
                }
                // 当nums1和nums2长度都大于1时,这时我可以选多个
                if(i > 0 && j > 0){
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + nums1[i] * nums2[j]);
                }

            }
        }
        return dp[nums1.length - 1][nums2.length - 1];
    }

    public static void main(String[] args) {
        int i = new Algorithm_1458_LeetCode().maxDotProduct(new int[]{2, 1, -2, 5}, new int[]{3, 0, -6});
        System.out.println(i);

    }
}
