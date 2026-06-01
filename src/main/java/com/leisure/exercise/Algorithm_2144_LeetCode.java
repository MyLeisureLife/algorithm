package com.leisure.exercise;

import java.util.Arrays;

/**
 * ClassName: Algorithm_2144_LeetCode
 * Package: com.leisure.exercise
 * Description: 2144. 打折购买糖果的最小开销
 *
 * @Author: MyLeisureLife
 * @Date: 2026/6/1:11:52:24 星期一
 */
public class Algorithm_2144_LeetCode {
    public int minimumCost(int[] cost) {
        Arrays.sort(cost);
        int c = 1;
        int ans = 0;
        for (int i = cost.length - 1; i >= 0; i--){
            if(c % 3 != 0){
               ans += cost[i];
            }
            c ++;
        }
        return ans;
    }
}
