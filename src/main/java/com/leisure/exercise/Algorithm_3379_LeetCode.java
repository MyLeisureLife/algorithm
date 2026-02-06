package com.leisure.exercise;

/**
 * ClassName: Algorithm_3379_LeetCode
 * Package: com.leisure.exercise
 * Description:
 * 给你一个整数数组 nums，它表示一个循环数组。请你遵循以下规则创建一个大小 相同 的新数组 result ：
 * 对于每个下标 i（其中 0 <= i < nums.length），独立执行以下操作：
 * 如果 nums[i] > 0：从下标 i 开始，向 右 移动 nums[i] 步，在循环数组中落脚的下标对应的值赋给 result[i]。
 * 如果 nums[i] < 0：从下标 i 开始，向 左 移动 abs(nums[i]) 步，在循环数组中落脚的下标对应的值赋给 result[i]。
 * 如果 nums[i] == 0：将 nums[i] 的值赋给 result[i]。
 * 1 <= nums.length <= 100
 * -100 <= nums[i] <= 100
 * @Author: MyLeisureLife
 * @Date: 2026/2/5:20:42:12 星期四
 */
public class Algorithm_3379_LeetCode {
    public int[] constructTransformedArray(int[] nums) {
        int  n = nums.length;
        int[] result = new int[n];

        for (int i = 0; i < nums.length; i++){
            // 如果 nums[i] > 0：从下标 i 开始，
            // 向右移动 nums[i] 步，在循环数组中落脚的下标对应的值赋给 result[i]。
            // 移动后的坐标
            int j = 0;
            if (nums[i] > 0){
                // 在i坐标需要右移动几步才能到下标0
                int temp = n - i;
                // 如果移动大于到下部0的步数时
                if (temp <= nums[i]){
                    //最后移动到的的坐标
                    j = (nums[i] - temp) % n;
                }else {
                    j = i + nums[i];
                }
                result[i] = nums[j];
                continue;
            }
            // 如果 nums[i] < 0：从下标 i 开始，
            // 向 左 移动 abs(nums[i]) 步，在循环数组中落脚的下标对应的值赋给 result[i]。
            if (nums[i] < 0){
                // 在i坐标需要左移动几步才能到下标n - 1
                int temp = i + 1;
                // 如果移动大于到下部0的步数时
                if (temp <= -nums[i]){
                    //最后移动到的的坐标
                    j = n - 1 - (-nums[i] - temp) % n;
                }else {
                    j = i - -nums[i];
                }
                result[i] = nums[j];
                continue;
            }
            // 如果 nums[i] == 0：将 nums[i] 的值赋给 result[i]。
            result[i] = 0;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] ints = new Algorithm_3379_LeetCode().constructTransformedArray(new int[]{-1,4,-1});
        for (int i = 0; i < ints.length; i++){
            System.out.println(ints[i]);
        }
    }
}
