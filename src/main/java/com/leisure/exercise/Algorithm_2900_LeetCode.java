package com.leisure.exercise;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: Algorithm_2900_LeetCode
 * Package: com.leisure.exercise
 * Description:
 *给你一个字符串数组 words，长度为 n。
 * 给你一个同样长度的二进制数组 groups，groups[i] 只会是 0 或 1。
 * 你要从 words 中选出若干个（顺序不变，但可以跳过）组成一个子序列，使得对于这个 子序列里任何相邻的两个字符串，它们在 groups 里的值必须不同（即不能出现连续的 0 或连续的 1）。
 * 你要让这个子序列尽量长。
 * 最后返回：用选出来的下标依次去 words 取字符串，拼成的结果数组。
 *
 * @Author: MyLeisureLife
 * @Date: 2025/5/15:11:13:42 星期四
 */
public class Algorithm_2900_LeetCode {
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        List<String> ans = new ArrayList<String>();
        int bit = -1;
        for (int i = 0; i < words.length; i++){
            if (groups[i] != bit){
                bit = groups[i];
                ans.add(words[i]);
            }
        }
        return ans;
    }
}
