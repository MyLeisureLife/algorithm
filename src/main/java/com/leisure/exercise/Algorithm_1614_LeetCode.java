package com.leisure.exercise;

/**
 * ClassName: Algorithm_1614_LeetCode
 * Package: com.leisure.exercise
 * Description:
 *
 * @Author: MyLeisureLife
 * @Date: 2026/9/28:16:20:29 星期一
 */
public class Algorithm_1614_LeetCode {
    public int maxDepth(String s) {
        int ans = 0;
        int l = 0;
        int r = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '('){
                l++;
                r--;
            }else if(s.charAt(i) == ')'){
                r++;
                l--;
            }
            ans = Math.max(ans, l);
            ans = Math.max(ans, r);
        }
        return ans;
    }

    public static void main(String[] args) {
        int i = new Algorithm_1614_LeetCode().maxDepth("(1)+((2))+(((3)))");
        System.out.println(i);
    }
}
