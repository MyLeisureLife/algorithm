package com.leisure.exercise;

import com.sun.xml.internal.bind.v2.model.core.ID;

/**
 * ClassName: Algorithm_2360_LeetCode
 * Package: com.leisure.exercise
 * Description:
 * 给你一个 n 个节点的 有向图 ，节点编号为 0 到 n - 1 ，其中每个节点 至多 有一条出边。
 * 图用一个大小为 n 下标从 0 开始的数组 edges 表示，节点 i 到节点 edges[i] 之间有一条有向边。如果节点 i 没有出边，那么 edges[i] == -1 。
 * 请你返回图中的 最长 环，如果没有任何环，请返回 -1 。
 * 一个环指的是起点和终点是 同一个 节点的路径。
 *
 * @Author: MyLeisureLife
 * @Date: 2025/3/29:16:36:04 星期六
 */
public class Algorithm_2360_LeetCode {

    public int LeetCode_longestCycle(int[] edges) {
        int n = edges.length;
        // label 记录节点多久才被循环到， label[0] = 1 表示 0号节点需要走一秒才到
        int[] label = new int[n];
        // current_label 表示当前走了几秒，  ans 表示环最大为多少， -1 表示没有环
        int current_label = 0, ans = -1;
        // 开始遍历循环所有节点
        for (int i = 0; i < n; i++){
            // 只有没有遍历过的节点才能用于找 环，遍历过的节点直接跳过。
            // 因为变量过的节点如果存在环的话，就应该被ans记录了。
            if (label[i] != 0){
                continue;
            }

            // pos 寻找环的开始位置，
            // start_label 开始位置的时间等于当前时间，表示新的一次寻找环的动作
            int pos = i, start_label = current_label;

            // 开始找环，确保当前节点可以进入循环，保证下一个节点没有时跳出循环
            while (pos != -1){
                // 消耗时间找环
                current_label ++;

                // 在找环过程中遇到了 节点时间不为0的情况的意思
                // 这个节点已经被走过了一次了。
                // 如果节点时间 大于当前start_label时间 就表示：这个节点是在这次找环动作中被走的。
                // 如果小于start_label时间就表示：这个节点是以前找环动作中被走的。
                if (label[i] != 0){
                    // 如果遇到时间大于当次找环的开始时间点，那就证明这个环是在这次找环的动作下找到的
                    if (label[pos] > start_label){
                        // 这时就需要比对那个环的寻找时间最大了
                        ans = Math.max(ans, current_label - label[pos]);
                    }
                }

                // 节点pos在第current_label步的时候被经过
                label[pos] = current_label;
                // 下一个节点的位置
                pos = edges[pos];
            }
        }
        return ans;
    }


    public int longestCycle(int[] edges) {
        int n = edges.length;
        // 找环时到该节点所用时间
        int[] nodesTime = new int[n];
        // 找环当前时间
        int current_time = 0;
        // 答案， 没有环就返回 -1
        int ans = -1;

        // 遍历所有节点开始找环
        for (int i = 0; i < n; i++){
            // 排除一些不需要找的节点, 当找到该节点的时间不为0时，表示已经在这个节点路径上找过了一次环，所以不需要再次寻找了
            if (nodesTime[i] != 0){
                continue;
            }
            // 定义变量在i节点上开始找环
            int position = i, start_time = current_time;

            // 当节点没有下一个节点时跳出循环
            while (position != -1){
                // 当前时间开始增加
                current_time ++;

                // 找到环的情况为 nodesTime[position] 的值不为0时就算找到了环
                // 这时存在两种情况：
                // 节点花费时间 大于 当次找环的开始时间；这个表示是一个环
                // 节点花费时间 小于   当次找环的开始时间：这根本不可能组成一个环
                // start_time && nodesTime[position] != 0 为了防止最开始为0的情况
                if (nodesTime[position] > start_time && nodesTime[position] != 0){
                    // 形成一个环所需要的时间
                    ans = Math.max(ans, current_time - nodesTime[position]);
                    // 找到环后就可以继续下一个了
                    break;
                }
                if (nodesTime[position] <= start_time && nodesTime[position] != 0){
                    break;
                }
                // 记录到position节点需要花费多长时间
                nodesTime[position] = current_time;
                // 下一个节点位置
                position = edges[position];
            }

        }
        return ans;
    }

    public static void main(String[] args) {
        new Algorithm_2360_LeetCode().longestCycle(new int[] { -1,4,-1,2,0,4 });
    }
}