package com.luhanlin.leetcode.array;

/**
 * 类详细描述：给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *
 * 你可以假设数组中无重复元素。
 *
 * @author Mr_lu
 * @version 1.0
 * @mail allen_lu_hh@163.com
 * 创建时间：2020/6/20 9:18 上午
 */
public class N035SearchInsert {

    /**
     * 暴力遍历法
     * @param nums
     * @param target
     * @return
     */
    public static int searchInsert(int[] nums, int target) {
        int len = nums.length;

        for (int i = 0; i < len; i++) {
            if (nums[i] >= target) {
                return i;
            }
        }
        return len;
    }

    /**
     * 二分法
     * @param nums
     * @param target
     * @return
     */
    public static int searchInsert2(int[] nums, int target) {
        int left = 0;
        int right = nums.length;

        while(left < right) {
            int midIndex = (left + right) >>1;
            if (nums[midIndex] > target) {
                right = midIndex - 1;
            } else if (nums[midIndex] < target) {
                left = midIndex + 1;
            } else {
                return midIndex;
            }
        }
        return left;
    }
}
