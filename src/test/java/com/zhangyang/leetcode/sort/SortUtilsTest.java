package com.zhangyang.leetcode.sort;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

/**
 * Created by yzhang on 2018/10/31.
 */
@RunWith(Parameterized.class)
public class SortUtilsTest {

    private int[] input;
    private int x;
    private int expected;

    public SortUtilsTest(int[] input, int x, int expected) {
        this.input = input;
        this.x = x;
        this.expected = expected;
    }

    @Test
    public void findX() throws Exception {
        int result = SortUtils.findX(input, input.length, this.x);
        Assert.assertEquals(expected, result);
    }

    @Parameterized.Parameters
    public static Collection params(){
        return Arrays.asList(new Object[][]{
                {new int[]{4,2,5,12,3}, 3, 4}
        });
    }

}