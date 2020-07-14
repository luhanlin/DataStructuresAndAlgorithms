package com.luhanlin.leetcode.hash;

import java.util.HashMap;
import java.util.HashSet;

/**
 * <类详细描述> 给定一个未排序的整数数组，找出最长连续序列的长度。
 *
 * 要求算法的时间复杂度为 O(n)。
 *
 * @author luhanlin
 * @version [V_1.0.0, 2020-07-14 15:50]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class N128LongestConsecutive {

    /**
     * 使用两次遍历
     * @param nums
     * @return
     */
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int n : nums) {
            set.add(n);
        }

        int res = 0;
        for (int n: nums) {
            if (!set.contains(n-1)) {
                int curLen = 1;
                while (set.contains(n+1)) {
                    n++;
                    curLen++;
                }
                res = Math.max(res, curLen);
            }
        }

        return res;
    }

    /**
     * 单词遍历
     * @param nums
     * @return
     */
    public int longestConsecutive2(int[] nums) {
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int n : nums) {
            if (!map.containsKey(n)) {
                int leftLen = map.getOrDefault(n-1,0);
                int rightLen = map.getOrDefault(n+1,0);

                int curLen = 1 + leftLen + rightLen;

                res = Math.max(res, curLen);

                map.put(n, curLen);
                map.put(n-leftLen,curLen);
                map.put(n+rightLen, curLen);
            }
        }
        return res;
    }
}
