package com.luhanlin.leetcode.array;

/**
 * 类详细描述：有两种特殊字符。第一种字符可以用一比特0来表示。第二种字符可以用两比特(10 或 11)来表示。
 *
 * 现给一个由若干比特组成的字符串。问最后一个字符是否必定为一个一比特字符。给定的字符串总是由0结束。
 *
 * @author Mr_lu
 * @version 1.0
 * @mail allen_lu_hh@163.com
 * 创建时间：2020/6/26 1:45 下午
 */
public class N717OneBitCharacter {

    public boolean isOneBitCharacter(int[] bits) {
        if (bits.length < 1) return true;

        // 寻找数据末尾连续1 的个数
        int count = 0;
        for (int i = bits.length - 2; i >=0; i--) {
            if (bits[i] == 1) {
                count++;
            } else {
                break;
            }
        }
        return count % 2 == 0;
    }
}
