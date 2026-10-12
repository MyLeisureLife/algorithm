package com.leisure.exercise;

import java.util.Arrays;
import java.util.List;

/**
 * ClassName: Algorithm_2897
 * Package: com.leisure.exercise
 * Description:
 *
 * @Author: MyLeisureLife
 * @Date: 2026/10/12:10:12:45 星期一
 */
public class Algorithm_2897_LeetCode {
    final int MOD = 1000000007;
    public int maxSum(List<Integer> nums, int k) {
        int[] cnt = new int[30];
        for(int num : nums){
            for(int i = 0 ; i < 30 ; i++){
                // 判断num在第几位出现了1情况
                if((num & (1 << i)) != 0){
                    cnt[i] += 1;
                }
            }
        }
        long ans = 0;
        for(int i = 0 ; i < k ; i++){
            //找最大的数
            long cul = 0;
            //要找最大的数，就需要倒序遍历
            for(int j = 29; j >= 0 ; j--){
                if (cnt[j] > 0){
                    cul += (1L << j);
                    cnt[j] -= 1;
                }
            }
            ans = (ans + cul * cul) % MOD;
        }
        return (int)ans;
    }


    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1,2,4);

        int i = new Algorithm_2897_LeetCode().maxSum(nums, 2);
        System.out.println(i);
    }
}
