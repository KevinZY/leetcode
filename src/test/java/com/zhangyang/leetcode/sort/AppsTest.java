package com.zhangyang.leetcode.sort;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

/**
 * Created by zhangyang on 2018/11/1.
 */
@RunWith(Parameterized.class)
public class AppsTest {
    private int[] input;
    private int[] expected;

    public AppsTest(int[] input, int[] expected) {
        this.input = input;
        this.expected = expected;
    }

    @Test
    public void moveZeroes() throws Exception {
        new Apps().moveZeroes(input);
        Assert.assertArrayEquals(expected, input);
    }

    @Parameterized.Parameters
    public static Collection params() {
        return Arrays.asList(new Object[][]{
                {new int[]{0, 1, 0, 3, 12}, new int[]{1, 3, 12, 0, 0}},
                {new int[]{0, 0, 1}, new int[]{1, 0, 0}},
        });
    }
}