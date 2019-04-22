package com.luhanlin.algorithms.compute;

import static java.lang.Math.abs;

/**
 * @description: 与 & 运算
 * @author: Mr.Lu
 * @create: 2019-04-22 14:22
 **/
public class WithCompute {

    public static void main(String[] args) {
        System.out.println(isPowerOf2(61));
        System.out.println(ChargeOnesCountInNum(15));
    }

    /**
     * 计算 a 是否是2 的乘方
     * @param a
     * @return
     */
    public static boolean isPowerOf2(int a){
        return (a & a-1) == 0;
    }


    /**
     * 计算 iNum有多少个二进制一位
     *      iNum - 1 会将iNum 最右端 1 变为0 ，后面的0 全部变为1
     * @param iNum
     * @return
     */
    public static int ChargeOnesCountInNum(int iNum)
    {
        int iCount=0;
        iNum = abs(iNum);//注意添加上了绝对值
        while(iNum != 0){
            ++iCount;
            iNum = iNum & (iNum-1);
        }

        return iCount;
    }
}
