package com.luhanlin.leetcode.array;

/**
 * 类详细描述：给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 *
 * @author Mr_lu
 * @version 1.0
 * @mail allen_lu_hh@163.com
 * 创建时间：2020/6/18 2:19 下午
 */
public class N026RemoveDuplicates {

    /**
     * 使用双指针解法
     * @param nums
     * @return
     */
    public static int removeDuplicates2(int[] nums) {
        int length = nums.length;

        if (length < 2) return length;

        int i = 0;
        int j = 1;
        while (j < length) {
            if (nums[i] != nums[j]){
                nums[++i] = nums[j];
            }
            j++;
        }

        return i+1;
    }

    public static int removeDuplicates(int[] nums) {

        int length = nums.length;

        if (length <= 1) return 1;

        int duplicateCount; // 因为有序，可以查看重复多少元素

        for (int i = 0; i < length; i++) {
            duplicateCount = 0;
            // 找出单个元素有多少重复的元素
            for (int j = i+1; j < length; j++) {
                if (nums[i] == nums[j]){
                    duplicateCount ++;
                    continue;
                }
                break;
            }
            // 对数组进行位移
            if (duplicateCount > 0) {
                move(nums, length, i, duplicateCount);
                length -= duplicateCount;
            }
        }
        return length;
    }

    /**
     * 将下标 i + duplicateCount 后的元素移动到i之后
     * @param nums
     * @param i
     * @param duplicateCount
     */
    private static void move(int[] nums, int length, int i, int duplicateCount) {
        for (int j = i+1; j < length - duplicateCount; j++) {
            nums[j] = nums[j + duplicateCount];
        }
    }

    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};

        System.out.println(removeDuplicates2(nums));

        for (int i = 0; i <nums.length; i++) {
            System.out.print(nums[i]);
        }
    }
}
