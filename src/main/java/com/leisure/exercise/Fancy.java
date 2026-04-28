package com.leisure.exercise;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: Algorithm_1622_LeetCode
 * Package: com.leisure.exercise
 * Description: 1622奇妙序列
 * 请你实现三个 API append，addAll 和 multAll 来实现奇妙序列。
 * 请实现 Fancy 类 ：
 * Fancy() 初始化一个空序列对象。
 * void append(val) 将整数 val 添加在序列末尾。
 * void addAll(inc) 将所有序列中的现有数值都增加 inc 。
 * void multAll(m) 将序列中的所有现有数值都乘以整数 m 。
 * int getIndex(idx) 得到下标为 idx 处的数值（下标从 0 开始），并将结果对 109 + 7 取余。如果下标大于等于序列的长度，请返回 -1 。
 * @Author: MyLeisureLife
 * @Date: 2026/3/15:11:08:37 星期日
 */
public class Fancy {
    List<Integer> list;
    int MOD = 1000000007;
    public  Fancy() {
        list = new ArrayList<>();
    }

    public void append(int val) {
        list.add(val);
    }

    public void addAll(int inc) {
        for (int i = 0; i < list.size(); i++) {
            list.set(i, (list.get(i) + inc)%MOD);
        }
    }

    public void multAll(int m) {
        for (int i = 0; i < list.size(); i++) {
            // 这里需要注意超出范围
            list.set(i, (int) ((( (long) list.get(i) * m))%MOD));
        }
    }

    public int getIndex(int idx) {
        if (idx < list.size()){
            return list.get(idx) % MOD;
        }
        return -1;
    }

    /**
     *  Time Complexity： O(n * m) Space Complexity:O(m)
     *  n: 方法调用次数   m: 添加数据的规模
     * 问题：时间复杂度超了，需要将某些操作合并到一起执行才能降低时间复杂度
     */
    public static void main(String[] args) {
        Fancy f = new Fancy();
        f.append(2);
        f.addAll(3);
        f.append(7);
        f.multAll(2);
        f.getIndex(0);
        f.addAll(3);
        f.append(10);
        f.multAll(2);
        int index = f.getIndex(0);
        int index1 = f.getIndex(1);
        int index2 = f.getIndex(2);

    }
}
