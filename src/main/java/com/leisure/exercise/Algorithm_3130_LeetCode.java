package com.leisure.exercise;

import jdk.internal.org.objectweb.asm.tree.MultiANewArrayInsnNode;

/**
 * ClassName: Algorithm_3130_LeetCode
 * Package: com.leisure.exercise
 * Description: 3130. 找出所有稳定的二进制数组 II
 * 给你 3 个正整数 zero ，one 和 limit 。
 * 一个 二进制数组 arr 如果满足以下条件，那么我们称它是 稳定的 ：
 * 0 在 arr 中出现次数 恰好 为 zero 。
 * 1 在 arr 中出现次数 恰好 为 one 。
 * arr 中每个长度超过 limit 的 子数组 都 同时 包含 0 和 1 。
 * 请你返回 稳定 二进制数组的 总 数目。
 * 由于答案可能很大，将它对 109 + 7 取余 后返回。
 * 1 <= zero, one, limit <= 1000
 * @Author: MyLeisureLife
 * @Date: 2026/3/10:10:21:53 星期二
 */
public class Algorithm_3130_LeetCode {

    public int numberOfStableArrays(int zero, int one, int limit) {
        int[][] dp_0 = new int [zero + 1][one + 1];
        dp_0[0][0] = 0;
        int[][] dp_1 = new int [zero + 1][one + 1];
        dp_1[0][0] = 0;
        for (int i = 1; i <= Math.min(zero, limit); i++) {
            dp_0[i][0] = 1;
        }
        for (int i = 1; i <= Math.min(one, limit); i++) {
            dp_1[0][i] = 1;
        }
        int MOD = 1000000007;
        for (int i = 1; i <= zero; i++) {
            for (int j = 1; j <= one; j++) {
                if(i <= limit){
                    dp_0[i][j] = dp_1[i - 1][j] + dp_0[i - 1][j];
                }else {
                    dp_0[i][j] = dp_1[i - 1][j] + dp_0[i - 1][j] - dp_1[i - (limit + 1)][j];
                }
                dp_0[i][j] = (dp_0[i][j] % MOD + MOD) % MOD;

                if(j <= limit){
                    dp_1[i][j] = dp_1[i ][j - 1] + dp_0[i ][j - 1];
                }else {
                    dp_1[i][j] = dp_1[i][j  - 1] + dp_0[i][j  - 1] - dp_0[i][j  - (limit + 1)];
                }
                dp_1[i][j] = (dp_1[i][j] % MOD + MOD) % MOD;
            }
        }
        return (dp_0[zero][one] + dp_1[zero][one]) % MOD;
    }

}