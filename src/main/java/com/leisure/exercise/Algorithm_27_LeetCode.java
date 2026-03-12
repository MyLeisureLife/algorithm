package com.leisure.exercise;

/**
 * ClassName: Algorithm_27_LeetCode
 * Package: com.leisure.exercise
 * Description: LeetCode: 27 移除元素
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素。元素的顺序可能发生改变。然后返回 nums 中与 val 不同的元素的数量。
 * 假设 nums 中不等于 val 的元素数量为 k，要通过此题，您需要执行以下操作：
 * 更改 nums 数组，使 nums 的前 k 个元素包含不等于 val 的元素。nums 的其余元素和 nums 的大小并不重要。
 * 返回 k。
 * 0 <= nums.length <= 100
 * 0 <= nums[i] <= 50
 * 0 <= val <= 100
 * @Author: MyLeisureLife
 * @Date: 2026/3/12:18:05:40 星期四
 */
public class Algorithm_27_LeetCode {
    /**
     * Two pointers algorithm
     * Time Complexity: O(n)   Space Complexity:O(1)
     * @param nums Array
     * @param val value
     * @return The array contains multiple elements equal to val.
     */
    public int removeElement(int[] nums, int val) {
        int n = nums.length;
        int ans = 0;
        int pointer_end = n - 1 ;
        int pointer_begin = 0;
        while (pointer_begin <= pointer_end) {
            // 找出末尾不等于val的
            if (nums[pointer_end] == val){
                pointer_end --;
                ans ++;
                continue;
            }

            // 找出开始等于val的
            if (nums[pointer_begin] == val){
                ans ++;
            }else{
                pointer_begin ++;
                continue;
            }

           // 两个位置交换
           int temp = nums[pointer_begin];
           nums[pointer_begin] = nums[pointer_end];
           nums[pointer_end] = temp;
           // 两个交换了一次就要加减一次
           pointer_end --;
           pointer_begin ++;
        }
        return n - ans;
    }

    public static void main(String[] args) {
        int i = new Algorithm_27_LeetCode().removeElement(
                new int[]{1}, 1);
        System.out.println(i);
    }
}
