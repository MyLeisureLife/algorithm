package com.leisure.exercise;

import sun.applet.Main;

/**
 * ClassName: Algorithm_1653_LeetCode
 * Package: com.leisure.exercise
 * Description:
 * 给你一个字符串 s ，它仅包含字符 'a' 和 'b'。
 * 你可以删除 s 中任意数目的字符，使得 s 平衡 。当不存在下标对 (i,j) 满足 i < j ，且 s[i] = 'b' 的同时 s[j]= 'a' ，此时认为 s 是 平衡 的。
 * 请你返回使 s 平衡 的 最少 删除次数。
 * 1 <= s.length <= 10 ^ 5
 * s[i] 要么是 'a' 要么是 'b'.
 * @Author: MyLeisureLife
 * @Date: 2026/2/7:14:34:21 星期六
 */
public class Algorithm_1653_LeetCode {
    /**
     * 时间复杂度:O(n ^ 3) 空间复杂度O(n)
     * @param s 字符串
     * @return s字符变成平衡字符，最少需要删除多少个字符
     */
    public int minimumDeletions(String s) {
        StringBuilder s1 = new StringBuilder(s);
        if (s.length() == 1) return 0;
        int ans = 0;
        while (true){
            int count = 0;
            for (int i = 0; i < s1.length() - 1; i ++) {
                if (s1.charAt(i) == 'b' && s1.charAt(i + 1) == 'a') {
                    // 这时需要删除一个字符
                    count++;
                    s1.deleteCharAt(i);
                    s1.deleteCharAt(i);
                }
            }
            if (count == 0) {break;}
            ans += count;
        }

        return ans;
    }

    /**
     * 时间复杂度:O(n) 空间复杂度O(n)
     * @param s 字符串
     * @return s字符变成平衡字符，最少需要删除多少个字符
     */
    public int minimumDeletions1(String s) {
        int[] count = new int[s.length()];
        int ans = Integer.MAX_VALUE;
        int a = 0;
        int b = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'b') {
                b ++;
            }else{
                a ++;
            }
            count[i] = b;
        }
        if (a == 0 || b == 0) return 0;
        for (int i = 0; i < s.length(); i++) {
            // 找竖线位置：将前面全变成a需要删除多少个b
            int a_count;
            if (i == 0) {
                a_count = 0;
            } else {
                 a_count = count[i];
            }

            // 将后面变成b需要删除多个a
            int b_count = (s.length() - 1 - i) - (b - count[i]);
            ans = Math.min(ans, a_count + b_count);
        }
        return ans;
    }

    public static void main(String[] args) {
        int i = new Algorithm_1653_LeetCode().minimumDeletions1(
                "bbbbbbbaabbbbbaaabbbabbbbaabbbbbbaabbaaabaabbbaaaabaaababbbabbabbaaaabbbabbbbbaabbababbbaaaaaababaaababaabbabbbaaaabbbbbabbabaaaabbbaba");
        System.out.println(i);


    }
}
