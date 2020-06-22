package com.luhanlin.leetcode.array;

import java.util.TreeSet;

/**
 * 类详细描述：给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，并且 i 和 j 的差的 绝对值 至多为 k。
 *
 * 示例 1:
 *
 * 输入: nums = [1,2,3,1], k = 3
 * 输出: true
 * 示例 2:
 *
 * 输入: nums = [1,0,1,1], k = 1
 * 输出: true
 * 示例 3:
 *
 * 输入: nums = [1,2,3,1,2,3], k = 2
 * 输出: false
 *
 * @author Mr_lu
 * @version 1.0
 * @mail allen_lu_hh@163.com
 * 创建时间：2020/6/22 2:05 下午
 */
public class N219ContainsDuplicate {

    /**
     * 给定了长度k，则可以使用滚动窗口的模式
     * @param nums
     * @param k
     * @return
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        // 由于不用求解索引值，不需要使用HashMap进行存储
        TreeSet<Integer> treeSet = new TreeSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (treeSet.contains(nums[i])) {
                return true;
            }
            treeSet.add(nums[i]);

            if (treeSet.size() > k){
                treeSet.remove(nums[i-k]);
            }
        }

        return false;
    }

}
