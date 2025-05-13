package com.leisure.exercise;

/**
 * ClassName: Algorithm_3335_LeetCode
 * Package: com.leisure.exercise
 * Description:
 * 给你一个字符串 s 和一个整数 t，表示要执行的 转换 次数。每次 转换 需要根据以下规则替换字符串 s 中的每个字符：
 * 如果字符是 'z'，则将其替换为字符串 "ab"。
 * 否则，将其替换为字母表中的下一个字符。例如，'a' 替换为 'b'，'b' 替换为 'c'，依此类推。
 * 返回 恰好 执行 t 次转换后得到的字符串的 长度。
 * 由于答案可能非常大，返回其对 109 + 7 取余的结果。
 *
 * @Author: MyLeisureLife
 * @Date: 2025/5/13:10:33:50 星期二
 */
public class Algorithm_3335_LeetCode {

    public static int MOD = 1000000007;

    public int lengthAfterTransformations(String s, int t) {

        // 用于存放二十六个字母出现的次数
        int[] counts = new int[26];

        // 记录字母出现次数， counts[0] 代表的字母a出现的次数，以此类推
        for (int i = 0; i < s.length(); i++) {
            counts[s.charAt(i) - 'a']++;
        }

        // 开始执行t次转换
        for (int i = 0; i < t; i++) {
            // 临时数组记录每次转换的数据
            int[] temp = new int[26];
            // 相当于字母z转换一次变成了字母a
            temp[0] =  counts[25];
            // 字母b 可以由字母a 和 字母z转换一次得到, 这里需要取模 不然数据量太大了int类型存不了
            temp[1] = (counts[0] + counts[25]) % MOD;
            // 其他字母不需要做特殊处理
            for (int j = 2; j < 26; j++) {
                temp[j] = counts[j - 1];
            }
            counts = temp;
        }

        // 现在将所有字母出现的个数全部相加 然后取模就可以了
        int ans = 0;
        for (int count : counts) {
            ans = (count + ans) % MOD;
        }

        return ans;
    }

    public static void main(String[] args) {
        int jqktcurgdvlibczdsvnsg = new Algorithm_3335_LeetCode().lengthAfterTransformations("jqktcurgdvlibczdsvnsg", 7517);
        System.out.println(jqktcurgdvlibczdsvnsg);
    }
}
