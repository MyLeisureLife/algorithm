package com.leisure.exercise;

/**
 * ClassName: Algorithm_1534_LeetCode
 * Package: com.leisure.exercise
 * Description:
 *
 * @Author: MyLeisureLife
 * @Date: 2025/4/14:16:53:48 星期一
 */
public class Algorithm_1534_LeetCode {
    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                for (int k = j + 1; k < arr.length; k++) {
                    if (Math.abs(arr[i] - arr[j]) <= a && Math.abs(arr[j] - arr[k]) <= b && Math.abs(arr[i] - arr[k]) <= c ) {
                        ans++;
                    }
                }
            }
        }
        return ans;
    }
}
