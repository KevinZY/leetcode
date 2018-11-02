package com.zhangyang.leetcode.sort;

/**
 * Created by zhangyang on 2018/11/1.
 */
public class Apps {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length < 2) return;
        int size = nums.length, i = 0;
        while (i < size) {
            if (nums[i] != 0) {
                i++;
                continue;
            }
            int j = i;
            while (j < size - 1) {
                nums[j] = nums[j + 1];
                j++;
            }
            nums[j] = 0;
            size--;
        }
    }
}
