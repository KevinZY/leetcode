package com.zhangyang.leetcode.search;

/**
 * Created by zhangyang on 2018/11/9.
 */
public class SQRT {
    public double mySqrt(double x) {
        if (x < 0) return -1;
        if (x == 0) return 0;
        if (x == 1) return 1;
        double lo, hi;
        if (x < 1) {
            lo = x;
            hi = 1;
        } else {
            lo = 1;
            hi = x;
        }
        double mid = -1;
        while (lo <= hi) {
            mid = (lo + hi) / 2;
            double sqrt = mid * mid;
            if (sqrt == x) {
                break;
            } else if (sqrt < x) {
                lo = mid;
            } else {
                hi = mid;
            }
        }
        return mid;
    }
}
