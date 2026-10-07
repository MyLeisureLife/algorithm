package com.leisure.exercise;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: Algorithm_301_LeetCode
 * Package: com.leisure.exercise
 * Description:
 *
 * @Author: MyLeisureLife
 * @Date: 2026/10/7:11:34:25 星期三
 */
public class Algorithm_301_LeetCode {
    private List<String> res = new ArrayList<>();

    public List<String> removeInvalidParentheses(String s) {
        int lRemove = 0;
        int rRemove = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                lRemove++;
            }else if (s.charAt(i) == ')') {
                if (lRemove == 0) {
                    rRemove++;
                }else {
                    lRemove--;
                }
            }
        }
        helper(s, 0, lRemove, rRemove);
        return res;
    }

    private void helper(String s, int start, int lRemove, int rRemove) {
        if (lRemove == 0 && rRemove == 0) {
            if(isValid(s)){
                res.add(s);
            }
            return;
        }
        // 从i位置开始删除
        for (int i = start; i < s.length(); i++) {
            // 如果要删除的位置和上一次删除的元素相同就没有必要删除了, 如果是第一次执行就没必要判断了
            if (i != start && s.charAt(i) == s.charAt(i - 1)) {
                continue;
            }
            // 如果剩余的字符串不足以满足删除数量时，直接返回
            if(lRemove + rRemove > s.length() - i){
                return;
            }
            // 删除i位置的子字符串
            String s1 = s.substring(0, i) + s.substring(i + 1);
            // 尝试去掉一个左括号
            if(lRemove > 0 && s.charAt(i) == '('){
                helper(s1, i, lRemove - 1, rRemove);
            }
            // 尝试去掉一个右括号
            if (rRemove > 0 && s.charAt(i) == ')'){
                helper(s1, i, lRemove, rRemove - 1);
            }
        }
    }

    private boolean isValid(String s) {
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                cnt++;
            }else if (s.charAt(i) == ')') {
                cnt--;
                if (cnt < 0) {
                    return false;
                }
            }
        }
        return cnt == 0;
    }

    public static void main(String[] args) {
        List<String> strings = new Algorithm_301_LeetCode().removeInvalidParentheses("(()()()");
        System.out.println(strings.toString());
    }
}
