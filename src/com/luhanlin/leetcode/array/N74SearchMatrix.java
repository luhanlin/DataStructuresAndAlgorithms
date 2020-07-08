package com.luhanlin.leetcode.array;

/**
 * <类详细描述>编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 *
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 *
 * @author luhanlin
 * @version [V_1.0.0, 2020-07-03 17:57]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */

public class N74SearchMatrix {

    /**
     * 先找到 target 所在行，然后对行数据进行二分查找
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int s = 0;
        int e = rows - 1;

        while(s < e) {
            int mid = s + (e-s)/2;

            if (matrix[mid][cols-1] < target) {
                s = mid + 1;
            } else {
                e = mid;
            }
        }

        int l = 0;
        int r = cols - 1;

        while (l<r) {
            int mid = l + (r-l)/2;
            if (matrix[e][mid] > target) {
                r = mid - 1;
            } else if (matrix[e][mid] < target) {
                l = mid + 1;
            } else {
                return true;
            }
        }

        if (matrix[e][l] == target) {
            return true;
        }

        return false;
    }
}
