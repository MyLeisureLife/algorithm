package com.leisure.exercise;

/**
 * ClassName: Algorithm_1758_LeetCode
 * Package: com.leisure.exercise
 * Description:
 * 给你一个仅由字符 '0' 和 '1' 组成的字符串 s 。一步操作中，你可以将任一 '0' 变成 '1' ，或者将 '1' 变成 '0' 。
 * 交替字符串 定义为：如果字符串中不存在相邻两个字符相等的情况，那么该字符串就是交替字符串。例如，字符串 "010" 是交替字符串，而字符串 "0100" 不是。
 * 返回使 s 变成 交替字符串 所需的 最少 操作数。
 * 1 <= s.length <= 10^4
 * s[i] 是 '0' 或 '1'
 * @Author: MyLeisureLife
 * @Date: 2026/3/5:22:53:37 星期四
 */
public class Algorithm_1758_LeetCode {
    /**
     * 时间复杂度O(n) 空间复杂度O(1)
     * 存在问题：执行次数有些多了，其实是2n，但是答案是n
     * @param s 0和1字符串
     * @return 变成交替字符串的需要操作次数
     */
    public int minOperations1(String s) {
        int num_ops_0 = 0;
        int num_ops_1 = 0;
        for (int i = 0; i < s.length(); i++) {
            // 默认从1开始 偶数位必须是1，奇数位必须是0
            if (s.charAt(i) == '0' && i % 2 == 0) {
                num_ops_1 ++;
            }else if (s.charAt(i) == '1' && i % 2 == 1) {
                num_ops_1 ++;
            }
            // 默认从0开始 偶数位必须是0，奇数位必须是1
            if (s.charAt(i) == '1' && i % 2 == 0) {
                num_ops_0 ++;
            }else if (s.charAt(i) == '0' && i % 2 == 1) {
                num_ops_0 ++;
            }
        }
        return Math.min(num_ops_0, num_ops_1);
    }

    /**
     * 时间复杂度O(n) 空间复杂度O(1)
     * 解决：从2n -> n : 替换无非变成101  或变成010, 这两种的替换次数相加是为s的长度
     * @param s 0和1字符串
     * @return 变成交替字符串的需要操作次数
     */
    public int minOperations2(String s) {
        int num_ops_0 = 0;
        for (int i = 0; i < s.length(); i++) {
            // 默认从0开始 偶数位必须是0，奇数位必须是1
            if (s.charAt(i) == '1' && i % 2 == 0) {
                num_ops_0++;
            } else if (s.charAt(i) == '0' && i % 2 == 1) {
                num_ops_0++;
            }
        }
        return Math.min(num_ops_0, s.length() - num_ops_0);
    }

    /**
     * 时间复杂度O(n) 空间复杂度O(1)
     * 解决：从2n -> n : 替换无非变成101  或变成010, 这两种的替换次数相加是为s的长度
     * 还可以降低执行时间: i % 2 == 0 这一步可以不需要执行
     * 如果想循环1010 可以 使用 k = 1 - k 放入循环，这样k就是循环的了
     * @param s 0和1字符串
     * @return 变成交替字符串的需要操作次数
     */
    public int minOperations3(String s) {
        int num_ops_0 = 0;
        int k = 1;
        for (int i = 0; i < s.length(); i++) {
            // 默认从0开始 偶数位必须是0，奇数位必须是1
            if ((s.charAt(i)&1) == k ) {
                num_ops_0++;
            }
            k = 1 - k;
        }
        return Math.min(num_ops_0, s.length() - num_ops_0);
    }

    /**
     * 时间复杂度O(n) 空间复杂度O(1)
     * 解决：从2n -> n : 替换无非变成101  或变成010, 这两种的替换次数相加是为s的长度
     * 还可以降低执行时间: i % 2 == 0 这一步可以不需要执行
     * 如果想循环1010 可以 使用 k = 1 - k 放入循环，这样k就是循环的了
     * 还可以提升空间复杂度从而略微降低时间复杂度:
     * 应为charAt(i) 需要
     * 边界检查（if 判断） → 每次调用都执行
     * 方法调用开销 → 虚拟机需要压栈、跳转、返回（即使 JIT 优化后仍有轻微成本）
     * 字段访问 → value 是 final char[]，但仍是间接访问
     * 可以使用s.toCharArray(); 降低上面几步操作
     * @param s 0和1字符串
     * @return 变成交替字符串的需要操作次数
     */
    public int minOperations(String s) {
        int num_ops_0 = 0;
        char[] charArray = s.toCharArray();
        int k = 1;
        for (char c : charArray) {
            // 默认从0开始 偶数位必须是0，奇数位必须是1
            if ((c & 1) == k) {
                num_ops_0++;
            }
            k = 1 - k;
        }
        return Math.min(num_ops_0, s.length() - num_ops_0);
    }


    public static void main(String[] args) {
        int i = new Algorithm_1758_LeetCode().minOperations("1011111111");
        System.out.println(i);

    }
}
