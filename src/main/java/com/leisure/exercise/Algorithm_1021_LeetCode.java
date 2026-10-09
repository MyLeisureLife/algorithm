package com.leisure.exercise;

/**
 * ClassName: Algorithm_1021_LeetCode
 * Package: com.leisure.exercise
 * Description:
 *
 * @Author: MyLeisureLife
 * @Date: 2026/10/8:10:14:12 星期四
 */
public class Algorithm_1021_LeetCode {
    public String removeOuterParentheses(String s) {
        StringBuilder ans = new StringBuilder();
        int balance = 0;
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                balance++;
            }else if (s.charAt(i) == ')') {
                balance--;
            }
            if (balance == 0) {
                ans.append(s.substring(start + 1, i));
                start = i + 1;
            }
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        String s = new Algorithm_1021_LeetCode().removeOuterParentheses("(()())(())");
        System.out.println(s);
    }
}
