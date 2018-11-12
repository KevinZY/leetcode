package com.zhangyang.leetcode.search;

/**
 * Created by zhangyang on 2018/11/9.
 */
public class BinarySearch {
    public int search(int[] array, int value) {
        int lo = 0, hi = array.length - 1;
        while (lo <= hi) {
            int mid = lo + ((hi - lo) >> 1);
            if (array[mid] == value) return mid;
            else if (array[mid] < value) lo = mid + 1;
            else hi = mid - 1;
        }
        return -1;
    }

    /**
     * 查找第一个值等于给定值的元素
     *
     * @param a
     * @param value
     * @return
     */
    public int search1(int[] a, int value) {
        int lo = 0, hi = a.length - 1;
        while (lo <= hi) {
            int mid = lo + ((hi - lo) >> 1);
            if (a[mid] > value) hi = mid - 1;
            else if (a[mid] < value) lo = mid + 1;
            else {
                if (mid == 0 || a[mid - 1] != value) return mid;
                hi = mid - 1;
            }
        }
        return -1;
    }

    /**
     * 查找最后一个值等于给定值的元素
     *
     * @param a
     * @param value
     * @return
     */
    public int search2(int[] a, int value) {
        int lo = 0, hi = a.length - 1;
        while (lo <= hi) {
            int mid = lo + ((hi - lo) >> 1);
            if (a[mid] < value) lo = mid + 1;
            else if (a[mid] > value) hi = mid - 1;
            else {
                if (mid == (a.length - 1) || a[mid + 1] != value) return mid;
                lo = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 查找第一个大于等于给定值的元素
     *
     * @param a
     * @param value
     * @return
     */
    public int search3(int[] a, int value) {
        int lo = 0, hi = a.length - 1;
        while (lo <= hi) {
            int mid = lo + ((hi - lo) >> 1);
            if (a[mid] < value) lo = mid + 1;
            else {
                if (mid == 0 || a[mid - 1] < value) return mid;
                hi = mid - 1;
            }
        }
        return -1;
    }

    /**
     * 查找最后一个小于等于给定值的元素
     *
     * @param a
     * @param value
     * @return
     */
    public int search4(int[] a, int value) {
        int lo = 0, hi = a.length - 1;
        while (lo <= hi) {
            int mid = lo + ((hi - lo) >> 1);
            if (a[mid] > value) hi = mid - 1;
            else {
                if (mid == (a.length - 1) || a[mid + 1] > value) return mid;
                lo = mid + 1;
            }
        }
        return -1;
    }
}
