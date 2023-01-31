package com.leisure;


import java.util.HashMap;
import java.util.Map;

/**
 * Author: leisure1456
 * Date: 2023/1/31:10:16:52 星期二
 *
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 提示：
 * 0 <= s.length <= 5 * 104
 * s 由英文字母、数字、符号和空格组成
 */
public class Algorithm_3_LeetCode {
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

    /**
     * LeetCode  算符
     * @param s 字符串
     * @return 最长字符长度
     */
    public static int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        //用于记录字符再那个位置出现了，使用0开始记录
        int[] arr = new int[128];
        //最开始的字符都是没有出现过的，使用-1进行赋值
        for(int i = 0; i < s.length(); i++){
            arr[s.charAt(i)] = -1;
        }
        //子串最大长度
        int maxLen = 1;
        //当字符所在子串前长度 current Length
        int curLen = 0;
        //以前重复下标  Previous Index
        int preIndex = -1;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            //最大的 已经出现过的字符位置 只要 arr[c] 不是-1 是其他值就表示这个字符在那个位置出现过了
            preIndex = Math.max(arr[c],preIndex);
            // 当前字符串不重复的长度 =  当前字符串长度 - 已经出现过字符
            curLen = i - preIndex;
            maxLen = Math.max(curLen,maxLen);

            arr[c] = i;
        }
        return maxLen;
    }

    /**
     * 根据LeetCode中的算法自己实现
     * @param s 字符串
     * @return 最长字符串
     */
    public static int MyLengthOfLongestSubstringLeetCode(String s){
        // 判断特殊情况 字符串为空或者长度为0
        if (s == null || s.length() ==0){
            return 0;
        }
        // 用于存放字符出现在字符串中的位置，开始位置从0开始。 当存放-1时表示字符还没有出现过。
        int[] chars = new int[128];

        char[] arr = s.toCharArray();
        // 将字符全部设置为没有出现过，将字符转换为对应的ASCII码存储
        for (int i = 0; i < s.length(); i++) {
            chars[s.charAt(i)] = -1;
        }

        //当前字符的最长不重复字符串长度
        int curLength = 0;
        //所有字符中的最长不重复字符串的长度
        int maxLength = 1;
        //前面字符出现最长的地方.最开始的字符都没有出现过所以赋值为-1
        int preLength = -1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            //获取最大的字符出现位置
            preLength = Math.max(chars[c], preLength);
            //记录当前字符出现的位置
            chars[c] = i;
            //字符最长不重复字符串长度 = 字符串长度 - 重复出现字符长度
            curLength = i - preLength;
            maxLength = Math.max(curLength, maxLength);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(MyLengthOfLongestSubstringLeetCode("1212ab123"));
    }
}
