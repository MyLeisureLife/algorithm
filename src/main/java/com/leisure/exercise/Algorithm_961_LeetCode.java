package com.leisure.exercise;

import java.util.*;

/**
 * ClassName: Algorithm_961_LeetCode
 * Package: com.leisure.exercise
 * Description:
 *给你一个整数数组 nums ，该数组具有以下属性：
 * nums.length == 2 * n.
 * nums 包含 n + 1 个 不同的 元素
 * nums 中恰有一个元素重复 n 次
 * 找出并返回重复了 n 次的那个元素。
 *
 * @Author: MyLeisureLife
 * @Date: 2026/1/2:10:16:33 星期五
 */
public class Algorithm_961_LeetCode {
    /**
     * 暴力算法  Brute-force Algorithm
     * 直接遍历整个数组
     * 时间复杂度O(2n) 空间复杂度(n)
     * @param nums 2n长度的数组
     * @return 数组中重复n次的数字
     */
    public int BruteForceRepeatedNTimes(int[] nums) {
        // 创建一个数组存放数组中数字出现的次数
        Map<Integer, Integer> map = new HashMap<>();

        // 遍历nums数组
        for (int num : nums){
            // 坐标位置数据 + 1
            map.put(num, map.getOrDefault(num, 0) + 1);

            // 如果等于n就直接返回
            if (map.get(num) == nums.length / 2) return num;
        }

        return -1;
    }

    /**
     * LeetCode Brute-force Algorithm
     * 将问题简化为：找到数组中两个相同数字问题
     * 时间复杂度O(n) 空间复杂度(n)
     * @param nums 2n长度的数组
     * @return 数组中重复n次的数字
     */
    public int LeetCodeBruteForceRepeatedNTimes(int[] nums) {
        // 使用Set集合存储数字，利用Set集合中的元素不能重复特点
        Set<Integer> set = new HashSet<>();
        for (int num : nums){
            // 是否可以存入到set集合中去
            boolean add = set.add(num);
            // 当返回false不能存入的时候，就表明先前已经存入了
            if (!add) return num;
        }
        // 特殊情况
        return -1;
    }

    /**
     * mathematical algorithm
     * 使用数学方法来解决降低空间复杂度
     * 应为题目给出的相同个数有n个占据数组的一半，所以他们的间隔方式必定有这
     * 三种方式， 11 ， 101， 1001， 不可能出现全部是10001这种排列方式。
     * 所以我们可以针对这三种排列方式遍历一次就行了，这样空间复杂度就降低了
     * 时间复杂度O(n) 空间复杂度O(1)
     * @param nums 2n长度的数组
     * @return 数组中重复n次的数字
     */
    public int mathematicalAlgorithmRepeatedNTimes(int[] nums) {
        for(int i=1; i < 4; i++){
            for(int j = 0; j + i < nums.length; j++){
                if (nums[j] == nums[j+i]) return nums[j];
            }
        }
        return -1;
    }

    /**
     * 随机算法 random algorithm
     * 应为重复数据在数组中占据了一半，而且剩下的那一半都没有重复，所以可以使用随机算法
     * 从数组中随机选两个数，选到有数字相同的数的概率是二分之一，如果两个都相同就是四分之一
     * 这样理论上就只需要4次就可以找到相同的数字了
     * 时间复杂度O(1) 空间复杂度O(1)
     * @param nums 2n长度的数组
     * @return 数组中重复n次的数字
     */
    public int randomRepeatedNTimes(int[] nums) {
        Random rand = new Random();
        while (true){
            int i = rand.nextInt(nums.length);
            int j = rand.nextInt(nums.length);
            if (i != j && nums[i] == nums[j]) return nums[i];
        }
    }


}