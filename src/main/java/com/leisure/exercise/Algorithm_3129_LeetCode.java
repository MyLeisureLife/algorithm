package com.leisure.exercise;

import com.mysql.jdbc.EscapeTokenizer;

/**
 * ClassName: Algorithm_3129_LeetCode
 * Package: com.leisure.exercise
 * Description:
 * 给你 3 个正整数 zero ，one 和 limit 。
 * 一个 二进制数组 arr 如果满足以下条件，那么我们称它是 稳定的 ：
 * 0 在 arr 中出现次数 恰好 为 zero 。
 * 1 在 arr 中出现次数 恰好 为 one 。
 * arr 中每个长度超过 limit 的 子数组 都 同时 包含 0 和 1 。
 * 请你返回 稳定 二进制数组的 总 数目。
 * 由于答案可能很大，将它对 109 + 7 取余 后返回。
 * 1 <= zero, one, limit <= 200
 * @Author: MyLeisureLife
 * @Date: 2026/3/9:07:55:01 星期一
 */
public class Algorithm_3129_LeetCode {
    /**
     *
     * @param zero The number of zeros in a binary array.
     * @param one The number of one in binary array.
     * @param limit Subarrays with length greater than `limit`
     * @return The number of items that satisfy all three conditions.
     */
    public int numberOfStableArrays(int zero, int one, int limit) {
        final long MOD = 1000000007;
        long[][] num_0 = new long[zero+1][one+1]; // num_0[i][j]表示 i个`0`和j个`1`能组成多少个最后一个元素是 0 的数量
        long[][] num_1 = new long[zero+1][one+1]; // num_1[i][j]表示 i个`0`和j个`1`能组成多少个最后一个元素是 1 的数量
        // 但有些0000000并不是我想要的，因为如果满足了limit + 1 个0就不是稳定二进制了。
        for (int i = 0; i <= Math.min(zero, limit); i++){
            // 默认`1`为0个时，`O`的个数逐渐增加，但管你增加多个个`0`只可能构建出一个结构一样的000000没有1的协助不可能构建出01000
            //num_0[0][0] = 1; 是为了让以后的计算方便
            num_0[i][0] = 1;
        }
        // 但有些11111111并不是我想要的，因为如果满足了limit + 1 个1就不是稳定二进制了。
        for (int i = 0; i <= Math.min(one, limit); i++){
            // 默认`1`为0个时，`O`的个数逐渐增加，但管你增加多个个`0`只可能构建出一个结构一样的11111111没有0的协助不可能构建出01000
            num_1[0][i] = 1;
        }
        // 现在我需要计算既有1也有0的情况了
        for (int i = 1; i <= zero; i++){
            for (int j = 1; j <= one; j++){
                // 计算结尾为0但是不稳定情况
                if (i > limit){
                    // 这个就需要考虑不稳定情况了，需要减去不稳定的数量
                    // 不稳定的情况只有 最后limit个都是0 而且最后的limit + 1位置是1在这基础上在添加0才能导致不稳定。
                    // 所以我们只需要知道最后为1的表中，i-limit-1个为0，j个为1 的情况有多少个稳定的就行了
                    num_0[i][j] = num_0[i - 1][j] + num_1[i - 1][j] - num_1[i - limit -  1][j] ;
                }else{
                    // 计算i个 0 和 j个1 结尾为0变化，
                    // 只需要将 i-1 个 0 和 j个1 结尾为0的情况个数 +   i-1 个 0 和 j个1 结尾为1的情况个数
                    // 因为这一步是在1 或 0结尾加上一个0就能保证结尾为0而且稳定
                    num_0[i][j] = num_0[i - 1][j] + num_1[i - 1][j];
                }
                // 需要取余了, 为什么要+MOD 因为  num_0[i][j]  可能是个负数，
                // 为什么num_0[i][j] 可能是个负数， 因为 num_0[i][j] = num_0[i - 1][j] + num_1[i - 1][j] - num_1[i - limit -  1][j]中
                // num_1[i - limit -  1][j] 在某一次取余运算中非常大。
                num_0[i][j] = (num_0[i][j]%MOD + MOD) % MOD;

                // 计算结尾为1但是不稳定情况， 和上面为0的情况相反就可以了
                if (j > limit){
                    num_1[i][j] = num_0[i][j - 1] + num_1[i][j - 1] - num_0[i][j - limit -  1] ;
                }else {
                    // 计算结尾为1而且稳定的情况
                    num_1[i][j] = num_0[i][j  - 1] + num_1[i][j  - 1];
                }
                // 取余
                num_1[i][j] = (num_1[i][j]%MOD + MOD) % MOD;
            }
        }
        return (int) ((num_0[zero][one] + num_1[zero][one]) % MOD);
    }


    public static void main(String[] args) {
        int i = new Algorithm_3129_LeetCode().numberOfStableArrays(3, 3, 2);
        System.out.println(i);
    }
}
