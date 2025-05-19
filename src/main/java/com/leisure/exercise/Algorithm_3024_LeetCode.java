package com.leisure.exercise;

/**
 * ClassName: Algorithm_3024_LeetCode
 * Package: com.leisure.exercise
 * Description:
 *给你一个下标从 0 开始长度为 3 的整数数组 nums ，需要用它们来构造三角形。
 * 如果一个三角形的所有边长度相等，那么这个三角形称为 equilateral 。
 * 如果一个三角形恰好有两条边长度相等，那么这个三角形称为 isosceles 。
 * 如果一个三角形三条边的长度互不相同，那么这个三角形称为 scalene 。
 * 如果这个数组无法构成一个三角形，请你返回字符串 "none" ，否则返回一个字符串表示这个三角形的类型。
 * @Author: MyLeisureLife
 * @Date: 2025/5/19:20:10:00 星期一
 */
public class Algorithm_3024_LeetCode {
    public String triangleType(int[] nums) {
        int a = nums[0] + nums[1];
        int b = nums[1] + nums[2];
        int c = nums[2] + nums[0];
        if (nums[0] == nums[1] && nums[0] == nums[2]){
            return "equilateral";
        }
        if (nums[2] < a && nums[0] < b && nums[1] < c){
            if (nums[0] == nums[1] || nums[0] == nums[2] || nums[2] == nums[1]){
                return "isosceles";
            }
            return "scalene";
        }
        return "none";
    }
}
