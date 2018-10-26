package com.zhangyang.leetcode.array;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

/**
 * Created by zhangyang on 2018/10/26.
 */
@RunWith(Parameterized.class)
public class RemoveDuplicatesTest {
    private int[] input;
    private int[] expected;

    public RemoveDuplicatesTest(int[] input, int[] expected) {
        this.input = input;
        this.expected = expected;
    }

    @Test
    public void removeDuplicates() throws Exception {
        int i = new RemoveDuplicates().removeDuplicates(input);
        Assert.assertEquals(expected.length, i);
        for (int i1 = 0; i1 < expected.length; i1++) {
            Assert.assertEquals(expected[i1], input[i1]);
        }
    }

    @Parameterized.Parameters
    public static Collection params() {
        return Arrays.asList(new Object[][]{
                {new int[]{1, 1, 2}, new int[]{1, 2}},
                {new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}, new int[]{0, 1, 2, 3, 4}},
                {new int[]{1}, new int[]{1}},
        });
    }
}