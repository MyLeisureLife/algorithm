package com.leisure.exercise;

/**
 * ClassName: Algorithm_1920_LeetCode
 * Package: com.leisure.exercise
 * Description:
 *给你一个 从 0 开始的排列 nums（下标也从 0 开始）。请你构建一个 同样长度 的数组 ans ，其中，对于每个 i（0 <= i < nums.length），都满足 ans[i] = nums[nums[i]] 。返回构建好的数组 ans 。
 * 从 0 开始的排列 nums 是一个由 0 到 nums.length - 1（0 和 nums.length - 1 也包含在内）的不同整数组成的数组。
 * @Author: MyLeisureLife
 * @Date: 2025/5/6:10:22:18 星期二
 */
public class Algorithm_1920_LeetCode {

    /**
     * 时间复杂度 为0(n) 空间复杂度为0(n)
     * @param nums 数据
     * @return 结果
     */
    public int[] buildArrayOne(int[] nums) {
        int[] ans = new int[nums.length];

        for (int i = 0; i < nums.length; i++){
            ans[i] = nums[nums[i]];
        }

        return ans;
    }
//
//    /**
//     * 需要控制空间复杂度到O(1)
//     * nums 中的元素 互不相同
//     * @param nums 数据
//     * @return 结果
//     */
//    public int[] buildArray(int[] nums) {
//
//        for (int i = 0; i < nums.length; i++){
//            int ans = nums[0];
//            if (ans <  0){ continue;}
//
//        }
//
//        if (nums.length == 1) return nums;
//        while () {
//
//        }
//        for (int i = 0; i < nums.length; i++){
//            ans[i] = nums[nums[i]];
//        }
//
//        return nums;
//    }
}
