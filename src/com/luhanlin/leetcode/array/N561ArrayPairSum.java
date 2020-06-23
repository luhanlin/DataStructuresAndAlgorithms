package com.luhanlin.leetcode.array;

import java.util.Arrays;

/**
 * 类详细描述：给定长度为 2n 的数组, 你的任务是将这些数分成 n 对, 例如 (a1, b1), (a2, b2), ..., (an, bn) ，使得从1 到 n 的 min(ai, bi) 总和最大。
 *
 * 示例 1:
 *
 * 输入: [1,4,3,2]
 *
 * 输出: 4
 * 解释: n 等于 2, 最大总和为 4 = min(1, 2) + min(3, 4).
 * 提示:
 *
 * n 是正整数,范围在 [1, 10000].
 * 数组中的元素范围在 [-10000, 10000].
 *
 * @author Mr_lu
 * @version 1.0
 * @mail allen_lu_hh@163.com
 * 创建时间：2020/6/23 3:46 下午
 */
public class N561ArrayPairSum {

    public int arrayPairSum(int[] nums) {
        if (nums.length == 0 || nums.length % 2 != 0) return -1;

        Arrays.sort(nums);

        int res = 0;
        for (int i = 0; i < nums.length - 1; i+=2) {
            res += nums[i];
        }

        return res;
    }
}
