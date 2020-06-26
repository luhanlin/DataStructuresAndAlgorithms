package com.luhanlin.leetcode.array;

import java.util.Arrays;

/**
 * 类详细描述：给定一个整型数组，在数组中找出由三个数组成的最大乘积，并输出这个乘积。
 *
 * @author Mr_lu
 * @version 1.0
 * @mail allen_lu_hh@163.com
 * 创建时间：2020/6/23 6:24 下午
 */
public class N628MaximumProduct {

    /**
     * 主要需要考虑为负数的情况
     * @param nums
     * @return
     */
    public int maximumProduct(int[] nums) {
        int len = nums.length;

        if (len < 3) return 0;

        Arrays.sort(nums);

        return Math.max(nums[len - 1] * nums[len - 2] * nums[len - 3], nums[0] * nums[1] * nums[len - 1]);
    }
}
