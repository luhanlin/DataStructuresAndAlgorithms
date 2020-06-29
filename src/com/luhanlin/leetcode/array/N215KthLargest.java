package com.luhanlin.leetcode.array;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * 类详细描述：在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 *
 * 示例 1:
 *
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * 示例 2:
 *
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 * 说明:
 *
 * 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
 *
 * @author Mr_lu
 * @version 1.0
 * @mail allen_lu_hh@163.com
 * 创建时间：2020/6/29 7:59 上午
 */
public class N215KthLargest {


    /**
     * 基于快排的思想
     * @param nums
     * @param k
     * @return
     */
    public static int findKthLargest(int[] nums, int k) {
        if (nums.length < k) {
            return -1;
        }

        int left = 0;
        int right = nums.length -1;
        k = nums.length - k;

        return sort(nums, left, right,k);
    }

    private static int sort(int[] nums, int left, int right, int k) {
        if (left >= right) return -1;

        int mid = partition(nums,left,right);
        if (k < mid + 1) {
            return sort(nums, left, mid - 1, k);
        } else if (k > mid + 1) {
            return sort(nums, mid + 1, right, k);
        } else  {
            return nums[mid];
        }
    }

    private static int partition(int[] nums, int left, int right) {
        if (left < right) {
            int randomIndex = left + 1 + new Random().nextInt(right - left);
            swap(nums, randomIndex, right);
        }
        int pivot = nums[right];

//        while (left < right) {
//            while (left < right && nums[left] > pivot) {
//                left++;
//            }
//            if (left < right) {
//                nums[right--] = nums[left];
//            }
//            while (left < right && pivot > nums[right]) {
//                right--;
//            }
//            if (left < right) {
//                nums[left++] = nums[right];
//            }
//        }
//
//        nums[left] = pivot;
//        return left;
        int i = left;
        for (int j = left; j < right; j++) {
            if (nums[j] < pivot) {
                swap(nums, i, j);
                i++;
            }
        }
        swap(nums, i, right);
        return i;

    }

    private static void swap(int[] nums, int i, int j) {
        if (i != j) {
            nums[i] = nums[i] ^ nums[j];
            nums[j] = nums[i] ^ nums[j];
            nums[i] = nums[i] ^ nums[j];
        }
    }


    /**
     * 排序法实现
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest2(int[] nums, int k) {
        if (nums.length < k) {
            return -1;
        }

        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    public int findKthLargest3(int[] nums, int k) {
        if (nums.length < k) {
            return -1;
        }

        // 维护一个大小为 k 的小顶堆
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int i = 0; i < nums.length; i++) {
            if (queue.size() < k) {
                queue.add(nums[i]);
            } else {
                if (queue.peek() < nums[i]) {
                    queue.poll();
                    queue.add(nums[i]);
                }
            }
        }
        return queue.peek();
    }

}
