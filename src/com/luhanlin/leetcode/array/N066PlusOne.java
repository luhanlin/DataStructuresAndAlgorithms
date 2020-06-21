package com.luhanlin.leetcode.array;

/**
 * 类详细描述：
 *
 * @author Mr_lu
 * @version 1.0
 * @mail allen_lu_hh@163.com
 * 创建时间：2020/6/20 8:23 下午
 */
public class N066PlusOne {

    public static int[] plusOne(int[] digits){
        for (int i = digits.length - 1; i >= 0 ; i--) {
            digits[i] ++;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0) {
                return digits;
            }
        }
        if (digits[0] == 0) {
            // 最高位为9，例如 999 加1 需扩充数组
            int[] res = new int[digits.length + 1];
            // 由于需要扩容的数一定后续数据都为0
            res[0] = 1;
            return res;
        }
        return digits;
    }
}
