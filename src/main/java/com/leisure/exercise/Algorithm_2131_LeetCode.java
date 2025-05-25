package com.leisure.exercise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ClassName: Algorithm_2131_LeetCode
 * Package: com.leisure.exercise
 * Description:
 *给你一个字符串数组 words 。words 中每个元素都是一个包含 两个 小写英文字母的单词。
 * 请你从 words 中选择一些元素并按 任意顺序 连接它们，并得到一个 尽可能长的回文串 。每个元素 至多 只能使用一次。
 * 请你返回你能得到的最长回文串的 长度 。如果没办法得到任何一个回文串，请你返回 0 。
 * 回文串 指的是从前往后和从后往前读一样的字符串。
 *1 <= words.length <= 105
 * words[i].length == 2
 * words[i] 仅包含小写英文字母。
 *  这道题不能使用O(n^2)时间复杂度，不然就会超出时间限制
 * @Author: MyLeisureLife
 * @Date: 2025/5/25:09:16:49 星期日
 */
public class Algorithm_2131_LeetCode {
    public int longestPalindromeMy(String[] words) {
        int n = words.length;
        int ans = 0;
        int flag = 0;
        for (int i = 0; i < n; i++) {
            // 必须是长度为2的才进行查找
            if (words[i].length() != 2) { continue; }

            // 全局查找是否存在一个与其相反的字符串，使用了的字符串改变长度
            for (int j = 0; j < n; j++) {
                if (words[j].length() == 2 && words[i].charAt(0) == words[j].charAt(1) && words[i].charAt(1) == words[j].charAt(0) && i != j) {
                    ans += 2;
                    words[i] = words[i] + "1";
                    words[j] = words[j] + "1";
                    break;
                }
            }

            // 必须是长度为2的才进行查找
            if (words[i].length() != 2) { continue; }

            // 位于中间位置的只能存在一个, 修改字符串长度
            if (words[i].charAt(0) ==  words[i].charAt(1) && flag == 0) {
                ans ++;
                flag = 1;
                words[i] = words[i] + "1";
            }
        }
        return ans * 2;
    }

    public int longestPalindrome(String[] words) {
        // 回文字符串的长度
        int ans = 0;
        // 字符串中单词个数为偶数时就是false 奇数时就是true
        boolean flag = false;
        Map<String, Integer> map = new HashMap<>();

        // 将所有单词都存储到map中
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        // 遍历hashmap
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String key = entry.getKey();
            int count = entry.getValue();
            // 获取单词的反序
            String reKey = "" + key.charAt(1) + key.charAt(0);
            // 如何key单词是前后相同的，并且多出一个，那么构成这个回文字符串的单词必定为奇数
            if (key.equals(reKey)) {
                if (count % 2 == 1) {
                    flag = true;
                }
                // 这里除以2的目的主要是为了去掉奇数的影响
                ans += (count / 2) * 4;
                //key.compareTo(reKey) > 0 的作用是防止重复使用map中的元素
            } else if (key.compareTo(reKey) > 0) {
                ans += Math.min(map.getOrDefault(reKey, 0), count) * 4;
            }
        }
        if (flag) {
            ans += 2;
        }
        return ans;
    }

    public static void main(String[] args) {
        int i = new Algorithm_2131_LeetCode().longestPalindrome(new String[]{"dd", "aa", "bb", "dd", "aa", "dd", "bb", "dd", "aa", "cc", "bb", "cc", "dd", "cc"});
        System.out.println(i);
    }
}
