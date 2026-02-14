package com.leisure.exercise;

import sun.applet.Main;

import java.util.*;

/**
 * ClassName: Algorithm_3714_LeetCode
 * Package: com.leisure.exercise
 * Description:
 *给你一个只包含字符 'a'、'b' 和 'c' 的字符串 s。
 * 如果一个 子串 中所有 不同 字符出现的次数都 相同，则称该子串为 平衡 子串。
 * 请返回 s 的 最长平衡子串 的 长度 。
 * 子串 是字符串中连续的、非空 的字符序列。
 * 1 <= s.length <= 10^5
 * s 仅包含字符 'a'、'b' 和 'c'。
 * @Author: MyLeisureLife
 * @Date: 2026/2/13:10:11:02 星期五
 */
public class Algorithm_3714_LeetCode {
    /**
     * 使用前缀和prefix sum 和 hashmap解决
     * 时间复杂度O(n) 空间复杂度O(n)
     * @param s 字符串
     * @return 满足条件的最长子字符串长度
     */
    public int longestBalanced(String s) {
        // 最终答案
        int ans = 0;
        // 数组长度
        int n = s.length();
        // 最终答案有三种情况：一种字符，两种字符，三种字符
        //一种字符情况
        // 连续相同的情况
        int  same = 0;
        for (int i = 0; i < n; i++) {
            if (i > 0 && s.charAt(i - 1) == s.charAt(i)){
                same++;
            }else {
                same = 1;
            }
            ans = Math.max(ans, same);
        }
        // 两种字符情况: ab   ac   bc
        ans = Math.max(ans, twoChar(s, 'a', 'b'));
        ans = Math.max(ans, twoChar(s, 'a', 'c'));
        ans = Math.max(ans, twoChar(s, 'b', 'c'));

        // 三种字符情况 i <= j
        // i位置出现a字符是数量ai j位置出现a字符数量 aj
        // i位置出现b字符是数量bi j位置出现b字符数量 bj
        // i位置出现c字符是数量ci j位置出现c字符数量 cj
        // 如果要满足条件就会有：aj - ai = bj - bi   bj - bi = cj - ci
        // 所以我们只要记录他们相差个数相同的位置 然后循环下去继续找相差个数位置相同的位置
        // 让后将两个位置相减就可以得到符合条件字符的长度了。
        // 但是出现了问题：怎么记录3种字符相差个数
        // 可以使用long类型记录：高位记录ab相差个数，低位记录bc相差个数
        // 由于相差可能是负数所以 ab相差个数 +n bc相差个数 + n保证是正数
        // 使用 | 按位或 符合进行高低位拼接
        // 2²⁰ = 1,048,576 ，s.length <= 10^5 所以低位只需要保留20位就完全够用了
        long different = 0;
        Map<Long, Integer> map = new HashMap<>();
        // 由于最开始ab bc 相差都是0
        map.put(((long) n << 20 | n), -1);
        // 记录a b c 出现的次数
        int[] nums = new int[3];
        for (int i = 0; i < n; i++) {
            nums[s.charAt(i) - 'a']++;
            different = (long)(nums[0] - nums[1] + n) << 20 | (nums[1] - nums[2] + n);
            if (map.containsKey(different)) {
                ans = Math.max(ans, i - map.get(different));
            }else {
                map.put(different, i);
            }
        }
        return ans;
    }

    /**
     *
     * @param s 字符串
     * @param x 第一种字符
     * @param y 第二种字符
     * @return 这两种字符最长的平衡子字符串长度
     */
    public int twoChar(String s, char x, char y) {
        int ans = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            // 跳过分割点
            if (s.charAt(i) != x && s.charAt(i) != y) {
                continue;
            }
            // 用于记录x字符和y字符相差多少个
            int different = 0;
            // key: 记录x和y相差多个 value: 记录相差个数的位置
            Map<Integer, Integer> map = new HashMap<>();
            // 记录开始的位置, 最开始相差0个是从-1坐标开始计算的
            map.put(different, i-1);
            // 找x和y字母相差多个个
            int  j = i;
            while (j < n && (s.charAt(j) == y || s.charAt(j) == x)) {
                different += s.charAt(j) == x ? 1 : -1;
                // 找到x和y的相差个数后，去map中找是否存在相差相同个数的位置。
                if (map.containsKey(different)) {
                    ans = Math.max(ans, j - map.get(different));
                    // 如果没有找到有相差这么多个的位置就记录起来
                }else {
                    map.put(different, j);
                }
                j++;
            }
            i = j - 1;

        }
        return ans;
    }

    public static void main(String[] args) {
        int i = new Algorithm_3714_LeetCode().longestBalanced("a");
        System.out.println(i);
    }
}
