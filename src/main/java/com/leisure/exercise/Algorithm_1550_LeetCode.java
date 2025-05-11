package com.leisure.exercise;

/**
 * ClassName: Algorithm_1550_LeetCode
 * Package: com.leisure.exercise
 * Description:
 *给你一个整数数组 arr，请你判断数组中是否存在连续三个元素都是奇数的情况：如果存在，请返回 true ；否则，返回 false 。
 *
 * @Author: MyLeisureLife
 * @Date: 2025/5/11:20:27:41 星期日
 */
public class Algorithm_1550_LeetCode {

    public boolean threeConsecutiveOdds(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0){
                sum = 0;
                continue;
            }
            sum += 1;
            if(sum == 3){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        boolean b = new Algorithm_1550_LeetCode().threeConsecutiveOdds(new int[]{1, 1,1});
        System.out.println(b);
    }
}
