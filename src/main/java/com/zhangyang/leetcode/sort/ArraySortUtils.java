package com.zhangyang.leetcode.sort;

import java.util.Random;

/**
 * Created by zhangyang on 2018/10/30.
 */
public class ArraySortUtils {

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
            int pivot = partition(start, end);
            int left = pivot - 1;
            int right = pivot + 1;
            if (left > start) quickSort(start, left);
            if (right < end) quickSort(right, end);
        }

        private int partition(int start, int end) {
            int bound = new Random().nextInt(end + 1);
            int pivot = bound % (end - start + 1) + start;
            swap(array, pivot, end);
            pivot = start;
            for (int i = start; i < end; i++) {
                if (array[i] < array[end]) {
                    swap(array, pivot++, i);
                }
            }
            swap(array, pivot, end);
            return pivot;
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

        private MergeSort() {
        }

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
            if (left == right) return;
            int half = (left + right) / 2;
            if (half != left) mergeSort(left, half);
            if (half != right) mergeSort(half + 1, right);
            merge(left, half, right);
        }

        void merge(int left, int half, int right) {
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

            System.arraycopy(array, start, temp, t, end - start + 1);
            System.arraycopy(temp, 0, array, left, temp.length);
        }
    }
}
