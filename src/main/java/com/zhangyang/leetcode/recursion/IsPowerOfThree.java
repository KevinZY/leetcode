package com.zhangyang.leetcode.recursion;

/**
 * Created by zhangyang on 2018/10/28.
 */
public class IsPowerOfThree {
    public boolean isPowerOfThree(int n) {
        if (n > 3) {
            return n % 3 == 0 && isPowerOfThree(n / 3);
        }
        return n == 1 || n == 3;
    }
}
