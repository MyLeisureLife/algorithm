package com.leisure.exercise;

import com.mysql.jdbc.EscapeTokenizer;

import java.util.*;

/**
 * ClassName: Algorithm_3666_LeetCode
 * Package: com.leisure.exercise
 * Description:
 * 给你一个二进制字符串 s 和一个整数 k。
 * 在一次操作中，你必须选择 恰好 k 个 不同的 下标，并将每个 '0' 翻转 为 '1'，每个 '1' 翻转为 '0'。
 * 返回使字符串中所有字符都等于 '1' 所需的 最少 操作次数。如果不可能，则返回 -1。
 * 1 <= s.length <= 105
 * s[i] 的值为 '0' 或 '1'。
 * 1 <= k <= s.length
 *
 * @Author: MyLeisureLife
 * @Date: 2026/2/27:11:35:12 星期五
 */
public class Algorithm_3666_LeetCode {
    public int minOperations(String s, int k) {
        int n = s.length(), m = 0; // m存储s中的0个数
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '0') {
                m++;
            }
        }
        if (m == 0) {
            return 0;
        }
        Set<Integer> current = new HashSet<>();
        // 每次取c个0变成1，取k-c个1变成0，
        // 最多取多少个0变成1：0 <= c <= min(m,k)
        // 最多取多少个1变成0：0 <= (k - c) <= n - m
        // 合并后得到c的最终取值范围 Max(k - n + m, 0) <= c <= min(m , k)
        int c = Math.max(k - n + m, 0);
        // 在c的取值范围进行一次操作后，s字符串的中0的数量为:
        // n = m - c + (k - c) = m + k - 2*c c:[Max(k - n + m, 0) <= c <= min(m , k)]
        // dist[i] 记录m = i，记录执行了多少次 m + k - 2*c
        // 如果等于  Integer.MAX_VALUE 就表示执行 m + k - 2*c 不能让m变成i
        // 第一层
        List<Integer> one = new ArrayList<>();
        // 第一层数据构建
        for (int i = 0; i < n + 1; i++) {
            one.add(Integer.MAX_VALUE);
        }
        for (int j = c; j <= Math.min(m, k); j++) {
            // 如果满足替换条件就进行替换操作
            if (m >= j && n - m >= k - j) {
                // 进行一次替换操作
                one.set(m + k - 2 * j, 1);
                current.add(m + k - 2 * j);
            }
        }
        if (one.get(0) != Integer.MAX_VALUE) {
            return one.get(0);
        }

        // 执行到第几步
        int step = 2;
        while (true) {
            // 第二层
            List<Integer> two = new ArrayList<>();
            int number = current.size();
            // 根据第一层数据构建出第二层数据
            for (int i = 0; i < one.size(); i++) {

                // 给第二层加上空位置
                if (two.size() <= one.size()) {
                    for (int j = 0; j < one.size() * (n + 1); j++) {
                        two.add(Integer.MAX_VALUE);
                    }
                }

                // 如果上一步都走不到，就不需要继续向下走了
                if (one.get(i) == Integer.MAX_VALUE) {
                    continue;
                }
                // 计算当前层位置的当前位置有多少个0
                m = i % (n + 1);
                c = Math.max(k - n + m, 0);
                // 给第二层添加数据
                for (int j = c; j <= Math.min(m, k); j++) {
                    // 如果满足替换条件就进行替换操作
                    if (m >= j && n - m >= k - j) {
                        // 进行一次替换操作
                        int p = i * (n + 1) + (m + k - 2 * j);
                        two.set(p, step);
                        current.add(m + k - 2 * j);
                        if (m + k - 2 * j == 0) {
                            return step;
                        }
                    }
                }
            }
            // 每次计算下一层时需查询
            if (current.size() == number) {
                return -1;
            }
            // 第二层给第一层
            one = two;
            step++;
        }

    }

    public static void main(String[] args) {
        int i = new Algorithm_3666_LeetCode().minOperations("00001001", 1);
        System.out.println(i);

    }

}
