package com.zhangyang.leetcode.sort;

import java.util.Arrays;

/**
 * Created by zhangyang on 2018/10/30.
 */
public class AdvanceSort {

    public static void mergeSort(int[] data) {
        MergeSort.of(data).sort();
    }

    public static void quickSort(int[] data) {
        QuickSort.of(data).sort();
    }

    private static class QuickSort {
        int[] array;

        static QuickSort of(int[] data) {
            QuickSort quickSort = new QuickSort();
            quickSort.array = data;
            return quickSort;
        }

        void sort() {
            quickSort(0, array.length - 1);
        }

        void quickSort(int start, int end) {
            int i = start;
            for (int j = start; j < end; j++) {
                if (array[j] < array[end]) {
                    swap(array, i++, j);  //unstable
                }
            }
            swap(array, i, end);
            System.out.println(Arrays.toString(array));
            if (i - 1 > start) quickSort(start, i - 1);
            if (i + 1 < end) quickSort(i + 1, end);
        }

        private static void swap(int[] data, int i, int j) {
            if (i == j) return;
            data[i] = data[i] + data[j];
            data[j] = data[i] - data[j];
            data[i] = data[i] - data[j];
        }
    }

    private static class MergeSort {
        int[] array;

        static MergeSort of(int[] data) {
            MergeSort mergeSort = new MergeSort();
            mergeSort.array = data;
            return mergeSort;
        }

        void sort() {
            mergeSort(0, array.length - 1);
        }

        /**
         * Time: nlog(n)
         *
         * @param left
         * @param right
         */
        void mergeSort(int left, int right) {
            System.out.println(Arrays.toString(array));
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
                if (array[i] <= array[j]) {  // stable
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
                array[left + x] = temp[x];
            }
        }
    }
}
