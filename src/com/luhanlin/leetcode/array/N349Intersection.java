package com.luhanlin.leetcode.array;

import java.util.Arrays;
import java.util.HashSet;

/**
 * 类详细描述：给定两个数组，编写一个函数来计算它们的交集。
 *
 * @author Mr_lu
 * @version 1.0
 * @mail allen_lu_hh@163.com
 * 创建时间：2020/6/29 4:53 下午
 */
public class N349Intersection {

    /**
     * 双hash解法
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> inc = new HashSet<>();

        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }

        for (Integer num : nums2) {
            if (set.contains(num)) {
                inc.add(num);
            }
        }

        int[] res = new int[inc.size()];
        int m = 0;
        for (Integer n : inc) {
            res[m++] = n;
        }

        return res;
    }

    /**
     * 使用双指针
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersection2(int[] nums1, int[] nums2) {
        // 排序
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int n1 = nums1.length;
        int n2 = nums2.length;
        int[] res = new int[Math.min(n1, n2)];

        int i = 0;
        int j = 0;
        int k = 0;
        while (i < n1 && j < n2) {
            if (nums1[i] == nums2[j]) {
                res[k++] = nums1[i++];
                j++;
                // 排除相同数据
                while (i < n1) {
                    if (nums1[i] == nums1[i - 1]) i++;
                }
                while (j < n2) {
                    if (nums1[j] == nums1[j - 1]) j++;
                }
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }

        return Arrays.copyOfRange(res, 0, k);
    }

}
