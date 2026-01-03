package com.leisure.exercise;

/**
 * ClassName: Algorithm_231_LeetCode
 * Package: com.leisure.exercise
 * Description:
 *给你一个整数 n，请你判断该整数是否是 2 的幂次方。如果是，返回 true ；否则，返回 false 。
 * 如果存在一个整数 x 使得 n == 2x ，则认为 n 是 2 的幂次方。
 * @Author: MyLeisureLife
 * @Date: 2026/1/3:13:41:29 星期六
 */
public class Algorithm_231_LeetCode {
    /**
     *  Brute-Force Algorithm
     *  时间复杂度O(log n) 空间复杂度O(1)
     *  将特定的解决了，让后再解决一般情况
     * @param n 2的幂次方构成的数
     * @return n是否是2的幂次方构成的数
     */
    public boolean isPowerOfTwo(int n) {
        if(n==0) return false;
        if(n==1) return true;

       while(n%2 == 0){
           n = n / 2;
           if(n == 1) return true;
       }

       return false;
    }

    /**
     * 位操作算法 bit manipulation algorithm
     * 将n转换一个角度看，n转化为二进制时就可以发现二进制情况如果n是2的幂构成的函数，
     * 那n这个转换为二进制时就只能存在一个1在二进制中
     * 时间复杂度O(1) 空间复杂度O（1）
     * @param n 2的幂次方构成的数
     * @return n是否是2的幂次方构成的数
     */
    public boolean leetCodeIsPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }


}
