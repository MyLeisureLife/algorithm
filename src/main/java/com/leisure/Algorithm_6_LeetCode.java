package com.leisure;

/**
 * Author: leisure1456
 * Date: 2023/2/10:12:28:29 星期五
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 *
 * 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
 *
 * 请你实现这个将字符串进行指定行数变换的函数：
 *
 * string convert(string s, int numRows);
 *
 */
public class Algorithm_6_LeetCode {
    /**
     * 使用模型的方式来实现则会个方法
     *
     * @param s
     * @param numRows
     * @return
     */
    public static String convert(String s, int numRows) {
        //边界处理
        if (numRows < 2) { return  s;}
        //创建模型
        char[][] mode = new char[numRows][s.length()];
        int a = 0;
        for (int i = 0; i < mode[0].length; i++) {
            for (int j = 0; j < numRows; j++) {
                if ((i % (numRows - 1) + j) == (numRows - 1) || i % (numRows - 1) == 0){
                    if (a < s.length()){
                        mode[j][i] = s.charAt(a);
                        a ++;
                    }
                }
            }
        }
        StringBuffer a1 = new StringBuffer();
        for (char[] c: mode) {
            for (char b : c) {
                if (b != 0){
                    a1.append(b);
                }
            }
        }

        return a1.toString();
    }

    public static void main(String[] args) {
        System.out.println(convert( "123456789", 4));
    }
}

