package com.leisure;

/**
 * Author: leisure1456
 * Date: 2023/2/20:12:14:24 星期一
 *
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 *
 * 如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
 *
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 */
public class Algorithm_7_LeetCode {

    public int reverse(int x) {
        //存放结果
        int res = 0;
        //余数
        int remainder = 0;
        //商
        int s = 0;
        while (x > 10){
            remainder = x % 10;



        }
        res = x;

        return res;
    }
}
