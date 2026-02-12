package com.leisure.exercise;

import jdk.internal.util.xml.impl.ReaderUTF16;

/**
 * ClassName: Algorithm_3713_LeetCoe
 * Package: com.leisure.exercise
 * Description:
 * 给你一个由小写英文字母组成的字符串 s。
 * 如果一个 子串 中所有 不同 字符出现的次数都 相同 ，则称该子串为 平衡 子串。
 * 请返回 s 的 最长平衡子串 的 长度 。
 * 子串 是字符串中连续的、非空 的字符序列。
 * 1 <= s.length <= 1000
 * s 仅由小写英文字母组成。
 * @Author: MyLeisureLife
 * @Date: 2026/2/12:11:58:05 星期四
 */
public class Algorithm_3713_LeetCode {
    /**
     * brute-force algorithm 暴力算法
     * 时间复杂度O(n^3)  空间复杂度O(1)
     * @param s 字符串
     * @return 符合条件的最长子字符串
     */
    public int longestBalanced(String s) {
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            int[] arr = new int[26];
            for (int j = i; j < s.length(); j++) {
                arr[s.charAt(j) - 'a']++;
                boolean a= true;
                for (int k = 0; k < 26; k++) {
                    if (arr[k] != 0 && arr[k] != arr[s.charAt(j) - 'a']) {
                        a = false;
                        break;
                    }
                }
                if (a){ ans = Math.max(ans, j - i + 1); }
            }

        }
        return ans;
    }
}
