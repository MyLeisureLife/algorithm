package com.leisure.exercise;

import java.util.*;

/**
 * ClassName: Algorithm_20_LeetCode
 * Package: com.leisure.exercise
 * Description:
 *
 * @Author: MyLeisureLife
 * @Date: 2026/10/1:13:32:53 星期四
 */
public class Algorithm_20_LeetCode {
    public boolean isValid(String s){
        int n = s.length();
        if(s.length() % 2 == 1) return false;
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            // 当找到右括号时提出和栈顶比对
            if (map.containsKey(ch)) {
                // 匹配不成功就直接返回false
                if(stack.peek() != map.get(ch)) return false;
                // 出栈
                stack.pop();
            // 当找到左括号时存放
            }else{
                // 将左括号全部放到栈中去
                stack.push(ch);
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        boolean valid = new Algorithm_20_LeetCode().isValid("([)]");
        System.out.println(valid);
    }
}
