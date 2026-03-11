package com.leisure.exercise;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * ClassName: Algorithm_1009_LeetCode
 * Package: com.leisure.exercise
 * Description:
 * 每个非负整数 N 都有其二进制表示。例如， 5 可以被表示为二进制 "101"，11 可以用二进制 "1011" 表示，依此类推。注意，除 N = 0 外，任何二进制表示中都不含前导零。
 * 二进制的反码表示是将每个 1 改为 0 且每个 0 变为 1。例如，二进制数 "101" 的二进制反码为 "010"。
 * 给你一个十进制数 N，请你返回其二进制表示的反码所对应的十进制整数。
 * 0 <= N < 10^9
 * @Author: MyLeisureLife
 * @Date: 2026/3/11:11:56:46 星期三
 */
public class Algorithm_1009_LeetCode {
    /**
     * Time Complexity: O(log n) Space Complexity: O(1)
     * @param n 0 <= N < 10^9
     * @return N的二进制反码 表示的十进制数
     */
    public int bitwiseComplement(int n) {
        if(n==0)return 1;
        int ans = 1;
        while(ans <= n){
            ans <<= 1;
        }
        return (ans - 1) ^ n;
    }

    public static void main(String[] args) {
        int i = new Algorithm_1009_LeetCode().bitwiseComplement(1);
        System.out.println(i);
    }
}
