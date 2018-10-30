package com.zhangyang.leetcode.sort;

/**
 * Created by zhangyang on 2018/10/28.
 */
public class SimpleSort {

    /**
     * Space: O(1)
     * Best Time: O(n)
     * Worst Time: O(n^2)
     *
     * @param a
     * @param size
     */
    public static void BubbleSort(int[] a, int size) {
        if (size < 2) return;
        for (int i = size - 1; i > 0; i--) {
            boolean hasChange = false;
            for (int j = 0; j < i; j++) {
                if (a[j] > a[j + 1]) { //stable
                    swap(a, j, j + 1);
                    hasChange = true;
                }
            }
            if (!hasChange) break;
        }
    }

    /**
     * Space: O(1)
     * Best Time: O(n)
     * Worst Time: O(n^2)
     *
     * @param data
     * @param size
     */
    public static void InsertSort(int[] data, int size) {
        if (size < 2) return;
        for (int i = 0; i < size; i++) {
            int val = data[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (data[j] > val) data[j + 1] = data[j]; //stable
                else break;
            }
            data[j + 1] = val;
        }
    }

    /**
     * Space: O(1)
     * Best Time: O(n^2)
     * Worst Time: O(n^2)
     *
     * @param data
     * @param size
     */
    public static void SelectSort(int[] data, int size) {
        if (size < 2) return;
        for (int i = 0; i < size - 1; i++) {
            int min = i;
            for (int j = i + 1; j < size; j++) {
                if (data[j] < data[min]) min = j;  //unstable
            }
            swap(data, i, min);
        }
    }

    private static void swap(int[] data, int i, int j) {
        if (i == j) return;
        data[i] = data[i] + data[j];
        data[j] = data[i] - data[j];
        data[i] = data[i] - data[j];
    }
}
