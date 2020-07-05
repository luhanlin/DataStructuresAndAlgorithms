package com.luhanlin.leetcode.array;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;

/**
 * 类详细描述：
 冬季已经来临。 你的任务是设计一个有固定加热半径的供暖器向所有房屋供暖。

 现在，给出位于一条水平线上的房屋和供暖器的位置，找到可以覆盖所有房屋的最小加热半径。

 所以，你的输入将会是房屋和供暖器的位置。你将输出供暖器的最小加热半径。
 *
 * @author Mr_lu
 * @version 1.0
 * @mail allen_lu_hh@163.com
 * 创建时间：2020/6/30 3:21 下午
 */
public class N475Radius {

    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(heaters);

        int res = 0;
        for (int i = 0; i < houses.length; i++) {

            int l = 0;
            int r = heaters.length - 1;

            while (l < r) {
                int mid = l + (r - l) / 2;

                if (heaters[mid] < houses[i]) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }
            if (heaters[l] == houses[i]) continue;

            if (heaters[l] < houses[i]) { // 这种情况l 走到了末尾
                res = Math.max(res, houses[i] - heaters[l]);
            } else if (l == 0) {    // house 在l左侧
                res = Math.max(res, heaters[l] - houses[i]);
            } else {
                int longest = Math.min(heaters[l] - houses[i], houses[i] - heaters[l-1]);
                res = Math.max(res, longest);
            }
        }

        return res;
    }
}
