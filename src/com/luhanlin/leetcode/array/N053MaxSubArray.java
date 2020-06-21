package com.luhanlin.leetcode.array;

/**
 * 类详细描述：给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 示例:
 *
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 *
 * @author Mr_lu
 * @version 1.0
 * @mail allen_lu_hh@163.com
 * 创建时间：2020/6/20 10:31 上午
 */
public class N053MaxSubArray {

    /**
     * 动态规划 f(i) = Max(f(i-1), f(i))
     * @param nums
     * @return
     */
    public static int maxSubArray(int[] nums) {
        int res = nums[0];

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = Math.max(sum + nums[i], nums[i]);
            res = Math.max(res, sum);
        }
        return res;
    }
}
