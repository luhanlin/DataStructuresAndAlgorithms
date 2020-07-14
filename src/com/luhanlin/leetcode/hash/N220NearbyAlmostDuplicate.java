package com.luhanlin.leetcode.hash;

import java.util.TreeSet;

/**
 * <类详细描述>在整数数组 nums 中，是否存在两个下标 i 和 j，使得 nums [i] 和 nums [j] 的差的绝对值小于等于 t ，且满足 i 和 j 的差的绝对值也小于等于 ķ 。
 *
 * 如果存在则返回 true，不存在返回 false。
 *
 * @author luhanlin
 * @version [V_1.0.0, 2020-07-14 15:05]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class N220NearbyAlmostDuplicate {

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Integer> set = new TreeSet<>();

        for (int i = 0; i < nums.length; i++) {
            // 寻找 >= nums[i] 的最小值
            Integer ceil = set.ceiling(nums[i]);
            if (ceil != null && ceil <= t + nums[i]) return true;
            // 寻找 <= nums[i] 的最大值
            Integer floor = set.floor(nums[i]);
            if (floor != null && nums[i] <= t + floor ) return true;

            set.add(nums[i]);
            if (set.size() > k) {
                set.remove(nums[i-k]);
            }
        }
        return false;
    }
}
