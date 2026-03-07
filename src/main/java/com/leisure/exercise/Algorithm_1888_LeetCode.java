package com.leisure.exercise;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * ClassName: Algorithm_1888_LeetCode
 * Package: com.leisure.exercise
 * Description: 1888. 使二进制字符串字符交替的最少反转次数
 * 给你一个二进制字符串 s 。你可以按任意顺序执行以下两种操作任意次：
 * 类型 1 ：删除 字符串 s 的第一个字符并将它 添加 到字符串结尾。
 * 类型 2 ：选择 字符串 s 中任意一个字符并将该字符 反转 ，也就是如果值为 '0' ，则反转得到 '1' ，反之亦然。
 * 请你返回使 s 变成 交替 字符串的前提下， 类型 2 的 最少 操作次数 。
 * 我们称一个字符串是 交替 的，需要满足任意相邻字符都不同。
 * 比方说，字符串 "010" 和 "1010" 都是交替的，但是字符串 "0100" 不是。
 * 1 <= s.length <= 10^5
 * s[i] 要么是 '0' ，要么是 '1' 。
 * @Author: MyLeisureLife
 * @Date: 2026/3/7:09:27:56 星期六
 */
public class Algorithm_1888_LeetCode {
    /**
     * Time Complexity: O(n * n )  Space Complexity: O(n)
     * n: The length of string s
     * 解决思路1： 操作1从0 ~ n 都执行一次，在操作1的基础上执行操作2需要几次才能将s变成交替字符
     * 思路1的方法可以解决问题，但是时间复杂度太高了。 问题规模不能用n*n的时间复杂度
     * @param s: s is a string consisting of 0s and 1s.
     * @return : The minimum number of operations of type 2
     */
    public int minFlips1(String s) {
        // 应为操作1所以需要将s转换为列表
        char[] charArray = s.toCharArray();
        int ans = Integer.MAX_VALUE;
        List<Character> characters = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            characters.add(charArray[i]);
        }
        for (int i = 0; i < s.length() - 1; i++) {
            // 现在靠开始第二步操作将s变成交替字符串
            int k = 0;
            int num_0 = 0;
            int num_1 = 0;
            for (Character character : characters) {
                // 010交替需要修改几次
                if ((character & 1) != k) {
                    num_0 = num_0 + 1;
                }
                // 101交替需要修改几次
                if ((character & 1) == k) {
                    num_1 = num_1 + 1;
                }
                k = 1 - k;
            }
            ans = Math.min(Math.min(num_0, num_1), ans);

            // 现在开始操作将第一步骤将第一个提到最后一个
            characters.add(characters.get(0));
            characters.remove(0);
        }
        return ans;
    }

    /**
     * Time Complexity: O(n )  Space Complexity: O(n)
     * n: The length of string s
     * 解决思路1： 操作1从0 ~ n 都执行一次，在操作1的基础上执行操作2需要几次才能将s变成交替字符
     * 思路1的方法可以解决问题，但是时间复杂度太高了。 问题规模不能用n*n的时间复杂度
     * 操作1的方式: 最终的效果是在2s上进行滑动而已
     * 虽然时间复杂度降低了，但是空间用了很多
     * @param s: s is a string consisting of 0s and 1s.
     * @return : The minimum number of operations of type 2
     */
    public int minFlips2(String s) {
        //构建2s字符穿
        StringBuilder double_s = new StringBuilder(s);
        char[] charArray = double_s.append(s).toString().toCharArray();
        //将charArray变成交替字符
        int k = 0;
        int ans = Integer.MAX_VALUE;
        int num_0 = 0;
        int num_1 = 0;
        int[] arr_0 = new int[charArray.length];
        int[] arr_1 = new int[charArray.length];
        for (int i = 0; i < charArray.length; i++) {
            // 变成010交替需要执行的次数
            if ((charArray[i] & 1) != k) {
                num_0 = num_0 + 1;
            }
            // 变成101交替需要执行的次数
            if ((charArray[i] & 1) == k) {
                num_1 = num_1 + 1;
            }
            k = 1 - k;
            // 记录前面的每次交换次数总和
            arr_0[i] = arr_0[i] + num_0;
            arr_1[i] = arr_1[i] + num_1;
        }
        // 现在使用滑动窗口计算交换次数就可以了
        for (int i = s.length() - 1; i < charArray.length; i++) {
            // 变成010 需要执行多少次2操作
            int start = i - s.length() + 1;
            int a = arr_0[i] - arr_0[start];
            // 变成101 需要执行多少次2操作
            int b = arr_1[i] - arr_1[start];

            // 前后不一样,就表示了当前位置改动了一次需要+1
            if ( (start == 0 && arr_0[start] == 1) || (start - 1 >= 0 && arr_0[start - 1] != arr_0[start])) {
                a++;
            }
            if ((start == 0 && arr_1[start] == 1) || (start - 1 >= 0 && arr_1[start - 1] != arr_1[start])) {
                b++;
            }


            int min = Math.min(a, b);
            ans = Math.min(ans, min);
        }
        return ans;
    }

    /**
     * Time Complexity: O(n )  Space Complexity: O(1)
     * n: The length of string s
     * 解决思路1： 操作1从0 ~ n 都执行一次，在操作1的基础上执行操作2需要几次才能将s变成交替字符
     * 思路1的方法可以解决问题，但是时间复杂度太高了。 问题规模不能用n*n的时间复杂度
     * 操作1的方式: 最终的效果是在2s上进行滑动而已
     * 虽然时间复杂度降低了，但是空间用了很多
     * LeetCode上的最优解
     * 将操作1看成：s就是一个环
     * 当s长度为偶数时，就不用执行操作1了，直接执行操作2就可以了
     * 当s长度为奇数时，就需要考虑了
     * @param s: s is a string consisting of 0s and 1s.
     * @return : The minimum number of operations of type 2
     */
    public int minFlips(String s) {
        int ans = 0;
        char[] charArray = s.toCharArray();
        int n = charArray.length;
        int diff = 0;
        for (int i = 0; i < charArray.length; i++) {
            // 统计s变成: 010101模式的交替字符串， 需要修改多少个位
            diff += (charArray[i] & 1) ^ (i & 1);
        }
        ans = Math.min(diff, n - diff);
        if (ans == 0 || n % 2 == 0) { return ans;}
        // 当s字符长度为奇数时
        for (char c : charArray) {
            // 移出的第一个字符 和 010101模式匹配时， new_diff = n - diff - 1 不匹配时: new_diff = n -diff + 1
            // 因为0101模式第一个是0所以就直接等于0就可以了
            int new_diff = 0;
            if ((c & 1) == 0) {
                new_diff = n - diff - 1;
            } else {
                new_diff = n - diff + 1;
            }
            ans = Math.min(ans, Math.min(n - new_diff, new_diff));
            diff = new_diff;
        }
        return ans;
    }


    public static void main(String[] args) {
        int i = new Algorithm_1888_LeetCode().minFlips("00110");
        System.out.println(i);
    }

}
