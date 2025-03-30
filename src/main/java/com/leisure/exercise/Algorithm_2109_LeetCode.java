package com.leisure.exercise;

import java.util.LinkedList;

/**
 * ClassName: Algorithm_2109_LeetCode
 * Package: com.leisure.exercise
 * Description:
 * 给你一个下标从 0 开始的字符串 s ，以及一个下标从 0 开始的整数数组 spaces
 * 数组 spaces 描述原字符串中需要添加空格的下标。每个空格都应该插入到给定索引处的字符值 之前 。
 * 例如，s = "EnjoyYourCoffee" 且 spaces = [5, 9] ，那么我们需要在 'Y' 和 'C' 之前添加空格，这两个字符分别位于下标 5 和下标 9 。因此，最终得到 "Enjoy Your Coffee" 。
 * 请你添加空格，并返回修改后的字符串。
 *
 * @Author: MyLeisureLife
 * @Date: 2025/3/30:09:45:38 星期日
 */
public class Algorithm_2109_LeetCode {
    public String addSpaces(String s, int[] spaces) {
        // 创建一个可以扩充的字符串
        StringBuilder sb = new StringBuilder();

        // 将字符串重新装入这个可以扩充的字符串中
        for (int i = 0, j = 0; i < s.length(); i++) {
            // 当满足需要插入空格时，就直接插入空格
            if ( j < spaces.length && spaces[j] == i) {
                sb.append(" ");
                j++;
            }
            sb.append(s.charAt(i));
        }

        return sb.toString();
    }
}
