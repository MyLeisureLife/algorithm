package com.leisure.exercise;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: Algorithm_560_LeetCode
 * Package: com.leisure.exercise
 * Description:
 * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。
 * 子数组是数组中元素的连续非空序列。
 * 1 <= nums.length <= 2 * 10^4
 * -1000 <= nums[i] <= 1000
 * -10^7 <= k <= 10^7
 * @Author: MyLeisureLife
 * @Date: 2026/2/11:20:27:12 星期三
 */
public class Algorithm_560_LeetCode {
    /**
     * 时间复杂度O(n * n) 空间复杂度O(1)
     * brute-force algorithm 暴力算法
     * @param nums 数组
     * @param k 子数组和
     * @return 子数组和等于k的个数
     */
    public int subarraySum1(int[] nums, int k) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum == k){
                    ans ++;
                }
            }
        }
        return ans;
    }

    /**
     * Prefix Sum Algorithm 前缀和算法 优化
     * 降低时间复杂度，提升空间复杂度 可以使用Map结构将时间复杂度降低一个层级
     * 时间复杂O(n) 空间复杂度(n)
     *  @param nums 数组
     *  @param k 子数组和
     *  @return 子数组和等于k的个数
     */
    public int subarraySum(int[] nums, int k) {
        int ans = 0, pre = 0;
        // key：前面的和  value：和出现的次数
        Map<Integer, Integer> map = new HashMap<>();
        // 第一个的前面是0，出现次数为1次
        map.put(0, 1);
        for (int num : nums) {
            //0 到 i - 1 的和
            pre += num;
            // pre[i]−pre[j−1]==k -》 pre[j−1]==pre[i]−k
            if (map.containsKey(pre - k)) {
                ans += map.get(pre - k);
            }
            map.put(pre, map.getOrDefault(pre, 0) + 1);
        }
        return ans;
    }

}
