package com.zhangyang.leetcode.search;

/**
 * Created by zhangyang on 2018/11/9.
 */
public class BinarySearch {
    public int search(int[] array, int value) {
        int lo = 0, hi = array.length - 1;
        int mid = lo + ((hi - lo) >> 1);
        while (lo <= hi) {
            if (array[mid] == value) return mid;
            else if (array[mid] < value) lo = mid + 1;
            else hi = mid - 1;
        }
        return -1;
    }
}
