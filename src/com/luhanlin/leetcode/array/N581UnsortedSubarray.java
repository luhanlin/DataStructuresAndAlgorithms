package com.luhanlin.leetcode.array;

/**
 * 类详细描述：给定一个整数数组，你需要寻找一个连续的子数组，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
 *
 * 你找到的子数组应是最短的，请输出它的长度。
 * 示例 1:
 *
 * 输入: [2, 6, 4, 8, 10, 9, 15]
 * 输出: 5
 * 解释: 你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
 * 说明 :
 *
 * 输入的数组长度范围在 [1, 10,000]。
 * 输入的数组可能包含重复元素 ，所以升序的意思是<=。
 *
 * @author Mr_lu
 * @version 1.0
 * @mail allen_lu_hh@163.com
 * 创建时间：2020/6/23 4:23 下午
 */
public class N581UnsortedSubarray {

    /**
     * 双指针解法 从左往右找出第一个破坏递增的，从右往左找出第一个破坏递减的
     * @param nums
     * @return
     */
    public int findUnsortedSubarray(int[] nums) {
        if (nums.length < 2) return 0;

        int l = 0;
        int r = 0;

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        // 找到逆序元素，左边最小值和右边最大值
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] < nums[i]) {
                min = Math.min(min, nums[i + 1]);
                max = Math.max(max, nums[i]);
            }
        }

        //左边元素位置
        for (l = 0; l < nums.length; l++) {
            if (nums[l] > min) {
                break;
            }
        }

        //右边元素位置
        for (r = nums.length - 1; r >=0; r--) {
            if (nums[r] < min) {
                break;
            }
        }

        return l < r ? r - l + 1 : 0;
    }
}
