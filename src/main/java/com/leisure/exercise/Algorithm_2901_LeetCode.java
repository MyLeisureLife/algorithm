package com.leisure.exercise;

import java.util.*;

/**
 * ClassName: Algorithm_2901_LeetCode
 * Package: com.leisure.exercise
 * Description:
 *给你一个整数 n 和一个下标从 0 开始的字符串数组 words ，和一个下标从 0 开始的数组 groups ，两个数组长度都是 n 。
 * 两个长度相等字符串的 汉明距离 定义为对应位置字符 不同 的数目。
 * 你需要从下标 [0, 1, ..., n - 1] 中选出一个 最长子序列 ，将这个子序列记作长度为 k 的 [i0, i1, ..., ik - 1] ，它需要满足以下条件：
 * 相邻 下标对应的 groups 值 不同。即，对于所有满足 0 < j + 1 < k 的 j 都有 groups[ij] != groups[ij + 1] 。
 * 对于所有 0 < j + 1 < k 的下标 j ，都满足 words[ij] 和 words[ij + 1] 的长度 相等 ，且两个字符串之间的 汉明距离 为 1 。
 * 请你返回一个字符串数组，它是下标子序列 依次 对应 words 数组中的字符串连接形成的字符串数组。如果有多个答案，返回任意一个。
 * 子序列 指的是从原数组中删掉一些（也可能一个也不删掉）元素，剩余元素不改变相对位置得到的新的数组。
 * 注意：words 中的字符串长度可能 不相等 。
 * @Author: MyLeisureLife
 * @Date: 2025/5/16:11:10:44 星期五
 */
public class Algorithm_2901_LeetCode {
    public List<String> getWordsInLongestSubsequence(String[] words, int[] groups) {
        int n = words.length;
        // 该数组存以当前下标为结尾的最长子字符串个数
        int[] count = new int[n];
        // 记录以当前为下标结尾的最长子字符串的前一个字符下标
        int[] prev = new int[n];
        // 以当前下标为结尾的最长子字符串最小都是1
        Arrays.fill(count, 1);
        // 以当前下标为结尾的最长字符串的前一个字符下面最开始是没有的设置成-1
        Arrays.fill(prev, -1);
        //记录最长子字符串在那个坐标上
        int maxIndex = 0;
        // i = 1 因为以第一个为结尾的最长子字符串 长度一定是1,所以我们直接找第二个
        for (int i = 1; i < n; i++) {
            // i前面所有的数据都要确定一遍
            for (int j = 0; j < i; j++) {
                // count[j] + 1 > count[i] 表示：你找到的最长子字符串一定要比你上次找到的长才行
                if (isDifferenceOfOne(words[i], words[j]) && groups[i] != groups[j] && count[j] + 1 > count[i]) {
                    // 找到比上次长的以后就可以进行赋值，并记录最长子字符串的上一个坐标
                    count[i] = count[j] + 1;
                    prev[i] = j;
                }
            }
            // 判断当前算出来的坐标是不是最长子字符串的坐标，是就记录下来
            if (count[i] > count[maxIndex]) {
                maxIndex = i;
            }
        }

        // 现在已经知道了最长子字符串的坐标了，就可以逆推回去了
        List<String> list = new ArrayList<String>();
        while (maxIndex != -1) {
            list.add(words[maxIndex]);
            maxIndex = prev[maxIndex];
        }
        // 需要将集合顺序倒转下
        Collections.reverse(list);
        return list;

    }

    /**
     * 判断 ab 是不是 汉明距离 为 1
     * @param a 字符串
     * @param b 字符串
     * @return false 相差不为 1  ture：相差为1
     */
    public static boolean isDifferenceOfOne( String a, String b ) {
        if (a.length() != b.length()) return false;
        int sum = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) sum++;

        }
        return sum == 1;
    }

    public static void main(String[] args) {

    }
}
