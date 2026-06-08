package com.leisure.exercise;

import java.util.Arrays;

/**
 * ClassName: Algorithm_2161_LeetCode
 * Package: com.leisure.exercise
 * Description:2161. 根据给定数字划分数组
 *
 * @Author: MyLeisureLife
 * @Date: 2026/6/8:19:21:24 星期一
 */
public class Algorithm_2161_LeetCode {
    /**
     * Time Complexity: O(n)  Space Complexity: O(n)
     * pivot 一定在nums数组中
     * @param nums 数组
     * @param pivot 支点
     * @return 排序后的数组
     */
    public int[] pivotArray(int[] nums, int pivot) {
        int[] res = new int[nums.length];
        Arrays.fill(res, pivot);
        // 统计大于pivot的个数
        int c = 0;
        for (int num : nums) {
            if (num > pivot) {
                c++;
            }
        }
        // 统计当前跳过了多少个位置， i - c1是数据真实填入位置避免跳过位置
        int c1 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == pivot) {
                c1 ++;
            }else if (nums[i] < pivot) {
                res[i - c1] = nums[i];
            }else if (nums[i] > pivot) {
                res[nums.length - c] = nums[i];
                c --;
                c1 ++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] ints = new Algorithm_2161_LeetCode().pivotArray(new int[]{10,2,10,1,10,3}, 10);
        System.out.println(Arrays.toString(ints));

    }
}
