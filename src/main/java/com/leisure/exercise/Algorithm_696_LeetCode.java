package com.leisure.exercise;

/**
 * ClassName: Algorithm_696_LeetCode
 * Package: com.leisure.exercise
 * Description:
 * 给定一个字符串 s，统计并返回具有相同数量 0 和 1 的非空（连续）子字符串的数量，
 * 并且这些子字符串中的所有 0 和所有 1 都是成组连续的。
 * 重复出现（不同位置）的子串也要统计它们出现的次数。
 * 1 <= s.length <= 105
 * s[i] 为 '0' 或 '1'
 * @Author: MyLeisureLife
 * @Date: 2026/2/19:09:16:59 星期四
 */
public class Algorithm_696_LeetCode {
    /**
     * 时间复杂度O(n)  空间复杂度O(1)
     * @param s 字符串
     * @return 满足条件的子字符串数量
     */
    public int countBinarySubstrings(String s) {
        int ans = 0;
        int l;
        int r;
        for (int i = 0; i < s.length() - 1; i = r) {
            l = i;
            r = i + 1;
            char a = s.charAt(l);
            char b = s.charAt(r);
            while(s.charAt(l) == a && s.charAt(r) == b && s.charAt(l) + s.charAt(r)  ==  '1' + '0'){
                ans ++;
                l --;
                r ++;
                if(l == -1 || r == s.length()) break;
            }
            if( r != i + 1) r --;

        }
        return ans;
    }

    /**
     * 需要优化想法
     * 时间复杂度O(n) 空间复杂度O(1)
     * @param s 字符串
     * @return 符合条件的子字符串数量
     */
    public int countBinarySubstrings2(String s) {
        int ans = 0;
        int pre = 0; // 之前相同个数
        int cur = 1; // 当前相同的个数
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                cur++;
            }else {
                // 前面相同和后面相同取最小的就是答案个数，00111 这个pre为2 cur：3 ans = 2
                ans += Math.min(pre, cur);
                pre = cur; // 将当前相同的赋予给前面的一个
                cur = 1; // 当前相同的默认有一个
            }
        }
        // 最后一次还需要计算一次，因为循环最后一次不一定会进入到else中
        return ans + Math.min(pre, cur);
    }



    public static void main(String[] args) {
        int i = new Algorithm_696_LeetCode().countBinarySubstrings2("00110011");
        System.out.println(i);
    }
}
