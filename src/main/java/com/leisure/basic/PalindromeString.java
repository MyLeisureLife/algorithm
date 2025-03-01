package com.leisure.basic;

/**
 * ClassName: PalindromeString
 * Package: com.leisure.basic
 * Description: 本类实现回文串的一系列计算。
 *
 * @Author: MyLeisureLife
 * @Date: 2025/3/1:22:41:44 星期六
 */
public class PalindromeString {
    /**
     * 判断字符串是否是回文字符串
     * @param str 需要判断的字符串
     * @return false 不是回文字符串  true 是回文字符串
     */
    public static boolean isPalindromeString(String str) {
        for (int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(str.length() - 1 - i)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
