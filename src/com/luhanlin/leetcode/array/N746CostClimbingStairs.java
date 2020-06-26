package com.luhanlin.leetcode.array;

/**
 * 类详细描述：数组的每个索引作为一个阶梯，第 i个阶梯对应着一个非负数的体力花费值 cost[i](索引从0开始)。
 *
 * 每当你爬上一个阶梯你都要花费对应的体力花费值，然后你可以选择继续爬一个阶梯或者爬两个阶梯。
 *
 * 您需要找到达到楼层顶部的最低花费。在开始时，你可以选择从索引为 0 或 1 的元素作为初始阶梯。
 *
 * @author Mr_lu
 * @version 1.0
 * @mail allen_lu_hh@163.com
 * 创建时间：2020/6/26 4:01 下午
 */
public class N746CostClimbingStairs {

    /**
     * 动态规划求解 f(i) = min(f(i),f(i-1))
     * @param cost
     * @return
     */
    public int minCostClimbingStairs(int[] cost) {
        int m = 0;      // f(i-1)
        int n = Math.min(cost[0], cost[1]); // f(i)
        int minCost = 0;

        for (int i = 2; i < cost.length; i++) {
            minCost = Math.min(m + cost[i-1], n + cost[i]);
            m = n;
            n = minCost;
        }

        return minCost;
    }

    public int minCostClimbingStairs2(int[] cost) {
        for (int i = 2; i < cost.length; i++) {
            cost[i] = Math.min(cost[i-2],cost[i-1]) + cost[i];
        }

        return Math.min(cost[cost.length-2], cost[cost.length-1]);
    }

}
