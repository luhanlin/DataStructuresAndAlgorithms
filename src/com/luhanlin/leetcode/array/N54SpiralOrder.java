package com.luhanlin.leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 类详细描述：给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 *
 * @author Mr_lu
 * @version 1.0
 * @mail allen_lu_hh@163.com
 * 创建时间：2020/7/4 10:52 上午
 */
public class N54SpiralOrder {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int rows = matrix.length;
        if (rows == 0) return res;
        int cols = matrix[0].length;
        if (cols == 0) return res;

        // 定义上下左右边界
        int top = 0;
        int left = 0;
        int bottom = rows - 1;
        int right = cols - 1;

        while (true) {
            for (int i = left; i <= right; i++) {
                res.add(matrix[top][i]);
            }
            if (++top > bottom) break;
            for (int i = top; i <= bottom; i++) {
                res.add(matrix[i][right]);
            }
            if (--right < left) break;
            for (int i = right; i >=left; i--) {
                res.add(matrix[bottom][i]);
            }
            if (--bottom < top) break;
            for (int i = bottom; i >=top; i--) {
                res.add(matrix[i][left]);
            }
            if (++left > right) break;
        }
        return res;
    }
}
