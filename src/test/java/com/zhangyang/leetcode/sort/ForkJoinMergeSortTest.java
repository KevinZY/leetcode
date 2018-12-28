package com.zhangyang.leetcode.sort;

import org.junit.Before;
import org.junit.Test;

import java.util.Random;

/**
 * Created by zhangyang on 2018/11/3.
 */
public class ForkJoinMergeSortTest {

    private int[] input = new int[10000000];

    @Before
    public void init() {
        Random random = new Random();
        for (int i = 0; i < input.length; i++) {
            input[i] = random.nextInt(100000);
        }
    }

    @Test
    public void sort() throws Exception {
        long start = System.currentTimeMillis();
        ForkJoinMergeSort.sort(input);
        long end = System.currentTimeMillis();
//        System.out.println(Arrays.toString(input));
        System.out.println("fork/join time: " + (end - start));
    }

    @Test
    public void basicMergeSort() {
        long start = System.currentTimeMillis();
        ArraySortUtils.mergeSort(input);
        long end = System.currentTimeMillis();
//        System.out.println(Arrays.toString(input));
        System.out.println("single thread time: " + (end - start));
    }

}