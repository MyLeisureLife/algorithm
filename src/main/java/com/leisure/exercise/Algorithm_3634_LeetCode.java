package com.leisure.exercise;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: Algorithm_3634_LeetCode
 * Package: com.leisure.exercise
 * Description:
 * 给你一个整数数组 nums 和一个整数 k。
 * 如果一个数组的 最大 元素的值 至多 是其 最小 元素的 k 倍，则该数组被称为是 平衡 的。
 * 你可以从 nums 中移除 任意 数量的元素，但不能使其变为 空 数组。
 * 返回为了使剩余数组平衡，需要移除的元素的 最小 数量。
 * 注意：大小为 1 的数组被认为是平衡的，因为其最大值和最小值相等，且条件总是成立。
 * 1 <= nums.length <= 10^5
 * 1 <= nums[i] <= 10^9
 * 1 <= k <= 10^5
 * @Author: MyLeisureLife
 * @Date: 2026/2/6:19:12:23 星期五
 */
public class Algorithm_3634_LeetCode {

    /**
     *  时间复杂度O(n log n) 空间复杂度O(log n)
     * @param nums 数组
     * @param k 倍数
     * @return 去掉最小个数
     */
    public int minRemoval(int[] nums, int k) {
        if (nums.length == 1) return 0;
        // 递增顺序排序
        Arrays.sort(nums);
        // 最少需要去除的个数
        int ans = Integer.MAX_VALUE;
        int count = 0;
        // 条件最小值乘以K被后应该小于等于最大值才行
        for (int i = 0; i < nums.length - 1; i++) {
            // 最大元素允许存在的位置
            int position = getPosition(nums, k, i);
            if (position != i) {
                // 后面就表示找到了,需要移除的个数
                int i1 = i  + nums.length - (position + 1);
                ans = Math.min(ans, i1);
            }
        }

        if ( ans == Integer.MAX_VALUE){
            // 如果当前i没有符合的最大值时,就需要舍去除它以外的全部
            ans = nums.length - 1;
        }
        return ans;
    }

    private static int getMiddle(int[] nums, int k, int i) {
        // 数组中最大允许存在的数
        long  maxNum = (long) nums[i] * k;
        // 在数组中找到小于等于 maxNum 值的位置，使用二分法找到该位置
        int left = i + 1;
        int right = nums.length - 1;
        int middle = 0;
        while (left <= right) {
            // 中间位置
            middle = left + (right - left) / 2;
            // 中间位置大于了最大值，中间位置需要左移动变小
            if ( nums[middle] > maxNum) {
                right = middle - 1;
            // 中间位置需要右移动
            }else {
                left = middle + 1;
            }
        }
        // 得到坐标后需要判断坐标是否正常
        if (nums[middle] <= maxNum) {
            return middle;
        }else if( nums[middle - 1] <= maxNum) {
            return middle - 1;
        }
        return -1;
    }

    private static int getPosition(int[] nums,int k, int i) {
        // 数组中最大允许存在的数
        long  maxNum = (long) nums[i] * k;
        int l = i + 1;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            // 中点左移， 这里是不符合要求的
            if ( nums[mid] > maxNum) {
                r = mid - 1;
            // 中点右移 , 下面是符合要求的，但是需要循环走完才能得到最终的
            }else {
                l = mid + 1;
            }
        }
        return l - 1;
    }

    public static void main(String[] args) {
        int i = new Algorithm_3634_LeetCode().minRemoval(
                new int[]{33,6,19}, 1);
        System.out.println(i);

    }
}
