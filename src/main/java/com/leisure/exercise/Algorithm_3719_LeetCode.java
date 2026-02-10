package com.leisure.exercise;


import java.util.HashSet;
import java.util.Set;

/**
 * ClassName: Algorithm_3719_LeetCode
 * Package: com.leisure.exercise
 * Description:
 * 给你一个整数数组 nums。
 * 如果子数组中 不同偶数 的数量等于 不同奇数 的数量，则称该 子数组 是 平衡的 。
 * 返回 最长 平衡子数组的长度。
 * 子数组 是数组中连续且 非空 的一段元素序列。
 * 1 <= nums.length <= 1500
 * 1 <= nums[i] <= 10^5
 * @Author: MyLeisureLife
 * @Date: 2026/2/10:19:33:17 星期二
 */
public class Algorithm_3719_LeetCode {
    /**
     * brute-force algorithm
     * 时间复杂度O(n^n)  空间复杂度O(n)
     * @param nums 数组
     * @return 最长子字符串
     */
    public int longestBalanced(int[] nums) {
        int ans = 0;
        // 奇数数组
        Set<Integer> odd_number = new HashSet<>();
        // 偶数数组
        Set<Integer> even_number = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            odd_number.clear();
            even_number.clear();
            for (int j = i; j < nums.length; j++) {
                // 如果是奇数
                if(nums[j] % 2 == 1){
                    odd_number.add(nums[j]);
                }else {
                    even_number.add(nums[j]);
                }

                // 平衡了
                if (odd_number.size() == even_number.size()) {
                    ans = Math.max(ans, j - i + 1);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int i = new Algorithm_3719_LeetCode().longestBalanced(
                new int[]{1,2,3,4,5}
        );
        System.out.println(i);
    }
}
