package com.luhanlin.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 类详细描述：给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
 *      在杨辉三角中，每个数是它左上方和右上方的数的和。
 *
 * @author Mr_lu
 * @version 1.0
 * @mail allen_lu_hh@163.com
 * 创建时间：2020/6/20 11:05 下午
 */
public class N119PascalTriangle2 {

    public static List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>(rowIndex + 1);
        for (int i = 0; i <= rowIndex; i++) {
            result.add(1);
        }

        for (int i = 0; i <= rowIndex; i++) {
            for (int j = i-1; j > 0; j--) {
                result.set(j,result.get(j-1) + result.get(j));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> row = getRow(3);
        row.forEach(System.out::println);
    }
}
