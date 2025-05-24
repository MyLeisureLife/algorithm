package com.leisure.exercise;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: Algorithm_2942_LeetCode
 * Package: com.leisure.exercise
 * Description:
 *给你一个下标从 0 开始的字符串数组 words 和一个字符 x 。
 * 请你返回一个 下标数组 ，表示下标在数组中对应的单词包含字符 x 。
 * 注意 ，返回的数组可以是 任意 顺序。
 * 1 <= words.length <= 50
 * 1 <= words[i].length <= 50
 * x 是一个小写英文字母。
 * words[i] 只包含小写英文字母。
 * @Author: MyLeisureLife
 * @Date: 2025/5/24:19:51:24 星期六
 */
public class Algorithm_2942_LeetCode {
    public List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < words.length; i++){
            for (int j = 0; j < words[i].length(); j++){
                if (words[i].charAt(j) == x){
                    list.add(i);
                    break;
                }
            }
        }
        return list;
    }
}
