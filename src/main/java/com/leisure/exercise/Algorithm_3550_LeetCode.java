package com.leisure.exercise;

/**
 * ClassName: Algorithm_3550_LeetCode
 * Package: com.leisure.exercise
 * Description:
 *
 * @Author: MyLeisureLife
 * @Date: 2026/9/24:23:18:25 星期四
 */
public class Algorithm_3550_LeetCode {
    public int smallestIndex(int[] nums) {
        for (int i = 0; i < nums.length; i++){
            int  sum = 0;
            while (nums[i] != 0){
                sum += nums[i] % 10;
                nums[i] = nums[i] / 10;
            }
            if (sum == i){
                return i;
            }
        }
        return -1;
    }
}
