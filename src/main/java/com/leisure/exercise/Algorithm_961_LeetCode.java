package com.leisure.exercise;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: Algorithm_961_LeetCode
 * Package: com.leisure.exercise
 * Description:
 *给你一个整数数组 nums ，该数组具有以下属性：
 * nums.length == 2 * n.
 * nums 包含 n + 1 个 不同的 元素
 * nums 中恰有一个元素重复 n 次
 * 找出并返回重复了 n 次的那个元素。
 *
 * @Author: MyLeisureLife
 * @Date: 2026/1/2:10:16:33 星期五
 */
public class Algorithm_961_LeetCode {
    /**
     * 暴力算法  Brute-force Algorithm
     * 直接遍历整个数组
     * 时间复杂度O(2n) 空间复杂度(n)
     * @param nums 2n长度的数组
     * @return 数组中重复n次的数字
     */
    public int BruteForceRepeatedNTimes(int[] nums) {
        // 创建一个数组存放数组中数字出现的次数
        Map<Integer, Integer> map = new HashMap<>();

        // 遍历nums数组
        for (int num : nums){
            // 坐标位置数据 + 1
            map.put(num, map.getOrDefault(num, 0) + 1);

            // 如果等于n就直接返回
            if (map.get(num) == nums.length / 2) return num;
        }

        return 0;
    }


}
