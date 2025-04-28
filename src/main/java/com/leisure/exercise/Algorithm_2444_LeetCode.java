package com.leisure.exercise;

import java.util.*;

/**
 * ClassName: Algorithm_2444_LeetCode
 * Package: com.leisure.exercise
 * Description:
 *
 * @Author: MyLeisureLife
 * @Date: 2025/4/26:21:02:53 星期六
 */
public class Algorithm_2444_LeetCode {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int left = 0;
        int right = 0;
        long ans = 0;
        // 需要使用HashMap存数量 key : 值  value : 数量
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int i = left; i < nums.length; i++){
            // 添加时需要注意规则，必须在 minK <= nums[i] <= maxK 区间才能添加
            if (minK <= nums[i] && nums[i] <= maxK){
                map.put(nums[i], map.get(nums[i]) + 1);
            }else {

            }

            if (map.containsKey(minK) && map.containsKey(maxK)){
                ans++;
                right = i;
            }

        }

        return ans;
    }

}
