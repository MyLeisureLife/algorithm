package com.leisure.exercise;

import java.io.FileReader;

/**
 * ClassName: Algorithm_1390_LeetCode
 * Package: com.leisure.exercise
 * Description:
 * 给你一个整数数组 nums，请你返回该数组中恰有四个因数的这些整数的各因数之和。如果数组中不存在满足题意的整数，则返回 0 。
 * @Author: MyLeisureLife
 * @Date: 2026/1/4:10:31:34 星期日
 */
public class Algorithm_1390_LeetCode {
    /**
     * Brute-Force Algorithm
     * 时间复杂度O(n*m) 空间复杂度O(1) , 1 <= n <= 10^4 , 1 <= m <= 10^5
     * @param nums 1 <= nums.length <= 10^4, 1 <= nums[i] <= 10^5
     * @return 4个约数的和
     */
    public int sumFourDivisors(int[] nums) {
        int sum = 0;
        for (int num : nums){
            // 首先找到4个约数，其中 1 和 它本身不需要寻找
            int secondDivisor = 0, thirdDivisor = 0;
            // 找到约数应该只能找一次，不能找两个词
            int countFind = 0;
            for (int i = 2; i < num; i++){
                if (num % i == 0){
                    // 先记录符合条件的两个约数,这里可能出现secondDivisor == thirdDivisor情况
                    secondDivisor = num / i;
                    thirdDivisor = i;
                    countFind ++ ;
                }
                // 如果出现了两次以上就不符合条件了
                if(countFind > 2){break;}
            }
            // 只有secondDivisor 和 thirdDivisor 不相等且只查找了2次才行，才能符合刚好4约数的条件
            if (secondDivisor != thirdDivisor && countFind == 2){
                sum += 1 + secondDivisor + thirdDivisor + num;
            }

        }
        return sum;
    }



    public static void main(String[] args) {
        int i = new Algorithm_1390_LeetCode().sumFourDivisors(new int[]{7286,18704,70773,8224,91675});
        System.out.println(i);

    }
}
