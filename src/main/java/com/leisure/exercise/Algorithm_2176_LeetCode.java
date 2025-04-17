package com.leisure.exercise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ClassName: Algorithm_2176_LeetCode
 * Package: com.leisure.exercise
 * Description:
 *给你一个下标从 0 开始长度为 n 的整数数组 nums 和一个整数 k ，
 * 请你返回满足 0 <= i < j < n ，nums[i] == nums[j] 且 (i * j) 能被 k 整除的
 * 数对 (i, j) 的 数目 。
 * @Author: MyLeisureLife
 * @Date: 2025/4/17:10:12:44 星期四
 */
public class Algorithm_2176_LeetCode {
    /**
     * 时间复制度0(n^2) 空间复杂度O(1)
     * @param nums 数组
     * @param k 除数
     * @return 满足条件的个数
     */
    public int countPairsViolent(int[] nums, int k) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j] && i * j % k == 0) {
                    ans++;
                }
            }
        }
        return ans;
    }

    /**
     *  题目的样本太小，导致这个效率不如暴力算法 这个时间复杂度最差是0(n^2) 最好是O(n) 空间复杂度为O(n)
     * @param nums 数组
     * @param k 除数
     * @return 满足条件的个数
     */
    public int countPairsSpace(int[] nums, int k) {
        int ans = 0;

        // 键 用于存数组值  List<Integer> 用于存值相同的下标
        Map<Integer, List<Integer>> number = new HashMap<Integer, List<Integer>>();

        for (int i = 0; i < nums.length; i++) {
            // 存在相同的值的下标 全部存到 List中
            if (number.containsKey(nums[i])) {
                List<Integer> integers = number.get(nums[i]);

                for (int num : integers) {
                    if (num * i % k == 0) {
                        ans++;
                    }
                }

                integers.add(i);
            }else {
                List<Integer> integers = new ArrayList<Integer>();
                integers.add(i);
                number.put(nums[i], integers);

            }
        }
        return ans;
    }


}
