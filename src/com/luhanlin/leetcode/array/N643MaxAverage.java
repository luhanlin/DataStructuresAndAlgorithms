package com.luhanlin.leetcode.array;

/**
 * 类详细描述：给定 n 个整数，找出平均数最大且长度为 k 的连续子数组，并输出该最大平均数。
 *
 * @author Mr_lu
 * @version 1.0
 * @mail allen_lu_hh@163.com
 * 创建时间：2020/6/23 7:55 下午
 */
public class N643MaxAverage {

    /**
     * 滑动窗口
     * @param nums
     * @param k
     * @return
     */
    public static double findMaxAverage(int[] nums, int k) {
        int length = nums.length;

        if (length == 0 || length < k) return -1;

        double sum = 0;

        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }

        double res = sum;
        for (int i = k; i < length; i++) {
            sum += nums[i] - nums[i - k];
            res = Math.max(res, sum);
        }

        return res/k;
    }
}
