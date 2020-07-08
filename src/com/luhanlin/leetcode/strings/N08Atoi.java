package com.luhanlin.leetcode.strings;

/**
 * <类详细描述>请你来实现一个 atoi 函数，使其能将字符串转换成整数。
 *
 * 首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。接下来的转化规则如下：
 *
 * 如果第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字字符组合起来，形成一个有符号整数。
 * 假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成一个整数。
 * 该字符串在有效的整数部分之后也可能会存在多余的字符，那么这些字符可以被忽略，它们对函数不应该造成影响。
 * 注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换，即无法进行有效转换。
 *
 * 在任何情况下，若函数不能进行有效的转换时，请返回 0 。
 *
 * 提示：
 *
 * 本题中的空白字符只包括空格字符 ' ' 。
 * 假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 [−2^31,  2^31 − 1]。如果数值超过这个范围，请返回  INT_MAX (2^31 − 1) 或 INT_MIN (−2^31) 。
 *
 * @author luhanlin
 * @version [V_1.0.0, 2020-07-07 14:34]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class N08Atoi {

    public int myAtoi(String str) {
        int n = str.length();
        if (n == 0) return 0;
        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;
        int res = 0;
        int index = 0;
        boolean flag = false;

        while (index < n && str.charAt(index) == ' ') {
            index++;
        }
        // 此时index指向符号位
        if (index == n) return 0;

        if (str.charAt(index) == '-') {
            index++;
            flag = true;
        } else if (str.charAt(index) == '+') {
            index++;
        } else if (Character.isDigit(str.charAt(index))) {
            // 不进行任何操作
        } else {
            return 0;
        }

        while (index < n && Character.isDigit(str.charAt(index))) {
            int digit = str.charAt(index) - '0';
            if (res > (max - digit)/10) {
                return flag ? min : max;
            }
            res = res * 10 + digit;
            index++;
        }

        return flag ? -res : res;
    }

}
