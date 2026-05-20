package com.leisure.exercise;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * ClassName: Algorithm_LeetCode_2657
 * Package: com.leisure.exercise
 * Description:2657. 找到两个数组的前缀公共数组
 *
 * @Author: MyLeisureLife
 * @Date: 2026/5/20:17:53:53 星期三
 */
public class Algorithm_LeetCode_2657 {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        Set<Integer> setA = new HashSet<>();
        Set<Integer> setB = new HashSet<>();
        int[] result = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            setA.add(A[i]);
            setB.add(B[i]);
            if (i > 0){
                result[i] = result[i - 1];
            }
            if (A[i] == B[i]) {
                result[i] ++ ;
                continue;
            }
            if (setA.contains(B[i])) {
                result[i] ++;
            }
            if (setB.contains(A[i])) {
                result[i] ++;
            }

        }
        return result;
    }
}
