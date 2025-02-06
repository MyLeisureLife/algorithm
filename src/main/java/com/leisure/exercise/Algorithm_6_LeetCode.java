package com.leisure.exercise;

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
     * 时间复杂度O（n * numRows） 空间复杂度（n * numRows）
     *
     * 缺点：占用大量的未使用空间，导致内存的浪费
     *
     * @param s 字符串
     * @param numRows 行数
     * @return 结果
     */
    public static String myConvert1(String s, int numRows) {
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

    /**
     * 解题思路：使用StringBuffer来去掉重复的空间
     * 时间复杂度O（n） 空间复杂度O（n）
     * @param s 字符串
     * @param numRows 行数
     * @return 结果
     */
    public static String myConvert2(String s, int numRows){
        //边界处理
        if (numRows < 2) { return  s;}
        //设置numRows个StringBuffer
        StringBuffer[] stringBuffers = new StringBuffer[numRows];
        //初始化每个StringBuffer
        for (int i = 0; i < numRows; i++) {
            stringBuffers[i] = new StringBuffer();
        }
        //遍历字符串
        for (int i = 0; i < s.length(); i++) {
            //用于辅助判断存储方式
            int j = i % (numRows - 1);
            int m = i / (numRows - 1);

            if (m % 2 == 0){
                //从上到下的方法存储
                stringBuffers[j].append(s.charAt(i));
            }else {
                //从下到上的方式存储
                stringBuffers[numRows - 1 - j].append(s.charAt(i));
            }

        }

        //将全部类容存储到stringBuffers[0]上，然后用于输出结果
        for (int i = 1; i < numRows; i++) {
            stringBuffers[0].append(stringBuffers[i].toString());
        }

        return stringBuffers[0].toString();
    }

    /**
     * 使用寻找特殊规律的方式来求解，可以降低空间复杂度。
     * 时间复杂度：O(n) 空间复杂度（1）
     * 难点：很难发现数学公式
     * @param s 字符串
     * @param numRows 行数
     * @return 结果
     */
    public static  String convert(String s, int numRows){
        if (numRows == 1 || numRows > s.length()){return s;}

        //循环周期 cyc
        int cyc = 2 * numRows - 2;

        //接受结果
        StringBuilder stringBuffer = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j + i< s.length(); j = j + cyc) {
                stringBuffer.append(s.charAt(i + j));
                // 0 < i && i < (numRows - 1) 这个条件是用于跳出第一行和最后一行的    j + cyc - i < s.length() 这个是用于判断后面是否存在第二个数
                if (0 < i && i < (numRows - 1) && j + cyc - i < s.length()){
                    stringBuffer.append(s.charAt(j + cyc - i));
                }
            }
        }

        return stringBuffer.toString();
    }

    public static void main(String[] args) {
        System.out.println(convert( "123456789", 4));
    }
}

