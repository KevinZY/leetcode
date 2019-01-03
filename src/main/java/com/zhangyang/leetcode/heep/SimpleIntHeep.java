package com.zhangyang.leetcode.heep;

/**
 * Created by zhangyang on 2018/12/29.
 */
public class SimpleIntHeep implements IntHeep {

    public static void main(String[] args) {
        SimpleIntHeep simpleIntHeep = new SimpleIntHeep();
        simpleIntHeep.add(2);
        simpleIntHeep.add(8);
        simpleIntHeep.add(2);
        simpleIntHeep.add(82);
        simpleIntHeep.add(9);
        simpleIntHeep.add(1);
    }

    private static final int DEFAULT_CAPACITY = 101;
    private int[] elementData;
    private int size;

    public SimpleIntHeep() {
        elementData = new int[DEFAULT_CAPACITY];
        size = 0;
    }

    /**
     * 1) add element to the end
     * 2) rebuild heap
     *
     * @param data
     */
    @Override
    public void add(int data) {
        if (size >= elementData.length) return;
        size++;
        elementData[size] = data;
//        buildHeap();
        int i = size;
        while (i / 2 > 0 && elementData[i / 2] < elementData[i]) {
            swap(i, i / 2);
            i /= 2;
        }
    }


    /**
     * @return
     */
    @Override
    public int removeTop() {
        if (size <= 0) return Integer.MIN_VALUE;
        swap(1, size);
        size--;
        buildHeap();
        return elementData[size + 1];
    }

    private void swap(int i, int j) {
        if (i == j) return;
        elementData[i] = elementData[i] + elementData[j];
        elementData[j] = elementData[i] - elementData[j];
        elementData[i] = elementData[i] - elementData[j];
    }


    private void buildHeap() {
        for (int i = size / 2; i >= 1; i--) {
            while (true) {
                int maxPos = i;
                if (i * 2 <= size && elementData[maxPos] < elementData[i * 2]) maxPos = i * 2;
                if (i * 2 + 1 <= size && elementData[maxPos] < elementData[i * 2 + 1]) maxPos = i * 2 + 1;
                if (maxPos == i) break;
                swap(i, maxPos);
                i = maxPos;
            }
        }
    }
}
