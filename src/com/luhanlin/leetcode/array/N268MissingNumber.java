package com.luhanlin.leetcode.array;

import java.util.Arrays;

/**
 * 类详细描述：给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。
 *
 * 示例 1:
 *
 * 输入: [3,0,1]
 * 输出: 2
 * 示例 2:
 *
 * 输入: [9,6,4,2,3,5,7,0,1]
 * 输出: 8
 *
 * 说明:
 * 你的算法应具有线性时间复杂度。你能否仅使用额外常数空间来实现?
 *
 * @author Mr_lu
 * @version 1.0
 * @mail allen_lu_hh@163.com
 * 创建时间：2020/6/22 2:14 下午
 */
public class N268MissingNumber {

    public int missingNumber(int[] nums) {
        /**
         * 数学计算法
         */
//        int sum = 0;
//        int i;
//        for (i = 0; i < nums.length; i++) {
//            // 防止溢出，边加边减
//            sum +=nums[i] - i;
//        }
//
//        return Math.abs(sum - i);

        /**
         * 排序法
         */
//        Arrays.sort(nums);
//        if (nums[nums.length - 1] != nums.length) {
//            return nums.length;
//        } else if (nums[0] != 0) {
//            return 0;
//        }
//
//        for (int i = 1; i < nums.length; i++) {
//            if (nums[i]-nums[i-1] != 1) {
//                return i;
//            }
//        }
//        return -1;

        /**
         * 位运算法 相同数的两次 ^ 位运算为相同的数
         */
        int res = 0;
        int i;
        for (i = 0; i < nums.length; i++) {
            res ^= nums[i];
            res ^= i;
        }
        return res ^ i;
    }

}
