package com.leisure.exercise;

/**
 * ClassName: Algorithm_693_LeetCode
 * Package: com.leisure.exercise
 * Description:
 * 给定一个正整数，检查它的二进制表示是否总是 0、1 交替出现：
 * 换句话说，就是二进制表示中相邻两位的数字永不相同。
 * @Author: MyLeisureLife
 * @Date: 2026/2/18:11:05:57 星期三
 */
public class Algorithm_693_LeetCode {

    /**
     * 时间复杂度O(1) 空间复杂度(n)
     * @param n 二进制数
     * @return 是否是循环二进制数
     */
    public boolean hasAlternatingBits(int n) {
        int m = n >> 1;
        int c = m ^ n;
        while (c % 2 == 1) {
            c >>= 1;
        }
        return c == 0;
    }

    /**
     * 时间复杂度O(1) 空间复杂度(1)
     * @param n 二进制数
     * @return 是否是循环二进制数
     */
    public boolean hasAlternatingBits1(int n) {
        int m = n >> 1;
        int c = m ^ n;
        return (c & (c + 1)) == 0;
    }



    public static void main(String[] args) {
        Algorithm_693_LeetCode obj = new Algorithm_693_LeetCode();
        System.out.println(obj.hasAlternatingBits(10));
    }
}
