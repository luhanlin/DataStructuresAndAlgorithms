package com.luhanlin.leetcode.array;

import java.util.TreeSet;

/**
 * 类详细描述：给定一个非空数组，返回此数组中第三大的数。如果不存在，则返回数组中最大的数。要求算法时间复杂度必须是O(n)。
 *
 * @author Mr_lu
 * @version 1.0
 * @mail allen_lu_hh@163.com
 * 创建时间：2020/6/23 8:51 上午
 */
public class N414ThirdMax {

    /**
     * 借用红黑树集合来进行计算时间复杂度为 O(n log3)
     * @param nums
     * @return
     */
    public int thirdMax(int[] nums){

        if(nums == null || nums.length == 0){
            return -1;
        }

        TreeSet<Integer> set = new TreeSet<>();

        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
            if (set.size() > 3) {
                set.remove(set.first());
            }
        }

        return (set.size() < 3)? set.last() : set.first();
    }

}
