package com.leisure.exercise;

/**
 * ClassName: Algorithm_66_LeetCode
 * Package: com.leisure.exercise
 * Description:
 * 给定一个表示 大整数 的整数数组 digits，其中 digits[i] 是整数的第 i 位数字。这些数字按从左到右，从最高位到最低位排列。这个大整数不包含任何前导 0。
 * 将大整数加 1，并返回结果的数字数组。
 *
 * @Author: MyLeisureLife
 * @Date: 2026/1/1:16:24:14 星期四
 */
public class Algorithm_66_LeetCode {
    /**
     * 简单题目
     * 只需要考虑几种特殊情况就可以了 扩容情况，不扩容情况
     * 时间复杂度O(n) 空间复杂度O(1)
     * @param digits 目标数组
     * @return 目标数组 + 1
     */
    public int[] plusOne(int[] digits) {
        // 不扩容情况，证明数组中存在小于9的位
        for (int i = digits.length - 1; i >= 0; i--){
            if(digits[i] == 9){
                digits[i] = 0;
            }else {
                digits[i]++;
                return digits;
            }
        }

        // 上面没有返回就剩下一种情况: 位全部是9
        int[] res = new int[digits.length + 1];
        res[0] = 1;
        return res;

    }
}
