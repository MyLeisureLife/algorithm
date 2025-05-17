package com.leisure.exercise;

import sun.applet.Main;

/**
 * ClassName: Algorithm_75_LeetCode
 * Package: com.leisure.exercise
 * Description:
 *给定一个包含红色、白色和蓝色、共 n 个元素的数组 nums ，原地 对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * 我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 * 必须在不使用库内置的 sort 函数的情况下解决这个问题。
 *
 * @Author: MyLeisureLife
 * @Date: 2025/5/17:11:25:33 星期六
 */
public class Algorithm_75_LeetCode {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int index = -1;
        int k = 0;
        for (int i = 0; i < n; i++) {
            if (i == 0 || (nums[i] != k && nums[i-1] == k)) {
                index ++;
            }else if (nums[i] == k) {
                int temp = nums[index];
                nums[index] = nums[i];
                nums[i] = temp;
                index ++;
            }

            if (i == n - 1 && index != i) {
                k ++;
                i = index;
            }
        }
    }

    public static void main(String[] args) {
        new Algorithm_75_LeetCode().sortColors(new int[]{0,2,1});
    }
}


