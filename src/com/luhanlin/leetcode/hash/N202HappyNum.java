package com.luhanlin.leetcode.hash;

import java.util.HashSet;

/**
 * <类详细描述>
 *
 * @author luhanlin
 * @version [V_1.0.0, 2020-07-02 10:49]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class N202HappyNum {

    /**
     * 使用hashset
     * @param n
     * @return
     */
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        set.add(n);
        while (n != 1) {
            n = getNext(n);
            if (set.contains(n)) {
                return false;
            }
            set.add(n);
        }

        return true;
    }

    public boolean isHappy2(int n) {
        int slow = n;
        int fast = getNext(n);

        while (fast != 1) {
            if (slow == fast) return false;
            slow = getNext(slow);
            fast = getNext(getNext(fast));
        }
        return true;
    }

    public int getNext(int n){
        int sum = 0;
        while (n != 0) {
            int m = n % 10;
            n = n / 10;
            sum += m * m;
        }
        return sum;
    }
}
