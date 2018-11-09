package com.zhangyang.leetcode.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

/**
 * Created by zhangyang on 2018/11/2.
 */
public class ForkJoinMergeSort {

    public static void sort(int[] array) {
        SortTask sortTask = new SortTask(array);
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        forkJoinPool.invoke(sortTask);
        forkJoinPool.shutdown();
    }

    private static class SortTask extends RecursiveAction {

        private final int[] array;
        private final int lo;
        private final int hi;
        private final int pivot;

        public SortTask(int[] array) {
            this(array, 0, array.length - 1);
        }

        public SortTask(int[] array, int lo, int hi) {
            super();
            this.array = array;
            this.lo = lo;
            this.hi = hi;
            this.pivot = (hi + lo) >> 1;
        }

        @Override
        protected void compute() {
            ArrayList<SortTask> tasks = new ArrayList<>(2);
            if (lo == hi) return;
            if (pivot > lo) {
                tasks.add(new SortTask(array, lo, pivot));
            }
            if (pivot < hi) {
                tasks.add(new SortTask(array, pivot + 1, hi));
            }
            invokeAll(tasks);
            merge();
        }

        private void merge() {
            int[] tmp = new int[hi - lo + 1];
            int t = 0, i = lo, j = pivot + 1;
            while (i <= pivot && j <= hi) {
                if (array[i] <= array[j]) {
                    tmp[t++] = array[i++];
                } else {
                    tmp[t++] = array[j++];
                }
            }

            int start = i, end = pivot;
            if (j <= hi) {
                start = j;
                end = hi;
            }
            System.arraycopy(array, start, tmp, t, end - start + 1);
            System.arraycopy(tmp, 0, array, lo, tmp.length);
        }
    }
}
