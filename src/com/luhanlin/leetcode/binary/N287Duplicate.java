package com.luhanlin.leetcode.binary;

/**
 * <类详细描述> 给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），
 * 可知 至少 存在一个重复的整数。假设只有一个重复的整数，找出这个重复的数。
 *
 * @author luhanlin
 * @version [V_1.0.0, 2020-07-09 09:24]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class N287Duplicate {

    /**
     * 使用二分法
     * @param nums
     * @return
     */
    public int findDuplicate(int[] nums) {
        int left = 1;
        int right = nums.length-1;

        while (left < right) {
            int count = 0;
            int mid = (left + right) >>> 1;
            for (int num : nums) {
                if (num <= mid) {
                    count++;
                }
            }

            if (count > mid) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    /**
     * 使用环入口即为重复数
     * @param nums
     * @return
     */
    public int findDuplicate2(int[] nums) {
        int slow = 0;
        int fast = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        // 相遇后
        fast = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return fast;
    }
}
