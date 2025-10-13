package com.leisure.exercise;

/**
 * ClassName: 换水问题 II
 * Package: com.leisure.exercise
 * Description:给你两个整数 numBottles 和 numExchange 。
 * numBottles 代表你最初拥有的满水瓶数量。在一次操作中，你可以执行以下操作之一：
 * 喝掉任意数量的满水瓶，使它们变成空水瓶。
 * 用 numExchange 个空水瓶交换一个满水瓶。然后，将 numExchange 的值增加 1 。
 * 注意，你不能使用相同的 numExchange 值交换多批空水瓶。例如，如果 numBottles == 3 并且 numExchange == 1 ，则不能用 3 个空水瓶交换成 3 个满水瓶。
 * 返回你 最多 可以喝到多少瓶水。
 *
 * @Author: MyLeisureLife
 * @Date: 2025/10/2:18:48:23 星期四
 */
public class Algorithm_3100_LeetCode {
    int maxBottlesDrunk(int numBottles, int numExchange) {
        int answer = numBottles;
        int emptyBottles = numBottles;
        int residueEmptyBottles;
        while (emptyBottles >= numExchange) {
            // 剩余未兑换的空水瓶数量
            residueEmptyBottles = emptyBottles - numExchange;
            // 兑换水瓶数量加1
            numExchange ++;
            // 喝了的水瓶数量加1
            answer ++;
            //剩余的空瓶子数量加1
            emptyBottles = residueEmptyBottles + 1;
        }
        return answer;
    }
    public static void main(String[] args) {

    }
}
