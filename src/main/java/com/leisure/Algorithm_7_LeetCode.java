package com.leisure;

/**
 * Author: leisure1456
 * Date: 2023/2/20:12:14:24 星期一
 *
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 *
 * 如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
 *
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 */
public class Algorithm_7_LeetCode {

    public static int reverse(int x) {

        //存放结果
        String s = Integer.toString(x);
        StringBuffer reS = new StringBuffer();
        //商
        for (int i = s.length() - 1 ; i >= 0; i--) {
            reS.append(s.charAt(i));
        }
        s = reS.toString();



        if (isAMax(s)) {


            int integer;
            if (x < 0) {
                integer = Integer.parseInt(s.substring(0, s.length() - 1));
                integer = -integer;

            }else {
                integer = Integer.parseInt(s.substring(0, s.length()));
            }
            return integer;

        }else {
            return 0;
        }
    }

    public static boolean isAMax(String a){
        String max = String.valueOf((int)(Math.pow(2,31) - 1));
        String min = String.valueOf((int)Math.pow(2,31));
        if (a.length() < max.length()){
            return true;
        }

        if (a.charAt(a.length() - 1) == '-'){
            for (int i = 0; i < a.length() - 1; i++) {
                int aInt = Integer.parseInt(String.valueOf(a.charAt(i)));
                int bInt = Integer.parseInt(String.valueOf(min.charAt(i)));
                if (aInt == bInt){
                    continue;
                }
                if (i == a.length() -1){return true;}
                return aInt < bInt;
            }
        }else {
            for (int i = 0; i < a.length(); i++) {
                int aInt = Integer.parseInt(String.valueOf(a.charAt(i)));
                int bInt = Integer.parseInt(String.valueOf(max.charAt(i)));
                if (aInt == bInt){
                    continue;
                }
                if (i == a.length() -1){return true;}
                return aInt < bInt;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        reverse(-214748364);
    }
}
