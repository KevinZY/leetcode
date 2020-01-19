package com.zhangyang.leetcode.map;

import java.util.*;

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
public class ThreeSum2 {
    public static void main(String[] args) {
        ThreeSum2 threeSum = new ThreeSum2();
        List<List<Integer>> lists = threeSum.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        System.out.println(lists);
        lists = threeSum.threeSum(new int[]{-1, 0, 1});
        System.out.println(lists);
        lists = threeSum.threeSum(new int[]{-2, 0, 1, 1, 2});
        System.out.println(lists);

        lists = threeSum.threeSum(new int[]{});
        System.out.println(lists);
        lists = threeSum.threeSum(null);
        System.out.println(lists);
        lists = threeSum.threeSum(new int[]{-1, 1});
        System.out.println(lists);
    }

    /**
     * 1. i, j两个指针可能出现一次k中发现多个满足要求的值
     * 2.
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) return Collections.emptyList();
        Arrays.sort(nums);
        Set<List<Integer>> result = new HashSet<>();
        for (int k = 0; nums[k] <= 0 && k < nums.length - 2; k++) {
            int target = -nums[k];
            int i = k + 1, j = nums.length - 1;
            while (i < j) {
                int tmp = nums[i] + nums[j];
                if (target == tmp) result.add(Arrays.asList(nums[k], nums[i++], nums[j--]));
                else if (tmp < target) i++;
                else j--;
            }
        }
        return new ArrayList<>(result);
    }
}
