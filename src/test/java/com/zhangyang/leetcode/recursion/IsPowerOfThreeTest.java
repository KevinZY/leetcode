package com.zhangyang.leetcode.recursion;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by zhangyang on 2018/10/28.
 */
public class IsPowerOfThreeTest {
    @Test
    public void isPowerOfThree() throws Exception {
        IsPowerOfThree isPowerOfThree = new IsPowerOfThree();
        boolean powerOfThree = isPowerOfThree.isPowerOfThree(0);
        boolean powerOfThree1 = isPowerOfThree.isPowerOfThree(1);
        boolean powerOfThree2 = isPowerOfThree.isPowerOfThree(2);
        boolean powerOfThree3 = isPowerOfThree.isPowerOfThree(3);
        boolean powerOfThree4 = isPowerOfThree.isPowerOfThree(4);
        boolean powerOfThree5 = isPowerOfThree.isPowerOfThree(27);
        boolean powerOfThree6 = isPowerOfThree.isPowerOfThree(9);
        boolean powerOfThree7 = isPowerOfThree.isPowerOfThree(45);
        return;
    }

}