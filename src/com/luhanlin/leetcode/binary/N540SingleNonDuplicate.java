package com.luhanlin.leetcode.binary;

/**
 * <类详细描述> 给定一个只包含整数的有序数组，每个元素都会出现两次，唯有一个数只会出现一次，找出这个数。
 *          注意: 您的方案应该在 O(log n)时间复杂度和 O(1)空间复杂度中运行。
 *
 * @author luhanlin
 * @version [V_1.0.0, 2020-07-09 18:26]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class N540SingleNonDuplicate {

    /**
     * 二分查找，判断奇偶
     * @param nums
     * @return
     */
    public int singleNonDuplicate(int[] nums) {
        int l = 0;
        int r = nums.length - 1;

        while (l < r) {
            int mid = (l + r) >>> 1;

            boolean flag = (mid - l) % 2 == 0;  // 判断左边序列是否为偶数
            if (nums[mid] == nums[mid-1]) {
                if (flag) {
                    // 此时删除重复数后，左边为奇数
                    r = mid - 2;
                } else {
                    l = mid + 1;
                }
            } else if (nums[mid] == nums[mid+1]) {
                if (flag) {
                    l = mid + 2;
                } else {
                    r = mid - 1;
                }
            } else {
                return nums[mid];
            }
         }
        return nums[l];
    }

    /**
     * 根据索引判断
     * @param nums
     * @return
     */
    public int singleNonDuplicate2(int[] nums) {
        int l = 0;
        int r = nums.length - 1;

        while (l < r) {
            int mid  = l + (r-l)/2;
            if (mid % 2 == 1) mid--; // 保证左边为偶数

            if (nums[mid] == nums[mid+1]) {
                l = mid + 2;
            } else {
                r = mid;
            }
        }
        return nums[r];
    }
}
