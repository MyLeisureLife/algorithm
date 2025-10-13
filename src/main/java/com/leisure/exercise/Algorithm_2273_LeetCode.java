package com.leisure.exercise;

import sun.applet.Main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * ClassName: Algorithm_2273_LeetCode
 * Package: com.leisure.exercise
 * Description:给你一个下标从 0 开始的字符串 words ，其中 words[i] 由小写英文字符组成。
 * 在一步操作中，需要选出任一下标 i ，从 words 中 删除 words[i] 。其中下标 i 需要同时满足下述两个条件：
 * 0 < i < words.length
 * words[i - 1] 和 words[i] 是 字母异位词 。
 * 只要可以选出满足条件的下标，就一直执行这个操作。
 * 在执行所有操作后，返回 words 。可以证明，按任意顺序为每步操作选择下标都会得到相同的结果。
 * 字母异位词 是由重新排列源单词的字母得到的一个新单词，所有源单词中的字母通常恰好只用一次。例如，"dacb" 是 "abdc" 的一个字母异位词。
 *
 * @Author: MyLeisureLife
 * @Date: 2025/10/13:17:12:36 星期一
 */
public class Algorithm_2273_LeetCode {
    public List<String> removeAnagrams(String[] words) {
        List<String> result = new ArrayList<String>();
        if ( words.length == 1) {
            result.add(words[0]);
            return result;
        }
        for (int i = 0; i < words.length - 1; i++) {
            // 如果是Anagram就直接添加
            if (isAnagram(words[i], words[i + 1]) ) {
                // 如果是还需要再次过滤一次，和前面的对比不能是Anagram
                if (!result.isEmpty() && isAnagram(result.get(result.size() - 1), words[i])) {
                    continue;
                }
                result.add(words[i]);
            }else if (!result.isEmpty() &&! isAnagram(result.get(result.size() - 1), words[i])) {
                result.add(words[i]);
            }else if (result.isEmpty()) {
                result.add(words[i]);
            }
        }
        if (! isAnagram(result.get(result.size() - 1), words[words.length - 1])) {
            result.add(words[words.length - 1]);
        }
        return result;
    }

    /**
     *  解决方法使用集合存储元素，如果元素存在直接删除，到最后删除完了后为0就行了
     *  可以直接排序后，在进行比较
     * @param s 字符串
     * @param t 字符串
     * @return true 就是相同字符串不同顺序
     *
     */
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        char[] charArray = s.toCharArray();
        char[] charArray1 = t.toCharArray();
        Arrays.sort(charArray);
        Arrays.sort(charArray1);
        for (int i = 0; i < s.length(); i++) {
            if (charArray[i] != charArray1[i]) return false;
        }
        return true;
    }





    public static void main(String[] args) {
        System.out.println(new Algorithm_2273_LeetCode().removeAnagrams(new String[]{"abababaab"}));


    }
}
