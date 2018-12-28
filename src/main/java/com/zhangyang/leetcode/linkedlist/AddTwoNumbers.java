package com.zhangyang.leetcode.linkedlist;

import com.zhangyang.leetcode.linkedlist.po.ListNode;

/**
 * Created by zhangyang on 2018/12/16.
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(-1);
        ListNode p = result;
        int carry = 0;
        while (l1 != null && l2 != null) {
            int x = l1.val + l2.val + carry;
            carry = x / 10;
            p.next = new ListNode(x % 10);
            p = p.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        ListNode start = l1;
        if (l2 != null) start = l2;
        while (start != null) {
            int x = start.val + carry;
            carry = x / 10;
            p.next = new ListNode(x % 10);
            p = p.next;
            start = start.next;
        }
        if (carry != 0) p.next = new ListNode(carry);
        return result.next;
    }
}
