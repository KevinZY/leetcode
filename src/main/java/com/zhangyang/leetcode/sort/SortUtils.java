package com.zhangyang.leetcode.sort;

/**
 * Created by yzhang on 2018/10/31.
 */
public class SortUtils {
    /**
     * 找到数组中第N 大的元素
     * Time: O(n)
     *
     * @param array
     * @param x
     */
    public static int findX(int[] array, int length, int x) throws Exception {
        if (length < 1 || x > length) throw new Exception();
        if (length < 2) return array[0];
        return quickSort(array, 0, length - 1, x);
    }

    private static int quickSort(int[] array, int start, int end, int x) {
        int i = start;
        for (int j = start; j < end; j++) {
            if (array[j] > array[end]) {
                swapElement(array, i++, j);
            }
        }
        swapElement(array, i, end);
        if ((i + 1) == x) return array[i];
        else if ((i + 1) < x) return quickSort(array, i + 1, end, x);
        else return quickSort(array, start, i - 1, x);
    }

    private static void swapElement(int[] a, int i, int j) {
        if (i == j) return;
        a[i] = a[i] + a[j];
        a[j] = a[i] - a[j];
        a[i] = a[i] - a[j];
    }
}
