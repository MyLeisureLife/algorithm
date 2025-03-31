package com.leisure.exercise;

/**
 * ClassName: Algorithm_2278_LeetCode
 * Package: com.leisure.exercise
 * Description: sameQuantity 的数据类型不能使用float类型，因为精度没有达到 Java 的默认格式化 规则要求， 就会导致精度缺失
 *给你一个字符串 s 和一个字符 letter ，返回在 s 中等于 letter 字符所占的 百分比 ，向下取整到最接近的百分比。
 * @Author: MyLeisureLife 
 * @Date: 2025/3/31:09:56:55 星期一
 *
 */
public class Algorithm_2278_LeetCode {
    public int percentageLetter(String s, char letter) {
        double sameQuantity = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == letter){
                sameQuantity++;
            }
        }
        System.out.println( sameQuantity + "  " +s.length() + " " + sameQuantity / s.length() * 100);
        return (int) (sameQuantity / s.length() * 100);
    }

    public static void main(String[] args) {
        int i = new Algorithm_2278_LeetCode().percentageLetter("vmvvvvvzrvvpvdvvvvyfvdvvvvpkvvbvvkvvfkvvvkvbvvnvvomvzvvvdvvvkvvvvvvvvvlvcvilaqvvhoevvlmvhvkvtgwfvvzy", 'v');
        System.out.println(i);
    }
}
