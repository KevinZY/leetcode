package com.zhangyang.leetcode.queue;

import com.zhangyang.leetcode.linkedlist.po.ListNode;

/**
 * Created by zhangyang on 2018/10/24.
 */
public class LinkedListQueue {
    private ListNode head = new ListNode(233);
    private ListNode tail = head;

    public boolean offer(int data) {
        ListNode newNode = new ListNode(data);
        tail.next = newNode;
        tail = newNode;
        return true;
    }

    public Integer peek() {
        if (head == tail) return null;
        return head.next.val;
    }

    public Integer poll() {
        if (head.next == tail) {
            int val = tail.val;
            tail = head;
            head.next = null;
            return val;
        } else if (head == tail) {
            return null;
        }

        int val = head.next.val;
        head.next = head.next.next;
        return val;
    }
}
