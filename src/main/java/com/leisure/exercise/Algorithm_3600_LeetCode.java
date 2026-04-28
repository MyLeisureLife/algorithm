package com.leisure.exercise;

/**
 * ClassName: Algorithm_3600_LeetCode
 * Package: com.leisure.exercise
 * Description: 3600 升级后最大生成树稳定性
 *给你一个整数 n，表示编号从 0 到 n - 1 的 n 个节点，以及一个 edges 列表，其中 edges[i] = [ui, vi, si, musti]：
 * ui 和 vi 表示节点 ui 和 vi 之间的一条无向边。
 * si 是该边的强度。
 * i 是一个整数（0 或 1）。如果 i == 1，则该边 必须 包含在生成树中，且 不能升级 。
 * 你还有一个整数 k，表示你可以执行的最多 升级 次数。每次升级会使边的强度 翻倍 ，且每条可升级边（即 musti == 0）最多只能升级一次。
 * 一个生成树的 稳定性 定义为其中所有边的 最小 强度。
 * 返回任何有效生成树可能达到的 最大 稳定性。如果无法连接所有节点，返回 -1。
 * 注意： 图的一个 生成树（spanning tree）是该图中边的一个子集，它满足以下条件：
 * 将所有节点连接在一起（即图是 连通的 ）。不 形成任何环。包含 恰好 n - 1 条边，其中 n 是图中节点的数量。
 * 2 <= n <= 105
 * 1 <= edges.length <= 105
 * edges[i] = [ui, vi, si, must i]
 * 0 <= ui, vi < n
 * ui != vi
 * 1 <= si <= 105
 * must i 是 0 或 1。
 * 0 <= k <= n
 * @Author: MyLeisureLife
 * @Date: 2026/3/12:11:54:13 星期四
 */
public class Algorithm_3600_LeetCode {
    // 难点 怎么知道可不可以将所有节点都连接起来而且不构成循环
    public int maxStability(int n, int[][] edges, int k) {
        return 0;
    }
}
