package com.luhanlin.leetcode.array;

/**
 * 类详细描述：斐波那契数，通常用 F(n) 表示，形成的序列称为斐波那契数列。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
 *
 * F(0) = 0,   F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 * 给定 N，计算 F(N)。
 *
 * @author Mr_lu
 * @version 1.0
 * @mail allen_lu_hh@163.com
 * 创建时间：2020/6/23 11:30 上午
 */
public class N509Fib {

    /**
     * 忽略递归方法，效率最低，重复计算度太高
     * 方式1：采用自底向上的方式
     * @param N
     * @return
     */
    public int fib(int N) {
        if (N < 2) {
            return N;
        }

        int pre2 = 0;
        int pre = 1;
        int res = 1;
        for (int i = 2; i <= N; i++) {
            res = pre + pre2;
            pre2 = pre;
            pre = res;
        }
        return res;
    }
}
