package com.zhangyang.leetcode.linkedlist.po;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by yzhang on 2018/10/17.
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        this(x, null);
    }

    public ListNode(int x, ListNode next) {
        val = x;
        this.next = next;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        List<Integer> values = new ArrayList<>();

        public Builder add(int i) {
            values.add(i);
            return this;
        }

        public ListNode build() {
            ListNode head = new ListNode(-1);
            ListNode p = head;
            for (Integer value : values) {
                p.next = new ListNode(value);
                p = p.next;
            }
            return head.next;
        }
    }
}
