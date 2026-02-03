package com.leisure.exercise;

/**
 * ClassName: Algorithm_3637_LeetCode
 * Package: com.leisure.exercise
 * Description:
 *给你一个长度为 n 的整数数组 nums。
 * 如果存在索引 0 < p < q < n − 1，使得数组满足以下条件，则称其为 三段式数组（trionic）：
 * nums[0...p] 严格 递增，
 * nums[p...q] 严格 递减，
 * nums[q...n − 1] 严格 递增。
 * 如果 nums 是三段式数组，返回 true；否则，返回 false。
 * 3 <= n <= 100
 * -1000 <= nums[i] <= 1000
 * @Author: MyLeisureLife
 * @Date: 2026/2/3:19:30:11 星期二
 */
public class Algorithm_3637_LeetCode {

    /**
     * 时间复杂度O(n)  空间复杂度O(1)
     * @param nums 数组
     * @return 数组是否符合条件
     */
    public boolean isTrionic(int[] nums) {
        int a = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] < nums[i + 1]) {
                a ++;
            }else break;
        }
        if (a == 0) {return false;}
        int b = 0;
        for (int i = a; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                a ++;
                b ++;
            }else break;
        }
        if (b == 0) {return false;}
        int c = 0;
        for (int i = a; i < nums.length - 1; i++) {
            if (nums[i] < nums[i + 1]) {
                a ++;
                c ++;
            }else break;
        }
        if (c == 0) {return false;}
        return a == nums.length - 1;
    }

    public static void main(String[] args) {
        boolean trionic = new Algorithm_3637_LeetCode().isTrionic(new int[]{2,1,3});
        System.out.println(trionic);
    }
}
