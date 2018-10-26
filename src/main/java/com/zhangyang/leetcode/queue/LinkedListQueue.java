package com.zhangyang.leetcode.queue;

import com.zhangyang.leetcode.linkedlist.po.ListNode;

/**
 * Created by zhangyang on 2018/10/24.
 */
public class LinkedListQueue {
    private ListNode guard = new ListNode(233);
    private ListNode tail = guard;

    public boolean offer(int data) {
        ListNode newNode = new ListNode(data);
        tail.next = newNode;
        tail = newNode;
        return true;
    }

    public Integer peek() {
        if (guard == tail) return null;
        return guard.next.val;
    }

    public Integer poll() {
        if (guard.next == tail) {
            int val = tail.val;
            tail = guard;
            guard.next = null;
            return val;
        } else if (guard == tail) {
            return null;
        }

        int val = guard.next.val;
        guard.next = guard.next.next;
        return val;
    }
}
