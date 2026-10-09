package com.leisure.exercise;

/**
 * ClassName: Algorithm_1541_LeetCode
 * Package: com.leisure.exercise
 * Description:
 *
 * @Author: MyLeisureLife
 * @Date: 2026/10/9:10:21:14 星期五
 */
public class Algorithm_1541_LeetCode {
    public int minInsertions(String s) {
        int leftNumber = 0;
        int rightNumber = 0;
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                leftNumber++;
            }else if (i + 1 < s.length() && s.charAt(i) == ')' && s.charAt(i + 1) == ')') {
                rightNumber++;
                i++;
            } else if (i + 1 < s.length() && s.charAt(i) == ')' && s.charAt(i + 1) == '(') {
                ans++;
                rightNumber++;
            }else if (i == s.length() - 1 && s.charAt(i) == ')') {
                ans++;
                rightNumber++;
            }
            if (leftNumber < rightNumber) {
                ans++;
                rightNumber--;
            }
        }
        return (leftNumber - rightNumber) * 2 + ans;
    }

    public static void main(String[] args) {
        int i = new Algorithm_1541_LeetCode().minInsertions("(((()(()((())))(((()())))()())))(((()(()()((()()))");
        System.out.println(i);
    }
}
