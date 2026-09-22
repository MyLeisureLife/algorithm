package com.leisure.exercise;

/**
 * ClassName: Algorithm_28_LeetCode
 * Package: com.leisure.exercise
 * Description:
 *
 * @Author: MyLeisureLife
 * @Date: 2026/9/22:19:50:13 星期二
 */
public class Algorithm_28_LeetCode {

    public int strStr(String haystack, String needle) {
        if (haystack.length() < needle.length()){return -1;}
        int ans;
        for (int i = 0; i < haystack.length(); i++) {
            ans = 0;
            for (int j = 0; j < needle.length(); j++) {
                if(j + i >= haystack.length()){
                    break;
                }
                if(haystack.charAt(j + i) != needle.charAt(j)) {
                    break;
                }
                ans ++;
            }
            if (ans == needle.length()){
                return i;
            }

        }
        return -1;
    }

    public static void main(String[] args) {
        Algorithm_28_LeetCode obj = new Algorithm_28_LeetCode();
        System.out.println(obj.strStr("mississippi", "issipi"));
    }

}
