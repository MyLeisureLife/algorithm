package com.leisure.exercise;

import javax.security.auth.login.Configuration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * ClassName: Algorithm_2094_LeetCode
 * Package: com.leisure.exercise
 * Description:
 *给你一个整数数组 digits ，其中每个元素是一个数字（0 - 9）。数组中可能存在重复元素。
 * 你需要找出 所有 满足下述条件且 互不相同 的整数：
 * 该整数由 digits 中的三个元素按 任意 顺序 依次连接 组成。
 * 该整数不含 前导零
 * 该整数是一个 偶数
 * 例如，给定的 digits 是 [1, 2, 3] ，整数 132 和 312 满足上面列出的全部条件。
 * 将找出的所有互不相同的整数按 递增顺序 排列，并以数组形式返回。
 * @Author: MyLeisureLife
 * @Date: 2025/5/12:11:29:37 星期一
 */
public class Algorithm_2094_LeetCode {
    public int[] findEvenNumbers(int[] digits) {
        Set<Integer> set = new HashSet<Integer>();
        int sum = 0;
        for (int i = 0; i < digits.length; i++) {
            for (int j = 0; j < digits.length; j++) {
                for (int k = 0; k < digits.length; k++) {
                    if (i == j || j == k || i == k) {
                        continue;
                    }
                    sum = digits[i] * 100 + digits[j] * 10 + digits[k];
                    if (sum % 2 == 0 && sum >= 100) {
                        set.add(sum);
                    }
                }
            }
        }

        ArrayList<Integer> list = new ArrayList<Integer>(set);
        Collections.sort(list);

        int[] res = new int[set.size()];
        for (int i = 0; i < set.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
