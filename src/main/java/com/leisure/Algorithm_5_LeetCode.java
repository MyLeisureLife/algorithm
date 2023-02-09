package com.leisure;

/**
 * Author: leisure1456
 * Date: 2023/2/8:12:27:15 星期三
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 * 如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。
 */
public class Algorithm_5_LeetCode {

    /**
     * 没有简化代码
     * 解释：字符串中的每个回文子字符串都都有一个共同的特点，它是两边对称的，所以可以直接找到对称的中心点。
     * 然后使用两个指针同时向左右两遍移动，只要相等就是回文子串的字符，当不再相等时就不是回文子串字符了。
     * 但是回文子串有两种特殊情况需要考虑。
     * 1、当回文子串的字符个数为单个时，它的中心点就一个字符。
     * 2、当回文子串的字符个数为双数时，它的中心点就是两个字符中间。
     * 所以中心点的个数因该有 2 * s.length - 1
     * @param s 字符串
     * @return 最长回文字符串
     */
    public static String MyLongestPalindrome1(String s) {
        if (s.length() == 0) return "";
        //设置两个指针来记录回文字符串开始位置和结束位置
        int length = 0, startPosition = 0, endPosition = 0;
        //设置一个记录最长回文子串的长度和位置。
        int maxLength = 0, maxStartPosition = 0, maxEndPosition = 0;

        //以字符为中心
        for (int i = 0; i < s.length(); i++) {
            startPosition = i; endPosition = i;
            while (startPosition >= 0 && endPosition < s.length() && s.charAt(startPosition) == s.charAt(endPosition)){
                length = endPosition - startPosition + 1;
                startPosition --;
                endPosition ++;
            }
            if (maxLength < length){
                maxStartPosition = startPosition + 1;
                maxEndPosition = endPosition - 1;
                maxLength = maxEndPosition - maxStartPosition + 1;
            }
        }

        //以两字符为中心
        for (int j = 1; j < s.length(); j++) {
            startPosition = j - 1; endPosition = j;
            while (startPosition >= 0 && endPosition < s.length() && s.charAt(startPosition) == s.charAt(endPosition)){
                length = endPosition - startPosition + 1;
                startPosition --;
                endPosition ++;
            }
            if (maxLength < length){
                maxStartPosition = startPosition + 1;
                maxEndPosition = endPosition - 1;
                maxLength = maxEndPosition - maxStartPosition + 1;
            }

        }
        return s.substring(maxStartPosition, maxEndPosition + 1);
    }


    //设置两个指针来记录回文字符串开始位置和结束位置
    static int length = 0, startPosition = 0, endPosition = 0;
    //设置一个记录最长回文子串的长度和位置。
    static int maxLength = 0, maxStartPosition = 0, maxEndPosition = 0;

    /**
     * 这个算法在leetCode中需要去掉static关键字才能正常运行，不然会提交通不过
     * 这个方法使用的是“中心扩散法”
     * 时间复杂度O(n^2) 空间复杂度(1)
     * 解释：字符串中的每个回文子字符串都都有一个共同的特点，它是两边对称的，所以可以直接找到对称的中心点。
     * 然后使用两个指针同时向左右两遍移动，只要相等就是回文子串的字符，当不再相等时就不是回文子串字符了。
     * 但是回文子串有两种特殊情况需要考虑。
     * 1、当回文子串的字符个数为单个时，它的中心点就一个字符。
     * 2、当回文子串的字符个数为双数时，它的中心点就是两个字符中间。
     * 所以中心点的个数因该有 2 * s.length - 1
     * @param s 字符串
     * @return 最长回文字符串
     */
    public static String MyLongestPalindrome(String s) {
        if (s.length() == 0) return "";
        for (int i = 0; i < s.length(); i++) {
            //以字符为中心
            subChar(i, i, s);
            //以两字符为中心
            subChar(i - 1, i, s);
        }
        return s.substring(maxStartPosition, maxEndPosition + 1);
    }
    public static void subChar(int startPosition, int endPosition, String s){
        while (startPosition >= 0 && endPosition < s.length() && s.charAt(startPosition) == s.charAt(endPosition)){
            length = endPosition - startPosition + 1;
            startPosition --;
            endPosition ++;
        }
        if (maxLength < length){
            maxStartPosition = startPosition + 1;
            maxEndPosition = endPosition - 1;
            maxLength = maxEndPosition - maxStartPosition + 1;
        }
    }

    /**
     * 解释：这个方法使用动态规划的方式来解决。
     * 时间复杂度：O(n^2) 空间复杂度O(n^2)
     * 原理：回文子串去掉前面后后面的字符依然是回文子串
     *      使用一张表格 纵坐标表示回文子串的最左边字符位置，横坐标表示回文字符串最右边的字符位置。
     *      表里面的类型为boolean类型。
     *      纵坐标 和 横坐标相交的位置为true表示 s.substring(纵坐标，横坐标 + 1)的字符串是回文字符串，false就不是回文字符串。
     *      如果要计算 1~3 的字符串是否为回文字符串，我们就只需要知道 [1 + 1， 3-1]的坐标是不是为true就可以了
     *      LeetCode将对角线直接赋值为true，有些影响理解，这里我什么赋值为true，最开始都是false
     *      然后计算[0,1] [1,1] [0, 2] [1 , 2], [2, 2] [0, 3] [1, 3] .....
     *
     * @param s 字符串
     * @return 最长回文子串
     */
    public static String longestPalindrome(String s){
        if (s.length() == 0) return s;
        boolean[][] subPalindrome = new boolean[s.length()][s.length()];
        int maxLength = 0, beginPosition = 0, endPosition = 0;

        for (int col = 0; col <s.length(); col++) {
            for (int row = 0; row <= col; row++) {
                if (row == col ) {
                    subPalindrome[row][col] = true;
                    continue;
                }
                // 这里计算row ~ col 的字符串是否为回文字符串 col - row == 1 这个是为了防止回文子字符串长度为2导致去除两端后找不到对应的坐标来判断
                subPalindrome[row][col] =s.charAt(col) == s.charAt(row) && (col - row == 1 || subPalindrome[row + 1][col - 1]);
            }
        }

        for (int col = 0; col <s.length(); col++) {
            for (int row = 0; row <= col; row++) {
                if (subPalindrome[row][col] && maxLength < col - row + 1){
                    maxLength = col - row + 1;
                    beginPosition = row;
                    endPosition = col;
                }
            }
        }

        return s.substring(beginPosition, endPosition + 1);
    }


    public static void main(String[] args) {
        System.out.println(longestPalindrome(""));

    }
}
