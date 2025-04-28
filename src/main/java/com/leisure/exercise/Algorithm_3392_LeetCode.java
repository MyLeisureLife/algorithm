package com.leisure.exercise;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: Algorithm_3392_LeetCode
 * Package: com.leisure.exercise
 * Description:给你一个整数数组 nums ，请你返回长度为 3 的 子数组 的数量，满足第一个数和第三个数的和恰好为第二个数的一半。
 * 子数组 指的是一个数组中连续 非空 的元素序列。
 *输入：nums = [1,2,1,4,1]
 * 输出：1
 * 解释：
 * 只有子数组 [1,4,1] 包含 3 个元素且第一个和第三个数字之和是中间数字的一半。number.
 * @Author: MyLeisureLife
 * @Date: 2025/4/27:17:52:39 星期日
 */
public class Algorithm_3392_LeetCode {
    public int countSubarrays(int[] nums) {
        int ans = 0;
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] * 1.0  / 2 == nums[i - 1] + nums[i + 1]) {
                ans ++;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(1, 1);
        System.out.println(map.get(1) + 1);
    }
}
