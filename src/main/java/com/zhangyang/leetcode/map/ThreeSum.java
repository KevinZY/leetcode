package com.zhangyang.leetcode.map;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * #15
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 * Note:
 * The solution set must not contain duplicate triplets.
 * <p>
 * Example:
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 * A solution set is:
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 */
public class ThreeSum {
    public static void main(String[] args) {
        ThreeSum threeSum = new ThreeSum();
        List<List<Integer>> lists = threeSum.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        System.out.println(lists);
        lists = threeSum.threeSum(new int[]{-1, 0, 1});
        System.out.println(lists);
        lists = threeSum.threeSum(new int[]{2, -1, -4});
        System.out.println(lists);

        lists = threeSum.threeSum(new int[]{});
        System.out.println(lists);
        lists = threeSum.threeSum(null);
        System.out.println(lists);
        lists = threeSum.threeSum(new int[]{-1, 1});
        System.out.println(lists);
    }

    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) return Collections.emptyList();
        List<List<Integer>> twins = collectTwins(nums);
        return twins.stream().map(twin -> findTriplets(nums, twin))
                .filter(list -> !list.isEmpty())
                .distinct()
                .collect(Collectors.toList());
    }

    private List<List<Integer>> collectTwins(int[] nums) {
        List<List<Integer>> records = new ArrayList<>(nums.length * nums.length / 2);
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                records.add(Arrays.asList(i, j, nums[i] + nums[j]));
            }
        }
        return records;
    }

    private List<Integer> findTriplets(int[] nums, List<Integer> record) {
        Integer indexOne = record.get(0);
        Integer indexTwo = record.get(1);
        Integer sum = record.get(2);
        int target = 0 - sum;
        int indexThree = -1;
        for (int i = 0; i < nums.length; i++) {
            if (i == indexOne || i == indexTwo) continue;
            if (nums[i] == target) {
                indexThree = i;
                break;
            }
        }
        List<Integer> list = new ArrayList<>(3);
        if (indexThree >= 0) {
            list.add(nums[indexOne]);
            list.add(nums[indexTwo]);
            list.add(nums[indexThree]);
            list.sort(null);
        }
        return list;
    }
}