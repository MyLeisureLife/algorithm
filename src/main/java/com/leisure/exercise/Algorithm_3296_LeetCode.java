package com.leisure.exercise;

/**
 * ClassName: Algorithm_3296_LeetCode
 * Package: com.leisure.exercise
 * Description: 3296. 移山所需的最少秒数
 * 给你一个整数 mountainHeight 表示山的高度。
 * 同时给你一个整数数组 workerTimes，表示工人们的工作时间（单位：秒）。
 * 工人们需要 同时 进行工作以 降低 山的高度。对于工人 i :
 * 山的高度降低 x，需要花费 workerTimes[i] + workerTimes[i] * 2 + ... + workerTimes[i] * x 秒。例如：
 * 山的高度降低 1，需要 workerTimes[i] 秒。
 * 山的高度降低 2，需要 workerTimes[i] + workerTimes[i] * 2 秒，依此类推。
 * 返回一个整数，表示工人们使山的高度降低到 0 所需的 最少 秒数
 * 1 <= mountainHeight <= 10^5
 * 1 <= workerTimes.length <= 10^4
 * 1 <= workerTimes[i] <= 10^6
 * @Author: MyLeisureLife
 * @Date: 2026/3/13:17:30:24 星期五
 */
public class Algorithm_3296_LeetCode {
    /**
     * 二分答案 binary search on answer
     * Time Complexity: 0(nlog(MH²))  Space Complexity:O(1)
     * endTime ≈ max(workerTime) * H² / 2，其中 H = mountainHeight
     * n: workerTimes数组长度 M:workerTimes中最大值  H: mountainHeight值
     * @param mountainHeight 山的高度
     * @param workerTimes 每个工人将山降低高低1需要工作时间
     * @return 最少需要多少时间才能将山的高度降低到0
     */
    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
       // 当山的高度都是一个人让其降低时最久耗时
        long endTime = 0;
        for (int workerTime : workerTimes) {
            endTime = Math.max(endTime, workerTime * ((long) mountainHeight * (mountainHeight + 1)) / 2);
        }
        // 取中间时间
        long startTime = 1;
        long midTime = 0;
        while (startTime < endTime) {
            midTime = startTime +  (endTime - startTime) / 2;
            // 中间值midTime 可以去掉多少高度
            long mindHeight = 0;
            for (int workerTime : workerTimes) {
                double sqrt = Math.sqrt(1 + (double) (8 * midTime) / workerTime);
                mindHeight += (long) (sqrt - 1) / 2;
            }
            // 如果能去掉的高度 mindHeight 小于了 总高度，
            // 就表示midTime时间不够还需要加
            if (mindHeight < mountainHeight) {
                // 就只需要将开始时间移动到中间时间 + 1就可以了
                startTime = midTime + 1;
            }else {
                // 表示midTime时间太多了导致高度太高了
                // 就只需要将开始时间移动到中间时间 -1就可以了
                endTime = midTime;
            }
        }
        return startTime;
    }

    public static void main(String[] args) {
        long l = new Algorithm_3296_LeetCode().minNumberOfSeconds(5, new int[]{1});
        System.out.println(l);

    }
}
