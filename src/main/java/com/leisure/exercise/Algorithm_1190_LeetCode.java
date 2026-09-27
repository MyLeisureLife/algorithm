package com.leisure.exercise;

import javax.xml.stream.events.StartDocument;
import java.sql.PseudoColumnUsage;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * ClassName: Alogrithm_1190_LeetCode
 * Package: com.leisure.exercise
 * Description:
 *
 * @Author: MyLeisureLife
 * @Date: 2026/9/27:13:40:54 星期日
 */
public class Algorithm_1190_LeetCode {
    public String reverseParentheses(String s) {
        Deque<String> stack = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '('){
                //先进后出原则
                stack.push(sb.toString());
                //将sb变成空
                sb.setLength(0);
            }else if (s.charAt(i) == ')'){
                //识别到反转信号,开始反转
                sb.reverse();
                //反转后要将前面的加上方便下次再次进行反转操作
                sb.insert(0, stack.pop());
            }else{
                sb.append(s.charAt(i));
            }

        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = new Algorithm_1190_LeetCode().reverseParentheses("(ed(et(oc))el)");
        System.out.println(s);
    }
}
