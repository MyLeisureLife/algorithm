package com.leisure.exercise;

/**
 * ClassName: Algorithm_3453_LeetCode
 * Package: com.leisure.exercise
 * Description:
 * 给你一个二维整数数组 squares ，其中 squares[i] = [xi, yi, li] 表示一个与 x 轴平行的正方形的左下角坐标和正方形的边长。
 * 找到一个最小的 y 坐标，它对应一条水平线，该线需要满足它以上正方形的总面积 等于 该线以下正方形的总面积。
 * 答案如果与实际答案的误差在 10-5 以内，将视为正确答案。
 * 注意：正方形 可能会 重叠。重叠区域应该被 多次计数 。
 * @Author: MyLeisureLife
 * @Date: 2026/1/13:09:01:55 星期二
 */
public class Algorithm_3453_LeetCode {
    /// 定义一个极小的误差范围（epsilon）
    private static final double EPSILON = 0.00001;
    public static boolean approximatelyEqual(double a, double b) {
        double d = Math.abs(a - b);
        return d < EPSILON;
    }
    /**
     * Binary Search 二分查找法
     * 时间复杂度O(lng n * m) 空间复杂度(1) n是所有正方形左上角的y轴坐标， m：所有正方形个数
     * 你需要注意int类型 和 double类型转换，需要注意等于条件
     * @param squares 正方形数组
     * @return 将所有正方形数组面积总和刚好分成一般的：y轴坐标
     */
    public double separateSquares(int[][] squares) {
        // y轴最高坐标
        double highestY = Integer.MIN_VALUE;
        // 总面积
        double sumArea = 0;
        for (int[] square : squares) {
            // x轴坐标
            int x = square[0];
            // y轴坐标
            int y = square[1];
            // 正方形边长
            int length = square[2];
            //所有总面积的和
            sumArea += (long)length * length;
            // 最高点的y轴的中间位置
            highestY = Math.max(highestY, y + length);
        }
        // 刚好分一半的面积
        double halfArea = sumArea / 2;

        // 使用二分法找到刚好将所有正方形面积总和分成一半的y轴线
        double lowestY = 0;
        double middleY = lowestY + (highestY- lowestY) / 2;
        while (lowestY < highestY) {
            // y轴线切割后的下部分的面积
            double cutArea = getCutArea(squares, middleY);

            boolean a = approximatelyEqual(cutArea, halfArea);
            boolean b = approximatelyEqual(middleY, lowestY) || approximatelyEqual(middleY, highestY);
            // 如果切割后的面积刚好相等就直接返回切割线
            if ( approximatelyEqual(middleY, lowestY) || approximatelyEqual(middleY, highestY)) {
                return middleY;
            }

            //就算面积相等了，也要将Y轴逐渐向下移动
            if (cutArea >= halfArea) {
                highestY = middleY;
            } else {
                lowestY = middleY;
            }
            middleY = lowestY + (highestY - lowestY) / 2;



        }

        return 0;
    }

    private static double getCutArea(int[][] squares, double middleY) {
        double cutArea = 0;
        for (int[] square : squares) {
            // 这个条件满足就表示该正方形被切割了(求的切割后的下半部分面积)
            if (square[1] < middleY  && middleY < square[1] + square[2]) {
                double height =  middleY - square[1];
                cutArea += height * square[2];
            // 如果没有切割到，正方行刚好处于切割线的的下面
            }else if( square[1] + square[2] <= middleY) {
                cutArea +=  (double)square[2] * square[2];
            }
        }
        return cutArea;
    }

    public static void main(String[] args) {
        int[][] ints = {
                {522261215,954313664,225462},{628661372,718610752,10667},{619734768,941310679,44788},
        {352367502,656774918,289036},{860247066,905800565,100123},{817623994,962847576,71460},
        {691552058,782740602,36271},{911356,152015365,513881},{462847044,859151855,233567},
        {672324240,954509294,685569}};

        // 9.565580922E9
        // 6.276484895304046E10
        double cutArea = getCutArea(ints, 954521423.80202);
        System.out.println("半径范围："+cutArea);
        double v = new Algorithm_3453_LeetCode().separateSquares(ints);
        System.out.println(v);
    }
}
