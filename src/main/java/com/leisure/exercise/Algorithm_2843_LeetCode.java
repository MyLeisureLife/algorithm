package com.leisure.exercise;

/**
 * ClassName: Algorithm_2843_LeetCode
 * Package: com.leisure.exercise
 * Description: 使用的是枚举法
 *给你两个正整数 low 和 high 。
 * 对于一个由 2 * n 位数字组成的整数 x ，如果其前 n 位数字之和与后 n 位数字之和相等，则认为这个数字是一个对称整数。
 * 返回在 [low, high] 范围内的 对称整数的数目 。
 * @Author: MyLeisureLife
 * @Date: 2025/4/11:16:47:06 星期五
 */
public class Algorithm_2843_LeetCode {
    public int countSymmetricIntegers(int low, int high) {
        int ans = 0;
        for (int i = low; i <= high; i++){
            String str = Integer.toString(i);
            if (str.length() % 2 == 0 && i != 0){
                // 遍历计算前半部分 和 后半部分
                int left = 0, right = 0;
                for (int j = 0; j < str.length() / 2; j++){
                    left = str.charAt(j) - '0' + left;
                }
                for (int j = str.length() / 2; j < str.length(); j++){
                    right = str.charAt(j) - '0' + right;
                }
                if (left == right){
                    ans++;
                }
            }

        }
        return ans;
    }

    public static void main(String[] args) {
        int i = new Algorithm_2843_LeetCode().countSymmetricIntegers(1203, 1203);
        System.out.println(i);
    }
}
