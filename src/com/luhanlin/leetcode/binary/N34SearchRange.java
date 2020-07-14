package com.luhanlin.leetcode.binary;

/**
 * <类详细描述> 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 *
 * 你的算法时间复杂度必须是 O(log n) 级别。
 *
 * 如果数组中不存在目标值，返回 [-1, -1]。
 *
 * @author luhanlin
 * @version [V_1.0.0, 2020-07-09 09:58]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class N34SearchRange {

    public int[] searchRange(int[] nums, int target) {
        int[] res = {-1, -1};
        int n = nums.length;
        if (n == 0) return res;

        int l = 0;
        int r = n;

        // 寻找最左边界
        while (l < r) {
            int mid = (l + r) >>> 1;

            if (nums[mid] == target) {
                r = mid;
            } else if (nums[mid] > target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        if (l==n || nums[l] != target) return res;
        res[0] = l;
        r = n;

        // 寻找最右边界
        while (l < r) {
            int mid = (l + r) >>> 1;

            if (nums[mid] == target) {
                l = mid + 1;
            } else if (nums[mid] > target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        res[1] = r-1;
        return res;
    }
}
