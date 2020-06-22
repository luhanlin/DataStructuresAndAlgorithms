package com.luhanlin.leetcode.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 类详细描述：
     给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。

     你可以假设数组是非空的，并且给定的数组总是存在多数元素。

     示例 1:

     输入: [3,2,3]
     输出: 3
     示例 2:

     输入: [2,2,1,1,1,2,2]
     输出: 2
 *
 * @author Mr_lu
 * @version 1.0
 * @mail allen_lu_hh@163.com
 * 创建时间：2020/6/22 8:44 上午
 */
public class N169MajorityElement {

    /**
     * 枚举法
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        if (nums == null) return -1;

        Map<Integer,Integer> counts = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (counts.get(nums[i]) == null){
                counts.put(nums[i],1);
            } else {
                counts.put(nums[i],counts.get(nums[i])+1);
            }
        }

        Map.Entry<Integer,Integer> majority = null;
        for (Map.Entry<Integer,Integer> entry : counts.entrySet()) {
            if (majority == null || entry.getValue() > majority.getValue()) {
                majority = entry;
            }
        }

        return majority.getKey();
    }

    /**
     * 排序法
     * @param nums
     * @return
     */
    public int majorityElement2(int[] nums) {
        Arrays.sort(nums);

        return nums[nums.length >> 1];
    }

    /**
     * 分治法
     * @param nums
     * @return
     */
    public int majorityElement3(int[] nums) {
        return majorityElement3Rec(nums, 0, nums.length-1);
    }

    private int majorityElement3Rec(int[] nums, int left, int right) {
        if (left == right) {
            return nums[left];
        }

        int mid  = left + (right - left)/2;
        int leftMajority = majorityElement3Rec(nums, left, mid);
        int rightMajority = majorityElement3Rec(nums, mid + 1, right);

        if (leftMajority == rightMajority) {
            return leftMajority;
        }

        // 如果左右众数不同，这判定两边众数出现的次数大小
        int leftCount = 0;
        int rightCount = 0;
        for (int i = left; i <= right; i++) {
            if (nums[i] == leftMajority) leftCount++;
            if (nums[i] == rightMajority) rightCount++;
        }

        return leftCount > rightCount ? leftMajority : rightMajority;
    }

    /**
     * 投票法
     * @param nums
     * @return
     */
    public int majorityElement4(int[] nums) {
        int count = 0;
        int majority = -1;
        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                majority = nums[i];
            }

            count += (nums[i] == majority ? 1 : -1);
        }

        return majority;
    }

}
