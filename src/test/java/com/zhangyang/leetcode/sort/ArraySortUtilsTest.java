package com.zhangyang.leetcode.sort;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

/**
 * Created by zhangyang on 2018/10/30.
 */
@RunWith(Parameterized.class)
public class ArraySortUtilsTest {
    private int[] input;

    private int[] expected;

    public ArraySortUtilsTest(int[] input, int[] expected) {
        this.input = input;
        this.expected = expected;
    }

    @Test
    public void mergeSort() throws Exception {
        ArraySortUtils.mergeSort(input);
        for (int i = 0; i < expected.length; i++) {
            Assert.assertEquals(expected[i], input[i]);
        }
    }

    @Test
    public void quickSort() throws Exception {
        ArraySortUtils.quickSort(input);
        Assert.assertArrayEquals(expected, input);
//        for (int i = 0; i < expected.length; i++) {
//            Assert.assertEquals(expected[i], input[i]);
//        }
    }


    @Parameterized.Parameters
    public static Collection params() {
        return Arrays.asList(new Object[][]{
                {new int[]{1, 2, 5, 1, 2, 4, 5}, new int[]{1, 1, 2, 2, 4, 5, 5}},
                {new int[]{90, 99, 29, 37, 42}, new int[]{29, 37, 42, 90, 99}},
                {new int[]{83, 28, 23, 47, 10, 93}, new int[]{10, 23, 28, 47, 83, 93}},
                {new int[]{198,185, 165, 126, 124, 123, 115, 102, 101, 100, 98, 45, 42, 35, 23, 10}, new int[]{}}
        });
    }

}