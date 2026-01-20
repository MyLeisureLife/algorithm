package com.leisure.exercise;

import sun.applet.Main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ClassName: Algorithm_3314_LeetCode
 * Package: com.leisure.exercise
 * Description:
 *给你一个长度为 n 的质数数组 nums 。你的任务是返回一个长度为 n 的数组 ans ，对于每个下标 i ，以下 条件 均成立：
 * ans[i] OR (ans[i] + 1) == nums[i]
 * 除此以外，你需要 最小化 结果数组里每一个 ans[i] 。
 * 如果没法找到符合 条件 的 ans[i] ，那么 ans[i] = -1 。
 * 质数 指的是一个大于 1 的自然数，且它只有 1 和自己两个因数。
 * 1 <= nums.length <= 100
 * 2 <= nums[i] <= 1000
 * @Author: MyLeisureLife
 * @Date: 2026/1/20:17:52:07 星期二
 */
public class Algorithm_3314_LeetCode {
    /**
     * Brute-Force Algorithm 暴力算法
     * 直接使用遍历去找符合条件的
     * 时间复杂度O(nm) 空间复杂度(1) n: list长度 m:列表最大值
     * @param nums 质数列表
     * @return 满足特定条件的数组
     */
    public int[] minBitwiseArray1(List<Integer> nums) {
        // 返回的结果数组
        int [] ans = new int[nums.size()];
        // 对结果进行赋值计算
        for (int i = 0; i < nums.size(); i++){
            // Brute-Force Algorithm 直接遍历所有可能
            for (int j = 0; j < nums.get(i); j++){
                // 对于满足条件的情况
                if ((j | j + 1) == nums.get(i)){
                    ans[i] = j;
                    break;
                }
                // 对于没有满足条件的情况
                if (j + 1 == nums.get(i)){
                    ans[i] = -1;
                    break;
                }
            }
        }
        return ans;
    }

    /**
     * Bit Manipulation Algorithm 位运算算法
     * 时间复杂度O(n log m) 空间复杂度O(1) n: list长度 m:列表最大值
     * @param nums 质数列表
     * @return 满足特定条件的数组
     */
    public int[] minBitwiseArray(List<Integer> nums) {
        int size = nums.size();
        // 返回结果数组
        int [] ans = new int[size];
        for (int i = 0; i < size; i++){
            // 数组每个的初始结果
            int res = -1;
            // 获取质数
            int prime_number = nums.get(i);
            // bit manipulation 的 bit position ，默认从第一位开始运算
            int bit_position = 1;
            // res & bit_position 表示当 prime_number 第一位如果是1就进行里面的运算，
            // 直到找到prime_number不是1的位结束运算
            // 题目中最小的条件则是在循环结束的最后一次满足了
            while ((prime_number & bit_position) != 0){
                // 如果条件满足进入了就将 prime_number 当前bit变成0，
                // 然后就可以满足题目中的 ans[i] OR (ans[i] + 1) == nums[i]条件了
                res = prime_number - bit_position;
                // 向左移动一位
                bit_position <<= 1;
            }
            // 赋值结果
            ans[i] = res;
        }
        return ans;
    }

    public static void main(String[] args) {
        List<Integer> objects = new ArrayList<>();
        objects.add(2);
        objects.add(3);
        objects.add(5);
        objects.add(7);
        int[] ints = new Algorithm_3314_LeetCode().minBitwiseArray(objects);
        System.out.println(Arrays.toString(ints));
    }
}
