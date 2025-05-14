package com.leisure.exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ClassName: Algorithm_3337_LeetCode
 * Package: com.leisure.exercise
 * Description:
 * 给你一个由小写英文字母组成的字符串 s，一个整数 t 表示要执行的 转换 次数，以及一个长度为 26 的数组 nums。每次 转换 需要根据以下规则替换字符串 s 中的每个字符：
 * 将 s[i] 替换为字母表中后续的 nums[s[i] - 'a'] 个连续字符。例如，如果 s[i] = 'a' 且 nums[0] = 3，则字符 'a' 转换为它后面的 3 个连续字符，结果为 "bcd"。
 * 如果转换超过了 'z'，则 回绕 到字母表的开头。例如，如果 s[i] = 'y' 且 nums[24] = 3，则字符 'y' 转换为它后面的 3 个连续字符，结果为 "zab"。
 * 返回 恰好 执行 t 次转换后得到的字符串的 长度。
 * 由于答案可能非常大，返回其对 109 + 7 取余的结果。
 *
 *
 * @Author: MyLeisureLife
 * @Date: 2025/5/14:10:35:55 星期三
 */
public class Algorithm_3337_LeetCode {
    public static final int MOD = 1000000007;
    public int lengthAfterTransformations(String s, int t, List<Integer> nums) {
        // 先试用一个长度为26的数组存储初始字母个数
        int[] count = new int[26];
        for (char c : s.toCharArray()) count[c - 'a']++;

        // 处理转换次数
        for (int i = 0; i <t; i++) {
            // 创建一个临时数组存放每次转换后的数据
            int[] temp = new int[26];

            // 转换时需要对每个字母单独处理下
            for (int j = 0; j < 26; j++) {
                // 没有数组需要增加多长
                for (int k = 0; k < nums.get(j) && count[j] > 0; k++) {
                    int n = (j + k + 1) % 26;
                    temp[n] = (count[j] + temp[n]) % MOD;
                }
            }
            // 将转换一次后的数据保存，然后再次进行转换
            count = temp;
        }

        int ans = 0;
        for (int j : count) {
            ans = (j + ans) % MOD;
        }

        return ans;
    }

    public static void main(String[] args) {
        ArrayList<Integer> integers = new ArrayList<Integer>();
        integers.add(1);
        integers.add(2);
        integers.add(3);
        integers.add(1);
        integers.add(1);
        integers.add(1);

        integers.add(1);
        integers.add(1);
        integers.add(1);
        integers.add(1);
        integers.add(1);
        integers.add(1);
        integers.add(1);
        integers.add(1);
        integers.add(1);
        integers.add(1);
        integers.add(1);
        integers.add(1);
        integers.add(1);
        integers.add(1);
        integers.add(1);
        integers.add(1);
        integers.add(1);
        integers.add(1);
        integers.add(1);
        integers.add(2);
        int qwe = new Algorithm_3337_LeetCode().lengthAfterTransformations("zz", 2, integers);
        System.out.println(qwe);
    }
}
