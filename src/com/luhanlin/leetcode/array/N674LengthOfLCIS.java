package com.luhanlin.leetcode.array;

/**
 * 类详细描述：给定一个未经排序的整数数组，找到最长且连续的的递增序列，并返回该序列的长度。
 *
 * @author Mr_lu
 * @version 1.0
 * @mail allen_lu_hh@163.com
 * 创建时间：2020/6/24 5:22 下午
 */
public class N674LengthOfLCIS {

    public int findLengthOfLCIS(int[] nums) {
        if (nums.length == 0) return 0;

        int res = 1;
        int arc = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i-1] >= nums[i]){
                res = Math.max(res,i - arc);
                arc = i;
            }
        }
        return Math.max(res,nums.length - arc);
    }
}
