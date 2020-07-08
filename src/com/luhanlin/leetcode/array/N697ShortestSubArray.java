package com.luhanlin.leetcode.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * 类详细描述：
 给定一个非空且只包含非负数的整数数组 nums, 数组的度的定义是指数组里任一元素出现频数的最大值。

 你的任务是找到与 nums 拥有相同大小的度的最短连续子数组，返回其长度。
 *
 * @author Mr_lu
 * @version 1.0
 * @mail allen_lu_hh@163.com
 * 创建时间：2020/6/24 6:47 下午
 */
public class N697ShortestSubArray {

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,2,2,3,1};

        System.out.println(findShortestSubArray(nums));
    }

    public static int findShortestSubArray(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        // 计数
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i],0) + 1);
        }
        // 找到最大的度 对应的数
        List<Integer> du = new ArrayList<>();
        Integer max = Collections.max(map.values());
        if (max == 1) return 1;
        for (Integer n: map.keySet()) {
            if (map.get(n) == max) {
                du.add(n);
            }
        }

        // 双指针寻找最短距离
        int res = nums.length;
        for (Integer num : du) {
            int l = 0;
            int j = nums.length - 1;
            while (l < j) {
                if (num == nums[l]) {
                    break;
                }
                l++;
            }
            while (l < j) {
                if (num == nums[j]) {
                    break;
                }
                j--;
            }

            res = Math.min(res, j - l + 1);
        }

        return res;
    }
}
