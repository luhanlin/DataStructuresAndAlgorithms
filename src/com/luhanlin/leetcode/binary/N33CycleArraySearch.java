package com.luhanlin.leetcode.binary;

/**
 * <类详细描述> 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 *
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 *
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 *
 * 你可以假设数组中不存在重复的元素。
 *
 * 你的算法时间复杂度必须是 O(log n) 级别。
 *
 * @author luhanlin
 * @version [V_1.0.0, 2020-07-09 14:05]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class N33CycleArraySearch {

    public int findMin(int[] nums) {
        if (nums.length == 0) return -1;
        int l = 0;
        int r = nums.length - 1;

        while (l < r) {
            int mid = (l + r) >>> 1;
            if (nums[mid] > nums[r]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        return nums[r];
    }


    public int search(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) return -1;

        int l = 0;
        int r = n - 1;

        while (l <= r) {
            int mid = (l + r) >>> 1;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] < nums[r]) { // 右边有序
                if (nums[mid] < target && target <= nums[r]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            } else {
                if (nums[mid] > target && target >= nums[l]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
        }

        return -1;
    }
}
