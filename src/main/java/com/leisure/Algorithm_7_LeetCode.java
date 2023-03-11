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

    /**
     * 出现问题，需要考虑到传入的数的取值范围。
     * @param x 操作数
     * @return 结果
     */
    public static int reverse(int x) {
        int result = 0;
        while (x != 0){
            if (result < Integer.MIN_VALUE/10 || result > Integer.MAX_VALUE/10){
                return 0;
            }
            int remainder = x % 10;
            x = x / 10;
            result  =  result * 10 + remainder;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(reverse(-214748364));
    }
}
