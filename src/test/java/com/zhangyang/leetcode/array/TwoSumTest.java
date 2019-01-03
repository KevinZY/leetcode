package com.zhangyang.leetcode.array;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by zhangyang on 2018/12/28.
 */
public class TwoSumTest {
    @Test
    public void twoSum() throws Exception {
        int[] data = new int[]{2, 9, 7, 10};
        int[] result = new TwoSum().twoSum2(data, 12);
        Assert.assertArrayEquals(new int[]{0, 3}, result);
    }

}