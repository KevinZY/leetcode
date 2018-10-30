package com.zhangyang.leetcode.sort;

/**
 * Created by zhangyang on 2018/10/30.
 */
public class AdvanceSort {

    public static int mergeSort(int[] data) {
        MergeSort mergeSort = MergeSort.of(data);
        mergeSort.sort();
        return mergeSort.count;
    }

    public static void quickSort() {

    }

    private static class MergeSort {
        int[] array;
        int count = 0;

        static MergeSort of(int[] data) {
            MergeSort mergeSort = new MergeSort();
            mergeSort.array = data;
            return mergeSort;
        }

        void sort() {
            mergeSort(0, array.length - 1);
        }

        void mergeSort(int left, int right) {
            if (left == right) return;
            int half = (left + right) / 2;
            if (half != left) mergeSort(left, half);
            if (half != right) mergeSort(half + 1, right);
            join(left, half, right);
        }

        void join(int left, int half, int right) {
            int[] temp = new int[right - left + 1];
            int t = 0, i = left, j = half + 1;
            while (i <= half && j <= right) {
                if (array[i] <= array[j]) {
                    temp[t++] = array[i++];
                } else {
                    temp[t++] = array[j++];
                }
            }
            int start = i, end = half;
            if (j <= right) {
                start = j;
                end = right;
            }
            for (int k = start; k <= end; k++) {
                temp[t++] = array[k];
            }

            for (int x = 0; x < temp.length; x++) {
                count++;
                array[left + x] = temp[x];
            }
        }
    }
}
