package com.leisure.exercise;

import java.util.*;

/**
 * ClassName: Algorithm_756_LeetCode
 * Package: com.leisure.exercise
 * Description:
 * 你正在把积木堆成金字塔。每个块都有一个颜色，用一个字母表示。每一行的块比它下面的行 少一个块 ，并且居中。
 * 为了使金字塔美观，只有特定的 三角形图案 是允许的。一个三角形的图案由 两个块 和叠在上面的 单个块 组成。模式是以三个字母字符串的列表形式 allowed 给出的，其中模式的前两个字符分别表示左右底部块，第三个字符表示顶部块。
 * 例如，"ABC" 表示一个三角形图案，其中一个 “C” 块堆叠在一个 'A' 块(左)和一个 'B' 块(右)之上。请注意，这与 "BAC" 不同，"B" 在左下角，"A" 在右下角。
 * 你从作为单个字符串给出的底部的一排积木 bottom 开始，必须 将其作为金字塔的底部。
 * 在给定 bottom 和 allowed 的情况下，如果你能一直构建到金字塔顶部，使金字塔中的 每个三角形图案 都是在 allowed 中的，则返回 true ，否则返回 false 。
 *
 * @Author: MyLeisureLife
 * @Date: 2025/12/29:09:00:23 星期一
 */
public class Algorithm_756_LeetCode {
    public boolean pyramidTransition(String bottom, List<String> allowed) {
        //首先创建一个二维数组存放allowed中的第一个和第二个字母
        @SuppressWarnings("unchecked")
        List<Integer>[][] mappingTable = new ArrayList[6][6];
        // 必须手动初始化每个元素！
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                mappingTable[i][j] = new ArrayList<Integer>();
            }
        }
        // 将allowed数据全部存储到二维数组结构中
        for (String s : allowed) {
            mappingTable[s.charAt(0) - 'A'][s.charAt(1) - 'A'].add(s.charAt(2) - 'A');
        }

        // 将金字塔转化为二维数组
        int n = bottom.length();
        int[][] pyramid = new int[n][];
        for (int i = n - 1; i >= 0; i--) {
            pyramid[i] = new int[i + 1];
        }
        //将bottom数据放入二维数组中
        for (int i = 0; i < pyramid[n - 1].length; i++) {
            pyramid[n - 1][i] = bottom.charAt(i) - 'A';
        }

        // 然后使用深度优先搜索算法判断是否能从底部构建出完整金字塔
        return dfs(mappingTable, pyramid, n - 1, 0, new ArrayList<>());

    }

    /**
     * @param mappingTable  映射表
     * @param pyramid       金字塔
     * @param currentRow    当前所在行
     * @param position      当前所在行的下标位置
     * @param pyramidTopSet 当前位置所有allowed的塔尖
     * @return false 表示不能获取到塔尖元素， ture表示可以获取到塔尖元素
     */
    private boolean dfs(List<Integer>[][] mappingTable, int[][] pyramid, int currentRow, int position, List<Integer> pyramidTopSet) {


        // 到金字塔上一层
        if (position == pyramid[currentRow].length - 1) {
            position = 0;
            currentRow--;
        }

        //停止条件
        if (currentRow == 0 && position == pyramid[0].length - 1) {
            return true;
        }

        // 为空的时候才查询数据否则不查询
        if (pyramidTopSet.isEmpty()){
            pyramidTopSet = new ArrayList<>(mappingTable[pyramid[currentRow][position]][pyramid[currentRow][position + 1]]);
        }

        int[][] newPyramid = new int[pyramid.length][];

        // 只存在一个金字塔尖的结果
        if (pyramidTopSet.size() == 1) {
            // 将金字塔二维数组填充
            pyramid[currentRow - 1][position] = pyramidTopSet.get(0);
            int  a = pyramidTopSet.remove(0);
            //将坐标右移动一位
            position = position + 1;

            // 需要传入一个单独的 金字塔
            for (int i = 0; i < pyramid.length; i++) {
                newPyramid[i] = Arrays.copyOf(pyramid[i], pyramid[i].length);
            }

            // 需要传一个单独的top
            dfs(mappingTable,newPyramid, currentRow, position, pyramidTopSet);

            //回溯 数据
            pyramidTopSet.add(a);


            // 存在多个金字塔尖的结果
        } else if (pyramidTopSet.size() > 1) {

            //如果有多个塔尖就需要将所有塔尖全部依次填充到金字塔二维数组中去
            for (int i = 0; i < pyramidTopSet.size(); i++) {
                pyramid[currentRow - 1][position] = pyramidTopSet.get(0);
                // 移除第一个
                int  a = pyramidTopSet.remove(0);

                // 需要传入一个单独的 金字塔
                for (int m = 0; m < pyramid.length; m++) {
                    newPyramid[m] = Arrays.copyOf(pyramid[m], pyramid[m].length);
                }

                dfs(mappingTable,newPyramid, currentRow, position, pyramidTopSet);

                //回溯 数据
                pyramidTopSet.add(a);


            }
        }

        // 如果最后能到这一步，就表示不能构成金字塔
        return false;
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("CBB");
        list.add("ACB");
        list.add("ABD");
        list.add("CDB");
        list.add("BDC");
        list.add("CBC");
        list.add("DBA");
        list.add("DBB");
        list.add("CAB");

        list.add("BCB");
        list.add("BCC");
        list.add("BAA");
        list.add("CCD");
        list.add("BDD");
        list.add("DDD");
        list.add("CCA");
        list.add("CAA");
        list.add("CCC");
        list.add("CCB");


        boolean b = new Algorithm_756_LeetCode().pyramidTransition("CCC", list);
        System.out.println(b);
    }
}
