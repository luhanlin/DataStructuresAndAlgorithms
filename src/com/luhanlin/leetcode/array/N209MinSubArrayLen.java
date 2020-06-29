package com.luhanlin.leetcode.array;

/**
 * 类详细描述：给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组，并返回其长度。
 * 如果不存在符合条件的连续子数组，返回 0。
 *
 * @author Mr_lu
 * @version 1.0
 * @mail allen_lu_hh@163.com
 * 创建时间：2020/6/28 4:33 下午
 */
public class N209MinSubArrayLen {

    /**
     * 双指针
     * @param s
     * @param nums
     * @return
     */
    public int minSubArrayLen(int s, int[] nums) {
        if (nums.length == 0) return 0;

        int min = Integer.MAX_VALUE;
        int sum = 0;
        int start = 0;
        int end = 0;
        while (end <nums.length) {
            sum += nums[end++];
            while (sum >= s) {
                min = Math.min(min,end - start);
                sum -= nums[start++];
            }
        }

        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
