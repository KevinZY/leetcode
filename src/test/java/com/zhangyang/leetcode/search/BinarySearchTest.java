package com.zhangyang.leetcode.search;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by zhangyang on 2018/11/12.
 */
public class BinarySearchTest {
    @Test
    public void search() throws Exception {
        BinarySearch binarySearch = new BinarySearch();
        int index = binarySearch.search(new int[]{1, 2, 3, 4, 5, 19, 82, 99}, 19);
        Assert.assertEquals(5, index);
    }

    @Test
    public void search1() throws Exception {
        BinarySearch binarySearch = new BinarySearch();
        int index = binarySearch.search1(new int[]{1, 4, 4, 4, 4, 19, 82, 99}, 4);
        Assert.assertEquals(1, index);
    }

    @Test
    public void search2() throws Exception {
        BinarySearch binarySearch = new BinarySearch();
        int index = binarySearch.search2(new int[]{1, 4, 4, 4, 4, 4, 4, 99}, 4);
        Assert.assertEquals(6, index);
    }

    @Test
    public void search3() throws Exception {
        BinarySearch binarySearch = new BinarySearch();
        int index = binarySearch.search3(new int[]{1, 2, 30, 40, 50, 60, 76, 99}, 10);
        Assert.assertEquals(2, index);
    }

    @Test
    public void search4() throws Exception {
        BinarySearch binarySearch = new BinarySearch();
        int index = binarySearch.search4(new int[]{1, 2, 30, 40, 50, 60, 76, 99}, 78);
        Assert.assertEquals(6, index);
    }

}