package com.zhangyang.leetcode.array;

/**
 * Created by zhangyang on 2018/10/26.
 * Given a sorted array nums, remove the duplicates in-place such that each element appear only once and return the new length.
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 */
public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        int p1 = 0;
        for (int p2 = 1; p2 < nums.length; p2++) {
            if (nums[p2] != nums[p1]) {
                nums[++p1] = nums[p2];
            }
        }
        return p1 + 1;
    }
}
