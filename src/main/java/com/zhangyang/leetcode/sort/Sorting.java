package com.zhangyang.leetcode.sort;

/**
 * Created by zhangyang on 2018/10/28.
 */
public class Sorting {

    /**
     * Space: O(1)
     * Best Time: O(n)
     * Worst Time: O(n*n)
     *
     * @param a
     * @param size
     */
    public static void BubbleSort(int[] a, int size) {
        if (size < 2) return;
        for (int i = size - 1; i > 0; i--) {
            boolean hasChange = false;
            for (int j = 0; j < i; j++) {
                if (a[j] > a[j + 1]) {
                    a[j] = a[j] + a[j + 1];
                    a[j + 1] = a[j] - a[j + 1];
                    a[j] = a[j] - a[j + 1];
                    hasChange = true;
                }
            }
            if (!hasChange) break;
        }
    }

    public static void InsertSort(int[] data, int size) {

    }

    public static void SelectSort(int[] data, int size) {

    }
}
