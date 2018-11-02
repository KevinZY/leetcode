package com.zhangyang.leetcode.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.TimeUnit;

/**
 * Created by zhangyang on 2018/11/2.
 */
public class ForkJoinMergeSort {
    public static void main(String[] args) throws InterruptedException {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        int[] input = new int[]{73, 59, 89, 38, 88};
        System.out.println(Arrays.toString(input));
        SortTask sortTask = new SortTask(input);
        forkJoinPool.execute(sortTask);
        forkJoinPool.shutdown();
        forkJoinPool.awaitTermination(2, TimeUnit.MINUTES);
        System.out.println(Arrays.toString(input));
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
            this.pivot = (hi + lo) / 2;
        }

        @Override
        protected void compute() {
            ArrayList<SortTask> tasks = new ArrayList<>(2);
            if (lo == hi) return;
            System.out.println("lo:" + lo + "; hi:" + hi + "; pivot:" + pivot + " {start: " + Arrays.toString(array) + "}");
            if (pivot > lo) {
                tasks.add(new SortTask(array, lo, pivot));
            }
            if (pivot < hi) {
                tasks.add(new SortTask(array, pivot + 1, hi));
            }
            invokeAll(tasks);
            merge();
            System.out.println("lo:" + lo + "; hi:" + hi + "; pivot:" + pivot + " {end: " + Arrays.toString(array) + "}");
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

            int start = lo, end = pivot;
            if (j <= hi) {
                start = j;
                end = hi;
            }
            for (int k = start; k <= end; k++) {
                tmp[t++] = array[k];
            }

            for (int x = 0; x < tmp.length; x++) {
                array[lo + x] = tmp[x];
            }
        }
    }
}
