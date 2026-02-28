package com.leisure.exercise;

import com.sun.org.apache.xpath.internal.operations.Mod;
import com.sun.prism.shader.Solid_TextureYV12_AlphaTest_Loader;

/**
 * ClassName: Algorithm_1680_LeetCode
 * Package: com.leisure.exercise
 * Description:
 * 给你一个整数 n ，请你将 1 到 n 的二进制表示连接起来，
 * 并返回连接结果对应的 十进制 数字对 109 + 7 取余的结果。
 * 1 <= n <= 10^5
 * @Author: MyLeisureLife
 * @Date: 2026/2/28:12:04:24 星期六
 */
public class Algorithm_1680_LeetCode {

    /**
     * 模运算
     * 时间复杂度0(n) 空间复杂度O(1)
     * @param n 规模
     * @return 取模结果
     */
    public int concatenatedBinary(int n) {
        int MOD = 1000000007;
        long ans = 0;
        for (int i = 1; i <= n; i++) {
            // 计算i有多少个二进制位
            int bits = 32 - Integer.numberOfLeadingZeros(i);
            // i 和 i+1 的二进制位拼接等于 i << (i+1的二进制位) + i
            // i << (i+1的二进制位) 会导致大于int类型存储极限
            // 所以可以在拼接的时候就自动开始取模
            // 模运算满足分配规则，(a * b + c) % MOD  ==  ( (a % MOD) * (b % MOD) % MOD + c % MOD ) % MOD;
            ans = ((ans << bits) % MOD + i) % MOD;
        }
        return (int)ans;
    }

    public static void main(String[] args) {
        int i = new Algorithm_1680_LeetCode().concatenatedBinary(63556);
        System.out.println(i);

    }
}
