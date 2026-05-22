package com.leisure.exercise;

/**
 * ClassName: Algorithm_33_LeetCode
 * Package: com.leisure.exercise
 * Description:33. 搜索旋转排序数组
 * 1 <= nums.length <= 5000
 * -10^4 <= nums[i] <= 10^4
 * nums 中的每个值都 独一无二
 * 题目数据保证 nums 在预先未知的某个下标上进行了旋转
 * -10^4 <= target <= 10^4
 * @Author: MyLeisureLife
 * @Date: 2026/5/22:18:43:07 星期五
 */
public class Algorithm_33_LeetCode {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target){
                return mid;
            }
            if (nums[0] <= nums[mid]){
                if (nums[0] <= target && target < nums[mid]){
                    right = mid - 1;
                }else {
                    left = mid + 1;

                }
            }else {
                if (nums[mid] < target && target <= nums[nums.length - 1]){
                    left = mid + 1;
                }else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int search = new Algorithm_33_LeetCode().search(new int[]{3, 1}, 1);
        System.out.println(search);
    }
}
