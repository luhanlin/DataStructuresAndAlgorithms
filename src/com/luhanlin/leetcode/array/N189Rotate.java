package com.luhanlin.leetcode.array;

/**
 * 类详细描述：给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 *
 * 示例 1:
 *
 * 输入: [1,2,3,4,5,6,7] 和 k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 * 示例 2:
 *
 * 输入: [-1,-100,3,99] 和 k = 2
 * 输出: [3,99,-1,-100]
 * 解释:
 * 向右旋转 1 步: [99,-1,-100,3]
 * 向右旋转 2 步: [3,99,-1,-100]
 * 说明:
 *
 * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
 * 要求使用空间复杂度为 O(1) 的 原地 算法。
 *
 * @author Mr_lu
 * @version 1.0
 * @mail allen_lu_hh@163.com
 * 创建时间：2020/6/22 9:58 上午
 */
public class N189Rotate {

    /**
     * 暴力法，每次向后移动一位
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {
        k = k % nums.length;

        for (int i = 0; i < k; i++) {
            int end = nums[nums.length - 1];
            for (int j = nums.length - 1; j > 0; j--) {
                nums[j] = nums[j - 1];
            }
            nums[0] = end;
        }
    }

    /**
     * 环形求解法
     * @param nums
     * @param k
     */
    public void rotate2(int[] nums, int k) {
        k = k % nums.length;

        int count = 0;
        for (int i = 0; count < nums.length; i++) {
            int cur = i;
            int prev = nums[i];
            do {
                int next = (cur + k) % nums.length;
                int tmp = nums[next];
                nums[next] = prev;
                prev = tmp;
                cur = next;
                count++;
            } while(cur != i);
        }
    }

    /**
     * 三次反转数组
     * @param nums
     * @param k
     */
    public void rotate3(int[] nums, int k) {
        k = k % nums.length;

        reverse(nums, 0, nums.length -1);
        reverse(nums,0, k-1);
        reverse(nums,k, nums.length-1);
    }

    private void reverse(int[] nums, int left, int right) {
        int start = left;
        int end = right;
        for (int i = left; start < end; i++) {
            int tmp = nums[end];
            nums[end] = nums[start];
            nums[start] = tmp;
            start++;
            end--;
        }
    }
}
