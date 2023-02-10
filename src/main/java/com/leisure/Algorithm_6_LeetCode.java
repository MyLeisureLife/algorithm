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
        if (numRows < 3) { return  s;}
        //创建模型
        boolean[][] mode = new boolean[numRows][numRows - 1];
        for (int i = 0; i < numRows; i++) {
            mode[i][0] = true;
            for (int j = i; j < numRows - 1; j++) {
                if (i == j){
                    mode[i][j] = true;
                }
            }
        }
        char[][] chars = new char[numRows][s.length()];
        // 用于循环整个字符串
        int i = 0;
        //用于判读是否超出了模型的列
        int col = 0;
        //使用模型填充字符
        while (i < chars.length){
            if (col == numRows - 1) { col = 0;}
            for (int j = 0; j < numRows; j++) {
                if (mode[j][0]){
                    chars[j][0] = s.charAt(i);
                    i ++;
                }
            }
            col ++;
        }

        for (char[] a: chars) {
            for (char b : a) {
                if (b != 0){
                    System.out.print(b);
                }
            }
        }

        return "";
    }

    public static void main(String[] args) {
        convert( "123456789", 4);
    }
}

