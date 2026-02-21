package com.leisure.exercise;

/**
 * ClassName: Algorithm_762_LeetCode
 * Package: com.leisure.exercise
 * Description: 给你两个整数 left 和 right ，在闭区间 [left, right] 范围内，统计并返回 计算置位位数为质数 的整数个数。
 * 计算置位位数 就是二进制表示中 1 的个数。
 * 例如， 21 的二进制表示 10101 有 3 个计算置位。
 *
 * @Author: MyLeisureLife
 * @Date: 2026/2/21:19:29:12 星期六
 */
public class Algorithm_762_LeetCode {
    /**
     * 时间复杂度O(n)  空间复杂度O(1)
     * @param left 左边界
     * @param right 有边界
     * @return 中间有多少个符合条件的个数
     */
    public int countPrimeSetBits(int left, int right) {
        int ans = 0;
        for (int i = left; i <= right; i++) {
            // 统计i二进制数1的个数
            int j = i;
            int c = 0;
            while (j != 0) {
                j = j & (j - 1);
                c ++;
            }
            // 判断是否是质数
            if(isPrime(c)) ans++;
        }
        return ans;
    }

    /**
     * 判断是否是质数方法
     * @param i 需要判断的质数
     * @return 是否是质数
     */
    private boolean isPrime(int i) {
        if (i < 2) return false;
        for (int j = 2; j * j < i; j++) {
            if (i % j == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int i = new Algorithm_762_LeetCode().countPrimeSetBits(6, 10);
        System.out.println(i);
    }
}
