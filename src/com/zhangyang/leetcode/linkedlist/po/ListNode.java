package com.zhangyang.leetcode.linkedlist.po;


/**
 * Created by yzhang on 2018/10/17.
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        this(x, null);
    }

    public ListNode(int x, ListNode next){
        val = x;
        this.next = next;
    }
}
