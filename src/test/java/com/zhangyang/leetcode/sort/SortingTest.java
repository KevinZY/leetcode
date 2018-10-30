package com.zhangyang.leetcode.sort;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

/**
 * Created by zhangyang on 2018/10/28.
 */

@RunWith(Parameterized.class)
public class SortingTest {

    private int[] input;
    private int[] expected;

    public SortingTest(int[] input, int[] expected) {
        this.input = input;
        this.expected = expected;
    }

    @Test
    public void bubbleSort() throws Exception {
        Sorting.BubbleSort(input, input.length);
        for (int i = 0; i < expected.length; i++) {
            Assert.assertEquals(expected[i], input[i]);
        }
    }

    @Test
    public void insertSort() throws Exception {
        Sorting.InsertSort(input, input.length);
        for (int i = 0; i < expected.length; i++) {
            Assert.assertEquals(expected[i], input[i]);
        }
    }

    @Test
    public void selectSort() throws Exception {
        Sorting.SelectSort(input, input.length);
        for (int i = 0; i < expected.length; i++) {
            Assert.assertEquals(expected[i], input[i]);
        }
    }


    @Parameterized.Parameters
    public static Collection params() {
        return Arrays.asList(new Object[][]{
                {new int[]{1, 2, 5, 1, 2, 4, 5}, new int[]{1, 1, 2, 2, 4, 5, 5}},
                {new int[]{83, 28, 23, 47, 10, 93}, new int[]{10, 23, 28, 47, 83, 93}}
        });
    }
}