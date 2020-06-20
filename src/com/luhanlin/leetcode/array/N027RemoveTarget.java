package com.luhanlin.leetcode.array;

/**
 * 类详细描述：
 *
 * @author Mr_lu
 * @version 1.0
 * @mail allen_lu_hh@163.com
 * 创建时间：2020/6/18 3:12 下午
 */
public class N027RemoveTarget {

    public static int removeElement(int[] nums, int val) {
        int length = nums.length;

        if (length <= 0) {
            return 0;
        }

        int i = 0;
        int j = 0;

        while (j < length) {
            if (nums[j] != val) {
                nums[i++] = nums[j];
            }
            j++;
        }
        return i;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 2, 3, 0, 4, 2};

        System.out.println(removeElement(nums, 2));

        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]);
        }
    }
}
