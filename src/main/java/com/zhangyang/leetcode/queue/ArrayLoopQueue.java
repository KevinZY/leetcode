package com.zhangyang.leetcode.queue;

/**
 * Created by zhangyang on 2018/10/24.
 * LoopQueue base on Array
 */
public class ArrayLoopQueue {
    private int head = 0;
    private int tail = 0;
    private int[] array;
    private static final int ARRAY_SIZE = 5;

    public ArrayLoopQueue() {
        array = new int[ARRAY_SIZE];
    }

    public boolean offer(int data) {
        if (modIncreament(tail) == head)
            return false;
        array[tail] = data;
        tail = modIncreament(tail);
        return true;
    }

    public Integer poll() {
        if (head == tail)
            return null;
        int result = array[head];
        head = modIncreament(head);
        return result;
    }

    public Integer peek() {
        if (head == tail)
            return null;
        return array[head];
    }

    private int modIncreament(int pointer) {
        return (pointer + 1) % ARRAY_SIZE;
    }
}
