package org.leisure;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 提示：
 * 0 <= s.length <= 5 * 104
 * s 由英文字母、数字、符号和空格组成
 */
public class ThreeSolution {

    /**
     * 算法出现过的问题: 1、循环使用的变量需要检查清楚。
     *                2、没有考虑到只有一个字符的字符串
     *                3、时间复杂度过高
     * 时间复杂度: O(n^2)  空间复杂度O(∣Σ∣) 所有 ASCII 码在 [0,128) 内的字符，即 ∣Σ∣=128
     * @param s 字符串
     * @return 最长子串的长度
     */
    public static int MyLengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        //使用HashMap来判断是否有相同的字符
        Map<Character, Integer> hash = new HashMap<Character, Integer>();
        int result = 0;
        //使用第一个循环来寻找字符串的起始位置
        for (int i = 0; i < chars.length - result; i++) {
            hash.clear();
            //使用第二个循环来寻找字符串的终止位置
            for (int j = i; j < chars.length; j++) {

                if(hash.containsKey(chars[j])){
                    break;
                }else {
                    hash.put(chars[j],0);
                    if (result < hash.size())  result = hash.size();
                }

            }
        }
        return result;
    }

    public static int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        int startPosition = 0, endPosit = 0; //字符串起始位置  字符结束位置
        Set<Character> set = new HashSet<Character>();
        int result = 0; //返回的长度
        for (int i = 0; i < chars.length; i++) {
            startPosition = i;
            if(set.contains(chars[i])){
                if (result < set.size()) result = set.size();
                
            }else {
                set.add(chars[i]);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        lengthOfLongestSubstring(" ");
    }
}
