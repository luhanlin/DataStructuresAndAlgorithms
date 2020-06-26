package com.luhanlin.leetcode.array;

import java.util.Arrays;

/**
 * 类详细描述：给定一个包括 n 个整数的数组 nums 和 一个目标值 target。
 * 找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 *
 * 示例：
 *
 * 输入：nums = [-1,2,1,-4], target = 1
 * 输出：2
 * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
 *
 * @author Mr_lu
 * @version 1.0
 * @mail allen_lu_hh@163.com
 * 创建时间：2020/6/24 4:19 下午
 */
public class N016ThreeSumClosest {

    /**
     * 使用排序以及双指针
     * @param nums
     * @param target
     * @return
     */
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);

        int len = nums.length;

        if (len < 3) return -1;

        int res = nums[0] + nums[1] + nums[2];

        for (int i = 0; i < len-1; i++) {
            if (i > 0 && nums[i-1] == nums[i]) {
                continue;
            }

            // 双指针
            int l = i+1;
            int r = len-1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum < target) {
                    l++;
                    while (l<r && nums[l] == nums[l-1]){
                        l++;
                    }

                } else if (sum > target) {
                    r--;
                    while (l<r && nums[r] == nums[r+1]) {
                        r--;
                    }
                } else {
                    return sum;
                }

                if (Math.abs(target - sum) < Math.abs(target - res)) {
                    res = sum;
                }
            }
        }

        return res;
    }

}
