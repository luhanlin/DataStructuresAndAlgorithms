package com.luhanlin.leetcode.array;

/**
 * 类详细描述：在一个给定的数组nums中，总是存在一个最大元素 。
 *
 * 查找数组中的最大元素是否至少是数组中每个其他数字的两倍。
 *
 * 如果是，则返回最大元素的索引，否则返回-1。
 *
 * @author Mr_lu
 * @version 1.0
 * @mail allen_lu_hh@163.com
 * 创建时间：2020/6/26 4:30 下午
 */
public class N747DominantIndex {

    public int dominantIndex(int[] nums) {
        int one = 0;
        int two = 0;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (one < nums[i]) {
                two = one;
                one = nums[i];
                res = i;
            } else {
                two = Math.max(two, nums[i]);
            }
        }
        return one/2 >= two ? res : -1;
    }
}
