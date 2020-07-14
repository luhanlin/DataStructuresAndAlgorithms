package com.luhanlin.leetcode.array;

import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * <类详细描述> 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 *
 * @author luhanlin
 * @version [V_1.0.0, 2020-07-14 13:55]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class N347TopKFrequent {

    public static int[] topKFrequent(int[] nums, int k) {
        int[] res = new int[k];
        if (k == 0) return res;
        HashMap<Integer, Integer> map = new HashMap<>();

        // 计算数组重复元素
        for (int n: nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        // 创建小顶堆，存放k个元素
        PriorityQueue<Integer> queue = new PriorityQueue<>((n1, n2) -> map.get(n1) - map.get(n2));

        for (int key : map.keySet()) {
            queue.add(key);
            if (queue.size() > k) {
                queue.remove();
            }
        }
        int i = 0;
        while (!queue.isEmpty()) {
            res[i++] = queue.poll();
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {3, 0, 1, 0};
        topKFrequent(nums, 1);
    }
}
