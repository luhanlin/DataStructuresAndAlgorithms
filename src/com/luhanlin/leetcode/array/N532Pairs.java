package com.luhanlin.leetcode.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * 类详细描述：给定一个整数数组和一个整数 k, 你需要在数组里找到不同的 k-diff 数对。这里将 k-diff 数对定义为一个整数对 (i, j), 其中 i 和 j 都是数组中的数字，且两数之差的绝对值是 k.
 *
 * @author Mr_lu
 * @version 1.0
 * @mail allen_lu_hh@163.com
 * 创建时间：2020/6/23 2:15 下午
 */
public class N532Pairs {

    /**
     * 采用hashMap
     * @param nums
     * @param k
     * @return
     */
    public int findPairs(int[] nums, int k) {
        if (k<0) return 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            map.putIfAbsent(nums[i],0);
            map.put(nums[i], map.get(nums[i]) + 1);
        }

        for (Integer num : map.keySet()) {
            if (k == 0) {
                if (map.get(num) > 1) {
                    count++;
                }
            } else {
                if (map.containsKey(num + k)) {
                    count++;
                }
            }
        }
        return count;
    }

    public int findPairs2(int[] nums, int k) {
        if (k<0) return 0;
        Set<Integer> diff = new HashSet<>();
        Set<Integer> keySet = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {

            if (keySet.contains(nums[i] + k)) {
                diff.add(nums[i]);
            }
            if (keySet.contains(nums[i] - k)) {
                diff.add(nums[i] - k);
            }
            keySet.add(nums[i]);
        }

        return diff.size();
    }

    /**
     * 排序 双指针
     * @param nums
     * @param k
     * @return
     */
    public int findPairs3(int[] nums, int k) {
        if (k < 0) return 0;

        Arrays.sort(nums);

        int left = 0;
        int right = 1;
        int count = 0;

        int len = nums.length;
        while(right < len) {
            int t = nums[right] - nums[left];

            if (t < k) {
                right++;
            } else if (t > k){
                left++;
            } else {
                count++;
                left++;
                right++;
            }

            // 找到第一位后，需要将后续相同的数字跳过
            while (right < len && nums[right] == nums[right - 1]) {
                right++;
            }
            while (left < len && left > 0 && nums[left] == nums[left - 1]) {
                left++;
            }

            // 比如 k = 0; 数组【1，1，3，4，5】 第一次查到后，left = right = 2
            if (left >= right) {
                right = left + 1;
            }
        }

        return count;
    }
}
