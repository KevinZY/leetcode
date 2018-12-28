package com.zhangyang.leetcode.recursion;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Collection;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by zhangyang on 2018/12/11.
 */

public class PermutationsTest {
    @Test
    public void permute() throws Exception {

        int[] a = {1,2,3,4,5,6,7,8,9,10};

        List<List<Integer>> list = new Permutations().permute(a);

//        list.forEach(System.out::println);
    }
}