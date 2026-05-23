package com.leisure.exercise;

/**
 * ClassName: Algorithm_1752_LeetCode
 * Package: com.leisure.exercise
 * Description: 1752. 检查数组是否经排序和轮转得到
 * 1 <= nums.length <= 100
 * 1 <= nums[i] <= 100
 * @Author: MyLeisureLife
 * @Date: 2026/5/23:11:16:12 星期六
 */
public class Algorithm_1752_LeetCode {
        public boolean check(int[] nums) {
            int n = nums.length, x = 0;
            for (int i = 1; i < n; ++i) {
                if (nums[i] < nums[i - 1]) {
                    x = i;
                    break;
                }
            }
            if (x == 0) {
                return true;
            }
            for (int i = x + 1; i < n; ++i) {
                if (nums[i] < nums[i - 1]) {
                    return false;
                }
            }
            return nums[0] >= nums[n - 1];
        }

}
