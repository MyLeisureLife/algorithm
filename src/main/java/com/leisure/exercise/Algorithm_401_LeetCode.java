package com.leisure.exercise;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: Algorithm_401_LeetCode
 * Package: com.leisure.exercise
 * Description:二进制手表顶部有 4 个 LED 代表 小时（0-11），底部的 6 个 LED 代表 分钟（0-59）。每个 LED 代表一个 0 或 1，最低位在右侧。
 * 给你一个整数 turnedOn ，表示当前亮着的 LED 的数量，返回二进制手表可以表示的所有可能时间。你可以 按任意顺序 返回答案。
 * 小时不会以零开头：
 * 例如，"01:00" 是无效的时间，正确的写法应该是 "1:00" 。
 * 分钟必须由两位数组成，可能会以零开头：
 * 例如，"10:2" 是无效的时间，正确的写法应该是 "10:02" 。
 *
 * @Author: MyLeisureLife
 * @Date: 2026/2/17:11:40:01 星期二
 */
public class Algorithm_401_LeetCode {
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> ans = new ArrayList<String>();
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 60; j++) {

            }
        }
        return ans;
    }
}
