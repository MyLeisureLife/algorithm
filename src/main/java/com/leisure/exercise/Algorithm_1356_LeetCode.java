package com.leisure.exercise;

/**
 * ClassName: Algorithm_1356_LeetCode
 * Package: com.leisure.exercise
 * Description:
 * 给你一个整数数组 arr 。请你将数组中的元素按照其二进制表示中数字 1 的数目升序排序。
 * 如果存在多个数字二进制中 1 的数目相同，则必须将它们按照数值大小升序排列。
 * 请你返回排序后的数组。
 * 1 <= arr.length <= 500
 * 0 <= arr[i] <= 10^4
 * @Author: MyLeisureLife
 * @Date: 2026/2/25:08:27:18 星期三
 */
public class Algorithm_1356_LeetCode {
    /**
     * 位排序
     * 时间复杂度O(n ^ 2) 空间复杂度O(n)
     * @param arr 需要排序的所有数据
     * @return 排序的结果
     */
    public int[] sortByBits(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            // 冒泡排序
            for (int j = i+1; j < arr.length; j++) {
                if (bitCount(arr[i]) > bitCount(arr[j])) {
                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }else if (bitCount(arr[i]) == bitCount(arr[j]) && arr[i] > arr[j]) {
                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }

        }
        return arr;
    }

    /**
     * 计算二进制中1的个数
     * @param num 二进制数
     * @return 1的个
     */
    private int bitCount(int num) {
        // 计算整数二进制1的个数,当32位就只需要计算到它的一半就行。
        num = (num & 0x55555555) + ((num >>> 1) & 0x55555555);
        num = (num & 0x33333333) + ((num >>> 2) & 0x33333333);
        num = (num & 0x0f0f0f0f) + ((num >>> 4) & 0x0f0f0f0f);
        num = (num & 0x00ff00ff) + ((num >>> 8) & 0x00ff00ff);
        num = (num & 0x0000ffff) + ((num >>> 16) & 0x0000ffff);
        return num;
    }


    public static void main(String[] args) {
        int[] ints = new Algorithm_1356_LeetCode().sortByBits(new int[]{0,1,2,3,4,5,6,7,8});
        for (int anInt : ints) {
            System.out.print(anInt + " ");
        }


    }
}
