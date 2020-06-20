package com.luhanlin.leetcode.array;

import java.util.HashMap;

/**
 * 类详细描述：给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 *
 * 示例:
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 * @author Mr_lu
 * @version 1.0
 * @mail allen_lu_hh@163.com
 * 创建时间：2020/6/18 10:28 上午
 */
public class N001TwoSum {

    public static int[] twoSum(int[] nums, int target) {
//        if (target < 0) return null;

        // 返回结果数据
        int[] result = new int[2];

//        int length = nums.length;

        // 建立k-v ，一一对应的哈希表
        HashMap<Integer,Integer> hash = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(hash.containsKey(nums[i])){
                result[0] = i;
                result[1] = hash.get(nums[i]);
                return result;
            }
            // 将数据存入 key为补数 ，value为下标
            hash.put(target-nums[i],i);
        }

//        for (int i = 0; i < length; i++) {
//            int tmp = target - nums[i];
//
////            if (tmp < 0) continue;
//
//            for (int j = i+1; j < length; j++) {
//                if (nums[j] == tmp) {
//                    result[0] = i;
//                    result[1] = j;
//                    return result;
//                }
//            }
//        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-1, -2, -3, -4, -5, 2, 7, 11, 15};

        int[] result = twoSum(nums, -8);
        System.out.println(result[0] + "," + result[1]);
    }
}
