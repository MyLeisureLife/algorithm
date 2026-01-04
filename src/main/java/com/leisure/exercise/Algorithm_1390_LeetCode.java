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
     * @return 数组中刚好有4个约数的 数的 约数和
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

    /**
     * sqrt algorithm
     * 需要优化下算法，上面的算法的时间复杂度有些高了
     * 我们要判断1个数的约数不需要从1 遍历到 n只需要变量 n开根号就可以了
     * 应为：如果整数 x 有因数 y，那么也必有因数 x/y，并且 y 和 x/y 中至少有一个不大于 sqrt(x)
     * 时间复杂度O(n*m开平方根) 空间复杂度O(1) , 1 <= n <= 10^4 , 1 <= m <= 10^5
     * @param nums 1 <= nums.length <= 10^4, 1 <= nums[i] <= 10^5
     * @return 数组中刚好有4个约数的 数的 约数和
     */
    public int sumFiveDivisorsOptimization(int[] nums) {
        int sum = 0;
        for (int num : nums){
            // 首先找到4个约数，其中 1 和 它本身不需要寻找
            int secondDivisor = 0, thirdDivisor = 0;
            int end =  (int)Math.sqrt(num);
            for (int i = 2; i <= end; i++){
                if (num % i == 0){
                    // 如果secondDivisor！=0就证明了该判断条件执行第二次，单这个条件不允许执行第二次
                    if (secondDivisor != 0){
                        secondDivisor = thirdDivisor;
                        break;
                    }
                    // 先记录符合条件的两个约数,这里可能出现secondDivisor == thirdDivisor情况
                    secondDivisor = num / i;
                    thirdDivisor = i;
                }

            }
            // 只有secondDivisor 和 thirdDivisor 不相等且，才能符合刚好4约数的条件
            if (secondDivisor != thirdDivisor ){
                sum += 1 + secondDivisor + thirdDivisor + num;
            }

        }
        return sum;
    }




    public static void main(String[] args) {
        int i = new Algorithm_1390_LeetCode().sumFiveDivisorsOptimization(new int[]{1,2,3,4,5,6,7,8,9,10});
        System.out.println(i);

    }
}
