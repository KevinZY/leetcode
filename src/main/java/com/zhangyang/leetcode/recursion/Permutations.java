package com.zhangyang.leetcode.recursion;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by zhangyang on 2018/12/10.
 */

//Given a collection of distinct integers, return all possible permutations.
public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> results = new LinkedList<>();
        if (nums.length == 1) {
            results.add(Collections.singletonList(nums[0]));
        } else if (nums.length == 2) {
            results.add(Arrays.asList(nums[0], nums[1]));
            results.add(Arrays.asList(nums[1], nums[0]));
        } else if (nums.length > 2) {
            for (int i = 0; i < nums.length; i++) {
                int num = nums[i];
                int[] subNum = new int[nums.length - 1];
                System.arraycopy(nums, 0, subNum, 0, i);
                int length = nums.length - i - 1;
                if (length > 0) {
                    System.arraycopy(nums, i + 1, subNum, i, length);
                }
                List<List<Integer>> permute = permute(subNum);
                List<List<Integer>> collect = permute.stream().map(p -> {
                    LinkedList<Integer> integers = new LinkedList<>(p);
                    integers.addFirst(num);
                    return integers;
                }).collect(Collectors.toList());
                results.addAll(collect);
            }
        }
        return results;
    }
}
