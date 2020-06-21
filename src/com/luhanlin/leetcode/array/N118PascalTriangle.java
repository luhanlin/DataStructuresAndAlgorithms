package com.luhanlin.leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 类详细描述：给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 *      在杨辉三角中，每个数是它左上方和右上方的数的和。
 *
 * @author Mr_lu
 * @version 1.0
 * @mail allen_lu_hh@163.com
 * 创建时间：2020/6/20 11:05 下午
 */
public class N118PascalTriangle {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();

        if (numRows == 0) return result;

        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();

            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    row.add(result.get(i-1).get(j-1) + result.get(i-1).get(j));
                }
            }
            result.add(row);
        }
        return result;
    }
}
