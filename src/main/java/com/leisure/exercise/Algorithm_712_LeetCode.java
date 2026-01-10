package com.leisure.exercise;

/**
 * ClassName: Algorithm_712_LeetCode
 * Package: com.leisure.exercise
 * Description:
 * 给定两个字符串s1 和 s2，返回 使两个字符串相等所需删除字符的 ASCII 值的最小和 。
 * 0 <= s1.length, s2.length <= 1000
 * s1 和 s2 由小写英文字母组成
 * @Author: MyLeisureLife
 * @Date: 2026/1/10:11:43:32 星期六
 */
public class Algorithm_712_LeetCode {
    /**
     * Dynamic Programming 动态规划
     * 时间复杂度O(mn) 空间复杂度O(mn) m：s1.length n:s2.length
     * @param s1 字符串1
     * @param s2 字符串2
     * @return 最小剩余字符ASCII和
     */
    public int minimumDeleteSum(String s1, String s2) {
        // 最小子问题 n为行，m为列
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n + 1][m + 1];

        // 当都为都为空时 i + 1： dp[0][0]位置应该为0
        // 为每一行数据取值
        for (int i = 0; i < n ; i++){
            dp[i + 1][0] = s1.codePointAt(i) + dp[i][0];
        }
        // 为每一列数据取值
        for (int i = 0; i < m; i++){
            dp[0][i + 1] += s2.codePointAt(i) + dp[0][i];
        }
        // 当s1和s2都不为空时，这时 s1的每个字符要和s2的每个字符比较
        //变量行
        for (int i = 1; i <= n; i++){
            // 遍历列
            for (int j = 1; j <= m; j++){
                // 如果相等就直接等于上一次运算，就相当与s1少了一个
                if (s1.codePointAt(i - 1) == s2.codePointAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1];
                //不相等情况要根据  dp[j - 1][i]  dp[j][i - 1]  s2.codePointAt(i)  s1.codePointAt(i) 这四个数据推算出来
                }else {
                    int a = dp[ i - 1][j] + s1.codePointAt( i - 1);
                    int b = dp[i][j - 1] + s2.codePointAt(j - 1);
                    dp[i][j] = Math.min(a, b);
                }
            }
        }
        return dp[n][m];
    }

    public static void main(String[] args) {
        int i = new Algorithm_712_LeetCode().minimumDeleteSum("abc", "abcd");
        System.out.println("结果:"+i);
    }
}

