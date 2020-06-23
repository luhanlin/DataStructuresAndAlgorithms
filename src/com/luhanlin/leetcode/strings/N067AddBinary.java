package com.luhanlin.leetcode.strings;

/**
 * 类详细描述：给你两个二进制字符串，返回它们的和（用二进制表示）。
 *
 * 输入为 非空 字符串且只包含数字 1 和 0。
 *
 * 示例 1:
 *
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * 示例 2:
 *
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 *
 * 提示：
 *
 * 每个字符串仅由字符 '0' 或 '1' 组成。
 * 1 <= a.length, b.length <= 10^4
 * 字符串如果不是 "0" ，就都不含前导零。
 *
 * @author Mr_lu
 * @version 1.0
 * @mail allen_lu_hh@163.com
 * 创建时间：2020/6/23 9:27 上午
 */
public class N067AddBinary {

    /**
     * 使用 低位逐步相加的方式
     * @param a
     * @param b
     * @return
     */
    public String addBinary(String a, String b){
        StringBuilder result = new StringBuilder();

        int cas = 0;

        for (int i = a.length()-1, j = b.length()-1; i >=0 || j>=0 ; i--,j--) {
            int sum = cas;
            // 需要短的进行 0 补齐
            sum += (i>=0 ? a.charAt(i) - '0' : 0); // '0' 的ASCII值 48,'1'-> 49
            sum += (j>=0 ? b.charAt(j) - '0' : 0);

            result.append(sum % 2);
            cas = sum >> 1;  //如果二者都为1  那么ca 应该刚好为1 否则为0 1>>1=0; 2>>1=1
        }

        // 判断最后一位是否进1
        if (cas == 1) {
            result.append(cas);
        }

        return result.reverse().toString();
    }

}
